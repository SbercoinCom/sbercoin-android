package org.sbercoin.wallet.ui.fragment.contract_management_fragment.light;

import org.sbercoin.wallet.model.contract.ContractMethod;
import org.sbercoin.wallet.ui.fragment.contract_management_fragment.ContractManagementFragment;

import java.util.List;

public class ContractManagementFragmentLight extends ContractManagementFragment
{

    @Override
    protected int getLayout()
    {
        return org.sbercoin.wallet.R.layout.fragment_contract_management_light;
    }

    @Override
    public void setRecyclerView(List<ContractMethod> contractMethodList, boolean needToGetValue)
    {
        mMethodAdapter = new MethodAdapter(contractMethodList, org.sbercoin.wallet.R.layout.item_contract_property_light, org.sbercoin.wallet.R.layout.item_contract_method_light, needToGetValue);
        mRecyclerView.setAdapter(mMethodAdapter);
    }
}

