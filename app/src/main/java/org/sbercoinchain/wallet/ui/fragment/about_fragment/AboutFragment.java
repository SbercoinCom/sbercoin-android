package org.sbercoin.wallet.ui.fragment.about_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import org.sbercoin.wallet.model.Version;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragment;
import org.sbercoin.wallet.ui.fragment_factory.Factory;
import org.sbercoin.wallet.utils.FontTextView;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class AboutFragment extends BaseFragment implements AboutView
{

    AboutPresenter mAboutFragmentPresenter;
    @BindView(org.sbercoin.wallet.R.id.tv_sbercoin_version)
    FontTextView mTextViewSBERVersion;

    public static BaseFragment newInstance(Context context)
    {
        Bundle args = new Bundle();
        BaseFragment fragment = Factory.instantiateFragment(context, AboutFragment.class);
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({org.sbercoin.wallet.R.id.ibt_back})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case org.sbercoin.wallet.R.id.ibt_back:
                getActivity().onBackPressed();
                break;
        }
    }

    @Override
    public void updateVersion(Version version)
    {
        String footer = getString(org.sbercoin.wallet.R.string._2017_sbercoin_n_skynet_testnet_version) + "Version " + version.getVersionName() + "(" + version.getVersionCode() + ")";
        mTextViewSBERVersion.setText(footer);
    }

    @Override
    protected void createPresenter()
    {
        mAboutFragmentPresenter = new AboutPresenterImpl(this, new AboutInteractorImpl(getContext()));
    }

    @Override
    protected AboutPresenter getPresenter()
    {
        return mAboutFragmentPresenter;
    }
}