package com.example.myapplication.models;


import android.text.TextUtils;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.apiResponse.ServerResponse;
import com.example.myapplication.apiResponse.models.AreaOfCities;
import com.example.myapplication.apiResponse.models.Cities;
import com.example.myapplication.apiResponse.models.PostAddress;
import com.example.myapplication.listeners.OnResponse;
import com.example.myapplication.repository.DataRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class AddAddressActivityViewModel extends ViewModel {

    private PostAddress postAddress;
    private DataRepository dataRepository;
    private OnResponse onResponse;
    public List<Cities> citiesList = new ArrayList<>();
    public List<AreaOfCities> areaOfCities = new ArrayList<>();

    public AddAddressActivityViewModel() {
        postAddress = new PostAddress();
    }

    public List<AreaOfCities> filter(String cityId) {
        List<AreaOfCities> tempArea = new ArrayList<>();
        for (int i = 0; i < areaOfCities.size(); i++) {
            if (cityId.equals(areaOfCities.get(i).getCity_id())) {
                tempArea.add(areaOfCities.get(i));
            }
        }
        return tempArea;
    }

    public boolean isValidData() {
        return !TextUtils.isEmpty(postAddress.getApartmentName()) && !TextUtils.isEmpty(postAddress.getBuildingName()) && !TextUtils.isEmpty(postAddress.getStreetAddress());
    }

    public void initModel(String buildingName, String apartmentName, String streetAddress, int cityId, int areaId, int deviceId, String lang, double lat, double lng) {
        postAddress.setBuildingName(buildingName);
        postAddress.setApartmentName(apartmentName);
        postAddress.setStreetAddress(streetAddress);
        postAddress.setCityId(cityId);
        postAddress.setAreaId(areaId);
        postAddress.setDeviceId(deviceId);
        postAddress.setLng(lng);
        postAddress.setLang(lang);
        postAddress.setLat(lat);
    }

    public void addUserAddressApi() {
        dataRepository = DataRepository.getInstance();
        dataRepository.addUserAddress(postAddress, onResponse);

    }

    public void setOnResponseListener(OnResponse onResponseListener) {
        this.onResponse = onResponseListener;
    }
}
