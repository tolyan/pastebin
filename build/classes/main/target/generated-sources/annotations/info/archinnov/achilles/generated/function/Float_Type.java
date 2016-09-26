package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Float;
import java.lang.Override;
import java.util.Optional;

public abstract class Float_Type extends AbstractCQLCompatibleType<Float> implements FunctionCall {
  protected Float_Type(final Optional<Float> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
