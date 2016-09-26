package info.archinnov.achilles.generated.dsl;

import com.datastax.driver.core.querybuilder.NotEq;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Update;
import info.archinnov.achilles.generated.meta.entity.Entry_AchillesMeta;
import info.archinnov.achilles.internals.dsl.query.update.AbstractUpdate;
import info.archinnov.achilles.internals.dsl.query.update.AbstractUpdateColumns;
import info.archinnov.achilles.internals.dsl.query.update.AbstractUpdateEnd;
import info.archinnov.achilles.internals.dsl.query.update.AbstractUpdateFrom;
import info.archinnov.achilles.internals.dsl.query.update.AbstractUpdateWhere;
import info.archinnov.achilles.internals.metamodel.AbstractEntityProperty;
import info.archinnov.achilles.internals.options.Options;
import info.archinnov.achilles.internals.runtime.RuntimeEngine;
import info.archinnov.achilles.type.SchemaNameProvider;
import info.archinnov.achilles.validation.Validator;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;
import ru.anglerhood.pastebin.Entry;

public final class Entry_Update extends AbstractUpdate {
  protected final Entry_AchillesMeta meta;

  protected final Class<Entry> entityClass = Entry.class;

  public Entry_Update(RuntimeEngine rte, Entry_AchillesMeta meta) {
    super(rte);
    this.meta = meta;
  }

  /**
   * Generate an UPDATE <strong>FROM</strong> ... */
  public final Entry_Update.Entry_UpdateFrom fromBaseTable() {
    final String currentKeyspace = meta.getKeyspace().orElse("unknown_keyspace_for_" + meta.entityClass.getCanonicalName());
    final Update.Where where = QueryBuilder.update(currentKeyspace, meta.getTableOrViewName()).where();
    return new Entry_Update.Entry_UpdateFrom(where);
  }

  /**
   * Generate an UPDATE <strong>FROM</strong> ... using the given SchemaNameProvider */
  public final Entry_Update.Entry_UpdateFrom from(final SchemaNameProvider schemaNameProvider) {
    final String currentKeyspace = lookupKeyspace(schemaNameProvider, meta.entityClass);
    final String currentTable = lookupTable(schemaNameProvider, meta.entityClass);
    final Update.Where where = QueryBuilder.update(currentKeyspace, currentTable).where();
    return new Entry_Update.Entry_UpdateFrom(where);
  }

  public class Entry_UpdateColumns extends AbstractUpdateColumns {
    Entry_UpdateColumns(Update.Where where) {
      super(where);
    }

    public final Entry_UpdateColumns.ModifiedAt_Relation modifiedAt() {
      return new Entry_UpdateColumns.ModifiedAt_Relation();
    }

    public final Entry_UpdateColumns.Expires_Relation expires() {
      return new Entry_UpdateColumns.Expires_Relation();
    }

    public final Entry_UpdateColumns.Uuid_Relation uuid() {
      return new Entry_UpdateColumns.Uuid_Relation();
    }

    public final Entry_Update.Entry_UpdateWhere_IsPrivate where() {
      return new Entry_Update.Entry_UpdateWhere_IsPrivate(where);
    }

    public final class ModifiedAt_Relation {
      /**
       * Generate an UPDATE FROM ... <strong>SET modified_at = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateColumns Set(final Date modifiedAt) {
        where.with(QueryBuilder.set("modified_at", QueryBuilder.bindMarker("modified_at")));
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        return Entry_Update.Entry_UpdateColumns.this;
      }

      /**
       * Generate an UPDATE FROM ... <strong>SET modified_at = fromJson(?)</strong> */
      public final Entry_Update.Entry_UpdateColumns Set_FromJSON(final String modifiedAt) {
        where.with(QueryBuilder.set("modified_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("modified_at"))));
        boundValues.add(modifiedAt);
        encodedValues.add(modifiedAt);
        return Entry_Update.Entry_UpdateColumns.this;
      }
    }

    public final class Expires_Relation {
      /**
       * Generate an UPDATE FROM ... <strong>SET expires_at = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateColumns Set(final Date expires) {
        where.with(QueryBuilder.set("expires_at", QueryBuilder.bindMarker("expires_at")));
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        return Entry_Update.Entry_UpdateColumns.this;
      }

      /**
       * Generate an UPDATE FROM ... <strong>SET expires_at = fromJson(?)</strong> */
      public final Entry_Update.Entry_UpdateColumns Set_FromJSON(final String expires) {
        where.with(QueryBuilder.set("expires_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("expires_at"))));
        boundValues.add(expires);
        encodedValues.add(expires);
        return Entry_Update.Entry_UpdateColumns.this;
      }
    }

    public final class Uuid_Relation {
      /**
       * Generate an UPDATE FROM ... <strong>SET entry_uuid = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateColumns Set(final UUID uuid) {
        where.with(QueryBuilder.set("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        return Entry_Update.Entry_UpdateColumns.this;
      }

      /**
       * Generate an UPDATE FROM ... <strong>SET entry_uuid = fromJson(?)</strong> */
      public final Entry_Update.Entry_UpdateColumns Set_FromJSON(final String uuid) {
        where.with(QueryBuilder.set("entry_uuid", QueryBuilder.fromJson(QueryBuilder.bindMarker("entry_uuid"))));
        boundValues.add(uuid);
        encodedValues.add(uuid);
        return Entry_Update.Entry_UpdateColumns.this;
      }
    }
  }

  public class Entry_UpdateFrom extends AbstractUpdateFrom {
    Entry_UpdateFrom(Update.Where where) {
      super(where);
    }

    public final Entry_UpdateFrom.ModifiedAt_Relation modifiedAt() {
      return new Entry_UpdateFrom.ModifiedAt_Relation();
    }

    public final Entry_UpdateFrom.Expires_Relation expires() {
      return new Entry_UpdateFrom.Expires_Relation();
    }

    public final Entry_UpdateFrom.Uuid_Relation uuid() {
      return new Entry_UpdateFrom.Uuid_Relation();
    }

    public final class ModifiedAt_Relation {
      /**
       * Generate an UPDATE FROM ... <strong>SET modified_at = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateColumns Set(final Date modifiedAt) {
        where.with(QueryBuilder.set("modified_at", QueryBuilder.bindMarker("modified_at")));
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        return new Entry_Update.Entry_UpdateColumns(where);
      }

      /**
       * Generate an UPDATE FROM ... <strong>SET modified_at = fromJson(?)</strong> */
      public final Entry_Update.Entry_UpdateColumns Set_FromJSON(final String modifiedAt) {
        where.with(QueryBuilder.set("modified_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("modified_at"))));
        boundValues.add(modifiedAt);
        encodedValues.add(modifiedAt);
        return new Entry_Update.Entry_UpdateColumns(where);
      }
    }

    public final class Expires_Relation {
      /**
       * Generate an UPDATE FROM ... <strong>SET expires_at = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateColumns Set(final Date expires) {
        where.with(QueryBuilder.set("expires_at", QueryBuilder.bindMarker("expires_at")));
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        return new Entry_Update.Entry_UpdateColumns(where);
      }

      /**
       * Generate an UPDATE FROM ... <strong>SET expires_at = fromJson(?)</strong> */
      public final Entry_Update.Entry_UpdateColumns Set_FromJSON(final String expires) {
        where.with(QueryBuilder.set("expires_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("expires_at"))));
        boundValues.add(expires);
        encodedValues.add(expires);
        return new Entry_Update.Entry_UpdateColumns(where);
      }
    }

    public final class Uuid_Relation {
      /**
       * Generate an UPDATE FROM ... <strong>SET entry_uuid = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateColumns Set(final UUID uuid) {
        where.with(QueryBuilder.set("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        return new Entry_Update.Entry_UpdateColumns(where);
      }

      /**
       * Generate an UPDATE FROM ... <strong>SET entry_uuid = fromJson(?)</strong> */
      public final Entry_Update.Entry_UpdateColumns Set_FromJSON(final String uuid) {
        where.with(QueryBuilder.set("entry_uuid", QueryBuilder.fromJson(QueryBuilder.bindMarker("entry_uuid"))));
        boundValues.add(uuid);
        encodedValues.add(uuid);
        return new Entry_Update.Entry_UpdateColumns(where);
      }
    }
  }

  public final class Entry_UpdateWhere_IsPrivate extends AbstractUpdateWhere {
    public Entry_UpdateWhere_IsPrivate(Update.Where where) {
      super(where);
    }

    public final Entry_Update.Entry_UpdateWhere_IsPrivate.Relation isPrivate() {
      return new Entry_Update.Entry_UpdateWhere_IsPrivate.Relation();
    }

    public final class Relation {
      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateWhere_CreatedAt Eq(Boolean isPrivate) {
        where.and(QueryBuilder.eq("is_private", QueryBuilder.bindMarker("is_private")));
        boundValues.add(isPrivate);
        encodedValues.add(meta.isPrivate.encodeFromJava(isPrivate));
        return new Entry_Update.Entry_UpdateWhere_CreatedAt(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private IN ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateWhere_CreatedAt IN(Boolean... isPrivate) {
        Validator.validateTrue(ArrayUtils.isNotEmpty(isPrivate), "Varargs for field '%s' should not be null/empty", "isPrivate");
        where.and(QueryBuilder.in("is_private",QueryBuilder.bindMarker("is_private")));
        final List<Object> varargs = Arrays.<Object>asList((Object[])isPrivate);
        final List<Object> encodedVarargs = Arrays.<Boolean>stream((Boolean[])isPrivate).map(x -> meta.isPrivate.encodeFromJava(x)).collect(Collectors.toList());
        boundValues.add(varargs);
        encodedValues.add(encodedVarargs);
        return new Entry_Update.Entry_UpdateWhere_CreatedAt(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private  = fromJson(?) </strong> */
      public final Entry_Update.Entry_UpdateWhere_CreatedAt Eq_FromJson(String isPrivate) {
        where.and(QueryBuilder.eq("is_private", QueryBuilder.fromJson(QueryBuilder.bindMarker("is_private"))));
        boundValues.add(isPrivate);
        encodedValues.add(isPrivate);
        return new Entry_Update.Entry_UpdateWhere_CreatedAt(where);
      }
    }
  }

  public final class Entry_UpdateWhere_CreatedAt extends AbstractUpdateWhere {
    public Entry_UpdateWhere_CreatedAt(Update.Where where) {
      super(where);
    }

    public final Entry_Update.Entry_UpdateWhere_CreatedAt.Relation createdAt() {
      return new Entry_Update.Entry_UpdateWhere_CreatedAt.Relation();
    }

    public final class Relation {
      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Eq(Date createdAt) {
        where.and(QueryBuilder.eq("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Update.Entry_UpdateEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at  = fromJson(?) </strong> */
      public final Entry_Update.Entry_UpdateEnd Eq_FromJson(String createdAt) {
        where.and(QueryBuilder.eq("created_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("created_at"))));
        boundValues.add(createdAt);
        encodedValues.add(createdAt);
        return new Entry_Update.Entry_UpdateEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at IN ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd IN(Date... createdAt) {
        Validator.validateTrue(ArrayUtils.isNotEmpty(createdAt), "Varargs for field '%s' should not be null/empty", "createdAt");
        where.and(QueryBuilder.in("created_at",QueryBuilder.bindMarker("created_at")));
        final List<Object> varargs = Arrays.<Object>asList((Object[])createdAt);
        final List<Object> encodedVarargs = Arrays.<Date>stream((Date[])createdAt).map(x -> meta.createdAt.encodeFromJava(x)).collect(Collectors.toList());
        boundValues.add(varargs);
        encodedValues.add(encodedVarargs);
        return new Entry_Update.Entry_UpdateEnd(where);
      }
    }
  }

  public final class Entry_UpdateEnd extends AbstractUpdateEnd<Entry_Update.Entry_UpdateEnd, Entry> {
    public Entry_UpdateEnd(Update.Where where) {
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

    @Override
    protected final Entry_Update.Entry_UpdateEnd getThis() {
      return this;
    }

    public final Entry_UpdateEnd.If_ModifiedAt if_ModifiedAt() {
      return new Entry_UpdateEnd.If_ModifiedAt();
    }

    public final Entry_UpdateEnd.If_Expires if_Expires() {
      return new Entry_UpdateEnd.If_Expires();
    }

    public final Entry_UpdateEnd.If_Uuid if_Uuid() {
      return new Entry_UpdateEnd.If_Uuid();
    }

    public final class If_ModifiedAt {
      /**
       * Generate an ... <strong>IF modifiedAt = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Eq(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(QueryBuilder.eq("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF modifiedAt > ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Gt(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(QueryBuilder.gt("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF modifiedAt >= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Gte(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(QueryBuilder.gte("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF modifiedAt < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Lt(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(QueryBuilder.lt("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF modifiedAt <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Lte(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(QueryBuilder.lte("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an  ... <strong>IF modifiedAt != ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd NotEq(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(NotEq.of("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF modifiedAt = fromJson(?)</strong> */
      public final Entry_Update.Entry_UpdateEnd Eq_FromJSON(final String modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(modifiedAt);
        where.onlyIf(QueryBuilder.eq("modified_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("modified_at"))));
        return Entry_Update.Entry_UpdateEnd.this;
      }
    }

    public final class If_Expires {
      /**
       * Generate an ... <strong>IF expires = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Eq(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(QueryBuilder.eq("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF expires > ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Gt(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(QueryBuilder.gt("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF expires >= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Gte(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(QueryBuilder.gte("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF expires < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Lt(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(QueryBuilder.lt("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF expires <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Lte(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(QueryBuilder.lte("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an  ... <strong>IF expires != ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd NotEq(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(NotEq.of("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF expires = fromJson(?)</strong> */
      public final Entry_Update.Entry_UpdateEnd Eq_FromJSON(final String expires) {
        boundValues.add(expires);
        encodedValues.add(expires);
        where.onlyIf(QueryBuilder.eq("expires_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("expires_at"))));
        return Entry_Update.Entry_UpdateEnd.this;
      }
    }

    public final class If_Uuid {
      /**
       * Generate an ... <strong>IF uuid = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Eq(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(QueryBuilder.eq("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF uuid > ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Gt(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(QueryBuilder.gt("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF uuid >= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Gte(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(QueryBuilder.gte("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF uuid < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Lt(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(QueryBuilder.lt("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF uuid <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd Lte(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(QueryBuilder.lte("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an  ... <strong>IF uuid != ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Update.Entry_UpdateEnd NotEq(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(NotEq.of("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Update.Entry_UpdateEnd.this;
      }

      /**
       * Generate an ... <strong>IF uuid = fromJson(?)</strong> */
      public final Entry_Update.Entry_UpdateEnd Eq_FromJSON(final String uuid) {
        boundValues.add(uuid);
        encodedValues.add(uuid);
        where.onlyIf(QueryBuilder.eq("entry_uuid", QueryBuilder.fromJson(QueryBuilder.bindMarker("entry_uuid"))));
        return Entry_Update.Entry_UpdateEnd.this;
      }
    }
  }
}
