package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaof implements zzanx {
    final /* synthetic */ zzaog zza;
    private final zzfo zzb = new zzfo(new byte[5], 5);
    private final SparseArray zzc = new SparseArray();
    private final SparseIntArray zzd = new SparseIntArray();
    private final int zze;

    public zzaof(zzaog zzaogVar, int i) {
        this.zza = zzaogVar;
        this.zze = i;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:31:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:41:0x0114  */
    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zza(zzfp zzfpVar) {
        zzfw zzfwVar;
        int i;
        int i2;
        int i3;
        int i4;
        if (zzfpVar.zzm() != 2) {
            return;
        }
        zzfw zzfwVar2 = (zzfw) this.zza.zzb.get(0);
        if ((zzfpVar.zzm() & 128) != 0) {
            zzfpVar.zzL(1);
            int iZzq = zzfpVar.zzq();
            int i5 = 3;
            zzfpVar.zzL(3);
            zzfpVar.zzF(this.zzb, 2);
            this.zzb.zzm(3);
            int i6 = 13;
            this.zza.zzr = this.zzb.zzd(13);
            zzfpVar.zzF(this.zzb, 2);
            int i7 = 4;
            this.zzb.zzm(4);
            int i8 = 12;
            zzfpVar.zzL(this.zzb.zzd(12));
            this.zzc.clear();
            this.zzd.clear();
            int iZzb = zzfpVar.zzb();
            while (iZzb > 0) {
                int i9 = 5;
                zzfpVar.zzF(this.zzb, 5);
                zzfo zzfoVar = this.zzb;
                int iZzd = zzfoVar.zzd(8);
                zzfoVar.zzm(i5);
                int iZzd2 = this.zzb.zzd(i6);
                this.zzb.zzm(i7);
                int iZzd3 = this.zzb.zzd(i8);
                int iZzd4 = zzfpVar.zzd();
                int i10 = iZzd4 + iZzd3;
                ArrayList arrayList = null;
                String strTrim = null;
                int i11 = -1;
                while (true) {
                    if (zzfpVar.zzd() >= i10) {
                        i2 = i7;
                        break;
                    }
                    int iZzm = zzfpVar.zzm();
                    int iZzd5 = zzfpVar.zzd() + zzfpVar.zzm();
                    if (iZzd5 > i10) {
                        i2 = 4;
                        break;
                    }
                    if (iZzm == i9) {
                        long jZzu = zzfpVar.zzu();
                        if (jZzu == 1094921523) {
                            zzfwVar2 = zzfwVar2;
                            i11 = 129;
                            i3 = 4;
                            iZzq = iZzq;
                        } else {
                            if (jZzu == 1161904947) {
                                zzfwVar2 = zzfwVar2;
                                i11 = 135;
                            } else if (jZzu == 1094921524) {
                                zzfwVar2 = zzfwVar2;
                                i11 = 172;
                            } else if (jZzu == 1212503619) {
                                i4 = 36;
                                i11 = i4;
                            }
                            i3 = 4;
                        }
                    } else if (iZzm == 106) {
                        zzfwVar2 = zzfwVar2;
                        i11 = 129;
                        i3 = 4;
                        iZzq = iZzq;
                    } else if (iZzm == 122) {
                        zzfwVar2 = zzfwVar2;
                        i11 = 135;
                        i3 = 4;
                    } else if (iZzm == 127) {
                        if (zzfpVar.zzm() == 21) {
                            zzfwVar2 = zzfwVar2;
                            i11 = 172;
                        }
                        i3 = 4;
                    } else if (iZzm == 123) {
                        i4 = 138;
                        i11 = i4;
                        i3 = 4;
                    } else if (iZzm == 10) {
                        strTrim = zzfpVar.zzA(i5, zzfwq.zzc).trim();
                        i3 = 4;
                    } else if (iZzm == 89) {
                        ArrayList arrayList2 = new ArrayList();
                        while (zzfpVar.zzd() < iZzd5) {
                            String strTrim2 = zzfpVar.zzA(i5, zzfwq.zzc).trim();
                            int iZzm2 = zzfpVar.zzm();
                            zzfw zzfwVar3 = zzfwVar2;
                            byte[] bArr = new byte[4];
                            zzfpVar.zzG(bArr, 0, 4);
                            arrayList2.add(new zzaoh(strTrim2, iZzm2, bArr));
                            zzfwVar2 = zzfwVar3;
                            iZzq = iZzq;
                            i5 = 3;
                        }
                        zzfwVar2 = zzfwVar2;
                        iZzq = iZzq;
                        i3 = 4;
                        arrayList = arrayList2;
                        i11 = 89;
                    } else {
                        zzfwVar2 = zzfwVar2;
                        iZzq = iZzq;
                        i3 = 4;
                        if (iZzm == 111) {
                            i11 = 257;
                        }
                    }
                    zzfpVar.zzL(iZzd5 - zzfpVar.zzd());
                    i7 = i3;
                    zzfwVar2 = zzfwVar2;
                    iZzq = iZzq;
                    i5 = 3;
                    i9 = 5;
                }
                zzfpVar.zzK(i10);
                zzaoi zzaoiVar = new zzaoi(i11, strTrim, arrayList, Arrays.copyOfRange(zzfpVar.zzM(), iZzd4, i10));
                if (iZzd == 6 || iZzd == 5) {
                    iZzd = zzaoiVar.zza;
                }
                iZzb -= iZzd3 + 5;
                if (!this.zza.zzh.get(iZzd2)) {
                    zzaol zzaolVarZza = this.zza.zze.zza(iZzd, zzaoiVar);
                    this.zzd.put(iZzd2, iZzd2);
                    this.zzc.put(iZzd2, zzaolVarZza);
                }
                i7 = i2;
                zzfwVar2 = zzfwVar2;
                iZzq = iZzq;
                i5 = 3;
                i8 = 12;
                i6 = 13;
            }
            zzfw zzfwVar4 = zzfwVar2;
            int i12 = iZzq;
            int size = this.zzd.size();
            int i13 = 0;
            while (i13 < size) {
                SparseIntArray sparseIntArray = this.zzd;
                zzaog zzaogVar = this.zza;
                int iKeyAt = sparseIntArray.keyAt(i13);
                int iValueAt = sparseIntArray.valueAt(i13);
                zzaogVar.zzh.put(iKeyAt, true);
                this.zza.zzi.put(iValueAt, true);
                zzaol zzaolVar = (zzaol) this.zzc.valueAt(i13);
                if (zzaolVar != null) {
                    zzacx zzacxVar = this.zza.zzl;
                    i = i12;
                    zzaok zzaokVar = new zzaok(i, iKeyAt, 8192);
                    zzfwVar = zzfwVar4;
                    zzaolVar.zzb(zzfwVar, zzacxVar, zzaokVar);
                    this.zza.zzg.put(iValueAt, zzaolVar);
                } else {
                    zzfwVar = zzfwVar4;
                    i = i12;
                }
                i13++;
                zzfwVar4 = zzfwVar;
                i12 = i;
            }
            this.zza.zzg.remove(this.zze);
            this.zza.zzm = 0;
            zzaog zzaogVar2 = this.zza;
            if (zzaogVar2.zzm == 0) {
                zzaogVar2.zzl.zzD();
                this.zza.zzn = true;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzb(zzfw zzfwVar, zzacx zzacxVar, zzaok zzaokVar) {
    }
}
