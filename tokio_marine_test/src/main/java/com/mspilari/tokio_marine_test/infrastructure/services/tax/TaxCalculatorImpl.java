package com.mspilari.tokio_marine_test.infrastructure.services.tax;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mspilari.tokio_marine_test.core.services.tax.TaxCalculator;
import com.mspilari.tokio_marine_test.core.services.tax.TaxStrategy;

@Service
public class TaxCalculatorImpl implements TaxCalculator {

    private final List<TaxStrategy> taxStrategies;

    public TaxCalculatorImpl(List<TaxStrategy> taxStrategies) {
        this.taxStrategies = taxStrategies;
    }

    @Override
    public BigDecimal calculateTax(LocalDate transferDate, BigDecimal amount) {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), transferDate);

        return taxStrategies.stream()
                .filter(strategy -> strategy.isApplicable(days))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nenhuma estratégia aplicável."))
                .calculate(amount);

    }

}
