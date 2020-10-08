package org.sbercoin.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.light;

import org.sbercoin.wallet.model.AddressWithBalance;
import org.sbercoin.wallet.model.contract.ContractMethodParameter;
import org.sbercoin.wallet.ui.fragment.contract_function_fragment.ParameterAdapter;
import org.sbercoin.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.AddressesWithBalanceSpinnerAdapter;
import org.sbercoin.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.ContractFunctionDefaultFragment;

import java.util.List;

public class ContractFunctionDefaultFragmentLight extends ContractFunctionDefaultFragment
{

    @Override
    protected int getLayout()
    {
        return org.sbercoin.wallet.R.layout.fragment_function_detail_light;
    }

    @Override
    public void setUpParameterList(List<ContractMethodParameter> contractMethodParameterList)
    {
        mParameterAdapter = new ParameterAdapter(contractMethodParameterList, org.sbercoin.wallet.R.layout.lyt_constructor_input_light);
        mParameterList.setAdapter(mParameterAdapter);
    }

    @Override
    public void updateAddressWithBalanceSpinner(List<AddressWithBalance> addressWithBalances)
    {
        AddressesWithBalanceSpinnerAdapter adapter = new AddressesWithBalanceSpinnerAdapterLight(getContext(), addressWithBalances);
        mSpinner.setAdapter(adapter);
    }
}
