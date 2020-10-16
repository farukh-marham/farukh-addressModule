package com.example.myapplication.Source;

import com.example.myapplication.ApiResponse.AddressServerResponse;
import com.example.myapplication.ApiResponse.ServerResponse;

public interface UserDataSource {

    interface GetUserAddressCallback{
        void onSuccessResponseCallback(AddressServerResponse addressServerResponse);
        void onPayloadError(ServerResponse serverResponse);
    }
}
