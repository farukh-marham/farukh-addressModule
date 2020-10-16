package com.example.myapplication.ApiResponse;

import java.util.List;

public class ServerResponse {

    private int code;
    private String status;
    private List<String> msg;
    private List<String> errors;

    public ServerResponse(int code, String status, List<String> errors) {
        this.code = code;
        this.status = status;
        this.errors = errors;
    }

    public ServerResponse(){

    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getMsg() {
        return msg;
    }

    public List<String> getErrors() {
        return errors;
    }
}
