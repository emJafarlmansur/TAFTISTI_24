package com.tugas.tugasakhir2024.TOKOCRYPTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceTKO {
    @GET("open/v1/market/depth")
    Call<OrderbookTKO> getTKO(@Query("symbol") String symbol, @Query("limit") int limit);
}
