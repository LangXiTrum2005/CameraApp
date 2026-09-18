package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.JsonReader;
import com.google.android.gms.ads.RequestConfiguration;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdxm extends zzbog {
    private final zzdxp zza;
    private final zzdxk zzb;
    private final Map zzc = new HashMap();

    zzdxm(zzdxp zzdxpVar, zzdxk zzdxkVar) {
        this.zza = zzdxpVar;
        this.zzb = zzdxkVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x0081  */
    private static com.google.android.gms.ads.internal.client.zzl zzc(Map map) {
        com.google.android.gms.ads.internal.client.zzm zzmVar = new com.google.android.gms.ads.internal.client.zzm();
        String str = (String) map.get("ad_request");
        if (str == null) {
            return zzmVar.zza();
        }
        JsonReader jsonReader = new JsonReader(new StringReader(Uri.decode(str)));
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "extras":
                        jsonReader.beginObject();
                        Bundle bundle = new Bundle();
                        while (jsonReader.hasNext()) {
                            bundle.putString(jsonReader.nextName(), jsonReader.nextString());
                        }
                        jsonReader.endObject();
                        zzmVar.zzb(bundle);
                        break;
                    case "keywords":
                        jsonReader.beginArray();
                        ArrayList arrayList = new ArrayList();
                        while (jsonReader.hasNext()) {
                            arrayList.add(jsonReader.nextString());
                        }
                        jsonReader.endArray();
                        zzmVar.zze(arrayList);
                        break;
                    case "isTestDevice":
                        zzmVar.zzd(jsonReader.nextBoolean());
                        break;
                    case "tagForChildDirectedTreatment":
                        if (!jsonReader.nextBoolean()) {
                            zzmVar.zzg(0);
                            break;
                        } else {
                            zzmVar.zzg(1);
                            break;
                        }
                        break;
                    case "tagForUnderAgeOfConsent":
                        if (!jsonReader.nextBoolean()) {
                            zzmVar.zzh(0);
                            break;
                        } else {
                            zzmVar.zzh(1);
                            break;
                        }
                        break;
                    case "maxAdContentRating":
                        String strNextString = jsonReader.nextString();
                        if (!RequestConfiguration.zza.contains(strNextString)) {
                            break;
                        } else {
                            zzmVar.zzf(strNextString);
                            break;
                        }
                        break;
                    case "httpTimeoutMillis":
                        zzmVar.zzc(jsonReader.nextInt());
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (IOException unused) {
            zzcec.zze("Ad Request json was malformed, parsing ended early.");
        }
        com.google.android.gms.ads.internal.client.zzl zzlVarZza = zzmVar.zza();
        Bundle bundle2 = zzlVarZza.zzm.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle2 == null) {
            bundle2 = zzlVarZza.zzc;
            zzlVarZza.zzm.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundle2);
        }
        return new com.google.android.gms.ads.internal.client.zzl(zzlVarZza.zza, zzlVarZza.zzb, bundle2, zzlVarZza.zzd, zzlVarZza.zze, zzlVarZza.zzf, zzlVarZza.zzg, zzlVarZza.zzh, zzlVarZza.zzi, zzlVarZza.zzj, zzlVarZza.zzk, zzlVarZza.zzl, zzlVarZza.zzm, zzlVarZza.zzn, zzlVarZza.zzo, zzlVarZza.zzp, zzlVarZza.zzq, zzlVarZza.zzr, zzlVarZza.zzs, zzlVarZza.zzt, zzlVarZza.zzu, zzlVarZza.zzv, zzlVarZza.zzw, zzlVarZza.zzx, zzlVarZza.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzboh
    public final void zze() {
        this.zzc.clear();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    @Override // com.google.android.gms.internal.ads.zzboh
    public final void zzf(String str) throws RemoteException {
        byte b;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjF)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received H5 gmsg: ".concat(String.valueOf(str)));
            Uri uri = Uri.parse(str);
            com.google.android.gms.ads.internal.zzt.zzp();
            Map mapZzO = com.google.android.gms.ads.internal.util.zzt.zzO(uri);
            String str2 = (String) mapZzO.get("action");
            if (TextUtils.isEmpty(str2)) {
                zzcec.zze("H5 gmsg did not contain an action");
                return;
            }
            int iHashCode = str2.hashCode();
            if (iHashCode != 579053441) {
                if (iHashCode == 871091088 && str2.equals("initialize")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str2.equals("dispose_all")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                this.zzc.clear();
                this.zzb.zza();
                return;
            }
            if (b == 1) {
                Iterator it = this.zzc.values().iterator();
                while (it.hasNext()) {
                    ((zzdxf) it.next()).zza();
                }
                this.zzc.clear();
                return;
            }
            String str3 = (String) mapZzO.get("obj_id");
            try {
                long j = Long.parseLong((String) Objects.requireNonNull(str3));
                switch (str2) {
                    case "create_interstitial_ad":
                        if (this.zzc.size() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjG)).intValue()) {
                            zzcec.zzj("Could not create H5 ad, too many existing objects");
                            this.zzb.zzi(j);
                            break;
                        } else {
                            Map map = this.zzc;
                            Long lValueOf = Long.valueOf(j);
                            if (!map.containsKey(lValueOf)) {
                                String str4 = (String) mapZzO.get("ad_unit");
                                if (!TextUtils.isEmpty(str4)) {
                                    zzdxg zzdxgVarZzb = this.zza.zzb();
                                    zzdxgVarZzb.zzb(j);
                                    zzdxgVarZzb.zza(str4);
                                    this.zzc.put(lValueOf, zzdxgVarZzb.zzc().zza());
                                    this.zzb.zzh(j);
                                    com.google.android.gms.ads.internal.util.zze.zza("Created H5 interstitial #" + j + " with ad unit " + str4);
                                } else {
                                    zzcec.zzj("Could not create H5 ad, missing ad unit id");
                                    this.zzb.zzi(j);
                                }
                            } else {
                                zzcec.zze("Could not create H5 ad, object ID already exists");
                                this.zzb.zzi(j);
                            }
                            break;
                        }
                        break;
                    case "load_interstitial_ad":
                        zzdxf zzdxfVar = (zzdxf) this.zzc.get(Long.valueOf(j));
                        if (zzdxfVar == null) {
                            zzcec.zze("Could not load H5 ad, object ID does not exist");
                            this.zzb.zzf(j);
                            break;
                        } else {
                            zzdxfVar.zzb(zzc(mapZzO));
                            break;
                        }
                        break;
                    case "show_interstitial_ad":
                        zzdxf zzdxfVar2 = (zzdxf) this.zzc.get(Long.valueOf(j));
                        if (zzdxfVar2 == null) {
                            zzcec.zze("Could not show H5 ad, object ID does not exist");
                            this.zzb.zzf(j);
                            break;
                        } else {
                            zzdxfVar2.zzc();
                            break;
                        }
                        break;
                    case "create_rewarded_ad":
                        if (this.zzc.size() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjG)).intValue()) {
                            zzcec.zzj("Could not create H5 ad, too many existing objects");
                            this.zzb.zzi(j);
                            break;
                        } else {
                            Map map2 = this.zzc;
                            Long lValueOf2 = Long.valueOf(j);
                            if (!map2.containsKey(lValueOf2)) {
                                String str5 = (String) mapZzO.get("ad_unit");
                                if (!TextUtils.isEmpty(str5)) {
                                    zzdxg zzdxgVarZzb2 = this.zza.zzb();
                                    zzdxgVarZzb2.zzb(j);
                                    zzdxgVarZzb2.zza(str5);
                                    this.zzc.put(lValueOf2, zzdxgVarZzb2.zzc().zzb());
                                    this.zzb.zzh(j);
                                    com.google.android.gms.ads.internal.util.zze.zza("Created H5 rewarded #" + j + " with ad unit " + str5);
                                } else {
                                    zzcec.zzj("Could not create H5 ad, missing ad unit id");
                                    this.zzb.zzi(j);
                                }
                            } else {
                                zzcec.zze("Could not create H5 ad, object ID already exists");
                                this.zzb.zzi(j);
                            }
                            break;
                        }
                        break;
                    case "load_rewarded_ad":
                        zzdxf zzdxfVar3 = (zzdxf) this.zzc.get(Long.valueOf(j));
                        if (zzdxfVar3 == null) {
                            zzcec.zze("Could not load H5 ad, object ID does not exist");
                            this.zzb.zzq(j);
                            break;
                        } else {
                            zzdxfVar3.zzb(zzc(mapZzO));
                            break;
                        }
                        break;
                    case "show_rewarded_ad":
                        zzdxf zzdxfVar4 = (zzdxf) this.zzc.get(Long.valueOf(j));
                        if (zzdxfVar4 == null) {
                            zzcec.zze("Could not show H5 ad, object ID does not exist");
                            this.zzb.zzq(j);
                            break;
                        } else {
                            zzdxfVar4.zzc();
                            break;
                        }
                        break;
                    case "dispose":
                        Map map3 = this.zzc;
                        Long lValueOf3 = Long.valueOf(j);
                        zzdxf zzdxfVar5 = (zzdxf) map3.get(lValueOf3);
                        if (zzdxfVar5 == null) {
                            zzcec.zze("Could not dispose H5 ad, object ID does not exist");
                            break;
                        } else {
                            zzdxfVar5.zza();
                            this.zzc.remove(lValueOf3);
                            com.google.android.gms.ads.internal.util.zze.zza("Disposed H5 ad #" + j);
                            break;
                        }
                        break;
                    default:
                        zzcec.zze("H5 gmsg contained invalid action: ".concat(String.valueOf(str2)));
                        break;
                }
            } catch (NullPointerException | NumberFormatException unused) {
                zzcec.zze("H5 gmsg did not contain a valid object id: ".concat(String.valueOf(str3)));
            }
        }
    }
}
