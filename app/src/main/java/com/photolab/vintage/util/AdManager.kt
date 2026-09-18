package com.photolab.vintage.util

import android.app.Activity
import android.content.Context
import android.util.Log

class AdManager private constructor() {

    var isShowingAd = false
    private var isInitialized = false

    fun initialize(context: Context) {
        if (isInitialized) return
        isInitialized = true
        Log.i(TAG, "AdManager initialized")
    }

    fun showAppOpenAd(activity: Activity) {
        Log.i(TAG, "showAppOpenAd requested")
    }

    fun loadInterstitialAd(context: Context) {
        Log.i(TAG, "loadInterstitialAd requested")
    }

    fun showInterstitialAd(activity: Activity, onAdClosed: (() -> Unit)? = null) {
        Log.i(TAG, "showInterstitialAd requested")
        onAdClosed?.invoke()
    }

    companion object {
        private const val TAG = "AdManager"

        @Volatile
        private var instance: AdManager? = null

        fun getInstance(): AdManager {
            return instance ?: synchronized(this) {
                instance ?: AdManager().also { instance = it }
            }
        }
    }
}
