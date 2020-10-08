package org.sbercoin.wallet.ui.fragment.contract_confirm_fragment;

import org.sbercoin.wallet.model.contract.ContractMethodParameter;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface ContractConfirmPresenter extends BaseFragmentPresenter
{
    void onConfirmContract(final String uiid, final int gasLimit, final int gasPrice, final String fee, String passphrase);

    List<ContractMethodParameter> getContractMethodParameterList();

    void setContractMethodParameterList(List<ContractMethodParameter> contractMethodParameterList);
}
