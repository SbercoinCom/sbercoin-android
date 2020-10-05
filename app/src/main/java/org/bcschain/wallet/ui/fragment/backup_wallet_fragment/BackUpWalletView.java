package org.sbercoin.wallet.ui.fragment.backup_wallet_fragment;

import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

public interface BackUpWalletView extends BaseFragmentView {
    void setBrainCode(String seed);

    void showToast();

    String getPin();

    void copyToClipboard(String text);

    void chooseShareMethod(String text);

    void onLogin();
}
