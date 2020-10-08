package org.sbercoin.wallet.ui.fragment.store_categories;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.model.gson.QstoreContractType;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragment;
import org.sbercoin.wallet.ui.fragment.qstore_by_type.QStoreByTypeFragment;
import org.sbercoin.wallet.ui.fragment_factory.Factory;
import org.sbercoin.wallet.utils.SearchBar;
import org.sbercoin.wallet.utils.SearchBarListener;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class StoreCategoriesFragment extends BaseFragment implements StoreCategoriesView, SearchBarListener
{

    protected StoreCategoriesAdapter adapter;
    @BindView(R.id.content_list)
    protected
    RecyclerView contentList;
    @BindView(R.id.search_bar)
    SearchBar searchBar;
    private StoreCategoriesPresenter presenter;
    private Subscription s;

    public static BaseFragment newInstance(Context context)
    {
        Bundle args = new Bundle();
        BaseFragment fragment = Factory.instantiateFragment(context, StoreCategoriesFragment.class);
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.ibt_back)
    public void onBackClick()
    {
        getActivity().onBackPressed();
    }

    @Override
    public void initializeViews()
    {
        super.initializeViews();
        contentList.setLayoutManager(new LinearLayoutManager(getContext()));
        searchBar.setListener(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        s = getPresenter().categoriesObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<QstoreContractType>>()
                {
                    @Override
                    public void onCompleted()
                    {
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<QstoreContractType> types)
                    {
                        getPresenter().setContractTypes(types);
                        setUpCategoriesList(types, new StoreCategoryViewHolder.OnCategoryClickListener()
                        {
                            @Override
                            public void onClick(String type)
                            {
                                BaseFragment qStoreByTypeFragment = QStoreByTypeFragment.newInstance(type, getContext());
                                openFragment(qStoreByTypeFragment);
                            }
                        });
                    }
                });
    }

    @Override
    protected void createPresenter()
    {
        presenter = new StoreCategoriesPresenterImpl(this, new StoreCategoriesInteractorImpl(getContext()));
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        if (s != null)
        {
            s.unsubscribe();
        }
    }

    @Override
    protected StoreCategoriesPresenter getPresenter()
    {
        return presenter;
    }

    @Override
    public void onActivate()
    {
    }

    @Override
    public void onDeactivate()
    {
    }

    @Override
    public void onRequestSearch(String filter)
    {
        adapter.updateItems(presenter.getFilter(filter));
    }
}
