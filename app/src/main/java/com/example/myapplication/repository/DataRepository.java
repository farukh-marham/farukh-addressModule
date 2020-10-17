package com.example.myapplication.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.apiClient.APIClient;
import com.example.myapplication.apiResponse.AddressServerResponse;
import com.example.myapplication.apiResponse.ServerResponse;
import com.example.myapplication.appConstants.AppConstants;
import com.example.myapplication.listeners.TechBayEndPoints;
import com.example.myapplication.apiResponse.models.PostAddress;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private static DataRepository dataRepository;
    private MutableLiveData<AddressServerResponse> data = new MutableLiveData<>();

    public static DataRepository getInstance() {
        if (dataRepository == null) {
            dataRepository = new DataRepository();
        }
        return dataRepository;
    }

    private TechBayEndPoints techBayEndPoints;

    public DataRepository() {
        techBayEndPoints = APIClient.cteateService(TechBayEndPoints.class);
    }

    public MutableLiveData<AddressServerResponse> getUserAddress(String deviceId, String language) {
        techBayEndPoints.getUserAddress(deviceId, language).enqueue(new Callback<AddressServerResponse>() {
            @Override
            public void onResponse(Call<AddressServerResponse> call, Response<AddressServerResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getStatus().equals(AppConstants.SUCCESS)) {
                            data.setValue(response.body());
                        } else {
                            data.setValue(response.body());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<AddressServerResponse> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    public void addUserAddress(PostAddress postAddress) {
        techBayEndPoints.addUserAddress(postAddress).enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getStatus().equals(AppConstants.SUCCESS)) {

                        } else {

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
    }
}
