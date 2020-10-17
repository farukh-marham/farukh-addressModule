package com.example.myapplication.apiResponse;

import com.example.myapplication.apiResponse.models.Data;

public class AddressServerResponse extends ServerResponse {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ClassPojo [msg = " + ", code = " + ", data = " + data + ", status = " + "]";
    }
}
