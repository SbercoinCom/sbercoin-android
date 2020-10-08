package org.sbercoin.wallet.ui.fragment.overview_fragment;


import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;
import org.sbercoin.wallet.ui.fragment.transaction_fragment.HistoryType;

import java.util.List;

public interface OverviewView extends BaseFragmentView{
    String getTxHash();
    HistoryType getHistoryType();
    void setUpOverview(List<CopyableOverviewItem> overview);
}
