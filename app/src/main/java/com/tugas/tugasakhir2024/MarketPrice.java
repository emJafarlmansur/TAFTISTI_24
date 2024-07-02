package com.tugas.tugasakhir2024;

public class MarketPrice {
    public MarketPrice(String market, String coin, String price) {

    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String market;
    private String coin;
    private String price;
}
