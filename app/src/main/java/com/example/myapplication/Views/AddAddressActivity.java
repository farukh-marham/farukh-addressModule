package com.example.myapplication.Views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Adapters.AreaSpinnerAdapter;
import com.example.myapplication.Adapters.CitySpinnerAdapter;
import com.example.myapplication.ApiResponse.Models.AreaOfCities;
import com.example.myapplication.ApiResponse.Models.Cities;
import com.example.myapplication.AppConstants.AppConstants;
import com.example.myapplication.R;
import com.example.myapplication.Utils.SharedPreferenceHelper;
import com.example.myapplication.models.AddAddressActivityViewModel;
import com.example.myapplication.databinding.ActivityAddAddressBinding;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class AddAddressActivity extends AppCompatActivity {


    private AddAddressActivityViewModel addAddressActivityViewModel;
    private Spinner citiesSpinner,areasSpinner;
    private String lat;
    private String lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddAddressBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_address);
        activityMainBinding.setViewModel(new AddAddressActivityViewModel());
        activityMainBinding.executePendingBindings();
        getLatAndLong();
        addAddressActivityViewModel = ViewModelProviders.of(this).get(AddAddressActivityViewModel.class);
        initViews();
        setCitiesListSpinner();

    }

    private void getLatAndLong() {
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            lat = bundle.getString(AppConstants.LAT);
            lng = bundle.getString(AppConstants.LNG);
        }
    }

    private void setAreaListAdapter(List<AreaOfCities> areaList) {
        areasSpinner.setAdapter(new AreaSpinnerAdapter(this,areaList));
        areasSpinner.setSelection(0);
        areasSpinner.setOnItemSelectedListener(areaSelectedListener);
    }

    private void initViews() {
        citiesSpinner = findViewById(R.id.city_spinner);
        areasSpinner = findViewById(R.id.area_spinner);
        addAddressActivityViewModel.citiesList = SharedPreferenceHelper.getInstance().getSharedPreferenceListOfCities(AddAddressActivity.this, AppConstants.CITY_LIST_KEY,new TypeToken<ArrayList<Cities>>() {
        }.getType());
        addAddressActivityViewModel.areaOfCities = SharedPreferenceHelper.getInstance().getSharedPreferenceListOfAreas(AddAddressActivity.this, AppConstants.AREA_LIST_KEY,new TypeToken<ArrayList<AreaOfCities>>() {
        }.getType());
    }

    private void setCitiesListSpinner() {
        citiesSpinner.setAdapter(new CitySpinnerAdapter(this,addAddressActivityViewModel.citiesList));
        citiesSpinner.setSelection(0);
        citiesSpinner.setOnItemSelectedListener(citySelectedListener);
    }




    private AdapterView.OnItemSelectedListener citySelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position != 0) {
                Log.i("Kashmir", String.valueOf(position));
                String cityId = addAddressActivityViewModel.citiesList.get(position-1).getCity_id();
                setAreaListAdapter(addAddressActivityViewModel.filter(cityId));
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private AdapterView.OnItemSelectedListener areaSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position != 0) {
                Log.i("Kashmir", String.valueOf(position));
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


}