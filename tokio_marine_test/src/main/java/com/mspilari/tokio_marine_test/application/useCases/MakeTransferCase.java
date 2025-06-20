package com.mspilari.tokio_marine_test.application.useCases;

import com.mspilari.tokio_marine_test.core.entities.Transfer;

public interface MakeTransferCase {

    public void execute(Transfer transfer);
}
