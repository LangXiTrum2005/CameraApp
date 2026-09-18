package com.facebook.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.photolab.vintage.R;

/* JADX INFO: loaded from: classes.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private final Paint mContentPaint;
    private final ShimmerDrawable mShimmerDrawable;
    private boolean mShowShimmer;
    private boolean mStoppedShimmerBecauseVisibility;

    public ShimmerFrameLayout(Context context) {
        super(context);
        this.mContentPaint = new Paint();
        this.mShimmerDrawable = new ShimmerDrawable();
        this.mShowShimmer = true;
        this.mStoppedShimmerBecauseVisibility = false;
        init(context, null);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContentPaint = new Paint();
        this.mShimmerDrawable = new ShimmerDrawable();
        this.mShowShimmer = true;
        this.mStoppedShimmerBecauseVisibility = false;
        init(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContentPaint = new Paint();
        this.mShimmerDrawable = new ShimmerDrawable();
        this.mShowShimmer = true;
        this.mStoppedShimmerBecauseVisibility = false;
        init(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mContentPaint = new Paint();
        this.mShimmerDrawable = new ShimmerDrawable();
        this.mShowShimmer = true;
        this.mStoppedShimmerBecauseVisibility = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Shimmer.Builder alphaHighlightBuilder;
        setWillNotDraw(false);
        this.mShimmerDrawable.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new Shimmer.AlphaHighlightBuilder().build());
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_shimmer_colored) && typedArrayObtainStyledAttributes.getBoolean(R.styleable.ShimmerFrameLayout_shimmer_colored, false)) {
                alphaHighlightBuilder = new Shimmer.ColorHighlightBuilder();
            } else {
                alphaHighlightBuilder = new Shimmer.AlphaHighlightBuilder();
            }
            setShimmer(alphaHighlightBuilder.consumeAttributes(typedArrayObtainStyledAttributes).build());
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public ShimmerFrameLayout setShimmer(Shimmer shimmer) {
        this.mShimmerDrawable.setShimmer(shimmer);
        if (shimmer != null && shimmer.clipToChildren) {
            setLayerType(2, this.mContentPaint);
        } else {
            setLayerType(0, null);
        }
        return this;
    }

    public Shimmer getShimmer() {
        return this.mShimmerDrawable.getShimmer();
    }

    public void startShimmer() {
        this.mShimmerDrawable.startShimmer();
    }

    public void stopShimmer() {
        this.mStoppedShimmerBecauseVisibility = false;
        this.mShimmerDrawable.stopShimmer();
    }

    public boolean isShimmerStarted() {
        return this.mShimmerDrawable.isShimmerStarted();
    }

    public void showShimmer(boolean z) {
        this.mShowShimmer = true;
        if (z) {
            startShimmer();
        }
        invalidate();
    }

    public void hideShimmer() {
        stopShimmer();
        this.mShowShimmer = false;
        invalidate();
    }

    public boolean isShimmerVisible() {
        return this.mShowShimmer;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mShimmerDrawable.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        ShimmerDrawable shimmerDrawable = this.mShimmerDrawable;
        if (shimmerDrawable == null) {
            return;
        }
        if (i != 0) {
            if (isShimmerStarted()) {
                stopShimmer();
                this.mStoppedShimmerBecauseVisibility = true;
                return;
            }
            return;
        }
        if (this.mStoppedShimmerBecauseVisibility) {
            shimmerDrawable.maybeStartShimmer();
            this.mStoppedShimmerBecauseVisibility = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mShimmerDrawable.maybeStartShimmer();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mShowShimmer) {
            this.mShimmerDrawable.draw(canvas);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mShimmerDrawable;
    }
}
