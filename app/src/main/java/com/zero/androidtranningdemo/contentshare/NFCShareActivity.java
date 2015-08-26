package com.zero.androidtranningdemo.contentshare;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.myview.TitleView;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zero on 15-8-20.
 */
public class NFCShareActivity extends Activity {
    private static final String TAG = "NFCShareActivity";

    @Bind(R.id.nfc_title_view)
    TitleView mTitleView;

    NfcAdapter mNfcAdapter;

    boolean mAndroidBeamAvailable = false;

    private Uri[] mFileUris;

    private FileUriCallback mFileUriCallback;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc_share);
        ButterKnife.bind(this);
        mTitleView.setTitleText("Sharing Files with NFC");

//        isAndroidBeamAvailable();
//        setSendFileUris();

        if (mAndroidBeamAvailable) {
            mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
            mFileUriCallback = new FileUriCallback();
            mNfcAdapter.setBeamPushUrisCallback(mFileUriCallback,this);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private class FileUriCallback implements NfcAdapter.CreateBeamUrisCallback {

        @Override
        public Uri[] createBeamUris(NfcEvent event) {
            Toast.makeText(NFCShareActivity.this,"成功发送",Toast.LENGTH_SHORT).show();
            return mFileUris;
        }
    }

    private void isAndroidBeamAvailable() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mAndroidBeamAvailable = false;
            Toast.makeText(this,"不支持NFC",Toast.LENGTH_SHORT).show();
        } else {
            mAndroidBeamAvailable = true;
        }
    }

    private void setSendFileUris() {
        mFileUris = new Uri[10];
        String transferFile = "transferimage.jpg";
        File extDir = getExternalFilesDir(null);
        File requestFile = new File(extDir, transferFile);
        requestFile.setReadable(true, false);
        // Get a URI for the File and add it to the list of URIs
        Uri fileUri = Uri.fromFile(requestFile);
        if (fileUri != null) {
            mFileUris[0] = fileUri;
        } else {
            Log.e("My Activity", "No File URI available for file.");
        }
    }
}
