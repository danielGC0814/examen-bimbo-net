package com.bimbo.net.applogin.ui.beer.detail;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bimbo.net.applogin.di.AppModule;
import com.bimbo.net.applogin.repository.local.beer.BeerLocalRepository;
import com.bimbo.net.applogin.repository.local.model.BeerDetail;
import com.bimbo.net.applogin.util.Resource;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;

public class BeerDetailViewmodel extends ViewModel {

    private BeerLocalRepository beerLocalRepository;


    private MutableLiveData<Resource<BeerDetail>> beerResult = new MutableLiveData<>();

    private BeerDetailViewmodel(){
        Retrofit r = AppModule.provideRetrofitBeer(new GsonBuilder()
                .setLenient()
                .create());
    }

    public void initLocalRepository(Context context){
        beerLocalRepository = new BeerLocalRepository(context);
    }

    public LiveData<Resource<BeerDetail>> getBeerDetailResult() {
        return beerResult;
    }

    public void getBeerDetailById(Long id) {
        beerResult.postValue(new Resource<BeerDetail>(Resource.Status.LOADING,null,"Cargando.."));
        // Puedes utilizar Executor o Thread para realizar la operación de inicio de sesión en segundo plano.
        new Thread(() -> {
            BeerDetail detail = beerLocalRepository.getBeerDetailById(id);
            beerResult.postValue(new Resource<>(Resource.Status.SUCCESS, detail, "success"));
        }).start();
    }

}
