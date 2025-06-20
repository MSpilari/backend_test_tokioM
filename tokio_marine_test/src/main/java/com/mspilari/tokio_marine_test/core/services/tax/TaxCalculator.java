package com.mspilari.tokio_marine_test.core.services.tax;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TaxCalculator {
    BigDecimal calculateTax(LocalDate transferDate, BigDecimal amount);
}
