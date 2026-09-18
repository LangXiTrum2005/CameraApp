package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaog implements zzacu {

    @Deprecated
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaod
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzaog.zza;
            return new zzacu[]{new zzaog(1, 1, zzakp.zza, new zzfw(0L), new zzamv(0), 112800)};
        }
    };
    private final List zzb;
    private final zzfp zzc;
    private final SparseIntArray zzd;
    private final zzaoj zze;
    private final zzakp zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;
    private final SparseBooleanArray zzi;
    private final zzaoc zzj;
    private zzaob zzk;
    private zzacx zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;

    @Deprecated
    public zzaog() {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:95:0x01b5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v23, types: [android.util.SparseArray] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.util.SparseBooleanArray] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.google.android.gms.internal.ads.zzaol] */
    /* JADX WARN: Type inference failed for: r8v6 */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        ?? r3;
        ?? r8;
        zzaol zzaolVar;
        long j;
        boolean z;
        long jZzd = zzacvVar.zzd();
        if (this.zzn) {
            if (jZzd != -1) {
                zzaoc zzaocVar = this.zzj;
                if (!zzaocVar.zzd()) {
                    return zzaocVar.zza(zzacvVar, zzadrVar, this.zzr);
                }
            }
            if (this.zzo) {
                j = 0;
            } else {
                this.zzo = true;
                zzaoc zzaocVar2 = this.zzj;
                if (zzaocVar2.zzb() != -9223372036854775807L) {
                    j = 0;
                    zzaob zzaobVar = new zzaob(zzaocVar2.zzc(), zzaocVar2.zzb(), jZzd, this.zzr, 112800);
                    this.zzk = zzaobVar;
                    this.zzl.zzO(zzaobVar.zzb());
                } else {
                    j = 0;
                    this.zzl.zzO(new zzadt(zzaocVar2.zzb(), 0L));
                }
            }
            if (this.zzp) {
                z = false;
                this.zzp = false;
                zzd(j, j);
                if (zzacvVar.zzf() != j) {
                    zzadrVar.zza = j;
                    return 1;
                }
            } else {
                z = false;
            }
            zzaob zzaobVar2 = this.zzk;
            r3 = z;
            if (zzaobVar2 != null && zzaobVar2.zze()) {
                r3 = z;
                return zzaobVar2.zza(zzacvVar, zzadrVar);
            }
        } else {
            r3 = 0;
        }
        r3 = z;
        zzfp zzfpVar = this.zzc;
        byte[] bArrZzM = zzfpVar.zzM();
        if (9400 - zzfpVar.zzd() < 188) {
            int iZzb = zzfpVar.zzb();
            if (iZzb > 0) {
                System.arraycopy(bArrZzM, zzfpVar.zzd(), bArrZzM, r3, iZzb);
            }
            this.zzc.zzI(bArrZzM, iZzb);
        }
        while (true) {
            zzfp zzfpVar2 = this.zzc;
            if (zzfpVar2.zzb() >= 188) {
                int iZzd = zzfpVar2.zzd();
                int iZze = zzfpVar2.zze();
                int iZza = zzaom.zza(zzfpVar2.zzM(), iZzd, iZze);
                this.zzc.zzK(iZza);
                int i = iZza + 188;
                if (i > iZze) {
                    this.zzq += iZza - iZzd;
                } else {
                    this.zzq = r3;
                }
                zzfp zzfpVar3 = this.zzc;
                int iZze2 = zzfpVar3.zze();
                if (i > iZze2) {
                    return r3;
                }
                int iZzg = zzfpVar3.zzg();
                if ((8388608 & iZzg) != 0) {
                    this.zzc.zzK(i);
                    return r3;
                }
                ?? r10 = (4194304 & iZzg) != 0 ? 1 : r3;
                int i2 = iZzg & 32;
                int i3 = (iZzg >> 8) & 8191;
                if ((iZzg & 16) != 0) {
                    zzaolVar = (zzaol) this.zzg.get(i3);
                } else {
                    r8 = 0;
                }
                if (r8 == 0) {
                    r8 = zzaolVar;
                    this.zzc.zzK(i);
                    return r3;
                }
                int i4 = iZzg & 15;
                int i5 = this.zzd.get(i3, i4 - 1);
                this.zzd.put(i3, i4);
                if (i5 == i4) {
                    r8 = zzaolVar;
                    this.zzc.zzK(i);
                    return r3;
                }
                if (i4 != ((i5 + 1) & 15)) {
                    r8 = zzaolVar;
                    r8.zzc();
                }
                if (i2 != 0) {
                    zzfp zzfpVar4 = this.zzc;
                    int iZzm = zzfpVar4.zzm();
                    r10 = (r10 == true ? 1 : 0) | ((zzfpVar4.zzm() & 64) != 0 ? 2 : r3);
                    this.zzc.zzL(iZzm - 1);
                }
                boolean z2 = this.zzn;
                if (z2 || !this.zzi.get(i3, r3)) {
                    this.zzc.zzJ(i);
                    r8.zza(this.zzc, r10);
                    this.zzc.zzJ(iZze2);
                    if (!z2) {
                        if (this.zzn && jZzd != -1) {
                            this.zzp = true;
                        }
                    }
                } else if (this.zzn) {
                    this.zzp = true;
                }
                this.zzc.zzK(i);
                return r3;
            }
            int iZze3 = zzfpVar2.zze();
            int iZza2 = zzacvVar.zza(bArrZzM, iZze3, 9400 - iZze3);
            if (iZza2 == -1) {
                for (?? r11 = r3; r11 < this.zzg.size(); r11++) {
                    zzaol zzaolVar2 = (zzaol) this.zzg.valueAt(r11);
                    if (zzaolVar2 instanceof zzanp) {
                        zzaolVar2.zza(new zzfp(), 1);
                    }
                }
                return -1;
            }
            this.zzc.zzJ(iZze3 + iZza2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzl = zzacxVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        zzaob zzaobVar;
        int size = this.zzb.size();
        for (int i = 0; i < size; i++) {
            zzfw zzfwVar = (zzfw) this.zzb.get(i);
            if (zzfwVar.zzf() != -9223372036854775807L) {
                long jZzd = zzfwVar.zzd();
                if (jZzd != -9223372036854775807L && jZzd != 0 && jZzd != j2) {
                    zzfwVar.zzi(j2);
                }
            } else {
                zzfwVar.zzi(j2);
            }
        }
        if (j2 != 0 && (zzaobVar = this.zzk) != null) {
            zzaobVar.zzd(j2);
        }
        this.zzc.zzH(0);
        this.zzd.clear();
        for (int i2 = 0; i2 < this.zzg.size(); i2++) {
            ((zzaol) this.zzg.valueAt(i2)).zzc();
        }
        this.zzq = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        byte[] bArrZzM = this.zzc.zzM();
        zzack zzackVar = (zzack) zzacvVar;
        zzackVar.zzm(bArrZzM, 0, 940, false);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    zzackVar.zzo(i, false);
                    return true;
                }
                if (bArrZzM[(i2 * 188) + i] != 71) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public zzaog(int i, int i2, zzakp zzakpVar, zzfw zzfwVar, zzaoj zzaojVar, int i3) {
        this.zze = zzaojVar;
        this.zzf = zzakpVar;
        this.zzb = Collections.singletonList(zzfwVar);
        this.zzc = new zzfp(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzaoc(112800);
        this.zzl = zzacx.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.zzg.put(sparseArray2.keyAt(i4), (zzaol) sparseArray2.valueAt(i4));
        }
        this.zzg.put(0, new zzany(new zzaoe(this)));
    }
}
