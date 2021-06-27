// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: gps.proto

package com.base.pj;

public final class Gps {
  private Gps() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface gps_dataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:gps_data)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 id = 1;</code>
     * @return The id.
     */
    long getId();

    /**
     * <code>string terminalId = 2;</code>
     * @return The terminalId.
     */
    java.lang.String getTerminalId();
    /**
     * <code>string terminalId = 2;</code>
     * @return The bytes for terminalId.
     */
    com.google.protobuf.ByteString
        getTerminalIdBytes();

    /**
     * <code>string dataTime = 3;</code>
     * @return The dataTime.
     */
    java.lang.String getDataTime();
    /**
     * <code>string dataTime = 3;</code>
     * @return The bytes for dataTime.
     */
    com.google.protobuf.ByteString
        getDataTimeBytes();

    /**
     * <code>double lon = 4;</code>
     * @return The lon.
     */
    double getLon();

    /**
     * <code>float speed = 6;</code>
     * @return The speed.
     */
    float getSpeed();

    /**
     * <code>int32 gpsStatus = 9;</code>
     * @return The gpsStatus.
     */
    int getGpsStatus();
  }
  /**
   * Protobuf type {@code gps_data}
   */
  public  static final class gps_data extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:gps_data)
      gps_dataOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use gps_data.newBuilder() to construct.
    private gps_data(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private gps_data() {
      terminalId_ = "";
      dataTime_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new gps_data();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private gps_data(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
            case 8: {

              id_ = input.readInt64();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              terminalId_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              dataTime_ = s;
              break;
            }
            case 33: {

              lon_ = input.readDouble();
              break;
            }
            case 53: {

              speed_ = input.readFloat();
              break;
            }
            case 72: {

              gpsStatus_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.base.pj.Gps.internal_static_gps_data_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.base.pj.Gps.internal_static_gps_data_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.base.pj.Gps.gps_data.class, com.base.pj.Gps.gps_data.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private long id_;
    /**
     * <code>int64 id = 1;</code>
     * @return The id.
     */
    public long getId() {
      return id_;
    }

    public static final int TERMINALID_FIELD_NUMBER = 2;
    private volatile java.lang.Object terminalId_;
    /**
     * <code>string terminalId = 2;</code>
     * @return The terminalId.
     */
    public java.lang.String getTerminalId() {
      java.lang.Object ref = terminalId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        terminalId_ = s;
        return s;
      }
    }
    /**
     * <code>string terminalId = 2;</code>
     * @return The bytes for terminalId.
     */
    public com.google.protobuf.ByteString
        getTerminalIdBytes() {
      java.lang.Object ref = terminalId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        terminalId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DATATIME_FIELD_NUMBER = 3;
    private volatile java.lang.Object dataTime_;
    /**
     * <code>string dataTime = 3;</code>
     * @return The dataTime.
     */
    public java.lang.String getDataTime() {
      java.lang.Object ref = dataTime_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dataTime_ = s;
        return s;
      }
    }
    /**
     * <code>string dataTime = 3;</code>
     * @return The bytes for dataTime.
     */
    public com.google.protobuf.ByteString
        getDataTimeBytes() {
      java.lang.Object ref = dataTime_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dataTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LON_FIELD_NUMBER = 4;
    private double lon_;
    /**
     * <code>double lon = 4;</code>
     * @return The lon.
     */
    public double getLon() {
      return lon_;
    }

    public static final int SPEED_FIELD_NUMBER = 6;
    private float speed_;
    /**
     * <code>float speed = 6;</code>
     * @return The speed.
     */
    public float getSpeed() {
      return speed_;
    }

    public static final int GPSSTATUS_FIELD_NUMBER = 9;
    private int gpsStatus_;
    /**
     * <code>int32 gpsStatus = 9;</code>
     * @return The gpsStatus.
     */
    public int getGpsStatus() {
      return gpsStatus_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (id_ != 0L) {
        output.writeInt64(1, id_);
      }
      if (!getTerminalIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, terminalId_);
      }
      if (!getDataTimeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, dataTime_);
      }
      if (lon_ != 0D) {
        output.writeDouble(4, lon_);
      }
      if (speed_ != 0F) {
        output.writeFloat(6, speed_);
      }
      if (gpsStatus_ != 0) {
        output.writeInt32(9, gpsStatus_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, id_);
      }
      if (!getTerminalIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, terminalId_);
      }
      if (!getDataTimeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, dataTime_);
      }
      if (lon_ != 0D) {
        size += com.google.protobuf.CodedOutputStream
          .computeDoubleSize(4, lon_);
      }
      if (speed_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(6, speed_);
      }
      if (gpsStatus_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(9, gpsStatus_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.base.pj.Gps.gps_data)) {
        return super.equals(obj);
      }
      com.base.pj.Gps.gps_data other = (com.base.pj.Gps.gps_data) obj;

      if (getId()
          != other.getId()) return false;
      if (!getTerminalId()
          .equals(other.getTerminalId())) return false;
      if (!getDataTime()
          .equals(other.getDataTime())) return false;
      if (java.lang.Double.doubleToLongBits(getLon())
          != java.lang.Double.doubleToLongBits(
              other.getLon())) return false;
      if (java.lang.Float.floatToIntBits(getSpeed())
          != java.lang.Float.floatToIntBits(
              other.getSpeed())) return false;
      if (getGpsStatus()
          != other.getGpsStatus()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getId());
      hash = (37 * hash) + TERMINALID_FIELD_NUMBER;
      hash = (53 * hash) + getTerminalId().hashCode();
      hash = (37 * hash) + DATATIME_FIELD_NUMBER;
      hash = (53 * hash) + getDataTime().hashCode();
      hash = (37 * hash) + LON_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          java.lang.Double.doubleToLongBits(getLon()));
      hash = (37 * hash) + SPEED_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getSpeed());
      hash = (37 * hash) + GPSSTATUS_FIELD_NUMBER;
      hash = (53 * hash) + getGpsStatus();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.base.pj.Gps.gps_data parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.base.pj.Gps.gps_data parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.base.pj.Gps.gps_data parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.base.pj.Gps.gps_data parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.base.pj.Gps.gps_data parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.base.pj.Gps.gps_data parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.base.pj.Gps.gps_data parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.base.pj.Gps.gps_data parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.base.pj.Gps.gps_data parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.base.pj.Gps.gps_data parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.base.pj.Gps.gps_data parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.base.pj.Gps.gps_data parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.base.pj.Gps.gps_data prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code gps_data}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:gps_data)
        com.base.pj.Gps.gps_dataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.base.pj.Gps.internal_static_gps_data_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.base.pj.Gps.internal_static_gps_data_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.base.pj.Gps.gps_data.class, com.base.pj.Gps.gps_data.Builder.class);
      }

      // Construct using com.base.pj.Gps.gps_data.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        id_ = 0L;

        terminalId_ = "";

        dataTime_ = "";

        lon_ = 0D;

        speed_ = 0F;

        gpsStatus_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.base.pj.Gps.internal_static_gps_data_descriptor;
      }

      @java.lang.Override
      public com.base.pj.Gps.gps_data getDefaultInstanceForType() {
        return com.base.pj.Gps.gps_data.getDefaultInstance();
      }

      @java.lang.Override
      public com.base.pj.Gps.gps_data build() {
        com.base.pj.Gps.gps_data result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.base.pj.Gps.gps_data buildPartial() {
        com.base.pj.Gps.gps_data result = new com.base.pj.Gps.gps_data(this);
        result.id_ = id_;
        result.terminalId_ = terminalId_;
        result.dataTime_ = dataTime_;
        result.lon_ = lon_;
        result.speed_ = speed_;
        result.gpsStatus_ = gpsStatus_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.base.pj.Gps.gps_data) {
          return mergeFrom((com.base.pj.Gps.gps_data)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.base.pj.Gps.gps_data other) {
        if (other == com.base.pj.Gps.gps_data.getDefaultInstance()) return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getTerminalId().isEmpty()) {
          terminalId_ = other.terminalId_;
          onChanged();
        }
        if (!other.getDataTime().isEmpty()) {
          dataTime_ = other.dataTime_;
          onChanged();
        }
        if (other.getLon() != 0D) {
          setLon(other.getLon());
        }
        if (other.getSpeed() != 0F) {
          setSpeed(other.getSpeed());
        }
        if (other.getGpsStatus() != 0) {
          setGpsStatus(other.getGpsStatus());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.base.pj.Gps.gps_data parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.base.pj.Gps.gps_data) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long id_ ;
      /**
       * <code>int64 id = 1;</code>
       * @return The id.
       */
      public long getId() {
        return id_;
      }
      /**
       * <code>int64 id = 1;</code>
       * @param value The id to set.
       * @return This builder for chaining.
       */
      public Builder setId(long value) {
        
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 id = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearId() {
        
        id_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object terminalId_ = "";
      /**
       * <code>string terminalId = 2;</code>
       * @return The terminalId.
       */
      public java.lang.String getTerminalId() {
        java.lang.Object ref = terminalId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          terminalId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string terminalId = 2;</code>
       * @return The bytes for terminalId.
       */
      public com.google.protobuf.ByteString
          getTerminalIdBytes() {
        java.lang.Object ref = terminalId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          terminalId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string terminalId = 2;</code>
       * @param value The terminalId to set.
       * @return This builder for chaining.
       */
      public Builder setTerminalId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        terminalId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string terminalId = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearTerminalId() {
        
        terminalId_ = getDefaultInstance().getTerminalId();
        onChanged();
        return this;
      }
      /**
       * <code>string terminalId = 2;</code>
       * @param value The bytes for terminalId to set.
       * @return This builder for chaining.
       */
      public Builder setTerminalIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        terminalId_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object dataTime_ = "";
      /**
       * <code>string dataTime = 3;</code>
       * @return The dataTime.
       */
      public java.lang.String getDataTime() {
        java.lang.Object ref = dataTime_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          dataTime_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string dataTime = 3;</code>
       * @return The bytes for dataTime.
       */
      public com.google.protobuf.ByteString
          getDataTimeBytes() {
        java.lang.Object ref = dataTime_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          dataTime_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string dataTime = 3;</code>
       * @param value The dataTime to set.
       * @return This builder for chaining.
       */
      public Builder setDataTime(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        dataTime_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string dataTime = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearDataTime() {
        
        dataTime_ = getDefaultInstance().getDataTime();
        onChanged();
        return this;
      }
      /**
       * <code>string dataTime = 3;</code>
       * @param value The bytes for dataTime to set.
       * @return This builder for chaining.
       */
      public Builder setDataTimeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        dataTime_ = value;
        onChanged();
        return this;
      }

      private double lon_ ;
      /**
       * <code>double lon = 4;</code>
       * @return The lon.
       */
      public double getLon() {
        return lon_;
      }
      /**
       * <code>double lon = 4;</code>
       * @param value The lon to set.
       * @return This builder for chaining.
       */
      public Builder setLon(double value) {
        
        lon_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double lon = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearLon() {
        
        lon_ = 0D;
        onChanged();
        return this;
      }

      private float speed_ ;
      /**
       * <code>float speed = 6;</code>
       * @return The speed.
       */
      public float getSpeed() {
        return speed_;
      }
      /**
       * <code>float speed = 6;</code>
       * @param value The speed to set.
       * @return This builder for chaining.
       */
      public Builder setSpeed(float value) {
        
        speed_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>float speed = 6;</code>
       * @return This builder for chaining.
       */
      public Builder clearSpeed() {
        
        speed_ = 0F;
        onChanged();
        return this;
      }

      private int gpsStatus_ ;
      /**
       * <code>int32 gpsStatus = 9;</code>
       * @return The gpsStatus.
       */
      public int getGpsStatus() {
        return gpsStatus_;
      }
      /**
       * <code>int32 gpsStatus = 9;</code>
       * @param value The gpsStatus to set.
       * @return This builder for chaining.
       */
      public Builder setGpsStatus(int value) {
        
        gpsStatus_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 gpsStatus = 9;</code>
       * @return This builder for chaining.
       */
      public Builder clearGpsStatus() {
        
        gpsStatus_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:gps_data)
    }

    // @@protoc_insertion_point(class_scope:gps_data)
    private static final com.base.pj.Gps.gps_data DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.base.pj.Gps.gps_data();
    }

    public static com.base.pj.Gps.gps_data getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<gps_data>
        PARSER = new com.google.protobuf.AbstractParser<gps_data>() {
      @java.lang.Override
      public gps_data parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new gps_data(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<gps_data> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<gps_data> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.base.pj.Gps.gps_data getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_gps_data_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_gps_data_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tgps.proto\"k\n\010gps_data\022\n\n\002id\030\001 \001(\003\022\022\n\nt" +
      "erminalId\030\002 \001(\t\022\020\n\010dataTime\030\003 \001(\t\022\013\n\003lon" +
      "\030\004 \001(\001\022\r\n\005speed\030\006 \001(\002\022\021\n\tgpsStatus\030\t \001(\005" +
      "B\r\n\013com.base.pjb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_gps_data_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_gps_data_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_gps_data_descriptor,
        new java.lang.String[] { "Id", "TerminalId", "DataTime", "Lon", "Speed", "GpsStatus", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
