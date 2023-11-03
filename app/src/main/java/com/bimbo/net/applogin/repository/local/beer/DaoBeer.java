package com.bimbo.net.applogin.repository.local.beer;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.bimbo.net.applogin.repository.local.model.BeerDetail;

import java.util.List;

@Dao
public interface DaoBeer {


    @Query("SELECT * FROM BeerDetail WHERE id= :id")
    BeerDetail getDetailsBeerById(Long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<BeerDetail> beerList);

}
