package org.sbercoin.wallet.ui.fragment.bcs_cash_management_fragment;

import org.sbercoin.wallet.model.AddressWithBalance;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface AddressListPresenter extends BaseFragmentPresenter {
    AddressWithBalance getKeyWithBalanceFrom();

    void setKeyWithBalanceFrom(AddressWithBalance keyWithBalanceFrom);

    List<AddressWithBalance> getAddressWithBalanceList();
}
