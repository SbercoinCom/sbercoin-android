package org.sbercoin.wallet.ui.fragment.currency_fragment;

import android.content.Context;

import org.sbercoin.wallet.R;
import org.sbercoin.wallet.datastorage.TinyDB;
import org.sbercoin.wallet.model.Currency;
import org.sbercoin.wallet.model.CurrencyToken;
import org.sbercoin.wallet.model.contract.ContractCreationStatus;
import org.sbercoin.wallet.model.contract.Token;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class CurrencyInteractorImpl implements CurrencyInteractor
{

    private Context mContext;

    CurrencyInteractorImpl(Context context)
    {
        mContext = context;
    }

    @Override
    public List<Currency> getCurrencies()
    {
        List<Currency> currencies = new ArrayList<>();
        List<Token> tokens = (new TinyDB(mContext)).getTokenList();
        Currency currency = new Currency("SBER " + mContext.getString(R.string.default_currency));
        currencies.add(currency);
        for (Token token : tokens)
        {
            if (token.getCreationStatus().equals(ContractCreationStatus.Created) && token.isSubscribe())
            {

                BigDecimal tokenBalanceWithDecimalUnits = token.getTokenBalanceWithDecimalUnits();

                if (tokenBalanceWithDecimalUnits.toString().equals("0") && !token.getSupportFlag())
                {
                    continue;
                }

                currency = new CurrencyToken(token.getContractName(), token);
                currencies.add(currency);
            }
        }
        return currencies;
    }
}
