package org.sbercoin.wallet.ui.fragment.my_contracts_fragment;

import org.sbercoin.wallet.model.contract.Contract;
import org.sbercoin.wallet.model.contract.Token;
import org.sbercoin.wallet.model.gson.ExistContractResponse;

import java.util.List;

import rx.Observable;

public interface MyContractsInteractor
{
    List<Contract> getContracts();

    List<Contract> getContractsWithoutTokens();

    List<Token> getTokens();

    void setTokens(List<Token> tokens);

    void setContractWithoutTokens(List<Contract> contracts);

    boolean isShowWizard();

    void setShowWizard(boolean isShow);

    Observable<ExistContractResponse> isContractExist(String contractAddress);
}
