package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Long;
import java.lang.Override;
import java.util.Optional;

public abstract class Long_Type extends AbstractCQLCompatibleType<Long> implements FunctionCall {
  protected Long_Type(final Optional<Long> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
