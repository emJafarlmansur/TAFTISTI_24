package com.tugas.tugasakhir2024.REKU;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderbookRK {

    @SerializedName("s")
    @Expose
    private List<List<String>> s;
    @SerializedName("b")
    @Expose
    private List<List<String>> b;
    private final static long serialVersionUID = -3795550462150092639L;

    public List<List<String>> getS() {
        return s;
    }

    public void setS(List<List<String>> s) {
        this.s = s;
    }

    public List<List<String>> getB() {
        return b;
    }

    public void setB(List<List<String>> b) {
        this.b = b;
    }

}
