package com.zero.androidtranningdemo.activities;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.zero.androidtranningdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zero on 15-8-28.
 */
public class FrescoActivity extends Activity {

    @Bind(R.id.my_image_view)
    SimpleDraweeView mGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_fresco);
        ButterKnife.bind(this);

        Uri uri = Uri.parse("http://7xjung.com1.z0.glb.clouddn.com/loadgif.gif");
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setAutoPlayAnimations(true)
                .build();
        mGif.setController(controller);
    }
}
