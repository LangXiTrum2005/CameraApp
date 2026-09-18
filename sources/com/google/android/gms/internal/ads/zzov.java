package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzov implements zzoz {
    public static final zzfxu zza = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzot
        @Override // com.google.android.gms.internal.ads.zzfxu
        public final Object zza() {
            return zzov.zzn();
        }
    };
    private static final Random zzb = new Random();
    private final zzcw zzc;
    private final zzcu zzd;
    private final HashMap zze;
    private final zzfxu zzf;
    private zzoy zzg;
    private zzcx zzh;
    private String zzi;
    private long zzj;

    public zzov() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzl() {
        zzou zzouVar = (zzou) this.zze.get(this.zzi);
        return (zzouVar == null || zzouVar.zzd == -1) ? this.zzj + 1 : zzouVar.zzd;
    }

    private final zzou zzm(int i, zzur zzurVar) {
        long j = Long.MAX_VALUE;
        zzou zzouVar = null;
        for (zzou zzouVar2 : this.zze.values()) {
            zzouVar2.zzg(i, zzurVar);
            if (zzouVar2.zzj(i, zzurVar)) {
                long j2 = zzouVar2.zzd;
                if (j2 == -1 || j2 < j) {
                    zzouVar = zzouVar2;
                    j = j2;
                } else if (j2 == j) {
                    int i2 = zzfy.zza;
                    if (zzouVar.zze != null && zzouVar2.zze != null) {
                        zzouVar = zzouVar2;
                    }
                }
            }
        }
        if (zzouVar != null) {
            return zzouVar;
        }
        String strZzn = zzn();
        zzou zzouVar3 = new zzou(this, strZzn, i, zzurVar);
        this.zze.put(strZzn, zzouVar3);
        return zzouVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzou zzouVar) {
        if (zzouVar.zzd != -1) {
            this.zzj = zzouVar.zzd;
        }
        this.zzi = null;
    }

    @RequiresNonNull({ServiceSpecificExtraArgs.CastExtraArgs.LISTENER})
    private final void zzp(zzmq zzmqVar) {
        if (zzmqVar.zzb.zzo()) {
            String str = this.zzi;
            if (str != null) {
                zzou zzouVar = (zzou) this.zze.get(str);
                zzouVar.getClass();
                zzo(zzouVar);
                return;
            }
            return;
        }
        zzou zzouVar2 = (zzou) this.zze.get(this.zzi);
        zzou zzouVarZzm = zzm(zzmqVar.zzc, zzmqVar.zzd);
        this.zzi = zzouVarZzm.zzb;
        zzi(zzmqVar);
        zzur zzurVar = zzmqVar.zzd;
        if (zzurVar == null || !zzurVar.zzb()) {
            return;
        }
        if (zzouVar2 != null) {
            if (zzouVar2.zzd == zzurVar.zzd && zzouVar2.zze != null && zzouVar2.zze.zzb == zzmqVar.zzd.zzb && zzouVar2.zze.zzc == zzmqVar.zzd.zzc) {
                return;
            }
        }
        zzur zzurVar2 = zzmqVar.zzd;
        String unused = zzm(zzmqVar.zzc, new zzur(zzurVar2.zza, zzurVar2.zzd)).zzb;
        String unused2 = zzouVarZzm.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final synchronized String zze() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final synchronized String zzf(zzcx zzcxVar, zzur zzurVar) {
        return zzm(zzcxVar.zzn(zzurVar.zza, this.zzd).zzd, zzurVar).zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final synchronized void zzg(zzmq zzmqVar) {
        zzoy zzoyVar;
        String str = this.zzi;
        if (str != null) {
            zzou zzouVar = (zzou) this.zze.get(str);
            zzouVar.getClass();
            zzo(zzouVar);
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzou zzouVar2 = (zzou) it.next();
            it.remove();
            if (zzouVar2.zzf && (zzoyVar = this.zzg) != null) {
                zzoyVar.zzd(zzmqVar, zzouVar2.zzb, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzh(zzoy zzoyVar) {
        this.zzg = zzoyVar;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c A[Catch: all -> 0x00c6, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x0010, B:10:0x0014, B:12:0x001e, B:14:0x002a, B:16:0x0034, B:18:0x003c, B:20:0x0048, B:21:0x004e, B:23:0x0053, B:25:0x0059, B:27:0x0070, B:28:0x0098, B:30:0x009e, B:31:0x00a4, B:33:0x00b0, B:35:0x00b6), top: B:43:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0048 A[Catch: all -> 0x00c6, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x0010, B:10:0x0014, B:12:0x001e, B:14:0x002a, B:16:0x0034, B:18:0x003c, B:20:0x0048, B:21:0x004e, B:23:0x0053, B:25:0x0059, B:27:0x0070, B:28:0x0098, B:30:0x009e, B:31:0x00a4, B:33:0x00b0, B:35:0x00b6), top: B:43:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0070 A[Catch: all -> 0x00c6, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x0010, B:10:0x0014, B:12:0x001e, B:14:0x002a, B:16:0x0034, B:18:0x003c, B:20:0x0048, B:21:0x004e, B:23:0x0053, B:25:0x0059, B:27:0x0070, B:28:0x0098, B:30:0x009e, B:31:0x00a4, B:33:0x00b0, B:35:0x00b6), top: B:43:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x009e A[Catch: all -> 0x00c6, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x0010, B:10:0x0014, B:12:0x001e, B:14:0x002a, B:16:0x0034, B:18:0x003c, B:20:0x0048, B:21:0x004e, B:23:0x0053, B:25:0x0059, B:27:0x0070, B:28:0x0098, B:30:0x009e, B:31:0x00a4, B:33:0x00b0, B:35:0x00b6), top: B:43:0x0001 }] */
    @Override // com.google.android.gms.internal.ads.zzoz
    public final synchronized void zzi(zzmq zzmqVar) {
        zzou zzouVarZzm;
        zzur zzurVar;
        zzou zzouVarZzm2;
        zzou zzouVar;
        this.zzg.getClass();
        if (!zzmqVar.zzb.zzo()) {
            zzur zzurVar2 = zzmqVar.zzd;
            if (zzurVar2 == null) {
                zzouVarZzm = zzm(zzmqVar.zzc, zzmqVar.zzd);
                if (this.zzi == null) {
                    this.zzi = zzouVarZzm.zzb;
                }
                zzurVar = zzmqVar.zzd;
                if (zzurVar != null) {
                    zzouVarZzm2 = zzm(zzmqVar.zzc, new zzur(zzurVar.zza, zzurVar.zzd, zzurVar.zzb));
                    if (!zzouVarZzm2.zzf) {
                        zzouVarZzm2.zzf = true;
                        zzmqVar.zzb.zzn(zzmqVar.zzd.zza, this.zzd);
                        this.zzd.zzi(zzmqVar.zzd.zzb);
                        Math.max(0L, zzfy.zzt(0L) + zzfy.zzt(0L));
                        String unused = zzouVarZzm2.zzb;
                    }
                }
                if (!zzouVarZzm.zzf) {
                    zzouVarZzm.zzf = true;
                    String unused2 = zzouVarZzm.zzb;
                }
                if (zzouVarZzm.zzb.equals(this.zzi)) {
                    zzouVarZzm.zzg = true;
                    this.zzg.zzc(zzmqVar, zzouVarZzm.zzb);
                }
            } else if (zzurVar2.zzd >= zzl() && ((zzouVar = (zzou) this.zze.get(this.zzi)) == null || zzouVar.zzd != -1 || zzouVar.zzc == zzmqVar.zzc)) {
                zzouVarZzm = zzm(zzmqVar.zzc, zzmqVar.zzd);
                if (this.zzi == null) {
                    this.zzi = zzouVarZzm.zzb;
                }
                zzurVar = zzmqVar.zzd;
                if (zzurVar != null && zzurVar.zzb()) {
                    zzouVarZzm2 = zzm(zzmqVar.zzc, new zzur(zzurVar.zza, zzurVar.zzd, zzurVar.zzb));
                    if (!zzouVarZzm2.zzf) {
                        zzouVarZzm2.zzf = true;
                        zzmqVar.zzb.zzn(zzmqVar.zzd.zza, this.zzd);
                        this.zzd.zzi(zzmqVar.zzd.zzb);
                        Math.max(0L, zzfy.zzt(0L) + zzfy.zzt(0L));
                        String unused3 = zzouVarZzm2.zzb;
                    }
                }
                if (!zzouVarZzm.zzf) {
                    zzouVarZzm.zzf = true;
                    String unused4 = zzouVarZzm.zzb;
                }
                if (zzouVarZzm.zzb.equals(this.zzi) && !zzouVarZzm.zzg) {
                    zzouVarZzm.zzg = true;
                    this.zzg.zzc(zzmqVar, zzouVarZzm.zzb);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final synchronized void zzj(zzmq zzmqVar, int i) {
        this.zzg.getClass();
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzou zzouVar = (zzou) it.next();
            if (zzouVar.zzk(zzmqVar)) {
                it.remove();
                if (zzouVar.zzf) {
                    boolean zEquals = zzouVar.zzb.equals(this.zzi);
                    boolean z = false;
                    if (i == 0 && zEquals && zzouVar.zzg) {
                        z = true;
                    }
                    if (zEquals) {
                        zzo(zzouVar);
                    }
                    this.zzg.zzd(zzmqVar, zzouVar.zzb, z);
                }
            }
        }
        zzp(zzmqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final synchronized void zzk(zzmq zzmqVar) {
        this.zzg.getClass();
        zzcx zzcxVar = this.zzh;
        this.zzh = zzmqVar.zzb;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzou zzouVar = (zzou) it.next();
            if (!zzouVar.zzl(zzcxVar, this.zzh) || zzouVar.zzk(zzmqVar)) {
                it.remove();
                if (zzouVar.zzf) {
                    if (zzouVar.zzb.equals(this.zzi)) {
                        zzo(zzouVar);
                    }
                    this.zzg.zzd(zzmqVar, zzouVar.zzb, false);
                }
            }
        }
        zzp(zzmqVar);
    }

    public zzov(zzfxu zzfxuVar) {
        this.zzf = zzfxuVar;
        this.zzc = new zzcw();
        this.zzd = new zzcu();
        this.zze = new HashMap();
        this.zzh = zzcx.zza;
        this.zzj = -1L;
    }
}
