package com.example.myapplication.models;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.AppConstants.AppConstants;
import com.example.myapplication.Views.MapsActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

public class MapsActivityViewModel extends ViewModel {

    private FusedLocationProviderClient client;
    public SupportMapFragment mapFragment;


    private String latitude,longitude;

    public void initGui(MapsActivity context, SupportMapFragment mapFragment) {
        this.mapFragment =mapFragment;
        client = LocationServices.getFusedLocationProviderClient(context);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation(context);
        } else {
            //When permission denied
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, AppConstants.REQUEST_MAPS_PERMISSION_CODE);
        }
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void getCurrentLocation(MapsActivity context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(location -> {
            if (location != null) {
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

                        setLatitude(String.valueOf(location.getLatitude()));
                        setLatitude(String.valueOf(location.getLongitude()));
                        //creating marker
                        MarkerOptions options = new MarkerOptions().position(latLng).title("I am here");
                        //zoom map
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                        //Add marker on map
                        googleMap.addMarker(options);

                    }
                });
            }
        });

    }


}
