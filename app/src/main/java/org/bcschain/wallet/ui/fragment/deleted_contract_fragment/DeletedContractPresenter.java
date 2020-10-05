package org.sbercoin.wallet.ui.fragment.deleted_contract_fragment;


import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface DeletedContractPresenter extends BaseFragmentPresenter {
    void onUnubscribeClick(String contractAddress);
}
