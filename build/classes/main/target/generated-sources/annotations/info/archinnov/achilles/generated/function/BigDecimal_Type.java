package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.math.BigDecimal;
import java.util.Optional;

public abstract class BigDecimal_Type extends AbstractCQLCompatibleType<BigDecimal> implements FunctionCall {
  protected BigDecimal_Type(final Optional<BigDecimal> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
