package com.zero.androidtranningdemo.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.zero.androidtranningdemo.R;

/**
 * 做一个菜单动画，移动到中间，旋转式散开
 * Created by zero on 15-9-6.
 */
public class MenuView extends FrameLayout implements View.OnClickListener{
    private ImageView mCenterIv;
    private ImageView mLeftIv;
    private ImageView mRightIv;
    private ImageView mTopIv;
    private ImageView mBottomIv;

    private Context context;

    private RelativeLayout.LayoutParams mRlLp;

    public MenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        LayoutInflater.from(context).inflate(R.layout.menu_view, this);

        mRlLp = new RelativeLayout.LayoutParams(context, attrs);

        findView();

        initView();
    }

    private void findView() {
        mCenterIv = (ImageView) findViewById(R.id.center_iv);
        mLeftIv = (ImageView) findViewById(R.id.left_iv);
        mRightIv = (ImageView) findViewById(R.id.right_iv);
        mTopIv = (ImageView) findViewById(R.id.top_iv);
        mBottomIv = (ImageView) findViewById(R.id.bottom_iv);
    }

    /**
     * 隐藏掉周围四个View，中间的移到左下角
     */
    private void initView() {
        mTopIv.setVisibility(View.GONE);
        mBottomIv.setVisibility(View.GONE);
        mRightIv.setVisibility(View.GONE);
        mLeftIv.setVisibility(View.GONE);

        mRlLp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        mRlLp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        mCenterIv.setLayoutParams(mRlLp);

        mCenterIv.setOnClickListener(this);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.center_iv:
                Toast.makeText(context,"Click Center",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
