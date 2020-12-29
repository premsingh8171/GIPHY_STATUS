package com.premsinghdaksha.giphystatus.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.premsinghdaksha.giphystatus.model.DataDTO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class LocalPreference {
    private static final String MY_PREFERENCES = "MY_PREFERENCES";
    private static final int MODE = Context.MODE_PRIVATE;
    private static LocalPreference pref;
    private SharedPreferences sharedPreference;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    public LocalPreference(Context context) {
        sharedPreference = context.getSharedPreferences(MY_PREFERENCES, MODE);
        editor = sharedPreference.edit();
    }

    public void clear() {
        editor.clear().commit();

    }


    public String getString(String key, String defValue) {
        return sharedPreference.getString(key, defValue);
    }

    public void setString(String key, String value) {
        editor.putString(key, value).commit();
    }


    //HomeModel
    public void StoreData(List<DataDTO> model, String key) {
        SharedPreferences.Editor editor = sharedPreference.edit();
        Gson gson = new Gson();
        String json = gson.toJson(model);
        editor.putString(key, json);
        editor.apply();
    }

    public List<DataDTO> getData(String key) {
        Gson gson = new Gson();
        String json = sharedPreference.getString(key, null);
        Type type = new TypeToken<ArrayList<DataDTO>>() {
        }.getType();
        return gson.fromJson(json, type);
    }





}
