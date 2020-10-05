package org.sbercoin.wallet.ui.fragment.watch_token_fragment.light;

import org.sbercoin.wallet.model.ContractTemplate;
import org.sbercoin.wallet.ui.fragment.watch_contract_fragment.OnTemplateClickListener;
import org.sbercoin.wallet.ui.fragment.watch_contract_fragment.TemplatesAdapter;
import org.sbercoin.wallet.ui.fragment.watch_contract_fragment.WatchContractFragment;
import org.sbercoin.wallet.ui.fragment.watch_token_fragment.WatchTokenFragment;
import org.sbercoin.wallet.utils.FontManager;

import java.util.List;

public class WatchTokenFragmentLight extends WatchTokenFragment {

    @Override
    protected int getLayout() {
        return org.sbercoin.wallet.R.layout.fragment_watch_token_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mEditTextContractName.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.sbercoin.wallet.R.string.proximaNovaSemibold)));
        mEditTextContractAddress.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.sbercoin.wallet.R.string.proximaNovaSemibold)));
    }

}
