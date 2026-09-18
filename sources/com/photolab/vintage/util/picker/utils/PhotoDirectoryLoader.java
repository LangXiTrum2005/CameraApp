package com.photolab.vintage.util.picker.utils;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.loader.content.CursorLoader;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoDirectoryLoader extends CursorLoader {
    final String[] IMAGE_PROJECTION;

    public PhotoDirectoryLoader(Context context, boolean z) {
        String[] strArr;
        super(context);
        String[] strArr2 = {"_id", "_data", "bucket_id", "bucket_display_name", "date_added", "_size"};
        this.IMAGE_PROJECTION = strArr2;
        setProjection(strArr2);
        setUri(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        setSortOrder("date_added DESC");
        setSelection("mime_type=? or mime_type=? or mime_type=? ".concat(z ? "or mime_type=?" : ""));
        if (z) {
            strArr = new String[]{"image/jpeg", "image/png", "image/jpg", "image/gif"};
        } else {
            strArr = new String[]{"image/jpeg", "image/png", "image/jpg"};
        }
        setSelectionArgs(strArr);
    }

    private PhotoDirectoryLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context, uri, strArr, str, strArr2, str2);
        this.IMAGE_PROJECTION = new String[]{"_id", "_data", "bucket_id", "bucket_display_name", "date_added", "_size"};
    }
}
