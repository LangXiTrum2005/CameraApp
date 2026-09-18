package com.photolab.vintage

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.photolab.vintage.util.AdManager
import com.photolab.vintage.util.CrashlyticsHelper
import com.photolab.vintage.util.FirebaseRealtimeHelper
import com.photolab.vintage.util.LanguageUtil
import com.photolab.vintage.util.PerformanceHelper
import com.photolab.vintage.util.SharePreferenceUtil

class App : Application(), Application.ActivityLifecycleCallbacks {

    private var activityReferences = 0
    private var isActivityChangingConfigurations = false

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
        LanguageUtil.applyLanguage(this, SharePreferenceUtil.getAppLanguage(this))
        PerformanceHelper.startAppStartupTrace()
        AdManager.getInstance().initialize(this)
        CrashlyticsHelper.initialize(this)
        PerformanceHelper.initialize(this)
        FirebaseRealtimeHelper.initialize()
        FirebaseRealtimeHelper.saveUserDeviceInfo(this)
        CrashlyticsHelper.log("App started successfully")
        PerformanceHelper.stopAppStartupTrace()
    }

    override fun onTerminate() {
        super.onTerminate()
        CrashlyticsHelper.log("App terminated")
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
    override fun onActivityStarted(activity: Activity) {
        activityReferences++
        if (activityReferences == 1 && !isActivityChangingConfigurations && !SharePreferenceUtil.isFirstRun(this)) {
            AdManager.getInstance().showAppOpenAd(activity)
        }
    }
    override fun onActivityResumed(activity: Activity) {}
    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStopped(activity: Activity) {
        isActivityChangingConfigurations = activity.isChangingConfigurations
        activityReferences--
    }
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {}
}
