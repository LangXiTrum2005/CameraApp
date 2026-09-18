package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
class SpinView extends ImageView implements Indeterminate {
    private int mFrameTime;
    private boolean mNeedToUpdateView;
    private float mRotateDegrees;
    private Runnable mUpdateViewRunnable;

    static /* synthetic */ float access$016(SpinView spinView, float f) {
        float f2 = spinView.mRotateDegrees + f;
        spinView.mRotateDegrees = f2;
        return f2;
    }

    public SpinView(Context context) {
        super(context);
        init();
    }

    public SpinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setImageResource(R.drawable.kprogresshud_spinner);
        this.mFrameTime = 83;
        this.mUpdateViewRunnable = new Runnable() { // from class: com.kaopiz.kprogresshud.SpinView.1
            @Override // java.lang.Runnable
            public void run() {
                SpinView.access$016(SpinView.this, 30.0f);
                SpinView spinView = SpinView.this;
                spinView.mRotateDegrees = spinView.mRotateDegrees < 360.0f ? SpinView.this.mRotateDegrees : SpinView.this.mRotateDegrees - 360.0f;
                SpinView.this.invalidate();
                if (SpinView.this.mNeedToUpdateView) {
                    SpinView spinView2 = SpinView.this;
                    spinView2.postDelayed(this, spinView2.mFrameTime);
                }
            }
        };
    }

    @Override // com.kaopiz.kprogresshud.Indeterminate
    public void setAnimationSpeed(float f) {
        this.mFrameTime = (int) (83.0f / f);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.rotate(this.mRotateDegrees, getWidth() / 2, getHeight() / 2);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mNeedToUpdateView = true;
        post(this.mUpdateViewRunnable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.mNeedToUpdateView = false;
        super.onDetachedFromWindow();
    }
}
