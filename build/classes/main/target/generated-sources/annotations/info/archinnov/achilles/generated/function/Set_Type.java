package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.lang.SuppressWarnings;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings("rawtypes")
public abstract class Set_Type extends AbstractCQLCompatibleType<Set> implements FunctionCall {
  protected Set_Type(final Optional<Set> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
