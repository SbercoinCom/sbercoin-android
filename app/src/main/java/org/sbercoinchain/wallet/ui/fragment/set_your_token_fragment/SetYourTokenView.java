package org.sbercoin.wallet.ui.fragment.set_your_token_fragment;

import org.sbercoin.wallet.model.contract.ContractMethodParameter;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface SetYourTokenView extends BaseFragmentView {
    void onContractConstructorPrepared(List<ContractMethodParameter> params);
}
