package com.zero.androidtranningdemo.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zero.androidtranningdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GlideActivity extends AppCompatActivity {

    @Bind(R.id.glide_iv)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);

        imageView.setImageBitmap(null);

        String internetUrl = "http://i.imgur.com/DvpvklR.png";

        String gifUrl = "http://7xjung.com1.z0.glb.clouddn.com/loadgif.gif";

        Glide.with(this)
                .load(gifUrl)
                .asGif()
                .override(300, 300)
                .into(imageView);
    }
}
