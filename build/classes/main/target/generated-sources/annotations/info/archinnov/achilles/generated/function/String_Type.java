package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;

public abstract class String_Type extends AbstractCQLCompatibleType<String> implements FunctionCall {
  protected String_Type(final Optional<String> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
