package com.photolab.vintage.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.photolab.vintage.R
import com.photolab.vintage.util.AdManager
import com.photolab.vintage.util.SharePreferenceUtil
import com.photolab.vintage.util.adapter.IntroAdapter
import com.photolab.vintage.util.bean.IntroItem

class IntroActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var layoutIndicators: LinearLayout
    private lateinit var btnNext: AppCompatButton
    private lateinit var btnSkip: TextView
    private lateinit var introAdapter: IntroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!SharePreferenceUtil.isFirstRun(this)) {
            if (hasAllPermissions()) {
                startCameraActivity()
            } else {
                startPermissionActivity()
            }
            return
        }

        setContentView(R.layout.activity_intro)
        AdManager.getInstance().loadInterstitialAd(this)
        window.decorView.systemUiVisibility = 1280

        viewPager = findViewById(R.id.viewPager)
        layoutIndicators = findViewById(R.id.layoutIndicators)
        btnNext = findViewById(R.id.btnNext)
        btnSkip = findViewById(R.id.btnSkip)

        setupViewPager()
        setupIndicators()
        setCurrentIndicator(0)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
                if (position == introAdapter.itemCount - 1) {
                    btnNext.text = "GET STARTED"
                } else {
                    btnNext.text = "NEXT"
                }
            }
        })

        btnNext.setOnClickListener {
            if (viewPager.currentItem + 1 < introAdapter.itemCount) {
                viewPager.currentItem += 1
            } else {
                completeIntro()
            }
        }

        btnSkip.setOnClickListener {
            completeIntro()
        }
    }

    private fun setupViewPager() {
        val items = listOf(
            IntroItem("Capture Moments", "Turn back time with a classic film camera.", R.drawable.intro_bg_1),
            IntroItem("Authentic Film Look", "Real-time color filters featuring realistic film grain and natural light leaks.", R.drawable.intro_bg_2),
            IntroItem("Share Your Story", "Save high-quality photos and instantly share your story.", R.drawable.intro_bg_3)
        )
        introAdapter = IntroAdapter(items)
        viewPager.adapter = introAdapter
    }

    private fun setupIndicators() {
        val count = introAdapter.itemCount
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { setMargins(8, 0, 8, 0) }

        for (i in 0 until count) {
            val imageView = ImageView(applicationContext).apply {
                setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.default_indicator))
                layoutParams = params
            }
            layoutIndicators.addView(imageView)
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val count = layoutIndicators.childCount
        for (i in 0 until count) {
            val imageView = layoutIndicators.getChildAt(i) as ImageView
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.selected_indicator))
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.default_indicator))
            }
        }
    }

    private fun completeIntro() {
        SharePreferenceUtil.setFirstRun(this, false)
        if (hasAllPermissions()) {
            startCameraActivity()
        } else {
            startPermissionActivity()
        }
    }

    private fun hasAllPermissions(): Boolean {
        val cameraPerm = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == 0
        val notifPerm = if (Build.VERSION.SDK_INT >= 33) {
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) == 0
        } else true
        return cameraPerm && notifPerm
    }

    private fun startPermissionActivity() {
        startActivity(Intent(this, PermissionActivity::class.java))
        finish()
    }

    private fun startCameraActivity() {
        startActivity(Intent(this, CameraActivity::class.java))
        finish()
    }
}
