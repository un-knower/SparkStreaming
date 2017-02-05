package com.sxp.task.bolt.db2.news.builder;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.hsae.rdbms.db2.DB2ConnectionPool;
import com.sxp.task.protobuf.generated.Gb2012;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CopyOfBuildDB2BoltUtil {
	private static final Logger LOG = LoggerFactory.getLogger(CopyOfBuildDB2BoltUtil.class);
	static String path = "D:\\EclipseWorkspace\\EclipseWorkspace4Hadoop2\\tsp-storm\\src\\main\\java\\com\\hsae\\storm\\bolt\\db2\\news\\";
	static String packageName = "com.hsae.storm.bolt.db2.news";
	static DatabaseMetaData metaData = null;
	static {
		try {
			metaData = DB2ConnectionPool.getInstance().getConnection().getMetaData();
		} catch (SQLException e) {
			LOG.error("init connection error", e);
		}
	}

	public static void main(String[] args) {
		FileDescriptor descriptor = Gb2012.getDescriptor();
		String tableName = "T_GBSPEEDSTATEDETAIL";
		try {
			buildDB2BoltJavaSource(descriptor, tableName);
		} catch (Exception e) {
			LOG.error("build DB2Bolt Java Source error", e);
		}
	}

	public static void buildDB2BoltJavaSource(FileDescriptor descriptor, String tableName) throws Exception {
		String pbClassName = descriptor.getOptions().getJavaOuterClassname();// GpsInfo
		String pbPackageName = descriptor.getOptions().getJavaPackage();// com.hsae.storm.proto
		Descriptor pbFirstClass = descriptor.getMessageTypes().get(26);
		String pbSubClassName = pbFirstClass.getFullName();// Gps
		String pbSubClassNameLower = pbSubClassName.toLowerCase();// gps
		String className = pbSubClassName + "DB2Bolt";
		List<FieldDescriptor> fields = pbFirstClass.getFields();
		ResultSet colRet = metaData.getColumns(null, "DB2INST1", tableName, "%");
		List<String[]> columnss = new ArrayList<String[]>();
		while (colRet.next()) {
			String columnName = colRet.getString("COLUMN_NAME");
			String columnType = colRet.getString("TYPE_NAME");
			int datasize = colRet.getInt("COLUMN_SIZE");
			// int digits = colRet.getInt("DECIMAL_DIGITS");
			// int nullable = colRet.getInt("NULLABLE");
			columnss.add(new String[] { columnName, columnType, datasize + "" });
		}
		if (columnss.size() != fields.size()) {
			// throw new Exception("sql pb is not same");
		}
		StringBuilder sb = new StringBuilder();
		// head
		sb.append("package " + packageName + ";" + "\n" + //
				"import java.sql.Types;" + "\n" + //
				"import java.util.ArrayList;" + "\n" + //
				"import java.util.HashMap;" + "\n" + //
				"import java.util.List;" + "\n" + //
				"import java.util.Map;" + "\n\n" + //
				"import org.slf4j.Logger;" + "\n" + //
				"import org.slf4j.LoggerFactory;" + "\n\n" + //
				"import com.google.protobuf.InvalidProtocolBufferException;" + "\n" + //
				"import com.hsae.storm.db2.Column;" + "\n" + //
				"import com.hsae.storm.db2.DB2Utils;" + "\n" + //
				"import com.hsae.storm.db2.PreparedSqlAndValues;" + "\n" + //
				"import " + pbPackageName + "." + pbClassName + "." + pbSubClassName + ";\n\n");//
		// fields
		sb.append("public class " + className + " extends AbstractDB2Bolt {" + "\n\n" + //
				"private static final Logger LOG = LoggerFactory.getLogger(" + className + ".class);" + "\n" + //
				"static String TABLE_NAME = \"").append(tableName).append("\";\n");//

		// COLUMNS
		sb.append("public static Column[] COLUMNS = new Column[] {");
		for (int i = 0; i < columnss.size(); i++) {
			String[] c = columnss.get(i);
			if (i < columnss.size() - 1) {
				if (needScaleOrLength(c[1], c[2])) {
					sb.append("new Column(\"" + c[0] + "\", Types." + c[1] + ", " + c[2] + "),// " + (i + 1));
				} else {
					sb.append("new Column(\"" + c[0] + "\", Types." + c[1] + "),// " + (i + 1));
				}
				sb.append("\n");
			} else {
				if (needScaleOrLength(c[1], c[2])) {
					sb.append("new Column(\"" + c[0] + "\", Types." + c[1] + ", " + c[2] + ")// " + (i + 1) + "\n};\n");
				} else {
					sb.append("new Column(\"" + c[0] + "\", Types." + c[1] + ")// " + (i + 1) + "\n};\n");
				}
			}
		}

		sb.append("public static final String INSERT_PREPARED_SQL = DB2Utils.buildInsertPreparedSql(TABLE_NAME, COLUMNS);\n");
		// function buildPreparedSqlAndValuesList
		sb.append("@Override" + "\n" + //
				"protected List<PreparedSqlAndValues> buildPreparedSqlAndValuesList(List<byte[]> " + pbSubClassNameLower + "List) throws InvalidProtocolBufferException {" + "\n" + //
				"List<Map<Integer, Object>> s = new ArrayList<Map<Integer, Object>>();" + "\n" + //
				"for (int i = 0, size = " + pbSubClassNameLower + "List.size(); i < size; i++) {" + "\n" + //
				"try {" + "\n" + //
				"" + pbSubClassName + " " + pbSubClassNameLower + " = " + pbSubClassName + ".parseFrom(" + pbSubClassNameLower + "List.get(i));" + "\n" + //
				"s.add(buildSqlObjectListFrom" + pbSubClassName + "(" + pbSubClassNameLower + "));" + "\n" + //
				"} catch (InvalidProtocolBufferException e) {" + "\n" + //
				"LOG.error(\"Protobuf parse " + pbSubClassName + " error\", e);" + "\n" + //
				"}" + "\n" + //
				"}" + "\n" + //
				"List<PreparedSqlAndValues> preparedSqlAndValuesList = new ArrayList<PreparedSqlAndValues>();" + "\n" + //
				"preparedSqlAndValuesList.add(new PreparedSqlAndValues(INSERT_PREPARED_SQL, COLUMNS, s));" + "\n" + //
				"return preparedSqlAndValuesList;" + "\n" + //
				"}" + "\n");
		// function buildSqlObjectListFromGps
		sb.append("	private static Map<Integer, Object> buildSqlObjectListFrom" + pbSubClassName + "(" + pbSubClassName + " " + pbSubClassNameLower + ") {" + "\n" + //
				"Map<Integer, Object> m = new HashMap<Integer, Object>();");
		for (int i = 0; i < fields.size(); i++) {
			FieldDescriptor field = fields.get(i);
			if (!field.isOptional()) {
				if (field.getType().name().equals("BOOL")) {
					sb.append("m.put(" + field.getNumber() + ", " + pbSubClassNameLower + ".get" + field.getName() + "() ? 1 : 0);");
				} else if (columnss.get(i)[1].equals("TIMESTAMP")) {
					sb.append("m.put(" + field.getNumber() + ", new java.sql.Date(" + pbSubClassNameLower + ".get" + field.getName() + "()));");
				} else {
					sb.append("m.put(" + field.getNumber() + ", " + pbSubClassNameLower + ".get" + field.getName() + "());");
				}
			} else {
				if (field.getType().name().equals("BOOL")) {
					sb.append("m.put(" + field.getNumber() + ", " + pbSubClassNameLower + ".has" + field.getName() + "() ? " + pbSubClassNameLower + ".get" + field.getName()
							+ "() ? 1 : 0 : null);");
				} else if (columnss.get(i)[1].equals("TIMESTAMP")) {
					sb.append("m.put(" + field.getNumber() + ", " + pbSubClassNameLower + ".has" + field.getName() + "() ? new java.sql.Date(" + pbSubClassNameLower + ".get"
							+ field.getName() + "()) : null);");
				} else {
					sb.append("m.put(" + field.getNumber() + ", " + pbSubClassNameLower + ".has" + field.getName() + "() ? " + pbSubClassNameLower + ".get" + field.getName()
							+ "() : null);");
				}
			}
			sb.append("\n");
		}
		sb.append("return m;\n}\n}");
		write(path + className + ".java", sb.toString());
		LOG.info("writed java source to " + path + className + ".java");
	}

	private static boolean needScaleOrLength(String type, String size) {
		int s = Integer.parseInt(size);
		if ((type.equals("TINYINT") && s < 3) || //
				(type.equals("SMALLINT") && s < 5) || //
				(type.equals("INTEGER") && s < 10) || //
				(type.equals("BIGINT") && s < 19) || //
				(type.equals("FLOAT") && s < 16) || //
				(type.equals("DOUBLE") && s < 53) || //
				(type.equals("CHAR")) || //
				(type.equals("VARCHAR")) || //
				(type.equals("LONGVARCHAR")) || //
				(type.equals("BINARY")) || //
				(type.equals("VARBINARY")) || //
				(type.equals("LONGVARBINARY"))) {
			return true;
		}
		return false;
	}

	private static void write(String file, String content) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static int sqlType(String ss) {
		int i = Types.NULL;
		switch (ss) {
		case "BIT":
			i = Types.BIT;
			break;
		case "TINYINT":
			i = Types.TINYINT;
			break;
		case "SMALLINT":
			i = Types.SMALLINT;
			break;
		case "INTEGER":
			i = Types.INTEGER;
			break;
		case "BIGINT":
			i = Types.BIGINT;
			break;
		case "FLOAT":
			i = Types.FLOAT;
			break;
		case "REAL":
			i = Types.REAL;
			break;
		case "DOUBLE":
			i = Types.DOUBLE;
			break;
		case "NUMERIC":
			i = Types.NUMERIC;
			break;
		case "DECIMAL":
			i = Types.DECIMAL;
			break;
		case "CHAR":
			i = Types.CHAR;
			break;
		case "VARCHAR":
			i = Types.VARCHAR;
			break;
		case "LONGVARCHAR":
			i = Types.LONGVARCHAR;
			break;
		case "DATE":
			i = Types.DATE;
			break;
		case "TIME":
			i = Types.TIME;
			break;
		case "TIMESTAMP":
			i = Types.TIMESTAMP;
			break;
		case "BINARY":
			i = Types.BINARY;
			break;
		case "VARBINARY":
			i = Types.VARBINARY;
			break;
		case "LONGVARBINARY":
			i = Types.LONGVARBINARY;
			break;
		case "NULL":
			i = Types.NULL;
			break;
		case "OTHER":
			i = Types.OTHER;
			break;
		case "JAVA_OBJECT":
			i = Types.JAVA_OBJECT;
			break;
		case "DISTINCT":
			i = Types.DISTINCT;
			break;
		case "STRUCT":
			i = Types.STRUCT;
			break;
		case "ARRAY":
			i = Types.ARRAY;
			break;
		case "BLOB":
			i = Types.BLOB;
			break;
		case "CLOB":
			i = Types.CLOB;
			break;
		case "REF":
			i = Types.REF;
			break;
		case "DATALINK":
			i = Types.DATALINK;
			break;
		case "BOOLEAN":
			i = Types.BOOLEAN;
			break;
		case "ROWID":
			i = Types.ROWID;
			break;
		default:
			break;
		}
		return i;
	}
}
