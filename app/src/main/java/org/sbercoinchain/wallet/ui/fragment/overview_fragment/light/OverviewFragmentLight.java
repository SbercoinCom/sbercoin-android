package org.sbercoin.wallet.ui.fragment.overview_fragment.light;


import org.sbercoin.wallet.R;
import org.sbercoin.wallet.ui.fragment.overview_fragment.CopyableOverviewItem;
import org.sbercoin.wallet.ui.fragment.overview_fragment.OverviewFragment;

import java.util.List;

public class OverviewFragmentLight extends OverviewFragment
{

    @Override
    protected int getLayout()
    {
        return R.layout.fragment_overview_light;
    }

    @Override
    public void setUpOverview(List<CopyableOverviewItem> overview)
    {
        mOverviewAdapter = new OverviewAdapter(overview, R.layout.item_overview_light);
        mRecyclerViewOverview.setAdapter(mOverviewAdapter);
    }

}
