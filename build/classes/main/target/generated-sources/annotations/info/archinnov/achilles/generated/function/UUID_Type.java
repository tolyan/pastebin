package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.util.Optional;
import java.util.UUID;

public abstract class UUID_Type extends AbstractCQLCompatibleType<UUID> implements FunctionCall {
  protected UUID_Type(final Optional<UUID> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
