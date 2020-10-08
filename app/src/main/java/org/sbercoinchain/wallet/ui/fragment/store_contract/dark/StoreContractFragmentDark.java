package org.sbercoin.wallet.ui.fragment.store_contract.dark;

import org.sbercoin.wallet.model.gson.qstore.QstoreContract;
import org.sbercoin.wallet.ui.fragment.store_contract.StoreContractFragment;
import org.sbercoin.wallet.ui.fragment.store_contract.TagRecyclerViewAdapter;
import org.sbercoin.wallet.utils.DateCalculator;

import butterknife.OnClick;

public class StoreContractFragmentDark extends StoreContractFragment
{

    @Override
    protected int getLayout()
    {
        return org.sbercoin.wallet.R.layout.lyt_store_contract;
    }

    @OnClick(org.sbercoin.wallet.R.id.tv_view_abi)
    public void onViewAbiClick()
    {
        getPresenter().getContractAbiById(getPresenter().getContract().id);
    }

    @Override
    public void setContractData(QstoreContract contract)
    {
        toolbarTitle.setText(contract.name);
        tvCost.setText(String.valueOf(contract.price));
        tvDescription.setText(contract.description);
        rvTags.setAdapter(new TagRecyclerViewAdapter(contract.tags, this, org.sbercoin.wallet.R.layout.item_tag));
        tvPublishDate.setText(DateCalculator.getShortDate(contract.creationDate));
        tvSizeInBytes.setText(String.valueOf(contract.sizeInBytes));
        tvCompiledOn.setText(contract.completedOn);
        tvSourceCode.setText(contract.withSourceCode ? "Yes" : "No");
        tvPublishedBy.setText(contract.publisherAddress);
        tvDownloads.setText(String.valueOf(contract.countDownloads));
    }
}
