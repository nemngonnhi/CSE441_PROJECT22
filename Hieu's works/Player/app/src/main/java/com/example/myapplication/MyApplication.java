package com.example.myapplication;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyApplication extends Application {

    static final String CHANNEL_ID = "channel_service";


    @Override
    public void onCreate() {
        super.onCreate();

        createChannelNotification();
    }
    private void createChannelNotification(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    "Channel Service",
                    NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            if(manager!= null){
                manager.createNotificationChannel(channel);
            }

        }
    }
}
