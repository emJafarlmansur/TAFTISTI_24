package com.tugas.tugasakhir2024.UPBIT;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderbookUnit {
    @SerializedName("ask_price")
    @Expose
    private int askPrice;
    @SerializedName("bid_price")
    @Expose
    private int bidPrice;
    @SerializedName("ask_size")
    @Expose
    private float askSize;
    @SerializedName("bid_size")
    @Expose
    private float bidSize;
    private final static long serialVersionUID = 8799664013393346377L;

    public int getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(int askPrice) {
        this.askPrice = askPrice;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public float getAskSize() {
        return askSize;
    }

    public void setAskSize(float askSize) {
        this.askSize = askSize;
    }

    public float getBidSize() {
        return bidSize;
    }

    public void setBidSize(float bidSize) {
        this.bidSize = bidSize;
    }

}

