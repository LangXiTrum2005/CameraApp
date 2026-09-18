package com.photolab.vintage.util.picker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.photolab.vintage.R;
import com.photolab.vintage.activity.EditPhotoActivity;
import com.photolab.vintage.util.picker.entity.Photo;
import com.photolab.vintage.util.picker.event.OnItemCheckListener;
import com.photolab.vintage.util.picker.fragment.ImagePagerFragment;
import com.photolab.vintage.util.picker.fragment.PhotoPickerFragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoPickerActivity extends AppCompatActivity {
    private boolean forwardMain;
    private ImagePagerFragment imagePagerFragment;
    private PhotoPickerFragment pickerFragment;
    private int maxCount = 9;
    private ArrayList<String> originalPhotos = null;
    private boolean showGif = false;

    public PhotoPickerActivity getActivity() {
        return this;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        boolean booleanExtra = getIntent().getBooleanExtra(PhotoPicker.EXTRA_SHOW_CAMERA, true);
        boolean booleanExtra2 = getIntent().getBooleanExtra(PhotoPicker.EXTRA_SHOW_GIF, false);
        boolean booleanExtra3 = getIntent().getBooleanExtra(PhotoPicker.EXTRA_PREVIEW_ENABLED, true);
        this.forwardMain = getIntent().getBooleanExtra(PhotoPicker.MAIN_ACTIVITY, false);
        setShowGif(booleanExtra2);
        setContentView(R.layout.__picker_activity_photo_picker);
        this.maxCount = getIntent().getIntExtra(PhotoPicker.EXTRA_MAX_COUNT, 9);
        int intExtra = getIntent().getIntExtra(PhotoPicker.EXTRA_GRID_COLUMN, 3);
        this.originalPhotos = getIntent().getStringArrayListExtra(PhotoPicker.EXTRA_ORIGINAL_PHOTOS);
        PhotoPickerFragment photoPickerFragment = (PhotoPickerFragment) getSupportFragmentManager().findFragmentByTag("tag");
        this.pickerFragment = photoPickerFragment;
        if (photoPickerFragment == null) {
            this.pickerFragment = PhotoPickerFragment.newInstance(booleanExtra, booleanExtra2, booleanExtra3, intExtra, this.maxCount, this.originalPhotos);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, this.pickerFragment, "tag").commit();
            getSupportFragmentManager().executePendingTransactions();
        }
        this.pickerFragment.getPhotoGridAdapter().setOnItemCheckListener(new OnItemCheckListener() { // from class: com.photolab.vintage.util.picker.PhotoPickerActivity.1
            @Override // com.photolab.vintage.util.picker.event.OnItemCheckListener
            public final boolean onItemCheck(int i, Photo photo, int i2) {
                return PhotoPickerActivity.this.lambda$onCreate$0$PhotoPickerActivity(i, photo, i2);
            }
        });
    }

    public boolean lambda$onCreate$0$PhotoPickerActivity(int i, Photo photo, int i2) {
        if (!this.forwardMain) {
            Intent intent = new Intent(getApplicationContext(), (Class<?>) EditPhotoActivity.class);
            intent.putExtra("path", photo.getPath());
            startActivity(intent);
            return true;
        }
        finish();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ImagePagerFragment imagePagerFragment = this.imagePagerFragment;
        if (imagePagerFragment == null || !imagePagerFragment.isVisible()) {
            super.onBackPressed();
        } else if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean isShowGif() {
        return this.showGif;
    }

    public void setShowGif(boolean z) {
        this.showGif = z;
    }
}
