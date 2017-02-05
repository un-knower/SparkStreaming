// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/Test10060.proto

package com.sxp.task.protobuf.generated;

public final class TestStorm {
  private TestStorm() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface TestOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Test)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int64 TestCol1 = 1;</code>
     */
    boolean hasTestCol1();
    /**
     * <code>required int64 TestCol1 = 1;</code>
     */
    long getTestCol1();

    /**
     * <code>required string TestCol2 = 2;</code>
     */
    boolean hasTestCol2();
    /**
     * <code>required string TestCol2 = 2;</code>
     */
    java.lang.String getTestCol2();
    /**
     * <code>required string TestCol2 = 2;</code>
     */
    com.google.protobuf.ByteString
        getTestCol2Bytes();
  }
  /**
   * Protobuf type {@code Test}
   */
  public static final class Test extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:Test)
      TestOrBuilder {
    // Use Test.newBuilder() to construct.
    private Test(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Test(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Test defaultInstance;
    public static Test getDefaultInstance() {
      return defaultInstance;
    }

    public Test getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Test(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              testCol1_ = input.readInt64();
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              testCol2_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return TestStorm.internal_static_Test_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return TestStorm.internal_static_Test_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              TestStorm.Test.class, TestStorm.Test.Builder.class);
    }

    public static com.google.protobuf.Parser<Test> PARSER =
        new com.google.protobuf.AbstractParser<Test>() {
      public Test parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Test(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Test> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int TESTCOL1_FIELD_NUMBER = 1;
    private long testCol1_;
    /**
     * <code>required int64 TestCol1 = 1;</code>
     */
    public boolean hasTestCol1() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int64 TestCol1 = 1;</code>
     */
    public long getTestCol1() {
      return testCol1_;
    }

    public static final int TESTCOL2_FIELD_NUMBER = 2;
    private java.lang.Object testCol2_;
    /**
     * <code>required string TestCol2 = 2;</code>
     */
    public boolean hasTestCol2() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string TestCol2 = 2;</code>
     */
    public java.lang.String getTestCol2() {
      java.lang.Object ref = testCol2_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          testCol2_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string TestCol2 = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTestCol2Bytes() {
      java.lang.Object ref = testCol2_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        testCol2_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      testCol1_ = 0L;
      testCol2_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasTestCol1()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasTestCol2()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt64(1, testCol1_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getTestCol2Bytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, testCol1_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getTestCol2Bytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static TestStorm.Test parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static TestStorm.Test parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static TestStorm.Test parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static TestStorm.Test parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static TestStorm.Test parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static TestStorm.Test parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static TestStorm.Test parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static TestStorm.Test parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static TestStorm.Test parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static TestStorm.Test parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(TestStorm.Test prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Test}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Test)
        TestStorm.TestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return TestStorm.internal_static_Test_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return TestStorm.internal_static_Test_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                TestStorm.Test.class, TestStorm.Test.Builder.class);
      }

      // Construct using TestStorm.Test.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        testCol1_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        testCol2_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return TestStorm.internal_static_Test_descriptor;
      }

      public TestStorm.Test getDefaultInstanceForType() {
        return TestStorm.Test.getDefaultInstance();
      }

      public TestStorm.Test build() {
        TestStorm.Test result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public TestStorm.Test buildPartial() {
        TestStorm.Test result = new TestStorm.Test(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.testCol1_ = testCol1_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.testCol2_ = testCol2_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof TestStorm.Test) {
          return mergeFrom((TestStorm.Test)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(TestStorm.Test other) {
        if (other == TestStorm.Test.getDefaultInstance()) return this;
        if (other.hasTestCol1()) {
          setTestCol1(other.getTestCol1());
        }
        if (other.hasTestCol2()) {
          bitField0_ |= 0x00000002;
          testCol2_ = other.testCol2_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasTestCol1()) {
          
          return false;
        }
        if (!hasTestCol2()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        TestStorm.Test parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (TestStorm.Test) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private long testCol1_ ;
      /**
       * <code>required int64 TestCol1 = 1;</code>
       */
      public boolean hasTestCol1() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int64 TestCol1 = 1;</code>
       */
      public long getTestCol1() {
        return testCol1_;
      }
      /**
       * <code>required int64 TestCol1 = 1;</code>
       */
      public Builder setTestCol1(long value) {
        bitField0_ |= 0x00000001;
        testCol1_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 TestCol1 = 1;</code>
       */
      public Builder clearTestCol1() {
        bitField0_ = (bitField0_ & ~0x00000001);
        testCol1_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object testCol2_ = "";
      /**
       * <code>required string TestCol2 = 2;</code>
       */
      public boolean hasTestCol2() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string TestCol2 = 2;</code>
       */
      public java.lang.String getTestCol2() {
        java.lang.Object ref = testCol2_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            testCol2_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string TestCol2 = 2;</code>
       */
      public com.google.protobuf.ByteString
          getTestCol2Bytes() {
        java.lang.Object ref = testCol2_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          testCol2_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string TestCol2 = 2;</code>
       */
      public Builder setTestCol2(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        testCol2_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string TestCol2 = 2;</code>
       */
      public Builder clearTestCol2() {
        bitField0_ = (bitField0_ & ~0x00000002);
        testCol2_ = getDefaultInstance().getTestCol2();
        onChanged();
        return this;
      }
      /**
       * <code>required string TestCol2 = 2;</code>
       */
      public Builder setTestCol2Bytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        testCol2_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Test)
    }

    static {
      defaultInstance = new Test(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Test)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Test_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Test_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\036src/main/proto/Test10060.proto\"*\n\004Test" +
      "\022\020\n\010TestCol1\030\001 \002(\003\022\020\n\010TestCol2\030\002 \002(\tB.\n!" +
      "com.hsae.task.protobuf.generatedB\tTestS" +
      "torm"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Test_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Test_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_Test_descriptor,
        new java.lang.String[] { "TestCol1", "TestCol2", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
