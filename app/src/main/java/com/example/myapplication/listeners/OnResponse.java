package com.example.myapplication.listeners;

import com.example.myapplication.apiResponse.ServerResponse;

import retrofit2.Response;

public interface OnResponse {

    void onSuccess(Response<ServerResponse> response);
    void onError();
}
