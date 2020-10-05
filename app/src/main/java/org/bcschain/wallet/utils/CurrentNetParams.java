package org.sbercoin.wallet.utils;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.BCSMainNetParams;
import org.bitcoinj.params.BCSTestNetParams;
import org.sbercoin.wallet.BuildConfig;

public class CurrentNetParams {

    public  CurrentNetParams(){}

    public static NetworkParameters getNetParams(){
        return BuildConfig.USE_MAIN_NET? BCSMainNetParams.get() : BCSTestNetParams.get();
    }

    public static String getUrl(){
        return BuildConfig.API_URL;
    }
}
