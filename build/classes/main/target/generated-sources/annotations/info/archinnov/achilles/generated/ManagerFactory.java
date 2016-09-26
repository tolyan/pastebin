package info.archinnov.achilles.generated;

import com.datastax.driver.core.Cluster;
import info.archinnov.achilles.generated.manager.Entry_Manager;
import info.archinnov.achilles.generated.meta.entity.Entry_AchillesMeta;
import info.archinnov.achilles.internals.context.ConfigurationContext;
import info.archinnov.achilles.internals.metamodel.AbstractUDTClassProperty;
import info.archinnov.achilles.internals.runtime.AbstractManagerFactory;
import java.lang.Override;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import ru.anglerhood.pastebin.Entry;

public final class ManagerFactory extends AbstractManagerFactory {
  private final Entry_AchillesMeta entry_AchillesMeta = new Entry_AchillesMeta();

  private final Entry_Manager entry_Manager = new Entry_Manager(Entry.class, entry_AchillesMeta, rte);

  public ManagerFactory(final Cluster cluster, final ConfigurationContext configContext) {
    super(cluster, configContext);
    this.entityProperties = Arrays.asList(entry_AchillesMeta);
    this.functionProperties = Arrays.asList();
    this.entityClasses = this.entityProperties.stream().map(x -> x.entityClass).collect(Collectors.toList());
    bootstrap();
  }

  /**
   * Create a Manager for entity class Entry
   * @return Entry_Manager */
  public final Entry_Manager forEntry() {
    return entry_Manager;
  }

  @Override
  protected final List<AbstractUDTClassProperty<?>> getUdtClassProperties() {
    final List<AbstractUDTClassProperty<?>> list = new ArrayList<>();
    return list;
  }
}
