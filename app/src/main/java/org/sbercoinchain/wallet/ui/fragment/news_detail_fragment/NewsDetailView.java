package org.sbercoin.wallet.ui.fragment.news_detail_fragment;

import org.jsoup.select.Elements;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

public interface NewsDetailView extends BaseFragmentView
{
    int getNewsPosition();

    void setupElements(Elements elements);

    void setUpTitleAndDate(String title, String date);
}
