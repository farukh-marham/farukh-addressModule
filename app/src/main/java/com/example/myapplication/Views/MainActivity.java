package com.example.myapplication.Views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.ApiResponse.AddressServerResponse;
import com.example.myapplication.ApiResponse.ServerResponse;
import com.example.myapplication.Factory.SingletonNameViewModelFactory;
import com.example.myapplication.R;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    private GifImageView gifImageView;
    private MainActivityViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariable();

         mModel = ViewModelProviders.of(this, new SingletonNameViewModelFactory()).get(MainActivityViewModel.class);
         attachViewModel();
         mModel.getUserAddress("123", "en"); //hardcoded strings
    }

    private void attachViewModel(){
        mModel.sendErrorMessage.observe(this, new Observer<ServerResponse>() {
            @Override
            public void onChanged(ServerResponse serverResponse) {
                if(serverResponse.getErrors()!=null) {
                    Toast.makeText(MainActivity.this, serverResponse.getErrors().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        mModel.progressBar.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                showOrHideLoader(aBoolean);
            }
        });

        mModel.addressServerResponseMutableLiveData.observe(this, new Observer<AddressServerResponse>() {
            @Override
            public void onChanged(AddressServerResponse addressServerResponse) {
                Log.e("address==>>", addressServerResponse.toString());

                //final response
            }
        });
    }

    private void initVariable() {
        gifImageView = findViewById(R.id.loading_gif_view);
    }

    private void showOrHideLoader(boolean loader){
        if(loader){
            gifImageView.setVisibility(View.VISIBLE);
        }else{
            gifImageView.setVisibility(View.GONE);
        }
    }

}