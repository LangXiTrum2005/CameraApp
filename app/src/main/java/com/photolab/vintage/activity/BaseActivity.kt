package com.photolab.vintage.activity

import android.app.ProgressDialog
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

open class BaseActivity : AppCompatActivity() {
    companion object {
        const val READ_WRITE_STORAGE = 52
    }

    private var mProgressDialog: ProgressDialog? = null

    open fun isPermissionGranted(granted: Boolean, permission: String) {}

    fun requestPermission(permission: String): Boolean {
        val isGranted = ContextCompat.checkSelfPermission(this, permission) == 0
        if (!isGranted) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), READ_WRITE_STORAGE)
        }
        return isGranted
    }

    fun makeFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == READ_WRITE_STORAGE && permissions.isNotEmpty() && grantResults.isNotEmpty()) {
            isPermissionGranted(grantResults[0] == 0, permissions[0])
        }
    }

    fun showLoading(message: String) {
        hideLoading()
        mProgressDialog = ProgressDialog(this).apply {
            setMessage(message)
            setProgressStyle(ProgressDialog.STYLE_SPINNER)
            setCancelable(false)
            show()
        }
    }

    fun hideLoading() {
        mProgressDialog?.dismiss()
        mProgressDialog = null
    }
}
