package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.math.BigInteger;
import java.util.Optional;

public abstract class BigInteger_Type extends AbstractCQLCompatibleType<BigInteger> implements FunctionCall {
  protected BigInteger_Type(final Optional<BigInteger> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
