package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhhc implements zzhhm, zzhgx {
    private static final Object zza = new Object();
    private volatile zzhhm zzb;
    private volatile Object zzc = zza;

    private zzhhc(zzhhm zzhhmVar) {
        this.zzb = zzhhmVar;
    }

    public static zzhgx zza(zzhhm zzhhmVar) {
        return zzhhmVar instanceof zzhgx ? (zzhgx) zzhhmVar : new zzhhc(zzhhmVar);
    }

    public static zzhhm zzc(zzhhm zzhhmVar) {
        return zzhhmVar instanceof zzhhc ? zzhhmVar : new zzhhc(zzhhmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final Object zzb() {
        Object objZzb = this.zzc;
        Object obj = zza;
        if (objZzb == obj) {
            synchronized (this) {
                objZzb = this.zzc;
                if (objZzb == obj) {
                    objZzb = this.zzb.zzb();
                    Object obj2 = this.zzc;
                    if (obj2 != obj && obj2 != objZzb) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + objZzb + ". This is likely due to a circular dependency.");
                    }
                    this.zzc = objZzb;
                    this.zzb = null;
                }
            }
        }
        return objZzb;
    }
}
