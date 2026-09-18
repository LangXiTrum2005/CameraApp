package com.photolab.vintage.util.picker.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtils {
    public static boolean fileIsExists(String str) {
        if (str != null && str.trim().length() > 0) {
            try {
                return new File(str).exists();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        float width = i / bitmap.getWidth();
        float height = i2 / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(width, height, 0.0f, 0.0f);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(2));
        return bitmapCreateBitmap;
    }
}
