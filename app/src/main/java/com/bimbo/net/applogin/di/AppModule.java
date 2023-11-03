package com.bimbo.net.applogin.di;


import android.content.Context;

import com.bimbo.net.applogin.repository.network.beer.ApiBeer;
import com.bimbo.net.applogin.repository.network.login.ApiLogin;
import com.bimbo.net.applogin.util.SharedPref;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.Duration;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AppModule {

    public static Retrofit provideRetrofitLogin() {

        OkHttpClient client = new OkHttpClient.Builder()
                .callTimeout(Duration.ofSeconds(60)).build();
        return new Retrofit.Builder()
                .baseUrl("https://apingweb.com/api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public static ApiLogin provideLoginService(Retrofit retrofit){
        return retrofit.create(ApiLogin.class);
    }

    public static Retrofit provideRetrofitBeer(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static SharedPref provideSharedPref(Context context) {
        return new SharedPref(context);
    }

    public static Gson provideGson(){
        return new GsonBuilder().create();
    }



    public static ApiBeer provideBeerService(Retrofit retrofit) {
        return retrofit.create(ApiBeer.class);
    }

}
