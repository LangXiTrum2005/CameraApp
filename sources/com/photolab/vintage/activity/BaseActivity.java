package com.photolab.vintage.activity;

import android.app.ProgressDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes2.dex */
public class BaseActivity extends AppCompatActivity {
    public static final int READ_WRITE_STORAGE = 52;
    private ProgressDialog mProgressDialog;

    public void isPermissionGranted(boolean z, String str) {
    }

    public boolean requestPermission(String str) {
        boolean z = ContextCompat.checkSelfPermission(this, str) == 0;
        if (!z) {
            ActivityCompat.requestPermissions(this, new String[]{str}, 52);
        }
        return z;
    }

    public void makeFullScreen() {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 52) {
            isPermissionGranted(iArr[0] == 0, strArr[0]);
        }
    }

    public void showLoading(String str) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.mProgressDialog = progressDialog;
        progressDialog.setMessage(str);
        this.mProgressDialog.setProgressStyle(0);
        this.mProgressDialog.setCancelable(false);
        this.mProgressDialog.show();
    }

    public void hideLoading() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
