package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdrz {
    private final com.google.android.gms.ads.internal.zza zzb;
    private final zzcjx zzc;
    private final Context zzd;
    private final zzdwf zze;
    private final zzflw zzf;
    private final Executor zzg;
    private final zzavi zzh;
    private final zzcei zzi;
    private final zzehh zzk;
    private final zzfny zzl;
    private final zzehs zzm;
    private final zzfhl zzn;
    private ListenableFuture zzo;
    private final zzdrm zza = new zzdrm();
    private final zzbnv zzj = new zzbnv();

    zzdrz(zzdrw zzdrwVar) {
        this.zzd = zzdrwVar.zzc;
        this.zzg = zzdrwVar.zzg;
        this.zzh = zzdrwVar.zzh;
        this.zzi = zzdrwVar.zzi;
        this.zzb = zzdrwVar.zza;
        this.zzc = zzdrwVar.zzb;
        this.zzk = zzdrwVar.zzf;
        this.zzl = zzdrwVar.zzj;
        this.zze = zzdrwVar.zzd;
        this.zzf = zzdrwVar.zze;
        this.zzm = zzdrwVar.zzk;
        this.zzn = zzdrwVar.zzl;
    }

    final /* synthetic */ zzcjk zza(zzcjk zzcjkVar) {
        zzcjkVar.zzae("/result", this.zzj);
        zzcky zzckyVarZzN = zzcjkVar.zzN();
        com.google.android.gms.ads.internal.zzb zzbVar = new com.google.android.gms.ads.internal.zzb(this.zzd, null, null);
        zzehh zzehhVar = this.zzk;
        zzfny zzfnyVar = this.zzl;
        zzdwf zzdwfVar = this.zze;
        zzflw zzflwVar = this.zzf;
        zzdrm zzdrmVar = this.zza;
        zzckyVarZzN.zzN(null, zzdrmVar, zzdrmVar, zzdrmVar, zzdrmVar, false, null, zzbVar, null, null, zzehhVar, zzfnyVar, zzdwfVar, zzflwVar, null, null, null, null, null);
        return zzcjkVar;
    }

    final /* synthetic */ ListenableFuture zzc(String str, JSONObject jSONObject, zzcjk zzcjkVar) throws Exception {
        return this.zzj.zzb(zzcjkVar, str, jSONObject);
    }

    public final synchronized ListenableFuture zzd(final String str, final JSONObject jSONObject) {
        ListenableFuture listenableFuture = this.zzo;
        if (listenableFuture == null) {
            return zzgen.zzh(null);
        }
        return zzgen.zzn(listenableFuture, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdrn
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(str, jSONObject, (zzcjk) obj);
            }
        }, this.zzg);
    }

    public final synchronized void zze(zzfgm zzfgmVar, zzfgp zzfgpVar) {
        ListenableFuture listenableFuture = this.zzo;
        if (listenableFuture == null) {
            return;
        }
        zzgen.zzr(listenableFuture, new zzdrt(this, zzfgmVar, zzfgpVar), this.zzg);
    }

    public final synchronized void zzf() {
        ListenableFuture listenableFuture = this.zzo;
        if (listenableFuture == null) {
            return;
        }
        zzgen.zzr(listenableFuture, new zzdrp(this), this.zzg);
        this.zzo = null;
    }

    public final synchronized void zzg(String str, Map map) {
        ListenableFuture listenableFuture = this.zzo;
        if (listenableFuture == null) {
            return;
        }
        zzgen.zzr(listenableFuture, new zzdrs(this, "sendMessageToNativeJs", map), this.zzg);
    }

    public final synchronized void zzh() {
        final String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdD);
        final Context context = this.zzd;
        final zzavi zzaviVar = this.zzh;
        final zzcei zzceiVar = this.zzi;
        final com.google.android.gms.ads.internal.zza zzaVar = this.zzb;
        final zzehs zzehsVar = this.zzm;
        final zzfhl zzfhlVar = this.zzn;
        ListenableFuture listenableFutureZzm = zzgen.zzm(zzgen.zzk(new zzgdt() { // from class: com.google.android.gms.internal.ads.zzcjv
            @Override // com.google.android.gms.internal.ads.zzgdt
            public final ListenableFuture zza() throws zzcjw {
                com.google.android.gms.ads.internal.zzt.zzz();
                Context context2 = context;
                zzcla zzclaVarZza = zzcla.zza();
                zzavi zzaviVar2 = zzaviVar;
                zzehs zzehsVar2 = zzehsVar;
                com.google.android.gms.ads.internal.zza zzaVar2 = zzaVar;
                zzcjk zzcjkVarZza = zzcjx.zza(context2, zzclaVarZza, "", false, false, zzaviVar2, null, zzceiVar, null, null, zzaVar2, zzbbp.zza(), null, null, zzehsVar2, zzfhlVar);
                final zzcet zzcetVarZza = zzcet.zza(zzcjkVarZza);
                zzcjkVarZza.zzN().zzB(new zzckw() { // from class: com.google.android.gms.internal.ads.zzcju
                    @Override // com.google.android.gms.internal.ads.zzckw
                    public final void zza(boolean z, int i, String str2, String str3) {
                        zzcetVarZza.zzb();
                    }
                });
                zzcjkVarZza.loadUrl(str);
                return zzcetVarZza;
            }
        }, zzcep.zze), new zzfws() { // from class: com.google.android.gms.internal.ads.zzdro
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                zzcjk zzcjkVar = (zzcjk) obj;
                this.zza.zza(zzcjkVar);
                return zzcjkVar;
            }
        }, this.zzg);
        this.zzo = listenableFutureZzm;
        zzces.zza(listenableFutureZzm, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzi(String str, zzbng zzbngVar) {
        ListenableFuture listenableFuture = this.zzo;
        if (listenableFuture == null) {
            return;
        }
        zzgen.zzr(listenableFuture, new zzdrq(this, str, zzbngVar), this.zzg);
    }

    public final void zzj(WeakReference weakReference, String str, zzbng zzbngVar) {
        zzi(str, new zzdry(this, weakReference, str, zzbngVar, null));
    }

    public final synchronized void zzk(String str, zzbng zzbngVar) {
        ListenableFuture listenableFuture = this.zzo;
        if (listenableFuture == null) {
            return;
        }
        zzgen.zzr(listenableFuture, new zzdrr(this, str, zzbngVar), this.zzg);
    }
}
