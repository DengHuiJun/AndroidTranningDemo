package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import com.zero.androidtranningdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-26.
 */
public class FirstActivity extends Activity {
    private static final String TAG = "FirstActivity";

    private static final int GO_TO_TH_RQ = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);

        Log.d(TAG,"onCreate First");
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

    @OnClick(R.id.go_to_sec_btn)
    public void gotoSec() {
        Log.d(TAG,"click btn First");
        Intent intent = new Intent(this, SecActivity.class);
//        startActivityForResult(intent, GO_TO_TH_RQ);
        startActivity(intent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult First");
////        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == GO_TO_TH_RQ) {
//            Log.d("1","getReturn");
//            if (resultCode == RESULT_OK) {
//                Log.d("1","ok");
//                int a = data.getIntExtra("data",0);
//                Log.d("1","data:"+a);
//            }
//        }
    }
}
