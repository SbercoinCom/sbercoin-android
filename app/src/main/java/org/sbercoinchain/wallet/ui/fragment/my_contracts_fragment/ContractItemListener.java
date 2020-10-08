package org.sbercoin.wallet.ui.fragment.my_contracts_fragment;

import org.sbercoin.wallet.model.contract.Contract;

public interface ContractItemListener
{
    void onUnsubscribeClick(Contract contract);
}
