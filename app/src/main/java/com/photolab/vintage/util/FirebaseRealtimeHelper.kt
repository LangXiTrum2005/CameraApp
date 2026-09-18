package com.photolab.vintage.util

import android.content.Context
import android.util.Log

object FirebaseRealtimeHelper {
    private const val TAG = "FirebaseRealtimeHelper"

    fun initialize() {
        Log.i(TAG, "FirebaseRealtimeHelper initialized")
    }

    fun saveUserDeviceInfo(context: Context) {
        Log.i(TAG, "Device info saved")
    }
}
