package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzelj implements zzeit {
    private final Context zza;
    private final zzdlk zzb;
    private final Executor zzc;

    public zzelj(Context context, zzdlk zzdlkVar, Executor executor) {
        this.zza = context;
        this.zzb = zzdlkVar;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfgy zzfgyVar, int i) {
        return zzfgyVar.zza.zza.zzg.contains(Integer.toString(i));
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzeml, zzfho {
        zzdna zzdnaVarZzah;
        zzbtg zzbtgVarZzD = ((zzfif) zzeiqVar.zzb).zzD();
        zzbth zzbthVarZzE = ((zzfif) zzeiqVar.zzb).zzE();
        zzbtk zzbtkVarZzd = ((zzfif) zzeiqVar.zzb).zzd();
        if (zzbtkVarZzd != null && zzc(zzfgyVar, 6)) {
            zzdnaVarZzah = zzdna.zzt(zzbtkVarZzd);
        } else if (zzbtgVarZzD != null && zzc(zzfgyVar, 6)) {
            zzdnaVarZzah = zzdna.zzai(zzbtgVarZzD);
        } else if (zzbtgVarZzD != null && zzc(zzfgyVar, 2)) {
            zzdnaVarZzah = zzdna.zzag(zzbtgVarZzD);
        } else if (zzbthVarZzE != null && zzc(zzfgyVar, 6)) {
            zzdnaVarZzah = zzdna.zzaj(zzbthVarZzE);
        } else {
            if (zzbthVarZzE == null || !zzc(zzfgyVar, 1)) {
                throw new zzeml(1, "No native ad mappers");
            }
            zzdnaVarZzah = zzdna.zzah(zzbthVarZzE);
        }
        zzfhh zzfhhVar = zzfgyVar.zza.zza;
        if (!zzfhhVar.zzg.contains(Integer.toString(zzdnaVarZzah.zzc()))) {
            throw new zzeml(1, "No corresponding native ad listener");
        }
        zzdnc zzdncVarZze = this.zzb.zze(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdnm(zzdnaVarZzah), new zzdpd(zzbthVarZzE, zzbtgVarZzD, zzbtkVarZzd));
        ((zzekj) zzeiqVar.zzc).zzc(zzdncVarZze.zzj());
        zzdncVarZze.zzd().zzo(new zzcrv((zzfif) zzeiqVar.zzb), this.zzc);
        return zzdncVarZze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        zzfif zzfifVar = (zzfif) zzeiqVar.zzb;
        zzfhh zzfhhVar = zzfgyVar.zza.zza;
        String string = zzfgmVar.zzw.toString();
        String strZzl = com.google.android.gms.ads.internal.util.zzbw.zzl(zzfgmVar.zzt);
        zzbtb zzbtbVar = (zzbtb) zzeiqVar.zzc;
        zzfhh zzfhhVar2 = zzfgyVar.zza.zza;
        zzfifVar.zzp(this.zza, zzfhhVar.zzd, string, strZzl, zzbtbVar, zzfhhVar2.zzi, zzfhhVar2.zzg);
    }
}
