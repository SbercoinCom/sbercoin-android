package org.sbercoin.wallet.ui.activity.main_activity;

import android.content.Context;

import org.sbercoin.wallet.dataprovider.rest_api.sbercoin.SBERService;
import org.sbercoin.wallet.datastorage.KeyStorage;
import org.sbercoin.wallet.datastorage.SBERSettingSharedPreference;
import org.sbercoin.wallet.datastorage.SBERSharedPreference;
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
        return SBERSharedPreference.getInstance().getKeyGeneratedInstance(mContext);
    }

    @Override
    public void clearStatic() {
        KeyStorage.getInstance().clearKeyStorage();
    }

    @Override
    public Observable<DGPInfo> getDGPInfo() {
        return SBERService.newInstance().getDGPInfo();
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
        SBERSettingSharedPreference.getInstance().addLanguageListener(languageChangeListener);
    }

    @Override
    public void removeLanguageChangeListener(LanguageChangeListener languageChangeListener) {
        SBERSettingSharedPreference.getInstance().removeLanguageListener(languageChangeListener);
    }

    @Override
    public Observable<FeePerKb> getFeePerKb() {
        return SBERService.newInstance().getEstimateFeePerKb(2);
    }

    @Override
    public void setDGPInfo(DGPInfo dgpInfo) {
        isDGPInfoLoaded = true;
        SBERSharedPreference.getInstance().setMinGasPrice(mContext, dgpInfo.getMingasprice());
    }

    @Override
    public void setFeePerKb(FeePerKb feePerKb) {
        isFeePerkbLoaded = true;
        SBERSettingSharedPreference sbercoinSettingSharedPreference = SBERSettingSharedPreference.getInstance();
        sbercoinSettingSharedPreference.setFeePerKb(mContext, feePerKb.getFeePerKb().setScale(5, BigDecimal.ROUND_HALF_DOWN).toPlainString());
    }
}
