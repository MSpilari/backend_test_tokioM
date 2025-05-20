package com.mspilari.tokio_marine_test.domains.transfer.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record TransferRequestDTO(

        @NotBlank @Pattern(regexp = "\\d{10}", message = "A conta de origem deve ter exatamente 10 dígitos numéricos.") String senderAccount,

        @NotBlank @Pattern(regexp = "\\d{10}", message = "A conta de destino deve ter exatamente 10 dígitos numéricos.") String destinationAccount,

        @NotNull @Positive BigDecimal value,

        @NotNull @FutureOrPresent LocalDate transferDate) {

}
