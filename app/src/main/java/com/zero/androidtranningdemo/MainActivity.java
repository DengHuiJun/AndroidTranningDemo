package com.zero.androidtranningdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zero.androidtranningdemo.activities.AnimationActivity;
import com.zero.androidtranningdemo.activities.BitmapActivity;
import com.zero.androidtranningdemo.activities.FirstActivity;
import com.zero.androidtranningdemo.activities.GesturesActivity;
import com.zero.androidtranningdemo.activities.ManagerAudioActivity;
import com.zero.androidtranningdemo.activities.PicassoActivity;
import com.zero.androidtranningdemo.activities.TakePhotoActivity;
import com.zero.androidtranningdemo.activities.ThrActivity;
import com.zero.androidtranningdemo.contentshare.NFCShareActivity;
import com.zero.androidtranningdemo.contentshare.ShareFilesActivity;
import com.zero.androidtranningdemo.contentshare.SimpleDateActivity;
import com.zero.androidtranningdemo.multimedia.AudioActivity;
import com.zero.androidtranningdemo.utils.AppUtils;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private static final String TAG = "MainActivity";

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private final String[] mList = {
            "内容分享之简单数据",  // 0
            "请求一个分享文件",   // 1
            "通用NFC分享文件",  // 2
            "Managing Audio Playback",  // 3
            "Picasso加载图片", // 4
            "Bitmap",  // 5
            "测试3个Activity跳转",  // 6
            "Fresco加载gif", // 7
            "管理音频播放", // 8
            "拍照", // 9
            "属性动画", // 10
            "学习NDK", // 11
            "手势", // 12
    };
//    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findView();
        initData();
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    private void initData() {
        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,mList);
    }

    private void findView() {
        mListView = (ListView) findViewById(R.id.main_list_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        MenuItem item = menu.findItem(R.id.menu_item_share);
//        mShareActionProvider = (ShareActionProvider) item.getActionProvider();
        return true;
    }
    private void setShareIntent(Intent shareIntent) {
//        if (mShareActionProvider != null) {
//            mShareActionProvider.setShareIntent(shareIntent);
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.menu_item_share) {
//            Intent sendIntent = new Intent();
//            sendIntent.setAction(Intent.ACTION_SEND);
//            sendIntent.putExtra(Intent.EXTRA_TEXT, "Send text by ShareActionProvider");
//            sendIntent.setType("text/plain");
//            setShareIntent(sendIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                AppUtils.toAnActivity(this, SimpleDateActivity.class);
                break;
            case 1:
                AppUtils.toAnActivity(this, ShareFilesActivity.class);
                break;
            case 2:
                AppUtils.toAnActivity(this, NFCShareActivity.class);
                break;
            case 3:
                AppUtils.toAnActivity(this, AudioActivity.class);
                break;
            case 4:
                AppUtils.toAnActivity(this, PicassoActivity.class);
                break;
            case 5:
                AppUtils.toAnActivity(this, BitmapActivity.class);
                break;
            case 6:
                AppUtils.toAnActivity(this, FirstActivity.class);
                break;
            case 7:

                break;
            case 8:
                AppUtils.toAnActivity(this, ManagerAudioActivity.class);
                break;
            case 9:
                AppUtils.toAnActivity(this, TakePhotoActivity.class);
                break;
            case 10:
                AppUtils.toAnActivity(this, AnimationActivity.class);
                break;
            case 11:
                AppUtils.toAnActivity(this, ThrActivity.class);
                break;
            case 12:
                AppUtils.toAnActivity(this, GesturesActivity.class);
                break;
            default:
                break;
        }
    }
}
