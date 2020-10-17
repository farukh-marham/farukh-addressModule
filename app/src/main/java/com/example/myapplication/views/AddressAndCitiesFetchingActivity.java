package com.example.myapplication.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.customViews.BodyText;
import com.example.myapplication.factory.SingletonNameViewModelFactory;
import com.example.myapplication.models.AddressAndCitiesActivityViewModel;
import com.example.myapplication.utils.Utils;

public class AddressAndCitiesFetchingActivity extends AppCompatActivity implements View.OnClickListener {

    private AddressAndCitiesActivityViewModel mModel;
    private ProgressBar progressBar;
    private BodyText headingTextview;
    private ImageView backBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGui();
        setListeners();
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

    private void setListeners() {
        backBtn.setOnClickListener(this);
    }


    private void initGui() {
        progressBar = findViewById(R.id.loading_bar);
        headingTextview = findViewById(R.id.heading_textview);
        backBtn = findViewById(R.id.backBtn);
        headingTextview.setText(getResources().getString(R.string.tech_bay));

    }

    public void showOrHideLoader(boolean loader) {
        if (loader) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backBtn:
                finish();
                break;
        }
    }
}