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
public class FirstActivity extends Activity {

    private static final int GO_TO_TH_RQ = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.go_to_sec_btn)
    public void gotoSec() {
        Intent intent = new Intent(this,SecActivity.class);
        startActivityForResult(intent,GO_TO_TH_RQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GO_TO_TH_RQ) {
            Log.d("1","getReturn");
            if (resultCode == RESULT_OK) {
                Log.d("1","ok");
                int a = data.getIntExtra("data",0);
                Log.d("1","data:"+a);
            }
        }
    }
}
