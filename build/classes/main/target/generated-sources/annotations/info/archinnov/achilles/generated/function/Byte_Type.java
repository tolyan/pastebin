package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Byte;
import java.lang.Override;
import java.util.Optional;

public abstract class Byte_Type extends AbstractCQLCompatibleType<Byte> implements FunctionCall {
  protected Byte_Type(final Optional<Byte> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
