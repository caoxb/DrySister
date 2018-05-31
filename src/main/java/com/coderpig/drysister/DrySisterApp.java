package com.coderpig.drysister;

import android.app.Application;

import com.coderpig.drysister.utils.CrashHandler;

public class DrySisterApp extends Application {
    private static DrySisterApp context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //CrashHandler.getInstance().init(this);
        DryInit.initTimber();
        DryInit.initOKHttp(this);
    }

    public static DrySisterApp getContext() {
        return context;
    }
}
