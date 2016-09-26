package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.lang.Short;
import java.util.Optional;

public abstract class Short_Type extends AbstractCQLCompatibleType<Short> implements FunctionCall {
  protected Short_Type(final Optional<Short> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
