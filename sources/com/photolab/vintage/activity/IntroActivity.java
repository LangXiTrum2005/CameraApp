package com.photolab.vintage.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.photolab.vintage.R;
import com.photolab.vintage.util.AdManager;
import com.photolab.vintage.util.SharePreferenceUtil;
import com.photolab.vintage.util.adapter.IntroAdapter;
import com.photolab.vintage.util.bean.IntroItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class IntroActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 101;
    private AppCompatButton btnNext;
    private TextView btnSkip;
    private IntroAdapter introAdapter;
    private LinearLayout layoutIndicators;
    private ViewPager2 viewPager;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!SharePreferenceUtil.isFirstRun(this)) {
            if (hasAllPermissions()) {
                startCameraActivity();
                return;
            } else {
                startPermissionActivity();
                return;
            }
        }
        setContentView(R.layout.activity_intro);
        AdManager.getInstance().loadInterstitial(this);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        this.viewPager = (ViewPager2) findViewById(R.id.viewPager);
        this.layoutIndicators = (LinearLayout) findViewById(R.id.layoutIndicators);
        this.btnNext = (AppCompatButton) findViewById(R.id.btnNext);
        this.btnSkip = (TextView) findViewById(R.id.btnSkip);
        setupViewPager();
        setupIndicators();
        setCurrentIndicator(0);
        this.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.photolab.vintage.activity.IntroActivity.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                IntroActivity.this.setCurrentIndicator(i);
                if (i == IntroActivity.this.introAdapter.getItemCount() - 1) {
                    IntroActivity.this.btnNext.setText("GET STARTED");
                } else {
                    IntroActivity.this.btnNext.setText("NEXT");
                }
            }
        });
        this.btnNext.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.IntroActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (IntroActivity.this.viewPager.getCurrentItem() + 1 < IntroActivity.this.introAdapter.getItemCount()) {
                    IntroActivity.this.viewPager.setCurrentItem(IntroActivity.this.viewPager.getCurrentItem() + 1);
                } else {
                    IntroActivity.this.completeIntro();
                }
            }
        });
        this.btnSkip.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.IntroActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IntroActivity.this.completeIntro();
            }
        });
    }

    private void setupViewPager() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IntroItem("Capture Moments", "Turn back time with a classic film camera.", R.drawable.intro_bg_1));
        arrayList.add(new IntroItem("Authentic Film Look", "Real-time color filters featuring realistic film grain and natural light leaks.", R.drawable.intro_bg_2));
        arrayList.add(new IntroItem("Share Your Story", "Save high-quality photos and instantly share your story.", R.drawable.intro_bg_3));
        this.viewPager.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.photolab.vintage.activity.IntroActivity.4
            private static final float MIN_SCALE = 0.75f;

            @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
            public void transformPage(View view, float f) {
                int width = view.getWidth();
                if (f < -1.0f) {
                    view.setAlpha(0.0f);
                    return;
                }
                if (f <= 0.0f) {
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setScaleX(1.0f);
                    view.setScaleY(1.0f);
                    return;
                }
                if (f <= 1.0f) {
                    view.setAlpha(1.0f - f);
                    view.setTranslationX(width * (-f));
                    float fAbs = ((1.0f - Math.abs(f)) * 0.25f) + 0.75f;
                    view.setScaleX(fAbs);
                    view.setScaleY(fAbs);
                    return;
                }
                view.setAlpha(0.0f);
            }
        });
        IntroAdapter introAdapter = new IntroAdapter(arrayList);
        this.introAdapter = introAdapter;
        this.viewPager.setAdapter(introAdapter);
    }

    private void setupIndicators() {
        int itemCount = this.introAdapter.getItemCount();
        ImageView[] imageViewArr = new ImageView[itemCount];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < itemCount; i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageViewArr[i] = imageView;
            imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.default_indicator));
            imageViewArr[i].setLayoutParams(layoutParams);
            this.layoutIndicators.addView(imageViewArr[i]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentIndicator(int i) {
        int childCount = this.layoutIndicators.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ImageView imageView = (ImageView) this.layoutIndicators.getChildAt(i2);
            if (i2 == i) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected_indicator));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.default_indicator));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeIntro() {
        SharePreferenceUtil.setFirstRun(this, false);
        if (hasAllPermissions()) {
            startCameraActivity();
        } else {
            startPermissionActivity();
        }
    }

    private void startPermissionActivity() {
        startActivity(new Intent(this, (Class<?>) PermissionActivity.class));
        finish();
    }

    private boolean hasAllPermissions() {
        return (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) && (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0);
    }

    private void startCameraActivity() {
        startActivity(new Intent(this, (Class<?>) CameraActivity.class));
        finish();
    }
}
