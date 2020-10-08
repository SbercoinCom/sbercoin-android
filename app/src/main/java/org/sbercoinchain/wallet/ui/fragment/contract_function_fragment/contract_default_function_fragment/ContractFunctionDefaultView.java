package org.sbercoin.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment;

import org.sbercoin.wallet.model.AddressWithBalance;
import org.sbercoin.wallet.model.contract.ContractMethodParameter;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface ContractFunctionDefaultView extends BaseFragmentView
{
    void setUpParameterList(List<ContractMethodParameter> contractMethodParameterList);

    String getContractTemplateUiid();

    String getMethodName();

    void updateFee(double minFee, double maxFee);

    void updateGasPrice(int minGasPrice, int maxGasPrice);

    void updateGasLimit(int minGasLimit, int maxGasLimit);

    void showEtSendToContract();

    void hideEtSendToContract();

    void updateAddressWithBalanceSpinner(List<AddressWithBalance> addressWithBalances);

}
