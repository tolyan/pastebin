package info.archinnov.achilles.generated.meta.entity;

import com.datastax.driver.core.ClusteringOrder;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.DataType;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.reflect.TypeToken;
import info.archinnov.achilles.generated.function.Boolean_Type;
import info.archinnov.achilles.generated.function.Date_Type;
import info.archinnov.achilles.generated.function.UUID_Type;
import info.archinnov.achilles.internals.apt.annotations.AchillesMeta;
import info.archinnov.achilles.internals.codec.FallThroughCodec;
import info.archinnov.achilles.internals.metamodel.AbstractEntityProperty;
import info.archinnov.achilles.internals.metamodel.AbstractProperty;
import info.archinnov.achilles.internals.metamodel.SimpleProperty;
import info.archinnov.achilles.internals.metamodel.columns.ClusteringColumnInfo;
import info.archinnov.achilles.internals.metamodel.columns.ColumnInfo;
import info.archinnov.achilles.internals.metamodel.columns.ColumnType;
import info.archinnov.achilles.internals.metamodel.columns.FieldInfo;
import info.archinnov.achilles.internals.metamodel.columns.PartitionKeyInfo;
import info.archinnov.achilles.internals.metamodel.index.IndexInfo;
import info.archinnov.achilles.internals.strategy.naming.InternalNamingStrategy;
import info.archinnov.achilles.type.strategy.InsertStrategy;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ru.anglerhood.pastebin.Entry;

/**
 * Meta class of all entities of type Entry<br/>
 * The meta class is responsible for<br/>
 * <ul>
 *    <li>determining runtime consistency levels (read/write,serial)<li/>
 *    <li>determining runtime insert strategy<li/>
 *    <li>trigger event interceptors (if any)<li/>
 *    <li>map a com.datastax.driver.core.Row back to an instance of Entry<li/>
 *    <li>determine runtime keyspace name using static annotations and runtime SchemaNameProvider (if any)<li/>
 *    <li>determine runtime table name using static annotations and runtime SchemaNameProvider (if any)<li/>
 *    <li>generate schema during bootstrap<li/>
 *    <li>validate schema during bootstrap<li/>
 *    <li>expose all property meta classes for encoding/decoding purpose on unitary columns<li/>
 * <ul/>
 */
@AchillesMeta
public final class Entry_AchillesMeta extends AbstractEntityProperty<Entry> {
  /**
   * Meta class for 'isPrivate' property <br/>
   * The meta class exposes some useful methods: <ul>
   *    <li>encodeFromJava: encode a property from raw Java to CQL java compatible type </li>
   *    <li>encodeField: extract the current property value from the given Entry instance and encode to CQL java compatible type </li>
   *    <li>decodeFromGettable: decode from a {@link com.datastax.driver.core.GettableData} instance (Row, UDTValue, TupleValue) the current property</li>
   * </ul>
   */
  @SuppressWarnings({"serial", "unchecked"})
  public static final SimpleProperty<Entry, Boolean, Boolean> isPrivate = new SimpleProperty<Entry, Boolean, Boolean>(new FieldInfo<>((Entry entity$) -> entity$.getIsPrivate(), (Entry entity$, Boolean value$) -> entity$.setIsPrivate(value$), "isPrivate", "is_private", ColumnType.PARTITION, new PartitionKeyInfo(1, false), IndexInfo.noIndex()), DataType.cboolean(), gettableData$ -> gettableData$.get("is_private", java.lang.Boolean.class), (settableData$, value$) -> settableData$.set("is_private", value$, java.lang.Boolean.class), new TypeToken<Boolean>(){}, new TypeToken<Boolean>(){}, new FallThroughCodec<>(Boolean.class));

  /**
   * Meta class for 'createdAt' property <br/>
   * The meta class exposes some useful methods: <ul>
   *    <li>encodeFromJava: encode a property from raw Java to CQL java compatible type </li>
   *    <li>encodeField: extract the current property value from the given Entry instance and encode to CQL java compatible type </li>
   *    <li>decodeFromGettable: decode from a {@link com.datastax.driver.core.GettableData} instance (Row, UDTValue, TupleValue) the current property</li>
   * </ul>
   */
  @SuppressWarnings({"serial", "unchecked"})
  public static final SimpleProperty<Entry, Date, Date> createdAt = new SimpleProperty<Entry, Date, Date>(new FieldInfo<>((Entry entity$) -> entity$.getCreatedAt(), (Entry entity$, Date value$) -> entity$.setCreatedAt(value$), "createdAt", "created_at", ColumnType.CLUSTERING, new ClusteringColumnInfo(1, false, ClusteringOrder.ASC), IndexInfo.noIndex()), DataType.timestamp(), gettableData$ -> gettableData$.get("created_at", java.util.Date.class), (settableData$, value$) -> settableData$.set("created_at", value$, java.util.Date.class), new TypeToken<Date>(){}, new TypeToken<Date>(){}, new FallThroughCodec<>(Date.class));

  /**
   * Meta class for 'modifiedAt' property <br/>
   * The meta class exposes some useful methods: <ul>
   *    <li>encodeFromJava: encode a property from raw Java to CQL java compatible type </li>
   *    <li>encodeField: extract the current property value from the given Entry instance and encode to CQL java compatible type </li>
   *    <li>decodeFromGettable: decode from a {@link com.datastax.driver.core.GettableData} instance (Row, UDTValue, TupleValue) the current property</li>
   * </ul>
   */
  @SuppressWarnings({"serial", "unchecked"})
  public static final SimpleProperty<Entry, Date, Date> modifiedAt = new SimpleProperty<Entry, Date, Date>(new FieldInfo<>((Entry entity$) -> entity$.getModifiedAt(), (Entry entity$, Date value$) -> entity$.setModifiedAt(value$), "modifiedAt", "modified_at", ColumnType.NORMAL, new ColumnInfo(false), IndexInfo.noIndex()), DataType.timestamp(), gettableData$ -> gettableData$.get("modified_at", java.util.Date.class), (settableData$, value$) -> settableData$.set("modified_at", value$, java.util.Date.class), new TypeToken<Date>(){}, new TypeToken<Date>(){}, new FallThroughCodec<>(Date.class));

  /**
   * Meta class for 'expires' property <br/>
   * The meta class exposes some useful methods: <ul>
   *    <li>encodeFromJava: encode a property from raw Java to CQL java compatible type </li>
   *    <li>encodeField: extract the current property value from the given Entry instance and encode to CQL java compatible type </li>
   *    <li>decodeFromGettable: decode from a {@link com.datastax.driver.core.GettableData} instance (Row, UDTValue, TupleValue) the current property</li>
   * </ul>
   */
  @SuppressWarnings({"serial", "unchecked"})
  public static final SimpleProperty<Entry, Date, Date> expires = new SimpleProperty<Entry, Date, Date>(new FieldInfo<>((Entry entity$) -> entity$.getExpires(), (Entry entity$, Date value$) -> entity$.setExpires(value$), "expires", "expires_at", ColumnType.NORMAL, new ColumnInfo(false), IndexInfo.noIndex()), DataType.timestamp(), gettableData$ -> gettableData$.get("expires_at", java.util.Date.class), (settableData$, value$) -> settableData$.set("expires_at", value$, java.util.Date.class), new TypeToken<Date>(){}, new TypeToken<Date>(){}, new FallThroughCodec<>(Date.class));

  /**
   * Meta class for 'uuid' property <br/>
   * The meta class exposes some useful methods: <ul>
   *    <li>encodeFromJava: encode a property from raw Java to CQL java compatible type </li>
   *    <li>encodeField: extract the current property value from the given Entry instance and encode to CQL java compatible type </li>
   *    <li>decodeFromGettable: decode from a {@link com.datastax.driver.core.GettableData} instance (Row, UDTValue, TupleValue) the current property</li>
   * </ul>
   */
  @SuppressWarnings({"serial", "unchecked"})
  public static final SimpleProperty<Entry, UUID, UUID> uuid = new SimpleProperty<Entry, UUID, UUID>(new FieldInfo<>((Entry entity$) -> entity$.getUuid(), (Entry entity$, UUID value$) -> entity$.setUuid(value$), "uuid", "entry_uuid", ColumnType.NORMAL, new ColumnInfo(false), IndexInfo.noIndex()), DataType.uuid(), gettableData$ -> gettableData$.get("entry_uuid", java.util.UUID.class), (settableData$, value$) -> settableData$.set("entry_uuid", value$, java.util.UUID.class), new TypeToken<UUID>(){}, new TypeToken<UUID>(){}, new FallThroughCodec<>(UUID.class));

  /**
   * Static class to expose "Entry_AchillesMeta" fields for <strong>type-safe</strong> function calls */
  public static final Entry_AchillesMeta.ColumnsForFunctions COLUMNS = new Entry_AchillesMeta.ColumnsForFunctions();
  ;

  @Override
  protected Class<Entry> getEntityClass() {
    return Entry.class;
  }

  @Override
  protected String getDerivedTableOrViewName() {
    return "entry";
  }

  @Override
  protected BiMap<String, String> fieldNameToCqlColumn() {
    BiMap<String,String> map = HashBiMap.create(5);
    map.put("isPrivate", "is_private");
    map.put("createdAt", "created_at");
    map.put("modifiedAt", "modified_at");
    map.put("expires", "expires_at");
    map.put("uuid", "entry_uuid");
    return map;
  }

  @Override
  protected Optional<ConsistencyLevel> getStaticReadConsistency() {
    return Optional.empty();
  }

  @Override
  protected Optional<InternalNamingStrategy> getStaticNamingStrategy() {
    return Optional.empty();
  }

  @Override
  protected List<AbstractProperty<Entry, ?, ?>> getPartitionKeys() {
    return Arrays.asList(isPrivate);
  }

  @Override
  protected List<AbstractProperty<Entry, ?, ?>> getClusteringColumns() {
    return Arrays.asList(createdAt);
  }

  @Override
  protected List<AbstractProperty<Entry, ?, ?>> getNormalColumns() {
    return Arrays.asList(uuid,expires,modifiedAt);
  }

  @Override
  protected List<AbstractProperty<Entry, ?, ?>> getComputedColumns() {
    return Arrays.asList();
  }

  @Override
  protected boolean isCounterTable() {
    return false;
  }

  @Override
  protected Optional<String> getStaticKeyspace() {
    return Optional.empty();
  }

  @Override
  protected Optional<String> getStaticTableOrViewName() {
    return Optional.of("entries");
  }

  @Override
  protected Optional<ConsistencyLevel> getStaticWriteConsistency() {
    return Optional.empty();
  }

  @Override
  protected Optional<ConsistencyLevel> getStaticSerialConsistency() {
    return Optional.empty();
  }

  @Override
  protected Optional<Integer> getStaticTTL() {
    return Optional.empty();
  }

  @Override
  protected Optional<InsertStrategy> getStaticInsertStrategy() {
    return Optional.empty();
  }

  @Override
  protected List<AbstractProperty<Entry, ?, ?>> getStaticColumns() {
    return Arrays.asList();
  }

  @Override
  protected List<AbstractProperty<Entry, ?, ?>> getCounterColumns() {
    return Arrays.asList();
  }

  /**
   * Utility class to expose all fields with their CQL type for function call */
  public static final class ColumnsForFunctions {
    /**
     * <br/>
     * Field to be used for <em>manager.dsl().select().function(...)</em> call
     * <br/>
     * This is an alias for the field <strong>"isPrivate"</strong> */
    public final Boolean_Type IS_PRIVATE = new Boolean_Type(Optional.empty()){
      @Override
      protected String cqlColumn() {
          return "is_private";
    }
      @Override
      public boolean isFunctionCall() {
          return false;
    }
      }
    ;

    /**
     * <br/>
     * Field to be used for <em>manager.dsl().select().function(...)</em> call
     * <br/>
     * This is an alias for the field <strong>"createdAt"</strong> */
    public final Date_Type CREATED_AT = new Date_Type(Optional.empty()){
      @Override
      protected String cqlColumn() {
          return "created_at";
    }
      @Override
      public boolean isFunctionCall() {
          return false;
    }
      }
    ;

    /**
     * <br/>
     * Field to be used for <em>manager.dsl().select().function(...)</em> call
     * <br/>
     * This is an alias for the field <strong>"modifiedAt"</strong> */
    public final Date_Type MODIFIED_AT = new Date_Type(Optional.empty()){
      @Override
      protected String cqlColumn() {
          return "modified_at";
    }
      @Override
      public boolean isFunctionCall() {
          return false;
    }
      }
    ;

    /**
     * <br/>
     * Field to be used for <em>manager.dsl().select().function(...)</em> call
     * <br/>
     * This is an alias for the field <strong>"expires"</strong> */
    public final Date_Type EXPIRES = new Date_Type(Optional.empty()){
      @Override
      protected String cqlColumn() {
          return "expires_at";
    }
      @Override
      public boolean isFunctionCall() {
          return false;
    }
      }
    ;

    /**
     * <br/>
     * Field to be used for <em>manager.dsl().select().function(...)</em> call
     * <br/>
     * This is an alias for the field <strong>"uuid"</strong> */
    public final UUID_Type UUID = new UUID_Type(Optional.empty()){
      @Override
      protected String cqlColumn() {
          return "entry_uuid";
    }
      @Override
      public boolean isFunctionCall() {
          return false;
    }
      }
    ;
  }
}
