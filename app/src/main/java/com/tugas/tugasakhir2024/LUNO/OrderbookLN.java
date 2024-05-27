package com.tugas.tugasakhir2024.LUNO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderbookLN implements Serializable
{

    @SerializedName("pair")
    @Expose
    private String pair;
    @SerializedName("timestamp")
    @Expose
    private long timestamp;
    @SerializedName("bid")
    @Expose
    private String bid;
    @SerializedName("ask")
    @Expose
    private String ask;
    @SerializedName("last_trade")
    @Expose
    private String lastTrade;
    @SerializedName("rolling_24_hour_volume")
    @Expose
    private String rolling24HourVolume;
    @SerializedName("status")
    @Expose
    private String status;
    private final static long serialVersionUID = 4711300636801722947L;

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getLastTrade() {
        return lastTrade;
    }

    public void setLastTrade(String lastTrade) {
        this.lastTrade = lastTrade;
    }

    public String getRolling24HourVolume() {
        return rolling24HourVolume;
    }

    public void setRolling24HourVolume(String rolling24HourVolume) {
        this.rolling24HourVolume = rolling24HourVolume;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}