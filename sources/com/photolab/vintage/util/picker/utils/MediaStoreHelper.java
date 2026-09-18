package com.photolab.vintage.util.picker.utils;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.photolab.vintage.R;
import com.photolab.vintage.util.picker.PhotoPicker;
import com.photolab.vintage.util.picker.entity.PhotoDirectory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediaStoreHelper {

    public interface PhotosResultCallback {
        void onResultCallback(List<PhotoDirectory> list);
    }

    public static void getPhotoDirs(FragmentActivity fragmentActivity, Bundle bundle, PhotosResultCallback photosResultCallback) {
        fragmentActivity.getSupportLoaderManager().initLoader(0, bundle, new PhotoDirLoaderCallbacks(fragmentActivity, photosResultCallback));
    }

    private static class PhotoDirLoaderCallbacks implements LoaderManager.LoaderCallbacks<Cursor> {
        private Context context;
        private PhotosResultCallback resultCallback;

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<Cursor> loader) {
        }

        public PhotoDirLoaderCallbacks(Context context, PhotosResultCallback photosResultCallback) {
            this.context = context;
            this.resultCallback = photosResultCallback;
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            return new PhotoDirectoryLoader(this.context, bundle.getBoolean(PhotoPicker.EXTRA_SHOW_GIF, false));
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            if (cursor != null) {
                List<PhotoDirectory> arrayList = new ArrayList<>();
                PhotoDirectory photoDirectory = new PhotoDirectory();
                photoDirectory.setName(this.context.getString(R.string.all_image));
                photoDirectory.setId("ALL");
                if (cursor.moveToFirst()) {
                    do {
                        int i = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("bucket_id"));
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("bucket_display_name"));
                        String string3 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor.getInt(cursor.getColumnIndexOrThrow("_size")) >= 1) {
                            PhotoDirectory photoDirectory2 = new PhotoDirectory();
                            photoDirectory2.setId(string);
                            photoDirectory2.setName(string2);
                            if (!arrayList.contains(photoDirectory2)) {
                                photoDirectory2.setCoverPath(string3);
                                photoDirectory2.addPhoto(i, string3);
                                photoDirectory2.setDateAdded(cursor.getLong(cursor.getColumnIndexOrThrow("date_added")));
                                arrayList.add(photoDirectory2);
                            } else {
                                arrayList.get(arrayList.indexOf(photoDirectory2)).addPhoto(i, string3);
                            }
                            photoDirectory.addPhoto(i, string3);
                        }
                    } while (cursor.moveToNext());
                }
                if (photoDirectory.getPhotoPaths().size() > 0) {
                    photoDirectory.setCoverPath(photoDirectory.getPhotoPaths().get(0));
                }
                Collections.sort(arrayList);
                arrayList.add(0, photoDirectory);
                PhotosResultCallback photosResultCallback = this.resultCallback;
                if (photosResultCallback != null) {
                    photosResultCallback.onResultCallback(arrayList);
                }
            }
        }
    }
}
