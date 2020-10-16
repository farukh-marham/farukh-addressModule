package com.example.myapplication.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myapplication.ApiResponse.Models.AreaOfCities;
import com.example.myapplication.ApiResponse.Models.Cities;
import com.example.myapplication.ApiResponse.Models.Data;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

public class SharedPreferenceHelper {

    private final String PREF_FILE = "tech Bay";
    private static SharedPreferenceHelper ourInstance = new SharedPreferenceHelper();

    public static SharedPreferenceHelper getInstance() {
        return ourInstance;
    }

    private SharedPreferenceHelper() {
    }

    public void setSharedPreferenceList(Context context, String key, List list) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);

        editor.putString(key, json);
        editor.apply();
    }


    public List<Cities> getSharedPreferenceListOfCities(Context context, String key, Type type) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = settings.getString(key, null);

        return gson.fromJson(json, type);
    }



    public List<AreaOfCities> getSharedPreferenceListOfAreas(Context context, String key, Type type) {
        SharedPreferences settings = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = settings.getString(key, null);

        return gson.fromJson(json, type);
    }
}
