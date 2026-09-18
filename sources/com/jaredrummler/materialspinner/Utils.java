package com.jaredrummler.materialspinner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
final class Utils {
    Utils() {
    }

    static int darker(int i, float f) {
        return Color.argb(Color.alpha(i), Math.max((int) (Color.red(i) * f), 0), Math.max((int) (Color.green(i) * f), 0), Math.max((int) (Color.blue(i) * f), 0));
    }

    static int lighter(int i, float f) {
        float f2 = 1.0f - f;
        return Color.argb(Color.alpha(i), (int) ((((Color.red(i) * f2) / 255.0f) + f) * 255.0f), (int) ((((Color.green(i) * f2) / 255.0f) + f) * 255.0f), (int) ((((Color.blue(i) * f2) / 255.0f) + f) * 255.0f));
    }

    static boolean isRtl(Context context) {
        return context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    static Drawable getDrawable(Context context, int i) {
        return context.getDrawable(i);
    }
}
