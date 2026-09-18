package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzevn implements zzexq {
    private final zzgey zza;
    private final zzfhh zzb;
    private final PackageInfo zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;

    public zzevn(zzgey zzgeyVar, zzfhh zzfhhVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgeyVar;
        this.zzb = zzfhhVar;
        this.zzc = packageInfo;
        this.zzd = zzgVar;
    }

    public static /* synthetic */ zzevo zzc(final zzevn zzevnVar) {
        final ArrayList arrayList = zzevnVar.zzb.zzg;
        if (arrayList == null) {
            return new zzevo() { // from class: com.google.android.gms.internal.ads.zzevk
                @Override // com.google.android.gms.internal.ads.zzexp
                public final void zzj(Object obj) {
                }
            };
        }
        return arrayList.isEmpty() ? new zzevo() { // from class: com.google.android.gms.internal.ads.zzevl
            @Override // com.google.android.gms.internal.ads.zzexp
            public final void zzj(Object obj) {
                ((Bundle) obj).putInt("native_version", 0);
            }
        } : new zzevo() { // from class: com.google.android.gms.internal.ads.zzevm
            @Override // com.google.android.gms.internal.ads.zzexp
            public final void zzj(Object obj) {
                this.zza.zzd(arrayList, (Bundle) obj);
            }
        };
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 26;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzevj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzevn.zzc(this.zza);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:63:0x011b  */
    final /* synthetic */ void zzd(ArrayList arrayList, Bundle bundle) {
        JSONArray jSONArrayOptJSONArray;
        String str;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", this.zzb.zzh);
        String str2 = "landscape";
        if (this.zzb.zzi.zza > 3) {
            bundle.putBoolean("enable_native_media_orientation", true);
            int i = this.zzb.zzi.zzh;
            if (i == 1) {
                str = "any";
            } else if (i == 2) {
                str = "landscape";
            } else if (i != 3) {
                str = i != 4 ? EnvironmentCompat.MEDIA_UNKNOWN : "square";
            } else {
                str = "portrait";
            }
            if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(str)) {
                bundle.putString("native_media_orientation", str);
            }
        }
        int i2 = this.zzb.zzi.zzc;
        if (i2 == 0) {
            str2 = "any";
        } else if (i2 == 1) {
            str2 = "portrait";
        } else if (i2 != 2) {
            str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(str2)) {
            bundle.putString("native_image_orientation", str2);
        }
        bundle.putBoolean("native_multiple_images", this.zzb.zzi.zzd);
        bundle.putBoolean("use_custom_mute", this.zzb.zzi.zzg);
        zzbjb zzbjbVar = this.zzb.zzi;
        if (zzbjbVar.zzi != 0) {
            bundle.putBoolean("sccg_tap", zzbjbVar.zzj);
            bundle.putInt("sccg_dir", this.zzb.zzi.zzi);
        }
        PackageInfo packageInfo = this.zzc;
        int i3 = packageInfo == null ? 0 : packageInfo.versionCode;
        if (i3 > this.zzd.zza()) {
            this.zzd.zzs();
            this.zzd.zzv(i3);
        }
        JSONObject jSONObjectZzp = this.zzd.zzp();
        String string = null;
        if (jSONObjectZzp != null && (jSONArrayOptJSONArray = jSONObjectZzp.optJSONArray(this.zzb.zzf)) != null) {
            string = jSONArrayOptJSONArray.toString();
        }
        if (!TextUtils.isEmpty(string)) {
            bundle.putString("native_advanced_settings", string);
        }
        int i4 = this.zzb.zzk;
        if (i4 > 1) {
            bundle.putInt("max_num_ads", i4);
        }
        zzbpp zzbppVar = this.zzb.zzb;
        if (zzbppVar != null) {
            if (TextUtils.isEmpty(zzbppVar.zzc)) {
                String str3 = "p";
                if (zzbppVar.zza >= 2) {
                    int i5 = zzbppVar.zzd;
                    if (i5 == 2 || i5 != 3) {
                        str3 = "l";
                    }
                } else {
                    int i6 = zzbppVar.zzb;
                    if (i6 == 1) {
                        str3 = "l";
                    } else if (i6 != 2) {
                        zzcec.zzg("Instream ad video aspect ratio " + i6 + " is wrong.");
                        str3 = "l";
                    }
                }
                bundle.putString("ia_var", str3);
            } else {
                bundle.putString("ad_tag", zzbppVar.zzc);
            }
            bundle.putBoolean("instr", true);
        }
        if (this.zzb.zza() != null) {
            bundle.putBoolean("has_delayed_banner_listener", true);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlj)).booleanValue()) {
            if (this.zzb.zzi.zzf != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("startMuted", this.zzb.zzi.zzf.zza);
                bundle2.putBoolean("clickToExpandRequested", this.zzb.zzi.zzf.zzc);
                bundle2.putBoolean("customControlsRequested", this.zzb.zzi.zzf.zzb);
                bundle.putBundle("video", bundle2);
            }
            bundle.putBoolean("disable_image_loading", this.zzb.zzi.zzb);
            bundle.putInt("preferred_ad_choices_position", this.zzb.zzi.zze);
        }
    }
}
