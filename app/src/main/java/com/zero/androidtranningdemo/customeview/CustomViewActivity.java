package com.zero.androidtranningdemo.customeview;

import android.os.Bundle;

import com.zero.androidtranningdemo.BaseActionBarActivity;
import com.zero.androidtranningdemo.R;

public class CustomViewActivity extends BaseActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custome_view);

        setTitleText("自定义View");
    }
}
