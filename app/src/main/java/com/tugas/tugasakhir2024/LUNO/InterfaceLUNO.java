package com.tugas.tugasakhir2024.LUNO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceLUNO {
    @GET("api/1/ticker")
    Call<OrderbookLN> getPriceLUNO(@Query("pair") String pair);
}
