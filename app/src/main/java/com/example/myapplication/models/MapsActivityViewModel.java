package com.example.myapplication.models;

import androidx.lifecycle.ViewModel;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.SupportMapFragment;

public class MapsActivityViewModel extends ViewModel {

    private FusedLocationProviderClient client;
    public SupportMapFragment mapFragment;


}
