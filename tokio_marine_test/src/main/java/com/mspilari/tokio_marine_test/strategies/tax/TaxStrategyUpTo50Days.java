package com.mspilari.tokio_marine_test.strategies.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public class TaxStrategyUpTo50Days implements TaxStrategy {
    @Override
    public boolean isApplicable(long days) {
        return days >= 41 && days <= 50;
    }

    @Override
    public BigDecimal calculate(BigDecimal amount) {
        return new BigDecimal("0.017").multiply(amount).setScale(2, RoundingMode.HALF_UP);
    }
}
