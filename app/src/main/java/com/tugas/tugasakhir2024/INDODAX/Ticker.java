package com.tugas.tugasakhir2024.INDODAX;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ticker {

    @SerializedName("high")
    @Expose
    private String high;
    @SerializedName("low")
    @Expose
    private String low;
    @SerializedName("vol_btc")
    @Expose
    private String volBtc;
    @SerializedName("vol_idr")
    @Expose
    private String volIdr;
    @SerializedName("last")
    @Expose
    private String last;
    @SerializedName("buy")
    @Expose
    private String buy;
    @SerializedName("sell")
    @Expose
    private String sell;
    @SerializedName("server_time")
    @Expose
    private int serverTime;

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVolBtc() {
        return volBtc;
    }

    public void setVolBtc(String volBtc) {
        this.volBtc = volBtc;
    }

    public String getVolIdr() {
        return volIdr;
    }

    public void setVolIdr(String volIdr) {
        this.volIdr = volIdr;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public int getServerTime() {
        return serverTime;
    }

    public void setServerTime(int serverTime) {
        this.serverTime = serverTime;
    }

}