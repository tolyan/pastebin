package info.archinnov.achilles.generated.dsl;

import com.datastax.driver.core.querybuilder.Delete;
import com.datastax.driver.core.querybuilder.NotEq;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import info.archinnov.achilles.generated.meta.entity.Entry_AchillesMeta;
import info.archinnov.achilles.internals.dsl.query.delete.AbstractDelete;
import info.archinnov.achilles.internals.dsl.query.delete.AbstractDeleteColumns;
import info.archinnov.achilles.internals.dsl.query.delete.AbstractDeleteEnd;
import info.archinnov.achilles.internals.dsl.query.delete.AbstractDeleteFrom;
import info.archinnov.achilles.internals.dsl.query.delete.AbstractDeleteWhere;
import info.archinnov.achilles.internals.dsl.query.delete.AbstractDeleteWherePartition;
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

public final class Entry_Delete extends AbstractDelete {
  protected final Entry_AchillesMeta meta;

  protected final Class<Entry> entityClass = Entry.class;

  public Entry_Delete(RuntimeEngine rte, Entry_AchillesMeta meta) {
    super(rte);
    this.meta = meta;
  }

  /**
   * Generate DELETE <strong>modified_at</strong> ... */
  public final Entry_Delete.Entry_DeleteColumns modifiedAt() {
    delete.column("modified_at");
    return new Entry_Delete.Entry_DeleteColumns(delete);
  }

  /**
   * Generate DELETE <strong>expires_at</strong> ... */
  public final Entry_Delete.Entry_DeleteColumns expires() {
    delete.column("expires_at");
    return new Entry_Delete.Entry_DeleteColumns(delete);
  }

  /**
   * Generate DELETE <strong>entry_uuid</strong> ... */
  public final Entry_Delete.Entry_DeleteColumns uuid() {
    delete.column("entry_uuid");
    return new Entry_Delete.Entry_DeleteColumns(delete);
  }

  /**
   * Generate ... * FROM ... */
  public final Entry_Delete.Entry_DeleteFrom allColumns_FromBaseTable() {
    final Delete.Where where = delete.all().from(meta.getKeyspace().orElse("unknown_keyspace_for_" + meta.entityClass.getCanonicalName()), meta.getTableOrViewName()).where();
    return new Entry_Delete.Entry_DeleteFrom(where);
  }

  /**
   * Generate ... * FROM ... using the given SchemaNameProvider */
  public final Entry_Delete.Entry_DeleteFrom allColumns_From(final SchemaNameProvider schemaNameProvider) {
    final String currentKeyspace = lookupKeyspace(schemaNameProvider, meta.entityClass);
    final String currentTable = lookupTable(schemaNameProvider, meta.entityClass);
    final Delete.Where where = delete.all().from(currentKeyspace, currentTable).where();
    return new Entry_Delete.Entry_DeleteFrom(where);
  }

  public class Entry_DeleteColumns extends AbstractDeleteColumns {
    Entry_DeleteColumns(Delete.Selection deleteColumns) {
      super(deleteColumns);
    }

    /**
     * Generate DELETE <strong>modified_at</strong> ... */
    public final Entry_Delete.Entry_DeleteColumns modifiedAt() {
      delete.column("modified_at");
      return this;
    }

    /**
     * Generate DELETE <strong>expires_at</strong> ... */
    public final Entry_Delete.Entry_DeleteColumns expires() {
      delete.column("expires_at");
      return this;
    }

    /**
     * Generate DELETE <strong>entry_uuid</strong> ... */
    public final Entry_Delete.Entry_DeleteColumns uuid() {
      delete.column("entry_uuid");
      return this;
    }

    /**
     * Generate a ... <strong>FROM xxx</strong> ...  */
    public final Entry_Delete.Entry_DeleteFrom fromBaseTable() {
      final Delete.Where where = deleteColumns.from(meta.getKeyspace().orElse("unknown_keyspace_for_" + meta.entityClass.getCanonicalName()), meta.getTableOrViewName()).where();
      return new Entry_Delete.Entry_DeleteFrom(where);
    }

    /**
     * Generate a ... <strong>FROM xxx</strong> ... using the given SchemaNameProvider */
    public final Entry_Delete.Entry_DeleteFrom from(final SchemaNameProvider schemaNameProvider) {
      final String currentKeyspace = lookupKeyspace(schemaNameProvider, meta.entityClass);
      final String currentTable = lookupTable(schemaNameProvider, meta.entityClass);
      final Delete.Where where = deleteColumns.from(currentKeyspace, currentTable).where();
      return new Entry_Delete.Entry_DeleteFrom(where);
    }
  }

  public class Entry_DeleteFrom extends AbstractDeleteFrom {
    Entry_DeleteFrom(Delete.Where where) {
      super(where);
    }

    public final Entry_Delete.Entry_DeleteWhere_IsPrivate where() {
      return new Entry_Delete.Entry_DeleteWhere_IsPrivate(where);
    }
  }

  public final class Entry_DeleteWhere_IsPrivate extends AbstractDeleteWherePartition {
    public Entry_DeleteWhere_IsPrivate(Delete.Where where) {
      super(where);
    }

    public final Entry_Delete.Entry_DeleteWhere_IsPrivate.Relation isPrivate() {
      return new Entry_Delete.Entry_DeleteWhere_IsPrivate.Relation();
    }

    public final class Relation {
      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteWhere_CreatedAt Eq(Boolean isPrivate) {
        where.and(QueryBuilder.eq("is_private", QueryBuilder.bindMarker("is_private")));
        boundValues.add(isPrivate);
        encodedValues.add(meta.isPrivate.encodeFromJava(isPrivate));
        return new Entry_Delete.Entry_DeleteWhere_CreatedAt(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private IN ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteWhere_CreatedAt IN(Boolean... isPrivate) {
        Validator.validateTrue(ArrayUtils.isNotEmpty(isPrivate), "Varargs for field '%s' should not be null/empty", "isPrivate");
        where.and(QueryBuilder.in("is_private",QueryBuilder.bindMarker("is_private")));
        final List<Object> varargs = Arrays.<Object>asList((Object[])isPrivate);
        final List<Object> encodedVarargs = Arrays.<Boolean>stream((Boolean[])isPrivate).map(x -> meta.isPrivate.encodeFromJava(x)).collect(Collectors.toList());
        boundValues.add(varargs);
        encodedValues.add(encodedVarargs);
        return new Entry_Delete.Entry_DeleteWhere_CreatedAt(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>is_private  = fromJson(?) </strong> */
      public final Entry_Delete.Entry_DeleteWhere_CreatedAt Eq_FromJson(String isPrivate) {
        where.and(QueryBuilder.eq("is_private", QueryBuilder.fromJson(QueryBuilder.bindMarker("is_private"))));
        boundValues.add(isPrivate);
        encodedValues.add(isPrivate);
        return new Entry_Delete.Entry_DeleteWhere_CreatedAt(where);
      }
    }
  }

  public final class Entry_DeleteWhere_CreatedAt extends AbstractDeleteWhere {
    public Entry_DeleteWhere_CreatedAt(Delete.Where where) {
      super(where);
    }

    public final Entry_Delete.Entry_DeleteWhere_CreatedAt.Relation createdAt() {
      return new Entry_Delete.Entry_DeleteWhere_CreatedAt.Relation();
    }

    public final class Relation {
      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Eq(Date createdAt) {
        where.and(QueryBuilder.eq("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Delete.Entry_DeleteEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at  = fromJson(?) </strong> */
      public final Entry_Delete.Entry_DeleteEnd Eq_FromJson(String createdAt) {
        where.and(QueryBuilder.eq("created_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("created_at"))));
        boundValues.add(createdAt);
        encodedValues.add(createdAt);
        return new Entry_Delete.Entry_DeleteEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at IN ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd IN(Date... createdAt) {
        Validator.validateTrue(ArrayUtils.isNotEmpty(createdAt), "Varargs for field '%s' should not be null/empty", "createdAt");
        where.and(QueryBuilder.in("created_at",QueryBuilder.bindMarker("created_at")));
        final List<Object> varargs = Arrays.<Object>asList((Object[])createdAt);
        final List<Object> encodedVarargs = Arrays.<Date>stream((Date[])createdAt).map(x -> meta.createdAt.encodeFromJava(x)).collect(Collectors.toList());
        boundValues.add(varargs);
        encodedValues.add(encodedVarargs);
        return new Entry_Delete.Entry_DeleteEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gt(Date createdAt) {
        where.and(QueryBuilder.gt("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Delete.Entry_DeleteEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gte(Date createdAt) {
        where.and(QueryBuilder.gte("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Delete.Entry_DeleteEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Lt(Date createdAt) {
        where.and(QueryBuilder.lt("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Delete.Entry_DeleteEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Lte(Date createdAt) {
        where.and(QueryBuilder.lte("created_at", QueryBuilder.bindMarker("created_at")));
        boundValues.add(createdAt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt));
        return new Entry_Delete.Entry_DeleteEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ? AND created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gt_And_Lt(Date createdAt_Gt, Date createdAt_Lt) {
        where.and(QueryBuilder.gt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        where.and(QueryBuilder.lt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        boundValues.add(createdAt_Gt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gt));
        boundValues.add(createdAt_Lt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lt));
        return new Entry_Delete.Entry_DeleteEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at > ? AND created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gt_And_Lte(Date createdAt_Gt, Date createdAt_Lte) {
        where.and(QueryBuilder.gt("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        where.and(QueryBuilder.lte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        boundValues.add(createdAt_Gt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gt));
        boundValues.add(createdAt_Lte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lte));
        return new Entry_Delete.Entry_DeleteEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ? AND created_at < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gte_And_Lt(Date createdAt_Gte, Date createdAt_Lt) {
        where.and(QueryBuilder.gte("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        where.and(QueryBuilder.lt("created_at",QueryBuilder.bindMarker("created_at_Lt")));
        boundValues.add(createdAt_Gte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gte));
        boundValues.add(createdAt_Lt);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lt));
        return new Entry_Delete.Entry_DeleteEnd(where);
      }

      /**
       * Generate a SELECT ... FROM ... WHERE ... <strong>created_at >= ? AND created_at <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gte_And_Lte(Date createdAt_Gte, Date createdAt_Lte) {
        where.and(QueryBuilder.gte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        where.and(QueryBuilder.lte("created_at",QueryBuilder.bindMarker("created_at_Lte")));
        boundValues.add(createdAt_Gte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Gte));
        boundValues.add(createdAt_Lte);
        encodedValues.add(meta.createdAt.encodeFromJava(createdAt_Lte));
        return new Entry_Delete.Entry_DeleteEnd(where);
      }
    }
  }

  public final class Entry_DeleteEnd extends AbstractDeleteEnd<Entry_Delete.Entry_DeleteEnd, Entry> {
    public Entry_DeleteEnd(Delete.Where where) {
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
    protected final Entry_Delete.Entry_DeleteEnd getThis() {
      return this;
    }

    public final Entry_DeleteEnd.If_ModifiedAt if_ModifiedAt() {
      return new Entry_DeleteEnd.If_ModifiedAt();
    }

    public final Entry_DeleteEnd.If_Expires if_Expires() {
      return new Entry_DeleteEnd.If_Expires();
    }

    public final Entry_DeleteEnd.If_Uuid if_Uuid() {
      return new Entry_DeleteEnd.If_Uuid();
    }

    public final class If_ModifiedAt {
      /**
       * Generate an ... <strong>IF modifiedAt = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Eq(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(QueryBuilder.eq("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF modifiedAt > ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gt(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(QueryBuilder.gt("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF modifiedAt >= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gte(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(QueryBuilder.gte("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF modifiedAt < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Lt(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(QueryBuilder.lt("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF modifiedAt <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Lte(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(QueryBuilder.lte("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an  ... <strong>IF modifiedAt != ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd NotEq(final Date modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(meta.modifiedAt.encodeFromJava(modifiedAt));
        where.onlyIf(NotEq.of("modified_at", QueryBuilder.bindMarker("modified_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF modifiedAt = fromJson(?)</strong> */
      public final Entry_Delete.Entry_DeleteEnd Eq_FromJSON(final String modifiedAt) {
        boundValues.add(modifiedAt);
        encodedValues.add(modifiedAt);
        where.onlyIf(QueryBuilder.eq("modified_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("modified_at"))));
        return Entry_Delete.Entry_DeleteEnd.this;
      }
    }

    public final class If_Expires {
      /**
       * Generate an ... <strong>IF expires = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Eq(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(QueryBuilder.eq("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF expires > ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gt(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(QueryBuilder.gt("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF expires >= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gte(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(QueryBuilder.gte("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF expires < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Lt(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(QueryBuilder.lt("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF expires <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Lte(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(QueryBuilder.lte("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an  ... <strong>IF expires != ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd NotEq(final Date expires) {
        boundValues.add(expires);
        encodedValues.add(meta.expires.encodeFromJava(expires));
        where.onlyIf(NotEq.of("expires_at", QueryBuilder.bindMarker("expires_at")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF expires = fromJson(?)</strong> */
      public final Entry_Delete.Entry_DeleteEnd Eq_FromJSON(final String expires) {
        boundValues.add(expires);
        encodedValues.add(expires);
        where.onlyIf(QueryBuilder.eq("expires_at", QueryBuilder.fromJson(QueryBuilder.bindMarker("expires_at"))));
        return Entry_Delete.Entry_DeleteEnd.this;
      }
    }

    public final class If_Uuid {
      /**
       * Generate an ... <strong>IF uuid = ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Eq(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(QueryBuilder.eq("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF uuid > ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gt(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(QueryBuilder.gt("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF uuid >= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Gte(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(QueryBuilder.gte("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF uuid < ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Lt(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(QueryBuilder.lt("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF uuid <= ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd Lte(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(QueryBuilder.lte("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an  ... <strong>IF uuid != ?</strong> */
      @SuppressWarnings("static-access")
      public final Entry_Delete.Entry_DeleteEnd NotEq(final UUID uuid) {
        boundValues.add(uuid);
        encodedValues.add(meta.uuid.encodeFromJava(uuid));
        where.onlyIf(NotEq.of("entry_uuid", QueryBuilder.bindMarker("entry_uuid")));
        return Entry_Delete.Entry_DeleteEnd.this;
      }

      /**
       * Generate an ... <strong>IF uuid = fromJson(?)</strong> */
      public final Entry_Delete.Entry_DeleteEnd Eq_FromJSON(final String uuid) {
        boundValues.add(uuid);
        encodedValues.add(uuid);
        where.onlyIf(QueryBuilder.eq("entry_uuid", QueryBuilder.fromJson(QueryBuilder.bindMarker("entry_uuid"))));
        return Entry_Delete.Entry_DeleteEnd.this;
      }
    }
  }
}
