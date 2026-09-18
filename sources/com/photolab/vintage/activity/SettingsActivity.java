package com.photolab.vintage.activity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.net.MailTo;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.photolab.vintage.R;
import com.photolab.vintage.util.CrashlyticsHelper;
import com.photolab.vintage.util.FirebaseAnalyticsHelper;
import com.photolab.vintage.util.SharePreferenceUtil;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsActivity extends AppCompatActivity {
    private MaterialCardView cardPremium;
    private SwitchMaterial switchGrid;
    private SwitchMaterial switchSaveOriginal;
    private SwitchMaterial switchSound;
    private TextView txtPremiumSubtitle;
    private TextView txtPremiumTitle;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.settings_layout);
        FirebaseAnalyticsHelper.trackSettingsOpened(this);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_settings));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.settings_title);
        }
        this.switchGrid = (SwitchMaterial) findViewById(R.id.switch_grid);
        this.switchSound = (SwitchMaterial) findViewById(R.id.switch_sound);
        this.switchSaveOriginal = (SwitchMaterial) findViewById(R.id.switch_save_original);
        this.cardPremium = (MaterialCardView) findViewById(R.id.card_premium);
        this.txtPremiumTitle = (TextView) findViewById(R.id.txt_premium_title);
        this.txtPremiumSubtitle = (TextView) findViewById(R.id.txt_premium_subtitle);
        this.cardPremium.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.SettingsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SharePreferenceUtil.isPurchased(SettingsActivity.this)) {
                    return;
                }
                SettingsActivity.this.startActivity(new Intent(SettingsActivity.this, (Class<?>) PremiumActivity.class));
            }
        });
        this.switchGrid.setChecked(SharePreferenceUtil.isGridEnabled(this));
        this.switchSound.setChecked(SharePreferenceUtil.isCountdownSoundEnabled(this));
        this.switchSaveOriginal.setChecked(SharePreferenceUtil.isSaveOriginalEnabled(this));
        this.switchGrid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.photolab.vintage.activity.SettingsActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SharePreferenceUtil.setGridEnabled(SettingsActivity.this, z);
                FirebaseAnalyticsHelper.trackSettingChanged(SettingsActivity.this, "grid_enabled", Boolean.valueOf(z));
            }
        });
        this.switchSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.photolab.vintage.activity.SettingsActivity.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SharePreferenceUtil.setCountdownSoundEnabled(SettingsActivity.this, z);
                FirebaseAnalyticsHelper.trackSettingChanged(SettingsActivity.this, "countdown_sound_enabled", Boolean.valueOf(z));
            }
        });
        this.switchSaveOriginal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.photolab.vintage.activity.SettingsActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SharePreferenceUtil.setSaveOriginalEnabled(SettingsActivity.this, z);
                FirebaseAnalyticsHelper.trackSettingChanged(SettingsActivity.this, "save_original_enabled", Boolean.valueOf(z));
            }
        });
        TextView textView = (TextView) findViewById(R.id.txt_version);
        try {
            textView.setText(String.format(Locale.getDefault(), "Version %s (%d)", getPackageManager().getPackageInfo(getPackageName(), 0).versionName, Integer.valueOf(getPackageManager().getPackageInfo(getPackageName(), 0).versionCode)));
        } catch (PackageManager.NameNotFoundException unused) {
            textView.setText("Version 1.0");
        }
        MaterialCardView materialCardView = (MaterialCardView) findViewById(R.id.card_rate_app);
        MaterialCardView materialCardView2 = (MaterialCardView) findViewById(R.id.card_feedback);
        MaterialCardView materialCardView3 = (MaterialCardView) findViewById(R.id.card_privacy);
        MaterialCardView materialCardView4 = (MaterialCardView) findViewById(R.id.card_terms);
        MaterialCardView materialCardView5 = (MaterialCardView) findViewById(R.id.card_about);
        materialCardView.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.SettingsActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingsActivity.this.openRateApp();
            }
        });
        materialCardView2.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.SettingsActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingsActivity.this.sendFeedback();
            }
        });
        materialCardView3.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.SettingsActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingsActivity.this.openPrivacyPolicy();
            }
        });
        materialCardView4.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.SettingsActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingsActivity.this.openTermsOfService();
            }
        });
        materialCardView5.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.SettingsActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingsActivity.this.showAboutDialog();
            }
        });
        CrashlyticsHelper.trackScreen("SettingsActivity");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (SharePreferenceUtil.isPurchased(this)) {
            this.txtPremiumTitle.setText("Premium Unlocked");
            this.txtPremiumSubtitle.setText("Thank you for your support!");
            this.cardPremium.setCardBackgroundColor(getResources().getColor(android.R.color.white));
            this.cardPremium.setClickable(false);
            return;
        }
        this.txtPremiumTitle.setText("Go Premium");
        this.txtPremiumSubtitle.setText("Remove ads & unlock all features");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openRateApp() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFeedback() {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(MailTo.MAILTO_SCHEME));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{getString(R.string.feedback_email)});
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.feedback_subject));
        try {
            startActivity(Intent.createChooser(intent, getString(R.string.settings_feedback)));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No email app found", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openPrivacyPolicy() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.privacy_policy_url))));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "Cannot open browser", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openTermsOfService() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.terms_of_service_url))));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "Cannot open browser", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAboutDialog() {
        String str;
        try {
            str = String.format(Locale.getDefault(), "Version %s (%d)", getPackageManager().getPackageInfo(getPackageName(), 0).versionName, Integer.valueOf(getPackageManager().getPackageInfo(getPackageName(), 0).versionCode));
        } catch (PackageManager.NameNotFoundException unused) {
            str = "Version 1.0";
        }
        new AlertDialog.Builder(this).setTitle(R.string.settings_about).setMessage(getString(R.string.app_name) + "\n\n" + str + "\n\nA retro camera app with vintage filters and effects.").setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).show();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
