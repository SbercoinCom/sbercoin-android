package org.sbercoin.wallet.ui.fragment.currency_fragment;

import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenterImpl;

public class CurrencyPresenterImpl extends BaseFragmentPresenterImpl implements CurrencyPresenter {

    private CurrencyView mCurrencyFragmentView;
    private CurrencyInteractor mCurrencyFragmentInteractor;

    public CurrencyPresenterImpl(CurrencyView currencyFragmentView, CurrencyInteractor currencyFragmentInteractor) {
        mCurrencyFragmentView = currencyFragmentView;
        mCurrencyFragmentInteractor = currencyFragmentInteractor;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        getView().setCurrencyList(getInteractor().getCurrencies());
    }

    @Override
    public CurrencyView getView() {
        return mCurrencyFragmentView;
    }

    private CurrencyInteractor getInteractor() {
        return mCurrencyFragmentInteractor;
    }
}
