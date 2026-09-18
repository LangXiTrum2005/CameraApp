package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfdw implements zzfws {
    final /* synthetic */ zzfdz zza;

    zzfdw(zzfdz zzfdzVar) {
        this.zza = zzfdzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfws
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzbze zzbzeVar = (zzbze) obj;
        this.zza.zzd = new zzfdy(zzbzeVar, new zzfjh(zzbzeVar.zzj), null);
        return this.zza.zzd;
    }
}
