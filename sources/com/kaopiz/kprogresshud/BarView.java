package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class BarView extends View implements Determinate {
    private RectF mBound;
    private float mBoundGap;
    private RectF mInBound;
    private Paint mInnerPaint;
    private int mMax;
    private Paint mOuterPaint;
    private int mProgress;

    public BarView(Context context) {
        super(context);
        this.mMax = 100;
        this.mProgress = 0;
        init();
    }

    public BarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMax = 100;
        this.mProgress = 0;
        init();
    }

    public BarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMax = 100;
        this.mProgress = 0;
        init();
    }

    private void init() {
        Paint paint = new Paint(1);
        this.mOuterPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mOuterPaint.setStrokeWidth(Helper.dpToPixel(2.0f, getContext()));
        this.mOuterPaint.setColor(-1);
        Paint paint2 = new Paint(1);
        this.mInnerPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mInnerPaint.setColor(-1);
        this.mBoundGap = Helper.dpToPixel(5.0f, getContext());
        float f = this.mBoundGap;
        this.mInBound = new RectF(f, f, ((getWidth() - this.mBoundGap) * this.mProgress) / this.mMax, getHeight() - this.mBoundGap);
        this.mBound = new RectF();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int iDpToPixel = Helper.dpToPixel(2.0f, getContext());
        float f = iDpToPixel;
        this.mBound.set(f, f, i - iDpToPixel, i2 - iDpToPixel);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.mBound;
        canvas.drawRoundRect(rectF, rectF.height() / 2.0f, this.mBound.height() / 2.0f, this.mOuterPaint);
        RectF rectF2 = this.mInBound;
        canvas.drawRoundRect(rectF2, rectF2.height() / 2.0f, this.mInBound.height() / 2.0f, this.mInnerPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(Helper.dpToPixel(100.0f, getContext()), Helper.dpToPixel(20.0f, getContext()));
    }

    @Override // com.kaopiz.kprogresshud.Determinate
    public void setMax(int i) {
        this.mMax = i;
    }

    @Override // com.kaopiz.kprogresshud.Determinate
    public void setProgress(int i) {
        this.mProgress = i;
        RectF rectF = this.mInBound;
        float f = this.mBoundGap;
        rectF.set(f, f, ((getWidth() - this.mBoundGap) * this.mProgress) / this.mMax, getHeight() - this.mBoundGap);
        invalidate();
    }
}
