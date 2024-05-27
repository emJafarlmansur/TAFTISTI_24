package com.tugas.tugasakhir2024.UPBIT;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceUPBIT {
    @GET("v1/orderbook")
   // Call<Orderbook> getokoCryptoPrice(@Query("symbol") String symbol, @Query("limit") int limit);
    Call<ArrayList<Orderbook>> getUPB(@Query("markets") String markets);
}
