package com.example.myapplication.Respository;

import com.example.myapplication.ApiClient.APIClient;
import com.example.myapplication.ApiClient.RetroFit2Callback;
import com.example.myapplication.ApiResponse.AddressServerResponse;
import com.example.myapplication.ApiResponse.ServerResponse;
import com.example.myapplication.Listeners.TechBayEndPoints;
import com.example.myapplication.Source.UserDataSource;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private static DataRepository dataRepository;

    public static DataRepository getInstance(){
        if (dataRepository == null){
            dataRepository = new DataRepository();
        }
        return dataRepository;
    }

    private TechBayEndPoints techBayEndPoints;

    public DataRepository(){
        APIClient apiClient = new APIClient();
        techBayEndPoints = APIClient.cteateService(TechBayEndPoints.class);
    }

    public void getUserAddress(String deviceId, String language, final UserDataSource.GetUserAddressCallback callback) {
        techBayEndPoints.getUserAddress(deviceId,language).enqueue(new Callback<AddressServerResponse>() {
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
    }

}
