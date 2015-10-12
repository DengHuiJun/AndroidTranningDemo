package com.zero.androidtranningdemo.multimedia;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.service.TestService1;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-21.
 */
public class AudioActivity extends Activity {
    private static final String TAG = "AudioActivity";

    private static final String ACTION_S = "com.zero.service.TEST_SERVICE1";

    private Intent intent;

    private TestService1.MyBinder myBinder;

    private ServiceConnection conn = new ServiceConnection() {

        //Activity与Service断开连接时回调该方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("TestService1","------Service DisConnected-------");
        }

        //Activity与Service连接成功时回调该方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("TestService1", "------Service Connected-------");
            myBinder = (TestService1.MyBinder) service;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.start_service_btn)
    public void start() {
        intent = new Intent(ACTION_S);
        intent.setPackage(getPackageName());
//        startService(intent);
        bindService(intent, conn, Service.BIND_AUTO_CREATE);
    }

    @OnClick(R.id.stop_service_btn)
    public void stop() {
        intent = new Intent(ACTION_S);
        intent.setPackage(getPackageName());
//        stopService(intent);
        unbindService(conn);
    }

    @OnClick(R.id.show_status_btn)
    public void show() {
        Toast.makeText(getApplicationContext(), "Service的count的值为:"
                + myBinder.getCount(), Toast.LENGTH_SHORT).show();
    }
}
