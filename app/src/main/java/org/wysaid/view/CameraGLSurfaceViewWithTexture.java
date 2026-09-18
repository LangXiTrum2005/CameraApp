package org.wysaid.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.wysaid.camera.CameraInstance;
import org.wysaid.common.Common;
import org.wysaid.common.FrameBufferObject;
import org.wysaid.nativePort.CGEFrameRecorder;
import org.wysaid.nativePort.CGENativeLibrary;

/* JADX INFO: loaded from: classes2.dex */
public class CameraGLSurfaceViewWithTexture extends CameraGLSurfaceView implements SurfaceTexture.OnFrameAvailableListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected CGEFrameRecorder mFrameRecorder;
    protected boolean mIsTransformMatrixSet;
    protected SurfaceTexture mSurfaceTexture;
    protected int mTextureID;
    protected float[] mTransformMatrix;

    public CGEFrameRecorder getRecorder() {
        return this.mFrameRecorder;
    }

    public synchronized void setFilterWithConfig(final String str) {
        queueEvent(new Runnable() { // from class: org.wysaid.view.CameraGLSurfaceViewWithTexture.1
            @Override // java.lang.Runnable
            public void run() {
                if (CameraGLSurfaceViewWithTexture.this.mFrameRecorder != null) {
                    CameraGLSurfaceViewWithTexture.this.mFrameRecorder.setFilterWidthConfig(str);
                } else {
                    Log.e("libCGE_java", "setFilterWithConfig after release!!");
                }
            }
        });
    }

    public void setFilterIntensity(final float f) {
        queueEvent(new Runnable() { // from class: org.wysaid.view.CameraGLSurfaceViewWithTexture.2
            @Override // java.lang.Runnable
            public void run() {
                if (CameraGLSurfaceViewWithTexture.this.mFrameRecorder != null) {
                    CameraGLSurfaceViewWithTexture.this.mFrameRecorder.setFilterIntensity(f);
                } else {
                    Log.e("libCGE_java", "setFilterIntensity after release!!");
                }
            }
        });
    }

    @Override // org.wysaid.view.CameraGLSurfaceView
    public void setOnCreateCallback(final CameraGLSurfaceView.OnCreateCallback onCreateCallback) {
        if (this.mFrameRecorder == null || onCreateCallback == null) {
            this.mOnCreateCallback = onCreateCallback;
        } else {
            queueEvent(new Runnable() { // from class: org.wysaid.view.CameraGLSurfaceViewWithTexture.3
                @Override // java.lang.Runnable
                public void run() {
                    onCreateCallback.createOver();
                }
            });
        }
    }

    public CameraGLSurfaceViewWithTexture(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsTransformMatrixSet = false;
        this.mTransformMatrix = new float[16];
    }

    @Override // org.wysaid.view.CameraGLSurfaceView, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        CGEFrameRecorder cGEFrameRecorder = new CGEFrameRecorder();
        this.mFrameRecorder = cGEFrameRecorder;
        this.mIsTransformMatrixSet = false;
        if (!cGEFrameRecorder.init(this.mRecordWidth, this.mRecordHeight, this.mRecordWidth, this.mRecordHeight)) {
            Log.e("libCGE_java", "Frame Recorder init failed!");
        }
        this.mFrameRecorder.setSrcRotation(1.5707964f);
        this.mFrameRecorder.setSrcFlipScale(1.0f, -1.0f);
        this.mFrameRecorder.setRenderFlipScale(1.0f, -1.0f);
        this.mTextureID = Common.genSurfaceTextureID();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        super.onSurfaceCreated(gl10, eGLConfig);
    }

    @Override // org.wysaid.view.CameraGLSurfaceView
    protected void onRelease() {
        super.onRelease();
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        int i = this.mTextureID;
        if (i != 0) {
            Common.deleteTextureID(i);
            this.mTextureID = 0;
        }
        CGEFrameRecorder cGEFrameRecorder = this.mFrameRecorder;
        if (cGEFrameRecorder != null) {
            cGEFrameRecorder.release();
            this.mFrameRecorder = null;
        }
    }

    @Override // org.wysaid.view.CameraGLSurfaceView, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        super.onSurfaceChanged(gl10, i, i2);
        if (cameraInstance().isPreviewing()) {
            return;
        }
        resumePreview();
    }

    @Override // org.wysaid.view.CameraGLSurfaceView
    public void resumePreview() {
        if (this.mFrameRecorder == null) {
            Log.e("libCGE_java", "resumePreview after release!!");
            return;
        }
        if (!cameraInstance().isCameraOpened()) {
            cameraInstance().tryOpenCamera(new CameraInstance.CameraOpenCallback() { // from class: org.wysaid.view.CameraGLSurfaceViewWithTexture.4
                @Override // org.wysaid.camera.CameraInstance.CameraOpenCallback
                public void cameraReady() {
                    Log.i("libCGE_java", "tryOpenCamera OK...");
                }
            }, !this.mIsCameraBackForward ? 1 : 0);
        }
        if (!cameraInstance().isPreviewing()) {
            cameraInstance().startPreview(this.mSurfaceTexture);
            this.mFrameRecorder.srcResize(cameraInstance().previewHeight(), cameraInstance().previewWidth());
        }
        requestRender();
    }

    @Override // org.wysaid.view.CameraGLSurfaceView, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.mSurfaceTexture == null || !cameraInstance().isPreviewing()) {
            return;
        }
        this.mSurfaceTexture.updateTexImage();
        this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
        this.mFrameRecorder.update(this.mTextureID, this.mTransformMatrix);
        this.mFrameRecorder.runProc();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.mFrameRecorder.render(this.mDrawViewport.x, this.mDrawViewport.y, this.mDrawViewport.width, this.mDrawViewport.height);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    @Override // org.wysaid.view.CameraGLSurfaceView
    protected void onSwitchCamera() {
        super.onSwitchCamera();
        CGEFrameRecorder cGEFrameRecorder = this.mFrameRecorder;
        if (cGEFrameRecorder != null) {
            cGEFrameRecorder.setSrcRotation(1.5707964f);
            this.mFrameRecorder.setRenderFlipScale(1.0f, -1.0f);
        }
    }

    @Override // org.wysaid.view.CameraGLSurfaceView
    public void takeShot(final CameraGLSurfaceView.TakePictureCallback takePictureCallback) {
        if (this.mFrameRecorder == null) {
            Log.e("libCGE_java", "Recorder not initialized!");
            takePictureCallback.takePictureOK(null);
        } else {
            queueEvent(new Runnable() { // from class: org.wysaid.view.CameraGLSurfaceViewWithTexture.5
                @Override // java.lang.Runnable
                public void run() {
                    FrameBufferObject frameBufferObject = new FrameBufferObject();
                    int iGenBlankTextureID = Common.genBlankTextureID(CameraGLSurfaceViewWithTexture.this.mRecordWidth, CameraGLSurfaceViewWithTexture.this.mRecordHeight);
                    frameBufferObject.bindTexture(iGenBlankTextureID);
                    GLES20.glViewport(0, 0, CameraGLSurfaceViewWithTexture.this.mRecordWidth, CameraGLSurfaceViewWithTexture.this.mRecordHeight);
                    CameraGLSurfaceViewWithTexture.this.mFrameRecorder.drawCache();
                    IntBuffer intBufferAllocate = IntBuffer.allocate(CameraGLSurfaceViewWithTexture.this.mRecordWidth * CameraGLSurfaceViewWithTexture.this.mRecordHeight);
                    GLES20.glReadPixels(0, 0, CameraGLSurfaceViewWithTexture.this.mRecordWidth, CameraGLSurfaceViewWithTexture.this.mRecordHeight, 6408, 5121, intBufferAllocate);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(CameraGLSurfaceViewWithTexture.this.mRecordWidth, CameraGLSurfaceViewWithTexture.this.mRecordHeight, Bitmap.Config.ARGB_8888);
                    bitmapCreateBitmap.copyPixelsFromBuffer(intBufferAllocate);
                    Log.i("libCGE_java", String.format("w: %d, h: %d", Integer.valueOf(CameraGLSurfaceViewWithTexture.this.mRecordWidth), Integer.valueOf(CameraGLSurfaceViewWithTexture.this.mRecordHeight)));
                    frameBufferObject.release();
                    GLES20.glDeleteTextures(1, new int[]{iGenBlankTextureID}, 0);
                    takePictureCallback.takePictureOK(bitmapCreateBitmap);
                }
            });
        }
    }

    @Override // org.wysaid.view.CameraGLSurfaceView
    public void setPictureSize(int i, int i2, boolean z) {
        cameraInstance().setPictureSize(i2, i, z);
    }

    public synchronized void takePicture(final CameraGLSurfaceView.TakePictureCallback takePictureCallback, Camera.ShutterCallback shutterCallback, final String str, final float f, final boolean z) {
        Camera.Parameters params = cameraInstance().getParams();
        if (takePictureCallback == null || params == null) {
            Log.e("libCGE_java", "takePicture after release!");
            if (takePictureCallback != null) {
                takePictureCallback.takePictureOK(null);
            }
            return;
        }
        try {
            params.setRotation(90);
            cameraInstance().setParams(params);
            cameraInstance().getCameraDevice().takePicture(shutterCallback, null, new Camera.PictureCallback() { // from class: org.wysaid.view.CameraGLSurfaceViewWithTexture.6
                /* JADX WARN: Code duplicated, block: B:46:0x01a1  */
                @Override // android.hardware.Camera.PictureCallback
                public void onPictureTaken(byte[] bArr, Camera camera) {
                    int width;
                    int height;
                    boolean z2;
                    Bitmap bitmapCreateScaledBitmap;
                    Bitmap bitmapCreateBitmap = null;
                    String str2;
                    Camera.Size pictureSize = camera.getParameters().getPictureSize();
                    if (pictureSize.width != pictureSize.height) {
                        bitmapCreateScaledBitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        width = bitmapCreateScaledBitmap.getWidth();
                        height = bitmapCreateScaledBitmap.getHeight();
                        z2 = (pictureSize.width > pictureSize.height && width > height) || (pictureSize.width < pictureSize.height && width < height);
                    } else {
                        Log.i("libCGE_java", "Cache image to get exif.");
                        try {
                            String str3 = CameraGLSurfaceViewWithTexture.this.getContext().getExternalCacheDir() + "/picture_cache000.jpg";
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                            bufferedOutputStream.write(bArr);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            boolean z3 = new ExifInterface(str3).getAttributeInt("Orientation", 1) == 6;
                            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str3);
                            width = bitmapDecodeFile.getWidth();
                            height = bitmapDecodeFile.getHeight();
                            z2 = z3;
                            bitmapCreateScaledBitmap = bitmapDecodeFile;
                        } catch (IOException e) {
                            Log.e("libCGE_java", "Err when saving bitmap...");
                            e.printStackTrace();
                            return;
                        }
                    }
                    if (width > CameraGLSurfaceViewWithTexture.this.mMaxTextureSize || height > CameraGLSurfaceViewWithTexture.this.mMaxTextureSize) {
                        float f2 = width;
                        float f3 = height;
                        float fMax = Math.max(f2 / CameraGLSurfaceViewWithTexture.this.mMaxTextureSize, f3 / CameraGLSurfaceViewWithTexture.this.mMaxTextureSize);
                        Log.i("libCGE_java", String.format("目标尺寸(%d x %d)超过当前设备OpenGL 能够处理的最大范围(%d x %d)， 现在将图片压缩至合理大小!", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(CameraGLSurfaceViewWithTexture.this.mMaxTextureSize), Integer.valueOf(CameraGLSurfaceViewWithTexture.this.mMaxTextureSize)));
                        bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, (int) (f2 / fMax), (int) (f3 / fMax), false);
                        width = bitmapCreateScaledBitmap.getWidth();
                        height = bitmapCreateScaledBitmap.getHeight();
                    }
                    if (z2) {
                        bitmapCreateBitmap = Bitmap.createBitmap(height, width, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        if (CameraGLSurfaceViewWithTexture.this.cameraInstance().getFacing() == 0) {
                            Matrix matrix = new Matrix();
                            float fMin = Math.min(width, height) / 2;
                            matrix.setRotate(90.0f, fMin, fMin);
                            canvas.drawBitmap(bitmapCreateScaledBitmap, matrix, null);
                        } else {
                            Matrix matrix2 = new Matrix();
                            if (z) {
                                matrix2.postTranslate((-width) / 2, (-height) / 2);
                                matrix2.postScale(-1.0f, 1.0f);
                                matrix2.postTranslate(width / 2, height / 2);
                                float fMin2 = Math.min(width, height) / 2;
                                matrix2.postRotate(90.0f, fMin2, fMin2);
                            } else {
                                float fMax2 = Math.max(width, height) / 2;
                                matrix2.postRotate(-90.0f, fMax2, fMax2);
                            }
                            canvas.drawBitmap(bitmapCreateScaledBitmap, matrix2, null);
                        }
                        bitmapCreateScaledBitmap.recycle();
                    } else {
                        if (CameraGLSurfaceViewWithTexture.this.cameraInstance().getFacing() != 0) {
                            bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                            Matrix matrix3 = new Matrix();
                            if (z) {
                                matrix3.postTranslate((-width) / 2, (-height) / 2);
                                matrix3.postScale(1.0f, -1.0f);
                                matrix3.postTranslate(width / 2, height / 2);
                            } else {
                                matrix3.postTranslate((-width) / 2, (-height) / 2);
                                matrix3.postScale(-1.0f, -1.0f);
                                matrix3.postTranslate(width / 2, height / 2);
                            }
                            canvas2.drawBitmap(bitmapCreateScaledBitmap, matrix3, null);
                        }
                        str2 = str;
                        if (str2 != null) {
                            CGENativeLibrary.filterImage_MultipleEffectsWriteBack(bitmapCreateScaledBitmap, str2, f);
                        }
                        takePictureCallback.takePictureOK(bitmapCreateScaledBitmap);
                        CameraGLSurfaceViewWithTexture.this.cameraInstance().getCameraDevice().startPreview();
                    }
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateScaledBitmap = bitmapCreateBitmap;
                    }
                    str2 = str;
                    if (str2 != null) {
                        CGENativeLibrary.filterImage_MultipleEffectsWriteBack(bitmapCreateScaledBitmap, str2, f);
                    }
                    takePictureCallback.takePictureOK(bitmapCreateScaledBitmap);
                    CameraGLSurfaceViewWithTexture.this.cameraInstance().getCameraDevice().startPreview();
                }
            });
        } catch (Exception e) {
            Log.e("libCGE_java", "Error when takePicture: " + e.toString());
            if (takePictureCallback != null) {
                takePictureCallback.takePictureOK(null);
            }
        }
    }
}
