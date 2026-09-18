package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class ShimmerDrawable extends Drawable {
    private final Rect mDrawRect;
    private final Matrix mShaderMatrix;
    private Shimmer mShimmer;
    private final Paint mShimmerPaint;
    private final ValueAnimator.AnimatorUpdateListener mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.facebook.shimmer.ShimmerDrawable.1
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShimmerDrawable.this.invalidateSelf();
        }
    };
    private ValueAnimator mValueAnimator;

    private float offset(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public ShimmerDrawable() {
        Paint paint = new Paint();
        this.mShimmerPaint = paint;
        this.mDrawRect = new Rect();
        this.mShaderMatrix = new Matrix();
        paint.setAntiAlias(true);
    }

    public void setShimmer(Shimmer shimmer) {
        this.mShimmer = shimmer;
        if (shimmer != null) {
            this.mShimmerPaint.setXfermode(new PorterDuffXfermode(this.mShimmer.alphaShimmer ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        updateShader();
        updateValueAnimator();
        invalidateSelf();
    }

    public Shimmer getShimmer() {
        return this.mShimmer;
    }

    public void startShimmer() {
        if (this.mValueAnimator == null || isShimmerStarted() || getCallback() == null) {
            return;
        }
        this.mValueAnimator.start();
    }

    public void stopShimmer() {
        if (this.mValueAnimator == null || !isShimmerStarted()) {
            return;
        }
        this.mValueAnimator.cancel();
    }

    public boolean isShimmerStarted() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDrawRect.set(rect);
        updateShader();
        maybeStartShimmer();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float fOffset;
        float fOffset2;
        if (this.mShimmer == null || this.mShimmerPaint.getShader() == null) {
            return;
        }
        float fTan = (float) Math.tan(Math.toRadians(this.mShimmer.tilt));
        float fHeight = this.mDrawRect.height() + (this.mDrawRect.width() * fTan);
        float fWidth = this.mDrawRect.width() + (fTan * this.mDrawRect.height());
        ValueAnimator valueAnimator = this.mValueAnimator;
        float f = 0.0f;
        float fFloatValue = valueAnimator != null ? ((Float) valueAnimator.getAnimatedValue()).floatValue() : 0.0f;
        int i = this.mShimmer.direction;
        if (i != 1) {
            if (i == 2) {
                fOffset2 = offset(fWidth, -fWidth, fFloatValue);
            } else if (i != 3) {
                fOffset2 = offset(-fWidth, fWidth, fFloatValue);
            } else {
                fOffset = offset(fHeight, -fHeight, fFloatValue);
            }
            f = fOffset2;
            fOffset = 0.0f;
        } else {
            fOffset = offset(-fHeight, fHeight, fFloatValue);
        }
        this.mShaderMatrix.reset();
        this.mShaderMatrix.setRotate(this.mShimmer.tilt, this.mDrawRect.width() / 2.0f, this.mDrawRect.height() / 2.0f);
        this.mShaderMatrix.postTranslate(f, fOffset);
        this.mShimmerPaint.getShader().setLocalMatrix(this.mShaderMatrix);
        canvas.drawRect(this.mDrawRect, this.mShimmerPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Shimmer shimmer = this.mShimmer;
        return (shimmer == null || !(shimmer.clipToChildren || this.mShimmer.alphaShimmer)) ? -1 : -3;
    }

    private void updateValueAnimator() {
        boolean zIsStarted;
        if (this.mShimmer == null) {
            return;
        }
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            zIsStarted = valueAnimator.isStarted();
            this.mValueAnimator.cancel();
            this.mValueAnimator.removeAllUpdateListeners();
        } else {
            zIsStarted = false;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, (this.mShimmer.repeatDelay / this.mShimmer.animationDuration) + 1.0f);
        this.mValueAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatMode(this.mShimmer.repeatMode);
        this.mValueAnimator.setStartDelay(this.mShimmer.startDelay);
        this.mValueAnimator.setRepeatCount(this.mShimmer.repeatCount);
        this.mValueAnimator.setDuration(this.mShimmer.animationDuration + this.mShimmer.repeatDelay);
        this.mValueAnimator.addUpdateListener(this.mUpdateListener);
        if (zIsStarted) {
            this.mValueAnimator.start();
        }
    }

    void maybeStartShimmer() {
        Shimmer shimmer;
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator == null || valueAnimator.isStarted() || (shimmer = this.mShimmer) == null || !shimmer.autoStart || getCallback() == null) {
            return;
        }
        this.mValueAnimator.start();
    }

    private void updateShader() {
        Shimmer shimmer;
        Shader radialGradient;
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (iWidth == 0 || iHeight == 0 || (shimmer = this.mShimmer) == null) {
            return;
        }
        int iWidth2 = shimmer.width(iWidth);
        int iHeight2 = this.mShimmer.height(iHeight);
        boolean z = true;
        if (this.mShimmer.shape != 1) {
            if (this.mShimmer.direction != 1 && this.mShimmer.direction != 3) {
                z = false;
            }
            if (z) {
                iWidth2 = 0;
            }
            if (!z) {
                iHeight2 = 0;
            }
            radialGradient = new LinearGradient(0.0f, 0.0f, iWidth2, iHeight2, this.mShimmer.colors, this.mShimmer.positions, Shader.TileMode.CLAMP);
        } else {
            radialGradient = new RadialGradient(iWidth2 / 2.0f, iHeight2 / 2.0f, (float) (((double) Math.max(iWidth2, iHeight2)) / Math.sqrt(2.0d)), this.mShimmer.colors, this.mShimmer.positions, Shader.TileMode.CLAMP);
        }
        this.mShimmerPaint.setShader(radialGradient);
    }
}
