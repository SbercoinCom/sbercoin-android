package org.sbercoin.wallet.ui.fragment.backup_wallet_fragment;

import android.content.Context;
import android.util.Base64;

import org.sbercoin.wallet.datastorage.BCSSharedPreference;
import org.sbercoin.wallet.utils.crypto.AESUtil;
import org.sbercoin.wallet.utils.crypto.KeyStoreHelper;

class BackUpWalletInteractorImpl implements BackUpWalletInteractor {

    private Context mContext;

    private final String BCS_PIN_ALIAS = "bcs_alias";

    BackUpWalletInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public String getPassphrase(String pin) {
       return KeyStoreHelper.getSeed(mContext, pin);
    }
}
