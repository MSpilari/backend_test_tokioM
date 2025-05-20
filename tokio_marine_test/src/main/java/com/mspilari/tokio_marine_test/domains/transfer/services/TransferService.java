package com.mspilari.tokio_marine_test.domains.transfer.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mspilari.tokio_marine_test.domains.transfer.dto.TransferRequestDTO;
import com.mspilari.tokio_marine_test.domains.transfer.dto.TransferResponseDTO;
import com.mspilari.tokio_marine_test.domains.transfer.repositories.TransferRepository;
import com.mspilari.tokio_marine_test.model.Transfer;
import com.mspilari.tokio_marine_test.strategies.tax.TaxCalculator;

@Service
public class TransferService {

    private TransferRepository transferRepository;
    private TaxCalculator taxCalculator;

    public TransferService(TransferRepository transferRepository, TaxCalculator taxCalculator) {
        this.transferRepository = transferRepository;
        this.taxCalculator = taxCalculator;
    }

    public void saveATransfer(TransferRequestDTO transferRequest) {
        if (transferRequest.senderAccount().equals(transferRequest.destinationAccount())) {
            throw new IllegalArgumentException("Contas devem ser diferentes.");
        }

        BigDecimal tax = taxCalculator.calculateTax(transferRequest.transferDate(), transferRequest.value());
        Transfer newTransfer = new Transfer(transferRequest.senderAccount(), transferRequest.destinationAccount(),
                transferRequest.value(), tax, transferRequest.transferDate());

        transferRepository.save(newTransfer);
    };

    public List<TransferResponseDTO> showAllTransfers() {
        return transferRepository.findAll()
                .stream()
                .map(transfer -> TransferResponseDTO.fromEntity(transfer))
                .toList();
    };
}
