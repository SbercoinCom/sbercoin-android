package org.sbercoin.wallet.ui.fragment.transaction_fragment;

import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

interface TransactionPresenter extends BaseFragmentPresenter
{
    void openTransactionView(String txHash, HistoryType historyType);
}
