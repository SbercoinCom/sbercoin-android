package org.sbercoin.wallet.ui.fragment.wallet_fragment;

import org.sbercoin.wallet.model.gson.history.History;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface WalletPresenter extends BaseFragmentPresenter
{

    void onTransactionClick(String txHash);

    void onLastItem(int currentItemCount);

    void onNetworkStateChanged(boolean networkConnectedFlag);

    void onNewHistory(History history);

    boolean getVisibility();

    void updateVisibility(boolean value);

}
