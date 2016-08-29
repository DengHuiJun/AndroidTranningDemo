package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.myview.TitleView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zero on 15-9-16.
 */
public class GesturesActivity extends Activity {
    private static final String TAG = "GesturesActivity";

    @Bind(R.id.gesture_tv)
    TitleView mTitleView;

    private final static int MIN_MOVE = 200;   //最小距离

    private MyGestureListener mgListener;
    private ActivityGestureListener aListener;
    private GestureDetector mGd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        ButterKnife.bind(this);

        mTitleView.setTitleText("手势");

        mgListener = new MyGestureListener();
        aListener = new ActivityGestureListener();
        mGd = new GestureDetector(this, aListener);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGd.onTouchEvent(event);
    }

    private class MyGestureListener implements GestureDetector.OnGestureListener{

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d(TAG, "onDown:按下:"+e.toString());
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.d(TAG, "onShowPress:手指按下一段时间,不过还没到长按" + e.toString());
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d(TAG, "onSingleTapUp:手指离开屏幕的一瞬间" + e.toString());
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(TAG, "onScroll:在触摸屏上滑动"+" location:"+distanceX + "##" + distanceY);
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.d(TAG, "onLongPress:长按并且没有松开"+e.toString());
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d(TAG, "onFling:迅速滑动，并松开");
            return false;
        }
    }

    private class ActivityGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
            if (e1.getY() - e2.getY() > MIN_MOVE) {
                Snackbar.make(mTitleView, "上滑操作", Snackbar.LENGTH_LONG).show();
            } else if (e1.getY() - e2.getY()  < MIN_MOVE) {
                Snackbar.make(mTitleView, "下滑操作", Snackbar.LENGTH_LONG).show();
            }
            return true;
        }
    }

    /**
     * 绘制一条滑动的线
     */
    private void drawLine() {

    }
}
