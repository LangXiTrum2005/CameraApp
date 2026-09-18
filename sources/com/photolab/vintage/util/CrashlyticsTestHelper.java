package com.photolab.vintage.util;

import android.content.Context;
import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

/* JADX INFO: loaded from: classes2.dex */
public class CrashlyticsTestHelper {
    private static final String TAG = "CrashlyticsTest";

    public static void testLogMessage(Context context) {
        try {
            String str = "Crashlytics test message at " + System.currentTimeMillis();
            CrashlyticsHelper.log(str);
            Log.d(TAG, "Test log message sent: " + str);
            Log.i(TAG, "Crashlytics is initialized and working");
        } catch (Exception e) {
            Log.e(TAG, "Error testing Crashlytics", e);
        }
    }

    public static void testNonFatalException(Context context) {
        try {
            CrashlyticsHelper.logException("Testing Crashlytics non-fatal exception", new Exception("This is a test non-fatal exception"));
            Log.d(TAG, "Test non-fatal exception logged");
        } catch (Exception e) {
            Log.e(TAG, "Error testing Crashlytics exception", e);
        }
    }

    public static void testCustomKeys(Context context) {
        try {
            CrashlyticsHelper.setCustomKey("test_key_string", "test_value");
            CrashlyticsHelper.setCustomKey("test_key_int", 123);
            CrashlyticsHelper.setCustomKey("test_key_bool", true);
            Log.d(TAG, "Test custom keys set");
        } catch (Exception e) {
            Log.e(TAG, "Error testing custom keys", e);
        }
    }

    public static void forceTestCrash() {
        Log.w(TAG, "FORCING TEST CRASH - This will crash the app!");
        throw new RuntimeException("This is a test crash from CrashlyticsTestHelper");
    }

    public static boolean isCrashlyticsEnabled() {
        try {
            return FirebaseCrashlytics.getInstance() != null;
        } catch (Exception e) {
            Log.e(TAG, "Error checking Crashlytics status", e);
            return false;
        }
    }

    public static void printStatus(Context context) {
        Log.i(TAG, "=== Crashlytics Status ===");
        Log.i(TAG, "Crashlytics enabled: " + isCrashlyticsEnabled());
        Log.i(TAG, "Package name: " + context.getPackageName());
        try {
            Log.i(TAG, "App version: " + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName + " (" + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode + ")");
        } catch (Exception e) {
            Log.e(TAG, "Error getting version info", e);
        }
        Log.i(TAG, "=========================");
    }
}
