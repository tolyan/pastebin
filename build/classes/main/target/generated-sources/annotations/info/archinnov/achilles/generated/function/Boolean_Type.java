package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Boolean;
import java.lang.Override;
import java.util.Optional;

public abstract class Boolean_Type extends AbstractCQLCompatibleType<Boolean> implements FunctionCall {
  protected Boolean_Type(final Optional<Boolean> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
