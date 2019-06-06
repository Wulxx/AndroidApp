package com.vogella.android.recyclerview.Controller;

import com.vogella.android.recyclerview.Model.Menus;
import com.vogella.android.recyclerview.RestApiMenus;
import com.vogella.android.recyclerview.View.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {

    public MainActivity view;
    private RestApiMenus restApiMenus;

    public MainController(MainActivity view, RestApiMenus restApiMenus) {
        this.view = view;
        this.restApiMenus = restApiMenus;
    }

    public void onCreate() {
        Call<List<Menus>> call = restApiMenus.getMenusData();
        call.enqueue(new Callback<List<Menus>>() {
            @Override
            public void onResponse(Call<List<Menus>> call, Response<List<Menus>> response) {
                List<Menus> restMenusResponse = response.body();
                List<Menus> MenusList = restMenusResponse;
                view.showList(MenusList);
            }

            @Override
            public void onFailure(Call<List<Menus>> call, Throwable t) {

            }
        });
    }
}
