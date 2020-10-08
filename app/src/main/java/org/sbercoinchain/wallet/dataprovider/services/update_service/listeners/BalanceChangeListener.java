package org.sbercoin.wallet.dataprovider.services.update_service.listeners;

import java.math.BigDecimal;

public interface BalanceChangeListener
{
    void onChangeBalance(BigDecimal unconfirmedBalance, BigDecimal balance, Long lastUpdatedBalanceTime);
}
