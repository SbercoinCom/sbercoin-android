package org.sbercoin.wallet.ui.fragment.my_contracts_fragment.dark;

import org.sbercoin.wallet.model.contract.Contract;
import org.sbercoin.wallet.ui.fragment.my_contracts_fragment.ContractItemListener;
import org.sbercoin.wallet.ui.fragment.my_contracts_fragment.MyContractsFragment;

import java.util.List;

public class MyContractsFragmentDark extends MyContractsFragment
{

    @Override
    protected int getLayout()
    {
        return org.sbercoin.wallet.R.layout.fragment_my_contracts;
    }


    @Override
    public void setUpRecyclerView(List<Contract> contractList, ContractItemListener contractItemListener)
    {
        mContractAdapter = new ContractAdapter(contractList, org.sbercoin.wallet.R.layout.item_contract_list, contractItemListener);
        mRecyclerView.setAdapter(mContractAdapter);
    }
}
