package com.zero.androidtranningdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.zero.androidtranningdemo.BaseActionBarActivity;
import com.zero.androidtranningdemo.BuildConfig;
import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.fragment.BlankFragment;

import butterknife.ButterKnife;

/**
 * Created by zero on 15-8-26.
 */
public class CommonTestActivity extends BaseActionBarActivity {
    private static final String TAG = "FilterEmojiActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_test);
        ButterKnife.bind(this);
        Log.d(TAG, "onCreate Sec : " + BuildConfig.APPLICATION_ID);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.content, BlankFragment.newInstance("",""))
                    .addToBackStack(null)
                    .commit();
        }

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
