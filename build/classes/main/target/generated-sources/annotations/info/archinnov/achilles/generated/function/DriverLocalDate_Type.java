package info.archinnov.achilles.generated.function;

import com.datastax.driver.core.LocalDate;
import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.util.Optional;

public abstract class DriverLocalDate_Type extends AbstractCQLCompatibleType<LocalDate> implements FunctionCall {
  protected DriverLocalDate_Type(final Optional<LocalDate> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
