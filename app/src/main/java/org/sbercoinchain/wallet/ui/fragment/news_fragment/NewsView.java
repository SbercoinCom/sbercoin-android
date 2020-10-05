package org.sbercoin.wallet.ui.fragment.news_fragment;

import org.sbercoin.wallet.model.news.News;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface NewsView extends BaseFragmentView {
    void startRefreshAnimation();

    void setAdapterNull();

    void updateNews(List<News> newses);

    void stopRefreshRecyclerAnimation();
}