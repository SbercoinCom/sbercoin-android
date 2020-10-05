package org.sbercoin.wallet.ui.fragment.sbercoin_cash_management_fragment;

import android.content.Context;

import org.sbercoin.wallet.dataprovider.rest_api.sbercoin.SBERService;
import org.sbercoin.wallet.datastorage.KeyStorage;

import org.sbercoin.wallet.model.gson.UnspentOutput;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class AddressListInteractorImpl implements AddressListInteractor {

    AddressListInteractorImpl() {
    }

    @Override
    public List<String> getAddresses() {
        return KeyStorage.getInstance().getAddresses();
    }

    @Override
    public Observable<List<UnspentOutput>> getUnspentOutputs(List<String> addresses) {
        return SBERService.newInstance().getUnspentOutputsForSeveralAddresses(addresses);
    }
}