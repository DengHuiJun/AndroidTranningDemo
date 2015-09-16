package com.zero.androidtranningdemo;

/**
 * Created by zero on 15-9-16.
 */
public class HelloJNI {
    static {
        System.loadLibrary("app");
    }

    public native String  stringFromJNI();
}
