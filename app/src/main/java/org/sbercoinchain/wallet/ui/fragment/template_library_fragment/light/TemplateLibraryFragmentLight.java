package org.sbercoin.wallet.ui.fragment.template_library_fragment.light;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.model.ContractTemplate;
import org.sbercoin.wallet.ui.fragment.template_library_fragment.TemplateLibraryFragment;

import java.util.List;

public class TemplateLibraryFragmentLight extends TemplateLibraryFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_template_library_light;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, R.layout.item_template_light);
    }
}
