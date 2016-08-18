package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zero.androidtranningdemo.HelloJNI;
import com.zero.androidtranningdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-26.
 */
public class StudyNDKActivity extends Activity {

    @Bind(R.id.jni_tv)
    TextView JNITv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thr);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.return_first_btn)
    public void setText() {
        HelloJNI a = new HelloJNI();
        JNITv.setText(a.stringFromJNI());
    }



}
