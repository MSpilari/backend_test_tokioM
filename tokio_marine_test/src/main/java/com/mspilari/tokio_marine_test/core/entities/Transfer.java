package com.mspilari.tokio_marine_test.core.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transfer {

    private final Long id;

    private final String senderAccount;
    private final String destinationAccount;

    private final BigDecimal amount;
    private final BigDecimal tax;

    private final LocalDate scheduleAt;
    private final LocalDate transferDate;

    public Transfer(Long id, String senderAccount, String destinationAccount, BigDecimal amount, BigDecimal tax,
            LocalDate scheduleAt, LocalDate transferDate) {
        this.id = id;
        this.senderAccount = senderAccount;
        this.destinationAccount = destinationAccount;

        if (senderAccount.equals(destinationAccount)) {
            throw new IllegalArgumentException("The sender account cannot be the same as destination account.");
        }

        this.amount = validateAmount(amount);
        this.scheduleAt = scheduleAt;
        this.transferDate = transferDate;

        this.tax = tax;
    }

    private BigDecimal validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("The value from the transfer must be positive.");
        }

        return amount;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public LocalDate getScheduleAt() {
        return scheduleAt;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

}
