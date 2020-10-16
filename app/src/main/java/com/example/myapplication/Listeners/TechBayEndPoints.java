package com.example.myapplication.Listeners;

import com.example.myapplication.ApiResponse.AddressServerResponse;

import java.sql.SQLTransactionRollbackException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface TechBayEndPoints {

    @GET
    Call<AddressServerResponse> getUserAddress(@Url String url);

}
