package info.archinnov.achilles.generated.function;

import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import java.lang.Override;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("rawtypes")
public abstract class List_Type extends AbstractCQLCompatibleType<List> implements FunctionCall {
  protected List_Type(final Optional<List> value) {
    this.value = value;
  }

  @Override
  public boolean isFunctionCall() {
    return false;
  }
}
