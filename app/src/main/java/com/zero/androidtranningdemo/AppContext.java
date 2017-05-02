package com.zero.androidtranningdemo;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by zero on 17-4-12.
 */

public class AppContext extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        mContext = this;
    }
}
