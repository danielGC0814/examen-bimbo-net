package com.bimbo.net.applogin.repository.network.beer;

import com.bimbo.net.applogin.repository.network.model.beer.BeerResponse;
import com.bimbo.net.applogin.util.BaseDataSource;
import com.bimbo.net.applogin.util.Resource;

import java.util.List;

public class BeerRemoteRepository extends BaseDataSource<List<BeerResponse>> {

    private ApiBeer apiBeer;

    public BeerRemoteRepository(ApiBeer apiBeer){
        this.apiBeer = apiBeer;
    }

    public Resource<List<BeerResponse>> getBeer(int page){

        return  this.getResult(() -> apiBeer.getBeers(page));
    }

}
