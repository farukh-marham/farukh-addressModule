package com.example.myapplication.apiResponse;

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

    public void setCode(int code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
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
