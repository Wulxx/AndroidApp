package com.example.androidapp;

//Cette classe permet de me retourner des instances d'objets
public class Injection {
    private static RestApiPokemon restApiPokemon;

    //Singleton
    public static RestApiPokemon getRestApi(){
        if(restApiPokemon == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            restApiPokemon = retrofit.create(RestApiPokemon.class);
        }
        return restApiPokemon;
    }
}
