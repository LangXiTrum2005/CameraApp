package org.wysaid.nativePort;

import android.graphics.Bitmap;
import android.graphics.PointF;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class CGEFaceTracker {
    protected static boolean sIsTrackerSetup;
    protected FaceResult mFaceResult = new FaceResult();
    protected long mNativeAddress = nativeCreateFaceTracker();

    public static class FaceResult {
        public FloatBuffer faceKeyPoints = ByteBuffer.allocateDirect(528).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static class FaceResultSimple {
        public PointF jawPos;
        public PointF leftEyePos;
        public PointF mouthPos;
        public PointF nosePos;
        public PointF rightEyepos;
    }

    private static native void nativeSetupTracker(String str, String str2, String str3);

    protected native long nativeCreateFaceTracker();

    protected native boolean nativeDetectFaceWithBuffer(long j, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, FloatBuffer floatBuffer);

    protected native float[] nativeDetectFaceWithSimpleResult(long j, Bitmap bitmap, boolean z);

    protected native void nativeRelease(long j);

    static {
        System.loadLibrary("FaceTracker");
        sIsTrackerSetup = false;
    }

    public static boolean isTrackerSetup() {
        return sIsTrackerSetup;
    }

    private CGEFaceTracker() {
    }

    public static CGEFaceTracker createFaceTracker() {
        if (!sIsTrackerSetup) {
            nativeSetupTracker(null, null, null);
            sIsTrackerSetup = true;
        }
        return new CGEFaceTracker();
    }

    public void release() {
        long j = this.mNativeAddress;
        if (j != 0) {
            nativeRelease(j);
            this.mNativeAddress = 0L;
        }
    }

    protected void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public FaceResultSimple detectFaceWithSimpleResult(Bitmap bitmap, boolean z) {
        float[] fArrNativeDetectFaceWithSimpleResult = nativeDetectFaceWithSimpleResult(this.mNativeAddress, bitmap, z);
        if (fArrNativeDetectFaceWithSimpleResult == null) {
            return null;
        }
        FaceResultSimple faceResultSimple = new FaceResultSimple();
        faceResultSimple.leftEyePos = new PointF(fArrNativeDetectFaceWithSimpleResult[0], fArrNativeDetectFaceWithSimpleResult[1]);
        faceResultSimple.rightEyepos = new PointF(fArrNativeDetectFaceWithSimpleResult[2], fArrNativeDetectFaceWithSimpleResult[3]);
        faceResultSimple.nosePos = new PointF(fArrNativeDetectFaceWithSimpleResult[4], fArrNativeDetectFaceWithSimpleResult[5]);
        faceResultSimple.mouthPos = new PointF(fArrNativeDetectFaceWithSimpleResult[6], fArrNativeDetectFaceWithSimpleResult[7]);
        faceResultSimple.jawPos = new PointF(fArrNativeDetectFaceWithSimpleResult[8], fArrNativeDetectFaceWithSimpleResult[9]);
        return faceResultSimple;
    }

    public FaceResult getFaceResult() {
        return this.mFaceResult;
    }

    public boolean detectFaceWithGrayBuffer(ByteBuffer byteBuffer, int i, int i2, int i3) {
        return nativeDetectFaceWithBuffer(this.mNativeAddress, byteBuffer, i, i2, 1, i3, this.mFaceResult.faceKeyPoints);
    }

    public boolean detectFaceWithBGRABuffer(ByteBuffer byteBuffer, int i, int i2, int i3) {
        return nativeDetectFaceWithBuffer(this.mNativeAddress, byteBuffer, i, i2, 4, i3, this.mFaceResult.faceKeyPoints);
    }

    public boolean detectFaceWithBGRBuffer(ByteBuffer byteBuffer, int i, int i2, int i3) {
        return nativeDetectFaceWithBuffer(this.mNativeAddress, byteBuffer, i, i2, 3, i3, this.mFaceResult.faceKeyPoints);
    }
}
