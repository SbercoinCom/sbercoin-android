package org.sbercoin.wallet.ui.fragment.other_tokens.dark;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.model.contract.Token;
import org.sbercoin.wallet.ui.fragment.other_tokens.OnTokenClickListener;
import org.sbercoin.wallet.ui.fragment.other_tokens.TokenViewHolder;
import org.sbercoin.wallet.ui.fragment.other_tokens.TokensAdapter;
import org.sbercoin.wallet.ui.fragment.other_tokens.UpdateSocketInstance;

import java.util.List;

public class TokensAdapterDark extends TokensAdapter {

    public TokensAdapterDark(List<Token> tokens, UpdateSocketInstance socketInstance, OnTokenClickListener listener) {
        super(tokens, socketInstance, listener);
    }

    @Override
    public TokenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TokenViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lyt_token_list_item, parent, false), socketInstace, parent.getContext(), listener);
    }

    @Override
    public void onBindViewHolder(TokenViewHolder holder, int position) {
        holder.bind(tokens.get(position));
    }
}
