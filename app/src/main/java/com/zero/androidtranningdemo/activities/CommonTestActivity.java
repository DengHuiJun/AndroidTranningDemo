package com.zero.androidtranningdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.zero.androidtranningdemo.AppContext;
import com.zero.androidtranningdemo.BaseActionBarActivity;
import com.zero.androidtranningdemo.BuildConfig;
import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.fragment.BlankFragment;
import com.zero.androidtranningdemo.utils.MediaFile;

import java.io.File;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-26.
 */
public class CommonTestActivity extends BaseActionBarActivity {
    private static final String TAG = "FilterEmojiActivity";

    private static final String path = Environment.getExternalStorageDirectory() + File.separator + ".demo_test" + File.separator
            + "photos"
            ;

    @Bind(R.id.single_tv)
    TextView tv;

    @OnClick(R.id.btn)
    public void createEvent() {
        if (createDir(path)) {
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_test);
        ButterKnife.bind(this);
        Log.d(TAG, "onCreate Sec : " + BuildConfig.APPLICATION_ID);
        tv.setText(path + "time:" + AppContext.sTime + AppContext.sName);

    }

    // FIXME: 2017/5/16 部分4.4机型(华为meta7，电信版) 上创建目录失败
    private boolean createDir(String path) {
        boolean result = false;

        File dir = new File(path);
        //如果目录不存在的话则新建一个
        if (!dir.exists()) {
            result = dir.mkdirs();
        }
        if (!result) {
            MediaFile mf = new MediaFile(mContext.getContentResolver(), dir);
            try {
                result = mf.mkdir();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
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
