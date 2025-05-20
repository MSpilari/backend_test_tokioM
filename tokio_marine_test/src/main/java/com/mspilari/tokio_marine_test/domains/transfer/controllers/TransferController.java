package com.mspilari.tokio_marine_test.domains.transfer.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mspilari.tokio_marine_test.domains.transfer.dto.TransferRequestDTO;
import com.mspilari.tokio_marine_test.domains.transfer.dto.TransferResponseDTO;
import com.mspilari.tokio_marine_test.domains.transfer.services.TransferService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transfers/")
public class TransferController {

    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("make")
    public ResponseEntity<Map<String, String>> makeATransfer(@Valid @RequestBody TransferRequestDTO transferRequest) {
        transferService.saveATransfer(transferRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Message", "Transferência programada com sucesso !"));
    }

    @GetMapping()
    public ResponseEntity<List<TransferResponseDTO>> seeAllTransfers() {
        return ResponseEntity.ok(transferService.showAllTransfers());

    }

}
