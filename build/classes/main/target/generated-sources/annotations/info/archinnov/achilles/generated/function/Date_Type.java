package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.util.Date;
import java.util.Optional;

public abstract class Date_Type extends AbstractCQLCompatibleType<Date> implements FunctionCall {
  protected Date_Type(final Optional<Date> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
