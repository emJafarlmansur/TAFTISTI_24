package com.tugas.tugasakhir2024.INDODAX;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tiker {
    @SerializedName("ticker")
    @Expose
    private Ticker ticker;

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

}
