package org.sbercoin.wallet.ui.fragment.watch_token_fragment;

import org.sbercoin.wallet.model.ContractTemplate;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface WatchTokenPresenter extends BaseFragmentPresenter {

    void onOkClick(String name, String address);

    void onContractAddressEntered(String contractAddress);

}
