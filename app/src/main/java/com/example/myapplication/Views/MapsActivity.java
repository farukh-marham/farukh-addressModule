package com.example.myapplication.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import com.example.myapplication.AppConstants.AppConstants;
import com.example.myapplication.Factory.SingletonNameViewModelFactory;
import com.example.myapplication.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends AppCompatActivity {

    private MapsActivityViewModel mapsActivityViewModel;
    private SupportMapFragment mapFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        initGui();
        mapsActivityViewModel = ViewModelProviders.of(this, new SingletonNameViewModelFactory()).get(MapsActivityViewModel.class);
        mapsActivityViewModel.initGui(MapsActivity.this,mapFragment);
        mapsActivityViewModel = ViewModelProviders.of(this, new SingletonNameViewModelFactory()).get(MapsActivityViewModel.class);
    }
    private void initGui() {
        mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.google_maps);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == AppConstants.REQUEST_MAPS_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mapsActivityViewModel.getCurrentLocation(MapsActivity.this);
            }
        }
    }
}
