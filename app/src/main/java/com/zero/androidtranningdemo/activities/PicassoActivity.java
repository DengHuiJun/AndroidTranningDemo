package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.myview.TitleView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-22.
 */
public class PicassoActivity extends Activity{

    @Bind(R.id.picasso_title_view)
    TitleView mTitleView;

    @Bind(R.id.load_image_view)
    ImageView mLoadIv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        ButterKnife.bind(this);

        mTitleView.setTitleText("使用Picasso");


    }

    @OnClick(R.id.begin_btn)
    public void beginLoad() {
        Picasso.with(this)  //上下文本
                .load("http://7xjung.com1.z0.glb.clouddn.com/randomview.png") //图片地址
                .placeholder(R.drawable.abc_btn_check_material) //占位图（等待下载）
                .error(R.drawable.abc_btn_radio_material) //加载错误
                .resize(200,200) //设置显示大小
                .centerCrop()  //自适应布局，减小内存
                .into(mLoadIv); //用来显示图片控件的ID
    }
}
