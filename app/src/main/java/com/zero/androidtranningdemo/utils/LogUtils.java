package com.zero.androidtranningdemo.utils;

import android.util.Log;

/**
 * 日志收集，将异常信息写入文件
 * Created by zero on 17-4-7.
 */

public class LogUtils {

    private LogUtils() {

    }

    public static final String TAG = "Allen";

    public static void exception(String tag, Throwable e, double threshold) {
        StringBuilder errorLogBuilder = new StringBuilder("-------------------------------------------------------------------\n");
        errorLogBuilder.append(Log.getStackTraceString(e));
//        error(tag, errorLogBuilder.toString(), threshold);
    }

    public static void i(String msg) {
        Log.i(TAG, msg);
    }
}
