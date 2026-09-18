package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdvj implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;

    public zzdvj(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
        this.zzd = zzhhuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setEmptySet;
        final String str = (String) this.zza.zzb();
        Context contextZza = ((zzclm) this.zzb).zza();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        Map mapZzb = ((zzhhh) this.zzd).zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeO)).booleanValue()) {
            zzbbp zzbbpVar = new zzbbp(new zzbbv(contextZza));
            zzbbpVar.zzb(new zzbbo() { // from class: com.google.android.gms.internal.ads.zzdvk
                @Override // com.google.android.gms.internal.ads.zzbbo
                public final void zza(zzbde zzbdeVar) {
                    zzbdeVar.zzh(str);
                }
            });
            setEmptySet = Collections.singleton(new zzdim(new zzdvm(zzbbpVar, mapZzb), zzgeyVar));
        } else {
            setEmptySet = Collections.emptySet();
        }
        zzhhl.zzb(setEmptySet);
        return setEmptySet;
    }
}
