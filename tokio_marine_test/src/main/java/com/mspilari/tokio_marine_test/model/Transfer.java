package com.mspilari.tokio_marine_test.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderAccount;
    private String destinationAccount;

    private BigDecimal amount;
    private BigDecimal tax;

    private LocalDate scheduleAt;
    private LocalDate transferDate;

    public Transfer() {
    }

    public Transfer(String senderAccount, String destinationAccount, BigDecimal amount, BigDecimal tax,
            LocalDate transferDate) {
        this.senderAccount = senderAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.tax = tax;
        this.scheduleAt = LocalDate.now();
        this.transferDate = transferDate;
    }

    public Long getId() {
        return id;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public LocalDate getScheduleAt() {
        return scheduleAt;
    }

    public void setScheduleAt(LocalDate scheduleAt) {
        this.scheduleAt = scheduleAt;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }
}
