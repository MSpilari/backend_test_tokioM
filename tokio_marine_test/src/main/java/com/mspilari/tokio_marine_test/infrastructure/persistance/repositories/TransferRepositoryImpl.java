package com.mspilari.tokio_marine_test.infrastructure.persistance.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mspilari.tokio_marine_test.core.entities.Transfer;
import com.mspilari.tokio_marine_test.core.repositories.TransferRepository;
import com.mspilari.tokio_marine_test.infrastructure.persistance.mappers.TransferMapper;

@Repository
public class TransferRepositoryImpl implements TransferRepository {

    private final SpringTransferJpaRepository springTransferJpaRepository;
    private final TransferMapper transferMapper;

    public TransferRepositoryImpl(SpringTransferJpaRepository springTransferJpaRepository,
            TransferMapper transferMapper) {
        this.springTransferJpaRepository = springTransferJpaRepository;
        this.transferMapper = transferMapper;
    }

    @Override
    public void save(Transfer transfer) {
        var model = transferMapper.toModel(transfer);
        springTransferJpaRepository.save(model);
    }

    @Override
    public List<Transfer> findAll() {
        var bankStatement = springTransferJpaRepository.findAll();
        var listEntity = bankStatement.stream().map(value -> transferMapper.toEntity(value)).toList();
        return listEntity;
    }

}
