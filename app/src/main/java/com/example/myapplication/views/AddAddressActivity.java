package com.example.myapplication.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.adapters.AreaSpinnerAdapter;
import com.example.myapplication.adapters.CitySpinnerAdapter;
import com.example.myapplication.apiResponse.models.AreaOfCities;
import com.example.myapplication.apiResponse.models.Cities;
import com.example.myapplication.appConstants.AppConstants;
import com.example.myapplication.factory.SingletonNameViewModelFactory;
import com.example.myapplication.R;
import com.example.myapplication.utils.SharedPreferenceHelper;
import com.example.myapplication.databinding.ActivityAddAddressBinding;
import com.example.myapplication.models.AddAddressActivityViewModel;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class AddAddressActivity extends AppCompatActivity implements View.OnClickListener {


    private AddAddressActivityViewModel addAddressActivityViewModel;
    private Spinner citiesSpinner, areasSpinner;
    private Button donebutton;
    private String lat;
    private String lng;
    private ActivityAddAddressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddAddressBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        addAddressActivityViewModel = ViewModelProviders.of(this, new SingletonNameViewModelFactory()).get(AddAddressActivityViewModel.class);
        getLatAndLong();
        initViews();
        setlisteners();
        setCitiesListSpinner();
        setDataInUserForm(binding);

    }

    private void setDataInUserForm(ActivityAddAddressBinding binding) {
        binding.latitudeField.setText(lat);
        binding.longitudeField.setText(lng);
        binding.deviceIdField.setText("123");
        binding.langField.setText("en");

    }

    private void setlisteners() {
        donebutton.setOnClickListener(this);
    }

    private void getLatAndLong() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            lat = bundle.getString(AppConstants.LAT);
            lng = bundle.getString(AppConstants.LNG);
        }
        Toast.makeText(this, lat+lng, Toast.LENGTH_SHORT).show();
    }

    private void setAreaListAdapter(List<AreaOfCities> areaList) {
        areasSpinner.setAdapter(new AreaSpinnerAdapter(this, areaList));
        areasSpinner.setSelection(0);
        areasSpinner.setOnItemSelectedListener(areaSelectedListener);
    }

    private void initViews() {
        citiesSpinner = findViewById(R.id.city_spinner);
        areasSpinner = findViewById(R.id.area_spinner);
        donebutton = findViewById(R.id.done_button);
        addAddressActivityViewModel.citiesList = SharedPreferenceHelper.getInstance().getSharedPreferenceListOfCities(AddAddressActivity.this, AppConstants.CITY_LIST_KEY, new TypeToken<ArrayList<Cities>>() {
        }.getType());
        addAddressActivityViewModel.areaOfCities = SharedPreferenceHelper.getInstance().getSharedPreferenceListOfAreas(AddAddressActivity.this, AppConstants.AREA_LIST_KEY, new TypeToken<ArrayList<AreaOfCities>>() {
        }.getType());
    }

    private void setCitiesListSpinner() {
        citiesSpinner.setAdapter(new CitySpinnerAdapter(this, addAddressActivityViewModel.citiesList));
        citiesSpinner.setSelection(0);
        citiesSpinner.setOnItemSelectedListener(citySelectedListener);
    }


    private AdapterView.OnItemSelectedListener citySelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position != 0) {
                Log.i("Kashmir", String.valueOf(position));
                String cityId = addAddressActivityViewModel.citiesList.get(position - 1).getCity_id();
                setAreaListAdapter(addAddressActivityViewModel.filter(cityId));
                setCityIDInUserFormUsingBinding(binding,cityId);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private void setCityIDInUserFormUsingBinding(ActivityAddAddressBinding binding, String cityId) {
        binding.cityIdField.setText(cityId);
    }

    private AdapterView.OnItemSelectedListener areaSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position != 0) {
                Log.i("Kashmir", String.valueOf(position));
                String areaId = addAddressActivityViewModel.areaOfCities.get(position - 1).getArea_id();
                setAreaIDInUserFormUsingBinding(binding,areaId);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private void setAreaIDInUserFormUsingBinding(ActivityAddAddressBinding binding, String areaId) {
        binding.areaIdField.setText(areaId);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.done_button:
                addAddressActivityViewModel.initModel(binding.buildingNameInputField.getEditableText().toString(),binding.appartmentNameInputField.getEditableText().toString(),binding.streetAddressInputField.getEditableText().toString(),Integer.parseInt(binding.cityIdField.getText().toString()),Integer.parseInt(binding.areaIdField.getText().toString()),Integer.parseInt(binding.deviceIdField.getText().toString()),binding.langField.getText().toString(),Double.parseDouble(binding.latitudeField.getText().toString()),Double.parseDouble(binding.longitudeField.getText().toString()));
                if(addAddressActivityViewModel.isValidData()){
                    addAddressActivityViewModel.addUserAddressApi();
                }
                break;
        }
    }


}