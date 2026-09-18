package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfzy extends zzfya {
    private final zzgaa zza;

    zzfzy(zzgaa zzgaaVar, int i) {
        super(zzgaaVar.size(), i);
        this.zza = zzgaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfya
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
