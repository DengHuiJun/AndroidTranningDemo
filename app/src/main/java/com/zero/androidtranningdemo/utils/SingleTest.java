package com.zero.androidtranningdemo.utils;

/**
 * Created by allen on 2017/6/23.
 */

public class SingleTest {

    private static final SingleTest INSTANCE = new SingleTest();

    private static final String ss = "223asdfsdf";

    private SingleTest() {
    }

    public SingleTest getInstance() {
        return INSTANCE;
    }


}
