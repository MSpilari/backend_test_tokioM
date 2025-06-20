package com.mspilari.tokio_marine_test.infrastructure.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mspilari.tokio_marine_test.application.useCases.ListTransfersCase;
import com.mspilari.tokio_marine_test.application.useCases.ListTransfersImpl;
import com.mspilari.tokio_marine_test.application.useCases.MakeTransferCase;
import com.mspilari.tokio_marine_test.application.useCases.MakeTransferImpl;
import com.mspilari.tokio_marine_test.core.repositories.TransferRepository;
import com.mspilari.tokio_marine_test.core.services.tax.TaxCalculator;

@Configuration
public class UseCaseConfig {

    @Bean
    public MakeTransferCase makeTransferCase(TransferRepository transferRepository, TaxCalculator taxCalculator) {
        return new MakeTransferImpl(transferRepository, taxCalculator);
    }

    @Bean
    public ListTransfersCase listTransfersCase(TransferRepository transferRepository) {
        return new ListTransfersImpl(transferRepository);
    }

}
