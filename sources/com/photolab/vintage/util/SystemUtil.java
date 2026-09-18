package com.photolab.vintage.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class SystemUtil {
    public static int dpToPx(Context context, int i) {
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }

    public static void clearCacheFile(Context context) {
        File[] fileArrListFiles;
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null || !externalCacheDir.isDirectory() || (fileArrListFiles = externalCacheDir.listFiles()) == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            bitmap.recycle();
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }
}
