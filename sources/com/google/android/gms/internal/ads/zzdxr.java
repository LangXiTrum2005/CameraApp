package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdxr implements zzdxf {
    private final long zza;
    private final zzeqm zzb;

    zzdxr(long j, Context context, zzdxk zzdxkVar, zzclg zzclgVar, String str) {
        this.zza = j;
        zzfer zzferVarZzu = zzclgVar.zzu();
        zzferVarZzu.zzc(context);
        zzferVarZzu.zza(new com.google.android.gms.ads.internal.client.zzq());
        zzferVarZzu.zzb(str);
        zzeqm zzeqmVarZza = zzferVarZzu.zzd().zza();
        this.zzb = zzeqmVarZza;
        zzeqmVarZza.zzD(new zzdxq(this, zzdxkVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zza() {
        this.zzb.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zzb(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        this.zzb.zzaa(zzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
