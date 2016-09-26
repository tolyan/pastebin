package info.archinnov.achilles.generated.function;

import com.datastax.driver.core.TupleValue;
import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.util.Optional;

public abstract class TupleValue_Type extends AbstractCQLCompatibleType<TupleValue> implements FunctionCall {
  protected TupleValue_Type(final Optional<TupleValue> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
