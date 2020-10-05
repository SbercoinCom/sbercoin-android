package org.sbercoin.wallet.ui.activity.main_activity;

import android.content.Context;

import org.sbercoin.wallet.dataprovider.rest_api.bcs.BCSService;
import org.sbercoin.wallet.datastorage.KeyStorage;
import org.sbercoin.wallet.datastorage.BCSSettingSharedPreference;
import org.sbercoin.wallet.datastorage.BCSSharedPreference;
import org.sbercoin.wallet.datastorage.listeners.LanguageChangeListener;
import org.sbercoin.wallet.model.gson.DGPInfo;
import org.sbercoin.wallet.model.gson.FeePerKb;

import java.math.BigDecimal;

import rx.Observable;

class MainActivityInteractorImpl implements MainActivityInteractor {

    private Context mContext;

    private boolean isDGPInfoLoaded = false;
    private boolean isFeePerkbLoaded = false;

    MainActivityInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public boolean getKeyGeneratedInstance() {
        return BCSSharedPreference.getInstance().getKeyGeneratedInstance(mContext);
    }

    @Override
    public void clearStatic() {
        KeyStorage.getInstance().clearKeyStorage();
    }

    @Override
    public Observable<DGPInfo> getDGPInfo() {
        return BCSService.newInstance().getDGPInfo();
    }

    @Override
    public boolean isDGPInfoLoaded() {
        return isDGPInfoLoaded;
    }

    @Override
    public boolean isFeePerkbLoaded() {
        return isFeePerkbLoaded;
    }

    @Override
    public void addLanguageChangeListener(LanguageChangeListener languageChangeListener) {
        BCSSettingSharedPreference.getInstance().addLanguageListener(languageChangeListener);
    }

    @Override
    public void removeLanguageChangeListener(LanguageChangeListener languageChangeListener) {
        BCSSettingSharedPreference.getInstance().removeLanguageListener(languageChangeListener);
    }

    @Override
    public Observable<FeePerKb> getFeePerKb() {
        return BCSService.newInstance().getEstimateFeePerKb(2);
    }

    @Override
    public void setDGPInfo(DGPInfo dgpInfo) {
        isDGPInfoLoaded = true;
        BCSSharedPreference.getInstance().setMinGasPrice(mContext, dgpInfo.getMingasprice());
    }

    @Override
    public void setFeePerKb(FeePerKb feePerKb) {
        isFeePerkbLoaded = true;
        BCSSettingSharedPreference bcsSettingSharedPreference = BCSSettingSharedPreference.getInstance();
        bcsSettingSharedPreference.setFeePerKb(mContext, feePerKb.getFeePerKb().setScale(5, BigDecimal.ROUND_HALF_DOWN).toPlainString());
    }
}
