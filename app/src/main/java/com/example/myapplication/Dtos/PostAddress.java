package com.example.myapplication.Dtos;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class PostAddress {

    @NonNull
    private String device_id;
    @NonNull
    private String lang;
    @NonNull
    @SerializedName("long")
    private String lng;
    @NonNull
    private String lat;
    @NonNull
    private String building_name;
    @NonNull
    private String apartment;
    @NonNull
    private String street_address;
    @NonNull
    private String area_id;
    @NonNull
    private String city_id;

    public PostAddress(){

    }

    @NonNull
    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(@NonNull String device_id) {
        this.device_id = device_id;
    }

    @NonNull
    public String getLang() {
        return lang;
    }

    public void setLang(@NonNull String lang) {
        this.lang = lang;
    }

    @NonNull
    public String getLng() {
        return lng;
    }

    public void setLng(@NonNull String lng) {
        this.lng = lng;
    }

    @NonNull
    public String getLat() {
        return lat;
    }

    public void setLat(@NonNull String lat) {
        this.lat = lat;
    }

    @NonNull
    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(@NonNull String building_name) {
        this.building_name = building_name;
    }

    @NonNull
    public String getApartment() {
        return apartment;
    }

    public void setApartment(@NonNull String apartment) {
        this.apartment = apartment;
    }

    @NonNull
    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(@NonNull String street_address) {
        this.street_address = street_address;
    }

    @NonNull
    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(@NonNull String area_id) {
        this.area_id = area_id;
    }

    @NonNull
    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(@NonNull String city_id) {
        this.city_id = city_id;
    }

    public PostAddress(@NonNull String device_id, @NonNull String lang, @NonNull String lng, @NonNull String lat, @NonNull String building_name, @NonNull String apartment, @NonNull String street_address, @NonNull String area_id, @NonNull String city_id) {
        this.device_id = device_id;
        this.lang = lang;
        this.lng = lng;
        this.lat = lat;
        this.building_name = building_name;
        this.apartment = apartment;
        this.street_address = street_address;
        this.area_id = area_id;
        this.city_id = city_id;
    }
}
