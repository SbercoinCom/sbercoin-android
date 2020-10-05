package org.sbercoin.wallet.ui.fragment.sbercoin_cash_management_fragment;

import org.sbercoin.wallet.model.AddressWithBalance;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface AddressListView extends BaseFragmentView {
    void updateAddressList(List<AddressWithBalance> deterministicKeyWithBalance);
}
