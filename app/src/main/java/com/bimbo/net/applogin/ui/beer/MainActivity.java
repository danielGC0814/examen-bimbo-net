package com.bimbo.net.applogin.ui.beer;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.bimbo.net.applogin.R;
import com.bimbo.net.applogin.databinding.ActivityMainBinding;
import com.bimbo.net.applogin.ui.login.LoginActivity;
import com.bimbo.net.applogin.util.BaseActivity;
import com.bimbo.net.applogin.util.SharedPref;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.btnLogOut.setOnClickListener(v -> {
            closeSession();
        });
    }

    public void closeSession(){
        SharedPref sr = new SharedPref(this);
        sr.setNameUser("");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void setNameUserHeader(String name){
        binding.tvHeaderNbUser.setText(name);
    }


    public void setNameBeer(String name){
        binding.tvHeader.setText(name);
    }

}