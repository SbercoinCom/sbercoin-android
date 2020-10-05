package org.sbercoin.wallet.dataprovider.services.update_service.listeners;

import org.sbercoin.wallet.model.gson.qstore.ContractPurchase;

public interface ContractPurchaseListener {
    void onContractPurchased(ContractPurchase purchaseData);
}
