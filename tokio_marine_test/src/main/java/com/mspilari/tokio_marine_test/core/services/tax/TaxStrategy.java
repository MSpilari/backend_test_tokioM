package com.mspilari.tokio_marine_test.core.services.tax;

import java.math.BigDecimal;

public interface TaxStrategy {
    boolean isApplicable(long days);

    BigDecimal calculate(BigDecimal amount);
}
