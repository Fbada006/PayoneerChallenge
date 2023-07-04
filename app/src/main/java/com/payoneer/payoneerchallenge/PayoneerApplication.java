package com.payoneer.payoneerchallenge;

import android.app.Application;
import dagger.hilt.android.HiltAndroidApp;
import timber.log.Timber;

@HiltAndroidApp
public class PayoneerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        if (BuildConfig.DEBUG) {
//            Timber.plant(new Timber.DebugTree());
//        }
    }
}
