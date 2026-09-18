package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzebf implements zzgej {
    final /* synthetic */ zzebg zza;

    zzebf(zzebg zzebgVar) {
        this.zza = zzebgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgj)).booleanValue()) {
            Matcher matcher = zzebg.zza.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zzf.zzi(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfgy zzfgyVar = (zzfgy) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgj)).booleanValue()) {
            this.zza.zzf.zzi(zzfgyVar.zzb.zzb.zze);
            this.zza.zzf.zzj(zzfgyVar.zzb.zzb.zzf);
        }
    }
}
