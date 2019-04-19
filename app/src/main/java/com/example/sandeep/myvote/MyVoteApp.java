package com.example.sandeep.myvote;

import android.app.Application;

public class MyVoteApp extends Application {
    private static MyVoteApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance =this;
    }

    public static synchronized MyVoteApp getInstance() {
        return mInstance;
    }
}
