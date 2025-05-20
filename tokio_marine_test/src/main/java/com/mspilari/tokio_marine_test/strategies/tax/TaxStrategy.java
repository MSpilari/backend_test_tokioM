package com.mspilari.tokio_marine_test.strategies.tax;

import java.math.BigDecimal;

public interface TaxStrategy {
    boolean isApplicable(long days);

    BigDecimal calculate(BigDecimal amount);
}
