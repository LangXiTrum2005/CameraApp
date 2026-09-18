package com.photolab.vintage.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CrashlyticsHelper {
    private static FirebaseCrashlytics crashlytics;

    public static void initialize(Context context) {
        crashlytics = FirebaseCrashlytics.getInstance();
        String deviceId = getDeviceId(context);
        if (deviceId != null && !deviceId.isEmpty()) {
            crashlytics.setUserId(deviceId);
        }
        setCustomKeys(context);
        crashlytics.setCrashlyticsCollectionEnabled(true);
    }

    public static FirebaseCrashlytics getInstance() {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        return crashlytics;
    }

    private static void setCustomKeys(Context context) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            crashlytics.setCustomKey("app_version", str);
            crashlytics.setCustomKey("version_code", i);
            crashlytics.setCustomKey("android_version", Build.VERSION.RELEASE);
            crashlytics.setCustomKey("sdk_version", Build.VERSION.SDK_INT);
            crashlytics.setCustomKey("device_model", Build.MODEL);
            crashlytics.setCustomKey("device_manufacturer", Build.MANUFACTURER);
            crashlytics.setCustomKey("device_brand", Build.BRAND);
            String deviceId = getDeviceId(context);
            if (deviceId == null || deviceId.isEmpty()) {
                return;
            }
            crashlytics.setCustomKey("device_id", deviceId);
        } catch (PackageManager.NameNotFoundException e) {
            logException(e);
        }
    }

    private static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static void log(String str) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.log(str);
    }

    public static void logException(Throwable th) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.recordException(th);
    }

    public static void logException(String str, Throwable th) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.log(str);
        crashlytics.recordException(th);
    }

    public static void setCustomKey(String str, String str2) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.setCustomKey(str, str2);
    }

    public static void setCustomKey(String str, int i) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.setCustomKey(str, i);
    }

    public static void setCustomKey(String str, long j) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.setCustomKey(str, j);
    }

    public static void setCustomKey(String str, float f) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.setCustomKey(str, f);
    }

    public static void setCustomKey(String str, double d) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.setCustomKey(str, d);
    }

    public static void setCustomKey(String str, boolean z) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.setCustomKey(str, z);
    }

    public static void setCustomKeys(Map<String, Object> map) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    crashlytics.setCustomKey(entry.getKey(), (String) value);
                } else if (value instanceof Integer) {
                    crashlytics.setCustomKey(entry.getKey(), ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    crashlytics.setCustomKey(entry.getKey(), ((Long) value).longValue());
                } else if (value instanceof Float) {
                    crashlytics.setCustomKey(entry.getKey(), ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    crashlytics.setCustomKey(entry.getKey(), ((Double) value).doubleValue());
                } else if (value instanceof Boolean) {
                    crashlytics.setCustomKey(entry.getKey(), ((Boolean) value).booleanValue());
                }
            }
        }
    }

    public static void setUserId(String str) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.setUserId(str);
    }

    public static void setCollectionEnabled(boolean z) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.setCrashlyticsCollectionEnabled(z);
    }

    public static void forceCrash() {
        throw new RuntimeException("This is a test crash from Crashlytics");
    }

    public static void logError(String str, String str2) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.log("Error: " + str);
        crashlytics.log("Context: " + str2);
        crashlytics.recordException(new Exception(str));
    }

    public static void trackUserAction(String str) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.log("User action: " + str);
        crashlytics.setCustomKey("last_user_action", str);
    }

    public static void trackScreen(String str) {
        if (crashlytics == null) {
            crashlytics = FirebaseCrashlytics.getInstance();
        }
        crashlytics.log("Screen: " + str);
        crashlytics.setCustomKey("current_screen", str);
    }
}
