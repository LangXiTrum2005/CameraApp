package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbep extends zzgzu implements zzhbf {
    private static final zzbep zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzbep zzbepVar = new zzbep();
        zzb = zzbepVar;
        zzgzu.zzaU(zzbep.class, zzbepVar);
    }

    private zzbep() {
    }

    public static zzbeo zza() {
        return (zzbeo) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzbep zzbepVar, int i) {
        zzbepVar.zzd |= 1;
        zzbepVar.zze = i;
    }

    static /* synthetic */ void zze(zzbep zzbepVar, int i) {
        zzbepVar.zzd |= 2;
        zzbepVar.zzf = i;
    }

    static /* synthetic */ void zzf(zzbep zzbepVar, int i) {
        zzbepVar.zzd |= 4;
        zzbepVar.zzg = i;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbep();
        }
        zzbbw zzbbwVar = null;
        if (i2 == 4) {
            return new zzbeo(zzbbwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
