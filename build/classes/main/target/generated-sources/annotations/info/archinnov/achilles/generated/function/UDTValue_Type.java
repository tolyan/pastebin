package info.archinnov.achilles.generated.function;

import com.datastax.driver.core.UDTValue;
import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.util.Optional;

public abstract class UDTValue_Type extends AbstractCQLCompatibleType<UDTValue> implements FunctionCall {
  protected UDTValue_Type(final Optional<UDTValue> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
