package com.mspilari.tokio_marine_test.domains.transfer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mspilari.tokio_marine_test.model.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
