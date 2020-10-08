package org.sbercoin.wallet.model.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendRawTransactionResponse
{
    @SerializedName("txid")
    public String txid;
    @SerializedName("result")
    @Expose
    private String result;

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getTxid()
    {
        return txid;
    }
}
