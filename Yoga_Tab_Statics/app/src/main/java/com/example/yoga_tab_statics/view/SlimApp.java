package com.example.yoga_tab_statics.view;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class SlimApp extends Application {
    @SuppressLint("StaticFieldLeak")
    public static Context context;
    @SuppressLint("StaticFieldLeak")
    static Context contextList;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        contextList = getApplicationContext();
    }
}
