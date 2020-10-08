package org.sbercoin.wallet.ui.fragment.news_detail_fragment;

import org.sbercoin.wallet.model.news.News;

public interface NewsDetailInteractor
{
    News getNews(int newsPosition);
}
