package org.sbercoin.wallet.ui.fragment.my_contracts_fragment;

import android.content.Context;

import org.sbercoin.wallet.dataprovider.rest_api.sbercoin.SBERService;
import org.sbercoin.wallet.datastorage.SBERSettingSharedPreference;
import org.sbercoin.wallet.datastorage.TinyDB;
import org.sbercoin.wallet.model.contract.Contract;
import org.sbercoin.wallet.model.contract.Token;
import org.sbercoin.wallet.model.gson.ExistContractResponse;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class MyContractsInteractorImpl implements MyContractsInteractor {
    private WeakReference<Context> mContext;

    public MyContractsInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public List<Contract> getContracts() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getContractList();
    }

    @Override
    public List<Contract> getContractsWithoutTokens() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getContractListWithoutToken();
    }

    @Override
    public List<Token> getTokens() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getTokenList();
    }

    @Override
    public void setContractWithoutTokens(List<Contract> contracts) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        tinyDB.putContractListWithoutToken(contracts);
    }

    @Override
    public void setTokens(List<Token> tokens) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        tinyDB.putTokenList(tokens);
    }

    @Override
    public boolean isShowWizard() {
        SBERSettingSharedPreference sbercoinSettingSharedPreference = SBERSettingSharedPreference.getInstance();
        return sbercoinSettingSharedPreference.getShowContractsDeleteUnsubscribeWizard(mContext.get());
    }

    @Override
    public void setShowWizard(boolean isShow) {
        SBERSettingSharedPreference sbercoinSettingSharedPreference = SBERSettingSharedPreference.getInstance();
        sbercoinSettingSharedPreference.setShowContractsDeleteUnsubscribeWizard(mContext.get(), isShow);
    }

    @Override
    public Observable<ExistContractResponse> isContractExist(String contractAddress) {
        return SBERService.newInstance().isContractExist(contractAddress);
    }
}
