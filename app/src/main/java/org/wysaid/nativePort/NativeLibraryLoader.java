package org.wysaid.nativePort;

/* JADX INFO: loaded from: classes2.dex */
public class NativeLibraryLoader {
    public static void load() {
        System.loadLibrary("ffmpeg");
        System.loadLibrary("CGE");
        System.loadLibrary("CGEExt");
        CGEFFmpegNativeLibrary.avRegisterAll();
    }
}
