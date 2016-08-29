package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.fragment.FireMissilesDialogFragment;
import com.zero.androidtranningdemo.fragment.LoginDialogFragment;
import com.zero.androidtranningdemo.myview.TitleView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-24.
 */
public class TestDialogFragmentActivity extends Activity implements LoginDialogFragment.OkListener {

    @Bind(R.id.bitmap_tv)
    TitleView mTitleView;

    @Bind(R.id.dialog_content)
    TextView mContentTv;

    @Bind(R.id.picker_dialog_btn)
    Button testBtn;

    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
        ButterKnife.bind(this);
        mTitleView.setTitleText("DialogFragment");

    }

    @OnClick(R.id.common_dialog_btn)
    public void showDialog() {
        FireMissilesDialogFragment dialogFragment = new FireMissilesDialogFragment();
        dialogFragment.show(getFragmentManager(), "FireMissilesDialogFragment");
    }

    @OnClick(R.id.custom_dialog_btn)
    public void showCustomDialog() {
        LoginDialogFragment dialogFragment = new LoginDialogFragment();
        dialogFragment.show(getFragmentManager(), "LoginDialogFragment");
    }

    @OnClick(R.id.picker_dialog_btn)
    public void showPickDialog() {
        testBtn.setEnabled(false);
        if (mCountDownTimer == null) {
            mCountDownTimer = new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    String text = millisUntilFinished/1000 + "秒后重发";
                    mContentTv.setText(text);
                }

                @Override
                public void onFinish() {
                    testBtn.setEnabled(true);
                    mContentTv.setText("重新获取验证码");
                }
            };
        }
        mCountDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onOkClickListener(String name, String pwd) {
        mContentTv.setText(name +"&&"+ pwd);
    }
}
