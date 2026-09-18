package com.photolab.vintage.util.picker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.photolab.vintage.R;
import com.photolab.vintage.util.picker.fragment.ImagePagerFragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoPagerActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private ImagePagerFragment pagerFragment;
    private boolean showDelete;

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.__picker_activity_photo_pager);
        int intExtra = getIntent().getIntExtra(PhotoPreview.EXTRA_CURRENT_ITEM, 0);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(PhotoPreview.EXTRA_PHOTOS);
        this.showDelete = getIntent().getBooleanExtra(PhotoPreview.EXTRA_SHOW_DELETE, true);
        if (this.pagerFragment == null) {
            this.pagerFragment = (ImagePagerFragment) getSupportFragmentManager().findFragmentById(R.id.photoPagerFragment);
        }
        this.pagerFragment.setPhotos(stringArrayListExtra, intExtra);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        this.actionBar = supportActionBar;
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            this.actionBar.setElevation(25.0f);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(PhotoPicker.KEY_SELECTED_PHOTOS, this.pagerFragment.getPaths());
        setResult(-1, intent);
        finish();
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
