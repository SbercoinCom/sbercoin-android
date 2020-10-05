package org.sbercoin.wallet.ui.fragment.set_your_token_fragment;

import android.content.Context;

import org.sbercoin.wallet.datastorage.FileStorageManager;
import org.sbercoin.wallet.model.contract.ContractMethod;

import java.lang.ref.WeakReference;

public class SetYourTokenInteractorImpl implements SetYourTokenInteractor {
    private WeakReference<Context> mContext;

    public SetYourTokenInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public ContractMethod getContractConstructor(String uiid) {
        return FileStorageManager.getInstance().getContractConstructor(mContext.get(), uiid);
    }
}
