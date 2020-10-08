package org.sbercoin.wallet.ui.fragment.news_fragment;

import android.content.Context;

import org.sbercoin.wallet.dataprovider.rest_api.medium.MediumService;
import org.sbercoin.wallet.datastorage.TinyDB;
import org.sbercoin.wallet.model.news.News;
import org.sbercoin.wallet.model.news.RssFeed;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;
import rx.internal.util.SubscriptionList;

public class NewsInteractorImpl implements NewsInteractor
{

    private final String MEDIUM_SBER_CHANEL = "@bs.world";
    private WeakReference<Context> mContext;
    private SubscriptionList mSubscriptionList = new SubscriptionList();

    public NewsInteractorImpl(Context context)
    {
        mContext = new WeakReference<>(context);
    }

    @Override
    public Observable<RssFeed> getMediumRssFeed()
    {
        return MediumService.getInstance().getRssFeed(MEDIUM_SBER_CHANEL);
    }

    @Override
    public List<News> getNewses()
    {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getNewsList();
    }

    @Override
    public void setNewses(List<News> newses)
    {
        TinyDB tinyDB = new TinyDB(mContext.get());
        tinyDB.putNewsList(newses);
    }

    @Override
    public void unSubscribe()
    {
        mSubscriptionList.clear();
    }
}
