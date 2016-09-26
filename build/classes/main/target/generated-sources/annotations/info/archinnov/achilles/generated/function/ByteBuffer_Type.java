package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.nio.ByteBuffer;
import java.util.Optional;

public abstract class ByteBuffer_Type extends AbstractCQLCompatibleType<ByteBuffer> implements FunctionCall {
  protected ByteBuffer_Type(final Optional<ByteBuffer> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
