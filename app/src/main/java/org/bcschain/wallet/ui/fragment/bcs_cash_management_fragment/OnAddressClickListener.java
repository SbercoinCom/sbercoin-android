package org.sbercoin.wallet.ui.fragment.bcs_cash_management_fragment;

import org.sbercoin.wallet.model.AddressWithBalance;

public interface OnAddressClickListener {
    void onItemClick(AddressWithBalance deterministicKeyWithBalance);
}
