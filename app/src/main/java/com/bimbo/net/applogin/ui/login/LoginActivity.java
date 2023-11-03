package com.bimbo.net.applogin.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bimbo.net.applogin.R;
import com.bimbo.net.applogin.util.BaseActivity;

import dagger.hilt.android.AndroidEntryPoint;


public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}