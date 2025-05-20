package com.mspilari.tokio_marine_test.strategies.tax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    @BeforeEach
    void setup() {
        taxCalculator = new TaxCalculator(List.of(
                new TaxStrategySameDay(),
                new TaxStrategyUpTo10Days(),
                new TaxStrategyUpTo20Days(),
                new TaxStrategyUpTo30Days(),
                new TaxStrategyUpTo40Days(),
                new TaxStrategyUpTo50Days()));
    }

    @Test
    void shouldApplySameDayStrategy() {
        LocalDate today = LocalDate.now();
        BigDecimal amount = new BigDecimal("1000.00");

        BigDecimal tax = taxCalculator.calculateTax(today, amount);

        // Tax: R$3,00 + 2.5% sobre R$1000.00 = 3.00 + 25.00 = 28.00
        assertEquals(new BigDecimal("28.00"), tax);
    }

    @Test
    void shouldApplyUpTo10DaysStrategy() {
        LocalDate futureDate = LocalDate.now().plusDays(5);
        BigDecimal amount = new BigDecimal("1000.00");

        BigDecimal tax = taxCalculator.calculateTax(futureDate, amount);

        // Tax: R$12,00
        assertEquals(new BigDecimal("12.00"), tax);
    }

    @Test
    void shouldApplyUpTo20DaysStrategy() {
        LocalDate futureDate = LocalDate.now().plusDays(15);
        BigDecimal amount = new BigDecimal("1000.00");

        BigDecimal tax = taxCalculator.calculateTax(futureDate, amount);

        // Tax: 8.2% of 1000 = 82.00
        assertEquals(new BigDecimal("82.00"), tax);
    }

    @Test
    void shouldThrowExceptionIfNoStrategyApplies() {
        LocalDate futureDate = LocalDate.now().plusDays(60); // no strategy for > 50 days
        BigDecimal amount = new BigDecimal("1000.00");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taxCalculator.calculateTax(futureDate, amount);
        });

        assertEquals("Nenhuma estratégia aplicável.", exception.getMessage());
    }
}
