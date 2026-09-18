package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzenq implements zzeit {
    private final Context zza;
    private final Executor zzb;
    private final zzdst zzc;

    public zzenq(Context context, Executor executor, zzdst zzdstVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdstVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zze(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) {
        try {
            ((zzfif) zzeiqVar.zzb).zzk(zzfgyVar.zza.zza.zzd, zzfgmVar.zzw.toString());
        } catch (Exception e) {
            zzcec.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzeiqVar.zza)), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, final zzeiq zzeiqVar) throws zzeml, zzfho {
        zzdsp zzdspVarZze = this.zzc.zze(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdsq(new zzdkw() { // from class: com.google.android.gms.internal.ads.zzenm
            @Override // com.google.android.gms.internal.ads.zzdkw
            public final void zza(boolean z, Context context, zzdbk zzdbkVar) throws zzdkv {
                zzeiq zzeiqVar2 = zzeiqVar;
                try {
                    ((zzfif) zzeiqVar2.zzb).zzv(z);
                    ((zzfif) zzeiqVar2.zzb).zzA();
                } catch (zzfho e) {
                    zzcec.zzk("Cannot show rewarded video.", e);
                    throw new zzdkv(e.getCause());
                }
            }
        }));
        zzdspVarZze.zzd().zzo(new zzcrv((zzfif) zzeiqVar.zzb), this.zzb);
        zzdce zzdceVarZze = zzdspVarZze.zze();
        zzdav zzdavVarZzb = zzdspVarZze.zzb();
        ((zzekk) zzeiqVar.zzc).zzc(new zzenp(this, zzdspVarZze.zza(), zzdavVarZzb, zzdceVarZze, zzdspVarZze.zzg()));
        return zzdspVarZze.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        if (((zzfif) zzeiqVar.zzb).zzC()) {
            zze(zzfgyVar, zzfgmVar, zzeiqVar);
            return;
        }
        ((zzekk) zzeiqVar.zzc).zzd(new zzeno(this, zzfgyVar, zzfgmVar, zzeiqVar));
        Object obj = zzeiqVar.zzb;
        Context context = this.zza;
        zzfhh zzfhhVar = zzfgyVar.zza.zza;
        ((zzfif) obj).zzh(context, zzfhhVar.zzd, null, (zzcaf) zzeiqVar.zzc, zzfgmVar.zzw.toString());
    }
}
