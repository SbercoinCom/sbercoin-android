package org.sbercoin.wallet.ui.fragment.watch_token_fragment.dark;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.ui.fragment.watch_token_fragment.WatchTokenFragment;
import org.sbercoin.wallet.utils.FontManager;

public class WatchTokenFragmentDark extends WatchTokenFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_watch_token;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mEditTextContractName.setTypeface(FontManager.getInstance().getFont(getResources().getString(R.string.simplonMonoMedium)));
        mEditTextContractAddress.setTypeface(FontManager.getInstance().getFont(getResources().getString(R.string.simplonMonoMedium)));
    }

}
