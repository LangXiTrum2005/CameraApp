package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzemu implements zzeit {
    private final Context zza;
    private final Executor zzb;
    private final zzdst zzc;

    public zzemu(Context context, Executor executor, zzdst zzdstVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdstVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, final zzeiq zzeiqVar) throws zzeml, zzfho {
        zzdsp zzdspVarZze = this.zzc.zze(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdsq(new zzdkw() { // from class: com.google.android.gms.internal.ads.zzemt
            @Override // com.google.android.gms.internal.ads.zzdkw
            public final void zza(boolean z, Context context, zzdbk zzdbkVar) throws zzdkv {
                zzeiq zzeiqVar2 = zzeiqVar;
                try {
                    ((zzfif) zzeiqVar2.zzb).zzv(z);
                    ((zzfif) zzeiqVar2.zzb).zzz(context);
                } catch (zzfho e) {
                    throw new zzdkv(e.getCause());
                }
            }
        }));
        zzdspVarZze.zzd().zzo(new zzcrv((zzfif) zzeiqVar.zzb), this.zzb);
        ((zzekj) zzeiqVar.zzc).zzc(zzdspVarZze.zzm());
        return zzdspVarZze.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        try {
            zzfhh zzfhhVar = zzfgyVar.zza.zza;
            if (zzfhhVar.zzo.zza == 3) {
                ((zzfif) zzeiqVar.zzb).zzr(this.zza, zzfhhVar.zzd, zzfgmVar.zzw.toString(), (zzbtb) zzeiqVar.zzc);
            } else {
                ((zzfif) zzeiqVar.zzb).zzq(this.zza, zzfhhVar.zzd, zzfgmVar.zzw.toString(), (zzbtb) zzeiqVar.zzc);
            }
        } catch (Exception e) {
            zzcec.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzeiqVar.zza)), e);
        }
    }
}
