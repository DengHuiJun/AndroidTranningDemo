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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        ButterKnife.bind(this);
        Log.d("1","SecActivity");
    }

    @OnClick(R.id.go_to_thr_btn)
    public void goToThrid() {
        Intent intent = new Intent(this,ThrActivity.class);
        startActivity(intent);
        intent.putExtra("data",22);
        setResult(RESULT_OK,intent);
        finish();
    }
}
