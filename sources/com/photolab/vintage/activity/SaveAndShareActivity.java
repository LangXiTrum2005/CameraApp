package com.photolab.vintage.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import com.photolab.vintage.R;
import com.photolab.vintage.util.AdManager;
import com.photolab.vintage.util.FirebaseAnalyticsHelper;
import com.photolab.vintage.util.FirebaseRealtimeHelper;
import com.photolab.vintage.util.PerformanceHelper;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class SaveAndShareActivity extends BaseActivity {
    File imgFile;
    private ViewGroup viewGroup;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        makeFullScreen();
        setContentView(R.layout.save_and_share_layout);
        AdManager.getInstance().loadBanner(this, (RelativeLayout) findViewById(R.id.bannerAd));
        AdManager.getInstance().showInterstitial(this, null);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.save_and_share));
        this.viewGroup = (ViewGroup) findViewById(android.R.id.content);
        String string = getIntent().getExtras().getString("path");
        this.imgFile = new File(string);
        Glide.with(getApplicationContext()).load(this.imgFile).into((ImageView) findViewById(R.id.preview));
        ((TextView) findViewById(R.id.path)).setText(string);
        findViewById(R.id.btnMore).setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.SaveAndShareActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PerformanceHelper.startPhotoShareTrace();
                FirebaseAnalyticsHelper.trackPhotoShared(SaveAndShareActivity.this, "More");
                FirebaseRealtimeHelper.trackPhotoShared(SaveAndShareActivity.this, "More");
                FirebaseRealtimeHelper.updateAppStats("total_photos_shared", 1L);
                PerformanceHelper.stopPhotoShareTrace("More");
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(SaveAndShareActivity.this.getApplicationContext(), SaveAndShareActivity.this.getPackageName() + ".provider", SaveAndShareActivity.this.imgFile));
                intent.addFlags(3);
                SaveAndShareActivity.this.startActivity(Intent.createChooser(intent, "Share"));
            }
        });
        findViewById(R.id.btnFace).setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.SaveAndShareActivity.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PerformanceHelper.startPhotoShareTrace();
                FirebaseAnalyticsHelper.trackPhotoShared(SaveAndShareActivity.this, "Facebook");
                FirebaseRealtimeHelper.trackPhotoShared(SaveAndShareActivity.this, "Facebook");
                FirebaseRealtimeHelper.updateAppStats("total_photos_shared", 1L);
                PerformanceHelper.stopPhotoShareTrace("Facebook");
                SaveAndShareActivity.this.shareImageWhatsApp("com.facebook.katana", "Facebook");
            }
        });
        findViewById(R.id.btnInta).setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.SaveAndShareActivity.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PerformanceHelper.startPhotoShareTrace();
                FirebaseAnalyticsHelper.trackPhotoShared(SaveAndShareActivity.this, "Instagram");
                FirebaseRealtimeHelper.trackPhotoShared(SaveAndShareActivity.this, "Instagram");
                FirebaseRealtimeHelper.updateAppStats("total_photos_shared", 1L);
                PerformanceHelper.stopPhotoShareTrace("Instagram");
                SaveAndShareActivity.this.shareImageWhatsApp("com.instagram.android", "Instagram");
            }
        });
    }

    public void shareImageWhatsApp(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", getString(R.string.app_name) + "Try it Now https://play.google.com/store/apps/details?id=" + getPackageName());
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this, getPackageName() + ".provider", this.imgFile));
        if (isPackageInstalled(str, this)) {
            intent.setPackage(str);
            startActivity(Intent.createChooser(intent, "Share"));
        } else {
            Toast.makeText(getApplicationContext(), "Please Install " + str2, 1).show();
        }
    }

    private boolean isPackageInstalled(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Exception e) {
            Log.e("eee", "" + e.getMessage());
            return false;
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menusave, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_home) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent(getApplicationContext(), (Class<?>) CameraActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }
}
