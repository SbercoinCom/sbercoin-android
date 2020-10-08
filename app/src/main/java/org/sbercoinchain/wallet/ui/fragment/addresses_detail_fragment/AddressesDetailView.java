package org.sbercoin.wallet.ui.fragment.addresses_detail_fragment;


import org.sbercoin.wallet.model.gson.history.Vin;
import org.sbercoin.wallet.model.gson.history.Vout;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;
import org.sbercoin.wallet.ui.fragment.transaction_fragment.HistoryType;

import java.util.List;

interface AddressesDetailView extends BaseFragmentView
{
    void setUpRecyclerView(List<Vin> transactionFrom, List<Vout> transactionTo, String symbol);

    String getTxHash();

    HistoryType getHistoryType();

    int getDecimalUnits();

    String getSymbol();
}
