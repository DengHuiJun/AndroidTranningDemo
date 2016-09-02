package com.zero.androidtranningdemo.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.zero.androidtranningdemo.R;

/**
 * Created by zero on 15-8-19.
 */
public class AppUtils {

    private static Toast mToast;

    public static void toAnActivity(Context context, Class<?> activity) {
        Intent intent = new Intent(context,activity);
        context.startActivity(intent);
    }

    public static void showShortToast(Context context, String str) {
        if (mToast == null) {
            mToast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.CENTER, 0, 0);
        }
        mToast.show();
    }
}
