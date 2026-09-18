package com.photolab.vintage.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.photolab.vintage.R;
import com.photolab.vintage.util.AdManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 200;
    private AppCompatButton btnGrant;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        setContentView(R.layout.activity_permission);
        AdManager.getInstance().loadInterstitial(this);
        AppCompatButton appCompatButton = (AppCompatButton) findViewById(R.id.btnGrant);
        this.btnGrant = appCompatButton;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.PermissionActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PermissionActivity.this.requestPermissions();
            }
        });
        if (hasAllPermissions()) {
            startCameraActivity();
        }
    }

    private boolean hasAllPermissions() {
        return (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) && (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPermissions() {
        ArrayList arrayList = new ArrayList();
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            arrayList.add("android.permission.CAMERA");
        }
        if (Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            arrayList.add("android.permission.POST_NOTIFICATIONS");
        }
        if (arrayList.isEmpty()) {
            startCameraActivity();
        } else {
            ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[0]), 200);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 200) {
            boolean z = false;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if ("android.permission.CAMERA".equals(strArr[i2]) && iArr[i2] == 0) {
                    z = true;
                }
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
                z = true;
            }
            if (z) {
                AdManager.getInstance().showInterstitial(this, new Runnable() { // from class: com.photolab.vintage.activity.PermissionActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PermissionActivity.this.startCameraActivity();
                    }
                });
            } else {
                Toast.makeText(this, "Camera permission is required to take photos.", 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCameraActivity() {
        startActivity(new Intent(this, (Class<?>) CameraActivity.class));
        finish();
    }
}
