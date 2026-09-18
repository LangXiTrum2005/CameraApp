package com.photolab.vintage.util;

import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PerformanceHelper {
    private static Map<String, Trace> activeTraces = new HashMap();
    private static FirebasePerformance firebasePerformance;

    public static void initialize(Context context) {
        if (firebasePerformance == null) {
            firebasePerformance = FirebasePerformance.getInstance();
        }
    }

    public static FirebasePerformance getInstance() {
        if (firebasePerformance == null) {
            firebasePerformance = FirebasePerformance.getInstance();
        }
        return firebasePerformance;
    }

    public static Trace startTrace(String str) {
        if (firebasePerformance == null) {
            firebasePerformance = FirebasePerformance.getInstance();
        }
        Trace traceNewTrace = firebasePerformance.newTrace(str);
        traceNewTrace.start();
        activeTraces.put(str, traceNewTrace);
        return traceNewTrace;
    }

    public static void stopTrace(String str) {
        Trace traceRemove = activeTraces.remove(str);
        if (traceRemove != null) {
            traceRemove.stop();
        }
    }

    public static void addAttribute(String str, String str2, String str3) {
        Trace trace = activeTraces.get(str);
        if (trace != null) {
            trace.putAttribute(str2, str3);
        }
    }

    public static void incrementMetric(String str, String str2, long j) {
        Trace trace = activeTraces.get(str);
        if (trace != null) {
            trace.incrementMetric(str2, j);
        }
    }

    public static void setMetric(String str, String str2, long j) {
        Trace trace = activeTraces.get(str);
        if (trace != null) {
            trace.putMetric(str2, j);
        }
    }

    public static Trace startPhotoCaptureTrace() {
        return startTrace("photo_capture");
    }

    public static void stopPhotoCaptureTrace(String str) {
        if (str == null) {
            str = "none";
        }
        addAttribute("photo_capture", FirebaseAnalyticsHelper.PARAM_FILTER_NAME, str);
        stopTrace("photo_capture");
    }

    public static Trace startPhotoEditTrace() {
        return startTrace("photo_edit");
    }

    public static void stopPhotoEditTrace(String str) {
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        addAttribute("photo_edit", FirebaseAnalyticsHelper.PARAM_TOOL_NAME, str);
        stopTrace("photo_edit");
    }

    public static Trace startFilterApplyTrace() {
        return startTrace("filter_apply");
    }

    public static void stopFilterApplyTrace(String str, String str2) {
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        addAttribute("filter_apply", FirebaseAnalyticsHelper.PARAM_FILTER_NAME, str);
        if (str2 == null) {
            str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        addAttribute("filter_apply", "filter_type", str2);
        stopTrace("filter_apply");
    }

    public static Trace startPhotoSaveTrace() {
        return startTrace("photo_save");
    }

    public static void stopPhotoSaveTrace(long j) {
        setMetric("photo_save", "file_size_bytes", j);
        stopTrace("photo_save");
    }

    public static Trace startPhotoShareTrace() {
        return startTrace("photo_share");
    }

    public static void stopPhotoShareTrace(String str) {
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        addAttribute("photo_share", FirebaseAnalyticsHelper.PARAM_SHARE_METHOD, str);
        stopTrace("photo_share");
    }

    public static Trace startScreenTrace(String str) {
        return startTrace("screen_" + str);
    }

    public static void stopScreenTrace(String str) {
        stopTrace("screen_" + str);
    }

    public static Trace startAppStartupTrace() {
        return startTrace("app_startup");
    }

    public static void stopAppStartupTrace() {
        stopTrace("app_startup");
    }

    public static Trace startImageLoadTrace() {
        return startTrace("image_load");
    }

    public static void stopImageLoadTrace(long j, long j2) {
        setMetric("image_load", "image_width", j);
        setMetric("image_load", "image_height", j2);
        stopTrace("image_load");
    }

    public static Trace startBitmapProcessingTrace() {
        return startTrace("bitmap_processing");
    }

    public static void stopBitmapProcessingTrace(long j) {
        setMetric("bitmap_processing", "bitmap_size_bytes", j);
        stopTrace("bitmap_processing");
    }

    public static HttpMetric startHttpMetric(String str, String str2) {
        if (firebasePerformance == null) {
            firebasePerformance = FirebasePerformance.getInstance();
        }
        return firebasePerformance.newHttpMetric(str, str2);
    }

    public static void setCollectionEnabled(boolean z) {
        if (firebasePerformance == null) {
            firebasePerformance = FirebasePerformance.getInstance();
        }
        firebasePerformance.setPerformanceCollectionEnabled(z);
    }

    public static boolean isCollectionEnabled() {
        if (firebasePerformance == null) {
            firebasePerformance = FirebasePerformance.getInstance();
        }
        return firebasePerformance.isPerformanceCollectionEnabled();
    }
}
