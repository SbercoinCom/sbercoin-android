package org.sbercoin.wallet.ui.fragment.store_contract.light;

import org.sbercoin.wallet.model.gson.qstore.QstoreContract;
import org.sbercoin.wallet.ui.fragment.store_contract.StoreContractFragment;
import org.sbercoin.wallet.ui.fragment.store_contract.TagRecyclerViewAdapter;
import org.sbercoin.wallet.ui.wave_visualizer.WaveHelper;
import org.sbercoin.wallet.ui.wave_visualizer.WaveView;
import org.sbercoin.wallet.utils.DateCalculator;

import butterknife.BindView;
import butterknife.OnClick;

public class StoreContractFragmentLight extends StoreContractFragment {

    @BindView(org.sbercoin.wallet.R.id.wave_view)
    WaveView waveView;
    private WaveHelper mWaveHelper;

    @Override
    protected int getLayout() {
        return org.sbercoin.wallet.R.layout.lyt_store_contract_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        waveView.setShapeType(WaveView.ShapeType.SQUARE);
        mWaveHelper = new WaveHelper(waveView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mWaveHelper.start();
    }

    @Override
    public void onPause() {
        mWaveHelper.cancel();
        super.onPause();
    }

    @OnClick(org.sbercoin.wallet.R.id.ibt_view_abi)
    public void onViewAbiClick() {
        getPresenter().getContractAbiById(getPresenter().getContract().id);
    }

    @Override
    public void setContractData(QstoreContract contract) {
        toolbarTitle.setText(contract.name);
        tvCost.setText(String.valueOf(contract.price));
        tvDescription.setText(contract.description);
        rvTags.setAdapter(new TagRecyclerViewAdapter(contract.tags, this, org.sbercoin.wallet.R.layout.item_tag_light));
        tvPublishDate.setText(DateCalculator.getShortDate(contract.creationDate));
        tvSizeInBytes.setText(String.valueOf(contract.sizeInBytes));
        tvCompiledOn.setText(contract.completedOn);
        tvSourceCode.setText(contract.withSourceCode ? "Yes" : "No");
        tvPublishedBy.setText(contract.publisherAddress);
        tvDownloads.setText(String.valueOf(contract.countDownloads));
    }
}
