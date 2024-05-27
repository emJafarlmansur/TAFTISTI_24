package com.tugas.tugasakhir2024.TOKOCRYPTO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("lastUpdateId")
    @Expose
    private long lastUpdateId;
    @SerializedName("bids")
    @Expose
    private List<List<String>> bids;
    @SerializedName("asks")
    @Expose
    private List<List<String>> asks;

    public long getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(long lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public List<List<String>> getBids() {
        return bids;
    }

    public void setBids(List<List<String>> bids) {
        this.bids = bids;
    }

    public List<List<String>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<String>> asks) {
        this.asks = asks;
    }

}
