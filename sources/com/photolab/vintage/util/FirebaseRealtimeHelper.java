package com.photolab.vintage.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.os.EnvironmentCompat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.ServerValues;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FirebaseRealtimeHelper {
    private static final String PATH_APP_STATS = "app_stats";
    private static final String PATH_REMOTE_CONFIG = "remote_config";
    private static final String PATH_USAGE_STATS = "usage_stats";
    private static final String PATH_USERS = "users";
    private static FirebaseDatabase database;
    private static DatabaseReference rootRef;

    public interface ValueListener {
        void onError(DatabaseError databaseError);

        void onValueReceived(Object obj);
    }

    public static void initialize() {
        if (database == null) {
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            database = firebaseDatabase;
            firebaseDatabase.setPersistenceEnabled(true);
            rootRef = database.getReference();
        }
    }

    public static FirebaseDatabase getDatabase() {
        if (database == null) {
            initialize();
        }
        return database;
    }

    public static DatabaseReference getRootReference() {
        if (rootRef == null) {
            initialize();
        }
        return rootRef;
    }

    private static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private static String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static void saveUserDeviceInfo(Context context) {
        String deviceId = getDeviceId(context);
        if (deviceId == null || deviceId.isEmpty()) {
            return;
        }
        DatabaseReference databaseReferenceChild = getRootReference().child(PATH_USERS).child(deviceId);
        HashMap map = new HashMap();
        map.put("device_id", deviceId);
        map.put("app_version", getAppVersion(context));
        map.put("android_version", Build.VERSION.RELEASE);
        map.put("sdk_version", Integer.valueOf(Build.VERSION.SDK_INT));
        map.put("device_model", Build.MODEL);
        map.put("device_manufacturer", Build.MANUFACTURER);
        map.put("first_seen", getCurrentTimestamp());
        map.put("last_seen", getCurrentTimestamp());
        databaseReferenceChild.updateChildren(map);
        databaseReferenceChild.child("last_seen").setValue(getCurrentTimestamp());
    }

    public static void trackUsageEvent(Context context, String str, Map<String, Object> map) {
        String deviceId = getDeviceId(context);
        if (deviceId == null || deviceId.isEmpty()) {
            return;
        }
        DatabaseReference databaseReferencePush = getRootReference().child(PATH_USAGE_STATS).child(deviceId).child(str).push();
        HashMap map2 = new HashMap();
        map2.put(ServerValues.NAME_OP_TIMESTAMP, getCurrentTimestamp());
        map2.put("device_id", deviceId);
        map2.put("app_version", getAppVersion(context));
        if (map != null) {
            map2.putAll(map);
        }
        databaseReferencePush.setValue(map2);
    }

    public static void trackPhotoCaptured(Context context, String str) {
        HashMap map = new HashMap();
        if (str == null) {
            str = "none";
        }
        map.put(FirebaseAnalyticsHelper.PARAM_FILTER_NAME, str);
        trackUsageEvent(context, FirebaseAnalyticsHelper.EVENT_PHOTO_CAPTURED, map);
    }

    public static void trackPhotoEdited(Context context, String str) {
        HashMap map = new HashMap();
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        map.put(FirebaseAnalyticsHelper.PARAM_TOOL_NAME, str);
        trackUsageEvent(context, "photo_edited", map);
    }

    public static void trackPhotoShared(Context context, String str) {
        HashMap map = new HashMap();
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        map.put(FirebaseAnalyticsHelper.PARAM_SHARE_METHOD, str);
        trackUsageEvent(context, FirebaseAnalyticsHelper.EVENT_PHOTO_SHARED, map);
    }

    public static void trackFilterApplied(Context context, String str, String str2) {
        HashMap map = new HashMap();
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        map.put(FirebaseAnalyticsHelper.PARAM_FILTER_NAME, str);
        if (str2 == null) {
            str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        map.put("filter_type", str2);
        trackUsageEvent(context, FirebaseAnalyticsHelper.EVENT_FILTER_APPLIED, map);
    }

    public static void updateAppStats(String str, final long j) {
        getRootReference().child(PATH_APP_STATS).child(str).runTransaction(new Transaction.Handler() { // from class: com.photolab.vintage.util.FirebaseRealtimeHelper.1
            @Override // com.google.firebase.database.Transaction.Handler
            public void onComplete(DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot) {
            }

            @Override // com.google.firebase.database.Transaction.Handler
            public Transaction.Result doTransaction(MutableData mutableData) {
                Long l = (Long) mutableData.getValue(Long.class);
                if (l == null) {
                    mutableData.setValue(Long.valueOf(j));
                } else {
                    mutableData.setValue(Long.valueOf(l.longValue() + j));
                }
                return Transaction.success(mutableData);
            }
        });
    }

    public static void getRemoteConfig(String str, final ValueListener valueListener) {
        getRootReference().child(PATH_REMOTE_CONFIG).child(str).addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.photolab.vintage.util.FirebaseRealtimeHelper.2
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Object value = dataSnapshot.getValue();
                    ValueListener valueListener2 = valueListener;
                    if (valueListener2 != null) {
                        valueListener2.onValueReceived(value);
                        return;
                    }
                    return;
                }
                ValueListener valueListener3 = valueListener;
                if (valueListener3 != null) {
                    valueListener3.onValueReceived(null);
                }
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
                ValueListener valueListener2 = valueListener;
                if (valueListener2 != null) {
                    valueListener2.onError(databaseError);
                }
            }
        });
    }

    public static void setRemoteConfig(String str, Object obj) {
        getRootReference().child(PATH_REMOTE_CONFIG).child(str).setValue(obj);
    }

    private static String getCurrentTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
    }

    private static long getCurrentTimestampMillis() {
        return System.currentTimeMillis();
    }

    public static void saveUserPreferences(Context context, Map<String, Object> map) {
        String deviceId = getDeviceId(context);
        if (deviceId == null || deviceId.isEmpty()) {
            return;
        }
        getRootReference().child(PATH_USERS).child(deviceId).child("preferences").setValue(map);
    }

    public static void getUserPreferences(Context context, final ValueListener valueListener) {
        String deviceId = getDeviceId(context);
        if (deviceId != null && !deviceId.isEmpty()) {
            getRootReference().child(PATH_USERS).child(deviceId).child("preferences").addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.photolab.vintage.util.FirebaseRealtimeHelper.3
                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    ValueListener valueListener2 = valueListener;
                    if (valueListener2 != null) {
                        valueListener2.onValueReceived(dataSnapshot.getValue());
                    }
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                    ValueListener valueListener2 = valueListener;
                    if (valueListener2 != null) {
                        valueListener2.onError(databaseError);
                    }
                }
            });
        } else if (valueListener != null) {
            valueListener.onValueReceived(null);
        }
    }
}
