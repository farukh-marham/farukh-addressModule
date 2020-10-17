package com.example.myapplication.apiResponse.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserAddress implements Serializable {

    private String area;

    private String building_name;

    private String street_address;

    private String device_id;

    private String city;

    private String address_id;

    private String area_id;

    private String email;

    private String apartment;

    private String lat;

    @SerializedName("long")
    private String lng;

    private String city_id;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return lng ;
    }

    public void setLong(String lng) {
        this. lng =lng ;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return "ClassPojo [area = " + area + ", building_name = " + building_name + ", street_address = " + street_address + ", device_id = " + device_id + ", city = " + city + ", address_id = " + address_id + ", area_id = " + area_id + ", email = " + email + ", apartment = " + apartment + ", lat = " + lat + ", long = " +
        lng +", city_id = " + city_id + "]";
    }
}
