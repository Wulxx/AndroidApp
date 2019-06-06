package com.example.androidapp.Controller;

import com.example.androidapp.Model.Menus;
import com.example.androidapp.Model.RestMenusResponse;
import com.example.androidapp.RestApiMenus;
import com.example.androidapp.View.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {

    public MainActivity view;
    private RestApiMenus restApiPokemon;

    public MainController(MainActivity view, RestApiMenus restApiPokemon) {
        this.view = view;
        this.restApiPokemon = restApiPokemon;
    }

    public void onCreate() {
        Call<RestMenusResponse> call = RestApiMenus.getMenusData();
        call.enqueue(new Callback<RestMenusResponse>() {
            @Override
            public void onResponse(Call<RestMenusResponse> call, Response<RestPokemonResponse> response) {
                RestMenusResponse restPokemonResponse = response.body();
                List<Menus> pokemonList = restPokemonResponse.getResults();
                view.showList(MenusList);
            }

            @Override
            public void onFailure(Call<RestMenusResponse> call, Throwable t) {

            }
        });
    }
}
