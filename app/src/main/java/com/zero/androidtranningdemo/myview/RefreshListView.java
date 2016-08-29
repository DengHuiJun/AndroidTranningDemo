package com.zero.androidtranningdemo.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.zero.androidtranningdemo.R;

import java.util.zip.Inflater;

/**
 * Created by zero on 16-8-29.
 */
public class RefreshListView extends ListView {

    View mShowLoadHeader;
    TextView mLoadTv;

    public RefreshListView(Context context) {
        super(context);
    }

    public RefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshListView(Context context, AttributeSet attrs, int deff) {
        super(context, attrs, deff);
    }

    private void initLoadHeader(Context context) {

        mShowLoadHeader = LayoutInflater.from(context).inflate(R.layout.loading_header, null);
        mLoadTv = (TextView) mShowLoadHeader.findViewById(R.id.loading_tv);

    }
}
