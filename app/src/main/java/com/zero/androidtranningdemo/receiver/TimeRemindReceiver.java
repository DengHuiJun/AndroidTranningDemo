package com.zero.androidtranningdemo.receiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.activities.TimeRemindActivity;
import com.zero.androidtranningdemo.helper.ActionConstant;

/**
 * 时间提醒显示Notification
 * Created by zero on 16-8-26.
 */
public class TimeRemindReceiver extends BroadcastReceiver {

    public static final int NOTIFICATION_ID = 1;
    public static final String EXTRA_NOTIF_FLAG = "notif_flag";

    private boolean mIsShow = false;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent != null) {
            mIsShow = intent.getBooleanExtra(EXTRA_NOTIF_FLAG, false);
        }

        Log.d(ActionConstant.TAG_WHOLE, "TimeRemindReceiver onReceive");

        if (mIsShow) {
            sendNotification("接收到请求", context);
        }
    }

    private void sendNotification(String msg, Context context) {
        NotificationManager mNotificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, TimeRemindActivity.class), 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("提醒时间")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}
