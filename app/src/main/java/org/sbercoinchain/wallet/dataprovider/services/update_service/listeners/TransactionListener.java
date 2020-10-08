package org.sbercoin.wallet.dataprovider.services.update_service.listeners;

import org.sbercoin.wallet.model.gson.history.History;

public interface TransactionListener
{
    void onNewHistory(History history);

    boolean getVisibility();
}
