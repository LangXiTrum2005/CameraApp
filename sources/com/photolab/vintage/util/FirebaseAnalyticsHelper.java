package com.photolab.vintage.util;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.photolab.vintage.App;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FirebaseAnalyticsHelper {
    public static final String EVENT_CAMERA_OPENED = "camera_opened";
    public static final String EVENT_EDIT_STARTED = "edit_started";
    public static final String EVENT_EDIT_TOOL_SELECTED = "edit_tool_selected";
    public static final String EVENT_FILTER_APPLIED = "filter_applied";
    public static final String EVENT_GALLERY_OPENED = "gallery_opened";
    public static final String EVENT_PHOTO_CAPTURED = "photo_captured";
    public static final String EVENT_PHOTO_SAVED = "photo_saved";
    public static final String EVENT_PHOTO_SHARED = "photo_shared";
    public static final String EVENT_SETTINGS_OPENED = "settings_opened";
    public static final String EVENT_SETTING_CHANGED = "setting_changed";
    public static final String PARAM_ADJUST_TYPE = "adjust_type";
    public static final String PARAM_ADJUST_VALUE = "adjust_value";
    public static final String PARAM_FILTER_NAME = "filter_name";
    public static final String PARAM_SETTING_NAME = "setting_name";
    public static final String PARAM_SETTING_VALUE = "setting_value";
    public static final String PARAM_SHARE_METHOD = "share_method";
    public static final String PARAM_TOOL_NAME = "tool_name";

    private static FirebaseAnalytics getAnalytics(Context context) {
        return App.getFirebaseAnalytics();
    }

    public static void logEvent(Context context, String str) {
        FirebaseAnalytics analytics = getAnalytics(context);
        if (analytics != null) {
            analytics.logEvent(str, null);
        }
    }

    public static void logEvent(Context context, String str, Map<String, Object> map) {
        FirebaseAnalytics analytics = getAnalytics(context);
        if (analytics == null || map == null) {
            return;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                bundle.putString(entry.getKey(), (String) value);
            } else if (value instanceof Integer) {
                bundle.putInt(entry.getKey(), ((Integer) value).intValue());
            } else if (value instanceof Long) {
                bundle.putLong(entry.getKey(), ((Long) value).longValue());
            } else if (value instanceof Double) {
                bundle.putDouble(entry.getKey(), ((Double) value).doubleValue());
            } else if (value instanceof Float) {
                bundle.putFloat(entry.getKey(), ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                bundle.putBoolean(entry.getKey(), ((Boolean) value).booleanValue());
            }
        }
        analytics.logEvent(str, bundle);
    }

    public static void logScreenView(Context context, String str) {
        FirebaseAnalytics analytics = getAnalytics(context);
        if (analytics != null) {
            Bundle bundle = new Bundle();
            bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, str);
            analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
        }
    }

    public static void trackCameraOpened(Context context) {
        logEvent(context, EVENT_CAMERA_OPENED);
        logScreenView(context, "Camera");
    }

    public static void trackPhotoCaptured(Context context) {
        logEvent(context, EVENT_PHOTO_CAPTURED);
    }

    public static void trackFilterApplied(Context context, String str) {
        HashMap map = new HashMap();
        map.put(PARAM_FILTER_NAME, str);
        logEvent(context, EVENT_FILTER_APPLIED, map);
    }

    public static void trackEditStarted(Context context) {
        logEvent(context, EVENT_EDIT_STARTED);
        logScreenView(context, "EditPhoto");
    }

    public static void trackEditToolSelected(Context context, String str) {
        HashMap map = new HashMap();
        map.put(PARAM_TOOL_NAME, str);
        logEvent(context, EVENT_EDIT_TOOL_SELECTED, map);
    }

    public static void trackPhotoSaved(Context context) {
        logEvent(context, EVENT_PHOTO_SAVED);
    }

    public static void trackPhotoShared(Context context, String str) {
        HashMap map = new HashMap();
        map.put(PARAM_SHARE_METHOD, str);
        logEvent(context, EVENT_PHOTO_SHARED, map);
    }

    public static void trackSettingsOpened(Context context) {
        logEvent(context, EVENT_SETTINGS_OPENED);
        logScreenView(context, "Settings");
    }

    public static void trackSettingChanged(Context context, String str, Object obj) {
        HashMap map = new HashMap();
        map.put(PARAM_SETTING_NAME, str);
        if (obj instanceof String) {
            map.put(PARAM_SETTING_VALUE, (String) obj);
        } else if (obj instanceof Boolean) {
            map.put(PARAM_SETTING_VALUE, ((Boolean) obj).toString());
        }
        logEvent(context, EVENT_SETTING_CHANGED, map);
    }

    public static void trackGalleryOpened(Context context) {
        logEvent(context, EVENT_GALLERY_OPENED);
        logScreenView(context, "Gallery");
    }

    public static void trackAdjustChanged(Context context, String str, float f) {
        HashMap map = new HashMap();
        map.put(PARAM_ADJUST_TYPE, str);
        map.put(PARAM_ADJUST_VALUE, Float.valueOf(f));
        logEvent(context, "adjust_changed", map);
    }
}
