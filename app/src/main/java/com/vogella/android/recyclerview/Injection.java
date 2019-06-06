package com.vogella.android.recyclerview;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Injection {
    private static RestApiMenus restApiMenus;

    //Singleton
    public static RestApiMenus getRestApi(){
        if(restApiMenus == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.menus.nypl.org/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            restApiMenus = retrofit.create(RestApiMenus.class);
        }
        return restApiMenus;
    }
}
