package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfef implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzfef(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfed zzb() {
        Context context = (Context) this.zza.zzb();
        zzfir zzfirVar = (zzfir) this.zzb.zzb();
        zzfjj zzfjjVar = (zzfjj) this.zzc.zzb();
        zzcdf zzcdfVarZzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgr)).booleanValue() ? com.google.android.gms.ads.internal.zzt.zzo().zzi().zzh() : com.google.android.gms.ads.internal.zzt.zzo().zzi().zzi();
        boolean z = false;
        if (zzcdfVarZzh != null && zzcdfVarZzh.zzh()) {
            z = true;
        }
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgH)).intValue() > 0) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgq)).booleanValue() || z) {
                zzfji zzfjiVarZza = zzfjjVar.zza(zzfiz.AppOpen, context, zzfirVar, new zzfdh(new zzfde()));
                return new zzfdj(new zzfdt(new zzfds()), new zzfdp(zzfjiVarZza.zza, zzcep.zza), zzfjiVarZza.zzb, zzfjiVarZza.zza.zza().zzf, zzcep.zza);
            }
        }
        return new zzfds();
    }
}
