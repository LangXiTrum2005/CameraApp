package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcsd implements zzgej {
    final /* synthetic */ zzfny zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcse zzc;

    zzcsd(zzcse zzcseVar, zzfny zzfnyVar, String str) {
        this.zza = zzfnyVar;
        this.zzb = str;
        this.zzc = zzcseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(final Throwable th) {
        zzgey zzgeyVar = this.zzc.zzg;
        final zzfny zzfnyVar = this.zza;
        final String str = this.zzb;
        zzgeyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsb
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjT)).booleanValue();
                zzcsd zzcsdVar = this.zza;
                Throwable th2 = th;
                if (zBooleanValue) {
                    zzcse zzcseVar = zzcsdVar.zzc;
                    zzcseVar.zzb = zzbxw.zzc(zzcseVar.zzc);
                    zzcsdVar.zzc.zzb.zzg(th2, "AttributionReporting.registerSourceAndPingClickUrl");
                } else {
                    zzcse zzcseVar2 = zzcsdVar.zzc;
                    zzcseVar2.zza = zzbxw.zza(zzcseVar2.zzc);
                    zzcsdVar.zzc.zza.zzg(th2, "AttributionReporting.registerSourceAndPingClickUrl");
                }
                zzfnyVar.zzc(str, null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcse zzcseVar = this.zzc;
        final zzfny zzfnyVar = this.zza;
        final String str = (String) obj;
        zzcseVar.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsc
            @Override // java.lang.Runnable
            public final void run() {
                zzfnyVar.zzc(str, null);
            }
        });
    }
}
