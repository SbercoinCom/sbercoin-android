package org.sbercoin.wallet.ui.fragment.bcs_cash_management_fragment;

import org.sbercoin.wallet.model.gson.UnspentOutput;

import java.util.List;

import rx.Observable;

public interface AddressListInteractor {
    List<String> getAddresses();

    Observable<List<UnspentOutput>> getUnspentOutputs(List<String> addresses);
}
