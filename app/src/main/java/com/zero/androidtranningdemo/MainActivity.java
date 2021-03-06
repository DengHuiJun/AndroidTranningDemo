package com.zero.androidtranningdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zero.androidtranningdemo.activities.AnimationActivity;
import com.zero.androidtranningdemo.activities.DragHelperActivity;
import com.zero.androidtranningdemo.activities.PullRefreshActivity;
import com.zero.androidtranningdemo.activities.CommonTestActivity;
import com.zero.androidtranningdemo.activities.TestDialogFragmentActivity;
import com.zero.androidtranningdemo.activities.FilterEmojiActivity;
import com.zero.androidtranningdemo.activities.GesturesActivity;
import com.zero.androidtranningdemo.activities.ManagerAudioActivity;
import com.zero.androidtranningdemo.activities.PicassoActivity;
import com.zero.androidtranningdemo.activities.SystemActionBarActivity;
import com.zero.androidtranningdemo.activities.StudyNDKActivity;
import com.zero.androidtranningdemo.activities.TimeRemindActivity;
import com.zero.androidtranningdemo.bdlbs.LBSActivity;
import com.zero.androidtranningdemo.contentshare.NFCShareActivity;
import com.zero.androidtranningdemo.contentshare.ShareFilesActivity;
import com.zero.androidtranningdemo.contentshare.SimpleDateActivity;
import com.zero.androidtranningdemo.customeview.CustomViewActivity;
import com.zero.androidtranningdemo.glide.GlideActivity;
import com.zero.androidtranningdemo.multimedia.TestServiceActivity;
import com.zero.androidtranningdemo.utils.AppUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainListAdapter.OnMainItemClickListener {
    private static final String TAG = "MainActivity";

    private Context mContext;
    private RecyclerView mListRv;
    private List<RecyclerMainItem> mItems = new ArrayList<>(20); // 添加时修改下初始大小
    private MainListAdapter mAdapter;

    private static final int ITEM_ID_SHARE_SIMPLE_DATA = 18;
    private static final int ITEM_ID_REQUEST_SHARE_FILE = 2;
    private static final int ITEM_ID_NFC_SHARE_FILE = 3;
    private static final int ITEM_ID_TEST_SERVICE = 4;
    private static final int ITEM_ID_USE_PICASSO = 5;
    private static final int ITEM_ID_TEST_BITMAP = 6;
    private static final int ITEM_ID_TEST_FILTER_EMOJI = 7;
    private static final int ITEM_ID_PULL_REFRESH = 8;
    private static final int ITEM_ID_MANAGING_AUDIO_PLAY = 9;
    private static final int ITEM_ID_TAKE_PHOTO = 10;
    private static final int ITEM_ID_USE_ANIMATION = 11;
    private static final int ITEM_ID_STUDY_NDK = 12;
    private static final int ITEM_ID_USE_SIMPLE_GESTURES = 13;
    private static final int ITEM_ID_DIALOG_FRAGMENT = 14;
    private static final int ITEM_ID_TEST_SCHDULER = 15;
    private static final int ITEM_ID_TEST_VIEW_DRAG_HELPER = 16;
    private static final int ITEM_ID_LBS = 17;
    private static final int ITEM_ID_COMMON_TEST = 1;
    private static final int ITEM_ID_CUSTOME_VIEW = 19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mContext = this;
        findView();
        initItems();

        View headerView = getLayoutInflater().inflate(R.layout.main_header, null);

        mListRv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        mAdapter = new MainListAdapter(mContext, sort(mItems));
        mListRv.setAdapter(mAdapter);
        mListRv.addItemDecoration(new SpacesItemDecoration(16));

        mListRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                mAdapter.setIsAnima(false);
            }
        });

        mAdapter.setHeaderView(headerView);
    }

    private void enterEditMode() {
        mAdapter.setEditMode(true);
    }

    private void exitEditMode() {
        mAdapter.setEditMode(false);
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
        itemTestBitmap.setTitle("Glide用法测试");
        mItems.add(itemTestBitmap);

        RecyclerMainItem itemTestActivities = new RecyclerMainItem(ITEM_ID_TEST_FILTER_EMOJI);
        itemTestActivities.setTitle("过滤Emoji表情");
        mItems.add(itemTestActivities);

        RecyclerMainItem itemUseFresco = new RecyclerMainItem(ITEM_ID_PULL_REFRESH);
        itemUseFresco.setTitle("下拉刷新控件");
        mItems.add(itemUseFresco);

        RecyclerMainItem itemTakePhoto = new RecyclerMainItem(ITEM_ID_TAKE_PHOTO);
        itemTakePhoto.setTitle("拍照功能");
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

        RecyclerMainItem viewDragHelperItem = new RecyclerMainItem(ITEM_ID_TEST_VIEW_DRAG_HELPER);
        viewDragHelperItem.setTitle("滑动测试");
        mItems.add(viewDragHelperItem);

        RecyclerMainItem lbsItem = new RecyclerMainItem(ITEM_ID_LBS);
        lbsItem.setTitle("百度定位");
        mItems.add(lbsItem);

        RecyclerMainItem commonItem = new RecyclerMainItem(ITEM_ID_COMMON_TEST);
        commonItem.setTitle("公共测试");
        mItems.add(commonItem);

        RecyclerMainItem viewItem = new RecyclerMainItem(ITEM_ID_CUSTOME_VIEW);
        viewItem.setTitle("自定义View");
        mItems.add(viewItem);
    }

    private List<RecyclerMainItem> sort(List<RecyclerMainItem> itemList) {
        List<RecyclerMainItem> items = itemList;
        int len = items.size();
        int[] keys = new int[len];
        for(int i=0; i<len; i++) {
            keys[i] = items.get(i).getId();
        }
        Arrays.sort(keys);
        List<RecyclerMainItem> sortItems = new ArrayList<>(len);
        for (int i=0; i<len; i++) {
            for (RecyclerMainItem item : items) {
                if (item.getId() == keys[i]) {
                    sortItems.add(item);
                    items.remove(item);
                    break;
                }
            }
        }
        return sortItems;
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
            // TODO 编辑模式
            if (mAdapter.getEditMode()) {
                mAdapter.setEditMode(false);
            } else {
                mAdapter.setEditMode(true);
            }

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
                AppUtils.toAnActivity(this, GlideActivity.class);
                break;
            case ITEM_ID_TEST_FILTER_EMOJI:
                AppUtils.toAnActivity(this, FilterEmojiActivity.class);
                break;

            case ITEM_ID_PULL_REFRESH:
                AppUtils.toAnActivity(this, PullRefreshActivity.class);
                break;

            case ITEM_ID_MANAGING_AUDIO_PLAY:
                AppUtils.toAnActivity(this, ManagerAudioActivity.class);
                break;

            case ITEM_ID_TAKE_PHOTO:
                AppUtils.toAnActivity(this, SystemActionBarActivity.class);
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

            case ITEM_ID_TEST_VIEW_DRAG_HELPER:
                AppUtils.toAnActivity(this, DragHelperActivity.class);
                break;

            case ITEM_ID_LBS:
                AppUtils.toAnActivity(this, LBSActivity.class);
                break;

            case ITEM_ID_COMMON_TEST:
                AppUtils.toAnActivity(this, CommonTestActivity.class);
                break;

            case ITEM_ID_CUSTOME_VIEW:
                AppUtils.toAnActivity(this, CustomViewActivity.class);
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
