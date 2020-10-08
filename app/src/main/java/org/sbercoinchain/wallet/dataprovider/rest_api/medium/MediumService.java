package org.sbercoin.wallet.dataprovider.rest_api.medium;

import org.sbercoin.wallet.model.news.RssFeed;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.SimpleXmlConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;

public class MediumService
{

    private static MediumService sMediumService;
    private final String MEDIUM_BASE_URL = "https://medium.com/";
    private MediumRssFeedService mMediumRssFeedService;

    private MediumService()
    {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MEDIUM_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        mMediumRssFeedService = retrofit.create(MediumRssFeedService.class);

    }

    public static MediumService getInstance()
    {
        if (sMediumService == null)
        {
            sMediumService = new MediumService();
        }
        return sMediumService;
    }

    public Observable<RssFeed> getRssFeed(String channel)
    {
        return mMediumRssFeedService.getRssFeed(channel);
    }

}
