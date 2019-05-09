package com.dima.weather;

import android.support.multidex.MultiDexApplication;

public class App extends MultiDexApplication {
    private static App instance;

    public static App getInstance() {
        if (instance == null) {
            throw new RuntimeException("Application initialization error!");
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}