package org.sbercoin.wallet.ui.fragment.addresses_detail_fragment.light;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.sbercoin.wallet.model.gson.history.TransactionInfo;
import org.sbercoin.wallet.ui.fragment.addresses_detail_fragment.AddressesDetailAdapter;
import org.sbercoin.wallet.ui.fragment.addresses_detail_fragment.AddressesDetailHolder;

import java.util.List;

class AddressesDetailAdapterLight<T extends TransactionInfo> extends AddressesDetailAdapter {

    protected AddressesDetailAdapterLight(List<T> transactionInfoList, String symbol) {
        super(transactionInfoList, symbol);
    }

    @Override
    public AddressesDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(org.sbercoin.wallet.R.layout.item_transaction_detail_light, parent, false);
        return new AddressesDetailHolder(view);
    }
}
