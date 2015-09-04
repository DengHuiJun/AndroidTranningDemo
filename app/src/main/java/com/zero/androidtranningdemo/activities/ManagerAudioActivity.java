package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.myview.TitleView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zero on 15-9-1.
 */
public class ManagerAudioActivity extends Activity {

    @Bind(R.id.manager_audio_title)
    TitleView mTitleTv;

    private Context mContext;

    private AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_audio);
        ButterKnife.bind(this);
        mContext = this;

        mTitleTv.setTitleText("管理音频播放");
        //设置音乐流，自此之后，不管目标Activity或Fragment是否可见，按下设备的音量键都能够影响我们指定的音频流（在这个例子中，音频流是"music"）。
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        am = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);

        int result = am.requestAudioFocus(afChangeListener,
                // Use the music stream.
                AudioManager.STREAM_MUSIC,
                // Request permanent focus.
                AudioManager.AUDIOFOCUS_GAIN);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//            am.registerMediaButtonEventReceiver(RemoteControlReceiver);
            // Start playback.
            Toast.makeText(mContext,"Start音乐",Toast.LENGTH_SHORT).show();
        }
    }

    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                // Pause playback
                Toast.makeText(mContext,"暂停音乐",Toast.LENGTH_SHORT).show();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Resume playback
                Toast.makeText(mContext,"Resume音乐",Toast.LENGTH_SHORT).show();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // Stop playback
//                am.unregisterMediaButtonEventReceiver(RemoteControlReceiver);
                am.abandonAudioFocus(afChangeListener);

                Toast.makeText(mContext,"Stop音乐",Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
//        am.registerMediaButtonEventReceiver(RemoteControlReceiver);
    }

    public class RemoteControlReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {

                KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
                if (KeyEvent.KEYCODE_MEDIA_PLAY == event.getKeyCode()) {
                    // Handle key press.
                    Toast.makeText(mContext, "Handle key press", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
