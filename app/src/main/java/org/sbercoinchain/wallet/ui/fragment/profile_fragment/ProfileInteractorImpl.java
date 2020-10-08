package org.sbercoin.wallet.ui.fragment.profile_fragment;

import android.content.Context;

import org.sbercoin.wallet.datastorage.KeyStorage;
import org.sbercoin.wallet.datastorage.SBERSettingSharedPreference;
import org.sbercoin.wallet.datastorage.SBERSharedPreference;
import org.sbercoin.wallet.datastorage.TinyDB;
import org.sbercoin.wallet.datastorage.listeners.LanguageChangeListener;

import io.realm.Realm;

class ProfileInteractorImpl implements ProfileInteractor
{

    private Context mContext;
    private Realm mRealm;

    ProfileInteractorImpl(Context context, Realm realm)
    {
        mContext = context;
        mRealm = realm;
    }

    @Override
    public void clearWallet()
    {
        SBERSharedPreference.getInstance().clear(mContext);
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
        TinyDB db = new TinyDB(mContext);
        db.clearTokenList();
        db.clearContractList();
        db.clearTemplateList();
    }

    @Override
    public void setupLanguageChangeListener(LanguageChangeListener listener)
    {
        SBERSettingSharedPreference.getInstance().addLanguageListener(listener);
    }

    @Override
    public void removeLanguageListener(LanguageChangeListener listener)
    {
        SBERSettingSharedPreference.getInstance().removeLanguageListener(listener);
    }

    @Override
    public boolean isTouchIdEnable()
    {
        return SBERSharedPreference.getInstance().isTouchIdEnable(mContext);
    }

    @Override
    public void saveTouchIdEnable(boolean isChecked)
    {
        SBERSharedPreference.getInstance().saveTouchIdEnable(mContext, isChecked);
    }
}
