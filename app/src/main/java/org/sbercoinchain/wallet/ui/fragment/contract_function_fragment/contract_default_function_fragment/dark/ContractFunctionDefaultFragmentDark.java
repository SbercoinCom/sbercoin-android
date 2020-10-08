package org.sbercoin.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.dark;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.model.AddressWithBalance;
import org.sbercoin.wallet.model.contract.ContractMethodParameter;
import org.sbercoin.wallet.ui.fragment.contract_function_fragment.ParameterAdapter;
import org.sbercoin.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.AddressesWithBalanceSpinnerAdapter;
import org.sbercoin.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.ContractFunctionDefaultFragment;

import java.util.List;

public class ContractFunctionDefaultFragmentDark extends ContractFunctionDefaultFragment
{

    @Override
    protected int getLayout()
    {
        return R.layout.fragment_function_detail;
    }

    @Override
    public void setUpParameterList(List<ContractMethodParameter> contractMethodParameterList)
    {
        mParameterAdapter = new ParameterAdapter(contractMethodParameterList, R.layout.lyt_constructor_input);
        mParameterList.setAdapter(mParameterAdapter);
    }

    @Override
    public void updateAddressWithBalanceSpinner(List<AddressWithBalance> addressWithBalances)
    {
        AddressesWithBalanceSpinnerAdapter adapter = new AddressesWithBalanceSpinnerAdapterDark(getContext(), addressWithBalances);
        mSpinner.setAdapter(adapter);
    }
}
