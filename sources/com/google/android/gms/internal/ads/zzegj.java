package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzegj implements zzgej {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzegk zzb;

    zzegj(zzegk zzegkVar, boolean z) {
        this.zza = z;
        this.zzb = zzegkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzcec.zzg("Failed to get signals bundle");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0074  */
    /* JADX WARN: Code duplicated, block: B:28:0x0076  */
    /* JADX WARN: Code duplicated, block: B:30:0x007e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0080  */
    /* JADX WARN: Code duplicated, block: B:33:0x0088  */
    /* JADX WARN: Code duplicated, block: B:34:0x008a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0092  */
    /* JADX WARN: Code duplicated, block: B:37:0x0094  */
    /* JADX WARN: Code duplicated, block: B:39:0x0097 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a9  */
    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List listEmptyList;
        List listAsList;
        final ArrayList arrayList;
        Iterator it;
        byte b;
        zzbcn zzbcnVar;
        Bundle bundle = (Bundle) obj;
        if (this.zzb.zzf()) {
            return;
        }
        Object obj2 = bundle.get("ad_types");
        if (!(obj2 instanceof List)) {
            if (obj2 instanceof String[]) {
                listAsList = Arrays.asList((String[]) obj2);
            } else {
                listEmptyList = Collections.emptyList();
            }
            arrayList = new ArrayList();
            it = listEmptyList.iterator();
            while (it.hasNext()) {
                switch ((String) it.next()) {
                    case "banner":
                        b = 0;
                        break;
                    case "native":
                        b = 2;
                        break;
                    case "rewarded":
                        b = 3;
                        break;
                    case "interstitial":
                        b = 1;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b != 0) {
                    zzbcnVar = zzbcn.BANNER;
                } else if (b != 1) {
                    zzbcnVar = zzbcn.INTERSTITIAL;
                } else if (b != 2) {
                    zzbcnVar = zzbcn.NATIVE_APP_INSTALL;
                } else if (b != 3) {
                    zzbcnVar = zzbcn.AD_FORMAT_TYPE_UNSPECIFIED;
                } else {
                    zzbcnVar = zzbcn.REWARD_BASED_VIDEO_AD;
                }
                arrayList.add(zzbcnVar);
            }
            final zzbec zzbecVarZzb = zzegk.zzb(this.zzb, bundle);
            final zzbdt zzbdtVarZza = zzegk.zza(this.zzb, bundle);
            zzegk zzegkVar = this.zzb;
            final boolean z = this.zza;
            zzegkVar.zza.zza(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzegi
                @Override // com.google.android.gms.internal.ads.zzfkp
                public final Object zza(Object obj3) {
                    zzegj zzegjVar = this.zza;
                    SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj3;
                    if (zzegjVar.zzb.zzf()) {
                        return null;
                    }
                    zzbec zzbecVar = zzbecVarZzb;
                    zzbdt zzbdtVar = zzbdtVarZza;
                    ArrayList arrayList2 = arrayList;
                    boolean z2 = z;
                    byte[] bArrZze = zzegk.zze(zzegjVar.zzb, z2, arrayList2, zzbdtVar, zzbecVar);
                    zzegn.zzg(sQLiteDatabase, z2, true);
                    zzegn.zzd(sQLiteDatabase, zzegjVar.zzb.zzf.zzd(), bArrZze);
                    return null;
                }
            });
        }
        listAsList = (List) obj2;
        ArrayList arrayList2 = new ArrayList(listAsList.size());
        for (Object obj3 : listAsList) {
            if (obj3 instanceof String) {
                arrayList2.add((String) obj3);
            }
        }
        listEmptyList = Collections.unmodifiableList(arrayList2);
        arrayList = new ArrayList();
        it = listEmptyList.iterator();
        while (it.hasNext()) {
            switch ((String) it.next()) {
                case -1396342996:
                    if (!r1.equals("banner")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    break;
                case -1052618729:
                    if (!r1.equals("native")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                    break;
                case -239580146:
                    if (!r1.equals("rewarded")) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                    break;
                case 604727084:
                    if (!r1.equals("interstitial")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b != 0) {
                zzbcnVar = zzbcn.BANNER;
            } else if (b != 1) {
                zzbcnVar = zzbcn.INTERSTITIAL;
            } else if (b != 2) {
                zzbcnVar = zzbcn.NATIVE_APP_INSTALL;
            } else if (b != 3) {
                zzbcnVar = zzbcn.AD_FORMAT_TYPE_UNSPECIFIED;
            } else {
                zzbcnVar = zzbcn.REWARD_BASED_VIDEO_AD;
            }
            arrayList.add(zzbcnVar);
        }
        final zzbec zzbecVarZzb2 = zzegk.zzb(this.zzb, bundle);
        final zzbdt zzbdtVarZza2 = zzegk.zza(this.zzb, bundle);
        zzegk zzegkVar2 = this.zzb;
        final boolean z2 = this.zza;
        zzegkVar2.zza.zza(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzegi
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj4) {
                zzegj zzegjVar = this.zza;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj4;
                if (zzegjVar.zzb.zzf()) {
                    return null;
                }
                zzbec zzbecVar = zzbecVarZzb2;
                zzbdt zzbdtVar = zzbdtVarZza2;
                ArrayList arrayList3 = arrayList;
                boolean z3 = z2;
                byte[] bArrZze = zzegk.zze(zzegjVar.zzb, z3, arrayList3, zzbdtVar, zzbecVar);
                zzegn.zzg(sQLiteDatabase, z3, true);
                zzegn.zzd(sQLiteDatabase, zzegjVar.zzb.zzf.zzd(), bArrZze);
                return null;
            }
        });
    }
}
