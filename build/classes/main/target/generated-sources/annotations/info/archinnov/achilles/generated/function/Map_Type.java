package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.lang.SuppressWarnings;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("rawtypes")
public abstract class Map_Type extends AbstractCQLCompatibleType<Map> implements FunctionCall {
  protected Map_Type(final Optional<Map> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
