package com.zero.androidtranningdemo.activities;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import com.zero.androidtranningdemo.R;

/**
 * Created by zero on 15-9-21.
 */
public class FirstActivityTest extends ActivityInstrumentationTestCase2<FirstActivity> {
    public FirstActivityTest() {
        super(FirstActivity.class);
    }

    private Instrumentation mInstrumentation;
    private FirstActivity mActivity;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mInstrumentation = getInstrumentation();
        mActivity = getActivity();
    }

    public void testClickBtn() {
        mInstrumentation.runOnMainSync(new Runnable() {

            @Override
            public void run() {
                // 得到焦点
                Button btn = (Button) mActivity.findViewById(R.id.go_to_sec_btn);
                btn.requestFocus();
                // 模拟点击事件
                btn.performClick();
            }
        });
    }
}
