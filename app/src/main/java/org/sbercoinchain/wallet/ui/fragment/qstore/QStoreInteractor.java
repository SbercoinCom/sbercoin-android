package org.sbercoin.wallet.ui.fragment.qstore;

import org.sbercoin.wallet.model.gson.qstore.QSearchItem;
import org.sbercoin.wallet.model.gson.qstore.QstoreItem;

import java.util.List;

import rx.Observable;

public interface QStoreInteractor
{
    Observable<List<QSearchItem>> searchContracts(int searchOffset, String emptyType, String tag, boolean byTag);

    Observable<List<QstoreItem>> getWhatsNewObservable();

    Observable<List<QstoreItem>> getTrendingNowObservable();

    String getTrendingString();

    String getWhatsNewString();
}
