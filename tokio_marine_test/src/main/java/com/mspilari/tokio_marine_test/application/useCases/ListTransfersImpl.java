package com.mspilari.tokio_marine_test.application.useCases;

import java.util.List;

import com.mspilari.tokio_marine_test.core.entities.Transfer;
import com.mspilari.tokio_marine_test.core.repositories.TransferRepository;

public class ListTransfersImpl implements ListTransfersCase {

    private final TransferRepository transferRepository;

    public ListTransfersImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public List<Transfer> execute() {
        return transferRepository.findAll();
    }

}
