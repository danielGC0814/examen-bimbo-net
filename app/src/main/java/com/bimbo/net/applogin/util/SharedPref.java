package com.bimbo.net.applogin.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private static String NAME_USER = "name_user";
    private static String USER_EMAIL = "user_email";

    private SharedPreferences sharedPreferences;

    public SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences("pfile", Context.MODE_PRIVATE);
    }

    public void setNameUser(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SharedPref.NAME_USER, name);
        editor.apply();
    }

    public String getNameUser() {
        return sharedPreferences.getString(SharedPref.NAME_USER,"");
    }


    public void setEmailUser(String email){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SharedPref.USER_EMAIL, email);
        editor.apply();
    }

    public String getEmailUser() {
        return sharedPreferences.getString(SharedPref.USER_EMAIL,"");
    }
}
