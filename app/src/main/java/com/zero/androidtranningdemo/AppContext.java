package com.zero.androidtranningdemo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;
import com.zero.androidtranningdemo.utils.LogUtils;

/**
 * Created by zero on 17-4-12.
 */

public class AppContext extends Application {

    public static Context mContext;
    public static long sTime;
    public static String sName;

    @Override
    public void onCreate() {
        super.onCreate();

        // 只在当前进程初始化即可
        long t = System.currentTimeMillis();
        sName = getCurrentProcessName();
        if (sName.contains(getPackageName())) {
            SDKInitializer.initialize(getApplicationContext());
            sTime= System.currentTimeMillis() - t;
        }
        mContext = this;
    }

    private String getCurrentProcessName() {
        int pid = android.os.Process.myPid();
        String processName = "";
        ActivityManager manager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo process: manager.getRunningAppProcesses()) {
            if(process.pid == pid) {
                processName = process.processName;
            }
        }
        return processName;
    }

    public static String printMermory() {
        return "";
    }
}
