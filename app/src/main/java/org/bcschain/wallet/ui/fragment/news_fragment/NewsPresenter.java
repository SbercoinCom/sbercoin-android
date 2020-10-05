package org.sbercoin.wallet.ui.fragment.news_fragment;

import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface NewsPresenter extends BaseFragmentPresenter {
    void onRefresh();

    void onNetworkStateChanged(boolean networkConnectedFlag);
}
