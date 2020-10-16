package com.example.myapplication.Respository;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.example.myapplication.ApiClient.APIClient;
import com.example.myapplication.ApiResponse.AddressServerResponse;
import com.example.myapplication.ApiResponse.ServerResponse;
import com.example.myapplication.AppConstants.AppConstants;
import com.example.myapplication.Listeners.TechBayEndPoints;
import com.example.myapplication.Source.UserDataSource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    public DataRepository() {

    }

    TechBayEndPoints getTechBayPoint() {
        APIClient apiClient = new APIClient();

        return apiClient.apiService;
    }

    public void getUserAddress(String deviceId, String language, final UserDataSource.GetUserAddressCallback callback) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("device_id", deviceId);
        hashMap.put("lang", language);

        String baseUrl = AppConstants.BASE_URL_LIVE+"get-user-addresses";
        Uri.Builder builder = Uri.parse(baseUrl).buildUpon();
        builder.appendQueryParameter("device_id", deviceId);
        builder.appendQueryParameter("lang", language);
        URL url;
        try {
           url= new URL(builder.toString());
            Log.e("url====>", url.toString());
            getTechBayPoint().getUserAddress(url.toString()).enqueue(new Callback<AddressServerResponse>() {
                @Override
                public void onResponse(Call<AddressServerResponse> call, Response<AddressServerResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getStatus().equals("200")) {
                            callback.onSuccessResponseCallback(response.body());
                        } else {
                            callback.onPayloadError(response.body());
                        }
                    }
                }

                @Override
                public void onFailure(Call<AddressServerResponse> call, Throwable t) {
                    ArrayList<String> errorMsgList = new ArrayList<>();
                    errorMsgList.add(t.getMessage());
                    ServerResponse serverResponse = new ServerResponse(402, "failed", errorMsgList);
                    callback.onPayloadError(serverResponse);
                }
            });

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



    }


}
