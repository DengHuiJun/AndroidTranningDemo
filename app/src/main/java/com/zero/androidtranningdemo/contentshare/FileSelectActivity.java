package com.zero.androidtranningdemo.contentshare;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zero.androidtranningdemo.R;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-20.
 */
public class FileSelectActivity extends Activity {
    private static final String TAG = "FileSelectActivity";

    @Bind(R.id.file_list_view)
    ListView mListView;

//    private File mPrivateRootDir;
    private File mImagesDir;
    private File mInFile;

    File[] mImageFiles;
    String[] mImageFileNames;
    Intent mResultIntent;

    Uri fileUri;

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_select);
        ButterKnife.bind(this);

        setUpFiles();
        initData();
    }

    private void setUpFiles() {

       // mPrivateRootDir = new File(getFilesDir(),"files");
        mImagesDir = new File(getFilesDir(),"files");
        mImageFiles = mImagesDir.listFiles();
//        mInFile = new File(getFilesDir(),"files");
    }

    private void initData() {
        mImageFileNames = new String[mImageFiles.length];
        for (int i = 0 ; i < mImageFiles.length ; i++) {
            mImageFileNames[i] = mImageFiles[i].toString();
        }
        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,mImageFileNames);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(onFilesItemClickListener);
    }

    private AdapterView.OnItemClickListener onFilesItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            File requestFile = new File(mImageFileNames[position]);

            fileUri = FileProvider.getUriForFile(
                    FileSelectActivity.this,
                    getResources().getString(R.string.file_provider_authority),
                    requestFile);
            mResultIntent = new Intent();

            if (fileUri != null) {
                //临时授权给 content URI
                mResultIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                mResultIntent.setDataAndType(fileUri, getContentResolver().getType(fileUri));
                setResult(Activity.RESULT_OK, mResultIntent);
            } else {
                mResultIntent.setDataAndType(null, "");
                setResult(RESULT_CANCELED, mResultIntent);
            }
            finishClickEvent();
        }
    };

    @OnClick(R.id.finish_btn)
    public void finishClickEvent() {
        finish();
    }
}
