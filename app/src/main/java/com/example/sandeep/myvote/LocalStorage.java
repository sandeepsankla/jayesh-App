package com.example.sandeep.myvote;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

public class LocalStorage {

    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_ADMIN_PASSWORD = "admin_password";
    public static final String KEY_ADMIN_EMAIL = "admin_password";


    private static LocalStorage instance = null;
    private SharedPreferences mSharedPreferences;

    public static LocalStorage getInstance(){
        if(instance == null){
          return new LocalStorage();
        }
        return instance;
    }



    private SharedPreferences getSharedPreferences() {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(
                    MyVoteApp.getInstance().getApplicationContext());
        }
        return mSharedPreferences;
    }

    public void saveUserEmail(@NonNull String email){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }
    public void saveUserPassword(@NonNull String pass){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(KEY_PASSWORD, pass);
        editor.apply();
    }
    public void saveAdminEmail(@NonNull String email){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(KEY_ADMIN_EMAIL, email);
        editor.apply();
    }
    public void saveAdminPassword(@NonNull String pass){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(KEY_ADMIN_PASSWORD, pass);
        editor.apply();
    }

    public  String getKeyEmail() {
        return getSharedPreferences().getString(KEY_EMAIL, null );
    }

    public  String getKeyPassword() {
        return getSharedPreferences().getString(KEY_PASSWORD, null );

    }

    public  String getKeyAdminPassword() {
        return getSharedPreferences().getString(KEY_ADMIN_PASSWORD, null );

    }

    public  String getKeyAdminEmail() {
        return getSharedPreferences().getString(KEY_ADMIN_EMAIL, null );
    }
}
