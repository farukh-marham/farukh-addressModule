package com.example.myapplication.ApiResponse;

import com.example.myapplication.ApiResponse.Models.Data;

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
