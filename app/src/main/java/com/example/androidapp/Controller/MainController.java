package com.example.androidapp.Controller;

import com.example.androidapp.View.MainActivity;

import java.util.List;

public class MainController {

    public MainActivity view;
    private RestApiPokemon restApiPokemon;

    public MainController(MainActivity view, RestApiPokemon restApiPokemon) {
        this.view = view;
        this.restApiPokemon = restApiPokemon;
    }

    public void onCreate() {
        Call<RestPokemonResponse> call = restApiPokemon.getPokemonData();
        call.enqueue(new Callback<RestPokemonResponse>() {
            @Override
            public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {
                RestPokemonResponse restPokemonResponse = response.body();
                List<Pokemon> pokemonList = restPokemonResponse.getResults();
                view.showList(pokemonList);
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {

            }
        });
    }
}
