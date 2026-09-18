package com.photolab.vintage.util.picker

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

class PhotoPicker {
    companion object {
        const val REQUEST_CODE = 233
        const val EXTRA_MAX_COUNT = "MAX_COUNT"
        const val EXTRA_SHOW_CAMERA = "SHOW_CAMERA"
        const val EXTRA_SHOW_GIF = "SHOW_GIF"
        const val EXTRA_GRID_COLUMN = "column"
        const val EXTRA_ORIGINAL_PHOTOS = "ORIGINAL_PHOTOS"
        const val EXTRA_PREVIEW_ENABLED = "PREVIEW_ENABLED"
        const val MAIN_ACTIVITY = "MAIN_ACTIVITY"
        const val KEY_SELECTED_PHOTOS = "SELECTED_PHOTOS"

        fun builder(): PhotoPickerBuilder = PhotoPickerBuilder()
    }

    class PhotoPickerBuilder {
        private val pickerIntent = Intent()
        private val pickerOptionsBundle = Bundle()

        fun setPhotoCount(count: Int): PhotoPickerBuilder {
            pickerOptionsBundle.putInt(EXTRA_MAX_COUNT, count)
            return this
        }

        fun setGridColumnCount(count: Int): PhotoPickerBuilder {
            pickerOptionsBundle.putInt(EXTRA_GRID_COLUMN, count)
            return this
        }

        fun setShowGif(showGif: Boolean): PhotoPickerBuilder {
            pickerOptionsBundle.putBoolean(EXTRA_SHOW_GIF, showGif)
            return this
        }

        fun setShowCamera(showCamera: Boolean): PhotoPickerBuilder {
            pickerOptionsBundle.putBoolean(EXTRA_SHOW_CAMERA, showCamera)
            return this
        }

        fun setForwardMain(forwardMain: Boolean): PhotoPickerBuilder {
            pickerOptionsBundle.putBoolean(MAIN_ACTIVITY, forwardMain)
            return this
        }

        fun start(activity: Activity, requestCode: Int = REQUEST_CODE) {
            val intent = getIntent(activity)
            activity.startActivityForResult(intent, requestCode)
        }

        fun getIntent(context: Context): Intent {
            pickerIntent.setClass(context, PhotoPickerActivity::class.java)
            pickerIntent.putExtras(pickerOptionsBundle)
            return pickerIntent
        }
    }
}
