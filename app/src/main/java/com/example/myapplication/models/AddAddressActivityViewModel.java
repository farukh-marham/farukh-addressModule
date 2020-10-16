package com.example.myapplication.models;


import androidx.lifecycle.ViewModel;

import com.example.myapplication.ApiResponse.Models.AreaOfCities;
import com.example.myapplication.ApiResponse.Models.Cities;
import com.example.myapplication.Respository.DataRepository;

import java.util.ArrayList;
import java.util.List;

public class AddAddressActivityViewModel extends ViewModel {

    private DataRepository dataRepository;
    public List<Cities> citiesList = new ArrayList<>();
    public List<AreaOfCities> areaOfCities = new ArrayList<>();


    public List<AreaOfCities> filter(String cityId) {
        List<AreaOfCities> tempArea = new ArrayList<>();
        for (int i = 0; i < areaOfCities.size(); i++) {
            if (cityId.equals(areaOfCities.get(i).getCity_id())) {
                tempArea.add(areaOfCities.get(i));
            }
        }
        return tempArea;
    }


}
