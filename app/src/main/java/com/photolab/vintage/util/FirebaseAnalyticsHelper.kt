package com.photolab.vintage.util

import android.content.Context
import android.util.Log

object FirebaseAnalyticsHelper {
    private const val TAG = "FirebaseAnalyticsHelper"

    fun logEvent(context: Context, eventName: String, params: Map<String, String>? = null) {
        Log.i(TAG, "Event logged: $eventName params: $params")
    }
}
