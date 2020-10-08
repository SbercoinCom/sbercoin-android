package org.sbercoin.wallet.ui.fragment.template_library_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.datastorage.FileStorageManager;
import org.sbercoin.wallet.model.ContractTemplate;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragment;
import org.sbercoin.wallet.ui.fragment.templates_fragment.TemplateSelectListener;
import org.sbercoin.wallet.ui.fragment.templates_fragment.TemplatesRecyclerAdapter;
import org.sbercoin.wallet.ui.fragment.watch_contract_fragment.WatchContractFragment;
import org.sbercoin.wallet.ui.fragment_factory.Factory;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class TemplateLibraryFragment extends BaseFragment implements TemplateLibraryView
{

    @BindView(R.id.recycler_view)
    RecyclerView contractList;
    TemplateLibraryPresenter mTemplateLibraryPresenterImpl;

    public static BaseFragment newInstance(Context context)
    {
        Bundle args = new Bundle();
        BaseFragment fragment = Factory.instantiateFragment(context, TemplateLibraryFragment.class);
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.ibt_back)
    public void onClick()
    {
        getActivity().onBackPressed();
    }

    @Override
    protected void createPresenter()
    {
        mTemplateLibraryPresenterImpl = new TemplateLibraryPresenterImpl(this, new TemplateLibraryInteractorImpl(getContext()));
    }

    @Override
    protected TemplateLibraryPresenter getPresenter()
    {
        return mTemplateLibraryPresenterImpl;
    }

    @Override
    public void initializeViews()
    {
        super.initializeViews();
        contractList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    protected void initializeRecyclerView(List<ContractTemplate> contractFullTemplateList, int resId)
    {
        contractList.setAdapter(new TemplatesRecyclerAdapter(contractFullTemplateList, new TemplateSelectListener()
        {
            @Override
            public void onSelectContract(ContractTemplate contractTemplate)
            {
                String abiInterface = FileStorageManager.getInstance().readAbiContract(getContext(), contractTemplate.getUuid());
                ((WatchContractFragment) getTargetFragment()).setABIInterfaceForResult(contractTemplate.getName(), abiInterface);
                getMainActivity().onBackPressed();
            }
        }, resId));
    }
}
