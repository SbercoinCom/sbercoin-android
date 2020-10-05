package org.sbercoin.wallet.ui.fragment.other_tokens;

import org.sbercoin.wallet.model.contract.Token;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface OtherTokensView extends BaseFragmentView {
    void setTokensData(List<Token> tokensData);

    void updateTokensData(List<Token> tokensData);
}
