package com.example.launchscreen.HomeScreen.Activities;

public class PlayerManager {
    private static MusicPlayerActivity currentActivity;
    public static void setCurrentActivity(MusicPlayerActivity activity){
        if (currentActivity != null){
            currentActivity.finish();
        }
        currentActivity = activity;
    }
}
