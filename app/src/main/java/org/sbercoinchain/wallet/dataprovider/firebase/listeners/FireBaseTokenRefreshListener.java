package org.sbercoin.wallet.dataprovider.firebase.listeners;

public interface FireBaseTokenRefreshListener {
    void onRefresh(String prevToken, String currentToken);
}
