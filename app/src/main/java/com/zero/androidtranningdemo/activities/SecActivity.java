package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.zero.androidtranningdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-26.
 */
public class SecActivity extends Activity {
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        ButterKnife.bind(this);
        Log.d(TAG, "onCreate Sec");
    }

    @OnClick(R.id.go_to_thr_btn)
    public void goToThrid() {
        Log.d(TAG, "click btn Sec");
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart Sec");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState Sec");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume Sec");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause Sec");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop Sec");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState Sec");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy Sec");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart Sec");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult Sec");
    }
}
