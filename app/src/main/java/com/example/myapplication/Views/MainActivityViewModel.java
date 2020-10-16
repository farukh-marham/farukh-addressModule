package com.example.myapplication.Views;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.ApiResponse.AddressServerResponse;
import com.example.myapplication.ApiResponse.ServerResponse;
import com.example.myapplication.Respository.DataRepository;
import com.example.myapplication.Source.UserDataSource;

public class MainActivityViewModel extends ViewModel {

    private DataRepository dataRepository;

    public MainActivityViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    MutableLiveData<AddressServerResponse> addressServerResponseMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Boolean> progressBar = new MutableLiveData<>();
    MutableLiveData<ServerResponse> sendErrorMessage = new MutableLiveData<>();

    void getUserAddress(String deviceId, String language){
        showProgressBar(true);

        dataRepository.getUserAddress(deviceId, language, new UserDataSource.GetUserAddressCallback() {
            @Override
            public void onSuccessResponseCallback(AddressServerResponse addressServerResponse) {
                showProgressBar(false);
                addressServerResponseMutableLiveData.setValue(addressServerResponse);
            }

            @Override
            public void onPayloadError(ServerResponse serverResponse) {
                showProgressBar(false);
                showErrorMessage(serverResponse);

            }
        });
    }

    private void showProgressBar(Boolean show){
        progressBar.setValue(show);
    }

    private void showErrorMessage(ServerResponse errorMsg){
        sendErrorMessage.setValue(errorMsg);
    }
}
