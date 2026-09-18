package com.photolab.vintage.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.photolab.vintage.R;

/* JADX INFO: loaded from: classes2.dex */
public class VerticalSlider extends View {
    private static final int COLOR_BG = Color.parseColor("#dddfeb");
    private static final int COLOR_FG = Color.parseColor("#7da1ae");
    private static final int THUMB_RADIUS_FG = 6;
    private static final int TRACK_HEIGHT_BG = 4;
    private static final int TRACK_HEIGHT_FG = 2;
    private OnProgressChangeListener mListener;
    private float mProgress;
    private Paint mThumbFgPaint;
    private int mThumbRadius;
    private Paint mTrackBgPaint;
    private int mTrackBgThickness;
    private Paint mTrackFgPaint;
    private int mTrackFgThickness;
    private RectF mTrackRect;

    public interface OnProgressChangeListener {
        void onFinish();

        void onProgress(float f);
    }

    public VerticalSlider(Context context) {
        super(context);
        this.mProgress = 0.0f;
        init(null, 0);
    }

    public VerticalSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0.0f;
        init(attributeSet, 0);
    }

    public VerticalSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0.0f;
        init(attributeSet, i);
    }

    public void setThumbColor(int i) {
        this.mThumbFgPaint.setColor(i);
        invalidate();
    }

    public void setTrackFgColor(int i) {
        this.mTrackFgPaint.setColor(i);
        invalidate();
    }

    public void setTrackBgColor(int i) {
        this.mTrackBgPaint.setColor(i);
        invalidate();
    }

    public void setThumbRadiusPx(int i) {
        this.mThumbRadius = i;
        invalidate();
    }

    public void setTrackFgThicknessPx(int i) {
        this.mTrackFgThickness = i;
        invalidate();
    }

    public void setTrackBgThicknessPx(int i) {
        this.mTrackBgThickness = i;
        invalidate();
    }

    public void setProgress(float f) {
        setProgress(f, false);
    }

    public void setProgress(float f, boolean z) {
        onProgressChanged(f, z);
    }

    public void setOnSliderProgressChangeListener(OnProgressChangeListener onProgressChangeListener) {
        this.mListener = onProgressChangeListener;
    }

    private void init(AttributeSet attributeSet, int i) {
        setFocusable(true);
        int iResolveAttrColor = resolveAttrColor("colorControlNormal", COLOR_BG);
        int iResolveAttrColor2 = resolveAttrColor("colorControlActivated", COLOR_FG);
        Paint paint = new Paint(1);
        this.mThumbFgPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mThumbFgPaint.setColor(iResolveAttrColor2);
        Paint paint2 = new Paint(1);
        this.mTrackBgPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mTrackBgPaint.setColor(iResolveAttrColor);
        Paint paint3 = new Paint(1);
        this.mTrackFgPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.mTrackFgPaint.setColor(iResolveAttrColor2);
        this.mTrackRect = new RectF();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mThumbRadius = (int) TypedValue.applyDimension(1, 6.0f, displayMetrics);
        this.mTrackBgThickness = (int) TypedValue.applyDimension(1, 4.0f, displayMetrics);
        this.mTrackFgThickness = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalSlider, i, 0);
            this.mThumbFgPaint.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.VerticalSlider_vs_thumb_color, this.mThumbFgPaint.getColor()));
            this.mTrackFgPaint.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.VerticalSlider_vs_track_fg_color, this.mTrackFgPaint.getColor()));
            this.mTrackBgPaint.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.VerticalSlider_vs_track_bg_color, this.mTrackBgPaint.getColor()));
            this.mThumbRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.VerticalSlider_vs_thumb_radius, this.mThumbRadius);
            this.mTrackFgThickness = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.VerticalSlider_vs_track_fg_thickness, this.mTrackFgThickness);
            this.mTrackBgThickness = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.VerticalSlider_vs_track_bg_thickness, this.mTrackBgThickness);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private int resolveAttrColor(String str, int i) {
        int identifier = getResources().getIdentifier(str, "attr", getContext().getPackageName());
        if (identifier <= 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(identifier, typedValue, true);
        return getResources().getColor(typedValue.resourceId);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(getSuggestedMinimumHeight(), i2);
        int paddingLeft = getPaddingLeft() + (this.mThumbRadius * 2) + getPaddingRight();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = Math.max(paddingLeft, getSuggestedMinimumWidth());
        }
        setMeasuredDimension(size, defaultSize);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float y = motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
            }
            return true;
        }
        this.mListener.onFinish();
        onProgressChanged(1.0f - (y / (((getHeight() - getPaddingTop()) - getPaddingBottom()) - (this.mThumbRadius * 2))), true);
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 19) {
            float f = this.mProgress;
            if (f < 1.0f) {
                onProgressChanged(f + 0.02f, true);
                return true;
            }
        } else if (i == 20) {
            float f2 = this.mProgress;
            if (f2 > 0.0f) {
                onProgressChanged(f2 - 0.02f, true);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void onProgressChanged(float f, boolean z) {
        OnProgressChangeListener onProgressChangeListener;
        this.mProgress = f;
        if (f < 0.0f) {
            this.mProgress = 0.0f;
        } else if (f > 1.0f) {
            this.mProgress = 1.0f;
        }
        invalidate();
        if (!z || (onProgressChangeListener = this.mListener) == null) {
            return;
        }
        onProgressChangeListener.onProgress(this.mProgress);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTrack(canvas, this.mThumbRadius, this.mTrackBgThickness, 0, this.mTrackBgPaint, 1.0f);
        int i = this.mTrackBgThickness;
        int i2 = this.mTrackFgThickness;
        int i3 = i > i2 ? (i - i2) >> 1 : 0;
        drawTrack(canvas, this.mThumbRadius, i2, i3, this.mTrackFgPaint, this.mProgress);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int i4 = this.mThumbRadius;
        int i5 = (height - (i4 * 2)) - (i3 * 2);
        float paddingLeft = getPaddingLeft() + ((width - (i4 * 2)) >> 1) + this.mThumbRadius;
        int paddingTop = getPaddingTop();
        int i6 = this.mThumbRadius;
        canvas.drawCircle(paddingLeft, paddingTop + i6 + ((1.0f - this.mProgress) * i5) + i3, i6, this.mThumbFgPaint);
    }

    private void drawTrack(Canvas canvas, int i, int i2, int i3, Paint paint, float f) {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = ((getHeight() - getPaddingTop()) - getPaddingBottom()) - (i * 2);
        int paddingLeft = getPaddingLeft() + ((width - i2) >> 1);
        int height2 = ((getHeight() - getPaddingBottom()) - i) - i3;
        float f2 = i2 * 0.5f;
        this.mTrackRect.set(paddingLeft, ((int) (getPaddingTop() + i + ((1.0f - f) * height))) + i3, paddingLeft + i2, height2);
        canvas.drawRoundRect(this.mTrackRect, f2, f2, paint);
    }

    public float getProgress() {
        return this.mProgress;
    }
}
