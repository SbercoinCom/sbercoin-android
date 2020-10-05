package org.sbercoin.wallet.ui.fragment.wallet_fragment;

import org.sbercoin.wallet.model.gson.history.History;

import javax.annotation.Nullable;

import io.realm.OrderedCollectionChangeSet;
import io.realm.RealmResults;


public interface HistoryInDbChangeListener<T>{
    void onHistoryChange(RealmResults<T> histories, @Nullable OrderedCollectionChangeSet changeSet);
}
