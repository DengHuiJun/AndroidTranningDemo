package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.zero.androidtranningdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-26.
 */
public class ThrActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thr);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.return_first_btn)
    public void returnFirst() {
        Intent intent = new Intent();
        intent.putExtra("data",33);
        setResult(RESULT_OK,intent);
        finish();
    }
}
