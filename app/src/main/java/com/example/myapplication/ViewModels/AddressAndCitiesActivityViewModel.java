package com.example.myapplication.ViewModels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.ApiResponse.AddressServerResponse;
import com.example.myapplication.ApiResponse.ServerResponse;
import com.example.myapplication.AppConstants.AppConstants;
import com.example.myapplication.Respository.DataRepository;
import com.example.myapplication.Utils.SharedPreferenceHelper;
import com.example.myapplication.Views.AddressAndCitiesFetchingActivity;

public class AddressAndCitiesActivityViewModel extends ViewModel {

    private DataRepository dataRepository;
    private MutableLiveData<AddressServerResponse> data;
    MutableLiveData<Boolean> progressBar = new MutableLiveData<>();
    MutableLiveData<ServerResponse> sendErrorMessage = new MutableLiveData<>();

    public AddressAndCitiesActivityViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void init(){
        if (data != null){
            return;
        }
        dataRepository = DataRepository.getInstance();
        data = dataRepository.getUserAddress("123", "en");
    }

    private void showProgressBar(Boolean show) {
        progressBar.setValue(show);
    }

    public LiveData<AddressServerResponse> getAddressRepository() {
        return data;
    }

    public void storeListOfCitiesInSharedPreference(AddressAndCitiesFetchingActivity context, AddressServerResponse addressServerResponse) {
        SharedPreferenceHelper.getInstance().setSharedPreferenceList(context, AppConstants.CITY_LIST_KEY,addressServerResponse.getData().getCities());
    }

    public void storeListOfAreasInSharedPreference(AddressAndCitiesFetchingActivity context, AddressServerResponse addressServerResponse) {
        SharedPreferenceHelper.getInstance().setSharedPreferenceList(context, AppConstants.CITY_LIST_KEY,addressServerResponse.getData().getAreas_of_cities());
    }
}
