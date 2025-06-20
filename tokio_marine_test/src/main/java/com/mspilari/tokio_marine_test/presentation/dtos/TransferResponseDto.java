package com.mspilari.tokio_marine_test.presentation.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransferResponseDto(
        String senderAccount,
        String destinationAccount,
        BigDecimal value,
        BigDecimal tax,
        BigDecimal totalWithTax,
        LocalDate scheduleAt,
        LocalDate transferDate) {

}
