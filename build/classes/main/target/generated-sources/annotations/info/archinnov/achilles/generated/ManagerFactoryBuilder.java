package info.archinnov.achilles.generated;

import com.datastax.driver.core.Cluster;
import info.archinnov.achilles.bootstrap.AbstractManagerFactoryBuilder;
import info.archinnov.achilles.configuration.ConfigurationParameters;
import info.archinnov.achilles.internals.types.ConfigMap;
import java.lang.Object;
import java.lang.Override;
import java.lang.SuppressWarnings;
import java.util.Map;

public final class ManagerFactoryBuilder extends AbstractManagerFactoryBuilder<ManagerFactoryBuilder> {
  private ManagerFactoryBuilder(final Cluster cluster) {
    super(cluster);
  }

  @Override
  protected ManagerFactoryBuilder getThis() {
    return this;
  }

  /**
   * Create a @{link ManagerFactoryBuilder} instance@param cluster native @{link Cluster} object@return ManagerFactoryBuilder */
  public static ManagerFactoryBuilder builder(Cluster cluster) {
    return new ManagerFactoryBuilder(cluster);
  }

  /**
   * Build a @{link ManagerFactory} instance@param cluster native @{link Cluster} object@param configurationMap Achilles configuration map@return ManagerFactory */
  public ManagerFactory build(Cluster cluster, Map<ConfigurationParameters, Object> configurationMap) {
    return new ManagerFactory(cluster, buildConfigContext(cluster, ConfigMap.fromMap(configurationMap)));
  }

  /**
   * Build a @{link ManagerFactory} instance@return ManagerFactory */
  @SuppressWarnings("unchecked")
  public ManagerFactory build() {
    return new ManagerFactory(this.cluster, buildConfigContext(this.cluster, this.configMap));
  }
}
