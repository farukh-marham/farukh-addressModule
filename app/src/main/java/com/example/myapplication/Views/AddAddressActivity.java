package com.example.myapplication.Views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Factory.SingletonNameViewModelFactory;
import com.example.myapplication.R;
import com.example.myapplication.ViewModels.AddAddressActivityViewModel;
import com.example.myapplication.databinding.ActivityAddAddressBinding;

public class AddAddressActivity extends AppCompatActivity {


    private AddAddressActivityViewModel addAddressActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddAddressBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_address);
        activityMainBinding.setViewModel(new AddAddressActivityViewModel());
        activityMainBinding.executePendingBindings();
        addAddressActivityViewModel = ViewModelProviders.of(this, new SingletonNameViewModelFactory()).get(AddAddressActivityViewModel.class);


    }
}