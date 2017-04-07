package com.zero.androidtranningdemo.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.zero.androidtranningdemo.BaseActionBarActivity;
import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.fragment.TimePickDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TimeRemindActivity extends BaseActionBarActivity implements TimePickDialogFragment.TimeSetListener {

    @Bind(R.id.remind_time_tv)
    TextView timeTv;

    private SimpleDateFormat mSDF = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_remind);
        ButterKnife.bind(this);

        setTitleText("时间提醒");

    }

    @OnClick(R.id.pick_time_btn)
    public void pickTime() {
        TimePickDialogFragment pickDialogFragment = new TimePickDialogFragment();
        pickDialogFragment.setTimeSetListener(this);
        pickDialogFragment.show(getFragmentManager(), "TimePickDialogFragment");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void selectTime(Date date) {
        timeTv.setText(mSDF.format(date));
    }
}
