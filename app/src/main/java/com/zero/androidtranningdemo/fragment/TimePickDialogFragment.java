package com.zero.androidtranningdemo.fragment;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;

import com.zero.androidtranningdemo.helper.ActionConstant;
import com.zero.androidtranningdemo.receiver.TimeRemindReceiver;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by zero on 16-8-26.
 */
public class TimePickDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    private static final String TAG = "TimePickDialogFragment";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        Date date = c.getTime();
        long time = date.getTime();

        Intent intent = new Intent(ActionConstant.ACTION_TIME_REMIND);
        intent.putExtra(TimeRemindReceiver.EXTRA_NOTIF_FLAG, true);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC, time, pendingIntent);

        Log.d(ActionConstant.TAG_WHOLE, "onTimeSet");
    }
}
