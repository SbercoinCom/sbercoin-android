package org.sbercoin.wallet.ui.fragment.templates_fragment.dark;

import org.sbercoin.wallet.model.ContractTemplate;
import org.sbercoin.wallet.ui.fragment.templates_fragment.TemplatesFragment;

import java.util.List;

public class TemplatesFragmentDark extends TemplatesFragment {

    @Override
    protected int getLayout() {
        return org.sbercoin.wallet.R.layout.fragment_templates;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, org.sbercoin.wallet.R.layout.item_template);
    }
}
