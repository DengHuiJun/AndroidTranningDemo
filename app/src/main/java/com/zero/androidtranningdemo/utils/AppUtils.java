package com.zero.androidtranningdemo.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by zero on 15-8-19.
 */
public class AppUtils {

    public static void toAnActivity(Context context,Class<?> activity) {
        Intent intent = new Intent(context,activity);
        context.startActivity(intent);
    }
}
