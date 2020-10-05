package org.sbercoin.wallet.ui.fragment.watch_token_fragment;

import org.sbercoin.wallet.model.ContractTemplate;
import org.sbercoin.wallet.model.contract.Contract;
import org.sbercoin.wallet.model.gson.ContractParams;

import java.util.List;

import rx.Observable;

public interface WatchTokenInteractor {
    List<ContractTemplate> getContractTemplates();

    int compareDates(String date, String date1);

    String readAbiContract(String uuid);

    boolean isValidContractAddress(String address);

    List<Contract> getContracts();

    String handleContractWithToken(String name, String address, String ABIInterface);

    String getQRC20TokenStandardAbi();

    Observable<ContractParams> getContractParams(String contractAddress);
}
