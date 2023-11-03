package com.bimbo.net.applogin.ui.beer.list;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bimbo.net.applogin.di.AppModule;
import com.bimbo.net.applogin.repository.local.beer.BeerLocalRepository;
import com.bimbo.net.applogin.repository.local.model.BeerDetail;
import com.bimbo.net.applogin.repository.network.beer.BeerRemoteRepository;
import com.bimbo.net.applogin.repository.network.model.beer.BeerResponse;
import com.bimbo.net.applogin.util.Resource;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class BeerViewModel extends ViewModel {
    private BeerRemoteRepository remoteDataSource;
    private BeerLocalRepository beerLocalRepository;


    private MutableLiveData<Resource<List<BeerResponse>>> beerResult = new MutableLiveData<>();

    private BeerViewModel(){
        Retrofit r = AppModule.provideRetrofitBeer(new GsonBuilder()
                .setLenient()
                .create());
        remoteDataSource = new BeerRemoteRepository(AppModule.provideBeerService(r));
    }

    public void initLocalRepository(Context context){
        beerLocalRepository = new BeerLocalRepository(context);
    }

    public LiveData<Resource<List<BeerResponse>>> getBeerResult() {
        return beerResult;
    }

    public void getBeer() {
        beerResult.postValue(new Resource<>(Resource.Status.LOADING,null,"Cargando.."));
        new Thread(() -> {
            Resource<List<BeerResponse>> result = remoteDataSource.getBeer(1);
            saveDataLocal(result.getData());
            beerResult.postValue(result);
        }).start();
    }

    public void saveDataLocal(List<BeerResponse> listRemote){
        List<BeerDetail> listLocal = new ArrayList<>();
        listRemote.forEach(item ->{
            listLocal.add(new BeerDetail(item.getId(), item.getName(), item.getDescription(),
                    item.getImageUrl(),item.getVolume().getValue(),item.getVolume().getUnit(),
                    item.getBrewersTips(), item.getContributedBy()));

        });
        beerLocalRepository.saveListBeerDetail(listLocal);
    }

}
