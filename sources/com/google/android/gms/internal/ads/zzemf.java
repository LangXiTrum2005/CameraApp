package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzemf implements zzgej {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfgp zzb;
    final /* synthetic */ zzfgm zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfnu zze;
    final /* synthetic */ zzfgy zzf;
    final /* synthetic */ zzemh zzg;

    zzemf(zzemh zzemhVar, long j, zzfgp zzfgpVar, zzfgm zzfgmVar, String str, zzfnu zzfnuVar, zzfgy zzfgyVar) {
        this.zza = j;
        this.zzb = zzfgpVar;
        this.zzc = zzfgmVar;
        this.zzd = str;
        this.zze = zzfnuVar;
        this.zzf = zzfgyVar;
        this.zzg = zzemhVar;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0061 A[PHI: r7
  0x0061: PHI (r7v1 int) = (r7v0 int), (r7v3 int), (r7v3 int), (r7v3 int) binds: [B:16:0x002f, B:21:0x004a, B:23:0x004e, B:25:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x006e A[Catch: all -> 0x0102, TryCatch #0 {, blocks: (B:31:0x0066, B:33:0x006e, B:35:0x007a, B:36:0x007d, B:37:0x0086, B:39:0x0098, B:40:0x00ad, B:42:0x00b5, B:44:0x00b7, B:52:0x00f5, B:53:0x0100, B:47:0x00da, B:49:0x00de, B:51:0x00e8), top: B:58:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x007a A[Catch: all -> 0x0102, TryCatch #0 {, blocks: (B:31:0x0066, B:33:0x006e, B:35:0x007a, B:36:0x007d, B:37:0x0086, B:39:0x0098, B:40:0x00ad, B:42:0x00b5, B:44:0x00b7, B:52:0x00f5, B:53:0x0100, B:47:0x00da, B:49:0x00de, B:51:0x00e8), top: B:58:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0098 A[Catch: all -> 0x0102, TryCatch #0 {, blocks: (B:31:0x0066, B:33:0x006e, B:35:0x007a, B:36:0x007d, B:37:0x0086, B:39:0x0098, B:40:0x00ad, B:42:0x00b5, B:44:0x00b7, B:52:0x00f5, B:53:0x0100, B:47:0x00da, B:49:0x00de, B:51:0x00e8), top: B:58:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b5 A[Catch: all -> 0x0102, DONT_GENERATE, TryCatch #0 {, blocks: (B:31:0x0066, B:33:0x006e, B:35:0x007a, B:36:0x007d, B:37:0x0086, B:39:0x0098, B:40:0x00ad, B:42:0x00b5, B:44:0x00b7, B:52:0x00f5, B:53:0x0100, B:47:0x00da, B:49:0x00de, B:51:0x00e8), top: B:58:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b7 A[Catch: all -> 0x0102, TryCatch #0 {, blocks: (B:31:0x0066, B:33:0x006e, B:35:0x007a, B:36:0x007d, B:37:0x0086, B:39:0x0098, B:40:0x00ad, B:42:0x00b5, B:44:0x00b7, B:52:0x00f5, B:53:0x0100, B:47:0x00da, B:49:0x00de, B:51:0x00e8), top: B:58:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        Integer numValueOf;
        int i;
        com.google.android.gms.ads.internal.client.zze zzeVarZzb;
        zzemh zzemhVar;
        zzemh zzemhVar2;
        com.google.android.gms.ads.internal.client.zze zzeVarZza;
        int i2;
        com.google.android.gms.ads.internal.client.zze zzeVar;
        long jElapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzelp) {
            i = 3;
        } else {
            if (!(th instanceof CancellationException)) {
                if (th instanceof zzfho) {
                    i = 5;
                } else {
                    int i3 = 6;
                    if (th instanceof zzead) {
                        i3 = zzfij.zza(th).zza == 3 ? 1 : 6;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbC)).booleanValue() && (th instanceof zzeir) && (zzeVarZzb = ((zzeir) th).zzb()) != null) {
                            numValueOf = Integer.valueOf(zzeVarZzb.zza);
                        } else {
                            numValueOf = null;
                        }
                    } else {
                        numValueOf = null;
                    }
                    i = i3;
                }
                synchronized (this.zzg) {
                    zzemhVar = this.zzg;
                    if (zzemhVar.zze) {
                        zzemhVar.zzb.zza(this.zzb, this.zzc, i, th instanceof zzeir ? (zzeir) th : null, jElapsedRealtime);
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzij)).booleanValue()) {
                        zzfny zzfnyVar = this.zzg.zzc;
                        zzfnu zzfnuVar = this.zze;
                        zzfgy zzfgyVar = this.zzf;
                        zzfgm zzfgmVar = this.zzc;
                        zzfnyVar.zzd(zzfnuVar.zzc(zzfgyVar, zzfgmVar, zzfgmVar.zzo));
                    }
                    zzemhVar2 = this.zzg;
                    if (zzemhVar2.zzg) {
                        return;
                    }
                    LinkedHashMap linkedHashMap = zzemhVar2.zzd;
                    zzfgm zzfgmVar2 = this.zzc;
                    linkedHashMap.put(zzfgmVar2, new zzemg(this.zzd, zzfgmVar2.zzag, i, jElapsedRealtime, numValueOf));
                    zzeVarZza = zzfij.zza(th);
                    i2 = zzeVarZza.zza;
                    if ((i2 != 3 || i2 == 0) && (zzeVar = zzeVarZza.zzd) != null && !zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                    }
                    this.zzg.zzf.zzf(this.zzc, jElapsedRealtime, zzeVarZza);
                }
            }
            i = 4;
        }
        numValueOf = null;
        synchronized (this.zzg) {
            zzemhVar = this.zzg;
            if (zzemhVar.zze) {
                zzemhVar.zzb.zza(this.zzb, this.zzc, i, th instanceof zzeir ? (zzeir) th : null, jElapsedRealtime);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzij)).booleanValue()) {
                zzfny zzfnyVar2 = this.zzg.zzc;
                zzfnu zzfnuVar2 = this.zze;
                zzfgy zzfgyVar2 = this.zzf;
                zzfgm zzfgmVar3 = this.zzc;
                zzfnyVar2.zzd(zzfnuVar2.zzc(zzfgyVar2, zzfgmVar3, zzfgmVar3.zzo));
            }
            zzemhVar2 = this.zzg;
            if (zzemhVar2.zzg) {
                return;
            }
            LinkedHashMap linkedHashMap2 = zzemhVar2.zzd;
            zzfgm zzfgmVar4 = this.zzc;
            linkedHashMap2.put(zzfgmVar4, new zzemg(this.zzd, zzfgmVar4.zzag, i, jElapsedRealtime, numValueOf));
            zzeVarZza = zzfij.zza(th);
            i2 = zzeVarZza.zza;
            zzeVarZza = i2 != 3 ? zzfij.zza(new zzeir(13, zzeVarZza.zzd)) : zzfij.zza(new zzeir(13, zzeVarZza.zzd));
            this.zzg.zzf.zzf(this.zzc, jElapsedRealtime, zzeVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zzb(Object obj) {
        long jElapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        synchronized (this.zzg) {
            zzemh zzemhVar = this.zzg;
            if (zzemhVar.zze) {
                zzemhVar.zzb.zza(this.zzb, this.zzc, 0, null, jElapsedRealtime);
            }
            zzemh zzemhVar2 = this.zzg;
            if (zzemhVar2.zzg) {
                return;
            }
            if (zzemhVar2.zzq(this.zzc)) {
                ((zzemg) this.zzg.zzd.get(this.zzc)).zzd = jElapsedRealtime;
            } else {
                LinkedHashMap linkedHashMap = this.zzg.zzd;
                zzfgm zzfgmVar = this.zzc;
                linkedHashMap.put(zzfgmVar, new zzemg(this.zzd, zzfgmVar.zzag, 0, jElapsedRealtime, null));
            }
            this.zzg.zzf.zzg(this.zzc, jElapsedRealtime, null);
        }
    }
}
