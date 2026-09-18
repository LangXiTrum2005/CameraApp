package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeku implements zzeit {
    private final Context zza;
    private final zzdko zzb;
    private final zzcei zzc;
    private final Executor zzd;

    public zzeku(Context context, zzcei zzceiVar, zzdko zzdkoVar, Executor executor) {
        this.zza = context;
        this.zzc = zzceiVar;
        this.zzb = zzdkoVar;
        this.zzd = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, final zzeiq zzeiqVar) throws zzeml, zzfho {
        zzdjo zzdjoVarZze = this.zzb.zze(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdjr(new zzdkw() { // from class: com.google.android.gms.internal.ads.zzekt
            @Override // com.google.android.gms.internal.ads.zzdkw
            public final void zza(boolean z, Context context, zzdbk zzdbkVar) throws zzdkv {
                this.zza.zzc(zzeiqVar, z, context, zzdbkVar);
            }
        }, null));
        zzdjoVarZze.zzd().zzo(new zzcrv((zzfif) zzeiqVar.zzb), this.zzd);
        ((zzekj) zzeiqVar.zzc).zzc(zzdjoVarZze.zzj());
        return zzdjoVarZze.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        zzfif zzfifVar = (zzfif) zzeiqVar.zzb;
        zzfhh zzfhhVar = zzfgyVar.zza.zza;
        zzfifVar.zzo(this.zza, zzfhhVar.zzd, zzfgmVar.zzw.toString(), com.google.android.gms.ads.internal.util.zzbw.zzl(zzfgmVar.zzt), (zzbtb) zzeiqVar.zzc);
    }

    final /* synthetic */ void zzc(zzeiq zzeiqVar, boolean z, Context context, zzdbk zzdbkVar) throws zzdkv {
        try {
            ((zzfif) zzeiqVar.zzb).zzv(z);
            if (this.zzc.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaH)).intValue()) {
                ((zzfif) zzeiqVar.zzb).zzx();
            } else {
                ((zzfif) zzeiqVar.zzb).zzy(context);
            }
        } catch (zzfho e) {
            zzcec.zzi("Cannot show interstitial.");
            throw new zzdkv(e.getCause());
        }
    }
}
