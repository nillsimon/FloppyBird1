package com.example.vkontact;

import android.app.Application;
import android.content.Context;

public class SlimApp extends Application {
    static Context context;
    static Context contextList;

    public SlimApp() {
        super.onCreate();
        context = getApplicationContext();
        contextList = getApplicationContext();
    }
}
