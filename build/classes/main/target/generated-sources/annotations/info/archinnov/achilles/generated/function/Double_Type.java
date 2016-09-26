package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Double;
import java.lang.Override;
import java.util.Optional;

public abstract class Double_Type extends AbstractCQLCompatibleType<Double> implements FunctionCall {
  protected Double_Type(final Optional<Double> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
