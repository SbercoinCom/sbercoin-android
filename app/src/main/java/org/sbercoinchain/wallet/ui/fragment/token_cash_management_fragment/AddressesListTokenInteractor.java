package org.sbercoin.wallet.ui.fragment.token_cash_management_fragment;

import org.bitcoinj.crypto.DeterministicKey;
import org.sbercoin.wallet.model.AddressWithTokenBalance;
import org.sbercoin.wallet.model.gson.token_balance.TokenBalance;

import java.util.List;

public interface AddressesListTokenInteractor {
    boolean isCurrencyValid(String currency);

    boolean isAmountValid(String amountString);

    List<String> getAddresses();

    boolean isValidForAddress(TokenBalance tokenBalance, AddressWithTokenBalance keyWithTokenBalanceFrom);

    boolean isValidBalance(TokenBalance tokenBalance, AddressWithTokenBalance keyWithTokenBalanceFrom, String amountString, Integer decimalUnits);
}
