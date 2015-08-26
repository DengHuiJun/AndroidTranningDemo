package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.myview.TitleView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zero on 15-8-24.
 */
public class BitmapActivity extends Activity {

    @Bind(R.id.bitmap_tv)
    TitleView mTitleView;

    @Bind(R.id.start_camera_btn)
    Button mStartCameraBtn;

    @Bind(R.id.my_photo_iv)
    ImageView mPhotoIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        ButterKnife.bind(this);
        mTitleView.setTitleText("高效加载图片");




    }
}
