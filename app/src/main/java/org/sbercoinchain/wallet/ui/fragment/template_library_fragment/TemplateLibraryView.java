package org.sbercoin.wallet.ui.fragment.template_library_fragment;

import org.sbercoin.wallet.model.ContractTemplate;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface TemplateLibraryView extends BaseFragmentView {

    void setUpTemplateList(List<ContractTemplate> contractTemplateList);

}
