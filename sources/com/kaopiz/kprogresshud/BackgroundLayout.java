package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes2.dex */
class BackgroundLayout extends LinearLayout {
    private int mBackgroundColor;
    private float mCornerRadius;

    public BackgroundLayout(Context context) {
        super(context);
        init();
    }

    public BackgroundLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BackgroundLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        initBackground(getContext().getResources().getColor(R.color.kprogresshud_default_color), this.mCornerRadius);
    }

    private void initBackground(int i, float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(f);
        setBackground(gradientDrawable);
    }

    public void setCornerRadius(float f) {
        float fDpToPixel = Helper.dpToPixel(f, getContext());
        this.mCornerRadius = fDpToPixel;
        initBackground(this.mBackgroundColor, fDpToPixel);
    }

    public void setBaseColor(int i) {
        this.mBackgroundColor = i;
        initBackground(i, this.mCornerRadius);
    }
}
