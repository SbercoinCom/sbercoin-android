package org.sbercoin.wallet.ui.fragment.other_tokens.light;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.model.contract.Token;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragment;
import org.sbercoin.wallet.ui.fragment.other_tokens.OtherTokensFragment;
import org.sbercoin.wallet.ui.fragment.token_fragment.TokenFragment;

import java.util.List;

public class OtherTokensFragmentLight extends OtherTokensFragment {

    @Override
    protected int getLayout() {
        return org.sbercoin.wallet.R.layout.lyt_other_tokens_light;
    }

    @Override
    public void setTokensData(List<Token> tokensData) {
        tokensList.setAdapter(new TokensAdapterLight(tokensData, this, this));
    }

    @Override
    public void onTokenClick(int adapterPosition) {
        if (tokensList.getAdapter() != null) {
            Token token = (Token)((TokensAdapterLight) tokensList.getAdapter()).get(adapterPosition);
            if(token.getSupportFlag()) {
                BaseFragment tokenFragment = TokenFragment.newInstance(getContext(), token);
                openFragment(tokenFragment);
            } else {
                setAlertDialog(getString(R.string.token_unsupported_reason),getString(R.string.ok),PopUpType.error);
            }
        }
    }
}
