package com.bimbo.net.applogin.util;

import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Response;

public abstract class BaseDataSource<T> {

    protected Resource<T> getResult(Callable<Call<T>> call) {
        try {
            Response<T> response = call.call().execute();
            if (response.isSuccessful()) {
                T body = response.body();
                if (body != null) return Resource.success(body);
            }
            return error(" " + response.code() + " " + response.message());
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage() != null ? e.getMessage() : e.toString());
        }
    }

    private Resource<T> error(String message) {
        return Resource.error("Network call has failed for a following reason: " + message,null);
    }

}
