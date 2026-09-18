package com.photolab.vintage.util

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.media.FaceDetector
import android.media.MediaScannerConnection
import android.net.Uri
import android.util.Log
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object ImageUtil {

    class FaceRects {
        var faces: Array<FaceDetector.Face?>? = null
        var numOfFaces: Int = 0
    }

    fun setDefaultFolder(folder: String) {
        FileUtil.setDefaultFolder(folder)
    }

    fun saveBitmapInCache(context: Context, bitmap: Bitmap): String? {
        return try {
            val file = File(context.externalCacheDir, "${Date().time}.jpg")
            val fileOutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
            fileOutputStream.flush()
            fileOutputStream.close()
            file.path
        } catch (unused: Exception) {
            null
        }
    }

    fun saveBitmap(context: Context, bitmap: Bitmap): String? {
        setDefaultFolder("VintageCamera")
        val path = FileUtil.getPath(context) + "/" + SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(Date()) + ".jpg"
        val savedPath = saveBitmap(bitmap, path)
        if (savedPath != null) {
            try {
                MediaScannerConnection.scanFile(context.applicationContext, arrayOf(savedPath), arrayOf("image/jpeg"), null)
                val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).apply {
                    data = Uri.fromFile(File(savedPath))
                }
                context.sendBroadcast(mediaScanIntent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return savedPath
    }

    fun saveBitmap(bitmap: Bitmap, path: String): String? {
        Log.i("libCGE_java", "saving Bitmap : $path")
        return try {
            val bufferedOutputStream = BufferedOutputStream(FileOutputStream(path))
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream)
            bufferedOutputStream.flush()
            bufferedOutputStream.close()
            Log.i("libCGE_java", "Bitmap $path saved!")
            path
        } catch (e: Exception) {
            Log.e("libCGE_java", "Err when saving bitmap... ${e.message}")
            e.printStackTrace()
            null
        }
    }

    fun findFaceByBitmap(bitmap: Bitmap?, maxFaces: Int = 1): FaceRects? {
        if (bitmap == null) {
            Log.e("libCGE_java", "Invalid Bitmap for Face Detection!")
            return null
        }
        val bitmapCopy = if (bitmap.config != Bitmap.Config.RGB_565) bitmap.copy(Bitmap.Config.RGB_565, false) else bitmap
        val faceRects = FaceRects()
        faceRects.faces = arrayOfNulls(maxFaces)
        return try {
            faceRects.numOfFaces = FaceDetector(bitmapCopy.width, bitmapCopy.height, maxFaces).findFaces(bitmapCopy, faceRects.faces)
            if (bitmapCopy != bitmap) {
                bitmapCopy.recycle()
            }
            faceRects
        } catch (e: Exception) {
            Log.e("libCGE_java", "findFaceByBitmap error: ${e.message}")
            null
        }
    }

    fun getResizedBitmap(bitmap: Bitmap, newWidth: Float, newHeight: Float): Bitmap {
        val bitmapCreateBitmap = Bitmap.createBitmap(newWidth.toInt(), newHeight.toInt(), Bitmap.Config.ARGB_8888)
        val scaleX = newWidth / bitmap.width
        val scaleY = newHeight / bitmap.height
        val matrix = Matrix().apply { postScale(scaleX, scaleY) }
        val canvas = Canvas(bitmapCreateBitmap)
        canvas.setMatrix(matrix)
        val paint = Paint().apply { isFilterBitmap = true }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint)
        return bitmapCreateBitmap
    }
}
