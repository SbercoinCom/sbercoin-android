package org.sbercoin.wallet.ui.fragment.backup_wallet_fragment;

import android.content.Context;
import android.util.Base64;

import org.sbercoin.wallet.datastorage.SBERSharedPreference;
import org.sbercoin.wallet.utils.crypto.AESUtil;
import org.sbercoin.wallet.utils.crypto.KeyStoreHelper;

class BackUpWalletInteractorImpl implements BackUpWalletInteractor {

    private Context mContext;

    private final String SBER_PIN_ALIAS = "sbercoin_alias";

    BackUpWalletInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public String getPassphrase(String pin) {
       return KeyStoreHelper.getSeed(mContext, pin);
    }
}
