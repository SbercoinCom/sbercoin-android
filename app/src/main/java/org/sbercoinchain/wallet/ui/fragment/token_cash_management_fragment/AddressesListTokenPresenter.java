package org.sbercoin.wallet.ui.fragment.token_cash_management_fragment;

import org.sbercoin.wallet.model.AddressWithTokenBalance;
import org.sbercoin.wallet.model.contract.Token;
import org.sbercoin.wallet.model.gson.token_balance.TokenBalance;
import org.sbercoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface AddressesListTokenPresenter extends BaseFragmentPresenter
{
    String getContractAddress();

    void setTokenBalance(TokenBalance tokenBalance);

    void processTokenBalances(TokenBalance tokenBalance);

    void setToken(Token token);

    int getDecimalUnits();

    List<AddressWithTokenBalance> getKeysWithTokenBalance();

    String getCurrency();

    void setCurrency(String currency);

    AddressWithTokenBalance getKeyWithTokenBalanceFrom();

    void setKeyWithTokenBalanceFrom(AddressWithTokenBalance itemAtPosition);

    void transfer(AddressWithTokenBalance keyWithBalanceTo, AddressWithTokenBalance keyWithTokenBalanceFrom, String s);
}
