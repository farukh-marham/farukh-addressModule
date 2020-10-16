package com.example.myapplication.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.AppConstants.AppConstants;
import com.example.myapplication.Factory.SingletonNameViewModelFactory;
import com.example.myapplication.R;
import com.example.myapplication.Utils.Utils;
import com.example.myapplication.ViewModels.MapsActivityViewModel;
import com.google.android.gms.maps.SupportMapFragment;
import com.karumi.dexter.Dexter;

import java.security.Permission;

public class MapsActivity extends AppCompatActivity {

    private MapsActivityViewModel mapsActivityViewModel;
    private SupportMapFragment mapFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        initGui();
        mapsActivityViewModel = ViewModelProviders.of(this, new SingletonNameViewModelFactory()).get(MapsActivityViewModel.class);
        mapsActivityViewModel.initGui(MapsActivity.this, mapFragment);
        if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            startAddAddressScreen();
        }
    }

    private void startAddAddressScreen() {
        Handler handler = new Handler();
        handler.postDelayed(() -> Utils.getInstance().startActivity(MapsActivity.this, AddAddressActivity.class), 4000);
    }

    private void initGui() {
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_maps);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == AppConstants.REQUEST_MAPS_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mapsActivityViewModel.getCurrentLocation(MapsActivity.this);
                startAddAddressScreen();
            }
        }
    }
}
