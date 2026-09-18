package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqv {
    private final zzfhh zza;
    private final Executor zzb;
    private final zzdtk zzc;
    private final zzdsf zzd;
    private final Context zze;
    private final zzdwf zzf;
    private final zzflw zzg;
    private final zzfny zzh;
    private final zzehh zzi;

    public zzdqv(zzfhh zzfhhVar, Executor executor, zzdtk zzdtkVar, Context context, zzdwf zzdwfVar, zzflw zzflwVar, zzfny zzfnyVar, zzehh zzehhVar, zzdsf zzdsfVar) {
        this.zza = zzfhhVar;
        this.zzb = executor;
        this.zzc = zzdtkVar;
        this.zze = context;
        this.zzf = zzdwfVar;
        this.zzg = zzflwVar;
        this.zzh = zzfnyVar;
        this.zzi = zzehhVar;
        this.zzd = zzdsfVar;
    }

    private final void zzh(zzcjk zzcjkVar) {
        zzj(zzcjkVar);
        zzcjkVar.zzae("/video", zzbnf.zzl);
        zzcjkVar.zzae("/videoMeta", zzbnf.zzm);
        zzcjkVar.zzae("/precache", new zzchx());
        zzcjkVar.zzae("/delayPageLoaded", zzbnf.zzp);
        zzcjkVar.zzae("/instrument", zzbnf.zzn);
        zzcjkVar.zzae("/log", zzbnf.zzg);
        zzcjkVar.zzae("/click", new zzbme(null, 0 == true ? 1 : 0));
        if (this.zza.zzb != null) {
            zzcjkVar.zzN().zzE(true);
            zzcjkVar.zzae("/open", new zzbnr(null, null, null, null, null, null));
        } else {
            zzcjkVar.zzN().zzE(false);
        }
        if (com.google.android.gms.ads.internal.zzt.zzn().zzp(zzcjkVar.getContext())) {
            zzcjkVar.zzae("/logScionEvent", new zzbnl(zzcjkVar.getContext()));
        }
    }

    private final void zzi(zzcjk zzcjkVar, zzcet zzcetVar) {
        if (this.zza.zza != null && zzcjkVar.zzq() != null) {
            zzcjkVar.zzq().zzs(this.zza.zza);
        }
        zzcetVar.zzb();
    }

    private static final void zzj(zzcjk zzcjkVar) {
        zzcjkVar.zzae("/videoClicked", zzbnf.zzh);
        zzcjkVar.zzN().zzG(true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdF)).booleanValue()) {
            zzcjkVar.zzae("/getNativeAdViewSignals", zzbnf.zzs);
        }
        zzcjkVar.zzae("/getNativeClickMeta", zzbnf.zzt);
    }

    public final ListenableFuture zza(final JSONObject jSONObject) {
        return zzgen.zzn(zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdqm
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zze(obj);
            }
        }, this.zzb), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdql
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(jSONObject, (zzcjk) obj);
            }
        }, this.zzb);
    }

    public final ListenableFuture zzb(final String str, final String str2, final zzfgm zzfgmVar, final zzfgp zzfgpVar, final com.google.android.gms.ads.internal.client.zzq zzqVar) {
        return zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdqk
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzd(zzqVar, zzfgmVar, zzfgpVar, str, str2, obj);
            }
        }, this.zzb);
    }

    final /* synthetic */ ListenableFuture zzc(JSONObject jSONObject, final zzcjk zzcjkVar) throws Exception {
        final zzcet zzcetVarZza = zzcet.zza(zzcjkVar);
        if (this.zza.zzb != null) {
            zzcjkVar.zzah(zzcla.zzd());
        } else {
            zzcjkVar.zzah(zzcla.zze());
        }
        zzcjkVar.zzN().zzB(new zzckw() { // from class: com.google.android.gms.internal.ads.zzdqn
            @Override // com.google.android.gms.internal.ads.zzckw
            public final void zza(boolean z, int i, String str, String str2) {
                this.zza.zzf(zzcjkVar, zzcetVarZza, z, i, str, str2);
            }
        });
        zzcjkVar.zzl("google.afma.nativeAds.renderVideo", jSONObject);
        return zzcetVarZza;
    }

    final /* synthetic */ ListenableFuture zzd(com.google.android.gms.ads.internal.client.zzq zzqVar, zzfgm zzfgmVar, zzfgp zzfgpVar, String str, String str2, Object obj) throws Exception {
        final zzcjk zzcjkVarZza = this.zzc.zza(zzqVar, zzfgmVar, zzfgpVar);
        final zzcet zzcetVarZza = zzcet.zza(zzcjkVarZza);
        if (this.zza.zzb != null) {
            zzh(zzcjkVarZza);
            zzcjkVarZza.zzah(zzcla.zzd());
        } else {
            zzdsc zzdscVarZzb = this.zzd.zzb();
            zzcjkVarZza.zzN().zzN(zzdscVarZzb, zzdscVarZzb, zzdscVarZzb, zzdscVarZzb, zzdscVarZzb, false, null, new com.google.android.gms.ads.internal.zzb(this.zze, null, null), null, null, this.zzi, this.zzh, this.zzf, this.zzg, null, zzdscVarZzb, null, null, null);
            zzj(zzcjkVarZza);
        }
        zzcjkVarZza.zzN().zzB(new zzckw() { // from class: com.google.android.gms.internal.ads.zzdqo
            @Override // com.google.android.gms.internal.ads.zzckw
            public final void zza(boolean z, int i, String str3, String str4) {
                this.zza.zzg(zzcjkVarZza, zzcetVarZza, z, i, str3, str4);
            }
        });
        zzcjkVarZza.zzac(str, str2, null);
        return zzcetVarZza;
    }

    final /* synthetic */ ListenableFuture zze(Object obj) throws Exception {
        zzcjk zzcjkVarZza = this.zzc.zza(com.google.android.gms.ads.internal.client.zzq.zzc(), null, null);
        final zzcet zzcetVarZza = zzcet.zza(zzcjkVarZza);
        zzh(zzcjkVarZza);
        zzcjkVarZza.zzN().zzH(new zzckx() { // from class: com.google.android.gms.internal.ads.zzdqp
            @Override // com.google.android.gms.internal.ads.zzckx
            public final void zza() {
                zzcetVarZza.zzb();
            }
        });
        zzcjkVarZza.loadUrl((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdE));
        return zzcetVarZza;
    }

    final /* synthetic */ void zzf(zzcjk zzcjkVar, zzcet zzcetVar, boolean z, int i, String str, String str2) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdP)).booleanValue()) {
            zzi(zzcjkVar, zzcetVar);
            return;
        }
        if (z) {
            zzi(zzcjkVar, zzcetVar);
            return;
        }
        zzcetVar.zzd(new zzeml(1, "Native Video WebView failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }

    final /* synthetic */ void zzg(zzcjk zzcjkVar, zzcet zzcetVar, boolean z, int i, String str, String str2) {
        if (z) {
            if (this.zza.zza != null && zzcjkVar.zzq() != null) {
                zzcjkVar.zzq().zzs(this.zza.zza);
            }
            zzcetVar.zzb();
            return;
        }
        zzcetVar.zzd(new zzeml(1, "Html video Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
