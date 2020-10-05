package org.sbercoin.wallet.ui.fragment.qstore;

import org.sbercoin.wallet.model.gson.qstore.QSearchItem;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;
import org.sbercoin.wallet.ui.fragment.qstore.categories.QstoreCategory;

import java.util.List;

public interface QStoreView extends BaseFragmentView {
    void setCategories(List<QstoreCategory> categories);

    void setSearchResult(List<QSearchItem> items);

    void setSearchBarText(String text);

    String getSeacrhBarText();
}
