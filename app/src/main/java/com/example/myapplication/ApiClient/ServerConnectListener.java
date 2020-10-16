package com.example.myapplication.ApiClient;

import com.example.myapplication.ApiResponse.ServerResponse;

public interface ServerConnectListener {

    void onSuccess(ServerResponse response);

    void onFailure(ServerResponse response);

    void onSessionExpiry(ServerResponse response);
}
