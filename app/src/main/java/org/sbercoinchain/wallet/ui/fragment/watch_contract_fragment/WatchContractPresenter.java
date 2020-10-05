package org.sbercoin.wallet.ui.fragment.watch_contract_fragment;

import org.sbercoin.wallet.model.ContractTemplate;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface WatchContractPresenter extends BaseFragmentPresenter {
    void onOkClick(String name, String address, String ABIInterface);

    void onTemplateClick(ContractTemplate contractTemplate);
}
