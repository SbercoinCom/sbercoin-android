package org.sbercoin.wallet.ui.fragment.set_your_token_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.datastorage.TinyDB;
import org.sbercoin.wallet.model.ContractTemplate;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragment;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenterImpl;
import org.sbercoin.wallet.ui.fragment.contract_confirm_fragment.ContractConfirmFragment;
import org.sbercoin.wallet.ui.fragment_factory.Factory;
import org.sbercoin.wallet.utils.FontEditText;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class SetYourTokenFragment extends BaseFragment implements SetYourTokenView, OnValidateParamsListener
{

    protected final static String CONTRACT_TEMPLATE_UIID = "mUiid";

    protected String templateUiid;

    protected ConstructorAdapter adapter;
    protected SetYourTokenPresenterImpl presenter;
    @BindView(R.id.recycler_view)
    protected
    RecyclerView constructorList;
    @BindView(R.id.tv_template_name)
    FontEditText mTextViewTemplateName;
    @BindView(R.id.confirm)
    Button confirmBtn;

    public static BaseFragment newInstance(Context context, String uiid)
    {
        Bundle args = new Bundle();
        BaseFragment fragment = Factory.instantiateFragment(context, SetYourTokenFragment.class);
        args.putString(CONTRACT_TEMPLATE_UIID, uiid);
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({R.id.ibt_back})
    public void onBackClick()
    {
        getActivity().onBackPressed();
    }

    @OnClick(R.id.confirm)
    public void onConfirmClick()
    {
        if (adapter != null)
        {
            String name = mTextViewTemplateName.getText().toString();
            if (adapter.validateMethods() && !name.isEmpty())
            {
                BaseFragment fragment = ContractConfirmFragment.newInstance(getContext(), adapter.getParams(), getArguments().getString(CONTRACT_TEMPLATE_UIID), name);
                openFragment(fragment);
            }
        }
    }

    @Override
    protected void createPresenter()
    {
        presenter = new SetYourTokenPresenterImpl(this, new SetYourTokenInteractorImpl(getContext()));
    }

    @Override
    protected BaseFragmentPresenterImpl getPresenter()
    {
        return presenter;
    }

    @Override
    public void initializeViews()
    {
        super.initializeViews();
        constructorList.setLayoutManager(new LinearLayoutManager(getContext()));
        templateUiid = getArguments().getString(CONTRACT_TEMPLATE_UIID);
        presenter.getConstructorByUiid(templateUiid);

        String templateName = "";
        TinyDB tinyDB = new TinyDB(getContext());
        List<ContractTemplate> contractTemplateList = tinyDB.getContractTemplateList();
        for (ContractTemplate contractTemplate : contractTemplateList)
        {
            if (contractTemplate.getUuid().equals(templateUiid))
            {
                templateName = contractTemplate.getName();
                break;
            }
        }

        mTextViewTemplateName.setText(templateName);
    }

    @Override
    public void onResume()
    {
        //hideBottomNavView(false);
        super.onResume();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        //showBottomNavView(false);
    }

    @Override
    public void onValidate()
    {
        confirmBtn.setEnabled(adapter.validateMethods());
    }
}
