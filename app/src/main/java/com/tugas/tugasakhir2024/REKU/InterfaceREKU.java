package com.tugas.tugasakhir2024.REKU;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceREKU {
    @GET("orderbook/")
    Call<OrderbookRK> getPriceRKu(@Query("id") String id);
}
