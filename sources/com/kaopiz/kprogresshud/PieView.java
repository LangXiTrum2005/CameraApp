package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class PieView extends View implements Determinate {
    private RectF mBound;
    private Paint mGreyPaint;
    private int mMax;
    private int mProgress;
    private Paint mWhitePaint;

    public PieView(Context context) {
        super(context);
        this.mMax = 100;
        this.mProgress = 0;
        init();
    }

    public PieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMax = 100;
        this.mProgress = 0;
        init();
    }

    public PieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMax = 100;
        this.mProgress = 0;
        init();
    }

    private void init() {
        Paint paint = new Paint(1);
        this.mWhitePaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mWhitePaint.setStrokeWidth(Helper.dpToPixel(0.1f, getContext()));
        this.mWhitePaint.setColor(-1);
        Paint paint2 = new Paint(1);
        this.mGreyPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mGreyPaint.setStrokeWidth(Helper.dpToPixel(2.0f, getContext()));
        this.mGreyPaint.setColor(-1);
        this.mBound = new RectF();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int iDpToPixel = Helper.dpToPixel(4.0f, getContext());
        float f = iDpToPixel;
        this.mBound.set(f, f, i - iDpToPixel, i2 - iDpToPixel);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.mBound, 270.0f, (this.mProgress * 360.0f) / this.mMax, true, this.mWhitePaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - Helper.dpToPixel(4.0f, getContext()), this.mGreyPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iDpToPixel = Helper.dpToPixel(40.0f, getContext());
        setMeasuredDimension(iDpToPixel, iDpToPixel);
    }

    @Override // com.kaopiz.kprogresshud.Determinate
    public void setMax(int i) {
        this.mMax = i;
    }

    @Override // com.kaopiz.kprogresshud.Determinate
    public void setProgress(int i) {
        this.mProgress = i;
        invalidate();
    }
}
