package org.sbercoin.wallet.ui.fragment.receive_fragment.dark;

import android.support.v4.content.ContextCompat;
import android.view.View;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.ui.fragment.receive_fragment.ReceiveFragment;

import butterknife.BindView;

public class ReceiveFragmentDark extends ReceiveFragment {

    @BindView(R.id.qr_code_boarder)
    View qrCodeBoarder;

    @Override
    protected int getLayout() {
        return org.sbercoin.wallet.R.layout.fragment_receive;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        setQrColors(ContextCompat.getColor(getContext(), org.sbercoin.wallet.R.color.grey), ContextCompat.getColor(getContext(), org.sbercoin.wallet.R.color.background));
    }
}
