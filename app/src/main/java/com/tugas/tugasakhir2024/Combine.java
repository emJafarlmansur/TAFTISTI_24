package com.tugas.tugasakhir2024;

public class Combine {
    private String  pair;
    private String upbitPrice;
    private String tokocryptoPrice;

    public Combine(String pair, String upbitPrice, String tokocryptoPrice) {
        this.pair = pair;
        this.upbitPrice = upbitPrice;
        this.tokocryptoPrice = tokocryptoPrice;
    }
    public String getPair() {
        return pair;
    }
    public void setPair(String pair) {
        this.pair = pair;
    }


    public String getUpbitPrice() {
        return upbitPrice;
    }

    public void setUpbitPrice(String upbitPrice) {
        this.upbitPrice = upbitPrice;
    }

    public String getTokocryptoPrice() {
        return tokocryptoPrice;
    }

    public void setTokocryptoPrice(String tokocryptoPrice) {
        this.tokocryptoPrice = tokocryptoPrice;
    }}
