package com.bimbo.net.applogin.repository.network.beer;

import com.bimbo.net.applogin.repository.network.model.beer.BeerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiBeer {

    @GET("v2/beers")
    Call<List<BeerResponse>> getBeers(@Query("page") int page);

}
