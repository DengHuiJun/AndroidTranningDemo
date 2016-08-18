package com.zero.androidtranningdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * 可排序
 * Created by zero on 16-8-16.
 */
public class RecyclerMainItem {
    private int id;
    private Drawable iconDrawable;
    private String title;

    public RecyclerMainItem(int id) {
        this.id = id;
    }
    public RecyclerMainItem() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public View getView(Context context) {
//        View view = LayoutInflater.from(context).inflate()
        return null;
    }

}
