package org.sbercoin.wallet.ui.fragment.contract_management_fragment;

import android.support.annotation.StringRes;

import org.sbercoin.wallet.model.contract.ContractMethod;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface ContractManagementView extends BaseFragmentView
{
    void setRecyclerView(List<ContractMethod> contractMethodList, boolean needToGetValue);

    String getContractTemplateUiid();

    String getContractAddress();

    String getContractABI();

    void setTitleText(@StringRes int resId);
}
