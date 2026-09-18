package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzecq {
    private final zzgey zza;
    private final zzebw zzb;
    private final zzhgx zzc;
    private final zzfnc zzd;
    private final Context zze;
    private final zzcei zzf;

    public zzecq(zzgey zzgeyVar, zzebw zzebwVar, zzhgx zzhgxVar, zzfnc zzfncVar, Context context, zzcei zzceiVar) {
        this.zza = zzgeyVar;
        this.zzb = zzebwVar;
        this.zzc = zzhgxVar;
        this.zzd = zzfncVar;
        this.zze = context;
        this.zzf = zzceiVar;
    }

    private final ListenableFuture zzh(final zzbze zzbzeVar, zzecp zzecpVar, final zzecp zzecpVar2, final zzgdu zzgduVar) {
        ListenableFuture listenableFutureZzf;
        String str = zzbzeVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            listenableFutureZzf = zzgen.zzg(new zzecf(1));
        } else {
            listenableFutureZzf = zzgen.zzf(zzecpVar.zza(zzbzeVar), ExecutionException.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeco
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    ExecutionException executionException = (ExecutionException) obj;
                    Throwable cause = executionException.getCause();
                    ExecutionException cause2 = executionException;
                    if (cause != null) {
                        cause2 = executionException.getCause();
                    }
                    return zzgen.zzg(cause2);
                }
            }, this.zza);
        }
        return zzgen.zzf(zzgen.zzn(zzgee.zzu(listenableFutureZzf), zzgduVar, this.zza), zzecf.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzecn
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzecpVar2, zzbzeVar, zzgduVar, (zzecf) obj);
            }
        }, this.zza);
    }

    public final ListenableFuture zza(final zzbze zzbzeVar) {
        zzgdu zzgduVar = new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeck
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                String str = new String(zzgci.zzb((InputStream) obj), zzfwq.zzc);
                zzbze zzbzeVar2 = zzbzeVar;
                zzbzeVar2.zzj = str;
                return zzgen.zzh(zzbzeVar2);
            }
        };
        final zzebw zzebwVar = this.zzb;
        Objects.requireNonNull(zzebwVar);
        return zzh(zzbzeVar, new zzecp() { // from class: com.google.android.gms.internal.ads.zzecl
            @Override // com.google.android.gms.internal.ads.zzecp
            public final ListenableFuture zza(zzbze zzbzeVar2) {
                return zzebwVar.zzb(zzbzeVar2);
            }
        }, new zzecp() { // from class: com.google.android.gms.internal.ads.zzecm
            @Override // com.google.android.gms.internal.ads.zzecp
            public final ListenableFuture zza(zzbze zzbzeVar2) {
                return this.zza.zzd(zzbzeVar2);
            }
        }, zzgduVar);
    }

    public final ListenableFuture zzb(JSONObject jSONObject) {
        return zzgen.zzn(zzgee.zzu(zzgen.zzh(jSONObject)), com.google.android.gms.ads.internal.zzt.zzf().zza(this.zze, this.zzf, this.zzd).zza("AFMA_getAdDictionary", zzbru.zza, new zzbrp() { // from class: com.google.android.gms.internal.ads.zzecg
            @Override // com.google.android.gms.internal.ads.zzbrp
            public final Object zza(JSONObject jSONObject2) {
                return new zzbzh(jSONObject2);
            }
        }), this.zza);
    }

    final /* synthetic */ ListenableFuture zzc(zzecp zzecpVar, zzbze zzbzeVar, zzgdu zzgduVar, zzecf zzecfVar) throws Exception {
        return zzgen.zzn(zzecpVar.zza(zzbzeVar), zzgduVar, this.zza);
    }

    final /* synthetic */ ListenableFuture zzd(zzbze zzbzeVar) {
        return ((zzeem) this.zzc.zzb()).zzb(zzbzeVar, Binder.getCallingUid());
    }

    final /* synthetic */ ListenableFuture zze(zzbze zzbzeVar) {
        return this.zzb.zzc(zzbzeVar.zzh);
    }

    final /* synthetic */ ListenableFuture zzf(zzbze zzbzeVar) {
        return ((zzeem) this.zzc.zzb()).zzi(zzbzeVar.zzh);
    }

    public final ListenableFuture zzg(zzbze zzbzeVar) {
        return zzh(zzbzeVar, new zzecp() { // from class: com.google.android.gms.internal.ads.zzeci
            @Override // com.google.android.gms.internal.ads.zzecp
            public final ListenableFuture zza(zzbze zzbzeVar2) {
                return this.zza.zze(zzbzeVar2);
            }
        }, new zzecp() { // from class: com.google.android.gms.internal.ads.zzecj
            @Override // com.google.android.gms.internal.ads.zzecp
            public final ListenableFuture zza(zzbze zzbzeVar2) {
                return this.zza.zzf(zzbzeVar2);
            }
        }, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzech
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzgen.zzh(null);
            }
        });
    }
}
