package com.yanxing.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 原点进度
 * Created by lishuangxiang on 2016/10/21.
 */

public class CircleDotProgressBar extends View {

    private Paint mPaint;
    private float mCenterX;
    private float mCenterY;
    private float mSin_1;

    //当前进度
    private int mProgress;
    //最大进度
    private int mProgressMax;
    //当前进度百分比
    private int mPercent;

    public CircleDotProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleDotProgressBar(Context context) {
        this(context, null);
    }

    public CircleDotProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mSin_1 = (float) Math.sin(Math.toRadians(1));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float outerRadius = (getWidth() > getHeight() ? getHeight() : getWidth()) / 2.f;
        mCenterX = getWidth() / 2;
        mCenterY = getHeight() / 2;

        float dotRadius = mSin_1 * outerRadius / (1 + mSin_1);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        int count = 0;
        //当前进度
        while (count < mPercent) {
            canvas.drawCircle(mCenterX, mCenterY - outerRadius + dotRadius, dotRadius, mPaint);
            canvas.rotate(3.6f, mCenterX, mCenterY);
        }
        //未完成进度
        mPaint.setColor(Color.GRAY);
        count--;
        while (count++ < 100) {
            canvas.drawCircle(mCenterX, mCenterY - outerRadius + dotRadius, dotRadius, mPaint);
            canvas.rotate(3.6f, mCenterX, mCenterY);
        }
    }

    public int getProgress() {
        return mProgress;
    }

    public synchronized void setProgress(int progress) {
        if (progress>mProgressMax){
            mProgress = progress;
            mPercent = progress * 100 / mProgressMax;
            postInvalidate();
        }
    }

    public int getProgressMax() {
        return mProgressMax;
    }

    public synchronized void setProgressMax(int progressMax) {
        mProgressMax = progressMax;
    }
}