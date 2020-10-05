package org.sbercoin.wallet.ui.fragment.contract_management_fragment;

import org.sbercoin.wallet.model.contract.Contract;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface ContractManagementPresenter extends BaseFragmentPresenter {
    Contract getContractByAddress(String contractAddress);
}
