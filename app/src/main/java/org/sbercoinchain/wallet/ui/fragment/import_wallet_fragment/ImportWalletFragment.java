package org.sbercoin.wallet.ui.fragment.import_wallet_fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import org.sbercoin.wallet.ui.base.base_fragment.BaseFragment;
import org.sbercoin.wallet.ui.fragment.pin_fragment.PinAction;
import org.sbercoin.wallet.ui.fragment.pin_fragment.PinFragment;
import org.sbercoin.wallet.ui.fragment_factory.Factory;
import org.sbercoin.wallet.utils.FontButton;
import org.sbercoin.wallet.utils.FontEditText;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class ImportWalletFragment extends BaseFragment implements ImportWalletView
{

    private final int LAYOUT = org.sbercoin.wallet.R.layout.fragment_import_wallet;
    @BindView(org.sbercoin.wallet.R.id.bt_cancel)
    FontButton mButtonCancel;
    @BindView(org.sbercoin.wallet.R.id.bt_import)
    FontButton mButtonImport;
    @BindView(org.sbercoin.wallet.R.id.et_your_brain_code)
    FontEditText mEditTextYourBrainCode;
    private ImportWalletPresenter mImportWalletFragmentPresenter;

    public static BaseFragment newInstance(Context context)
    {
        Bundle args = new Bundle();
        BaseFragment fragment = Factory.instantiateFragment(context, ImportWalletFragment.class);
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({org.sbercoin.wallet.R.id.bt_cancel, org.sbercoin.wallet.R.id.bt_import})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case org.sbercoin.wallet.R.id.bt_cancel:
                getMainActivity().onBackPressed();
                break;
            case org.sbercoin.wallet.R.id.bt_import:
                getPresenter().onImportClick(mEditTextYourBrainCode.getText().toString().trim());
                break;
        }
    }

    @Override
    protected void createPresenter()
    {
        mImportWalletFragmentPresenter = new ImportWalletPresenterImpl(this, new ImportWalletInteractorImpl(getContext()));
    }

    @Override
    protected ImportWalletPresenter getPresenter()
    {
        return mImportWalletFragmentPresenter;
    }

    @Override
    public void openPinFragment(String passphrase, PinAction action)
    {
        BaseFragment pinFragment = PinFragment.newInstance(action, passphrase, getContext());
        openRootFragment(pinFragment);
    }

    @Override
    public void initializeViews()
    {
        super.initializeViews();

        mEditTextYourBrainCode.setFocusableInTouchMode(true);
        mEditTextYourBrainCode.requestFocus();
        mButtonImport.setEnabled(false);
        mEditTextYourBrainCode.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                getPresenter().onPassphraseChange(editable.toString());
            }
        });
        showSoftInput();
    }

    @Override
    protected int getLayout()
    {
        return LAYOUT;
    }

    @Override
    public void enableImportButton()
    {
        mButtonImport.setEnabled(true);
    }

    @Override
    public void disableImportButton()
    {
        mButtonImport.setEnabled(false);
    }
}
