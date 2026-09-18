package org.wysaid.common;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public class SharedContext {
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final String LOG_TAG = "libCGE_java";
    private static int mBitsA = 8;
    private static int mBitsB = 8;
    private static int mBitsG = 8;
    private static int mBitsR = 8;
    private EGLConfig mConfig;
    private EGLContext mContext;
    private EGLDisplay mDisplay;
    private EGL10 mEgl;
    private GL10 mGl;
    private EGLSurface mSurface;

    public static void setContextColorBits(int i, int i2, int i3, int i4) {
        mBitsR = i;
        mBitsG = i2;
        mBitsB = i3;
        mBitsA = i4;
    }

    public static SharedContext create() {
        return create(EGL10.EGL_NO_CONTEXT, 64, 64, 1, null);
    }

    public static SharedContext create(int i, int i2) {
        return create(EGL10.EGL_NO_CONTEXT, i, i2, 1, null);
    }

    public static SharedContext create(EGLContext eGLContext, int i, int i2) {
        return create(eGLContext, i, i2, 1, null);
    }

    public static SharedContext create(EGLContext eGLContext, int i, int i2, int i3, Object obj) {
        SharedContext sharedContext = new SharedContext();
        if (sharedContext.initEGL(eGLContext, i, i2, i3, obj)) {
            return sharedContext;
        }
        sharedContext.release();
        return null;
    }

    public EGLContext getContext() {
        return this.mContext;
    }

    public EGLDisplay getDisplay() {
        return this.mDisplay;
    }

    public EGLSurface getSurface() {
        return this.mSurface;
    }

    public EGL10 getEGL() {
        return this.mEgl;
    }

    public GL10 getGL() {
        return this.mGl;
    }

    SharedContext() {
    }

    public void release() {
        Log.i("libCGE_java", "#### CGESharedGLContext Destroying context... ####");
        if (this.mDisplay != EGL10.EGL_NO_DISPLAY) {
            this.mEgl.eglMakeCurrent(this.mDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.mEgl.eglDestroyContext(this.mDisplay, this.mContext);
            this.mEgl.eglDestroySurface(this.mDisplay, this.mSurface);
            this.mEgl.eglTerminate(this.mDisplay);
        }
        this.mDisplay = EGL10.EGL_NO_DISPLAY;
        this.mSurface = EGL10.EGL_NO_SURFACE;
        this.mContext = EGL10.EGL_NO_CONTEXT;
    }

    public void makeCurrent() {
        EGL10 egl10 = this.mEgl;
        EGLDisplay eGLDisplay = this.mDisplay;
        EGLSurface eGLSurface = this.mSurface;
        if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mContext)) {
            return;
        }
        Log.e("libCGE_java", "eglMakeCurrent failed:" + this.mEgl.eglGetError());
    }

    public boolean swapBuffers() {
        return this.mEgl.eglSwapBuffers(this.mDisplay, this.mSurface);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x014a  */
    private boolean initEGL(EGLContext eGLContext, int i, int i2, int i3, Object obj) {
        int[] iArr = {12440, 2, 12344};
        int[] iArr2 = {12339, i3, 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344};
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr3 = new int[1];
        int[] iArr4 = new int[2];
        int[] iArr5 = {12375, i, 12374, i2, 12344};
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEgl = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mDisplay = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            Log.e("libCGE_java", String.format("eglGetDisplay() returned error 0x%x", Integer.valueOf(this.mEgl.eglGetError())));
            return false;
        }
        if (!this.mEgl.eglInitialize(this.mDisplay, iArr4)) {
            Log.e("libCGE_java", String.format("eglInitialize() returned error 0x%x", Integer.valueOf(this.mEgl.eglGetError())));
            return false;
        }
        Log.i("libCGE_java", String.format("eglInitialize - major: %d, minor: %d", Integer.valueOf(iArr4[0]), Integer.valueOf(iArr4[1])));
        if (!this.mEgl.eglChooseConfig(this.mDisplay, iArr2, eGLConfigArr, 1, iArr3)) {
            Log.e("libCGE_java", String.format("eglChooseConfig() returned error 0x%x", Integer.valueOf(this.mEgl.eglGetError())));
            return false;
        }
        Log.i("libCGE_java", String.format("Config num: %d, has sharedContext: %s", Integer.valueOf(iArr3[0]), eGLContext == EGL10.EGL_NO_CONTEXT ? "NO" : "YES"));
        EGLConfig eGLConfig = eGLConfigArr[0];
        this.mConfig = eGLConfig;
        EGLContext eGLContextEglCreateContext = this.mEgl.eglCreateContext(this.mDisplay, eGLConfig, eGLContext, iArr);
        this.mContext = eGLContextEglCreateContext;
        if (eGLContextEglCreateContext == EGL10.EGL_NO_CONTEXT) {
            Log.e("libCGE_java", "eglCreateContext Failed!");
            return false;
        }
        if (i3 == 1) {
            this.mSurface = this.mEgl.eglCreatePbufferSurface(this.mDisplay, this.mConfig, iArr5);
        } else if (i3 == 2) {
            this.mSurface = this.mEgl.eglCreatePixmapSurface(this.mDisplay, this.mConfig, obj, iArr5);
        } else if (i3 == 4) {
            this.mSurface = this.mEgl.eglCreateWindowSurface(this.mDisplay, this.mConfig, obj, iArr5);
        } else if (i3 == 12610) {
            this.mSurface = this.mEgl.eglCreatePbufferSurface(this.mDisplay, this.mConfig, iArr5);
        }
        if (this.mSurface == EGL10.EGL_NO_SURFACE) {
            Log.e("libCGE_java", "eglCreatePbufferSurface Failed!");
            return false;
        }
        EGL10 egl11 = this.mEgl;
        EGLDisplay eGLDisplay = this.mDisplay;
        EGLSurface eGLSurface = this.mSurface;
        if (!egl11.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mContext)) {
            Log.e("libCGE_java", "eglMakeCurrent failed:" + this.mEgl.eglGetError());
            return false;
        }
        int[] iArr6 = new int[1];
        this.mEgl.eglQueryContext(this.mDisplay, this.mContext, 12440, iArr6);
        Log.i("libCGE_java", "EGLContext created, client version " + iArr6[0]);
        this.mGl = (GL10) this.mContext.getGL();
        return true;
    }
}
