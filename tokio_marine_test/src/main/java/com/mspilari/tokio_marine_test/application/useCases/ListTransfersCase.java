package com.mspilari.tokio_marine_test.application.useCases;

import java.util.List;

import com.mspilari.tokio_marine_test.core.entities.Transfer;

public interface ListTransfersCase {

    public List<Transfer> execute();
}
