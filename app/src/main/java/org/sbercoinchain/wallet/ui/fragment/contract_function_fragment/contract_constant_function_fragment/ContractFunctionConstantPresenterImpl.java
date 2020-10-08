package org.sbercoin.wallet.ui.fragment.contract_function_fragment.contract_constant_function_fragment;

import org.sbercoin.wallet.model.contract.Contract;
import org.sbercoin.wallet.model.contract.ContractMethod;
import org.sbercoin.wallet.model.contract.ContractMethodParameter;
import org.sbercoin.wallet.model.gson.call_smart_contract_response.Item;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragment;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenterImpl;
import org.sbercoin.wallet.utils.ContractManagementHelper;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ContractFunctionConstantPresenterImpl extends BaseFragmentPresenterImpl implements ContractFunctionConstantPresenter {

    private ContractFunctionConstantView mContractMethodFragmentView;
    private ContractFunctionConstantInteractor mContractFunctionInteractor;
    private ContractMethod mContractMethod;

    public ContractFunctionConstantPresenterImpl(ContractFunctionConstantView contractMethodFragmentView, ContractFunctionConstantInteractor contractFunctionInteractor) {
        mContractMethodFragmentView = contractMethodFragmentView;
        mContractFunctionInteractor = contractFunctionInteractor;
    }

    @Override
    public ContractFunctionConstantView getView() {
        return mContractMethodFragmentView;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        List<ContractMethod> list = getInteractor().getContractMethod(getView().getContractTemplateUiid());
        for (ContractMethod contractMethod : list) {
            if (contractMethod.getName().equals(getView().getMethodName())) {
                mContractMethod = contractMethod;
                getView().setUpParameterList(contractMethod.getInputParams());
                break;
            }
        }
    }

    @Override
    public void onQueryClick(List<ContractMethodParameter> contractMethodParameterList, final String contractAddress, String methodName) {
        getView().setProgressDialog();
        for(ContractMethodParameter contract: contractMethodParameterList){
            if(contract.getValue().isEmpty()){
                getView().setAlertDialog("Invalid parameter", "Empty value","Cancel", BaseFragment.PopUpType.error);
                return;
            }
            if(contract.getType().equals("address")){
                if(contract.getValue().length()<24){
                    getView().setAlertDialog("Invalid parameter", "Minimum address length is 24", "Cancel",BaseFragment.PopUpType.error);
                    return;
                }
            }
        }
        final Contract contract = getInteractor().getContractByAddress(contractAddress);
        getInteractor().callSmartContractObservable(methodName, contractMethodParameterList, contract)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ContractFunctionConstantInteractorImpl.CallSmartContractRespWrapper>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(final ContractFunctionConstantInteractorImpl.CallSmartContractRespWrapper respWrapper) {
                        Item item = respWrapper.getResponse().getItems().get(0);
                        if (item.getExcepted().equals("None")) {
                            String queryResult = ContractManagementHelper.processResponse(mContractMethod.getOutputParams(),item.getOutput());
                            getView().dismissProgressDialog();
                            getView().updateQueryResult(queryResult);
                        }else {
                            getView().setAlertDialog(org.sbercoin.wallet.R.string.error,
                                    item.getExcepted(), "Ok",
                                    BaseFragment.PopUpType.error);
                        }

                    }
                });
    }


    public ContractFunctionConstantInteractor getInteractor() {
        return mContractFunctionInteractor;
    }
}
