package org.sbercoin.wallet.dataprovider.services.update_service.listeners;

import org.sbercoin.wallet.model.gson.token_balance.TokenBalance;

public interface TokenBalanceChangeListener
{
    void onBalanceChange(TokenBalance tokenBalance);
}
