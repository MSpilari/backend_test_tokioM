package com.mspilari.tokio_marine_test.strategies.tax;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TaxCalculator {

    private final List<TaxStrategy> taxStrategies;

    public TaxCalculator(List<TaxStrategy> taxStrategies) {
        this.taxStrategies = taxStrategies;
    }

    public BigDecimal calculateTax(LocalDate transferDate, BigDecimal amount) {
        LocalDate today = LocalDate.now();
        long days = ChronoUnit.DAYS.between(today, transferDate);

        return taxStrategies.stream()
                .filter(s -> s.isApplicable(days))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nenhuma estratégia aplicável."))
                .calculate(amount);
    }
}
