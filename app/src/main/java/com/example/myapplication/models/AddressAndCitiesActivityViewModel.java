package com.example.myapplication.models;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.apiResponse.AddressServerResponse;
import com.example.myapplication.appConstants.AppConstants;
import com.example.myapplication.repository.DataRepository;
import com.example.myapplication.utils.SharedPreferenceHelper;
import com.example.myapplication.views.AddressAndCitiesFetchingActivity;

public class AddressAndCitiesActivityViewModel extends ViewModel {

    private DataRepository dataRepository;
    private MutableLiveData<AddressServerResponse> data;


    public AddressAndCitiesActivityViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void init(){
        if (data != null){
            return;
        }
        dataRepository = DataRepository.getInstance();
        data = dataRepository.getUserAddress("123", "en"); //hardcoded strings
    }

    public LiveData<AddressServerResponse> getAddressRepository() {
        return data;
    }

    public void storeListOfCitiesInSharedPreference(AddressAndCitiesFetchingActivity context, AddressServerResponse addressServerResponse) {
        SharedPreferenceHelper.getInstance().setSharedPreferenceList(context, AppConstants.CITY_LIST_KEY,addressServerResponse.getData().getCities());
    }

    public void storeListOfAreasInSharedPreference(AddressAndCitiesFetchingActivity context, AddressServerResponse addressServerResponse) {
        SharedPreferenceHelper.getInstance().setSharedPreferenceList(context, AppConstants.AREA_LIST_KEY,addressServerResponse.getData().getAreas_of_cities());
    }
}
