package com.photolab.vintage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.photolab.vintage.util.AdManager;
import com.photolab.vintage.util.CrashlyticsHelper;
import com.photolab.vintage.util.FirebaseRealtimeHelper;
import com.photolab.vintage.util.PerformanceHelper;
import com.photolab.vintage.util.SharePreferenceUtil;

/* JADX INFO: loaded from: classes2.dex */
public class App extends Application implements Application.ActivityLifecycleCallbacks {
    private static FirebaseAnalytics firebaseAnalytics;
    private int activityReferences = 0;
    private boolean isActivityChangingConfigurations = false;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
        PerformanceHelper.startAppStartupTrace();
        AdManager.getInstance().initialize(this);
        CrashlyticsHelper.initialize(this);
        PerformanceHelper.initialize(this);
        FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(this);
        firebaseAnalytics = firebaseAnalytics2;
        firebaseAnalytics2.setAnalyticsCollectionEnabled(true);
        FirebaseRealtimeHelper.initialize();
        FirebaseMessaging.getInstance().subscribeToTopic("all").addOnCompleteListener(new OnCompleteListener() { // from class: com.photolab.vintage.App$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                App.lambda$onCreate$0(task);
            }
        });
        FirebaseRealtimeHelper.saveUserDeviceInfo(this);
        CrashlyticsHelper.log("App started successfully");
        PerformanceHelper.stopAppStartupTrace();
    }

    static /* synthetic */ void lambda$onCreate$0(Task task) {
        String str;
        if (task.isSuccessful()) {
            str = "Subscribed to all topic";
        } else {
            str = "Subscribe failed";
        }
        CrashlyticsHelper.log(str);
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        CrashlyticsHelper.log("App terminated");
    }

    public static FirebaseAnalytics getFirebaseAnalytics() {
        return firebaseAnalytics;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i = this.activityReferences + 1;
        this.activityReferences = i;
        if (i != 1 || this.isActivityChangingConfigurations || SharePreferenceUtil.isFirstRun(this)) {
            return;
        }
        AdManager.getInstance().showAppOpenAd(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.isActivityChangingConfigurations = activity.isChangingConfigurations();
        this.activityReferences--;
    }
}
