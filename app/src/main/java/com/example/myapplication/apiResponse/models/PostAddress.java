package com.example.myapplication.apiResponse.models;

import com.google.gson.annotations.SerializedName;

public class PostAddress {

    @SerializedName("building_name")
    private String buildingName;
    @SerializedName("apartment")
    private String apartmentName;
    @SerializedName("street_address")
    private String streetAddress;
    @SerializedName("city_id")
    private int cityId;
    @SerializedName("area_id")
    private int areaId;
    @SerializedName("device_id")
    private int deviceId;
    @SerializedName("lang")
    private String lang;
    @SerializedName("lat")
    private double lat;
    @SerializedName("long")
    private double lng;




    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
