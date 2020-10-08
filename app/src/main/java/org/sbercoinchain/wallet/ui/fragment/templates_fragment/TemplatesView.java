package org.sbercoin.wallet.ui.fragment.templates_fragment;

import org.sbercoin.wallet.model.ContractTemplate;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface TemplatesView extends BaseFragmentView
{
    void setUpTemplateList(List<ContractTemplate> contractTemplateList);
}
