package org.sbercoin.wallet.ui.fragment.qstore;

import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface QStorePresenter extends BaseFragmentPresenter {
    void searchItems(String seacrhBarText, boolean checked);
}
