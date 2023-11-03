package com.bimbo.net.applogin.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bimbo.net.applogin.di.AppModule;
import com.bimbo.net.applogin.repository.network.login.LoginRemoteRepository;
import com.bimbo.net.applogin.repository.network.model.login.LoginRequest;
import com.bimbo.net.applogin.repository.network.model.login.LoginResponse;
import com.bimbo.net.applogin.util.Resource;

import retrofit2.Retrofit;


public class LoginViewModel extends ViewModel {


    private LoginRemoteRepository remoteDataSource;


    private MutableLiveData<Resource<LoginResponse>> loginResult = new MutableLiveData<>();

    private LoginViewModel(){
        Retrofit r = AppModule.provideRetrofitLogin();
        remoteDataSource = new LoginRemoteRepository(AppModule.provideLoginService(r));
    }

    public LiveData<Resource<LoginResponse>> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        loginResult.postValue(new Resource<LoginResponse>(Resource.Status.LOADING,null,"Cargando.."));
        // Puedes utilizar Executor o Thread para realizar la operación de inicio de sesión en segundo plano.
        new Thread(() -> {
            LoginRequest request = new LoginRequest();
            request.setEmail(username);
            request.setPassword(password);
            Resource<LoginResponse> result = remoteDataSource.login(request);

            loginResult.postValue(result);
        }).start();
    }

}
