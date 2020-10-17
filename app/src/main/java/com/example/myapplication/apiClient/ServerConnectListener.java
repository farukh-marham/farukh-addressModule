package com.example.myapplication.apiClient;

import com.example.myapplication.apiResponse.ServerResponse;

public interface ServerConnectListener {

    void onSuccess(ServerResponse response);

    void onFailure(ServerResponse response);

    void onSessionExpiry(ServerResponse response);
}
