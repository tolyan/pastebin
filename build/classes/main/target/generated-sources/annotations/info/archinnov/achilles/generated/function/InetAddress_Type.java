package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.net.InetAddress;
import java.util.Optional;

public abstract class InetAddress_Type extends AbstractCQLCompatibleType<InetAddress> implements FunctionCall {
  protected InetAddress_Type(final Optional<InetAddress> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
