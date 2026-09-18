package com.kaopiz.kprogresshud;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
class Helper {
    private static float scale;

    Helper() {
    }

    public static int dpToPixel(float f, Context context) {
        if (scale == 0.0f) {
            scale = context.getResources().getDisplayMetrics().density;
        }
        return (int) (f * scale);
    }
}
