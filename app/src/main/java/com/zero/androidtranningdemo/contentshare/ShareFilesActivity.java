package com.zero.androidtranningdemo.contentshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;
import android.widget.TextView;
import android.widget.Toast;

import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.myview.TitleView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-20.
 */
public class ShareFilesActivity extends Activity {

    @Bind(R.id.share_files_title_bar)
    TitleView mTitleView;

    @Bind(R.id.show_file_name_tv)
    TextView mShowFileNameTv;

    private Intent mRequestFileIntent;
    private ParcelFileDescriptor mInputPFD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_files);
        ButterKnife.bind(this);

        mTitleView.setTitleText("Sharing Files");

        mRequestFileIntent = new Intent(Intent.ACTION_PICK);
        mRequestFileIntent.setType("image/jpg");

        makeIntFile();

    }

    @OnClick(R.id.start_request_btn)
    protected void requestFile() {
        startActivityForResult(mRequestFileIntent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        } else {
            Uri returnUri = data.getData();
            try {
                mInputPFD = getContentResolver().openFileDescriptor(returnUri,"r");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }

            Cursor returnCursor = getContentResolver().query(returnUri, null, null, null, null);

            int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
            int sizeIndex = returnCursor.getColumnIndex(OpenableColumns.SIZE);
            returnCursor.moveToFirst();
            mShowFileNameTv.setText("文件名"+returnCursor.getString(nameIndex)+",大小:"+returnCursor.getLong(sizeIndex)+"B");
            returnCursor.close();
        }
    }


    private void makeIntFile() {
        Context context = this;
        boolean success = true;

        //创建目录，通常是/data/data/<包名>/files/files
        File file = new File(context.getFilesDir(),"files");
        if (!file.exists()) {
            file.mkdirs();
        }

        //在上面的目录下创建10个文件，用来与客户端应用共享
        for (int i = 0; i < 10; i++) {
            String filename = "内部文件"+i+".txt";
            String content = "这是第"+i+"个内部文件";
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(new File(file, filename));
                fos.write(content.getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
                success = false;
            }
        }
        Toast.makeText(this, "在" + file.getAbsolutePath() + "目录下创建文件" + (success ? "成功" : "失败"), Toast.LENGTH_SHORT).show();
    }


}
