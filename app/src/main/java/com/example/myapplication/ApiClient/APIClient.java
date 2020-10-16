package com.example.myapplication.ApiClient;

import com.example.myapplication.ApiResponse.AddressServerResponse;
import com.example.myapplication.AppConstants.AppConstants;
import com.example.myapplication.Listeners.TechBayEndPoints;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static final String BASE_URL = AppConstants.BASE_URL_LIVE;
    public static TechBayEndPoints apiService;
    private static Retrofit retrofit;

    public static TechBayEndPoints getApiService() {
        return retrofit.create(TechBayEndPoints.class);
    }

    public APIClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging); // <-- this is the important line!

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build();
        apiService = retrofit.create(TechBayEndPoints.class);
    }

    public APIClient(String url) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        httpClient.addInterceptor(logging); // <-- this is the important line!

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build();
        apiService = retrofit.create(TechBayEndPoints.class);
    }

//    public Call<AddressServerResponse> getUserAddress(HashMap<String,String> info) {
//        return apiService.getUserAddress(info);
//    }

    public static <S> S cteateService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
