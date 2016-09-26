package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Integer;
import java.lang.Override;
import java.util.Optional;

public abstract class Integer_Type extends AbstractCQLCompatibleType<Integer> implements FunctionCall {
  protected Integer_Type(final Optional<Integer> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
