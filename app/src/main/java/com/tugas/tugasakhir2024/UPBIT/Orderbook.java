package com.tugas.tugasakhir2024.UPBIT;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Orderbook implements Serializable
{

    @SerializedName("market")
    @Expose
    private String market;
    @SerializedName("timestamp")
    @Expose
    private long timestamp;
    @SerializedName("total_ask_size")
    @Expose
    private float totalAskSize;
    @SerializedName("total_bid_size")
    @Expose
    private float totalBidSize;
    @SerializedName("orderbook_units")
    @Expose
    private List<OrderbookUnit> orderbookUnits;
    private final static long serialVersionUID = -4853015004311702320L;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public float getTotalAskSize() {
        return totalAskSize;
    }

    public void setTotalAskSize(float totalAskSize) {
        this.totalAskSize = totalAskSize;
    }

    public float getTotalBidSize() {
        return totalBidSize;
    }

    public void setTotalBidSize(float totalBidSize) {
        this.totalBidSize = totalBidSize;
    }

    public List<OrderbookUnit> getOrderbookUnits() {
        return orderbookUnits;
    }

    public void setOrderbookUnits(List<OrderbookUnit> orderbookUnits) {
        this.orderbookUnits = orderbookUnits;
    }

}