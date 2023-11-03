package com.bimbo.net.applogin.repository.network.login;

import com.bimbo.net.applogin.repository.network.model.login.LoginRequest;
import com.bimbo.net.applogin.repository.network.model.login.LoginResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiLogin {

    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest request);

}
