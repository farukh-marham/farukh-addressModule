package com.example.myapplication.Listeners;

import com.example.myapplication.ApiResponse.AddressServerResponse;

import java.sql.SQLTransactionRollbackException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface TechBayEndPoints {



    @GET("get-user-addresses")
    Call<AddressServerResponse> getUserAddress(@Query("device_id") String deviceId, @Query("lang") String lang);

}
