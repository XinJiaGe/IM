package com.jiage.im;


import android.app.Application;

import com.jiage.library_im.client.Client;

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
        Client.getInstance().init(this);
    }
}
