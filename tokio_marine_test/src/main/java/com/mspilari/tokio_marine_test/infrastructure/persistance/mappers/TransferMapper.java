package com.mspilari.tokio_marine_test.infrastructure.persistance.mappers;

import org.springframework.stereotype.Component;

import com.mspilari.tokio_marine_test.core.entities.Transfer;
import com.mspilari.tokio_marine_test.infrastructure.persistance.models.TransferModel;

@Component
public class TransferMapper {

    public TransferModel toModel(Transfer transfer) {
        return new TransferModel(transfer.getSenderAccount(),
                transfer.getDestinationAccount(),
                transfer.getAmount(),
                transfer.getTax(),
                transfer.getTransferDate());
    }

    public Transfer toEntity(TransferModel transferModel) {
        return new Transfer(transferModel.getId(),
                transferModel.getSenderAccount(),
                transferModel.getDestinationAccount(),
                transferModel.getAmount(),
                transferModel.getTax(),
                transferModel.getScheduleAt(),
                transferModel.getTransferDate());
    }
}
