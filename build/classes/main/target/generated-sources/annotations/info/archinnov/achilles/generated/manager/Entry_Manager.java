package info.archinnov.achilles.generated.manager;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.RegularStatement;
import info.archinnov.achilles.generated.dsl.Entry_Delete;
import info.archinnov.achilles.generated.dsl.Entry_Select;
import info.archinnov.achilles.generated.dsl.Entry_Update;
import info.archinnov.achilles.generated.meta.entity.Entry_AchillesMeta;
import info.archinnov.achilles.internals.dsl.crud.DeleteByPartitionWithOptions;
import info.archinnov.achilles.internals.dsl.crud.DeleteWithOptions;
import info.archinnov.achilles.internals.dsl.crud.FindWithOptions;
import info.archinnov.achilles.internals.dsl.crud.InsertJSONWithOptions;
import info.archinnov.achilles.internals.dsl.crud.InsertWithOptions;
import info.archinnov.achilles.internals.dsl.raw.NativeQuery;
import info.archinnov.achilles.internals.dsl.raw.TypedQuery;
import info.archinnov.achilles.internals.runtime.AbstractManager;
import info.archinnov.achilles.internals.runtime.RuntimeEngine;
import info.archinnov.achilles.validation.Validator;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import ru.anglerhood.pastebin.Entry;

public final class Entry_Manager extends AbstractManager<Entry> {
  public final Entry_AchillesMeta meta;

  public Entry_Manager(final Class<Entry> entityClass, final Entry_AchillesMeta meta, final RuntimeEngine rte) {
    super(entityClass, meta, rte);
    this.meta = meta;
  }

  /**
   * Provide CRUD operations: <br/> 
   * <ul>
   *    <li>FIND BY ID</li>
   *    <li>INSERT</li>
   *    <li>INSERT STATIC</li>
   *    <li>INSERT IF NOT EXISTS</li>
   *    <li>DELETE BY ID</li>
   *    <li>DELETE BY ID IF NOT EXISTS</li>
   *    <li>DELETE BY PARTITION</li>
   * </ul>
   */
  public final Entry_CRUD crud() {
    return new Entry_CRUD();
  }

  /**
   * Provide DSL methods: <br/>
   * <ul>
   *    <li>SELECT</li>
   *    <li>ITERATION ON SELECT</li>
   *    <li>UPDATE</li>
   *    <li>DELETE</li>
   * </ul>
   */
  public final Entry_DSL dsl() {
    return new Entry_DSL();
  }

  /**
   * Provide Raw query methods: <br/>
   * <ul>
   *    <li>Typed Queries (for SELECT only)</li>
   *    <li>Native Queries (for any kind of statement)</li>
   * </ul>
   */
  public final Entry_RAW_QUERY raw() {
    return new Entry_RAW_QUERY();
  }

  public final class Entry_CRUD {
    /**
     * Find an entity by its complete primary key@param isPrivate partition key 'isPrivate'@param createdAt clustering column 'createdAt'@return FindWithOptions<Entry> */
    public FindWithOptions<Entry> findById(final Boolean isPrivate, final Date createdAt) {
      List<Object> keys = new ArrayList<>();
      List<Object> encodedKeys = new ArrayList<>();
      Validator.validateNotNull(isPrivate, "Partition key '%s' should not be null", "isPrivate");
      keys.add(isPrivate);
      encodedKeys.add(Entry_AchillesMeta.isPrivate.encodeFromJava(isPrivate));
      Validator.validateNotNull(createdAt, "Partition key '%s' should not be null", "createdAt");
      keys.add(createdAt);
      encodedKeys.add(Entry_AchillesMeta.createdAt.encodeFromJava(createdAt));
      final Object[] primaryKeyValues = keys.toArray();
      final Object[] encodedPrimaryKeyValues = encodedKeys.toArray();
      return new FindWithOptions<Entry>(entityClass, meta, rte, primaryKeyValues, encodedPrimaryKeyValues);
    }

    /**
     * Delete an entity instance by extracting its primary keyRemark: <strong>Achilles will throw an exception if any column being part of the primary key is NULL</strong>@param an instance of Entry to be delete@return DeleteWithOptions<Entry> */
    public DeleteWithOptions<Entry> delete(final Entry instance) {
      return deleteInternal(instance);
    }

    /**
     * Delete an entity using its complete primary key@param isPrivate partition key 'isPrivate'@param createdAt clustering column 'createdAt'@return DeleteWithOptions<Entry> */
    public DeleteWithOptions<Entry> deleteById(final Boolean isPrivate, final Date createdAt) {
      List<Object> keys = new ArrayList<>();
      List<Object> encodedKeys = new ArrayList<>();
      Validator.validateNotNull(isPrivate, "Partition key '%s' should not be null", "isPrivate");
      keys.add(isPrivate);
      encodedKeys.add(Entry_AchillesMeta.isPrivate.encodeFromJava(isPrivate));
      Validator.validateNotNull(createdAt, "Partition key '%s' should not be null", "createdAt");
      keys.add(createdAt);
      encodedKeys.add(Entry_AchillesMeta.createdAt.encodeFromJava(createdAt));
      final Object[] partitionKeysValues = keys.toArray();
      final Object[] encodedPartitionKeyValues = encodedKeys.toArray();
      return new DeleteWithOptions<Entry>(entityClass, meta, rte, partitionKeysValues, encodedPartitionKeyValues, Optional.empty());
    }

    /**
     * Insert this entity
     *
     * @param instance an instance of Entry
     * @return InsertWithOptions<Entry> */
    public final InsertWithOptions<Entry> insert(final Entry instance) {
      return insertInternal(instance, false);
    }

    /**
     * Delete a whole partition using the partition key@param isPrivate partition key 'isPrivate'@return DeleteByPartitionWithOptions<Entry> */
    public DeleteByPartitionWithOptions<Entry> deleteByPartitionKeys(final Boolean isPrivate) {
      List<Object> keys = new ArrayList<>();
      List<Object> encodedKeys = new ArrayList<>();
      Validator.validateNotNull(isPrivate, "Partition key '%s' should not be null", "isPrivate");
      keys.add(isPrivate);
      encodedKeys.add(Entry_AchillesMeta.isPrivate.encodeFromJava(isPrivate));
      final Object[] partitionKeys = keys.toArray();
      final Object[] encodedPartitionKeys = encodedKeys.toArray();
      return new DeleteByPartitionWithOptions<Entry>(meta, rte, partitionKeys, encodedPartitionKeys);
    }

    /**
     * Insert using a JSON payload
     *
     * @json the JSON string representing an instance of Entry
     * @return InsertJSONWithOptions */
    public final InsertJSONWithOptions insertJSON(final String json) {
      return insertJSONInternal(json);
    }
  }

  public final class Entry_DSL {
    /**
     * Generate a <strong>SELECT</strong> statement@return Entry_Select */
    public final Entry_Select select() {
      return new Entry_Select(rte, meta);
    }

    /**
     * Generate a <strong>DELETE</strong> statement@return Entry_Delete */
    public final Entry_Delete delete() {
      return new Entry_Delete(rte, meta);
    }

    /**
     * Generate an <strong>UPDATE</strong> statement@return Entry_Update */
    public final Entry_Update update() {
      return new Entry_Update(rte, meta);
    }
  }

  public final class Entry_RAW_QUERY {
    /**
     * Execute the bound statement and map the result back into an instance of Entry <br/>
     * Remark: the bound statement should be a <strong>SELECT</strong> statement@param boundStatement a bound statement@return TypedQuery<Entry> */
    public final TypedQuery<Entry> typedQueryForSelect(BoundStatement boundStatement) {
      return typedQueryForSelectInternal(boundStatement);
    }

    /**
     * Execute the prepared statement and map the result back into an instance of Entry <br/>
     * Remark: the prepared statement should be a <strong>SELECT</strong> statement@param preparedStatement a prepared statement@return TypedQuery<Entry> */
    public final TypedQuery<Entry> typedQueryForSelect(PreparedStatement preparedStatement, Object... encodedBoundValues) {
      return typedQueryForSelectInternal(preparedStatement, encodedBoundValues);
    }

    /**
     * Execute the regular statement and map the result back into an instance of Entry <br/>
     * Remark: the regular statement should be a <strong>SELECT</strong> statement@param regularStatement a regular statement@return TypedQuery<Entry> */
    public final TypedQuery<Entry> typedQueryForSelect(RegularStatement regularStatement, Object... encodedBoundValues) {
      return typedQueryForSelectInternal(regularStatement, encodedBoundValues);
    }

    /**
     * Execute the native bound statement@param boundStatement a bound statement@return NativeQuery */
    public final NativeQuery nativeQuery(BoundStatement boundStatement) {
      return nativeQueryInternal(boundStatement);
    }

    /**
     * Execute the native prepared statement@param preparedStatement a prepared statement@return NativeQuery */
    public final NativeQuery nativeQuery(PreparedStatement preparedStatement, Object... encodedBoundValues) {
      return nativeQueryInternal(preparedStatement, encodedBoundValues);
    }

    /**
     * Execute the native regular statement@param regularStatement a regular statement@return NativeQuery */
    public final NativeQuery nativeQuery(RegularStatement regularStatement, Object... encodedBoundValues) {
      return nativeQueryInternal(regularStatement, encodedBoundValues);
    }
  }
}
