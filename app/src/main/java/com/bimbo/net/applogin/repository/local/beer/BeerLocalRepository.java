package com.bimbo.net.applogin.repository.local.beer;


import android.content.Context;

import androidx.room.Room;

import com.bimbo.net.applogin.repository.local.AppDataBase;
import com.bimbo.net.applogin.repository.local.model.BeerDetail;

import java.util.List;

public class BeerLocalRepository {

    AppDataBase appDataBase;
    public BeerLocalRepository(Context context){
         appDataBase = Room.databaseBuilder(context,AppDataBase.class,"db_beer")
                .allowMainThreadQueries().build();
    }
    public void saveListBeerDetail(List<BeerDetail> listBeerDetail){
        appDataBase.daoBeer().insertAll(listBeerDetail);
    }

    public BeerDetail getBeerDetailById(Long id){
        return appDataBase.daoBeer().getDetailsBeerById(id);
    }



}
