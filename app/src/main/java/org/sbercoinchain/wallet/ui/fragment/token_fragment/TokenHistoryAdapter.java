package org.sbercoin.wallet.ui.fragment.token_fragment;

import android.support.v7.widget.RecyclerView;

import org.sbercoin.wallet.model.gson.token_history.TokenHistory;
import org.sbercoin.wallet.ui.fragment.wallet_fragment.HistoryCountChangeListener;

import java.util.List;

public abstract class TokenHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    protected final int TYPE_PROGRESS_BAR = 0;
    protected final int TYPE_TRANSACTION = 1;
    protected List<TokenHistory> mHistoryList;
    protected TokenHistory mHistory;
    protected boolean mLoadingFlag = false;
    protected String mSymbol = "";
    protected HistoryCountChangeListener mHistoryCountChangeListener;
    protected TokenHistoryClickListener listener;
    protected int decimalUnits = 0;
    public TokenHistoryAdapter(List<TokenHistory> historyList, TokenHistoryClickListener listener, int decimalUnits)
    {
        mHistoryList = historyList;
        this.listener = listener;
        this.decimalUnits = decimalUnits;
    }

    public TokenHistory getItem(int position)
    {
        return mHistoryList.get(position);
    }

    @Override
    public int getItemViewType(int position)
    {
        if (position == mHistoryList.size())
        {
            return TYPE_PROGRESS_BAR;
        }
        return TYPE_TRANSACTION;
    }

    @Override
    public int getItemCount()
    {
        return mHistoryList.size() + 1;
    }

    public void setHistoryList(List<TokenHistory> historyList)
    {
        mHistoryList = historyList;
        if (mHistoryCountChangeListener != null)
        {
            mHistoryCountChangeListener.onCountChange(mHistoryList.size());
        }
    }

    public void setLoadingFlag(boolean loadingFlag)
    {
        mLoadingFlag = loadingFlag;
    }

    public void setSymbol(String symbol)
    {
        mSymbol = symbol;
    }

    public void setHistoryCountChangeListener(HistoryCountChangeListener historyCountChangeListener)
    {
        mHistoryCountChangeListener = historyCountChangeListener;
    }
}
