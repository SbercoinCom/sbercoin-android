package org.sbercoin.wallet.ui.fragment.sbercoin_cash_management_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.model.AddressWithBalance;
import org.sbercoin.wallet.utils.ClipboardUtils;
import org.sbercoin.wallet.utils.FontTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddressWithBalanceHolder extends RecyclerView.ViewHolder
{

    private static final long CLICK_TIME_INTERVAL = 1000;
    @BindView(R.id.address_name)
    FontTextView mTextViewAddress;
    @BindView(R.id.address_balance)
    FontTextView mTextViewAddressBalance;
    @BindView(R.id.address_symbol)
    FontTextView mTextViewSymbol;
    AddressWithBalance mDeterministicKeyWithBalance;
    OnAddressClickListener listener;
    private long mLastClickTime = System.currentTimeMillis();

    protected AddressWithBalanceHolder(View itemView, final OnAddressClickListener listener)
    {
        super(itemView);
        this.listener = listener;
        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onItemClick();
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                ClipboardUtils.copyToClipBoard(mTextViewAddress.getContext(), mTextViewAddress.getText().toString(), new ClipboardUtils.CopyCallback()
                {
                    @Override
                    public void onCopyToClipBoard()
                    {
                        Toast.makeText(mTextViewAddress.getContext(), mTextViewAddress.getContext().getString(R.string.copied), Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
        ButterKnife.bind(this, itemView);
    }

    public void bindDeterministicKeyWithBalance(final AddressWithBalance deterministicKeyWithBalance)
    {
        mDeterministicKeyWithBalance = deterministicKeyWithBalance;
        mTextViewAddress.setText(deterministicKeyWithBalance.getAddress());

        String balance = deterministicKeyWithBalance.getBalance().toString();

        mTextViewAddressBalance.setText(balance);

        mTextViewSymbol.setText(" SBER");
    }

    private void onItemClick()
    {
        long now = System.currentTimeMillis();
        if (now - mLastClickTime < CLICK_TIME_INTERVAL)
        {
            return;
        }
        mLastClickTime = now;
        listener.onItemClick(mDeterministicKeyWithBalance);
    }
}
