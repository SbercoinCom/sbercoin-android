package org.sbercoin.wallet.ui.fragment.qstore_by_type.dark;

import org.sbercoin.wallet.model.gson.qstore.QSearchItem;
import org.sbercoin.wallet.ui.fragment.qstore_by_type.QStoreByTypeFragment;
import org.sbercoin.wallet.ui.fragment.qstore_by_type.StoreSearchAdapter;

import java.util.List;

public class QStoreByTypeFragmentDark extends QStoreByTypeFragment {

    @Override
    protected int getLayout() {
        return org.sbercoin.wallet.R.layout.lyt_q_store;
    }

    @Override
    public void setSearchResult(List<QSearchItem> items) {
        searchAdapter = new StoreSearchAdapter(items, this, org.sbercoin.wallet.R.layout.lyt_store_search_list_item);
        contentList.setAdapter(searchAdapter);
    }
}
