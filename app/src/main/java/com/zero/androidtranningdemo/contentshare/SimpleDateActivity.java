package com.zero.androidtranningdemo.contentshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.myview.TitleView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zero on 15-8-19.
 */
public class SimpleDateActivity extends Activity {
    private static final String TAG = "SimpleDateActivity";

    @Bind(R.id.simple_data_title_bar)
    TitleView mTitleView;

    @Bind(R.id.send_et)
    EditText mSendEt;

    @Bind(R.id.get_data_tv)
    TextView mGetDataTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_data_activity);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                String text = intent.getStringExtra(Intent.EXTRA_TEXT);
                if (!text.equals("")) {
                    mGetDataTv.setText(text);
                }
            } else if (type.startsWith("image/")) {
//                handleSendImage(intent); // Handle single image being sent
            }
        } else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("image/")) {
//                handleSendMultipleImages(intent); // Handle multiple images being sent
            }
        } else {
            // Handle other intents, such as being started from the home screen
        }

        mTitleView.setTitleText("Content Sharing");
    }

    @OnClick(R.id.send_btn)
    public void sendAction() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,mSendEt.getText().toString());
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
