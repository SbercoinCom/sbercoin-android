package org.sbercoin.wallet.ui.fragment.addresses_detail_fragment;

import android.content.Context;

import org.sbercoin.wallet.model.gson.history.History;
import org.sbercoin.wallet.model.gson.token_history.TokenHistory;

import java.lang.ref.WeakReference;
import java.util.List;

import io.realm.Realm;

class AddressesDetailInteractorImpl implements AddressesDetailInteractor {

    WeakReference<Context> mContext;

    public AddressesDetailInteractorImpl(Context context) {
        mContext = new WeakReference<Context>(context);
    }

    @Override
    public History getHistory(String txHash) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(History.class)
                .equalTo("txHash", txHash)
                .findFirst();
    }

    @Override
    public TokenHistory getTokenHistory(String txHash) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(TokenHistory.class)
                .equalTo("txHash", txHash)
                .findFirst();
    }
}