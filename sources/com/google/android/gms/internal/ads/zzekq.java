package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzekq implements zzein {
    private final Context zza;
    private final zzdtk zzb;
    private final zzdko zzc;
    private final zzfhh zzd;
    private final Executor zze;
    private final zzcei zzf;
    private final zzbni zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziM)).booleanValue();
    private final zzehs zzi;

    public zzekq(Context context, zzcei zzceiVar, zzfhh zzfhhVar, Executor executor, zzdko zzdkoVar, zzdtk zzdtkVar, zzbni zzbniVar, zzehs zzehsVar) {
        this.zza = context;
        this.zzd = zzfhhVar;
        this.zzc = zzdkoVar;
        this.zze = executor;
        this.zzf = zzceiVar;
        this.zzb = zzdtkVar;
        this.zzg = zzbniVar;
        this.zzi = zzehsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final ListenableFuture zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar) {
        final zzdto zzdtoVar = new zzdto();
        ListenableFuture listenableFutureZzn = zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzekn
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzfgmVar, zzfgyVar, zzdtoVar, obj);
            }
        }, this.zze);
        listenableFutureZzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeko
            @Override // java.lang.Runnable
            public final void run() {
                zzdtoVar.zzb();
            }
        }, this.zze);
        return listenableFutureZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        zzfgr zzfgrVar = zzfgmVar.zzt;
        return (zzfgrVar == null || zzfgrVar.zza == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ ListenableFuture zzc(final zzfgm zzfgmVar, zzfgy zzfgyVar, zzdto zzdtoVar, Object obj) throws Exception {
        final zzcjk zzcjkVarZza = this.zzb.zza(this.zzd.zze, zzfgmVar, zzfgyVar.zzb.zzb);
        zzcjkVarZza.zzaa(zzfgmVar.zzX);
        zzdtoVar.zza(this.zza, (View) zzcjkVarZza);
        zzceu zzceuVar = new zzceu();
        final zzdjo zzdjoVarZze = this.zzc.zze(new zzcwx(zzfgyVar, zzfgmVar, null), new zzdjr(new zzekp(this.zza, this.zzf, zzceuVar, zzfgmVar, zzcjkVarZza, this.zzd, this.zzh, this.zzg, this.zzi), zzcjkVarZza));
        zzceuVar.zzc(zzdjoVarZze);
        zzdjoVarZze.zzc().zzo(new zzdbr() { // from class: com.google.android.gms.internal.ads.zzekl
            @Override // com.google.android.gms.internal.ads.zzdbr
            public final void zzq() {
                zzcjk zzcjkVar = zzcjkVarZza;
                if (zzcjkVar.zzN() != null) {
                    zzcjkVar.zzN().zzr();
                }
            }
        }, zzcep.zzf);
        zzdjoVarZze.zzk().zzi(zzcjkVarZza, true, this.zzh ? this.zzg : null);
        zzdjoVarZze.zzk();
        zzfgr zzfgrVar = zzfgmVar.zzt;
        return zzgen.zzm(zzdtj.zzj(zzcjkVarZza, zzfgrVar.zzb, zzfgrVar.zza), new zzfws() { // from class: com.google.android.gms.internal.ads.zzekm
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj2) {
                zzcjk zzcjkVar = zzcjkVarZza;
                if (zzfgmVar.zzN) {
                    zzcjkVar.zzaf();
                }
                zzdjo zzdjoVar = zzdjoVarZze;
                zzcjkVar.zzZ();
                zzcjkVar.onPause();
                return zzdjoVar.zzg();
            }
        }, this.zze);
    }
}
