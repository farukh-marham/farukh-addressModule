package com.example.myapplication.source;

import com.example.myapplication.apiResponse.AddressServerResponse;
import com.example.myapplication.apiResponse.ServerResponse;

public interface UserDataSource {

    interface GetUserAddressCallback{
        void onSuccessResponseCallback(AddressServerResponse addressServerResponse);
        void onPayloadError(ServerResponse serverResponse);
    }
}
