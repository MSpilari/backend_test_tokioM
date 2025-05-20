package com.mspilari.tokio_marine_test.strategies.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public class TaxStrategyUpTo10Days implements TaxStrategy {
    @Override
    public boolean isApplicable(long days) {
        return days >= 1 && days <= 10;
    }

    @Override
    public BigDecimal calculate(BigDecimal amount) {
        return new BigDecimal("12").setScale(2, RoundingMode.HALF_UP);
    }
}
