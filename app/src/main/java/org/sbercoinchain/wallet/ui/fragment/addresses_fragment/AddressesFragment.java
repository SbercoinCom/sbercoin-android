package org.sbercoin.wallet.ui.fragment.addresses_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.datastorage.KeyStorage;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragment;
import org.sbercoin.wallet.ui.fragment.receive_fragment.ReceiveFragment;
import org.sbercoin.wallet.ui.fragment_factory.Factory;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class AddressesFragment extends BaseFragment implements AddressesView, OnAddressClickListener
{

    protected AddressesAdapter mAddressAdapter;
    @BindView(R.id.recycler_view)
    protected
    RecyclerView mRecyclerView;
    private AddressesPresenterImpl mAddressesFragmentPresenter;

    public static BaseFragment newInstance(Context context)
    {
        Bundle args = new Bundle();
        BaseFragment fragment = Factory.instantiateFragment(context, AddressesFragment.class);
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({R.id.ibt_back})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.ibt_back:
                getActivity().onBackPressed();
                break;
        }
    }

    @Override
    protected void createPresenter()
    {
        mAddressesFragmentPresenter = new AddressesPresenterImpl(this, new AddressesInteractorImpl(getContext()));
    }

    @Override
    protected AddressesPresenterImpl getPresenter()
    {
        return mAddressesFragmentPresenter;
    }

    @Override
    public void initializeViews()
    {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void setAdapterNull()
    {
        mAddressAdapter = null;
    }

    @Override
    public void onAddressClick(int adapterPosition)
    {
        int oldPosition = KeyStorage.getInstance().getCurrentKeyPosition();
        KeyStorage.getInstance().setCurrentKeyPosition(adapterPosition);
        mAddressAdapter.notifyItemChanged(oldPosition);
        mAddressAdapter.notifyItemChanged(adapterPosition);
        ((ReceiveFragment) getTargetFragment()).onChangeAddress();
    }
}