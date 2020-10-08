package org.sbercoin.wallet.ui.fragment.event_log_fragment;


import org.sbercoin.wallet.model.gson.history.History;

public interface EventLogInteractor
{
    History getHistory(String txHash);
}
