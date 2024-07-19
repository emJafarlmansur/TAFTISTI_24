package com.tugas.tugasakhir2024;

public class Combine {
    private String  pair;
    private String upbitPrice;
    private String tokocryptoPrice;
    private String indodaxPrice;
    private String lunoPrice;
    private  String rekuPrice;
    private int logoResId; // Tambahkan properti ini

    public Combine(String pair, String upbitPrice, String tokocryptoPrice, String indodaxPrice, String lunoPrice, String rekuPrice,int logoResId) {
        this.pair = pair;
        this.upbitPrice = upbitPrice;
        this.tokocryptoPrice = tokocryptoPrice;
        this.indodaxPrice = indodaxPrice;
        this.lunoPrice = lunoPrice;
        this.rekuPrice = rekuPrice;
        this.logoResId = logoResId;
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
    }
    public String getIndodaxPrice() {
        return indodaxPrice;
    }
    public void setIndodaxPrice(String indodaxPrice) {
        this.indodaxPrice = indodaxPrice;
    }

    public String getLunoPrice() {
        return lunoPrice;
    }

    public void setLunoPrice(String lunoPrice) {
        this.lunoPrice = lunoPrice;
    }
    public String getRekuPrice() {
        return rekuPrice;
    }

    public void setRekuPrice(String rekuPrice) {
        this.rekuPrice = rekuPrice;
    }
    public int getLogoResId() { return logoResId; }
}
