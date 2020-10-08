package org.sbercoin.wallet.ui.fragment.profile_fragment;

import org.sbercoin.wallet.datastorage.listeners.LanguageChangeListener;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface ProfilePresenter extends BaseFragmentPresenter
{
    void onTouchIdSwitched(boolean isChecked);

    void clearWallet();

    List<SettingObject> getSettingsData();

    void setupLanguageChangeListener(LanguageChangeListener listener);

    void removeLanguageListener(LanguageChangeListener listener);
}
