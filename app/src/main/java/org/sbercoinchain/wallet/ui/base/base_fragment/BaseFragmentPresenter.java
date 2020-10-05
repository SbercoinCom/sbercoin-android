package org.sbercoin.wallet.ui.base.base_fragment;

import org.sbercoin.wallet.ui.base.base_activity.BasePresenter;

public interface BaseFragmentPresenter extends BasePresenter {
    void onViewCreated();

    void onDestroyView();
}
