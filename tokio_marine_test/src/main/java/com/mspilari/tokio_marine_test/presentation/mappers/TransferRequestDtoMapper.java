package com.mspilari.tokio_marine_test.presentation.mappers;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.mspilari.tokio_marine_test.core.entities.Transfer;
import com.mspilari.tokio_marine_test.presentation.dtos.TransferRequestDto;

@Component
public class TransferRequestDtoMapper {
    public Transfer toEntity(TransferRequestDto transferDto) {
        return new Transfer(null,
                transferDto.senderAccount(),
                transferDto.destinationAccount(),
                transferDto.value(),
                BigDecimal.ZERO,
                LocalDate.now(),
                transferDto.transferDate());
    }
}
