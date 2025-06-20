package com.mspilari.tokio_marine_test.presentation.mappers;

import org.springframework.stereotype.Component;

import com.mspilari.tokio_marine_test.core.entities.Transfer;
import com.mspilari.tokio_marine_test.presentation.dtos.TransferResponseDto;

@Component
public class TransferResponseDtoMapper {
    public TransferResponseDto toDto(Transfer transfer) {
        return new TransferResponseDto(transfer.getSenderAccount(),
                transfer.getDestinationAccount(),
                transfer.getAmount(),
                transfer.getTax(),
                transfer.getAmount().add(transfer.getTax()),
                transfer.getScheduleAt(),
                transfer.getTransferDate());
    }
}
