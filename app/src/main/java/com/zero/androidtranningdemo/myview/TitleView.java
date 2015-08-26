package com.zero.androidtranningdemo.myview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.zero.androidtranningdemo.R;

/**
 * 定义一个带标题的View
 * Created by zero on 15-8-19.
 */
public class TitleView extends FrameLayout {

    private Button mBackBtn;

    private TextView mTitleText;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.title_bar, this);
        mBackBtn = (Button) view.findViewById(R.id.title_bar_btn);
        mTitleText = (TextView) view.findViewById(R.id.title_bar_tv);

        mBackBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }

    public void setTitleText(String text) {
        mTitleText.setText(text);
    }

    public void setBackBtnText(String text) {
        mBackBtn.setText(text);
    }

    public void setBackBtnOnClickListener(OnClickListener l) {
        mBackBtn.setOnClickListener(l);
    }
}
