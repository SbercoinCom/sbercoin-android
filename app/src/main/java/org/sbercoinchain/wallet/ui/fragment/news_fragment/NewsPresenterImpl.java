package org.sbercoin.wallet.ui.fragment.news_fragment;

import org.sbercoin.wallet.datastorage.NewsStorage;
import org.sbercoin.wallet.model.news.News;
import org.sbercoin.wallet.model.news.RssFeed;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragment;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenterImpl;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsPresenterImpl extends BaseFragmentPresenterImpl implements NewsPresenter {

    private NewsView mNewsFragmentView;
    private NewsInteractor mNewsFragmentInteractor;
    private boolean mNetworkConnectedFlag = false;

    public NewsPresenterImpl(NewsView newsFragmentView, NewsInteractor newsInteractor) {
        mNewsFragmentView = newsFragmentView;
        mNewsFragmentInteractor = newsInteractor;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getInteractor().unSubscribe();
    }

    private NewsInteractor getInteractor() {
        return mNewsFragmentInteractor;
    }

    @Override
    public NewsView getView() {
        return mNewsFragmentView;
    }

    @Override
    public void onRefresh() {
        if (mNetworkConnectedFlag) {
            loadAndUpdateNews();
        } else {
            getView().setAlertDialog(org.sbercoin.wallet.R.string.no_internet_connection,
                    org.sbercoin.wallet.R.string.please_check_your_network_settings,
                    org.sbercoin.wallet.R.string.ok,
                    BaseFragment.PopUpType.error);
            getView().stopRefreshRecyclerAnimation();
        }
    }

    @Override
    public void onNetworkStateChanged(boolean networkConnectedFlag) {
        mNetworkConnectedFlag = networkConnectedFlag;
        if (networkConnectedFlag) {
            loadAndUpdateNews();
        } else {
            getView().updateNews(getInteractor().getNewses());
            NewsStorage.newInstance().setNewses(getInteractor().getNewses());
        }
    }

    private void loadAndUpdateNews() {
        getView().startRefreshAnimation();
        getInteractor().getMediumRssFeed()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RssFeed>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(RssFeed rssFeed) {
                        List<News> newNews = rssFeed.getNewses();
                        List<News> oldNews = getInteractor().getNewses();
                        if (oldNews.size() == 0) {
                            oldNews.addAll(newNews);
                        } else {
                            int pos = 0;
                            News lastNews = oldNews.get(0);
                            for (News news : newNews) {
                                if (!news.getPubDate().equals(lastNews.getPubDate())) {
                                    oldNews.add(pos, news);
                                    pos++;
                                } else {
                                    break;
                                }
                            }
                        }
                        NewsStorage.newInstance().setNewses(oldNews);
                        getInteractor().setNewses(oldNews);
                        getView().updateNews(oldNews);
                    }
                });
    }
}
