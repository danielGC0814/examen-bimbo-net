package com.bimbo.net.applogin.repository.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.bimbo.net.applogin.repository.local.beer.DaoBeer;
import com.bimbo.net.applogin.repository.local.model.BeerDetail;

@Database(
        entities = {BeerDetail.class},
        version = 1
)
public abstract class AppDataBase extends RoomDatabase {

    public abstract DaoBeer daoBeer();

}
