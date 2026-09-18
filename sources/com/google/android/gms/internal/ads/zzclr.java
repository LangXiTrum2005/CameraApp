package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzclr implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzclr(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x003b  */
    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setEmptySet;
        zzefk zzefkVar = (zzefk) this.zza.zzb();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbZ)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
                setEmptySet = Collections.singleton(new zzdim(zzefkVar, zzgeyVar));
            } else {
                setEmptySet = Collections.emptySet();
            }
        } else {
            setEmptySet = Collections.emptySet();
        }
        zzhhl.zzb(setEmptySet);
        return setEmptySet;
    }
}
