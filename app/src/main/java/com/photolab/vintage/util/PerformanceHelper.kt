package com.photolab.vintage.util

import android.content.Context
import android.util.Log

object PerformanceHelper {
    private const val TAG = "PerformanceHelper"

    fun initialize(context: Context) {
        Log.i(TAG, "PerformanceHelper initialized")
    }

    fun startAppStartupTrace() {
        Log.i(TAG, "startAppStartupTrace")
    }

    fun stopAppStartupTrace() {
        Log.i(TAG, "stopAppStartupTrace")
    }
}
