package org.sbercoin.wallet.ui.fragment.contract_function_fragment.contract_constant_function_fragment.dark;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.model.contract.ContractMethodParameter;
import org.sbercoin.wallet.ui.fragment.contract_function_fragment.ParameterAdapter;
import org.sbercoin.wallet.ui.fragment.contract_function_fragment.contract_constant_function_fragment.ContractFunctionConstantFragment;

import java.util.List;

public class ContractFunctionConstantFragmentDark extends ContractFunctionConstantFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_function_constant_detail;
    }

    @Override
    public void setUpParameterList(List<ContractMethodParameter> contractMethodParameterList) {
        mParameterAdapter = new ParameterAdapter(contractMethodParameterList, R.layout.lyt_constructor_input);
        mParameterList.setAdapter(mParameterAdapter);
    }
}
