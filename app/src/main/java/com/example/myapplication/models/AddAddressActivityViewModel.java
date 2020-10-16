package com.example.myapplication.models;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.ApiResponse.Models.AreaOfCities;
import com.example.myapplication.ApiResponse.Models.Cities;
import com.example.myapplication.Dtos.PostAddress;

import java.util.ArrayList;
import java.util.List;

public class AddAddressActivityViewModel extends ViewModel {

    private PostAddress postAddress;

    public List<Cities> citiesList = new ArrayList<>();
    public List<AreaOfCities> areaOfCities = new ArrayList<>();

    public void afterEmailTextChanged(CharSequence s) {

//        user.setEmail(s.toString());
    }

    public AddAddressActivityViewModel(){
        postAddress = new PostAddress();
    }

    public List<AreaOfCities> filter(String cityId){
        List<AreaOfCities> tempArea = new ArrayList<>();
        for(int i =0 ; i<areaOfCities.size(); i++){
            if(cityId.equals( areaOfCities.get(i).getCity_id())){
                tempArea.add(areaOfCities.get(i));
            }
        }
        return tempArea;
    }


   public void setLatitude(String latitude){
        postAddress.setLat(latitude);
   }

    public void setLongitude(String latitude){
        postAddress.setLat(latitude);
    }


    public void setBuildingName(String buildingName){
        postAddress.setBuilding_name(buildingName);
    }

    public void setAppartmentName(String appartmentName){
        postAddress.setApartment(appartmentName);
    }

    public void setStreetAddress(String streetAddress){
        postAddress.setApartment(streetAddress);
    }

    public void setdeviceId(){
        postAddress.setDevice_id("123");
    }

    public void setLang(){
        postAddress.setLng("en");
    }

    public void setCityId(String cityId){
        postAddress.setCity_id(cityId);
    }

    public void setAreaId(String areaId){
        postAddress.setArea_id(areaId);
    }
}
