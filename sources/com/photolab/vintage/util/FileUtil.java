package com.photolab.vintage.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtil {
    public static final String LOG_TAG = "libCGE_java";
    public static final File externalStorageDirectory = Environment.getExternalStorageDirectory();
    private static String mDefaultFolder = "libCGE";
    public static String packageFilesDirectory = null;
    public static String storagePath = null;

    public static void setDefaultFolder(String str) {
        mDefaultFolder = str;
    }

    public static String getPath() {
        return getPath(null);
    }

    public static String getPath(Context context) {
        if (storagePath == null) {
            storagePath = externalStorageDirectory.getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + mDefaultFolder;
            File file = new File(storagePath);
            if (!file.exists() && !file.mkdirs()) {
                storagePath = getPathInPackage(context, true);
            }
        }
        return storagePath;
    }

    public static String getPathInPackage(Context context, boolean z) {
        if (context == null || packageFilesDirectory != null) {
            return packageFilesDirectory;
        }
        String str = context.getFilesDir() + RemoteSettings.FORWARD_SLASH_STRING + mDefaultFolder;
        File file = new File(str);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.e("libCGE_java", "Create package dir of CGE failed!");
                return null;
            }
            if (z) {
                if (file.setExecutable(true, false)) {
                    Log.i("libCGE_java", "Package folder is executable");
                }
                if (file.setReadable(true, false)) {
                    Log.i("libCGE_java", "Package folder is readable");
                }
                if (file.setWritable(true, false)) {
                    Log.i("libCGE_java", "Package folder is writable");
                }
            }
        }
        packageFilesDirectory = str;
        return str;
    }

    public static void saveTextContent(String str, String str2) {
        Log.i("libCGE_java", "Saving text : " + str2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            Log.e("libCGE_java", "Error: " + e.getMessage());
        }
    }

    public static String getTextContent(String str) {
        Log.i("libCGE_java", "Reading text : " + str);
        if (str == null) {
            return null;
        }
        byte[] bArr = new byte[256];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            String str2 = "";
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    return str2;
                }
                str2 = str2 + new String(bArr, 0, i);
            }
        } catch (Exception e) {
            Log.e("libCGE_java", "Error: " + e.getMessage());
            return null;
        }
    }
}
