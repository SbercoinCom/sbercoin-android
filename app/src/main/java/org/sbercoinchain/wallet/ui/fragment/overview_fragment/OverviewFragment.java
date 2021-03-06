package org.sbercoin.wallet.ui.fragment.overview_fragment;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragment;
import org.sbercoin.wallet.ui.fragment.transaction_fragment.HistoryType;
import org.sbercoin.wallet.ui.fragment_factory.Factory;
import org.sbercoin.wallet.utils.ClipboardUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class OverviewFragment extends BaseFragment implements OverviewView
{

    public static String TX_HASH = "tx_hash";
    public static String HISTORY_TYPE = "history_type";
    @BindView(R.id.recycler_view_overview)
    protected
    RecyclerView mRecyclerViewOverview;
    protected OverviewAdapter mOverviewAdapter;
    OverviewPresenter mOverviewPresenter;

    public static Fragment newInstance(Context context, String txHash, HistoryType historyType)
    {
        Bundle args = new Bundle();
        args.putString(TX_HASH, txHash);
        args.putSerializable(HISTORY_TYPE, historyType);
        Fragment fragment = Factory.instantiateDefaultFragment(context, OverviewFragment.class);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void createPresenter()
    {
        mOverviewPresenter = new OverviewPresenterImpl(this, new OverviewIteractorImpl(getContext(), getMainActivity().getRealm()));
    }

    @Override
    protected OverviewPresenter getPresenter()
    {
        return mOverviewPresenter;
    }

    @Override
    public String getTxHash()
    {
        return getArguments().getString(TX_HASH);
    }


    @Override
    public void initializeViews()
    {
        super.initializeViews();
        mRecyclerViewOverview.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public HistoryType getHistoryType()
    {
        return (HistoryType) getArguments().getSerializable(HISTORY_TYPE);
    }

    class OverviewViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.tv_title)
        TextView mTextViewTitle;
        @BindView(R.id.tv_value)
        TextView mTextViewValue;
        @BindView(R.id.iv_copy)
        ImageView mImageViewCopy;
        CopyableOverviewItem mOverviewItem;

        public OverviewViewHolder(final View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    String explorerURL = "";

                    switch (mOverviewItem.getTitle())
                    {
                        case "TxHash":
                            explorerURL = "https://explorer.sbercoin.com//tx/" + mOverviewItem.getValue();
                            break;
                        case "BlockHash":
                        case "Block Height":
                            explorerURL = "https://explorer.sbercoin.com/block/" + mOverviewItem.getValue();
                            break;
                        default:
                            break;
                    }
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(explorerURL));
                    itemView.getContext().startActivity(browserIntent);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View view)
                {
                    ClipboardUtils.copyToClipBoard(mImageViewCopy.getContext(), mOverviewItem.getValue(), new ClipboardUtils.CopyCallback()
                    {
                        @Override
                        public void onCopyToClipBoard()
                        {
                            Toast.makeText(mImageViewCopy.getContext(), mImageViewCopy.getContext().getString(R.string.copied), Toast.LENGTH_SHORT).show();
                        }
                    });
                    return false;
                }
            });
        }

        public void bindOverview(CopyableOverviewItem overview)
        {
            mOverviewItem = overview;
            mTextViewTitle.setText(overview.getTitle());
            mTextViewValue.setText(overview.getValue());
            mImageViewCopy.setVisibility(overview.isCopyable() ? View.VISIBLE : View.GONE);
        }

    }

    protected class OverviewAdapter extends RecyclerView.Adapter<OverviewViewHolder>
    {

        List<CopyableOverviewItem> mOverview;
        @LayoutRes
        int mResId;

        public OverviewAdapter(List<CopyableOverviewItem> overview, @LayoutRes int resId)
        {
            mOverview = overview;
            mResId = resId;
        }

        @Override
        public OverviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(mResId, parent, false);
            return new OverviewViewHolder(view);
        }

        @Override
        public void onBindViewHolder(OverviewViewHolder holder, int position)
        {
            holder.bindOverview(mOverview.get(position));
        }

        @Override
        public int getItemCount()
        {
            return mOverview.size();
        }

    }
}
