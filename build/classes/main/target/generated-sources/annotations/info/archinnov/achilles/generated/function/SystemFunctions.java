package info.archinnov.achilles.generated.function;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import info.archinnov.achilles.internals.metamodel.functions.FunctionCall;
import info.archinnov.achilles.validation.Validator;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class is the common registry for all system functions */
public final class SystemFunctions {
  /**
   * Call "token" function with given parameters */
  @SuppressWarnings("rawtypes")
  public static final <T extends AbstractCQLCompatibleType & FunctionCall> Long_Type token(final T input) {
    final List<Object> params = new ArrayList<>();
    Validator.validateFalse(input.isFunctionCall(), "Invalid argument for 'token' function, it does not accept function call as argument, only simple column");
    Validator.validateFalse(input.hasLiteralValue(), "Invalid argument for 'token' function, it does not accept literal value as argument, only simple column");
    params.add(QueryBuilder.column((String)input.getValue()));
    return new Long_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "token";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "writetime" function with given parameters */
  @SuppressWarnings("rawtypes")
  public static final <T extends AbstractCQLCompatibleType & FunctionCall> Long_Type writetime(final T input) {
    final List<Object> params = new ArrayList<>();
    Validator.validateFalse(input.isFunctionCall(), "Invalid argument for 'writetime' function, it does not accept function call as argument, only simple column");
    Validator.validateFalse(input.hasLiteralValue(), "Invalid argument for 'writetime' function, it does not accept literal value as argument, only simple column");
    params.add(QueryBuilder.column((String)input.getValue()));
    return new Long_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "writetime";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "countNotNull" function with given parameters */
  @SuppressWarnings("rawtypes")
  public static final <T extends AbstractCQLCompatibleType & FunctionCall> Long_Type countNotNull(final T input) {
    final List<Object> params = new ArrayList<>();
    Validator.validateFalse(input.isFunctionCall(), "Invalid argument for 'countNotNull' function, it does not accept function call as argument, only simple column");
    Validator.validateFalse(input.hasLiteralValue(), "Invalid argument for 'countNotNull' function, it does not accept literal value as argument, only simple column");
    params.add(QueryBuilder.column((String)input.getValue()));
    return new Long_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "count";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "countNotNull" function with given parameters */
  @SuppressWarnings("rawtypes")
  public static final <T extends AbstractCQLCompatibleType & FunctionCall> Integer_Type ttl(final T input) {
    final List<Object> params = new ArrayList<>();
    Validator.validateFalse(input.isFunctionCall(), "Invalid argument for 'ttl' function, it does not accept function call as argument, only simple column");
    Validator.validateFalse(input.hasLiteralValue(), "Invalid argument for 'ttl' function, it does not accept literal value as argument, only simple column");
    params.add(QueryBuilder.column((String)input.getValue()));
    return new Integer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "ttl";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "toJson" function with given parameters */
  @SuppressWarnings("rawtypes")
  public static final <T extends AbstractCQLCompatibleType & FunctionCall> String_Type toJson(final T input) {
    final List<Object> params = new ArrayList<>();
    Validator.validateFalse(input.isFunctionCall(), "Invalid argument for 'toJson' function, it does not accept function call as argument, only simple column");
    Validator.validateFalse(input.hasLiteralValue(), "Invalid argument for 'toJson' function, it does not accept literal value as argument, only simple column");
    params.add(QueryBuilder.column((String)input.getValue()));
    return new String_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "toJson";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "sum" function with given parameters */
  public static final Byte_Type sum(final Byte_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Byte_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "sum";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "avg" function with given parameters */
  public static final Byte_Type avg(final Byte_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Byte_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "avg";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "sum" function with given parameters */
  public static final Short_Type sum(final Short_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Short_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "sum";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "avg" function with given parameters */
  public static final Short_Type avg(final Short_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Short_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "avg";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "sum" function with given parameters */
  public static final BigInteger_Type sum(final BigInteger_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigInteger_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "sum";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "avg" function with given parameters */
  public static final BigInteger_Type avg(final BigInteger_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigInteger_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "avg";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "sum" function with given parameters */
  public static final Long_Type sum(final Long_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Long_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "sum";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "avg" function with given parameters */
  public static final Long_Type avg(final Long_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Long_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "avg";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "sum" function with given parameters */
  public static final Float_Type sum(final Float_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Float_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "sum";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "avg" function with given parameters */
  public static final Float_Type avg(final Float_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Float_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "avg";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "sum" function with given parameters */
  public static final Double_Type sum(final Double_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Double_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "sum";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "avg" function with given parameters */
  public static final Double_Type avg(final Double_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Double_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "avg";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "sum" function with given parameters */
  public static final BigDecimal_Type sum(final BigDecimal_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigDecimal_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "sum";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "avg" function with given parameters */
  public static final BigDecimal_Type avg(final BigDecimal_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigDecimal_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "avg";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "sum" function with given parameters */
  public static final Integer_Type sum(final Integer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Integer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "sum";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "avg" function with given parameters */
  public static final Integer_Type avg(final Integer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Integer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "avg";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "minTimeuuid" function with given parameters */
  public static final UUID_Type minTimeuuid(final Date_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new UUID_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "minTimeuuid";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "maxTimeuuid" function with given parameters */
  public static final UUID_Type maxTimeuuid(final Date_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new UUID_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "maxTimeuuid";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "toDate" function with given parameters */
  public static final DriverLocalDate_Type toDate(final UUID_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new DriverLocalDate_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "toDate";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "toDate" function with given parameters */
  public static final DriverLocalDate_Type toDate(final Date_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new DriverLocalDate_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "toDate";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "toTimestamp" function with given parameters */
  public static final Date_Type toTimestamp(final UUID_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Date_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "toTimestamp";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "toTimestamp" function with given parameters */
  public static final Date_Type toTimestamp(final DriverLocalDate_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Date_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "toTimestamp";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "toUnixTimestamp" function with given parameters */
  public static final BigInteger_Type toUnixTimestamp(final UUID_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigInteger_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "toUnixTimestamp";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "toUnixTimestamp" function with given parameters */
  public static final BigInteger_Type toUnixTimestamp(final Date_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigInteger_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "toUnixTimestamp";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "asciiAsBlob" function with given parameters */
  public static final ByteBuffer_Type asciiAsBlob(final String_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "asciiAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "bigintAsBlob" function with given parameters */
  public static final ByteBuffer_Type bigintAsBlob(final Long_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "bigintAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "booleanAsBlob" function with given parameters */
  public static final ByteBuffer_Type booleanAsBlob(final Boolean_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "booleanAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "counterAsBlob" function with given parameters */
  public static final ByteBuffer_Type counterAsBlob(final Long_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "counterAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "dateAsBlob" function with given parameters */
  public static final ByteBuffer_Type dateAsBlob(final DriverLocalDate_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "dateAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "decimalAsBlob" function with given parameters */
  public static final ByteBuffer_Type decimalAsBlob(final BigDecimal_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "decimalAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "doubleAsBlob" function with given parameters */
  public static final ByteBuffer_Type doubleAsBlob(final Double_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "doubleAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "floatAsBlob" function with given parameters */
  public static final ByteBuffer_Type floatAsBlob(final Float_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "floatAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "inetAsBlob" function with given parameters */
  public static final ByteBuffer_Type inetAsBlob(final InetAddress_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "inetAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "intAsBlob" function with given parameters */
  public static final ByteBuffer_Type intAsBlob(final Integer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "intAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "smallintAsBlob" function with given parameters */
  public static final ByteBuffer_Type smallintAsBlob(final Short_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "smallintAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "textAsBlob" function with given parameters */
  public static final ByteBuffer_Type textAsBlob(final String_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "textAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "timeAsBlob" function with given parameters */
  public static final ByteBuffer_Type timeAsBlob(final Long_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "timeAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "timestampAsBlob" function with given parameters */
  public static final ByteBuffer_Type timestampAsBlob(final Date_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "timestampAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "timeuuidAsBlob" function with given parameters */
  public static final ByteBuffer_Type timeuuidAsBlob(final UUID_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "timeuuidAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "tinyintAsBlob" function with given parameters */
  public static final ByteBuffer_Type tinyintAsBlob(final Byte_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "tinyintAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "uuidAsBlob" function with given parameters */
  public static final ByteBuffer_Type uuidAsBlob(final UUID_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "uuidAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "varcharAsBlob" function with given parameters */
  public static final ByteBuffer_Type varcharAsBlob(final String_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "varcharAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "varintAsBlob" function with given parameters */
  public static final ByteBuffer_Type varintAsBlob(final BigInteger_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "varintAsBlob";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsAscii" function with given parameters */
  public static final String_Type blobAsAscii(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new String_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsAscii";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsBigint" function with given parameters */
  public static final Long_Type blobAsBigint(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Long_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsBigint";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsBoolean" function with given parameters */
  public static final Boolean_Type blobAsBoolean(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Boolean_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsBoolean";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsCounter" function with given parameters */
  public static final Long_Type blobAsCounter(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Long_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsCounter";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsDate" function with given parameters */
  public static final DriverLocalDate_Type blobAsDate(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new DriverLocalDate_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsDate";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsDecimal" function with given parameters */
  public static final BigDecimal_Type blobAsDecimal(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigDecimal_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsDecimal";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsDouble" function with given parameters */
  public static final Double_Type blobAsDouble(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Double_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsDouble";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsFloat" function with given parameters */
  public static final Float_Type blobAsFloat(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Float_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsFloat";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsInet" function with given parameters */
  public static final InetAddress_Type blobAsInet(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new InetAddress_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsInet";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsInt" function with given parameters */
  public static final Integer_Type blobAsInt(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Integer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsInt";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsSmallint" function with given parameters */
  public static final Short_Type blobAsSmallint(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Short_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsSmallint";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsText" function with given parameters */
  public static final String_Type blobAsText(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new String_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsText";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsTime" function with given parameters */
  public static final Long_Type blobAsTime(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Long_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsTime";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsTimestamp" function with given parameters */
  public static final Date_Type blobAsTimestamp(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Date_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsTimestamp";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsTimeUUID" function with given parameters */
  public static final UUID_Type blobAsTimeUUID(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new UUID_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsTimeUUID";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsTinyint" function with given parameters */
  public static final Byte_Type blobAsTinyint(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Byte_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsTinyint";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsUUID" function with given parameters */
  public static final UUID_Type blobAsUUID(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new UUID_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsUUID";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsVarchar" function with given parameters */
  public static final String_Type blobAsVarchar(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new String_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsVarchar";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "blobAsVarint" function with given parameters */
  public static final BigInteger_Type blobAsVarint(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigInteger_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "blobAsVarint";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final Float_Type min(final Float_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Float_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final Float_Type max(final Float_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Float_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final Double_Type min(final Double_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Double_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final Double_Type max(final Double_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Double_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final Date_Type min(final Date_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Date_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final Date_Type max(final Date_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Date_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final UUID_Type min(final UUID_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new UUID_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final UUID_Type max(final UUID_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new UUID_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final Integer_Type min(final Integer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Integer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final Integer_Type max(final Integer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Integer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final ByteBuffer_Type min(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final ByteBuffer_Type max(final ByteBuffer_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new ByteBuffer_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final InetAddress_Type min(final InetAddress_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new InetAddress_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final InetAddress_Type max(final InetAddress_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new InetAddress_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final BigDecimal_Type min(final BigDecimal_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigDecimal_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final BigDecimal_Type max(final BigDecimal_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigDecimal_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final DriverLocalDate_Type min(final DriverLocalDate_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new DriverLocalDate_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final DriverLocalDate_Type max(final DriverLocalDate_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new DriverLocalDate_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final Long_Type min(final Long_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Long_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final Long_Type max(final Long_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Long_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final Short_Type min(final Short_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Short_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final Short_Type max(final Short_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Short_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final Boolean_Type min(final Boolean_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Boolean_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final Boolean_Type max(final Boolean_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Boolean_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final BigInteger_Type min(final BigInteger_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigInteger_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final BigInteger_Type max(final BigInteger_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new BigInteger_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final String_Type min(final String_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new String_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final String_Type max(final String_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new String_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "min" function with given parameters */
  public static final Byte_Type min(final Byte_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Byte_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "min";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "max" function with given parameters */
  public static final Byte_Type max(final Byte_Type input) {
    final List<Object> params = new ArrayList<>();
    if (input.isFunctionCall()) {
      params.add(input.buildRecursive());
    } else {
      params.add(input.hasLiteralValue() ? input.getValue() : QueryBuilder.column((String)input.getValue()));
    }
    return new Byte_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "max";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "uuid" function with given parameters */
  public static final UUID_Type uuid() {
    final List<Object> params = new ArrayList<>();
    return new UUID_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "uuid";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "now" function with given parameters */
  public static final UUID_Type now() {
    final List<Object> params = new ArrayList<>();
    return new UUID_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "now";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }

  /**
   * Call "count" function with given parameters */
  public static final Long_Type count() {
    final List<Object> params = new ArrayList<>();
    return new Long_Type(Optional.empty()) {
      @Override
      public boolean isFunctionCall() {
        return true;
      }

      @Override
      public String functionName() {
        return "count";
      }

      @Override
      public List<Object> parameters() {
        return params;
      }
    };
  }
}
