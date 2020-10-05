package org.sbercoin.wallet.utils;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.SbercoinMainNetParams;
import org.bitcoinj.params.SbercoinTestNetParams;
import org.sbercoin.wallet.BuildConfig;

public class CurrentNetParams {

    public  CurrentNetParams(){}

    public static NetworkParameters getNetParams(){
        return BuildConfig.USE_MAIN_NET? SbercoinMainNetParams.get() : SbercoinTestNetParams.get();
    }

    public static String getUrl(){
        return BuildConfig.API_URL;
    }
}
