package com.zero.androidtranningdemo.customeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 1. Paint 设置公共属性，颜色、填充样式、字体大小、粗细
 * 2. Canvas 在画布上绘制，圆、矩形、椭圆、线、点、特殊路径、Bitmap
 *
 * Created by hui_deng on 2017/9/7.
 */

public class BaseView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    Path path = new Path(); // 初始化 Path 对象

    {
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }


    /**
     * 基本设置
     */
    private void initPaint() {
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        paint.setStrokeWidth(2);

        paint.setTextSize(14);

        //  设置抗锯齿开关
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制底色
//        canvas.drawColor(Color.GREEN);

//        canvas.drawCircle(200, 200, 100, paint);

        canvas.drawPath(path, paint); // 绘制出 path 描述的图形（心形），大功告成

    }
}
