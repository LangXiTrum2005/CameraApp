package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdbj extends zzdgl implements zzdbb {
    public zzdbj(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zza(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzu(new zzdgk() { // from class: com.google.android.gms.internal.ads.zzdbi
            @Override // com.google.android.gms.internal.ads.zzdgk
            public final void zza(Object obj) {
                ((zzdbn) obj).zzp(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zzb() {
        zzu(new zzdgk() { // from class: com.google.android.gms.internal.ads.zzdbh
            @Override // com.google.android.gms.internal.ads.zzdgk
            public final void zza(Object obj) {
                ((zzdbn) obj).zzp(zzfij.zzd(11, null, null));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zzc(final zzdkv zzdkvVar) {
        zzu(new zzdgk() { // from class: com.google.android.gms.internal.ads.zzdbg
            @Override // com.google.android.gms.internal.ads.zzdgk
            public final void zza(Object obj) {
                ((zzdbn) obj).zzp(zzfij.zzd(12, zzdkvVar.getMessage(), null));
            }
        });
    }
}
