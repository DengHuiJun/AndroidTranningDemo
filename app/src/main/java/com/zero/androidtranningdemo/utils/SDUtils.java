package com.zero.androidtranningdemo.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by zero on 17-4-7.
 */

public class SDUtils {
    public final static String SD_DIR = Environment.getExternalStorageDirectory() + "";
    public static final String PROJECT_ROOT_DIR = Environment.getExternalStorageDirectory().getPath()
            + File.separator + ".tranning" + File.separator;

    public static boolean isSdReady() {
        return Environment.MEDIA_MOUNTED.equalsIgnoreCase(Environment.getExternalStorageState());
    }
}
