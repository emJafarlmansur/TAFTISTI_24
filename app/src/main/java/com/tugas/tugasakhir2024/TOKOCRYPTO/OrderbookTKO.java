package com.tugas.tugasakhir2024.TOKOCRYPTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderbookTKO {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("timestamp")
    @Expose
    private long timestamp;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}