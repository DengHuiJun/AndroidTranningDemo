package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.os.Bundle;

import com.zero.androidtranningdemo.R;

import butterknife.ButterKnife;

/**
 * Created by zero on 15-9-1.
 */
public class TakePhotoActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
        ButterKnife.bind(this);
    }
}
