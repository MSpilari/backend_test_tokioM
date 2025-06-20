package com.mspilari.tokio_marine_test.presentation.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record TransferRequestDto(

                @NotBlank @Pattern(regexp = "\\d{10}", message = "The source account must have exactly 10 numeric digits.") String senderAccount,

                @NotBlank @Pattern(regexp = "\\d{10}", message = "The destination account must have exactly 10 numeric digits.") String destinationAccount,

                @NotNull @Positive BigDecimal value,

                @NotNull @FutureOrPresent LocalDate transferDate) {

}
