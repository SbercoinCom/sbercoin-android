package org.sbercoin.wallet.ui.fragment.wallet_main_fragment;

import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

public interface WalletMainView extends BaseFragmentView
{
    void showOtherTokens(boolean isShow);

    void showPageIndicator();

    void hidePageIndicator();
}
