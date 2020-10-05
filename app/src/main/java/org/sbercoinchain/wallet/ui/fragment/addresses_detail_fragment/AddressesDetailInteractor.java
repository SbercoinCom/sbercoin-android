package org.sbercoin.wallet.ui.fragment.addresses_detail_fragment;


import org.sbercoin.wallet.model.gson.history.History;
import org.sbercoin.wallet.model.gson.token_history.TokenHistory;


public interface AddressesDetailInteractor {
    History getHistory(String txHash);
    TokenHistory getTokenHistory(String txHash);
}
