package com.example.myapplication.Views;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.ApiResponse.AddressServerResponse;
import com.example.myapplication.Factory.SingletonNameViewModelFactory;
import com.example.myapplication.R;
import com.example.myapplication.Utils.SharedPreferenceHelper;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mModel;
    private GifImageView gifImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGui();
        mModel = ViewModelProviders.of(this, new SingletonNameViewModelFactory()).get(MainActivityViewModel.class);
        mModel.init();
        showOrHideLoader(true);
        mModel.getAddressRepository().observe(this, new Observer<AddressServerResponse>() {
            @Override
            public void onChanged(AddressServerResponse addressServerResponse) {
                MainActivity.this.showOrHideLoader(false);
                mModel.storeListOfCitiesInSharedPreference(MainActivity.this,addressServerResponse);
                mModel.storeListOfAreasInSharedPreference(MainActivity.this, addressServerResponse);

            }
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