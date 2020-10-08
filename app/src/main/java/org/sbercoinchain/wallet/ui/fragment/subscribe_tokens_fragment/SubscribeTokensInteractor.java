package org.sbercoin.wallet.ui.fragment.subscribe_tokens_fragment;

import org.sbercoin.wallet.model.contract.Token;

import java.util.List;

public interface SubscribeTokensInteractor
{
    void saveTokenList(List<Token> tokens);

    List<Token> getTokenList();
}
