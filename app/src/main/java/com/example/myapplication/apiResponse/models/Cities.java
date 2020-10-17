package com.example.myapplication.apiResponse.models;

import java.io.Serializable;

public class Cities implements Serializable {

    private String name;

    private String city_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return "ClassPojo [name = " + name + ", city_id = " + city_id + "]";
    }
}
