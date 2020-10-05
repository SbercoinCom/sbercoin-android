package org.sbercoin.wallet.ui.fragment.contract_confirm_fragment;

import org.sbercoin.wallet.SBERApplication;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

public interface ContractConfirmView extends BaseFragmentView {

    void makeToast(String s);

    SBERApplication getApplication();

    String getContractName();

    void updateFee(double minFee, double maxFee);

    void updateGasPrice(int minGasPrice, int maxGasPrice);

    void updateGasLimit(int minGasLimit, int maxGasLimit);

    void closeFragments();
}
