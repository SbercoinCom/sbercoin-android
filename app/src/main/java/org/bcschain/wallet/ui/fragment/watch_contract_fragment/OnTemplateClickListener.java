package org.sbercoin.wallet.ui.fragment.watch_contract_fragment;

import org.sbercoin.wallet.model.ContractTemplate;

public interface OnTemplateClickListener {
    void updateSelection(int adapterPosition);

    void onTemplateClick(ContractTemplate contractTemplate);
}
