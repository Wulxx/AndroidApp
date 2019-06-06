package com.example.androidapp;

import com.example.androidapp.Model.Menus;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiMenus {
    @GET("menus")
    Call<List<Menus>> getMenusData();

}
