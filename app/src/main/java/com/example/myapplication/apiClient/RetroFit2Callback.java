package com.example.myapplication.apiClient;

import android.content.Context;

import com.example.myapplication.apiResponse.ServerResponse;
import com.example.myapplication.appConstants.AppConstants;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroFit2Callback<T> implements Callback {

    private boolean isCanceled;
    private ServerConnectListener listener;
    private Context context;
    private int requestCode;

    public RetroFit2Callback(ServerConnectListener listener, int requestCode) {
        this.listener = listener;
        this.requestCode = requestCode;
    }

    public RetroFit2Callback(ServerConnectListener listener, Context context, int requestCode) {
        this.listener = listener;
        this.context = context;
        this.requestCode = requestCode;
    }

    public RetroFit2Callback(ServerConnectListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    public void cancel() {
        isCanceled = true;
    }

    public boolean isCancelled() {
        return isCanceled;
    }


    private void returnErrorObject(Throwable throwable) {

        ServerResponse errorResponse = new ServerResponse();
        errorResponse.setCode(requestCode);
        List<String> errorsList = new ArrayList<>();
        if (throwable instanceof IOException) {
            // Internet Unavailable
            errorsList.add(AppConstants.NETWORK_ERROR_MESSAGE);
            errorResponse.setMsg(errorsList);
        } else {
            // JSON parsing error
            errorsList.add(AppConstants.JSON_PARSING_MESSAGE);
            errorResponse.setMsg(errorsList);
        }

        listener.onFailure(errorResponse);

    }


    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) {

        if (isCancelled()) {
            return;
        }

        if (response.isSuccessful() && response.body() != null) {
            ServerResponse callResponse = (ServerResponse) response.body();
            callResponse.setCode(requestCode);
            listener.onSuccess(callResponse);

        } else {
            returnErrorObject(null);
        }

    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull Throwable t) {
        returnErrorObject(t);
    }
}
