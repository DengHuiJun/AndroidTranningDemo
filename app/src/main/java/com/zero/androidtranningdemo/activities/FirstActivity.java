package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.zero.androidtranningdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-26.
 */
public class FirstActivity extends Activity {
    private static final String TAG = "FirstActivity";

    @Bind(R.id.first_et)
    EditText mEt;

    @Bind(R.id.first_tv)
    TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);

        Log.d(TAG,"onCreate First");
    }

    @OnClick(R.id.first_btn)
    public void setTextToView() {
        mTv.setText(mEt.getText().toString());
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart First");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState First");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume First");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause First");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop First");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState First");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy First");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart First");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult First");

    }
}
