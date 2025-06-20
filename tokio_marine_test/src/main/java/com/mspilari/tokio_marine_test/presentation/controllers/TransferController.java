package com.mspilari.tokio_marine_test.presentation.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mspilari.tokio_marine_test.application.useCases.ListTransfersCase;
import com.mspilari.tokio_marine_test.application.useCases.MakeTransferCase;
import com.mspilari.tokio_marine_test.presentation.dtos.TransferRequestDto;
import com.mspilari.tokio_marine_test.presentation.dtos.TransferResponseDto;
import com.mspilari.tokio_marine_test.presentation.mappers.TransferRequestDtoMapper;
import com.mspilari.tokio_marine_test.presentation.mappers.TransferResponseDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transfers/")
public class TransferController {

    private final MakeTransferCase makeTransferCase;
    private final ListTransfersCase listTransferCase;
    private final TransferRequestDtoMapper transferRequestDtoMapper;
    private final TransferResponseDtoMapper transferResponseDtoMapper;

    public TransferController(MakeTransferCase makeTransferCase, TransferRequestDtoMapper transferRequestDtoMapper,
            ListTransfersCase listTransferCase, TransferResponseDtoMapper transferResponseDtoMapper) {
        this.makeTransferCase = makeTransferCase;
        this.transferRequestDtoMapper = transferRequestDtoMapper;
        this.listTransferCase = listTransferCase;
        this.transferResponseDtoMapper = transferResponseDtoMapper;

    }

    @PostMapping
    public ResponseEntity<Map<String, String>> makeATransfer(@Valid @RequestBody TransferRequestDto transferRequest) {

        var transferEntity = transferRequestDtoMapper.toEntity(transferRequest);
        makeTransferCase.execute(transferEntity);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Message", "Successfully transfered."));
    }

    @GetMapping
    public ResponseEntity<List<TransferResponseDto>> bankStatement() {
        var extract = listTransferCase.execute();
        var dtoResponse = extract.stream().map(value -> transferResponseDtoMapper.toDto(value)).toList();
        return ResponseEntity.ok(dtoResponse);

    }

}
