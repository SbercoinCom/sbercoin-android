package org.sbercoin.wallet.ui.fragment.qstore;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.model.gson.qstore.QstoreItem;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragment;
import org.sbercoin.wallet.ui.fragment.store_categories.StoreCategoriesFragment;
import org.sbercoin.wallet.ui.fragment.store_contract.StoreContractFragment;
import org.sbercoin.wallet.ui.fragment_factory.Factory;
import org.sbercoin.wallet.utils.FontCheckBox;
import org.sbercoin.wallet.utils.FontTextView;
import org.sbercoin.wallet.utils.SearchBar;
import org.sbercoin.wallet.utils.SearchBarListener;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public abstract class QStoreFragment extends BaseFragment implements QStoreView, StoreItemClickListener
{

    protected StoreAdapter storeAdapter;
    protected StoreSearchAdapter searchAdapter;
    @BindView(R.id.content_list)
    protected
    RecyclerView contentList;
    @BindView(R.id.search_type_menu)
    LinearLayout searchTypeMenu;
    @BindView(R.id.cb_by_name)
    FontCheckBox cbByName;
    @BindView(R.id.cb_by_tag)
    FontCheckBox cbByTag;
    @BindView(R.id.tv_toolbar_qstore)
    FontTextView mTextViewToolBar;
    @BindView(R.id.ibt_categories)
    ImageButton mImageButton;
    @BindView(R.id.search_bar)
    SearchBar searchBar;
    private QStorePresenter presenter;

    public static BaseFragment newInstance(Context context)
    {
        Bundle args = new Bundle();
        BaseFragment fragment = Factory.instantiateFragment(context, QStoreFragment.class);
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.ibt_back)
    public void onBackClick()
    {
        getActivity().onBackPressed();
    }

    @OnClick(R.id.ibt_categories)
    public void onCategoriesClick()
    {
        openFragment(StoreCategoriesFragment.newInstance(getContext()));
    }

    @Override
    protected void createPresenter()
    {
        presenter = new QStorePresenterImpl(this, new QStoreInteractorImpl(getContext()));
    }

    @Override
    protected QStorePresenter getPresenter()
    {
        return presenter;
    }

    @Override
    public void initializeViews()
    {
        super.initializeViews();
        contentList.setLayoutManager(new LinearLayoutManager(getContext()));

        cbByTag.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                cbByName.setChecked(!isChecked);
                presenter.searchItems(getSeacrhBarText(), cbByTag.isChecked());
            }
        });

        cbByName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                cbByTag.setChecked(!isChecked);
                presenter.searchItems(getSeacrhBarText(), cbByTag.isChecked());
            }
        });

        cbByTag.setChecked(true);

        Observable.create(new Observable.OnSubscribe<String>()
        {
            @Override
            public void call(final Subscriber<? super String> subscriber)
            {
                searchBar.setListener(new SearchBarListener()
                {
                    @Override
                    public void onActivate()
                    {
                        if (searchTypeMenu != null)
                        {
                            searchTypeMenu.setVisibility(View.VISIBLE);
                        }
                        contentList.setAdapter(searchAdapter);
                    }

                    @Override
                    public void onDeactivate()
                    {
                        if (searchTypeMenu != null)
                        {
                            searchTypeMenu.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onRequestSearch(String filter)
                    {
                        subscriber.onNext(filter);
                    }
                });
            }
        })
                .debounce(6000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>()
                {
                    @Override
                    public void call(final String s)
                    {
                        if (cbByTag != null)
                        {
                            presenter.searchItems(s, cbByTag.isChecked());
                        }
                    }
                });
    }

    @Override
    public void OnItemClick(QstoreItem item)
    {
        openFragmentForResult(StoreContractFragment.newInstance(getContext(), item.id));
    }

    @Override
    public void setSearchBarText(String text)
    {
        searchBar.setText(text);
    }

    @Override
    public String getSeacrhBarText()
    {
        return searchBar.getText();
    }


    public void setSearchTag(String tag)
    {
        cbByName.setChecked(false);
        cbByTag.setChecked(true);
        setSearchBarText(tag);
    }
}
