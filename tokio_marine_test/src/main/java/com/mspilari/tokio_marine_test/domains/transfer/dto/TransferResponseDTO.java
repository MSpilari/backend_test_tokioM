package com.mspilari.tokio_marine_test.domains.transfer.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.mspilari.tokio_marine_test.model.Transfer;

public record TransferResponseDTO(
        String senderAccount,
        String destinationAccount,
        BigDecimal value,
        BigDecimal tax,
        BigDecimal totalWithTax,
        LocalDate scheduleAt,
        LocalDate transferDate) {
    public static TransferResponseDTO fromEntity(Transfer transfer) {
        return new TransferResponseDTO(
                transfer.getSenderAccount(),
                transfer.getDestinationAccount(),
                transfer.getAmount(),
                transfer.getTax(),
                transfer.getAmount().add(transfer.getTax()),
                transfer.getScheduleAt(),
                transfer.getTransferDate());
    }
}
