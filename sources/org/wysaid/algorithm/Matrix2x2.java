package org.wysaid.algorithm;

/* JADX INFO: loaded from: classes2.dex */
public class Matrix2x2 {
    public float[] data;

    protected Matrix2x2() {
        this.data = new float[4];
    }

    protected Matrix2x2(float[] fArr) {
        this.data = fArr;
    }

    public static Matrix2x2 makeIdentity() {
        return new Matrix2x2(new float[]{1.0f, 0.0f, 0.0f, 1.0f});
    }

    public static Matrix2x2 makeRotation(float f) {
        double d = f;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        return new Matrix2x2(new float[]{fCos, fSin, -fSin, fCos});
    }

    protected static float[] _mul(float[] fArr, float[] fArr2) {
        float f = fArr[0];
        float f2 = fArr2[0];
        float f3 = fArr[2];
        float f4 = fArr2[1];
        float f5 = (f * f2) + (f3 * f4);
        float f6 = fArr[1];
        float f7 = fArr[3];
        float f8 = (f2 * f6) + (f4 * f7);
        float f9 = fArr2[2];
        float f10 = fArr2[3];
        return new float[]{f5, f8, (f * f9) + (f3 * f10), (f6 * f9) + (f7 * f10)};
    }

    public Matrix2x2 multiply(Matrix2x2 matrix2x2) {
        return new Matrix2x2(_mul(this.data, matrix2x2.data));
    }

    public Matrix2x2 multiplyBy(Matrix2x2 matrix2x2) {
        this.data = _mul(this.data, matrix2x2.data);
        return this;
    }

    public Matrix2x2 clone() {
        return new Matrix2x2((float[]) this.data.clone());
    }
}
