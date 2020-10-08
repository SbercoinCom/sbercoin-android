package org.sbercoin.wallet.ui.fragment.confirm_passphrase_fragment;


import android.content.Context;

import org.sbercoin.wallet.datastorage.KeyStorage;
import org.sbercoin.wallet.datastorage.SBERSharedPreference;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

import rx.Observable;

public class ConfirmPassphraseInteractorImpl implements ConfirmPassphraseInteractor
{

    WeakReference<Context> mContext;

    ConfirmPassphraseInteractorImpl(Context context)
    {
        mContext = new WeakReference<Context>(context);
    }

    @Override
    public Observable<String> createWallet(final String passphrase)
    {
        return Observable.fromCallable(new Callable<String>()
        {
            @Override
            public String call() throws Exception
            {
                return KeyStorage.getInstance().loadWallet(passphrase);
            }
        });
    }

    @Override
    public void setKeyGeneratedInstance(boolean isKeyGenerated)
    {
        SBERSharedPreference.getInstance().setKeyGeneratedInstance(mContext.get(), isKeyGenerated);
    }
}
