package org.sbercoin.wallet.ui.fragment.watch_contract_fragment.light;

import org.sbercoin.wallet.model.ContractTemplate;
import org.sbercoin.wallet.ui.fragment.watch_contract_fragment.OnTemplateClickListener;
import org.sbercoin.wallet.ui.fragment.watch_contract_fragment.TemplatesAdapter;
import org.sbercoin.wallet.ui.fragment.watch_contract_fragment.WatchContractFragment;
import org.sbercoin.wallet.utils.FontManager;

import java.util.List;

public class WatchContractFragmentLight extends WatchContractFragment {

    @Override
    protected int getLayout() {
        return org.sbercoin.wallet.R.layout.fragment_watch_contract_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mEditTextContractName.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.sbercoin.wallet.R.string.proximaNovaSemibold)));
        mEditTextContractAddress.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.sbercoin.wallet.R.string.proximaNovaSemibold)));
    }

    @Override
    public void setUpTemplatesList(List<ContractTemplate> contractTemplateList, OnTemplateClickListener listener) {
        mRecyclerViewTemplates.setAdapter(new TemplatesAdapter(contractTemplateList, listener, org.sbercoin.wallet.R.layout.item_template_chips_light, org.sbercoin.wallet.R.drawable.chip_selected_corner_background));
    }
}
