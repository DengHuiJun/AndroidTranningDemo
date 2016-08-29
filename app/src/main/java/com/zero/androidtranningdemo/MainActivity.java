package com.zero.androidtranningdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.zero.androidtranningdemo.activities.AnimationActivity;
import com.zero.androidtranningdemo.activities.TestDialogFragmentActivity;
import com.zero.androidtranningdemo.activities.FirstActivity;
import com.zero.androidtranningdemo.activities.GesturesActivity;
import com.zero.androidtranningdemo.activities.ManagerAudioActivity;
import com.zero.androidtranningdemo.activities.PicassoActivity;
import com.zero.androidtranningdemo.activities.TakePhotoActivity;
import com.zero.androidtranningdemo.activities.StudyNDKActivity;
import com.zero.androidtranningdemo.activities.TimeRemindActivity;
import com.zero.androidtranningdemo.contentshare.NFCShareActivity;
import com.zero.androidtranningdemo.contentshare.ShareFilesActivity;
import com.zero.androidtranningdemo.contentshare.SimpleDateActivity;
import com.zero.androidtranningdemo.multimedia.TestServiceActivity;
import com.zero.androidtranningdemo.utils.AppUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainListAdapter.OnMainItemClickListener {
    private static final String TAG = "MainActivity";

    private Context mContext;
    private RecyclerView mListRv;
    private List<RecyclerMainItem> mItems = new ArrayList<>(14); // 添加时修改下初始大小
    private MainListAdapter mAdapter;

    private static final int ITEM_ID_SHARE_SIMPLE_DATA = 1;
    private static final int ITEM_ID_REQUEST_SHARE_FILE = 2;
    private static final int ITEM_ID_NFC_SHARE_FILE = 3;
    private static final int ITEM_ID_TEST_SERVICE = 4;
    private static final int ITEM_ID_USE_PICASSO = 5;
    private static final int ITEM_ID_TEST_BITMAP = 6;
    private static final int ITEM_ID_TEST_ACTIVITIES_INTENT = 7;
    private static final int ITEM_ID_USE_FRESCO = 8;
    private static final int ITEM_ID_MANAGING_AUDIO_PLAY = 9;
    private static final int ITEM_ID_TAKE_PHOTO = 10;
    private static final int ITEM_ID_USE_ANIMATION = 11;
    private static final int ITEM_ID_STUDY_NDK = 12;
    private static final int ITEM_ID_USE_SIMPLE_GESTURES = 13;
    private static final int ITEM_ID_DIALOG_FRAGMENT = 14;
    private static final int ITEM_ID_TEST_SCHDULER = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mContext = this;
        findView();
        initItems();

        mListRv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        mAdapter = new MainListAdapter(mContext, mItems);
        mListRv.setAdapter(mAdapter);
        mListRv.addItemDecoration(new SpacesItemDecoration(16));

        mListRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void initItems() {
        RecyclerMainItem itemShareData = new RecyclerMainItem(ITEM_ID_SHARE_SIMPLE_DATA);
        itemShareData.setTitle("内容分享之简单数据");
        mItems.add(itemShareData);

        RecyclerMainItem itemRequestFile = new RecyclerMainItem(ITEM_ID_REQUEST_SHARE_FILE);
        itemRequestFile.setTitle("请求一个分享文件");
        mItems.add(itemRequestFile);

        RecyclerMainItem itemNFCFile = new RecyclerMainItem(ITEM_ID_NFC_SHARE_FILE);
        itemNFCFile.setTitle("通用NFC分享文件");
        mItems.add(itemNFCFile);

        RecyclerMainItem itemTestService = new RecyclerMainItem(ITEM_ID_TEST_SERVICE);
        itemTestService.setTitle("测试Service");
        mItems.add(itemTestService);

        RecyclerMainItem itemUsePicasso = new RecyclerMainItem(ITEM_ID_USE_PICASSO);
        itemUsePicasso.setTitle("Picasso加载图片");
        mItems.add(itemUsePicasso);

        RecyclerMainItem itemTestBitmap = new RecyclerMainItem(ITEM_ID_TEST_BITMAP);
        itemTestBitmap.setTitle("Bitmap");
        mItems.add(itemTestBitmap);

        RecyclerMainItem itemTestActivities = new RecyclerMainItem(ITEM_ID_TEST_ACTIVITIES_INTENT);
        itemTestActivities.setTitle("测试3个Activity跳转");
        mItems.add(itemTestActivities);

        RecyclerMainItem itemUseFresco = new RecyclerMainItem(ITEM_ID_USE_FRESCO);
        itemUseFresco.setTitle("Fresco加载gif");
        mItems.add(itemUseFresco);

        RecyclerMainItem itemTakePhoto = new RecyclerMainItem(ITEM_ID_TAKE_PHOTO);
        itemTakePhoto.setTitle("拍照");
        mItems.add(itemTakePhoto);

        RecyclerMainItem itemUseAnimation = new RecyclerMainItem(ITEM_ID_USE_ANIMATION);
        itemUseAnimation.setTitle("属性动画");
        mItems.add(itemUseAnimation);

        RecyclerMainItem itemStudyNDK = new RecyclerMainItem(ITEM_ID_STUDY_NDK);
        itemStudyNDK.setTitle("学习NDK");
        mItems.add(itemStudyNDK);

        RecyclerMainItem itemUseGesture = new RecyclerMainItem(ITEM_ID_USE_SIMPLE_GESTURES);
        itemUseGesture.setTitle("手势");
        mItems.add(itemUseGesture);

        RecyclerMainItem itemDialogFragment = new RecyclerMainItem(ITEM_ID_DIALOG_FRAGMENT);
        itemDialogFragment.setTitle("DialogFragment");
        mItems.add(itemDialogFragment);

        RecyclerMainItem testSchdulerItem = new RecyclerMainItem(ITEM_ID_TEST_SCHDULER);
        testSchdulerItem.setTitle("时间提醒");
        mItems.add(testSchdulerItem);
//        sort(mItems);
    }

    private void sort(List<RecyclerMainItem> items) {
        int len = items.size();
        int[] keys = new int[len];
        for(int i=0; i<len; i++) {
            keys[i] = items.get(i).getId();
        }
        Arrays.sort(keys);
        List<RecyclerMainItem> sortItems = new ArrayList<>(len);
        for (int i=0; i<len; i++) {
//            sortItems.add(2);
        }

    }

    private void findView() {
        mListRv = (RecyclerView) findViewById(R.id.main_recycler_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.menu_item_share) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void handleItemClick(int id) {
        switch (id) {
            case ITEM_ID_SHARE_SIMPLE_DATA:
                AppUtils.toAnActivity(this, SimpleDateActivity.class);
                break;

            case ITEM_ID_REQUEST_SHARE_FILE:
                AppUtils.toAnActivity(this, ShareFilesActivity.class);
                break;

            case ITEM_ID_NFC_SHARE_FILE:
                AppUtils.toAnActivity(this, NFCShareActivity.class);
                break;

            case ITEM_ID_TEST_SERVICE:
                AppUtils.toAnActivity(this, TestServiceActivity.class);
                break;

            case ITEM_ID_USE_PICASSO:
                AppUtils.toAnActivity(this, PicassoActivity.class);
                break;

            case ITEM_ID_TEST_BITMAP:

                break;
            case ITEM_ID_TEST_ACTIVITIES_INTENT:
                AppUtils.toAnActivity(this, FirstActivity.class);
                break;

            case ITEM_ID_USE_FRESCO:

                break;

            case ITEM_ID_MANAGING_AUDIO_PLAY:
                AppUtils.toAnActivity(this, ManagerAudioActivity.class);
                break;

            case ITEM_ID_TAKE_PHOTO:
                AppUtils.toAnActivity(this, TakePhotoActivity.class);
                break;

            case ITEM_ID_USE_ANIMATION:
                AppUtils.toAnActivity(this, AnimationActivity.class);
                break;

            case ITEM_ID_STUDY_NDK:
                AppUtils.toAnActivity(this, StudyNDKActivity.class);
                break;

            case ITEM_ID_USE_SIMPLE_GESTURES:
                AppUtils.toAnActivity(this, GesturesActivity.class);
                break;

            case ITEM_ID_DIALOG_FRAGMENT:
                AppUtils.toAnActivity(this, TestDialogFragmentActivity.class);
                break;

            case ITEM_ID_TEST_SCHDULER:
                AppUtils.toAnActivity(this, TimeRemindActivity.class);
                break;

            default:
                break;
        }
    }

    @Override
    public void onMainItemClickListener(int id) {
        handleItemClick(id);
    }
}
