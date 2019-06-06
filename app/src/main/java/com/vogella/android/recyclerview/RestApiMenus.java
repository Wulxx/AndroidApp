package com.vogella.android.recyclerview;

import com.vogella.android.recyclerview.Model.Menus;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiMenus {
    @GET("menus")
    Call<List<Menus>> getMenusData();

}
