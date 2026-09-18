package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzyo {
    private zzyn zza;
    private zzyw zzb;

    public zzmg zzd() {
        throw null;
    }

    public void zzj() {
        this.zza = null;
        this.zzb = null;
    }

    public void zzk(zzk zzkVar) {
        throw null;
    }

    public boolean zzn() {
        throw null;
    }

    public abstract zzyp zzp(zzmh[] zzmhVarArr, zzws zzwsVar, zzur zzurVar, zzcx zzcxVar) throws zziz;

    public abstract void zzq(Object obj);

    protected final zzyw zzr() {
        zzyw zzywVar = this.zzb;
        zzek.zzb(zzywVar);
        return zzywVar;
    }

    public final void zzs(zzyn zzynVar, zzyw zzywVar) {
        this.zza = zzynVar;
        this.zzb = zzywVar;
    }

    protected final void zzt() {
        zzyn zzynVar = this.zza;
        if (zzynVar != null) {
            zzynVar.zzj();
        }
    }
}
