package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzald implements zzakr {
    private static final byte[] zza = {0, 7, 8, Ascii.SI};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzakw zzg;
    private final zzakv zzh;
    private final zzalc zzi;
    private Bitmap zzj;

    public zzald(List list) {
        zzfp zzfpVar = new zzfp((byte[]) list.get(0));
        int iZzq = zzfpVar.zzq();
        int iZzq2 = zzfpVar.zzq();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzakw(719, 575, 0, 719, 0, 575);
        this.zzh = new zzakv(0, zzg(), zzh(), zzi());
        this.zzi = new zzalc(iZzq, iZzq2);
    }

    private static int zzb(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static zzakv zzc(zzfo zzfoVar, int i) {
        int[] iArr;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i2 = 8;
        int iZzd5 = zzfoVar.zzd(8);
        zzfoVar.zzm(8);
        int[] iArrZzg = zzg();
        int[] iArrZzh = zzh();
        int[] iArrZzi = zzi();
        int i3 = i - 2;
        while (i3 > 0) {
            int iZzd6 = zzfoVar.zzd(i2);
            int iZzd7 = zzfoVar.zzd(i2);
            if ((iZzd7 & 128) != 0) {
                iArr = iArrZzg;
            } else {
                iArr = (iZzd7 & 64) != 0 ? iArrZzh : iArrZzi;
            }
            if ((iZzd7 & 1) != 0) {
                iZzd3 = zzfoVar.zzd(i2);
                iZzd4 = zzfoVar.zzd(i2);
                iZzd = zzfoVar.zzd(i2);
                iZzd2 = zzfoVar.zzd(i2);
                i3 -= 6;
            } else {
                int iZzd8 = zzfoVar.zzd(6) << 2;
                int iZzd9 = zzfoVar.zzd(4) << 4;
                i3 -= 4;
                iZzd = zzfoVar.zzd(4) << 4;
                iZzd2 = zzfoVar.zzd(2) << 6;
                iZzd3 = iZzd8;
                iZzd4 = iZzd9;
            }
            if (iZzd3 == 0) {
                iZzd2 = 255;
            }
            if (iZzd3 == 0) {
                iZzd = 0;
            }
            if (iZzd3 == 0) {
                iZzd4 = 0;
            }
            double d = iZzd3;
            double d2 = iZzd4 - 128;
            double d3 = iZzd - 128;
            iArr[iZzd6] = zzb((byte) (255 - (iZzd2 & 255)), Math.max(0, Math.min((int) (d + (1.402d * d2)), 255)), Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)), Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255)));
            iZzd5 = iZzd5;
            i2 = 8;
        }
        return new zzakv(iZzd5, iArrZzg, iArrZzh, iArrZzi);
    }

    private static zzakx zzd(zzfo zzfoVar) {
        int iZzd = zzfoVar.zzd(16);
        zzfoVar.zzm(4);
        int iZzd2 = zzfoVar.zzd(2);
        boolean zZzo = zzfoVar.zzo();
        zzfoVar.zzm(1);
        byte[] bArr = zzfy.zzf;
        byte[] bArr2 = zzfy.zzf;
        if (iZzd2 == 1) {
            zzfoVar.zzm(zzfoVar.zzd(8) * 16);
        } else if (iZzd2 == 0) {
            int iZzd3 = zzfoVar.zzd(16);
            int iZzd4 = zzfoVar.zzd(16);
            if (iZzd3 > 0) {
                bArr = new byte[iZzd3];
                zzfoVar.zzh(bArr, 0, iZzd3);
            }
            if (iZzd4 > 0) {
                bArr2 = new byte[iZzd4];
                zzfoVar.zzh(bArr2, 0, iZzd4);
            } else {
                bArr2 = bArr;
            }
        }
        return new zzakx(iZzd, zZzo, bArr, bArr2);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0219  */
    /* JADX WARN: Code duplicated, block: B:119:0x0228 A[LOOP:3: B:88:0x0172->B:119:0x0228, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:143:0x0222 A[SYNTHETIC] */
    private static void zze(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        char c;
        char c2;
        int iZzd;
        int i4;
        int iZzd2;
        int iZzd3;
        int i5;
        int i6;
        int iZzd4;
        zzfo zzfoVar = new zzfo(bArr, bArr.length);
        int i7 = i2;
        int i8 = i3;
        byte[] bArrZzf = null;
        byte[] bArrZzf2 = null;
        byte[] bArrZzf3 = null;
        while (zzfoVar.zza() != 0) {
            int i9 = 8;
            int iZzd5 = zzfoVar.zzd(8);
            if (iZzd5 != 240) {
                int i10 = 4;
                int i11 = 1;
                int i12 = 2;
                switch (iZzd5) {
                    case 16:
                        int i13 = 1;
                        if (i == 3) {
                            if (bArrZzf == null) {
                                bArr3 = zzb;
                                bArr2 = bArr3;
                            } else {
                                bArr2 = bArrZzf;
                            }
                        } else if (i != 2) {
                            bArr2 = null;
                        } else if (bArrZzf3 == null) {
                            bArr3 = zza;
                            bArr2 = bArr3;
                        } else {
                            bArr2 = bArrZzf3;
                        }
                        int i14 = i7;
                        int i15 = 0;
                        while (true) {
                            int iZzd6 = zzfoVar.zzd(2);
                            if (iZzd6 != 0) {
                                iZzd = i13;
                            } else {
                                if (zzfoVar.zzo()) {
                                    iZzd = zzfoVar.zzd(3) + 3;
                                    iZzd6 = zzfoVar.zzd(2);
                                } else {
                                    if (zzfoVar.zzo()) {
                                        iZzd = i13;
                                        iZzd6 = 0;
                                    } else {
                                        int iZzd7 = zzfoVar.zzd(2);
                                        if (iZzd7 == 0) {
                                            c = 4;
                                            c2 = '\b';
                                            i15 = i13;
                                            iZzd6 = 0;
                                            iZzd = 0;
                                        } else if (iZzd7 == i13) {
                                            c = 4;
                                            c2 = '\b';
                                            i15 = i15;
                                            iZzd = 2;
                                            iZzd6 = 0;
                                        } else if (iZzd7 == 2) {
                                            c = 4;
                                            c2 = '\b';
                                            iZzd = zzfoVar.zzd(4) + 12;
                                            iZzd6 = zzfoVar.zzd(2);
                                            i15 = i15;
                                        } else if (iZzd7 != 3) {
                                            iZzd6 = 0;
                                            iZzd = 0;
                                        } else {
                                            c2 = '\b';
                                            iZzd = zzfoVar.zzd(8) + 29;
                                            iZzd6 = zzfoVar.zzd(2);
                                            i15 = i15;
                                            c = 4;
                                        }
                                    }
                                    c = 4;
                                    c2 = '\b';
                                }
                                if (iZzd == 0 && paint != null) {
                                    int i16 = i8 + 1;
                                    float f = i8;
                                    if (bArr2 != 0) {
                                        iZzd6 = bArr2[iZzd6];
                                    }
                                    paint.setColor(iArr[iZzd6]);
                                    canvas.drawRect(i14, f, i14 + iZzd, i16, paint);
                                }
                                i14 += iZzd;
                                if (i15 != 0) {
                                    zzfoVar.zze();
                                    i7 = i14;
                                } else {
                                    i15 = i15;
                                    i13 = 1;
                                }
                            }
                            c = 4;
                            c2 = '\b';
                            if (iZzd == 0) {
                            }
                            i14 += iZzd;
                            if (i15 != 0) {
                                zzfoVar.zze();
                                i7 = i14;
                            } else {
                                i15 = i15;
                                i13 = 1;
                            }
                            break;
                        }
                        break;
                    case 17:
                        byte[] bArr4 = i == 3 ? bArrZzf2 == null ? zzc : bArrZzf2 : null;
                        int i17 = i7;
                        boolean z = false;
                        while (true) {
                            int iZzd8 = zzfoVar.zzd(i10);
                            if (iZzd8 != 0) {
                                i4 = 1;
                                z = z;
                            } else if (zzfoVar.zzo()) {
                                if (zzfoVar.zzo()) {
                                    int iZzd9 = zzfoVar.zzd(i12);
                                    if (iZzd9 == 0) {
                                        i4 = 1;
                                    } else if (iZzd9 == 1) {
                                        i4 = i12;
                                    } else if (iZzd9 == i12) {
                                        iZzd2 = zzfoVar.zzd(i10) + 9;
                                        iZzd3 = zzfoVar.zzd(i10);
                                    } else if (iZzd9 != 3) {
                                        z = z;
                                        iZzd8 = 0;
                                        i4 = 0;
                                    } else {
                                        iZzd2 = zzfoVar.zzd(i9) + 25;
                                        iZzd3 = zzfoVar.zzd(i10);
                                    }
                                    iZzd8 = 0;
                                } else {
                                    iZzd2 = zzfoVar.zzd(i12) + i10;
                                    iZzd3 = zzfoVar.zzd(i10);
                                }
                                z = z;
                                i4 = iZzd2;
                                iZzd8 = iZzd3;
                            } else {
                                int iZzd10 = zzfoVar.zzd(3);
                                if (iZzd10 != 0) {
                                    i4 = iZzd10 + 2;
                                    iZzd8 = 0;
                                } else {
                                    z = true;
                                    iZzd8 = 0;
                                    i4 = 0;
                                }
                            }
                            if (i4 == 0 || paint == null) {
                                i5 = i12;
                            } else {
                                int i18 = i8 + 1;
                                float f2 = i8;
                                if (bArr4 != 0) {
                                    iZzd8 = bArr4[iZzd8];
                                }
                                paint.setColor(iArr[iZzd8]);
                                i5 = 2;
                                canvas.drawRect(i17, f2, i17 + i4, i18, paint);
                            }
                            i17 += i4;
                            if (z) {
                                zzfoVar.zze();
                                i7 = i17;
                            } else {
                                i12 = i5;
                                z = z;
                                i10 = 4;
                                i9 = 8;
                            }
                            break;
                        }
                        break;
                    case 18:
                        int i19 = i7;
                        int i20 = 0;
                        while (true) {
                            int iZzd11 = zzfoVar.zzd(8);
                            if (iZzd11 != 0) {
                                i6 = i20;
                                iZzd4 = i11;
                            } else if (zzfoVar.zzo()) {
                                i6 = i20;
                                iZzd4 = zzfoVar.zzd(7);
                                iZzd11 = zzfoVar.zzd(8);
                            } else {
                                int iZzd12 = zzfoVar.zzd(7);
                                if (iZzd12 != 0) {
                                    i6 = i20;
                                    iZzd4 = iZzd12;
                                    iZzd11 = 0;
                                } else {
                                    i6 = i11;
                                    iZzd11 = 0;
                                    iZzd4 = 0;
                                }
                            }
                            if (iZzd4 != 0 && paint != null) {
                                paint.setColor(iArr[iZzd11]);
                                canvas.drawRect(i19, i8, i19 + iZzd4, i8 + 1, paint);
                            }
                            i19 += iZzd4;
                            if (i6 != 0) {
                                i7 = i19;
                            } else {
                                i11 = i11;
                                i20 = i6;
                            }
                            break;
                        }
                        break;
                    default:
                        switch (iZzd5) {
                            case 32:
                                bArrZzf3 = zzf(4, 4, zzfoVar);
                                break;
                            case 33:
                                bArrZzf = zzf(4, 8, zzfoVar);
                                break;
                            case 34:
                                bArrZzf2 = zzf(16, 8, zzfoVar);
                                break;
                        }
                        break;
                }
            } else {
                i8 += 2;
                i7 = i2;
            }
        }
    }

    private static byte[] zzf(int i, int i2, zzfo zzfoVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) zzfoVar.zzd(i2);
        }
        return bArr;
    }

    private static int[] zzg() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] zzh() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            int i2 = i & 4;
            int i3 = i & 2;
            int i4 = i & 1;
            if (i < 8) {
                iArr[i] = zzb(255, 1 != i4 ? 0 : 255, i3 != 0 ? 255 : 0, i2 != 0 ? 255 : 0);
            } else {
                int i5 = WorkQueueKt.MASK;
                int i6 = 1 != i4 ? 0 : 127;
                int i7 = i3 != 0 ? 127 : 0;
                if (i2 == 0) {
                    i5 = 0;
                }
                iArr[i] = zzb(255, i6, i7, i5);
            }
        }
        return iArr;
    }

    private static int[] zzi() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = zzb(63, 1 != (i & 1) ? 0 : 255, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i2 = i & 136;
                if (i2 == 0) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 8) {
                    iArr[i] = zzb(WorkQueueKt.MASK, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 128) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 43) + WorkQueueKt.MASK + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + WorkQueueKt.MASK + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + WorkQueueKt.MASK + ((i & 64) == 0 ? 0 : 85));
                } else if (i2 == 136) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 43) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i, int i2, zzakq zzakqVar, zzep zzepVar) {
        zzakj zzakjVar;
        char c;
        char c2;
        int i3;
        zzala zzalaVar;
        int i4;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i5;
        int iZzd5;
        zzfo zzfoVar = new zzfo(bArr, i + i2);
        zzfoVar.zzk(i);
        while (zzfoVar.zza() >= 48 && zzfoVar.zzd(8) == 15) {
            zzalc zzalcVar = this.zzi;
            int iZzd6 = zzfoVar.zzd(8);
            int iZzd7 = zzfoVar.zzd(16);
            int iZzd8 = zzfoVar.zzd(16);
            int iZzb = zzfoVar.zzb() + iZzd8;
            if (iZzd8 * 8 > zzfoVar.zza()) {
                zzff.zzf("DvbParser", "Data field length exceeds limit");
                zzfoVar.zzm(zzfoVar.zza());
            } else {
                switch (iZzd6) {
                    case 16:
                        if (iZzd7 == zzalcVar.zza) {
                            zzaky zzakyVar = zzalcVar.zzi;
                            int iZzd9 = zzfoVar.zzd(8);
                            int iZzd10 = zzfoVar.zzd(4);
                            int iZzd11 = zzfoVar.zzd(2);
                            zzfoVar.zzm(2);
                            SparseArray sparseArray = new SparseArray();
                            for (int i6 = iZzd8 - 2; i6 > 0; i6 -= 6) {
                                int iZzd12 = zzfoVar.zzd(8);
                                zzfoVar.zzm(8);
                                sparseArray.put(iZzd12, new zzakz(zzfoVar.zzd(16), zzfoVar.zzd(16)));
                            }
                            zzaky zzakyVar2 = new zzaky(iZzd9, iZzd10, iZzd11, sparseArray);
                            if (zzakyVar2.zzb != 0) {
                                zzalcVar.zzi = zzakyVar2;
                                zzalcVar.zzc.clear();
                                zzalcVar.zzd.clear();
                                zzalcVar.zze.clear();
                            } else if (zzakyVar != null) {
                                if (zzakyVar.zza != zzakyVar2.zza) {
                                    zzalcVar.zzi = zzakyVar2;
                                }
                            }
                        }
                        break;
                    case 17:
                        zzaky zzakyVar3 = zzalcVar.zzi;
                        if (iZzd7 == zzalcVar.zza && zzakyVar3 != null) {
                            int iZzd13 = zzfoVar.zzd(8);
                            zzfoVar.zzm(4);
                            boolean zZzo = zzfoVar.zzo();
                            zzfoVar.zzm(3);
                            int iZzd14 = zzfoVar.zzd(16);
                            int iZzd15 = zzfoVar.zzd(16);
                            int iZzd16 = zzfoVar.zzd(3);
                            int iZzd17 = zzfoVar.zzd(3);
                            zzfoVar.zzm(2);
                            int iZzd18 = zzfoVar.zzd(8);
                            int iZzd19 = zzfoVar.zzd(8);
                            int iZzd20 = zzfoVar.zzd(4);
                            int iZzd21 = zzfoVar.zzd(2);
                            zzfoVar.zzm(2);
                            int i7 = iZzd8 - 10;
                            SparseArray sparseArray2 = new SparseArray();
                            while (i7 > 0) {
                                int iZzd22 = zzfoVar.zzd(16);
                                int iZzd23 = zzfoVar.zzd(2);
                                int iZzd24 = zzfoVar.zzd(2);
                                int iZzd25 = zzfoVar.zzd(12);
                                zzfoVar.zzm(4);
                                int iZzd26 = zzfoVar.zzd(12);
                                int i8 = i7 - 6;
                                if (iZzd23 == 1) {
                                    i7 -= 8;
                                    i4 = iZzd23;
                                    iZzd = zzfoVar.zzd(8);
                                    iZzd2 = zzfoVar.zzd(8);
                                } else if (iZzd23 == 2) {
                                    iZzd23 = 2;
                                    i7 -= 8;
                                    i4 = iZzd23;
                                    iZzd = zzfoVar.zzd(8);
                                    iZzd2 = zzfoVar.zzd(8);
                                } else {
                                    i4 = iZzd23;
                                    i7 = i8;
                                    iZzd = 0;
                                    iZzd2 = 0;
                                }
                                sparseArray2.put(iZzd22, new zzalb(i4, iZzd24, iZzd25, iZzd26, iZzd, iZzd2));
                            }
                            zzala zzalaVar2 = new zzala(iZzd13, zZzo, iZzd14, iZzd15, iZzd16, iZzd17, iZzd18, iZzd19, iZzd20, iZzd21, sparseArray2);
                            if (zzakyVar3.zzb == 0 && (zzalaVar = (zzala) zzalcVar.zzc.get(zzalaVar2.zza)) != null) {
                                int i9 = 0;
                                while (true) {
                                    SparseArray sparseArray3 = zzalaVar.zzj;
                                    if (i9 < sparseArray3.size()) {
                                        zzalaVar2.zzj.put(sparseArray3.keyAt(i9), (zzalb) sparseArray3.valueAt(i9));
                                        i9++;
                                    }
                                }
                            }
                            zzalcVar.zzc.put(zzalaVar2.zza, zzalaVar2);
                        }
                        break;
                    case 18:
                        if (iZzd7 == zzalcVar.zza) {
                            zzakv zzakvVarZzc = zzc(zzfoVar, iZzd8);
                            zzalcVar.zzd.put(zzakvVarZzc.zza, zzakvVarZzc);
                        } else if (iZzd7 == zzalcVar.zzb) {
                            zzakv zzakvVarZzc2 = zzc(zzfoVar, iZzd8);
                            zzalcVar.zzf.put(zzakvVarZzc2.zza, zzakvVarZzc2);
                        }
                        break;
                    case 19:
                        if (iZzd7 == zzalcVar.zza) {
                            zzakx zzakxVarZzd = zzd(zzfoVar);
                            zzalcVar.zze.put(zzakxVarZzd.zza, zzakxVarZzd);
                        } else if (iZzd7 == zzalcVar.zzb) {
                            zzakx zzakxVarZzd2 = zzd(zzfoVar);
                            zzalcVar.zzg.put(zzakxVarZzd2.zza, zzakxVarZzd2);
                        }
                        break;
                    case 20:
                        if (iZzd7 == zzalcVar.zza) {
                            zzfoVar.zzm(4);
                            boolean zZzo2 = zzfoVar.zzo();
                            zzfoVar.zzm(3);
                            int iZzd27 = zzfoVar.zzd(16);
                            int iZzd28 = zzfoVar.zzd(16);
                            if (zZzo2) {
                                int iZzd29 = zzfoVar.zzd(16);
                                iZzd3 = zzfoVar.zzd(16);
                                iZzd5 = zzfoVar.zzd(16);
                                iZzd4 = zzfoVar.zzd(16);
                                i5 = iZzd29;
                            } else {
                                iZzd3 = iZzd27;
                                iZzd4 = iZzd28;
                                i5 = 0;
                                iZzd5 = 0;
                            }
                            zzalcVar.zzh = new zzakw(iZzd27, iZzd28, i5, iZzd3, iZzd5, iZzd4);
                        }
                        break;
                }
                zzfoVar.zzn(iZzb - zzfoVar.zzb());
            }
        }
        zzalc zzalcVar2 = this.zzi;
        zzaky zzakyVar4 = zzalcVar2.zzi;
        if (zzakyVar4 == null) {
            zzakjVar = new zzakj(zzgaa.zzl(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzakw zzakwVar = zzalcVar2.zzh;
            if (zzakwVar == null) {
                zzakwVar = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzakwVar.zza + 1 != bitmap.getWidth() || zzakwVar.zzb + 1 != this.zzj.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zzakwVar.zza + 1, zzakwVar.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = bitmapCreateBitmap;
                this.zzf.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray4 = zzakyVar4.zzc;
            int i10 = 0;
            while (i10 < sparseArray4.size()) {
                this.zzf.save();
                zzakz zzakzVar = (zzakz) sparseArray4.valueAt(i10);
                zzala zzalaVar3 = (zzala) this.zzi.zzc.get(sparseArray4.keyAt(i10));
                int i11 = zzakzVar.zza + zzakwVar.zzc;
                int i12 = zzakzVar.zzb + zzakwVar.zze;
                this.zzf.clipRect(i11, i12, Math.min(zzalaVar3.zzc + i11, zzakwVar.zzd), Math.min(zzalaVar3.zzd + i12, zzakwVar.zzf));
                zzakv zzakvVar = (zzakv) this.zzi.zzd.get(zzalaVar3.zzf);
                if (zzakvVar == null) {
                    zzakvVar = (zzakv) this.zzi.zzf.get(zzalaVar3.zzf);
                    if (zzakvVar == null) {
                        zzakvVar = this.zzh;
                    }
                }
                SparseArray sparseArray5 = zzalaVar3.zzj;
                int i13 = 0;
                while (i13 < sparseArray5.size()) {
                    int iKeyAt = sparseArray5.keyAt(i13);
                    zzalb zzalbVar = (zzalb) sparseArray5.valueAt(i13);
                    zzakx zzakxVar = (zzakx) this.zzi.zze.get(iKeyAt);
                    if (zzakxVar == null) {
                        zzakxVar = (zzakx) this.zzi.zzg.get(iKeyAt);
                    }
                    if (zzakxVar != null) {
                        Paint paint = zzakxVar.zzb ? null : this.zzd;
                        int i14 = zzalaVar3.zze;
                        int i15 = zzalbVar.zza + i11;
                        int i16 = zzalbVar.zzb + i12;
                        Canvas canvas = this.zzf;
                        int[] iArr = i14 == 3 ? zzakvVar.zzd : i14 == 2 ? zzakvVar.zzc : zzakvVar.zzb;
                        Paint paint2 = paint;
                        zze(zzakxVar.zzc, iArr, i14, i15, i16, paint2, canvas);
                        zze(zzakxVar.zzd, iArr, i14, i15, i16 + 1, paint2, canvas);
                    }
                    i13++;
                    sparseArray4 = sparseArray4;
                    sparseArray5 = sparseArray5;
                    i10 = i10;
                }
                SparseArray sparseArray6 = sparseArray4;
                int i17 = i10;
                float f = i12;
                float f2 = i11;
                if (zzalaVar3.zzb) {
                    int i18 = zzalaVar3.zze;
                    c = 3;
                    if (i18 == 3) {
                        i3 = zzakvVar.zzd[zzalaVar3.zzg];
                        c2 = 2;
                    } else {
                        c2 = 2;
                        i3 = i18 == 2 ? zzakvVar.zzc[zzalaVar3.zzh] : zzakvVar.zzb[zzalaVar3.zzi];
                    }
                    this.zze.setColor(i3);
                    this.zzf.drawRect(f2, f, zzalaVar3.zzc + i11, zzalaVar3.zzd + i12, this.zze);
                } else {
                    c = 3;
                    c2 = 2;
                }
                zzea zzeaVar = new zzea();
                zzeaVar.zzc(Bitmap.createBitmap(this.zzj, i11, i12, zzalaVar3.zzc, zzalaVar3.zzd));
                zzeaVar.zzh(f2 / zzakwVar.zza);
                zzeaVar.zzi(0);
                zzeaVar.zze(f / zzakwVar.zzb, 0);
                zzeaVar.zzf(0);
                zzeaVar.zzk(zzalaVar3.zzc / zzakwVar.zza);
                zzeaVar.zzd(zzalaVar3.zzd / zzakwVar.zzb);
                arrayList.add(zzeaVar.zzp());
                this.zzf.drawColor(0, PorterDuff.Mode.CLEAR);
                this.zzf.restore();
                i10 = i17 + 1;
                sparseArray4 = sparseArray6;
            }
            zzakjVar = new zzakj(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzepVar.zza(zzakjVar);
    }
}
