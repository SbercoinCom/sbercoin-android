package org.sbercoin.wallet.ui.fragment.currency_fragment;

import org.sbercoin.wallet.model.Currency;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface CurrencyView extends BaseFragmentView
{
    void setCurrencyList(List<Currency> currencyList);
}
