package com.mspilari.tokio_marine_test.infrastructure.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mspilari.tokio_marine_test.infrastructure.persistance.models.TransferModel;

public interface SpringTransferJpaRepository extends JpaRepository<TransferModel, Long> {

}
