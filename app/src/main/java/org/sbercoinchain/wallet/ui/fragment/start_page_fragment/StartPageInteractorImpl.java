package org.sbercoin.wallet.ui.fragment.start_page_fragment;

import android.content.Context;

import org.sbercoin.wallet.datastorage.KeyStorage;
import org.sbercoin.wallet.datastorage.SBERSharedPreference;
import org.sbercoin.wallet.datastorage.TinyDB;

import java.lang.ref.WeakReference;

import io.realm.Realm;

public class StartPageInteractorImpl implements StartPageInteractor
{

    private WeakReference<Context> mContext;
    private Realm mRealm;

    public StartPageInteractorImpl(Context context, Realm realm)
    {
        mContext = new WeakReference<>(context);
        mRealm = realm;
    }

    @Override
    public boolean getGeneratedKey()
    {
        return SBERSharedPreference.getInstance().getKeyGeneratedInstance(mContext.get());
    }

    @Override
    public void clearWallet()
    {
        SBERSharedPreference.getInstance().clear(mContext.get());
        KeyStorage.getInstance().clearKeyStorage();
        mRealm.removeAllChangeListeners();
        mRealm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm)
            {
                realm.deleteAll();
            }
        });
        TinyDB db = new TinyDB(mContext.get());
        db.clearTokenList();
        db.clearContractList();
        db.clearTemplateList();
    }
}
