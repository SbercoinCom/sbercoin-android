package org.sbercoin.wallet.ui.fragment.profile_fragment;

import android.content.Context;

import org.sbercoin.wallet.datastorage.KeyStorage;
import org.sbercoin.wallet.datastorage.BCSSettingSharedPreference;
import org.sbercoin.wallet.datastorage.BCSSharedPreference;
import org.sbercoin.wallet.datastorage.TinyDB;
import org.sbercoin.wallet.datastorage.listeners.LanguageChangeListener;

import io.realm.Realm;

class ProfileInteractorImpl implements ProfileInteractor {

    private Context mContext;
    private Realm mRealm;

    ProfileInteractorImpl(Context context, Realm realm) {
        mContext = context;
        mRealm = realm;
    }

    @Override
    public void clearWallet() {
        BCSSharedPreference.getInstance().clear(mContext);
        KeyStorage.getInstance().clearKeyStorage();

        mRealm.removeAllChangeListeners();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });
        TinyDB db = new TinyDB(mContext);
        db.clearTokenList();
        db.clearContractList();
        db.clearTemplateList();
    }

    @Override
    public void setupLanguageChangeListener(LanguageChangeListener listener) {
        BCSSettingSharedPreference.getInstance().addLanguageListener(listener);
    }

    @Override
    public void removeLanguageListener(LanguageChangeListener listener) {
        BCSSettingSharedPreference.getInstance().removeLanguageListener(listener);
    }

    @Override
    public boolean isTouchIdEnable() {
        return BCSSharedPreference.getInstance().isTouchIdEnable(mContext);
    }

    @Override
    public void saveTouchIdEnable(boolean isChecked) {
        BCSSharedPreference.getInstance().saveTouchIdEnable(mContext, isChecked);
    }
}
