package org.sbercoin.wallet.ui.fragment.set_your_token_fragment;

import org.sbercoin.wallet.model.contract.ContractMethod;

public interface SetYourTokenInteractor
{
    ContractMethod getContractConstructor(String uiid);
}
