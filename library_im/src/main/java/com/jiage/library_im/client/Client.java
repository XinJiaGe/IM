package com.jiage.library_im.client;

import android.app.Application;

public class Client {

    public static Client client;
    private Application mAppLication;

    public static Client getInstance(){
        if(client == null){
            synchronized (Client.class){
                if(client == null){
                    client = new Client();
                }
            }
        }
        return client;
    }
    public void init(Application application){
        this.mAppLication = application;
    }

    public Application getmAppLication() {
        return mAppLication;
    }
}
