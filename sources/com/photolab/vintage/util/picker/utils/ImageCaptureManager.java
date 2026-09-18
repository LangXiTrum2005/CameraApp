package com.photolab.vintage.util.picker.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ImageCaptureManager {
    private static final String CAPTURED_PHOTO_PATH_KEY = "mCurrentPhotoPath";
    public static final int REQUEST_TAKE_PHOTO = 1;
    private Context mContext;
    private String mCurrentPhotoPath;

    public ImageCaptureManager(Context context) {
        this.mContext = context;
    }

    private File createImageFile() throws IOException {
        String str = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date()) + ".jpg";
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (externalStoragePublicDirectory.exists() || externalStoragePublicDirectory.mkdir()) {
            File file = new File(externalStoragePublicDirectory, str);
            this.mCurrentPhotoPath = file.getAbsolutePath();
            return file;
        }
        Log.e("TAG", "Throwing Errors....");
        throw new IOException();
    }

    public Intent dispatchTakePictureIntent() throws IOException {
        Uri uriFromFile;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
            File fileCreateImageFile = createImageFile();
            if (Build.VERSION.SDK_INT >= 24) {
                uriFromFile = FileProvider.getUriForFile(this.mContext.getApplicationContext(), this.mContext.getApplicationInfo().packageName + ".provider", fileCreateImageFile);
            } else {
                uriFromFile = Uri.fromFile(fileCreateImageFile);
            }
            if (uriFromFile != null) {
                intent.putExtra("output", uriFromFile);
            }
        }
        return intent;
    }

    public void galleryAddPic() {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        if (TextUtils.isEmpty(this.mCurrentPhotoPath)) {
            return;
        }
        intent.setData(Uri.fromFile(new File(this.mCurrentPhotoPath)));
        this.mContext.sendBroadcast(intent);
    }

    public String getCurrentPhotoPath() {
        return this.mCurrentPhotoPath;
    }

    public void onSaveInstanceState(Bundle bundle) {
        String str;
        if (bundle == null || (str = this.mCurrentPhotoPath) == null) {
            return;
        }
        bundle.putString(CAPTURED_PHOTO_PATH_KEY, str);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(CAPTURED_PHOTO_PATH_KEY)) {
            return;
        }
        this.mCurrentPhotoPath = bundle.getString(CAPTURED_PHOTO_PATH_KEY);
    }
}
