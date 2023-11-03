package com.bimbo.net.applogin.repository.network.login;

import com.bimbo.net.applogin.repository.network.model.login.LoginRequest;
import com.bimbo.net.applogin.repository.network.model.login.LoginResponse;
import com.bimbo.net.applogin.util.BaseDataSource;
import com.bimbo.net.applogin.util.Resource;


public class LoginRemoteRepository extends BaseDataSource<LoginResponse> {

    private ApiLogin apiLogin;

    public LoginRemoteRepository(ApiLogin apiLogin){
        this.apiLogin = apiLogin;
    }

    public Resource<LoginResponse> login(LoginRequest request){

        return  this.getResult(() -> apiLogin.login(request));
    }

}
