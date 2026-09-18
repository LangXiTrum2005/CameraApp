package com.github.pavlospt;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class CircleView extends View {
    private static int DEFAULT_BACKGROUND_COLOR = -1;
    private static int DEFAULT_FILL_COLOR = -12303292;
    private static float DEFAULT_FILL_RADIUS = 0.9f;
    private static boolean DEFAULT_SHOW_SUBTITLE = true;
    private static boolean DEFAULT_SHOW_TITLE = true;
    private static int DEFAULT_STROKE_COLOR = -16711681;
    private static float DEFAULT_STROKE_WIDTH = 5.0f;
    private static String DEFAULT_SUBTITLE = "Subtitle";
    private static int DEFAULT_SUBTITLE_COLOR = -1;
    private static float DEFAULT_SUBTITLE_SIZE = 20.0f;
    private static String DEFAULT_TITLE = "Title";
    private static int DEFAULT_TITLE_COLOR = -16711681;
    private static float DEFAULT_TITLE_SIZE = 25.0f;
    private static float DEFAULT_TITLE_SUBTITLE_SPACE = 0.0f;
    private static final int DEFAULT_VIEW_SIZE = 96;
    private int mBackgroundColor;
    private Paint mBackgroundPaint;
    private int mFillColor;
    private Paint mFillPaint;
    private float mFillRadius;
    private RectF mInnerRectF;
    private boolean mShowSubtitle;
    private boolean mShowTitle;
    private int mStrokeColor;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private TextPaint mSubTextPaint;
    private int mSubtitleColor;
    private float mSubtitleSize;
    private String mSubtitleText;
    private int mTitleColor;
    private float mTitleSize;
    private float mTitleSubtitleSpace;
    private String mTitleText;
    private TextPaint mTitleTextPaint;
    private int mViewSize;

    public CircleView(Context context) {
        super(context);
        this.mTitleColor = DEFAULT_TITLE_COLOR;
        this.mSubtitleColor = DEFAULT_SUBTITLE_COLOR;
        this.mStrokeColor = DEFAULT_STROKE_COLOR;
        this.mBackgroundColor = DEFAULT_BACKGROUND_COLOR;
        this.mFillColor = DEFAULT_FILL_COLOR;
        this.mTitleText = DEFAULT_TITLE;
        this.mSubtitleText = DEFAULT_SUBTITLE;
        this.mTitleSize = DEFAULT_TITLE_SIZE;
        this.mSubtitleSize = DEFAULT_SUBTITLE_SIZE;
        this.mStrokeWidth = DEFAULT_STROKE_WIDTH;
        this.mFillRadius = DEFAULT_FILL_RADIUS;
        this.mTitleSubtitleSpace = DEFAULT_TITLE_SUBTITLE_SPACE;
        this.mShowTitle = DEFAULT_SHOW_TITLE;
        this.mShowSubtitle = DEFAULT_SHOW_SUBTITLE;
        init(null, 0);
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTitleColor = DEFAULT_TITLE_COLOR;
        this.mSubtitleColor = DEFAULT_SUBTITLE_COLOR;
        this.mStrokeColor = DEFAULT_STROKE_COLOR;
        this.mBackgroundColor = DEFAULT_BACKGROUND_COLOR;
        this.mFillColor = DEFAULT_FILL_COLOR;
        this.mTitleText = DEFAULT_TITLE;
        this.mSubtitleText = DEFAULT_SUBTITLE;
        this.mTitleSize = DEFAULT_TITLE_SIZE;
        this.mSubtitleSize = DEFAULT_SUBTITLE_SIZE;
        this.mStrokeWidth = DEFAULT_STROKE_WIDTH;
        this.mFillRadius = DEFAULT_FILL_RADIUS;
        this.mTitleSubtitleSpace = DEFAULT_TITLE_SUBTITLE_SPACE;
        this.mShowTitle = DEFAULT_SHOW_TITLE;
        this.mShowSubtitle = DEFAULT_SHOW_SUBTITLE;
        init(attributeSet, 0);
    }

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitleColor = DEFAULT_TITLE_COLOR;
        this.mSubtitleColor = DEFAULT_SUBTITLE_COLOR;
        this.mStrokeColor = DEFAULT_STROKE_COLOR;
        this.mBackgroundColor = DEFAULT_BACKGROUND_COLOR;
        this.mFillColor = DEFAULT_FILL_COLOR;
        this.mTitleText = DEFAULT_TITLE;
        this.mSubtitleText = DEFAULT_SUBTITLE;
        this.mTitleSize = DEFAULT_TITLE_SIZE;
        this.mSubtitleSize = DEFAULT_SUBTITLE_SIZE;
        this.mStrokeWidth = DEFAULT_STROKE_WIDTH;
        this.mFillRadius = DEFAULT_FILL_RADIUS;
        this.mTitleSubtitleSpace = DEFAULT_TITLE_SUBTITLE_SPACE;
        this.mShowTitle = DEFAULT_SHOW_TITLE;
        this.mShowSubtitle = DEFAULT_SHOW_SUBTITLE;
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CircleView, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CircleView_cv_titleText)) {
            this.mTitleText = typedArrayObtainStyledAttributes.getString(R.styleable.CircleView_cv_titleText);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CircleView_cv_subtitleText)) {
            this.mSubtitleText = typedArrayObtainStyledAttributes.getString(R.styleable.CircleView_cv_subtitleText);
        }
        this.mTitleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleView_cv_titleColor, DEFAULT_TITLE_COLOR);
        this.mSubtitleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleView_cv_subtitleColor, DEFAULT_SUBTITLE_COLOR);
        this.mBackgroundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleView_cv_backgroundColorValue, DEFAULT_BACKGROUND_COLOR);
        this.mStrokeColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleView_cv_strokeColorValue, DEFAULT_STROKE_COLOR);
        this.mFillColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleView_cv_fillColor, DEFAULT_FILL_COLOR);
        this.mTitleSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.CircleView_cv_titleSize, DEFAULT_TITLE_SIZE);
        this.mSubtitleSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.CircleView_cv_subtitleSize, DEFAULT_SUBTITLE_SIZE);
        this.mStrokeWidth = typedArrayObtainStyledAttributes.getFloat(R.styleable.CircleView_cv_strokeWidthSize, DEFAULT_STROKE_WIDTH);
        this.mFillRadius = typedArrayObtainStyledAttributes.getFloat(R.styleable.CircleView_cv_fillRadius, DEFAULT_FILL_RADIUS);
        this.mTitleSubtitleSpace = typedArrayObtainStyledAttributes.getFloat(R.styleable.CircleView_cv_titleSubtitleSpace, DEFAULT_TITLE_SUBTITLE_SPACE);
        typedArrayObtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.mTitleTextPaint = textPaint;
        textPaint.setFlags(1);
        this.mTitleTextPaint.setTypeface(Typeface.defaultFromStyle(0));
        this.mTitleTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTitleTextPaint.setLinearText(true);
        this.mTitleTextPaint.setColor(this.mTitleColor);
        this.mTitleTextPaint.setTextSize(this.mTitleSize);
        TextPaint textPaint2 = new TextPaint();
        this.mSubTextPaint = textPaint2;
        textPaint2.setFlags(1);
        this.mSubTextPaint.setTypeface(Typeface.defaultFromStyle(0));
        this.mSubTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSubTextPaint.setLinearText(true);
        this.mSubTextPaint.setColor(this.mSubtitleColor);
        this.mSubTextPaint.setTextSize(this.mSubtitleSize);
        Paint paint = new Paint();
        this.mStrokePaint = paint;
        paint.setFlags(1);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setColor(this.mStrokeColor);
        this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
        Paint paint2 = new Paint();
        this.mBackgroundPaint = paint2;
        paint2.setFlags(1);
        this.mBackgroundPaint.setStyle(Paint.Style.FILL);
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        Paint paint3 = new Paint();
        this.mFillPaint = paint3;
        paint3.setFlags(1);
        this.mFillPaint.setStyle(Paint.Style.FILL);
        this.mFillPaint.setColor(this.mFillColor);
        this.mInnerRectF = new RectF();
    }

    private void invalidateTextPaints() {
        this.mTitleTextPaint.setColor(this.mTitleColor);
        this.mSubTextPaint.setColor(this.mSubtitleColor);
        this.mTitleTextPaint.setTextSize(this.mTitleSize);
        this.mSubTextPaint.setTextSize(this.mSubtitleSize);
        invalidate();
    }

    private void invalidatePaints() {
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        this.mStrokePaint.setColor(this.mStrokeColor);
        this.mFillPaint.setColor(this.mFillColor);
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iResolveSize = resolveSize(DEFAULT_VIEW_SIZE, i);
        int iResolveSize2 = resolveSize(DEFAULT_VIEW_SIZE, i2);
        this.mViewSize = Math.min(iResolveSize, iResolveSize2);
        setMeasuredDimension(iResolveSize, iResolveSize2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.mInnerRectF;
        int i = this.mViewSize;
        rectF.set(0.0f, 0.0f, i, i);
        this.mInnerRectF.offset((getWidth() - this.mViewSize) / 2, (getHeight() - this.mViewSize) / 2);
        float strokeWidth = (int) ((this.mStrokePaint.getStrokeWidth() / 2.0f) + 0.5f);
        this.mInnerRectF.inset(strokeWidth, strokeWidth);
        float fCenterX = this.mInnerRectF.centerX();
        float fCenterY = this.mInnerRectF.centerY();
        canvas.drawArc(this.mInnerRectF, 0.0f, 360.0f, true, this.mBackgroundPaint);
        canvas.drawCircle(fCenterX, fCenterY, (((this.mViewSize / 2) * this.mFillRadius) + 0.5f) - this.mStrokePaint.getStrokeWidth(), this.mFillPaint);
        int i2 = (int) fCenterX;
        int iDescent = (int) (fCenterY - ((this.mTitleTextPaint.descent() + this.mTitleTextPaint.ascent()) / 2.0f));
        canvas.drawOval(this.mInnerRectF, this.mStrokePaint);
        if (this.mShowTitle) {
            canvas.drawText(this.mTitleText, i2, iDescent, this.mTitleTextPaint);
        }
        if (this.mShowSubtitle) {
            canvas.drawText(this.mSubtitleText, i2, iDescent + 20 + this.mTitleSubtitleSpace, this.mSubTextPaint);
        }
    }

    public void setShowTitle(boolean z) {
        this.mShowTitle = z;
        invalidate();
    }

    public void setShowSubtitle(boolean z) {
        this.mShowSubtitle = z;
        invalidate();
    }

    public String getTitleText() {
        return this.mTitleText;
    }

    public void setTitleText(String str) {
        this.mTitleText = str;
        invalidate();
    }

    public String getSubtitleText() {
        return this.mSubtitleText;
    }

    public void setSubtitleText(String str) {
        this.mSubtitleText = str;
        invalidate();
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getFillColor() {
        return this.mStrokeColor;
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
        invalidatePaints();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        invalidatePaints();
    }

    public void setFillColor(int i) {
        this.mFillColor = i;
        invalidatePaints();
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void setBackgroundColor(float f) {
        this.mStrokeWidth = f;
        invalidate();
    }

    public float getFillRadius() {
        return this.mFillRadius;
    }

    public void setFillRadius(float f) {
        this.mFillRadius = f;
        invalidate();
    }

    public float getTitleSize() {
        return this.mTitleSize;
    }

    public void setTitleSize(float f) {
        this.mTitleSize = f;
        invalidateTextPaints();
    }

    public float getSubtitleSize() {
        return this.mSubtitleSize;
    }

    public void setSubtitleSize(float f) {
        this.mSubtitleSize = f;
        invalidateTextPaints();
    }

    public int getTitleColor() {
        return this.mTitleColor;
    }

    public void setTitleColor(int i) {
        this.mTitleColor = i;
        invalidateTextPaints();
    }

    public int getSubtitleColor() {
        return this.mSubtitleColor;
    }

    public void setSubtitleColor(int i) {
        this.mSubtitleColor = i;
        invalidateTextPaints();
    }

    public float getTitleSubtitleSpace() {
        return this.mTitleSubtitleSpace;
    }

    public void setTitleSubtitleSpace(float f) {
        this.mTitleSubtitleSpace = f;
        invalidateTextPaints();
    }
}
