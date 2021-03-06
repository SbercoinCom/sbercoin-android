package org.sbercoin.wallet.ui.fragment.deleted_contract_fragment;


import android.content.Context;

import org.sbercoin.wallet.datastorage.TinyDB;
import org.sbercoin.wallet.model.contract.Contract;
import org.sbercoin.wallet.model.contract.Token;

import java.lang.ref.WeakReference;
import java.util.List;

public class DeletedContractInteractorImpl implements DeletedContractInteractor
{

    WeakReference<Context> mContext;

    DeletedContractInteractorImpl(Context context)
    {
        mContext = new WeakReference<Context>(context);
    }

    @Override
    public List<Contract> getContractsWithoutTokens()
    {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getContractListWithoutToken();
    }

    @Override
    public List<Token> getTokens()
    {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getTokenList();
    }

    @Override
    public void setTokens(List<Token> tokens)
    {
        TinyDB tinyDB = new TinyDB(mContext.get());
        tinyDB.putTokenList(tokens);
    }

    @Override
    public void setContractWithoutTokens(List<Contract> contracts)
    {
        TinyDB tinyDB = new TinyDB(mContext.get());
        tinyDB.putContractListWithoutToken(contracts);
    }

}
