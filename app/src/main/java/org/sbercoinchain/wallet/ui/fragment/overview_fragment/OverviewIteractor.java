package org.sbercoin.wallet.ui.fragment.overview_fragment;


import org.sbercoin.wallet.model.gson.history.History;
import org.sbercoin.wallet.model.gson.history.TransactionReceipt;
import org.sbercoin.wallet.model.gson.token_history.TokenHistory;

public interface OverviewIteractor {
    History getHistory(String txHash);
    TokenHistory getTokenHistory(String txHash);
    TransactionReceipt getReceiptByRxhHashFromRealm(String txHash);
}
