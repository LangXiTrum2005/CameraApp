package com.photolab.vintage.util

import android.content.Context
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

object FileUtil {
    const val LOG_TAG = "libCGE_java"
    val externalStorageDirectory: File = Environment.getExternalStorageDirectory()
    private var mDefaultFolder = "VintageCamera"
    var packageFilesDirectory: String? = null
    var storagePath: String? = null

    fun setDefaultFolder(folder: String) {
        mDefaultFolder = folder
        storagePath = null
    }

    fun getPath(context: Context? = null): String? {
        if (storagePath == null) {
            val picturesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            val file = File(picturesDir, mDefaultFolder)
            if (file.exists() || file.mkdirs()) {
                storagePath = file.absolutePath
            } else {
                val legacyFile = File(externalStorageDirectory, mDefaultFolder)
                if (legacyFile.exists() || legacyFile.mkdirs()) {
                    storagePath = legacyFile.absolutePath
                } else {
                    storagePath = getPathInPackage(context, true)
                }
            }
        }
        return storagePath
    }

    fun getPathInPackage(context: Context?, setPermission: Boolean): String? {
        if (context == null || packageFilesDirectory != null) {
            return packageFilesDirectory
        }
        val str = context.filesDir.toString() + "/" + mDefaultFolder
        val file = File(str)
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.e(LOG_TAG, "Create package dir of CGE failed!")
                return null
            }
            if (setPermission) {
                file.setExecutable(true, false)
                file.setReadable(true, false)
                file.setWritable(true, false)
            }
        }
        packageFilesDirectory = str
        return str
    }

    fun saveTextContent(content: String, path: String) {
        Log.i(LOG_TAG, "Saving text : $path")
        try {
            FileOutputStream(path).use { fileOutputStream ->
                fileOutputStream.write(content.toByteArray())
                fileOutputStream.flush()
            }
        } catch (e: Exception) {
            Log.e(LOG_TAG, "Error: ${e.message}")
        }
    }

    fun getTextContent(path: String?): String? {
        if (path == null) return null
        Log.i(LOG_TAG, "Reading text : $path")
        val buffer = ByteArray(256)
        try {
            FileInputStream(path).use { fileInputStream ->
                var result = ""
                while (true) {
                    val read = fileInputStream.read(buffer)
                    if (read <= 0) break
                    result += String(buffer, 0, read)
                }
                return result
            }
        } catch (e: Exception) {
            Log.e(LOG_TAG, "Error: ${e.message}")
            return null
        }
    }
}
