package com.photolab.vintage.activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.photolab.vintage.R
import com.photolab.vintage.util.BillingManager
import com.photolab.vintage.util.SharePreferenceUtil

class PremiumActivity : Activity() {

    private lateinit var billingManager: BillingManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_premium)

        billingManager = BillingManager(this)
        billingManager.initialize()

        findViewById<ImageView>(R.id.ivClose)?.setOnClickListener {
            finish()
        }

        findViewById<View>(R.id.btnMainAction)?.setOnClickListener {
            SharePreferenceUtil.setIsPurchased(this, true)
            finish()
        }
    }
}
