package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.InputEvent;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcse {
    zzbxy zza;
    zzbxy zzb;
    private final Context zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzeij zze;
    private final zzdtp zzf;
    private final zzgey zzg;
    private final Executor zzh;
    private final ScheduledExecutorService zzi;

    zzcse(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar, zzeij zzeijVar, zzdtp zzdtpVar, zzgey zzgeyVar, zzgey zzgeyVar2, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = zzgVar;
        this.zze = zzeijVar;
        this.zzf = zzdtpVar;
        this.zzg = zzgeyVar;
        this.zzh = zzgeyVar2;
        this.zzi = scheduledExecutorService;
    }

    public static boolean zzh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjM));
    }

    private final ListenableFuture zzi(final String str, @Nullable final InputEvent inputEvent, Random random) {
        final Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        if (!str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjM)) || this.zzd.zzQ()) {
            return zzgen.zzh(str);
        }
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjN), String.valueOf(random.nextInt(Integer.MAX_VALUE)));
        if (inputEvent != null) {
            return zzgen.zzf(zzgen.zzn(zzgee.zzu(this.zze.zza()), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcry
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    return this.zza.zzc(builderBuildUpon, str, inputEvent, (Integer) obj);
                }
            }, this.zzh), Throwable.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcrz
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    return this.zza.zzd(builderBuildUpon, (Throwable) obj);
                }
            }, this.zzg);
        }
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjO), "11");
        return zzgen.zzh(builderBuildUpon.toString());
    }

    public final ListenableFuture zzb(final String str, Random random) {
        return TextUtils.isEmpty(str) ? zzgen.zzh(str) : zzgen.zzf(zzi(str, this.zzf.zza(), random), Throwable.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcrx
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzgen.zzh(str);
            }
        }, this.zzg);
    }

    final /* synthetic */ ListenableFuture zzc(final Uri.Builder builder, String str, InputEvent inputEvent, Integer num) throws Exception {
        if (num.intValue() != 1) {
            builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjO), "10");
            return zzgen.zzh(builder.toString());
        }
        Uri.Builder builderBuildUpon = builder.build().buildUpon();
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjP), "1");
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjO), "12");
        if (str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjQ))) {
            builderBuildUpon.authority((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjR));
        }
        return zzgen.zzn(zzgee.zzu(this.zze.zzb(builderBuildUpon.build(), inputEvent)), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcsa
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjO);
                Uri.Builder builder2 = builder;
                builder2.appendQueryParameter(str2, "12");
                return zzgen.zzh(builder2.toString());
            }
        }, this.zzh);
    }

    final /* synthetic */ ListenableFuture zzd(Uri.Builder builder, final Throwable th) throws Exception {
        this.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcrw
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzf(th);
            }
        });
        builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjO), "9");
        return zzgen.zzh(builder.toString());
    }

    final /* synthetic */ void zzf(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjT)).booleanValue()) {
            zzbxy zzbxyVarZzc = zzbxw.zzc(this.zzc);
            this.zzb = zzbxyVarZzc;
            zzbxyVarZzc.zzg(th, "AttributionReporting");
        } else {
            zzbxy zzbxyVarZza = zzbxw.zza(this.zzc);
            this.zza = zzbxyVarZza;
            zzbxyVarZza.zzg(th, "AttributionReporting");
        }
    }

    public final void zzg(String str, zzfny zzfnyVar, Random random) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzgen.zzr(zzgen.zzo(zzi(str, this.zzf.zza(), random), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjS)).intValue(), TimeUnit.MILLISECONDS, this.zzi), new zzcsd(this, zzfnyVar, str), this.zzg);
    }
}
