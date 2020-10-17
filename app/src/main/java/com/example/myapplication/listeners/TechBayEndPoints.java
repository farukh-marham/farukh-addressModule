package com.example.myapplication.listeners;

import com.example.myapplication.apiResponse.AddressServerResponse;
import com.example.myapplication.apiResponse.ServerResponse;
import com.example.myapplication.apiResponse.models.PostAddress;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TechBayEndPoints {



    @GET("get-user-addresses")
    Call<AddressServerResponse> getUserAddress(@Query("device_id") String deviceId, @Query("lang") String lang);


    @POST("add-user-address")
    Call<ServerResponse> addUserAddress(@Body PostAddress body);

}
