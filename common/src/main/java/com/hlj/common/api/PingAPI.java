package com.hlj.common.api;

import com.hlj.common.dtos.response.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hanlaijin@xiaomi.com on 18-5-25.
 */
public interface PingAPI {

    @GET("/get")
    Call<Response> ping(
            @Query("k1") String k1,
            @Query("k2") String k2,
            @Query("k3") Long k3
    );
}
