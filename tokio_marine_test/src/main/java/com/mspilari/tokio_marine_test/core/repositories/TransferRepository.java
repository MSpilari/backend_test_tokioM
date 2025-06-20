package com.mspilari.tokio_marine_test.core.repositories;

import java.util.List;

import com.mspilari.tokio_marine_test.core.entities.Transfer;

public interface TransferRepository {
    void save(Transfer transfer);

    List<Transfer> findAll();
}
