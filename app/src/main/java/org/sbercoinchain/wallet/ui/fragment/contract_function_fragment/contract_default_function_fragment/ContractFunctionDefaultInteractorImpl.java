package org.sbercoin.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment;

import android.content.Context;

import org.bitcoinj.script.Script;
import org.sbercoin.wallet.dataprovider.rest_api.sbercoin.SBERService;
import org.sbercoin.wallet.datastorage.FileStorageManager;
import org.sbercoin.wallet.datastorage.KeyStorage;
import org.sbercoin.wallet.datastorage.SBERSettingSharedPreference;
import org.sbercoin.wallet.datastorage.SBERSharedPreference;
import org.sbercoin.wallet.datastorage.TinyDB;
import org.sbercoin.wallet.model.contract.Contract;
import org.sbercoin.wallet.model.contract.ContractMethod;
import org.sbercoin.wallet.model.contract.ContractMethodParameter;
import org.sbercoin.wallet.model.gson.CallSmartContractRequest;
import org.sbercoin.wallet.model.gson.SendRawTransactionRequest;
import org.sbercoin.wallet.model.gson.SendRawTransactionResponse;
import org.sbercoin.wallet.model.gson.UnspentOutput;
import org.sbercoin.wallet.model.gson.call_smart_contract_response.CallSmartContractResponse;
import org.sbercoin.wallet.utils.ContractBuilder;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.List;

import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;

public class ContractFunctionDefaultInteractorImpl implements ContractFunctionDefaultInteractor {

    private WeakReference<Context> mContext;

    public ContractFunctionDefaultInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public List<ContractMethod> getContractMethod(String contractTemplateUiid) {
        return FileStorageManager.getInstance().getContractMethods(mContext.get(), contractTemplateUiid);
    }

    @Override
    public BigDecimal getFeePerKb() {
        SBERSettingSharedPreference sbercoinSettingSharedPreference = SBERSettingSharedPreference.getInstance();
        return new BigDecimal(sbercoinSettingSharedPreference.getFeePerKb(mContext.get()));
    }

    @Override
    public int getMinGasPrice() {
        return SBERSharedPreference.getInstance().getMinGasPrice(mContext.get());
    }

    @Override
    public Observable<CallSmartContractRespWrapper> callSmartContractObservable(final String methodName, final List<ContractMethodParameter> contractMethodParameterList, final Contract contract, final String addressFrom) {
        final CallSmartContractRespWrapper wrapper = new CallSmartContractRespWrapper();
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                ContractBuilder contractBuilder = new ContractBuilder();
                return contractBuilder.createAbiMethodParams(methodName, contractMethodParameterList);
            }
        }).flatMap(new Func1<String, Observable<CallSmartContractResponse>>() {
            @Override
            public Observable<CallSmartContractResponse> call(String s) {
                wrapper.setAbiParams(s);
                return SBERService.newInstance().callSmartContract(contract.getContractAddress(), new CallSmartContractRequest(new String[]{s}, addressFrom));
            }
        }).map(new Func1<CallSmartContractResponse, CallSmartContractRespWrapper>() {
            @Override
            public CallSmartContractRespWrapper call(CallSmartContractResponse response) {
                wrapper.setResponse(response);
                return wrapper;
            }
        });
    }

    @Override
    public Observable<List<UnspentOutput>> unspentOutputsForAddressObservable(final String address) {
        return Observable.defer(new Func0<Observable<List<UnspentOutput>>>() {
            @Override
            public Observable<List<UnspentOutput>> call() {
                return SBERService.newInstance().getUnspentOutputs(address);
            }
        });
    }

    @Override
    public String createTransactionHash(String abiParams, List<UnspentOutput> unspentOutputs, int gasLimit, int gasPrice, BigDecimal feePerKb, String fee, final String contractAddress, String sendToContract, String passphrase) {
        ContractBuilder contractBuilder = new ContractBuilder();
        Script script = contractBuilder.createMethodScript(abiParams, gasLimit, gasPrice, contractAddress);

        return contractBuilder.createTransactionHash(script, unspentOutputs, gasLimit, gasPrice, feePerKb, fee, sendToContract,mContext.get(), passphrase);
    }

    @Override
    public Observable<SendRawTransactionResponse> sendRawTransactionObservable(String code) {
        return SBERService.newInstance().sendRawTransaction(new SendRawTransactionRequest(code, 1));
    }

    @Override
    public Contract getContractByAddress(String address) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        for (Contract contract : tinyDB.getContractList()) {
            if (contract.getContractAddress().equals(address)) {
                return contract;
            }
        }
        return null;
    }

    @Override
    public List<String> getAddresses() {
        return KeyStorage.getInstance().getAddresses();
    }

    @Override
    public Observable<List<UnspentOutput>> getUnspentOutputs(List<String> addresses) {
        return SBERService.newInstance().getUnspentOutputsForSeveralAddresses(addresses);
    }

    public static class CallSmartContractRespWrapper {
        private String abiParams;
        private CallSmartContractResponse response;

        public CallSmartContractRespWrapper(String abiParams, CallSmartContractResponse response) {
            this.abiParams = abiParams;
            this.response = response;
        }

        public CallSmartContractRespWrapper() {

        }

        public String getAbiParams() {
            return abiParams;
        }

        public void setAbiParams(String abiParams) {
            this.abiParams = abiParams;
        }

        public CallSmartContractResponse getResponse() {
            return response;
        }

        public void setResponse(CallSmartContractResponse response) {
            this.response = response;
        }
    }
}
