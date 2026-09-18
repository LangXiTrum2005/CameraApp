package org.wysaid.algorithm;

/* JADX INFO: loaded from: classes2.dex */
public class Matrix3x3 {
    public float[] data;

    Matrix3x3() {
        this.data = new float[9];
    }

    Matrix3x3(float[] fArr) {
        this.data = fArr;
    }

    public static Matrix3x3 makeIdentity() {
        return new Matrix3x3(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
    }

    public static Matrix3x3 makeRotation(float f, float f2, float f3, float f4) {
        float normalizeScaling = AlgorithmUtil.getNormalizeScaling(f2, f3, f4);
        float f5 = f2 * normalizeScaling;
        float f6 = f3 * normalizeScaling;
        float f7 = f4 * normalizeScaling;
        double d = f;
        float fCos = (float) Math.cos(d);
        float f8 = 1.0f - fCos;
        float fSin = (float) Math.sin(d);
        float f9 = f8 * f5;
        float f10 = f9 * f6;
        float f11 = f7 * fSin;
        float f12 = f9 * f7;
        float f13 = f6 * fSin;
        float f14 = f10 - f11;
        float f15 = f8 * f6;
        float f16 = (f6 * f15) + fCos;
        float f17 = f15 * f7;
        float f18 = f5 * fSin;
        return new Matrix3x3(new float[]{(f9 * f5) + fCos, f10 + f11, f12 - f13, f14, f16, f17 + f18, f12 + f13, f17 - f18, fCos + (f8 * f7 * f7)});
    }

    public static Matrix3x3 makeXRotation(float f) {
        double d = f;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        return new Matrix3x3(new float[]{1.0f, 0.0f, 0.0f, 0.0f, fCos, fSin, 0.0f, -fSin, fCos});
    }

    public static Matrix3x3 makeYRotation(float f) {
        double d = f;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        return new Matrix3x3(new float[]{fCos, 0.0f, -fSin, 0.0f, 1.0f, 0.0f, fSin, 0.0f, fCos});
    }

    public static Matrix3x3 makeZRotation(float f) {
        double d = f;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        return new Matrix3x3(new float[]{fCos, fSin, 0.0f, -fSin, fCos, 0.0f, 0.0f, 0.0f, 1.0f});
    }

    protected static float[] _mul(float[] fArr, float[] fArr2) {
        float f = fArr[0];
        float f2 = fArr2[0];
        float f3 = fArr[3];
        float f4 = fArr2[1];
        float f5 = fArr[6];
        float f6 = fArr2[2];
        float f7 = (f * f2) + (f3 * f4) + (f5 * f6);
        float f8 = fArr[1];
        float f9 = fArr[4];
        float f10 = fArr[7];
        float f11 = (f8 * f2) + (f9 * f4) + (f10 * f6);
        float f12 = fArr[2];
        float f13 = fArr[5];
        float f14 = fArr[8];
        float f15 = (f2 * f12) + (f4 * f13) + (f6 * f14);
        float f16 = fArr2[3];
        float f17 = fArr2[4];
        float f18 = fArr2[5];
        float f19 = (f * f16) + (f3 * f17) + (f5 * f18);
        float f20 = (f8 * f16) + (f9 * f17) + (f10 * f18);
        float f21 = (f16 * f12) + (f17 * f13) + (f18 * f14);
        float f22 = fArr2[6];
        float f23 = fArr2[7];
        float f24 = (f * f22) + (f3 * f23);
        float f25 = fArr2[8];
        return new float[]{f7, f11, f15, f19, f20, f21, f24 + (f5 * f25), (f8 * f22) + (f9 * f23) + (f10 * f25), (f12 * f22) + (f13 * f23) + (f14 * f25)};
    }

    public Matrix3x3 multiply(Matrix3x3 matrix3x3) {
        return new Matrix3x3(_mul(this.data, matrix3x3.data));
    }

    public Matrix3x3 multiplyBy(Matrix3x3 matrix3x3) {
        this.data = _mul(this.data, matrix3x3.data);
        return this;
    }

    public Matrix3x3 clone() {
        return new Matrix3x3((float[]) this.data.clone());
    }
}
