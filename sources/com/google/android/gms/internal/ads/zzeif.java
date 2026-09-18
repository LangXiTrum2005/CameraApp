package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeif implements zzeig {
    static /* synthetic */ zzfod zzc(String str, String str2, String str3, zzeih zzeihVar, String str4, WebView webView, String str5, String str6, zzeii zzeiiVar) {
        zzfon zzfonVarZza = zzfon.zza("Google", str2);
        zzfom zzfomVarZzm = zzm("javascript");
        zzfoi zzfoiVarZzk = zzk(zzeihVar.toString());
        if (zzfomVarZzm == zzfom.NONE) {
            zzcec.zzj("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzfoiVarZzk == null) {
            zzcec.zzj("Omid html session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzeihVar))));
            return null;
        }
        zzfom zzfomVarZzm2 = zzm(str4);
        if (zzfoiVarZzk == zzfoi.VIDEO && zzfomVarZzm2 == zzfom.NONE) {
            zzcec.zzj("Omid html session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        }
        return zzfod.zza(zzfoe.zza(zzfoiVarZzk, zzl(zzeiiVar.toString()), zzfomVarZzm, zzfomVarZzm2, true), zzfof.zzb(zzfonVarZza, webView, str5, ""));
    }

    static /* synthetic */ zzfod zzd(String str, String str2, String str3, String str4, zzeih zzeihVar, WebView webView, String str5, String str6, zzeii zzeiiVar) {
        zzfon zzfonVarZza = zzfon.zza(str, str2);
        zzfom zzfomVarZzm = zzm("javascript");
        zzfom zzfomVarZzm2 = zzm(str4);
        zzfoi zzfoiVarZzk = zzk(zzeihVar.toString());
        if (zzfomVarZzm == zzfom.NONE) {
            zzcec.zzj("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzfoiVarZzk == null) {
            zzcec.zzj("Omid js session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzeihVar))));
            return null;
        }
        if (zzfoiVarZzk == zzfoi.VIDEO && zzfomVarZzm2 == zzfom.NONE) {
            zzcec.zzj("Omid js session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        }
        return zzfod.zza(zzfoe.zza(zzfoiVarZzk, zzl(zzeiiVar.toString()), zzfomVarZzm, zzfomVarZzm2, true), zzfof.zzc(zzfonVarZza, webView, str5, ""));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    private static zzfoi zzk(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -382745961) {
            if (iHashCode != 112202875) {
                if (iHashCode == 714893483 && str.equals("nativeDisplay")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (str.equals("video")) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (str.equals("htmlDisplay")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            return zzfoi.HTML_DISPLAY;
        }
        if (b == 1) {
            return zzfoi.NATIVE_DISPLAY;
        }
        if (b != 2) {
            return null;
        }
        return zzfoi.VIDEO;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    private static zzfol zzl(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1104128070) {
            if (iHashCode != 1318088141) {
                if (iHashCode == 1988248512 && str.equals("onePixel")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("definedByJavascript")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("beginToRender")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            return zzfol.BEGIN_TO_RENDER;
        }
        if (b != 1) {
            return b != 2 ? zzfol.UNSPECIFIED : zzfol.ONE_PIXEL;
        }
        return zzfol.DEFINED_BY_JAVASCRIPT;
    }

    private static zzfom zzm(String str) {
        if ("native".equals(str)) {
            return zzfom.NATIVE;
        }
        return "javascript".equals(str) ? zzfom.JAVASCRIPT : zzfom.NONE;
    }

    private static final Object zzn(zzeie zzeieVar) {
        try {
            return zzeieVar.zza();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzv(e, "omid exception");
            return null;
        }
    }

    private static final void zzo(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzv(e, "omid exception");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final zzfod zza(final String str, final WebView webView, String str2, String str3, final String str4, final zzeii zzeiiVar, final zzeih zzeihVar, final String str5) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() || !zzfob.zzb()) {
            return null;
        }
        final String str6 = "javascript";
        final String str7 = "Google";
        final String str8 = "";
        return (zzfod) zzn(new zzeie(str7, str, str6, zzeihVar, str4, webView, str5, str8, zzeiiVar) { // from class: com.google.android.gms.internal.ads.zzeib
            public final /* synthetic */ String zzb;
            public final /* synthetic */ zzeih zzd;
            public final /* synthetic */ String zze;
            public final /* synthetic */ WebView zzf;
            public final /* synthetic */ String zzg;
            public final /* synthetic */ zzeii zzi;
            public final /* synthetic */ String zza = "Google";
            public final /* synthetic */ String zzc = "javascript";
            public final /* synthetic */ String zzh = "";

            {
                this.zzb = str;
                this.zzd = zzeihVar;
                this.zze = str4;
                this.zzf = webView;
                this.zzg = str5;
                this.zzi = zzeiiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzeie
            public final Object zza() {
                return zzeif.zzc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final zzfod zzb(final String str, final WebView webView, String str2, String str3, final String str4, final String str5, final zzeii zzeiiVar, final zzeih zzeihVar, final String str6) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() || !zzfob.zzb()) {
            return null;
        }
        final String str7 = "";
        final String str8 = "javascript";
        return (zzfod) zzn(new zzeie(str5, str, str8, str4, zzeihVar, webView, str6, str7, zzeiiVar) { // from class: com.google.android.gms.internal.ads.zzehy
            public final /* synthetic */ String zza;
            public final /* synthetic */ String zzb;
            public final /* synthetic */ String zzd;
            public final /* synthetic */ zzeih zze;
            public final /* synthetic */ WebView zzf;
            public final /* synthetic */ String zzg;
            public final /* synthetic */ zzeii zzi;
            public final /* synthetic */ String zzc = "javascript";
            public final /* synthetic */ String zzh = "";

            {
                this.zzd = str4;
                this.zze = zzeihVar;
                this.zzf = webView;
                this.zzg = str6;
                this.zzi = zzeiiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzeie
            public final Object zza() {
                return zzeif.zzd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final String zze(Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue()) {
            return (String) zzn(new zzeie() { // from class: com.google.android.gms.internal.ads.zzeic
                @Override // com.google.android.gms.internal.ads.zzeie
                public final Object zza() {
                    return "a.1.4.8-google_20230803";
                }
            });
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final void zzf(final zzfod zzfodVar, final View view) {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehw
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() && zzfob.zzb()) {
                    zzfodVar.zzb(view, zzfok.NOT_VISIBLE, "Ad overlay");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final void zzg(final zzfod zzfodVar) {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeid
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() && zzfob.zzb()) {
                    zzfodVar.zzc();
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final void zzh(final zzfod zzfodVar, final View view) {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehx
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() && zzfob.zzb()) {
                    zzfodVar.zzd(view);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final void zzi(final zzfod zzfodVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() && zzfob.zzb()) {
            Objects.requireNonNull(zzfodVar);
            zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehz
                @Override // java.lang.Runnable
                public final void run() {
                    zzfodVar.zze();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final boolean zzj(final Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue()) {
            Boolean bool = (Boolean) zzn(new zzeie() { // from class: com.google.android.gms.internal.ads.zzeia
                @Override // com.google.android.gms.internal.ads.zzeie
                public final Object zza() {
                    if (zzfob.zzb()) {
                        return true;
                    }
                    zzfob.zza(context);
                    return Boolean.valueOf(zzfob.zzb());
                }
            });
            return bool != null && bool.booleanValue();
        }
        zzcec.zzj("Omid flag is disabled");
        return false;
    }
}
