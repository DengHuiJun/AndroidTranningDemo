package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.zero.androidtranningdemo.R;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import butterknife.ButterKnife;

/**
 * Created by zero on 15-9-4.
 */
public class AnimationActivity extends Activity {
    private static final String TAG = "AnimationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);


        AsyncTask asyncTask;
    }


}
