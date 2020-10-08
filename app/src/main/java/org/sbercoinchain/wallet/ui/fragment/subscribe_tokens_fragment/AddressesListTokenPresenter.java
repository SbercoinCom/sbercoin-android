package org.sbercoin.wallet.ui.fragment.subscribe_tokens_fragment;

import org.sbercoin.wallet.model.contract.Token;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface AddressesListTokenPresenter extends BaseFragmentPresenter
{
    void onSubscribeChanged(Token token);
}
