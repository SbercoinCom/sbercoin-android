package org.sbercoin.wallet.ui.fragment.start_page_fragment.dark;

import android.support.v4.content.ContextCompat;
import android.view.View;

import org.sbercoin.wallet.ui.fragment.start_page_fragment.StartPageFragment;

public class StartPageFragmentDark extends StartPageFragment
{
    @Override
    protected int getLayout()
    {
        return org.sbercoin.wallet.R.layout.fragment_start_page;
    }

    @Override
    public void initializeViews()
    {
        super.initializeViews();
    }

    @Override
    public void hideLoginButton()
    {
        mButtonLogin.setVisibility(View.GONE);
        mButtonCreateNew.setBackgroundColor(ContextCompat.getColor(getContext(), org.sbercoin.wallet.R.color.accent_red_color));
        mButtonCreateNew.setTextColor(ContextCompat.getColor(getContext(), org.sbercoin.wallet.R.color.background));
    }
}
