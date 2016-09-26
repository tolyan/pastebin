package info.archinnov.achilles.generated.dsl;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import info.archinnov.achilles.generated.meta.entity.Entry_AchillesMeta;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelect;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelectColumns;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelectColumnsTypeMap;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelectFrom;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelectFromJSON;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelectFromTypeMap;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelectWhere;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelectWhereJSON;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelectWherePartition;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelectWherePartitionJSON;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelectWherePartitionTypeMap;
import info.archinnov.achilles.internals.dsl.query.select.AbstractSelectWhereTypeMap;
import info.archinnov.achilles.internals.metamodel.AbstractEntityProperty;
import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import info.archinnov.achilles.internals.options.Options;
import info.archinnov.achilles.internals.runtime.RuntimeEngine;
import info.archinnov.achilles.type.SchemaNameProvider;
import info.archinnov.achilles.validation.Validator;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;
import ru.anglerhood.pastebin.Entry;

public final class Entry_Select extends AbstractSelect {
  protected final Entry_AchillesMeta meta;

  protected final Class<Entry> entityClass = Entry.class;

  public Entry_Select(RuntimeEngine rte, Entry_AchillesMeta meta) {
    super(rte);
    this.meta = meta;
  }

  /**
   * Generate a SELECT ... <strong>is_private</strong> ... */
  public final Entry_Select.Entry_SelectColumns isPrivate() {
    select.column("is_private");
    return new Entry_Select.Entry_SelectColumns(select);
  }

  /**
   * Generate a SELECT ... <strong>created_at</strong> ... */
  public final Entry_Select.Entry_SelectColumns createdAt() {
    select.column("created_at");
    return new Entry_Select.Entry_SelectColumns(select);
  }

  /**
   * Generate a SELECT ... <strong>modified_at</strong> ... */
  public final Entry_Select.Entry_SelectColumns modifiedAt() {
    select.column("modified_at");
    return new Entry_Select.Entry_SelectColumns(select);
  }

  /**
   * Generate a SELECT ... <strong>expires_at</strong> ... */
  public final Entry_Select.Entry_SelectColumns expires() {
    select.column("expires_at");
    return new Entry_Select.Entry_SelectColumns(select);
  }

  /**
   * Generate a SELECT ... <strong>entry_uuid</strong> ... */
  public final Entry_Select.Entry_SelectColumns uuid() {
    select.column("entry_uuid");
    return new Entry_Select.Entry_SelectColumns(select);
  }

  /**
   * Use this method to call a system or user-defined function.<br/>All the system functions are accessible from the <strong>{@link info.archinnov.achilles.generated.function.SystemFunctions}</strong> class<br/>All the user-defined functions and aggregates are accessible from the <strong>{@link info.archinnov.achilles.generated.function.FunctionsRegistry}</strong> class<br/>System and user-defined functions accept only appropriate type. To pass in an entity field as function argument, use the generated <strong>manager.COLUMNS</strong> class which exposes all columns with their appropriate type<br/>Example: <pre class="code"><code class="java">
   *   {@literal @}Table
   *   public class MyEntity {
   *
   *       ...
   *
   *       {@literal @}Column("value_column")
   *       private String value;
   *
   *       {@literal @}Column("list_of_string")
   *       private List<String> strings;
   *
   *       ...
   *
   *   }
   *
   *   {@literal @}FunctionsRegistry
   *   public interface MyFunctions {
   *
   *        String convertListToJson(List<String> strings);
   *
   *   }
   *
   *
   *   ...
   *
   *
   *   manager
   *      .dsl()
   *      .select()
   *      // This call will generate SELECT cast(writetime(value_column) as text) AS writetimeOfValueAsString, ...
   *      .function(SystemFunctions.castAsText(SystemFunctions.writetime(manager.COLUMNS.VALUE)), "writetimeOfValueAsString")
   *      ...
   *
   *   manager 
   *      .dsl()
   *      .select()
   *      // This call will generate SELECT convertlisttojson(list_of_string) AS strings_as_json, ...
   *      .function(FunctionsRegistry.convertListToJson(manager.COLUMNS.STRINGS), "strings_as_json")
   *      ...
   *
   * </code></pre>
   * <br/>
   * @param functionCall the function call object 
   * @param alias mandatory alias for this function call for easier retrieval from the ResultSet 
   * @return a built-in function call passed to the QueryBuilder object 
   */
  public final Entry_Select.Entry_SelectColumnsTypedMap function(final FunctionCall functionCall, final String alias) {
    functionCall.addToSelect(select, alias);
    return new Entry_Select.Entry_SelectColumnsTypedMap(select);
  }

  /**
   * Generate ... * FROM ... */
  public final Entry_Select.Entry_SelectFrom allColumns_FromBaseTable() {
    final Select.Where where = select.all().from(meta.getKeyspace().orElse("unknown_keyspace_for_" + meta.entityClass.getCanonicalName()), meta.getTableOrViewName()).where();
    return new Entry_Select.Entry_SelectFrom(where);
  }

  /**
   * Generate ... * FROM ... using the given SchemaNameProvider */
  public final Entry_Select.Entry_SelectFrom allColumns_From(final SchemaNameProvider schemaNameProvider) {
    final String currentKeyspace = lookupKeyspace(schemaNameProvider, meta.entityClass);
    final String currentTable = lookupTable(schemaNameProvider, meta.entityClass);
    final Select.Where where = select.all().from(currentKeyspace, currentTable).where();
    return new Entry_Select.Entry_SelectFrom(where);
  }

  /**
   * Generate ... * FROM ... */
  public final Entry_Select.Entry_SelectFromJSON allColumnsAsJSON_FromBaseTable() {
    final Select.Where where = select.json().all().from(meta.getKeyspace().orElse("unknown_keyspace_for_" + meta.entityClass.getCanonicalName()), meta.getTableOrViewName()).where();
    return new Entry_Select.Entry_SelectFromJSON(where);
  }

  /**
   * Generate ... * FROM ... using the given SchemaNameProvider */
  public final Entry_Select.Entry_SelectFromJSON allColumnsAsJSON_From(final SchemaNameProvider schemaNameProvider) {
    final String currentKeyspace = lookupKeyspace(schemaNameProvider, meta.entityClass);
    final String currentTable = lookupTable(schemaNameProvider, meta.entityClass);
    final Select.Where where = select.json().all().from(currentKeyspace, currentTable).where();
    return new Entry_Select.Entry_SelectFromJSON(where);
  }

  public class Entry_SelectColumns extends AbstractSelectColumns {
    public Entry_SelectColumns(Select.Selection selection) {
      super(selection);
    }

    /**
     * Generate a SELECT ... <strong>is_private</strong> ... */
    public final Entry_Select.Entry_SelectColumns isPrivate() {
      selection.column("is_private");
      return this;
    }

    /**
     * Generate a SELECT ... <strong>created_at</strong> ... */
    public final Entry_Select.Entry_SelectColumns createdAt() {
      selection.column("created_at");
      return this;
    }

    /**
     * Generate a SELECT ... <strong>modified_at</strong> ... */
    public final Entry_Select.Entry_SelectColumns modifiedAt() {
      selection.column("modified_at");
      return this;
    }

    /**
     * Generate a SELECT ... <strong>expires_at</strong> ... */
    public final Entry_Select.Entry_SelectColumns expires() {
      selection.column("expires_at");
      return this;
    }

    /**
     * Generate a SELECT ... <strong>entry_uuid</strong> ... */
    public final Entry_Select.Entry_SelectColumns uuid() {
      selection.column("entry_uuid");
      return this;
    }

    /**
     * Use this method to call a system or user-defined function.<br/>All the system functions are accessible from the <strong>{@link info.archinnov.achilles.generated.function.SystemFunctions}</strong> class<br/>All the user-defined functions and aggregates are accessible from the <strong>{@link info.archinnov.achilles.generated.function.FunctionsRegistry}</strong> class<br/>System and user-defined functions accept only appropriate type. To pass in an entity field as function argument, use the generated <strong>manager.COLUMNS</strong> class which exposes all columns with their appropriate type<br/>Example: <pre class="code"><code class="java">
     *   {@literal @}Table
     *   public class MyEntity {
     *
     *       ...
     *
     *       {@literal @}Column("value_column")
     *       private String value;
     *
     *       {@literal @}Column("list_of_string")
     *       private List<String> strings;
     *
     *       ...
     *
     *   }
     *
     *   {@literal @}FunctionsRegistry
     *   public interface MyFunctions {
     *
     *        String convertListToJson(List<String> strings);
     *
     *   }
     *
     *
     *   ...
     *
     *
     *   manager
     *      .dsl()
     *      .select()
     *      // This call will generate SELECT cast(writetime(value_column) as text) AS writetimeOfValueAsString, ...
     *      .function(SystemFunctions.castAsText(SystemFunctions.writetime(manager.COLUMNS.VALUE)), "writetimeOfValueAsString")
     *      ...
     *
     *   manager 
     *      .dsl()
     *      .select()
     *      // This call will generate SELECT convertlisttojson(list_of_string) AS strings_as_json, ...
     *      .function(FunctionsRegistry.convertListToJson(manager.COLUMNS.STRINGS), "strings_as_json")
     *      ...
     *
     * </code></pre>
     * <br/>
     * @param functionCall the function call object 
     * @param alias mandatory alias for this function call for easier retrieval from the ResultSet 
     * @return a built-in function call passed to the QueryBuilder object 
     */
    public final Entry_Select.Entry_SelectColumnsTypedMap function(final FunctionCall functionCall, final String alias) {
      functionCall.addToSelect(selection, alias);
      return new Entry_Select.Entry_SelectColumnsTypedMap(select);
    }

    /**
     * Generate a ... <strong>FROM xxx</strong> ...  */
    public final Entry_Select.Entry_SelectFrom fromBaseTable() {
      final Select.Where where = selection.from(meta.getKeyspace().orElse("unknown_keyspace_for_" + meta.entityClass.getCanonicalName()), meta.getTableOrViewName()).where();
      return new Entry_Select.Entry_SelectFrom(where);
    }

    /**
     * Generate a ... <strong>FROM xxx</strong> ... using the given SchemaNameProvider */
    public final Entry_Select.Entry_SelectFrom from(final SchemaNameProvider schemaNameProvider) {
      final String currentKeyspace = lookupKeyspace(schemaNameProvider, meta.entityClass);
      final String currentTable = lookupTable(schemaNameProvider, meta.entityClass);
      final Select.Where where = selection.from(currentKeyspace, currentTable).where();
      return new Entry_Select.Entry_SelectFrom(where);
    }
  }

  public class Entry_SelectColumnsTypedMap extends AbstractSelectColumnsTypeMap {
    public Entry_SelectColumnsTypedMap(Select.Selection selection) {
      super(selection);
    }

    /**
     * Generate a SELECT ... <strong>is_private</strong> ... */
    public final Entry_Select.Entry_SelectColumnsTypedMap isPrivate() {
      selection.column("is_private");
      return this;
    }

    /**
     * Generate a SELECT ... <strong>created_at</strong> ... */
    public final Entry_Select.Entry_SelectColumnsTypedMap createdAt() {
      selection.column("created_at");
      return this;
    }

    /**
     * Generate a SELECT ... <strong>modified_at</strong> ... */
    public final Entry_Select.Entry_SelectColumnsTypedMap modifiedAt() {
      selection.column("modified_at");
      return this;
    }

    /**
     * Generate a SELECT ... <strong>expires_at</strong> ... */
    public final Entry_Select.Entry_SelectColumnsTypedMap expires() {
      selection.column("expires_at");
      return this;
    }

    /**
     * Generate a SELECT ... <strong>entry_uuid</strong> ... */
    public final Entry_Select.Entry_SelectColumnsTypedMap uuid() {
      selection.column("entry_uuid");
      return this;
    }

    /**
     * Use this method to call a system or user-defined function.<br/>All the system functions are accessible from the <strong>{@link info.archinnov.achilles.generated.function.SystemFunctions}</strong> class<br/>All the user-defined functions and aggregates are accessible from the <strong>{@link info.archinnov.achilles.generated.function.FunctionsRegistry}</strong> class<br/>System and user-defined functions accept only appropriate type. To pass in an entity field as function argument, use the generated <strong>manager.COLUMNS</strong> class which exposes all columns with their appropriate type<br/>Example: <pre class="code"><code class="java">
     *   {@literal @}Table
     *   public class MyEntity {
     *
     *       ...
     *
     *       {@literal @}Column("value_column")
     *       private String value;
     *
     *       {@literal @}Column("list_of_string")
     *       private List<String> strings;
     *
     *       ...
     *
     *   }
     *
     *   {@literal @}FunctionsRegistry
     *   public interface MyFunctions {
     *
     *        String convertListToJson(List<String> strings);
     *
     *   }
     *
     *
     *   ...
     *
     *
     *   manager
     *      .dsl()
     *      .select()
     *      // This call will generate SELECT cast(writetime(value_column) as text) AS writetimeOfValueAsString, ...
     *      .function(SystemFunctions.castAsText(SystemFunctions.writetime(manager.COLUMNS.VALUE)), "writetimeOfValueAsString")
     *      ...
     *
     *   manager 
     *      .dsl()
     *      .select()
     *      // This call will generate SELECT convertlisttojson(list_of_string) AS strings_as_json, ...
     *      .function(FunctionsRegistry.convertListToJson(manager.COLUMNS.STRINGS), "strings_as_json")
     *      ...
     *
     * </code></pre>
     * <br/>
     * @param functionCall the function call object 
     * @param alias mandatory alias for this function call for easier retrieval from the ResultSet 
     * @return a built-in function call passed to the QueryBuilder object 
     */
    public final Entry_Select.Entry_SelectColumnsTypedMap function(final FunctionCall functionCall, final String alias) {
      functionCall.addToSelect(selection, alias);
      return this;
    }

    /**
     * Generate a ... <strong>FROM xxx</strong> ...  */
    public final Entry_Select.Entry_SelectFromTypedMap fromBaseTable() {
      final Select.Where where = selection.from(meta.getKeyspace().orElse("unknown_keyspace_for_" + meta.entityClass.getCanonicalName()), meta.getTableOrViewName()).where();
      return new Entry_Select.Entry_SelectFromTypedMap(where);
    }

    /**
     * Generate a ... <strong>FROM xxx</strong> ... using the given SchemaNameProvider */
    public final Entry_Select.Entry_SelectFromTypedMap from(final SchemaNameProvider schemaNameProvider) {
      final String currentKeyspace = lookupKeyspace(schemaNameProvider, meta.entityClass);
      final String currentTable = lookupTable(schemaNameProvider, meta.entityClass);
      final Select.Where where = selection.from(currentKeyspace, currentTable).where();
      return new Entry_Select.Entry_SelectFromTypedMap(where);
    }
  }

  public class Entry_SelectFrom extends AbstractSelectFrom {
    Entry_SelectFrom(Select.Where where) {
      super(where);
    }

    /**
     * Generate a SELECT ... FROM ... <strong>WHERE</strong> ... */
    public final Entry_Select.Entry_SelectWhere_IsPrivate where() {
      return new Entry_Select.Entry_SelectWhere_IsPrivate(where);
    }

    /**
     * Generate a SELECT statement <strong>without</strong> the <strong>WHERE</strong> clause */
    public final Entry_Select.Entry_SelectEnd without_WHERE_Clause() {
      return new Entry_Select.Entry_SelectEnd(where);
    }
  }

  public class Entry_SelectFromTypedMap extends AbstractSelectFromTypeMap {
    Entry_SelectFromTypedMap(Select.Where where) {
      super(where);
    }

    /**
     * Generate a SELECT ... FROM ... <strong>WHERE</strong> ... */
    public final Entry_Select.Entry_SelectWhereTypedMap_IsPrivate where() {
      return new Entry_Select.Entry_SelectWhereTypedMap_IsPrivate(where);
    }

    /**
     * Generate a SELECT statement <strong>without</strong> the <strong>WHERE</strong> clause */
    public final Entry_Select.Entry_SelectEndTypedMap without_WHERE_Clause() {
      return new Entry_Select.Entry_SelectEndTypedMap(where);
    }
  }

  public class Entry_SelectFromJSON extends AbstractSelectFromJSON {
    Entry_SelectFromJSON(Select.Where where) {
      super(where);
    }

    /**
     * Generate a SELECT ... FROM ... <strong>WHERE</strong> ... */
    public final Entry_Select.Entry_SelectWhereJSON_IsPrivate where() {
      return new Entry_Select.Entry_SelectWhereJSON_IsPrivate(where);
    }

    /**
     * Generate a SELECT statement <strong>without</strong> the <strong>WHERE</strong> clause */
    public final Entry_Select.Entry_SelectEndJSON without_WHERE_Clause() {
      return new Entry_Select.Entry_SelectEndJSON(where);
    }
  }

  public final class Entry_SelectWhere_IsPrivate extends AbstractSelectWherePartition {
    public Entry_SelectWhere_IsPrivate(Select.Where where) {
      super(where);
    }

    public final Entry_Select.Entry_SelectWhere_IsPrivate.Relation isPrivate() {
      return new Entry_Select.Entry_SelectWhere_IsPrivate.Relation();
    }

    public final class Relation {
      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectWhere_CreatedAt Eq(Boolean isPrivate) {
        where.and(QueryBuilder.eq("is_private", QueryBuilder.bindMarker("is_private")));
        boundValues.add(isPrivate);
        encodedValues.add(meta.isPrivate.encodeFromJava(isPrivate));
        return new Entry_Select.Entry_SelectWhere_CreatedAt(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private IN ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectWhere_CreatedAt IN(Boolean... isPrivate) {
        Validator.validateTrue(ArrayUtils.isNotEmpty(isPrivate), "Varargs for field '%s' should not be null/empty", "isPrivate");
        where.and(QueryBuilder.in("is_private",QueryBuilder.bindMarker("is_private")));
        final List<Object> varargs = Arrays.<Object>asList((Object[])isPrivate);
        final List<Object> encodedVarargs = Arrays.<Boolean>stream((Boolean[])isPrivate).map(x -> meta.isPrivate.encodeFromJava(x)).collect(Collectors.toList());
        boundValues.add(varargs);
        encodedValues.add(encodedVarargs);
        return new Entry_Select.Entry_SelectWhere_CreatedAt(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private  = fromJson(?) </strong> */
      public final Entry_Select.Entry_SelectWhere_CreatedAt Eq_FromJson(String isPrivate) {
        where.and(QueryBuilder.eq("is_private", QueryBuilder.fromJson(QueryBuilder.bindMarker("is_private"))));
        boundValues.add(isPrivate);
        encodedValues.add(isPrivate);
        return new Entry_Select.Entry_SelectWhere_CreatedAt(where);
      }
    }
  }

  public final class Entry_SelectWhere_CreatedAt extends AbstractSelectWhere<Entry_Select.Entry_SelectWhere_CreatedAt, Entry> {
    public Entry_SelectWhere_CreatedAt(Select.Where where) {
      super(where);
    }

    @Override
    protected final Entry_Select.Entry_SelectWhere_CreatedAt getThis() {
      return this;
    }

    @Override
    protected final AbstractEntityProperty<Entry> getMetaInternal() {
      return meta;
    }

    @Override
    protected final Class<Entry> getEntityClass() {
      return entityClass;
    }

    @Override
    protected final RuntimeEngine getRte() {
      return rte;
    }

    @Override
    protected final Options getOptions() {
      return options;
    }

    @Override
    protected final List<Object> getBoundValuesInternal() {
      return boundValues;
    }

    @Override
    protected final List<Object> getEncodedValuesInternal() {
      return encodedValues;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>LIMIT :limit</strong> */
    public final Entry_Select.Entry_SelectWhere_CreatedAt limit(final Integer limit) {
      where.limit(QueryBuilder.bindMarker("lim"));
      boundValues.add(limit);
      encodedValues.add(limit);
      return this;
    }

    public final Entry_Select.Entry_SelectWhere_CreatedAt.Relation createdAt() {
      return new Entry_Select.Entry_SelectWhere_CreatedAt.Relation();
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at ASC</strong> */
    public final Entry_Select.Entry_SelectWhere_CreatedAt orderByCreatedAtAscending() {
      where.orderBy(QueryBuilder.asc("created_at"));
      return this;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at DESC</strong> */
    public final Entry_Select.Entry_SelectWhere_CreatedAt orderByCreatedAtDescending() {
      where.orderBy(QueryBuilder.desc("created_at"));
      return this;
    }

    public final class Relation {
      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEnd Eq(Date createdAt) {
        where.and(QueryBuilder.eq("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at IN ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEnd IN(Date... createdAt) {
        Validator.validateTrue(ArrayUtils.isNotEmpty(createdAt), "Varargs for field '%s' should not be null/empty", "createdAt");
        where.and(QueryBuilder.in("created_at",QueryBuilder.bindMarker("created_at")));
        final List<Object> varargs = Arrays.<Object>asList((Object[])createdAt);
        final List<Object> encodedVarargs = Arrays.<Date>stream((Date[])createdAt).map(x -> meta.createdAt.encodeFromJava(x)).collect(Collectors.toList());
        boundValues.add(varargs);
        encodedValues.add(encodedVarargs);
        return new Entry_Select.Entry_SelectEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEnd Gt(Date createdAt) {
        where.and(QueryBuilder.gt("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEnd Gte(Date createdAt) {
        where.and(QueryBuilder.gte("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEnd Lt(Date createdAt) {
        where.and(QueryBuilder.lt("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEnd Lte(Date createdAt) {
        where.and(QueryBuilder.lte("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ? AND created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEnd Gt_And_Lt(Date createdAt_Gt, Date createdAt_Lt) {
        where.and(QueryBuilder.gt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        where.and(QueryBuilder.lt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        boundValues.add(createdAt_Gt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gt));
        boundValues.add(createdAt_Lt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lt));
        return new Entry_Select.Entry_SelectEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ? AND created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEnd Gt_And_Lte(Date createdAt_Gt, Date createdAt_Lte) {
        where.and(QueryBuilder.gt("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        where.and(QueryBuilder.lte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        boundValues.add(createdAt_Gt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gt));
        boundValues.add(createdAt_Lte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lte));
        return new Entry_Select.Entry_SelectEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ? AND created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEnd Gte_And_Lt(Date createdAt_Gte, Date createdAt_Lt) {
        where.and(QueryBuilder.gte("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        where.and(QueryBuilder.lt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        boundValues.add(createdAt_Gte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gte));
        boundValues.add(createdAt_Lt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lt));
        return new Entry_Select.Entry_SelectEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ? AND created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEnd Gte_And_Lte(Date createdAt_Gte, Date createdAt_Lte) {
        where.and(QueryBuilder.gte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        where.and(QueryBuilder.lte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        boundValues.add(createdAt_Gte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gte));
        boundValues.add(createdAt_Lte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lte));
        return new Entry_Select.Entry_SelectEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at  = fromJson(?) </strong> */
      public final Entry_Select.Entry_SelectEnd Eq_FromJson(String createdAt) {
        where.and(QueryBuilder.eq("created_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("created_at"))));
        boundValues.add(createdAt);
        encodedValues.add(createdAt);
        return new Entry_Select.Entry_SelectEnd(where);
      }
    }
  }

  public final class Entry_SelectEnd extends AbstractSelectWhere<Entry_Select.Entry_SelectEnd, Entry> {
    public Entry_SelectEnd(Select.Where where) {
      super(where);
    }

    @Override
    protected final Class<Entry> getEntityClass() {
      return entityClass;
    }

    @Override
    protected final AbstractEntityProperty<Entry> getMetaInternal() {
      return meta;
    }

    @Override
    protected final RuntimeEngine getRte() {
      return rte;
    }

    @Override
    protected final Options getOptions() {
      return options;
    }

    @Override
    protected final List<Object> getBoundValuesInternal() {
      return boundValues;
    }

    @Override
    protected final List<Object> getEncodedValuesInternal() {
      return encodedValues;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>LIMIT :limit</strong> */
    public final Entry_Select.Entry_SelectEnd limit(final Integer limit) {
      where.limit(QueryBuilder.bindMarker("lim"));
      boundValues.add(limit);
      encodedValues.add(limit);
      return this;
    }

    @Override
    protected final Entry_Select.Entry_SelectEnd getThis() {
      return this;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at ASC</strong> */
    public final Entry_Select.Entry_SelectEnd orderByCreatedAtAscending() {
      where.orderBy(QueryBuilder.asc("created_at"));
      return this;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at DESC</strong> */
    public final Entry_Select.Entry_SelectEnd orderByCreatedAtDescending() {
      where.orderBy(QueryBuilder.desc("created_at"));
      return this;
    }
  }

  public final class Entry_SelectWhereTypedMap_IsPrivate extends AbstractSelectWherePartitionTypeMap {
    public Entry_SelectWhereTypedMap_IsPrivate(Select.Where where) {
      super(where);
    }

    public final Entry_Select.Entry_SelectWhereTypedMap_IsPrivate.Relation isPrivate() {
      return new Entry_Select.Entry_SelectWhereTypedMap_IsPrivate.Relation();
    }

    public final class Relation {
      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectWhereTypedMap_CreatedAt Eq(Boolean isPrivate) {
        where.and(QueryBuilder.eq("is_private", QueryBuilder.bindMarker("is_private")));
        boundValues.add(isPrivate);
        encodedValues.add(meta.isPrivate.encodeFromJava(isPrivate));
        return new Entry_Select.Entry_SelectWhereTypedMap_CreatedAt(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private IN ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectWhereTypedMap_CreatedAt IN(Boolean... isPrivate) {
        Validator.validateTrue(ArrayUtils.isNotEmpty(isPrivate), "Varargs for field '%s' should not be null/empty", "isPrivate");
        where.and(QueryBuilder.in("is_private",QueryBuilder.bindMarker("is_private")));
        final List<Object> varargs = Arrays.<Object>asList((Object[])isPrivate);
        final List<Object> encodedVarargs = Arrays.<Boolean>stream((Boolean[])isPrivate).map(x -> meta.isPrivate.encodeFromJava(x)).collect(Collectors.toList());
        boundValues.add(varargs);
        encodedValues.add(encodedVarargs);
        return new Entry_Select.Entry_SelectWhereTypedMap_CreatedAt(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private  = fromJson(?) </strong> */
      public final Entry_Select.Entry_SelectWhereTypedMap_CreatedAt Eq_FromJson(String isPrivate) {
        where.and(QueryBuilder.eq("is_private", QueryBuilder.fromJson(QueryBuilder.bindMarker("is_private"))));
        boundValues.add(isPrivate);
        encodedValues.add(isPrivate);
        return new Entry_Select.Entry_SelectWhereTypedMap_CreatedAt(where);
      }
    }
  }

  public final class Entry_SelectWhereTypedMap_CreatedAt extends AbstractSelectWhereTypeMap<Entry_Select.Entry_SelectWhereTypedMap_CreatedAt, Entry> {
    public Entry_SelectWhereTypedMap_CreatedAt(Select.Where where) {
      super(where);
    }

    @Override
    protected final Entry_Select.Entry_SelectWhereTypedMap_CreatedAt getThis() {
      return this;
    }

    @Override
    protected final AbstractEntityProperty<Entry> getMetaInternal() {
      return meta;
    }

    @Override
    protected final Class<Entry> getEntityClass() {
      return entityClass;
    }

    @Override
    protected final RuntimeEngine getRte() {
      return rte;
    }

    @Override
    protected final Options getOptions() {
      return options;
    }

    @Override
    protected final List<Object> getBoundValuesInternal() {
      return boundValues;
    }

    @Override
    protected final List<Object> getEncodedValuesInternal() {
      return encodedValues;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>LIMIT :limit</strong> */
    public final Entry_Select.Entry_SelectWhereTypedMap_CreatedAt limit(final Integer limit) {
      where.limit(QueryBuilder.bindMarker("lim"));
      boundValues.add(limit);
      encodedValues.add(limit);
      return this;
    }

    public final Entry_Select.Entry_SelectWhereTypedMap_CreatedAt.Relation createdAt() {
      return new Entry_Select.Entry_SelectWhereTypedMap_CreatedAt.Relation();
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at ASC</strong> */
    public final Entry_Select.Entry_SelectWhereTypedMap_CreatedAt orderByCreatedAtAscending() {
      where.orderBy(QueryBuilder.asc("created_at"));
      return this;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at DESC</strong> */
    public final Entry_Select.Entry_SelectWhereTypedMap_CreatedAt orderByCreatedAtDescending() {
      where.orderBy(QueryBuilder.desc("created_at"));
      return this;
    }

    public final class Relation {
      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndTypedMap Eq(Date createdAt) {
        where.and(QueryBuilder.eq("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEndTypedMap(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at IN ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndTypedMap IN(Date... createdAt) {
        Validator.validateTrue(ArrayUtils.isNotEmpty(createdAt), "Varargs for field '%s' should not be null/empty", "createdAt");
        where.and(QueryBuilder.in("created_at",QueryBuilder.bindMarker("created_at")));
        final List<Object> varargs = Arrays.<Object>asList((Object[])createdAt);
        final List<Object> encodedVarargs = Arrays.<Date>stream((Date[])createdAt).map(x -> meta.createdAt.encodeFromJava(x)).collect(Collectors.toList());
        boundValues.add(varargs);
        encodedValues.add(encodedVarargs);
        return new Entry_Select.Entry_SelectEndTypedMap(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndTypedMap Gt(Date createdAt) {
        where.and(QueryBuilder.gt("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEndTypedMap(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndTypedMap Gte(Date createdAt) {
        where.and(QueryBuilder.gte("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEndTypedMap(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndTypedMap Lt(Date createdAt) {
        where.and(QueryBuilder.lt("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEndTypedMap(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndTypedMap Lte(Date createdAt) {
        where.and(QueryBuilder.lte("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEndTypedMap(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ? AND created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndTypedMap Gt_And_Lt(Date createdAt_Gt, Date createdAt_Lt) {
        where.and(QueryBuilder.gt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        where.and(QueryBuilder.lt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        boundValues.add(createdAt_Gt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gt));
        boundValues.add(createdAt_Lt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lt));
        return new Entry_Select.Entry_SelectEndTypedMap(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ? AND created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndTypedMap Gt_And_Lte(Date createdAt_Gt, Date createdAt_Lte) {
        where.and(QueryBuilder.gt("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        where.and(QueryBuilder.lte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        boundValues.add(createdAt_Gt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gt));
        boundValues.add(createdAt_Lte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lte));
        return new Entry_Select.Entry_SelectEndTypedMap(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ? AND created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndTypedMap Gte_And_Lt(Date createdAt_Gte, Date createdAt_Lt) {
        where.and(QueryBuilder.gte("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        where.and(QueryBuilder.lt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        boundValues.add(createdAt_Gte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gte));
        boundValues.add(createdAt_Lt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lt));
        return new Entry_Select.Entry_SelectEndTypedMap(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ? AND created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndTypedMap Gte_And_Lte(Date createdAt_Gte, Date createdAt_Lte) {
        where.and(QueryBuilder.gte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        where.and(QueryBuilder.lte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        boundValues.add(createdAt_Gte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gte));
        boundValues.add(createdAt_Lte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lte));
        return new Entry_Select.Entry_SelectEndTypedMap(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at  = fromJson(?) </strong> */
      public final Entry_Select.Entry_SelectEndTypedMap Eq_FromJson(String createdAt) {
        where.and(QueryBuilder.eq("created_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("created_at"))));
        boundValues.add(createdAt);
        encodedValues.add(createdAt);
        return new Entry_Select.Entry_SelectEndTypedMap(where);
      }
    }
  }

  public final class Entry_SelectEndTypedMap extends AbstractSelectWhereTypeMap<Entry_Select.Entry_SelectEndTypedMap, Entry> {
    public Entry_SelectEndTypedMap(Select.Where where) {
      super(where);
    }

    @Override
    protected final Class<Entry> getEntityClass() {
      return entityClass;
    }

    @Override
    protected final AbstractEntityProperty<Entry> getMetaInternal() {
      return meta;
    }

    @Override
    protected final RuntimeEngine getRte() {
      return rte;
    }

    @Override
    protected final Options getOptions() {
      return options;
    }

    @Override
    protected final List<Object> getBoundValuesInternal() {
      return boundValues;
    }

    @Override
    protected final List<Object> getEncodedValuesInternal() {
      return encodedValues;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>LIMIT :limit</strong> */
    public final Entry_Select.Entry_SelectEndTypedMap limit(final Integer limit) {
      where.limit(QueryBuilder.bindMarker("lim"));
      boundValues.add(limit);
      encodedValues.add(limit);
      return this;
    }

    @Override
    protected final Entry_Select.Entry_SelectEndTypedMap getThis() {
      return this;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at ASC</strong> */
    public final Entry_Select.Entry_SelectEndTypedMap orderByCreatedAtAscending() {
      where.orderBy(QueryBuilder.asc("created_at"));
      return this;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at DESC</strong> */
    public final Entry_Select.Entry_SelectEndTypedMap orderByCreatedAtDescending() {
      where.orderBy(QueryBuilder.desc("created_at"));
      return this;
    }
  }

  public final class Entry_SelectWhereJSON_IsPrivate extends AbstractSelectWherePartitionJSON {
    public Entry_SelectWhereJSON_IsPrivate(Select.Where where) {
      super(where);
    }

    public final Entry_Select.Entry_SelectWhereJSON_IsPrivate.Relation isPrivate() {
      return new Entry_Select.Entry_SelectWhereJSON_IsPrivate.Relation();
    }

    public final class Relation {
      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectWhereJSON_CreatedAt Eq(Boolean isPrivate) {
        where.and(QueryBuilder.eq("is_private", QueryBuilder.bindMarker("is_private")));
        boundValues.add(isPrivate);
        encodedValues.add(meta.isPrivate.encodeFromJava(isPrivate));
        return new Entry_Select.Entry_SelectWhereJSON_CreatedAt(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private IN ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectWhereJSON_CreatedAt IN(Boolean... isPrivate) {
        Validator.validateTrue(ArrayUtils.isNotEmpty(isPrivate), "Varargs for field '%s' should not be null/empty", "isPrivate");
        where.and(QueryBuilder.in("is_private",QueryBuilder.bindMarker("is_private")));
        final List<Object> varargs = Arrays.<Object>asList((Object[])isPrivate);
        final List<Object> encodedVarargs = Arrays.<Boolean>stream((Boolean[])isPrivate).map(x -> meta.isPrivate.encodeFromJava(x)).collect(Collectors.toList());
        boundValues.add(varargs);
        encodedValues.add(encodedVarargs);
        return new Entry_Select.Entry_SelectWhereJSON_CreatedAt(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private  = fromJson(?) </strong> */
      public final Entry_Select.Entry_SelectWhereJSON_CreatedAt Eq_FromJson(String isPrivate) {
        where.and(QueryBuilder.eq("is_private", QueryBuilder.fromJson(QueryBuilder.bindMarker("is_private"))));
        boundValues.add(isPrivate);
        encodedValues.add(isPrivate);
        return new Entry_Select.Entry_SelectWhereJSON_CreatedAt(where);
      }
    }
  }

  public final class Entry_SelectWhereJSON_CreatedAt extends AbstractSelectWhereJSON<Entry_Select.Entry_SelectWhereJSON_CreatedAt, Entry> {
    public Entry_SelectWhereJSON_CreatedAt(Select.Where where) {
      super(where);
    }

    @Override
    protected final Entry_Select.Entry_SelectWhereJSON_CreatedAt getThis() {
      return this;
    }

    @Override
    protected final AbstractEntityProperty<Entry> getMetaInternal() {
      return meta;
    }

    @Override
    protected final Class<Entry> getEntityClass() {
      return entityClass;
    }

    @Override
    protected final RuntimeEngine getRte() {
      return rte;
    }

    @Override
    protected final Options getOptions() {
      return options;
    }

    @Override
    protected final List<Object> getBoundValuesInternal() {
      return boundValues;
    }

    @Override
    protected final List<Object> getEncodedValuesInternal() {
      return encodedValues;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>LIMIT :limit</strong> */
    public final Entry_Select.Entry_SelectWhereJSON_CreatedAt limit(final Integer limit) {
      where.limit(QueryBuilder.bindMarker("lim"));
      boundValues.add(limit);
      encodedValues.add(limit);
      return this;
    }

    public final Entry_Select.Entry_SelectWhereJSON_CreatedAt.Relation createdAt() {
      return new Entry_Select.Entry_SelectWhereJSON_CreatedAt.Relation();
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at ASC</strong> */
    public final Entry_Select.Entry_SelectWhereJSON_CreatedAt orderByCreatedAtAscending() {
      where.orderBy(QueryBuilder.asc("created_at"));
      return this;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at DESC</strong> */
    public final Entry_Select.Entry_SelectWhereJSON_CreatedAt orderByCreatedAtDescending() {
      where.orderBy(QueryBuilder.desc("created_at"));
      return this;
    }

    public final class Relation {
      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndJSON Eq(Date createdAt) {
        where.and(QueryBuilder.eq("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEndJSON(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at IN ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndJSON IN(Date... createdAt) {
        Validator.validateTrue(ArrayUtils.isNotEmpty(createdAt), "Varargs for field '%s' should not be null/empty", "createdAt");
        where.and(QueryBuilder.in("created_at",QueryBuilder.bindMarker("created_at")));
        final List<Object> varargs = Arrays.<Object>asList((Object[])createdAt);
        final List<Object> encodedVarargs = Arrays.<Date>stream((Date[])createdAt).map(x -> meta.createdAt.encodeFromJava(x)).collect(Collectors.toList());
        boundValues.add(varargs);
        encodedValues.add(encodedVarargs);
        return new Entry_Select.Entry_SelectEndJSON(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndJSON Gt(Date createdAt) {
        where.and(QueryBuilder.gt("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEndJSON(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndJSON Gte(Date createdAt) {
        where.and(QueryBuilder.gte("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEndJSON(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndJSON Lt(Date createdAt) {
        where.and(QueryBuilder.lt("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEndJSON(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndJSON Lte(Date createdAt) {
        where.and(QueryBuilder.lte("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Select.Entry_SelectEndJSON(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ? AND created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndJSON Gt_And_Lt(Date createdAt_Gt, Date createdAt_Lt) {
        where.and(QueryBuilder.gt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        where.and(QueryBuilder.lt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        boundValues.add(createdAt_Gt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gt));
        boundValues.add(createdAt_Lt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lt));
        return new Entry_Select.Entry_SelectEndJSON(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ? AND created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndJSON Gt_And_Lte(Date createdAt_Gt, Date createdAt_Lte) {
        where.and(QueryBuilder.gt("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        where.and(QueryBuilder.lte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        boundValues.add(createdAt_Gt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gt));
        boundValues.add(createdAt_Lte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lte));
        return new Entry_Select.Entry_SelectEndJSON(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ? AND created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndJSON Gte_And_Lt(Date createdAt_Gte, Date createdAt_Lt) {
        where.and(QueryBuilder.gte("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        where.and(QueryBuilder.lt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        boundValues.add(createdAt_Gte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gte));
        boundValues.add(createdAt_Lt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lt));
        return new Entry_Select.Entry_SelectEndJSON(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ? AND created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Select.Entry_SelectEndJSON Gte_And_Lte(Date createdAt_Gte, Date createdAt_Lte) {
        where.and(QueryBuilder.gte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        where.and(QueryBuilder.lte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        boundValues.add(createdAt_Gte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gte));
        boundValues.add(createdAt_Lte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lte));
        return new Entry_Select.Entry_SelectEndJSON(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at  = fromJson(?) </strong> */
      public final Entry_Select.Entry_SelectEndJSON Eq_FromJson(String createdAt) {
        where.and(QueryBuilder.eq("created_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("created_at"))));
        boundValues.add(createdAt);
        encodedValues.add(createdAt);
        return new Entry_Select.Entry_SelectEndJSON(where);
      }
    }
  }

  public final class Entry_SelectEndJSON extends AbstractSelectWhereJSON<Entry_Select.Entry_SelectEndJSON, Entry> {
    public Entry_SelectEndJSON(Select.Where where) {
      super(where);
    }

    @Override
    protected final Class<Entry> getEntityClass() {
      return entityClass;
    }

    @Override
    protected final AbstractEntityProperty<Entry> getMetaInternal() {
      return meta;
    }

    @Override
    protected final RuntimeEngine getRte() {
      return rte;
    }

    @Override
    protected final Options getOptions() {
      return options;
    }

    @Override
    protected final List<Object> getBoundValuesInternal() {
      return boundValues;
    }

    @Override
    protected final List<Object> getEncodedValuesInternal() {
      return encodedValues;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>LIMIT :limit</strong> */
    public final Entry_Select.Entry_SelectEndJSON limit(final Integer limit) {
      where.limit(QueryBuilder.bindMarker("lim"));
      boundValues.add(limit);
      encodedValues.add(limit);
      return this;
    }

    @Override
    protected final Entry_Select.Entry_SelectEndJSON getThis() {
      return this;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at ASC</strong> */
    public final Entry_Select.Entry_SelectEndJSON orderByCreatedAtAscending() {
      where.orderBy(QueryBuilder.asc("created_at"));
      return this;
    }

    /**
     * Generate a SELECT ... FROM ... WHERE ... <strong>ORDER BY created_at DESC</strong> */
    public final Entry_Select.Entry_SelectEndJSON orderByCreatedAtDescending() {
      where.orderBy(QueryBuilder.desc("created_at"));
      return this;
    }
  }
}
