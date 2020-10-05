package org.sbercoin.wallet.ui.fragment.profile_fragment;

import org.sbercoin.wallet.datastorage.listeners.LanguageChangeListener;

import io.realm.Realm;

public interface ProfileInteractor {
    void clearWallet();

    void setupLanguageChangeListener(LanguageChangeListener listener);

    void removeLanguageListener(LanguageChangeListener listener);

    boolean isTouchIdEnable();

    void saveTouchIdEnable(boolean isChecked);
}
