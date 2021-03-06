package org.sbercoin.wallet.ui.fragment.receive_fragment;

import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.math.BigDecimal;

public interface ReceivePresenter extends BaseFragmentPresenter
{
    void changeAmount(String s);

    void setTokenAddress(String address);

    void changeAddress();

    void calcModuleWidth(boolean isDataPixel, int x, int y);

    boolean getWithCrossQr();

    int getTopOffsetHeight();

    int getModuleWidth();

    void setModuleWidth(int qrCodeWidth);

    CharSequence getCurrentReceiveAddress();

    void onBalanceChanged(BigDecimal unconfirmedBalance, BigDecimal balance);
}
