package org.sbercoin.wallet.ui.fragment.send_fragment;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.model.gson.token_balance.TokenBalance;
import org.sbercoin.wallet.utils.FontTextView;

import java.math.BigDecimal;
import java.math.MathContext;

public abstract class AddressWithTokenBalanceSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {

    private Context mContext;
    private TokenBalance mTokenBalance;
    private String symbol;
    private int decimalUnits;

    public AddressWithTokenBalanceSpinnerAdapter(@NonNull Context context, TokenBalance tokenBalance, String symbol, int decimalUnits) {
        mContext = context;
        mTokenBalance = tokenBalance;
        this.symbol = symbol;
        this.decimalUnits = decimalUnits;
    }

    @Override
    public int getCount() {
        return mTokenBalance.getBalances().size();
    }

    @Override
    public Object getItem(int i) {
        return mTokenBalance.getBalances().get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getCustomViewDropDown(int position, @Nullable int resId, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(resId, parent, false);
        FontTextView textViewAddress = view.findViewById(R.id.address_name);
        final FontTextView textViewBalance = view.findViewById(R.id.address_balance);
        final FontTextView textViewSymbol = view.findViewById(R.id.address_symbol);
        textViewSymbol.setText(String.format(" %s", symbol));
        String balance = (mTokenBalance.getBalances().get(position).getBalance() != null) ? String.valueOf(mTokenBalance.getBalances().get(position).getBalance().divide(new BigDecimal(Math.pow(10, decimalUnits)), MathContext.DECIMAL128)) : "0";
        textViewBalance.setLongNumberText(balance, textViewBalance.getContext().getResources().getDisplayMetrics().widthPixels / 2);
        textViewAddress.setText(mTokenBalance.getBalances().get(position).getAddress());
        return view;
    }

    public View getCustomView(int position, @Nullable int resId, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(resId, parent, false);
        FontTextView textViewAddress = view.findViewById(R.id.address_name);
        textViewAddress.setText(mTokenBalance.getBalances().get(position).getAddress());
        return view;
    }

    public TokenBalance getTokenBalance() {
        return mTokenBalance;
    }

    public void setTokenBalance(TokenBalance tokenBalance) {
        mTokenBalance = tokenBalance;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void clearBalances(){

    }
}