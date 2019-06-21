package com.example.asad.zuoye;

import android.app.Application;

/**
 * Created by 13768 on 2019/5/15.
 */

public class App extends Application{
    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static App getApp() {
        return app;
    }
}
