package com.photolab.vintage.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.photolab.vintage.R
import com.photolab.vintage.util.AdManager

class PermissionActivity : AppCompatActivity() {

    companion object {
        private const val PERMISSION_REQUEST_CODE = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = 1280
        setContentView(R.layout.activity_permission)
        AdManager.getInstance().loadInterstitialAd(this)

        findViewById<AppCompatButton>(R.id.btnGrant).setOnClickListener {
            requestAppPermissions()
        }

        if (hasAllPermissions()) {
            startCameraActivity()
        }
    }

    private fun hasAllPermissions(): Boolean {
        val cameraPerm = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == 0
        val notifPerm = if (Build.VERSION.SDK_INT >= 33) {
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) == 0
        } else true
        return cameraPerm && notifPerm
    }

    private fun requestAppPermissions() {
        val list = ArrayList<String>()
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != 0) {
            list.add(android.Manifest.permission.CAMERA)
        }
        if (Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != 0) {
            list.add(android.Manifest.permission.POST_NOTIFICATIONS)
        }

        if (list.isEmpty()) {
            startCameraActivity()
        } else {
            ActivityCompat.requestPermissions(this, list.toTypedArray(), PERMISSION_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            val cameraGranted = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == 0
            if (cameraGranted) {
                AdManager.getInstance().showInterstitialAd(this) {
                    startCameraActivity()
                }
            } else {
                Toast.makeText(this, "Camera permission is required to take photos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startCameraActivity() {
        startActivity(Intent(this, CameraActivity::class.java))
        finish()
    }
}
