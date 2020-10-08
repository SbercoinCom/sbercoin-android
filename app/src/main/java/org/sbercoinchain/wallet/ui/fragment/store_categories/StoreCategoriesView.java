package org.sbercoin.wallet.ui.fragment.store_categories;

import org.sbercoin.wallet.model.gson.QstoreContractType;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface StoreCategoriesView extends BaseFragmentView
{
    void setUpCategoriesList(List<QstoreContractType> list, StoreCategoryViewHolder.OnCategoryClickListener listener);
}
