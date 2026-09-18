package com.photolab.vintage.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class AdManager {
    private static final String KEY_ADS_ENABLED = "ads_enabled";
    private static final String KEY_APP_OPEN_AD_FREQUENCY_HOURS = "app_open_ad_frequency_hours";
    private static final String KEY_APP_OPEN_ID = "admob_app_open_id";
    private static final String KEY_BANNER_ID = "admob_banner_id";
    private static final String KEY_INTERSTITIAL_ID = "admob_interstitial_id";
    private static final String REAL_INTERSTITIAL_ID = "ca-app-pub-2919969899170036/1630590790";
    private static final String TAG = "AdManager";
    private static final String TEST_APP_OPEN_ID = "ca-app-pub-3940256099942544/9257395921";
    private static final String TEST_BANNER_ID = "ca-app-pub-3940256099942544/6300978111";
    private static final String TEST_INTERSTITIAL_ID = "ca-app-pub-3940256099942544/1033173712";
    private static AdManager instance;
    private AppOpenAd mAppOpenAd;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private InterstitialAd mInterstitialAd;
    private boolean isAdLoading = false;
    private boolean isAppOpenAdLoading = false;
    private boolean isInitialized = false;
    private long loadTime = 0;
    public boolean isShowingAd = false;

    static /* synthetic */ void lambda$initialize$0(InitializationStatus initializationStatus) {
    }

    private AdManager() {
    }

    public void loadAppOpenAd(Context context) {
        if (isAdAvailable() || this.isAppOpenAdLoading || !isAdsEnabled(context)) {
            return;
        }
        this.isAppOpenAdLoading = true;
        AppOpenAd.load(context, getAdUnitId(KEY_APP_OPEN_ID, TEST_APP_OPEN_ID), new AdRequest.Builder().build(), 1, new AppOpenAd.AppOpenAdLoadCallback() { // from class: com.photolab.vintage.util.AdManager.1
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(AppOpenAd appOpenAd) {
                AdManager.this.mAppOpenAd = appOpenAd;
                AdManager.this.isAppOpenAdLoading = false;
                AdManager.this.loadTime = new Date().getTime();
                Log.d(AdManager.TAG, "App Open Ad loaded");
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                AdManager.this.isAppOpenAdLoading = false;
                Log.e(AdManager.TAG, "App Open Ad load failed: " + loadAdError.getMessage());
            }
        });
    }

    private boolean isAdAvailable() {
        FirebaseRemoteConfig firebaseRemoteConfig = this.mFirebaseRemoteConfig;
        long j = 4;
        if (firebaseRemoteConfig != null) {
            long j2 = firebaseRemoteConfig.getLong(KEY_APP_OPEN_AD_FREQUENCY_HOURS);
            if (j2 > 0) {
                j = j2;
            }
        }
        return this.mAppOpenAd != null && wasLoadTimeLessThanNHoursAgo(j);
    }

    private boolean wasLoadTimeLessThanNHoursAgo(long j) {
        return new Date().getTime() - this.loadTime < j * 3600000;
    }

    public void showAppOpenAd(final Activity activity) {
        if (isAdsEnabled(activity) && isAdAvailable() && !this.isShowingAd) {
            this.mAppOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.photolab.vintage.util.AdManager.2
                @Override // com.google.android.gms.ads.FullScreenContentCallback
                public void onAdDismissedFullScreenContent() {
                    AdManager.this.mAppOpenAd = null;
                    AdManager.this.isShowingAd = false;
                    AdManager.this.loadAppOpenAd(activity);
                }

                @Override // com.google.android.gms.ads.FullScreenContentCallback
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    AdManager.this.mAppOpenAd = null;
                    AdManager.this.isShowingAd = false;
                    AdManager.this.loadAppOpenAd(activity);
                }

                @Override // com.google.android.gms.ads.FullScreenContentCallback
                public void onAdShowedFullScreenContent() {
                    AdManager.this.isShowingAd = true;
                    Bundle bundle = new Bundle();
                    bundle.putString(FirebaseAnalytics.Param.AD_UNIT_NAME, "App Open Ad");
                    bundle.putString(FirebaseAnalytics.Param.AD_FORMAT, "APP_OPEN");
                    FirebaseAnalytics.getInstance(activity).logEvent(FirebaseAnalytics.Event.AD_IMPRESSION, bundle);
                }
            });
            this.mAppOpenAd.show(activity);
        }
    }

    public static synchronized AdManager getInstance() {
        if (instance == null) {
            instance = new AdManager();
        }
        return instance;
    }

    public void initialize(final Context context) {
        if (this.isInitialized) {
            return;
        }
        MobileAds.initialize(context, new OnInitializationCompleteListener() { // from class: com.photolab.vintage.util.AdManager$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
            public final void onInitializationComplete(InitializationStatus initializationStatus) {
                AdManager.lambda$initialize$0(initializationStatus);
            }
        });
        this.mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        this.mFirebaseRemoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(3600L).build());
        HashMap map = new HashMap();
        map.put(KEY_ADS_ENABLED, true);
        map.put(KEY_BANNER_ID, TEST_BANNER_ID);
        map.put(KEY_INTERSTITIAL_ID, TEST_INTERSTITIAL_ID);
        map.put(KEY_APP_OPEN_ID, TEST_APP_OPEN_ID);
        map.put(KEY_APP_OPEN_AD_FREQUENCY_HOURS, 4L);
        this.mFirebaseRemoteConfig.setDefaultsAsync(map);
        this.mFirebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(new OnCompleteListener<Boolean>() { // from class: com.photolab.vintage.util.AdManager.3
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<Boolean> task) {
                if (task.isSuccessful()) {
                    Log.d(AdManager.TAG, "Remote config fetched");
                }
                AdManager.this.loadInterstitial(context);
                AdManager.this.loadAppOpenAd(context);
            }
        });
        this.isInitialized = true;
    }

    private String getAdUnitId(String str, String str2, String str3) {
        String string = this.mFirebaseRemoteConfig.getString(str);
        return (string == null || string.isEmpty()) ? str3 : string;
    }

    private String getAdUnitId(String str, String str2) {
        return getAdUnitId(str, str2, str2);
    }

    private boolean isAdsEnabled(Context context) {
        if (SharePreferenceUtil.isPurchased(context)) {
            return false;
        }
        FirebaseRemoteConfig firebaseRemoteConfig = this.mFirebaseRemoteConfig;
        if (firebaseRemoteConfig == null) {
            return true;
        }
        return firebaseRemoteConfig.getBoolean(KEY_ADS_ENABLED);
    }

    public void loadBanner(final Activity activity, final RelativeLayout relativeLayout) {
        if (!isAdsEnabled(activity)) {
            relativeLayout.setVisibility(8);
            return;
        }
        AdView adView = new AdView(activity);
        adView.setAdUnitId(getAdUnitId(KEY_BANNER_ID, TEST_BANNER_ID));
        adView.setAdSize(AdSize.BANNER);
        relativeLayout.removeAllViews();
        relativeLayout.addView(adView);
        adView.loadAd(new AdRequest.Builder().build());
        adView.setAdListener(new AdListener() { // from class: com.photolab.vintage.util.AdManager.4
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                relativeLayout.setVisibility(0);
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.AD_UNIT_NAME, "Banner Ad");
                bundle.putString(FirebaseAnalytics.Param.AD_FORMAT, "BANNER");
                FirebaseAnalytics.getInstance(activity).logEvent(FirebaseAnalytics.Event.AD_IMPRESSION, bundle);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                relativeLayout.setVisibility(8);
                Log.e(AdManager.TAG, "Banner failed: " + loadAdError.getMessage());
            }
        });
    }

    public void loadInterstitial(final Context context) {
        if (isAdsEnabled(context) && this.mInterstitialAd == null && !this.isAdLoading) {
            this.isAdLoading = true;
            InterstitialAd.load(context, getAdUnitId(KEY_INTERSTITIAL_ID, TEST_INTERSTITIAL_ID, REAL_INTERSTITIAL_ID), new AdRequest.Builder().build(), new InterstitialAdLoadCallback() { // from class: com.photolab.vintage.util.AdManager.5
                @Override // com.google.android.gms.ads.AdLoadCallback
                public void onAdLoaded(InterstitialAd interstitialAd) {
                    AdManager.this.mInterstitialAd = interstitialAd;
                    AdManager.this.isAdLoading = false;
                    Log.d(AdManager.TAG, "Interstitial loaded");
                    AdManager.this.mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.photolab.vintage.util.AdManager.5.1
                        @Override // com.google.android.gms.ads.FullScreenContentCallback
                        public void onAdDismissedFullScreenContent() {
                            AdManager.this.mInterstitialAd = null;
                            AdManager.this.loadInterstitial(context);
                        }

                        @Override // com.google.android.gms.ads.FullScreenContentCallback
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            AdManager.this.mInterstitialAd = null;
                        }

                        @Override // com.google.android.gms.ads.FullScreenContentCallback
                        public void onAdShowedFullScreenContent() {
                            Bundle bundle = new Bundle();
                            bundle.putString(FirebaseAnalytics.Param.AD_UNIT_NAME, "Interstitial Ad");
                            bundle.putString(FirebaseAnalytics.Param.AD_FORMAT, "INTERSTITIAL");
                            FirebaseAnalytics.getInstance(context).logEvent(FirebaseAnalytics.Event.AD_IMPRESSION, bundle);
                            AdManager.this.mInterstitialAd = null;
                        }
                    });
                }

                @Override // com.google.android.gms.ads.AdLoadCallback
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    AdManager.this.mInterstitialAd = null;
                    AdManager.this.isAdLoading = false;
                    Log.e(AdManager.TAG, "Interstitial load failed: " + loadAdError.getMessage());
                }
            });
        }
    }

    public void showInterstitial(final Activity activity, final Runnable runnable) {
        InterstitialAd interstitialAd;
        if (isAdsEnabled(activity) && (interstitialAd = this.mInterstitialAd) != null) {
            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.photolab.vintage.util.AdManager.6
                @Override // com.google.android.gms.ads.FullScreenContentCallback
                public void onAdDismissedFullScreenContent() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                    AdManager.this.mInterstitialAd = null;
                    AdManager.this.loadInterstitial(activity);
                }

                @Override // com.google.android.gms.ads.FullScreenContentCallback
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    AdManager.this.mInterstitialAd = null;
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                    AdManager.this.loadInterstitial(activity);
                }

                @Override // com.google.android.gms.ads.FullScreenContentCallback
                public void onAdShowedFullScreenContent() {
                    AdManager.this.mInterstitialAd = null;
                }
            });
            this.mInterstitialAd.show(activity);
            return;
        }
        if (runnable != null) {
            runnable.run();
        }
        if (isAdsEnabled(activity)) {
            loadInterstitial(activity);
        }
    }
}
