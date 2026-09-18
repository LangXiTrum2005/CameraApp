package com.photolab.vintage.util

import android.app.Activity
import android.content.Context
import android.util.Log

class BillingManager(private val context: Context) {

    fun initialize() {
        Log.i(TAG, "BillingManager initialized")
    }

    fun purchase(activity: Activity, productId: String) {
        Log.i(TAG, "Purchase requested for $productId")
    }

    companion object {
        private const val TAG = "BillingManager"
    }
}
