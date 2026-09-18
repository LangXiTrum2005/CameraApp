package com.photolab.vintage.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import java.io.File

object SystemUtil {
    fun dpToPx(context: Context, dp: Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }

    fun clearCacheFile(context: Context) {
        try {
            val externalCacheDir = context.externalCacheDir
            if (externalCacheDir != null && externalCacheDir.isDirectory) {
                val files = externalCacheDir.listFiles()
                files?.forEach { it.delete() }
            }
        } catch (unused: Exception) {
        }
    }

    fun rotateBitmap(bitmap: Bitmap, orientation: Int): Bitmap? {
        val matrix = Matrix()
        when (orientation) {
            2 -> matrix.setScale(-1.0f, 1.0f)
            3 -> matrix.setRotate(180.0f)
            4 -> {
                matrix.setRotate(180.0f)
                matrix.postScale(-1.0f, 1.0f)
            }
            5 -> {
                matrix.setRotate(90.0f)
                matrix.postScale(-1.0f, 1.0f)
            }
            6 -> matrix.setRotate(90.0f)
            7 -> {
                matrix.setRotate(-90.0f)
                matrix.postScale(-1.0f, 1.0f)
            }
            8 -> matrix.setRotate(-90.0f)
            else -> return bitmap
        }
        return try {
            val rotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, false)
            bitmap.recycle()
            rotated
        } catch (e: OutOfMemoryError) {
            e.printStackTrace()
            null
        }
    }
}
