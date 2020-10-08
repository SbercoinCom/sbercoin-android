package org.sbercoin.wallet.ui.fragment.backup_wallet_fragment;

import android.content.Context;

import org.sbercoin.wallet.utils.crypto.KeyStoreHelper;

class BackUpWalletInteractorImpl implements BackUpWalletInteractor
{

    private final String SBER_PIN_ALIAS = "sbercoin_alias";
    private Context mContext;

    BackUpWalletInteractorImpl(Context context)
    {
        mContext = context;
    }

    @Override
    public String getPassphrase(String pin)
    {
        return KeyStoreHelper.getSeed(mContext, pin);
    }
}
