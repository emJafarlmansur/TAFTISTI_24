package com.tugas.tugasakhir2024.INDODAX;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InterfaceIDX {
    @GET("api/ticker/{pair_id}")
    Call<Tiker> getPriceIDX(@Path("pair_id") String pair_id);
}
