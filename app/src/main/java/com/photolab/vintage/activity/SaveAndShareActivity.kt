package com.photolab.vintage.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.bumptech.glide.Glide
import com.photolab.vintage.R
import com.photolab.vintage.util.AdManager
import com.photolab.vintage.util.FirebaseAnalyticsHelper
import java.io.File

class SaveAndShareActivity : BaseActivity() {

    private var imgFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeFullScreen()
        hideSystemUI()
        setContentView(R.layout.save_and_share_layout)

        AdManager.getInstance().showInterstitialAd(this)

        val pathStr = intent.extras?.getString("path")
        if (pathStr != null) {
            imgFile = File(pathStr)
            val previewView = findViewById<ImageView>(R.id.preview)
            if (previewView != null) {
                Glide.with(applicationContext).load(imgFile).into(previewView)
            }
            val pathTv = findViewById<TextView>(R.id.path)
            if (pathTv != null) {
                pathTv.text = getString(R.string.ui_saved_to, pathStr)
            }
            Toast.makeText(this, R.string.ui_saved_success, Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.back)?.setOnClickListener {
            finish()
        }

        findViewById<View>(R.id.btnHome)?.setOnClickListener {
            goHome()
        }

        findViewById<View>(R.id.btnMore)?.setOnClickListener {
            shareImage()
        }

        findViewById<View>(R.id.btnFace)?.setOnClickListener {
            shareImagePackage("com.facebook.katana", "Facebook")
        }

        findViewById<View>(R.id.btnInta)?.setOnClickListener {
            shareImagePackage("com.instagram.android", "Instagram")
        }

        findViewById<View>(R.id.btnEditAgain)?.setOnClickListener {
            finish()
        }

        findViewById<View>(R.id.btnNewPhoto)?.setOnClickListener {
            goHome()
        }
    }

    private fun goHome() {
        val intent = Intent(this, CameraActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
        finish()
    }

    private fun shareImagePackage(packageNameApp: String, appName: String) {
        val file = imgFile ?: return
        val uri: Uri = FileProvider.getUriForFile(
            applicationContext,
            "$packageName.provider",
            file
        )
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "image/*"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        if (isPackageInstalled(packageNameApp, this)) {
            intent.setPackage(packageNameApp)
            startActivity(Intent.createChooser(intent, getString(R.string.ui_share)))
        } else {
            Toast.makeText(applicationContext, getString(R.string.ui_install_app, appName), Toast.LENGTH_SHORT).show()
        }
    }

    private fun isPackageInstalled(packageNameApp: String, context: Context): Boolean {
        return try {
            context.packageManager.getPackageInfo(packageNameApp, 1)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun shareImage() {
        val file = imgFile ?: return
        FirebaseAnalyticsHelper.logEvent(this, "photo_shared")
        val uri: Uri = FileProvider.getUriForFile(
            applicationContext,
            "$packageName.provider",
            file
        )
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "image/*"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        startActivity(Intent.createChooser(intent, getString(R.string.ui_share)))
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.navigationBars())
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        )
    }

    override fun onResume() {
        super.onResume()
        hideSystemUI()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
