package com.photolab.vintage.util.picker

import android.app.Activity
import android.content.Context
import android.content.Intent

class PhotoPreview {
    companion object {
        fun builder(): PhotoPreviewBuilder = PhotoPreviewBuilder()
    }

    class PhotoPreviewBuilder {
        fun start(activity: Activity) {
            val intent = Intent(activity, PhotoPagerActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
