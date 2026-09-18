package com.photolab.vintage.util

import android.content.Context
import android.util.Log

object CrashlyticsHelper {
    private const val TAG = "CrashlyticsHelper"

    fun initialize(context: Context) {
        Log.i(TAG, "CrashlyticsHelper initialized")
    }

    fun log(message: String) {
        Log.i(TAG, message)
    }

    fun logException(throwable: Throwable) {
        Log.e(TAG, "Exception logged", throwable)
    }
}
