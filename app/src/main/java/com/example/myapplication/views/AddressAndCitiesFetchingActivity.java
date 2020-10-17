package com.example.myapplication.views;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.factory.SingletonNameViewModelFactory;
import com.example.myapplication.R;
import com.example.myapplication.utils.Utils;
import com.example.myapplication.models.AddressAndCitiesActivityViewModel;

import pl.droidsonroids.gif.GifImageView;

public class AddressAndCitiesFetchingActivity extends AppCompatActivity {

    private AddressAndCitiesActivityViewModel mModel;
    private GifImageView gifImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGui();
        mModel = ViewModelProviders.of(this, new SingletonNameViewModelFactory()).get(AddressAndCitiesActivityViewModel.class);
        mModel.init();
        showOrHideLoader(true);
        mModel.getAddressRepository().observe(this, addressServerResponse -> {
            AddressAndCitiesFetchingActivity.this.showOrHideLoader(false);
            mModel.storeListOfCitiesInSharedPreference(AddressAndCitiesFetchingActivity.this, addressServerResponse);
            mModel.storeListOfAreasInSharedPreference(AddressAndCitiesFetchingActivity.this, addressServerResponse);
            Utils.getInstance().startActivityAndFinish(AddressAndCitiesFetchingActivity.this,MapsActivity.class);

        });
    }


    private void initGui() {
        gifImageView = findViewById(R.id.loading_gif_view);
    }

    public void showOrHideLoader(boolean loader) {
        if (loader) {
            gifImageView.setVisibility(View.VISIBLE);
        } else {
            gifImageView.setVisibility(View.GONE);
        }
    }
}