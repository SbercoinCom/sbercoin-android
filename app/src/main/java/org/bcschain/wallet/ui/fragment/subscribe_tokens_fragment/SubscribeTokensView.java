package org.sbercoin.wallet.ui.fragment.subscribe_tokens_fragment;

import org.sbercoin.wallet.model.contract.Token;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface SubscribeTokensView extends BaseFragmentView {

    void setTokenList(List<Token> tokenList);

    void setPlaceHolder();
}
