package com.mspilari.tokio_marine_test.infrastructure.services.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.mspilari.tokio_marine_test.core.services.tax.TaxStrategy;

@Component
public class TaxStrategySameDay implements TaxStrategy {
    @Override
    public boolean isApplicable(long days) {
        return days == 0;
    }

    @Override
    public BigDecimal calculate(BigDecimal amount) {

        return new BigDecimal("3").add(amount.multiply(new BigDecimal("0.025"))).setScale(2, RoundingMode.HALF_UP);
    }
}
