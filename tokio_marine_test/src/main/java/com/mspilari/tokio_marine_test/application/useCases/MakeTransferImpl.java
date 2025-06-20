package com.mspilari.tokio_marine_test.application.useCases;

import com.mspilari.tokio_marine_test.core.entities.Transfer;
import com.mspilari.tokio_marine_test.core.repositories.TransferRepository;
import com.mspilari.tokio_marine_test.core.services.tax.TaxCalculator;

public class MakeTransferImpl implements MakeTransferCase {

    private final TransferRepository transferRepository;
    private final TaxCalculator taxCalculator;

    public MakeTransferImpl(TransferRepository transferRepository, TaxCalculator taxCalculator) {
        this.transferRepository = transferRepository;
        this.taxCalculator = taxCalculator;
    }

    @Override
    public void execute(Transfer transfer) {
        var tax = taxCalculator.calculateTax(transfer.getTransferDate(), transfer.getAmount());
        var transferWithTax = new Transfer(
                transfer.getId(),
                transfer.getSenderAccount(),
                transfer.getDestinationAccount(),
                transfer.getAmount(),
                tax,
                transfer.getScheduleAt(),
                transfer.getTransferDate());

        transferRepository.save(transferWithTax);
    }
}
