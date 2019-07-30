package com.jiage.im;


import android.app.Application;

public class NettyChatApp extends Application {

    private static NettyChatApp instance;

    public static NettyChatApp sharedInstance() {
        if (instance == null) {
            throw new IllegalStateException("app not init...");
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
