package org.sbercoin.wallet.ui.fragment.profile_fragment;

import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import io.realm.Realm;

public interface ProfileView extends BaseFragmentView {
    void startDialogFragmentForResult();

    void resetText();

    boolean checkAvailabilityTouchId();

    Realm getRealm();
}
