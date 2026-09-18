package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfdv implements zzfws {
    final /* synthetic */ zzfdz zza;

    zzfdv(zzfdz zzfdzVar) {
        this.zza = zzfdzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfws
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzcec.zzh("", (zzecf) obj);
        com.google.android.gms.ads.internal.util.zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzfdz zzfdzVar = this.zza;
        zzfdzVar.zzd = new zzfdy(null, zzfdzVar.zze(), null);
        return this.zza.zzd;
    }
}
