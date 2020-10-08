package org.sbercoin.wallet.ui.activity.main_activity;

import org.sbercoin.wallet.datastorage.listeners.LanguageChangeListener;
import org.sbercoin.wallet.model.gson.DGPInfo;
import org.sbercoin.wallet.model.gson.FeePerKb;

import rx.Observable;

public interface MainActivityInteractor
{
    boolean getKeyGeneratedInstance();

    void clearStatic();

    Observable<FeePerKb> getFeePerKb();

    void setFeePerKb(FeePerKb feePerKb);

    Observable<DGPInfo> getDGPInfo();

    void setDGPInfo(DGPInfo dgpInfo);

    boolean isDGPInfoLoaded();

    boolean isFeePerkbLoaded();

    void addLanguageChangeListener(LanguageChangeListener languageChangeListener);

    void removeLanguageChangeListener(LanguageChangeListener languageChangeListener);
}
