package org.sbercoin.wallet.ui.fragment.addresses_detail_fragment.dark;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.model.gson.history.TransactionInfo;
import org.sbercoin.wallet.ui.fragment.addresses_detail_fragment.AddressesDetailAdapter;
import org.sbercoin.wallet.ui.fragment.addresses_detail_fragment.AddressesDetailHolder;

import java.util.List;

public class AddressesDetailAdapterDark<T extends TransactionInfo> extends AddressesDetailAdapter
{

    AddressesDetailAdapterDark(List<T> transactionInfoList, String symbol)
    {
        super(transactionInfoList, symbol);
    }

    @Override
    public AddressesDetailHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_transaction_detail, parent, false);
        return new AddressesDetailHolder(view);
    }
}
