package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzrb;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzit implements Callable {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjd zzc;

    zzit(zzjd zzjdVar, zzbg zzbgVar, String str) {
        this.zza = zzbgVar;
        this.zzb = str;
        Objects.requireNonNull(zzjdVar);
        this.zzc = zzjdVar;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0440 A[Catch: all -> 0x052c, TryCatch #4 {all -> 0x052c, blocks: (B:95:0x03b4, B:96:0x03d1, B:98:0x03d7, B:100:0x03eb, B:101:0x03f6, B:103:0x0440, B:104:0x044e, B:106:0x0456, B:107:0x0459, B:109:0x0461, B:112:0x046a, B:115:0x0481, B:116:0x0484, B:111:0x0467, B:128:0x0512, B:57:0x01eb, B:59:0x01f3, B:61:0x01f9), top: B:145:0x01eb, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0456 A[Catch: all -> 0x052c, TryCatch #4 {all -> 0x052c, blocks: (B:95:0x03b4, B:96:0x03d1, B:98:0x03d7, B:100:0x03eb, B:101:0x03f6, B:103:0x0440, B:104:0x044e, B:106:0x0456, B:107:0x0459, B:109:0x0461, B:112:0x046a, B:115:0x0481, B:116:0x0484, B:111:0x0467, B:128:0x0512, B:57:0x01eb, B:59:0x01f3, B:61:0x01f9), top: B:145:0x01eb, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0461 A[Catch: all -> 0x052c, TryCatch #4 {all -> 0x052c, blocks: (B:95:0x03b4, B:96:0x03d1, B:98:0x03d7, B:100:0x03eb, B:101:0x03f6, B:103:0x0440, B:104:0x044e, B:106:0x0456, B:107:0x0459, B:109:0x0461, B:112:0x046a, B:115:0x0481, B:116:0x0484, B:111:0x0467, B:128:0x0512, B:57:0x01eb, B:59:0x01f3, B:61:0x01f9), top: B:145:0x01eb, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0465 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0467 A[Catch: all -> 0x052c, TryCatch #4 {all -> 0x052c, blocks: (B:95:0x03b4, B:96:0x03d1, B:98:0x03d7, B:100:0x03eb, B:101:0x03f6, B:103:0x0440, B:104:0x044e, B:106:0x0456, B:107:0x0459, B:109:0x0461, B:112:0x046a, B:115:0x0481, B:116:0x0484, B:111:0x0467, B:128:0x0512, B:57:0x01eb, B:59:0x01f3, B:61:0x01f9), top: B:145:0x01eb, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x047f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:148:0x0252 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x03eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x03d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x01ba A[Catch: all -> 0x052e, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x052e, blocks: (B:8:0x0058, B:10:0x0063, B:13:0x007d, B:15:0x0083, B:16:0x0095, B:18:0x00ac, B:19:0x00b3, B:21:0x00bd, B:22:0x00ca, B:24:0x00d4, B:25:0x00e1, B:27:0x00ec, B:28:0x00f4, B:30:0x010c, B:31:0x010f, B:33:0x0129, B:35:0x0139, B:37:0x0141, B:39:0x0147, B:40:0x014a, B:42:0x0159, B:44:0x015f, B:46:0x0171, B:48:0x017b, B:49:0x018c, B:51:0x0190, B:53:0x019d, B:56:0x01ba, B:57:0x01eb, B:59:0x01f3, B:61:0x01f9, B:62:0x0210, B:64:0x021a, B:65:0x0227, B:66:0x0239, B:68:0x023f, B:75:0x0257, B:78:0x0280, B:79:0x0287, B:81:0x028d, B:82:0x02c1, B:77:0x025b), top: B:147:0x0058, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01f3 A[Catch: SecurityException -> 0x050f, all -> 0x052e, TryCatch #5 {SecurityException -> 0x050f, blocks: (B:57:0x01eb, B:59:0x01f3, B:61:0x01f9), top: B:145:0x01eb, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x021a A[Catch: all -> 0x052e, TryCatch #6 {all -> 0x052e, blocks: (B:8:0x0058, B:10:0x0063, B:13:0x007d, B:15:0x0083, B:16:0x0095, B:18:0x00ac, B:19:0x00b3, B:21:0x00bd, B:22:0x00ca, B:24:0x00d4, B:25:0x00e1, B:27:0x00ec, B:28:0x00f4, B:30:0x010c, B:31:0x010f, B:33:0x0129, B:35:0x0139, B:37:0x0141, B:39:0x0147, B:40:0x014a, B:42:0x0159, B:44:0x015f, B:46:0x0171, B:48:0x017b, B:49:0x018c, B:51:0x0190, B:53:0x019d, B:56:0x01ba, B:57:0x01eb, B:59:0x01f3, B:61:0x01f9, B:62:0x0210, B:64:0x021a, B:65:0x0227, B:66:0x0239, B:68:0x023f, B:75:0x0257, B:78:0x0280, B:79:0x0287, B:81:0x028d, B:82:0x02c1, B:77:0x025b), top: B:147:0x0058, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x023f A[Catch: all -> 0x052e, TryCatch #6 {all -> 0x052e, blocks: (B:8:0x0058, B:10:0x0063, B:13:0x007d, B:15:0x0083, B:16:0x0095, B:18:0x00ac, B:19:0x00b3, B:21:0x00bd, B:22:0x00ca, B:24:0x00d4, B:25:0x00e1, B:27:0x00ec, B:28:0x00f4, B:30:0x010c, B:31:0x010f, B:33:0x0129, B:35:0x0139, B:37:0x0141, B:39:0x0147, B:40:0x014a, B:42:0x0159, B:44:0x015f, B:46:0x0171, B:48:0x017b, B:49:0x018c, B:51:0x0190, B:53:0x019d, B:56:0x01ba, B:57:0x01eb, B:59:0x01f3, B:61:0x01f9, B:62:0x0210, B:64:0x021a, B:65:0x0227, B:66:0x0239, B:68:0x023f, B:75:0x0257, B:78:0x0280, B:79:0x0287, B:81:0x028d, B:82:0x02c1, B:77:0x025b), top: B:147:0x0058, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0257 A[Catch: all -> 0x052e, TryCatch #6 {all -> 0x052e, blocks: (B:8:0x0058, B:10:0x0063, B:13:0x007d, B:15:0x0083, B:16:0x0095, B:18:0x00ac, B:19:0x00b3, B:21:0x00bd, B:22:0x00ca, B:24:0x00d4, B:25:0x00e1, B:27:0x00ec, B:28:0x00f4, B:30:0x010c, B:31:0x010f, B:33:0x0129, B:35:0x0139, B:37:0x0141, B:39:0x0147, B:40:0x014a, B:42:0x0159, B:44:0x015f, B:46:0x0171, B:48:0x017b, B:49:0x018c, B:51:0x0190, B:53:0x019d, B:56:0x01ba, B:57:0x01eb, B:59:0x01f3, B:61:0x01f9, B:62:0x0210, B:64:0x021a, B:65:0x0227, B:66:0x0239, B:68:0x023f, B:75:0x0257, B:78:0x0280, B:79:0x0287, B:81:0x028d, B:82:0x02c1, B:77:0x025b), top: B:147:0x0058, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x025b A[Catch: all -> 0x052e, TryCatch #6 {all -> 0x052e, blocks: (B:8:0x0058, B:10:0x0063, B:13:0x007d, B:15:0x0083, B:16:0x0095, B:18:0x00ac, B:19:0x00b3, B:21:0x00bd, B:22:0x00ca, B:24:0x00d4, B:25:0x00e1, B:27:0x00ec, B:28:0x00f4, B:30:0x010c, B:31:0x010f, B:33:0x0129, B:35:0x0139, B:37:0x0141, B:39:0x0147, B:40:0x014a, B:42:0x0159, B:44:0x015f, B:46:0x0171, B:48:0x017b, B:49:0x018c, B:51:0x0190, B:53:0x019d, B:56:0x01ba, B:57:0x01eb, B:59:0x01f3, B:61:0x01f9, B:62:0x0210, B:64:0x021a, B:65:0x0227, B:66:0x0239, B:68:0x023f, B:75:0x0257, B:78:0x0280, B:79:0x0287, B:81:0x028d, B:82:0x02c1, B:77:0x025b), top: B:147:0x0058, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x028d A[Catch: all -> 0x052e, LOOP:1: B:79:0x0287->B:81:0x028d, LOOP_END, TryCatch #6 {all -> 0x052e, blocks: (B:8:0x0058, B:10:0x0063, B:13:0x007d, B:15:0x0083, B:16:0x0095, B:18:0x00ac, B:19:0x00b3, B:21:0x00bd, B:22:0x00ca, B:24:0x00d4, B:25:0x00e1, B:27:0x00ec, B:28:0x00f4, B:30:0x010c, B:31:0x010f, B:33:0x0129, B:35:0x0139, B:37:0x0141, B:39:0x0147, B:40:0x014a, B:42:0x0159, B:44:0x015f, B:46:0x0171, B:48:0x017b, B:49:0x018c, B:51:0x0190, B:53:0x019d, B:56:0x01ba, B:57:0x01eb, B:59:0x01f3, B:61:0x01f9, B:62:0x0210, B:64:0x021a, B:65:0x0227, B:66:0x0239, B:68:0x023f, B:75:0x0257, B:78:0x0280, B:79:0x0287, B:81:0x028d, B:82:0x02c1, B:77:0x025b), top: B:147:0x0058, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0328 A[Catch: all -> 0x050b, TryCatch #2 {all -> 0x050b, blocks: (B:84:0x02fc, B:86:0x0328, B:87:0x033c, B:89:0x0348, B:91:0x039d, B:90:0x0380), top: B:141:0x02fc }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0348 A[Catch: all -> 0x050b, TryCatch #2 {all -> 0x050b, blocks: (B:84:0x02fc, B:86:0x0328, B:87:0x033c, B:89:0x0348, B:91:0x039d, B:90:0x0380), top: B:141:0x02fc }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0380 A[Catch: all -> 0x050b, TryCatch #2 {all -> 0x050b, blocks: (B:84:0x02fc, B:86:0x0328, B:87:0x033c, B:89:0x0348, B:91:0x039d, B:90:0x0380), top: B:141:0x02fc }] */
    /* JADX WARN: Code duplicated, block: B:98:0x03d7 A[Catch: all -> 0x052c, TryCatch #4 {all -> 0x052c, blocks: (B:95:0x03b4, B:96:0x03d1, B:98:0x03d7, B:100:0x03eb, B:101:0x03f6, B:103:0x0440, B:104:0x044e, B:106:0x0456, B:107:0x0459, B:109:0x0461, B:112:0x046a, B:115:0x0481, B:116:0x0484, B:111:0x0467, B:128:0x0512, B:57:0x01eb, B:59:0x01f3, B:61:0x01f9), top: B:145:0x01eb, inners: #5 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.measurement.internal.zzbg, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.android.gms.measurement.internal.zzol] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        byte[] bArr;
        zzpg zzpgVar;
        String strZzc;
        zzpg zzpgVar2;
        List listZzn;
        Iterator it;
        zzpn zzpnVar;
        com.google.android.gms.internal.measurement.zziu[] zziuVarArr;
        int i;
        zzic zzicVar;
        Bundle bundle;
        String str;
        zzbc zzbcVarZzf;
        boolean z;
        Object obj;
        zzbc zzbcVarZza;
        long j;
        com.google.android.gms.internal.measurement.zzhr zzhrVarZzk;
        zzbe zzbeVar;
        zzbd zzbdVar;
        long jZzp;
        long jZzn;
        String strZzh;
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn;
        Object objZza;
        zzav zzavVarZzj;
        zzjd zzjdVar = this.zzc;
        zzjdVar.zzL().zzZ();
        zzlp zzlpVarZzn = zzjdVar.zzL().zzn();
        zzlpVarZzn.zzg();
        zzic zzicVar2 = zzlpVarZzn.zzu;
        zzic.zzL();
        ?? r4 = this.zza;
        Preconditions.checkNotNull(r4);
        String str2 = this.zzb;
        Preconditions.checkNotEmpty(str2);
        String str3 = r4.zza;
        if (!"_iap".equals(str3) && !"_iapx".equals(str3)) {
            zzlpVarZzn.zzu.zzaV().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", str2, str3);
            return null;
        }
        zzpg zzpgVar3 = zzlpVarZzn.zzg;
        com.google.android.gms.internal.measurement.zzhz zzhzVarZzh = com.google.android.gms.internal.measurement.zzib.zzh();
        zzpgVar3.zzj().zzb();
        try {
            zzh zzhVarZzu = zzpgVar3.zzj().zzu(str2);
            if (zzhVarZzu != null) {
                if (zzhVarZzu.zzD()) {
                    com.google.android.gms.internal.measurement.zzic zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                    zzicVarZzaE.zza(1);
                    zzicVarZzaE.zzC("android");
                    if (!TextUtils.isEmpty(zzhVarZzu.zzc())) {
                        zzicVarZzaE.zzL(zzhVarZzu.zzc());
                    }
                    if (!TextUtils.isEmpty(zzhVarZzu.zzv())) {
                        zzicVarZzaE.zzJ((String) Preconditions.checkNotNull(zzhVarZzu.zzv()));
                    }
                    if (!TextUtils.isEmpty(zzhVarZzu.zzr())) {
                        zzicVarZzaE.zzM((String) Preconditions.checkNotNull(zzhVarZzu.zzr()));
                    }
                    if (zzhVarZzu.zzt() != -2147483648L) {
                        zzicVarZzaE.zzaj((int) zzhVarZzu.zzt());
                    }
                    zzicVarZzaE.zzN(zzhVarZzu.zzx());
                    zzicVarZzaE.zzar(zzhVarZzu.zzB());
                    String strZzf = zzhVarZzu.zzf();
                    if (!TextUtils.isEmpty(strZzf)) {
                        zzicVarZzaE.zzad(strZzf);
                    }
                    zzicVarZzaE.zzay(zzhVarZzu.zzak());
                    zzjl zzjlVarZzB = zzlpVarZzn.zzg.zzB(str2);
                    zzicVarZzaE.zzY(zzhVarZzu.zzz());
                    if (zzicVar2.zzB() && zzlpVarZzn.zzu.zzc().zzC(zzicVarZzaE.zzK()) && zzjlVarZzB.zzo(zzjk.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                        zzicVarZzaE.zzam(null);
                    }
                    zzicVarZzaE.zzat(zzjlVarZzB.zzk());
                    if (zzjlVarZzB.zzo(zzjk.AD_STORAGE) && zzhVarZzu.zzac()) {
                        Pair pairZzc = zzpgVar3.zzq().zzc(zzhVarZzu.zzc(), zzjlVarZzB);
                        if (!zzhVarZzu.zzac() || TextUtils.isEmpty((CharSequence) pairZzc.first)) {
                            zzic zzicVar3 = zzlpVarZzn.zzu;
                            zzicVar3.zzu().zzw();
                            zzicVarZzaE.zzF(Build.MODEL);
                            zzicVar3.zzu().zzw();
                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                            zzicVarZzaE.zzI((int) zzicVar3.zzu().zzb());
                            zzicVarZzaE.zzH(zzicVar3.zzu().zzc());
                            if (zzjlVarZzB.zzo(zzjk.ANALYTICS_STORAGE)) {
                                zzicVarZzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzhVarZzu.zzd()), Long.toString(r4.zzd)));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                            }
                            strZzc = zzhVarZzu.zzc();
                            zzpgVar2 = zzlpVarZzn.zzg;
                            listZzn = zzpgVar2.zzj().zzn(strZzc);
                            it = listZzn.iterator();
                            do {
                                if (!it.hasNext()) {
                                    zzpnVar = null;
                                    break;
                                }
                                zzpnVar = (zzpn) it.next();
                            } while (!"_lte".equals(zzpnVar.zzc));
                            if (zzpnVar != null) {
                                zzpn zzpnVar2 = new zzpn(strZzc, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzlpVarZzn.zzu.zzaZ().currentTimeMillis(), 0L);
                                listZzn.add(zzpnVar2);
                                zzpgVar2.zzj().zzl(zzpnVar2);
                            } else {
                                zzpn zzpnVar3 = new zzpn(strZzc, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzlpVarZzn.zzu.zzaZ().currentTimeMillis(), 0L);
                                listZzn.add(zzpnVar3);
                                zzpgVar2.zzj().zzl(zzpnVar3);
                            }
                            zziuVarArr = new com.google.android.gms.internal.measurement.zziu[listZzn.size()];
                            for (i = 0; i < listZzn.size(); i++) {
                                com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
                                zzitVarZzm.zzb(((zzpn) listZzn.get(i)).zzc);
                                zzitVarZzm.zza(((zzpn) listZzn.get(i)).zzd);
                                zzpgVar2.zzp().zzc(zzitVarZzm, ((zzpn) listZzn.get(i)).zze);
                                zziuVarArr[i] = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbc();
                            }
                            zzicVarZzaE.zzq(Arrays.asList(zziuVarArr));
                            zzpg zzpgVar4 = zzlpVarZzn.zzg;
                            zzpgVar4.zzI(zzhVarZzu, zzicVarZzaE);
                            zzpgVar4.zzJ(zzhVarZzu, zzicVarZzaE);
                            zzgv zzgvVarZza = zzgv.zza(r4);
                            zzicVar = zzlpVarZzn.zzu;
                            zzpp zzppVarZzk = zzicVar.zzk();
                            bundle = zzgvVarZza.zzd;
                            zzppVarZzk.zzI(bundle, zzpgVar2.zzj().zzU(str2));
                            zzicVar.zzk().zzG(zzgvVarZza, zzicVar.zzc().zzd(str2));
                            bundle.putLong("_c", 1L);
                            zzicVar.zzaV().zzj().zza("Marking in-app purchase as real-time");
                            bundle.putLong("_r", 1L);
                            String str4 = r4.zzc;
                            bundle.putString("_o", str4);
                            if (zzicVar.zzk().zzaa(zzicVarZzaE.zzK(), zzhVarZzu.zzay())) {
                                zzicVar.zzk().zzM(bundle, "_dbg", 1L);
                                zzicVar.zzk().zzM(bundle, "_r", 1L);
                            }
                            zzav zzavVarZzj2 = zzpgVar2.zzj();
                            str = r4.zza;
                            zzbcVarZzf = zzavVarZzj2.zzf(str2, str);
                            if (zzbcVarZzf == null) {
                                z = true;
                                obj = null;
                                zzbcVarZza = new zzbc(str2, str, 0L, 0L, 0L, r4.zzd, 0L, null, null, null, null);
                                j = 0;
                            } else {
                                z = true;
                                obj = null;
                                long j2 = zzbcVarZzf.zzf;
                                zzbcVarZza = zzbcVarZzf.zza(r4.zzd);
                                j = j2;
                            }
                            zzpgVar2.zzj().zzh(zzbcVarZza);
                            zzbb zzbbVar = new zzbb(zzlpVarZzn.zzu, str4, str2, str, r4.zzd, j, bundle);
                            zzhrVarZzk = com.google.android.gms.internal.measurement.zzhs.zzk();
                            zzhrVarZzk.zzo(zzbbVar.zzd);
                            zzhrVarZzk.zzl(zzbbVar.zzb);
                            zzhrVarZzk.zzq(zzbbVar.zze);
                            zzbeVar = zzbbVar.zzf;
                            zzbdVar = new zzbd(zzbeVar);
                            while (zzbdVar.hasNext()) {
                                String next = zzbdVar.next();
                                String str5 = next;
                                zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn.zzb(next);
                                objZza = zzbeVar.zza(next);
                                if (objZza != null) {
                                    zzpgVar2.zzp().zzd(zzhvVarZzn, objZza);
                                    zzhrVarZzk.zzg(zzhvVarZzn);
                                }
                            }
                            zzicVarZzaE.zzg(zzhrVarZzk);
                            com.google.android.gms.internal.measurement.zzie zzieVarZza = com.google.android.gms.internal.measurement.zzig.zza();
                            com.google.android.gms.internal.measurement.zzht zzhtVarZza = com.google.android.gms.internal.measurement.zzhu.zza();
                            zzhtVarZza.zzb(zzbcVarZza.zzc);
                            zzhtVarZza.zza(str);
                            zzieVarZza.zza(zzhtVarZza);
                            zzicVarZzaE.zzap(zzieVarZza);
                            zzicVarZzaE.zzaf(zzpgVar2.zzm().zzb(zzhVarZzu.zzc(), Collections.emptyList(), zzicVarZzaE.zzk(), Long.valueOf(zzhrVarZzk.zzn()), Long.valueOf(zzhrVarZzk.zzn()), false));
                            if (zzhrVarZzk.zzm()) {
                                zzicVarZzaE.zzv(zzhrVarZzk.zzn());
                                zzicVarZzaE.zzx(zzhrVarZzk.zzn());
                            }
                            jZzp = zzhVarZzu.zzp();
                            if (jZzp != 0) {
                                zzicVarZzaE.zzA(jZzp);
                            }
                            jZzn = zzhVarZzu.zzn();
                            if (jZzn != 0) {
                                zzicVarZzaE.zzy(jZzn);
                            } else if (jZzp != 0) {
                                zzicVarZzaE.zzy(jZzp);
                            }
                            strZzh = zzhVarZzu.zzh();
                            zzrb.zza();
                            if (zzicVar.zzc().zzp(str2, zzfy.zzaM)) {
                                zzicVarZzaE.zzau(strZzh);
                            }
                            zzhVarZzu.zzL();
                            zzicVarZzaE.zzZ((int) zzhVarZzu.zzG());
                            zzicVar.zzc().zzi();
                            zzicVarZzaE.zzO(133005L);
                            zzicVarZzaE.zzs(zzicVar.zzaZ().currentTimeMillis());
                            zzicVarZzaE.zzae(z);
                            zzpgVar4.zzS(zzicVarZzaE.zzK(), zzicVarZzaE);
                            zzhzVarZzh.zze(zzicVarZzaE);
                            zzhVarZzu.zzo(zzicVarZzaE.zzu());
                            zzhVarZzu.zzq(zzicVarZzaE.zzw());
                            zzpgVar2.zzj().zzv(zzhVarZzu, false, false);
                            zzpgVar2.zzj().zzc();
                            zzpgVar2.zzj().zzd();
                            return zzpgVar2.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVarZzh.zzbc()).zzcc());
                        }
                        try {
                            zzicVarZzaE.zzQ(zzlp.zzc((String) pairZzc.first, Long.toString(r4.zzd)));
                            if (pairZzc.second != null) {
                                zzicVarZzaE.zzT(((Boolean) pairZzc.second).booleanValue());
                            }
                            zzic zzicVar4 = zzlpVarZzn.zzu;
                            zzicVar4.zzu().zzw();
                            zzicVarZzaE.zzF(Build.MODEL);
                            zzicVar4.zzu().zzw();
                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                            zzicVarZzaE.zzI((int) zzicVar4.zzu().zzb());
                            zzicVarZzaE.zzH(zzicVar4.zzu().zzc());
                            if (zzjlVarZzB.zzo(zzjk.ANALYTICS_STORAGE)) {
                                zzicVarZzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzhVarZzu.zzd()), Long.toString(r4.zzd)));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                            }
                            strZzc = zzhVarZzu.zzc();
                            zzpgVar2 = zzlpVarZzn.zzg;
                            listZzn = zzpgVar2.zzj().zzn(strZzc);
                            it = listZzn.iterator();
                            do {
                                if (!it.hasNext()) {
                                    zzpnVar = null;
                                    break;
                                }
                                zzpnVar = (zzpn) it.next();
                            } while (!"_lte".equals(zzpnVar.zzc));
                            if (zzpnVar != null) {
                                zzpn zzpnVar4 = new zzpn(strZzc, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzlpVarZzn.zzu.zzaZ().currentTimeMillis(), 0L);
                                listZzn.add(zzpnVar4);
                                zzpgVar2.zzj().zzl(zzpnVar4);
                            } else {
                                zzpn zzpnVar5 = new zzpn(strZzc, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzlpVarZzn.zzu.zzaZ().currentTimeMillis(), 0L);
                                listZzn.add(zzpnVar5);
                                zzpgVar2.zzj().zzl(zzpnVar5);
                            }
                            zziuVarArr = new com.google.android.gms.internal.measurement.zziu[listZzn.size()];
                            while (i < listZzn.size()) {
                                com.google.android.gms.internal.measurement.zzit zzitVarZzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
                                zzitVarZzm2.zzb(((zzpn) listZzn.get(i)).zzc);
                                zzitVarZzm2.zza(((zzpn) listZzn.get(i)).zzd);
                                zzpgVar2.zzp().zzc(zzitVarZzm2, ((zzpn) listZzn.get(i)).zze);
                                zziuVarArr[i] = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm2.zzbc();
                            }
                            zzicVarZzaE.zzq(Arrays.asList(zziuVarArr));
                            zzpg zzpgVar5 = zzlpVarZzn.zzg;
                            zzpgVar5.zzI(zzhVarZzu, zzicVarZzaE);
                            zzpgVar5.zzJ(zzhVarZzu, zzicVarZzaE);
                            zzgv zzgvVarZza2 = zzgv.zza(r4);
                            zzicVar = zzlpVarZzn.zzu;
                            zzpp zzppVarZzk2 = zzicVar.zzk();
                            bundle = zzgvVarZza2.zzd;
                            zzppVarZzk2.zzI(bundle, zzpgVar2.zzj().zzU(str2));
                            zzicVar.zzk().zzG(zzgvVarZza2, zzicVar.zzc().zzd(str2));
                            bundle.putLong("_c", 1L);
                            zzicVar.zzaV().zzj().zza("Marking in-app purchase as real-time");
                            bundle.putLong("_r", 1L);
                            String str6 = r4.zzc;
                            bundle.putString("_o", str6);
                            if (zzicVar.zzk().zzaa(zzicVarZzaE.zzK(), zzhVarZzu.zzay())) {
                                zzicVar.zzk().zzM(bundle, "_dbg", 1L);
                                zzicVar.zzk().zzM(bundle, "_r", 1L);
                            }
                            zzav zzavVarZzj3 = zzpgVar2.zzj();
                            str = r4.zza;
                            zzbcVarZzf = zzavVarZzj3.zzf(str2, str);
                            if (zzbcVarZzf == null) {
                                z = true;
                                obj = null;
                                zzbcVarZza = new zzbc(str2, str, 0L, 0L, 0L, r4.zzd, 0L, null, null, null, null);
                                j = 0;
                            } else {
                                z = true;
                                obj = null;
                                long j3 = zzbcVarZzf.zzf;
                                zzbcVarZza = zzbcVarZzf.zza(r4.zzd);
                                j = j3;
                            }
                            zzpgVar2.zzj().zzh(zzbcVarZza);
                            zzbb zzbbVar2 = new zzbb(zzlpVarZzn.zzu, str6, str2, str, r4.zzd, j, bundle);
                            zzhrVarZzk = com.google.android.gms.internal.measurement.zzhs.zzk();
                            zzhrVarZzk.zzo(zzbbVar2.zzd);
                            zzhrVarZzk.zzl(zzbbVar2.zzb);
                            zzhrVarZzk.zzq(zzbbVar2.zze);
                            zzbeVar = zzbbVar2.zzf;
                            zzbdVar = new zzbd(zzbeVar);
                            while (zzbdVar.hasNext()) {
                                String next2 = zzbdVar.next();
                                String str7 = next2;
                                zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn.zzb(next2);
                                objZza = zzbeVar.zza(next2);
                                if (objZza != null) {
                                    zzpgVar2.zzp().zzd(zzhvVarZzn, objZza);
                                    zzhrVarZzk.zzg(zzhvVarZzn);
                                }
                            }
                            zzicVarZzaE.zzg(zzhrVarZzk);
                            com.google.android.gms.internal.measurement.zzie zzieVarZza2 = com.google.android.gms.internal.measurement.zzig.zza();
                            com.google.android.gms.internal.measurement.zzht zzhtVarZza2 = com.google.android.gms.internal.measurement.zzhu.zza();
                            zzhtVarZza2.zzb(zzbcVarZza.zzc);
                            zzhtVarZza2.zza(str);
                            zzieVarZza2.zza(zzhtVarZza2);
                            zzicVarZzaE.zzap(zzieVarZza2);
                            zzicVarZzaE.zzaf(zzpgVar2.zzm().zzb(zzhVarZzu.zzc(), Collections.emptyList(), zzicVarZzaE.zzk(), Long.valueOf(zzhrVarZzk.zzn()), Long.valueOf(zzhrVarZzk.zzn()), false));
                            if (zzhrVarZzk.zzm()) {
                                zzicVarZzaE.zzv(zzhrVarZzk.zzn());
                                zzicVarZzaE.zzx(zzhrVarZzk.zzn());
                            }
                            jZzp = zzhVarZzu.zzp();
                            if (jZzp != 0) {
                                zzicVarZzaE.zzA(jZzp);
                            }
                            jZzn = zzhVarZzu.zzn();
                            if (jZzn != 0) {
                                zzicVarZzaE.zzy(jZzn);
                            } else if (jZzp != 0) {
                                zzicVarZzaE.zzy(jZzp);
                            }
                            strZzh = zzhVarZzu.zzh();
                            zzrb.zza();
                            if (zzicVar.zzc().zzp(str2, zzfy.zzaM)) {
                                zzicVarZzaE.zzau(strZzh);
                            }
                            zzhVarZzu.zzL();
                            zzicVarZzaE.zzZ((int) zzhVarZzu.zzG());
                            zzicVar.zzc().zzi();
                            zzicVarZzaE.zzO(133005L);
                            zzicVarZzaE.zzs(zzicVar.zzaZ().currentTimeMillis());
                            zzicVarZzaE.zzae(z);
                            zzpgVar5.zzS(zzicVarZzaE.zzK(), zzicVarZzaE);
                            zzhzVarZzh.zze(zzicVarZzaE);
                            zzhVarZzu.zzo(zzicVarZzaE.zzu());
                            zzhVarZzu.zzq(zzicVarZzaE.zzw());
                            zzpgVar2.zzj().zzv(zzhVarZzu, false, false);
                            zzpgVar2.zzj().zzc();
                            zzpgVar2.zzj().zzd();
                            return zzpgVar2.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVarZzh.zzbc()).zzcc());
                        } catch (SecurityException e) {
                            zzlpVarZzn.zzu.zzaV().zzj().zzb("Resettable device id encryption failed", e.getMessage());
                            bArr = new byte[0];
                            zzpgVar = zzlpVarZzn.zzg;
                            zzavVarZzj = zzpgVar.zzj();
                            zzavVarZzj.zzd();
                            return bArr;
                        }
                    }
                    zzic zzicVar5 = zzlpVarZzn.zzu;
                    zzicVar5.zzu().zzw();
                    zzicVarZzaE.zzF(Build.MODEL);
                    zzicVar5.zzu().zzw();
                    zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                    zzicVarZzaE.zzI((int) zzicVar5.zzu().zzb());
                    zzicVarZzaE.zzH(zzicVar5.zzu().zzc());
                    try {
                        try {
                            if (zzjlVarZzB.zzo(zzjk.ANALYTICS_STORAGE) && zzhVarZzu.zzd() != null) {
                                zzicVarZzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzhVarZzu.zzd()), Long.toString(r4.zzd)));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                            }
                            strZzc = zzhVarZzu.zzc();
                            zzpgVar2 = zzlpVarZzn.zzg;
                            listZzn = zzpgVar2.zzj().zzn(strZzc);
                            it = listZzn.iterator();
                            do {
                                if (!it.hasNext()) {
                                    zzpnVar = null;
                                    break;
                                }
                                zzpnVar = (zzpn) it.next();
                            } while (!"_lte".equals(zzpnVar.zzc));
                            if (zzpnVar != null || zzpnVar.zze == null) {
                                zzpn zzpnVar6 = new zzpn(strZzc, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzlpVarZzn.zzu.zzaZ().currentTimeMillis(), 0L);
                                listZzn.add(zzpnVar6);
                                zzpgVar2.zzj().zzl(zzpnVar6);
                            }
                            zziuVarArr = new com.google.android.gms.internal.measurement.zziu[listZzn.size()];
                            while (i < listZzn.size()) {
                                com.google.android.gms.internal.measurement.zzit zzitVarZzm3 = com.google.android.gms.internal.measurement.zziu.zzm();
                                zzitVarZzm3.zzb(((zzpn) listZzn.get(i)).zzc);
                                zzitVarZzm3.zza(((zzpn) listZzn.get(i)).zzd);
                                zzpgVar2.zzp().zzc(zzitVarZzm3, ((zzpn) listZzn.get(i)).zze);
                                zziuVarArr[i] = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm3.zzbc();
                            }
                            zzicVarZzaE.zzq(Arrays.asList(zziuVarArr));
                            zzpg zzpgVar6 = zzlpVarZzn.zzg;
                            zzpgVar6.zzI(zzhVarZzu, zzicVarZzaE);
                            zzpgVar6.zzJ(zzhVarZzu, zzicVarZzaE);
                            zzgv zzgvVarZza3 = zzgv.zza(r4);
                            zzicVar = zzlpVarZzn.zzu;
                            zzpp zzppVarZzk3 = zzicVar.zzk();
                            bundle = zzgvVarZza3.zzd;
                            zzppVarZzk3.zzI(bundle, zzpgVar2.zzj().zzU(str2));
                            zzicVar.zzk().zzG(zzgvVarZza3, zzicVar.zzc().zzd(str2));
                            try {
                                bundle.putLong("_c", 1L);
                                zzicVar.zzaV().zzj().zza("Marking in-app purchase as real-time");
                                bundle.putLong("_r", 1L);
                                String str8 = r4.zzc;
                                bundle.putString("_o", str8);
                                if (zzicVar.zzk().zzaa(zzicVarZzaE.zzK(), zzhVarZzu.zzay())) {
                                    zzicVar.zzk().zzM(bundle, "_dbg", 1L);
                                    zzicVar.zzk().zzM(bundle, "_r", 1L);
                                }
                                zzav zzavVarZzj4 = zzpgVar2.zzj();
                                str = r4.zza;
                                zzbcVarZzf = zzavVarZzj4.zzf(str2, str);
                                if (zzbcVarZzf == null) {
                                    z = true;
                                    obj = null;
                                    zzbcVarZza = new zzbc(str2, str, 0L, 0L, 0L, r4.zzd, 0L, null, null, null, null);
                                    j = 0;
                                } else {
                                    z = true;
                                    obj = null;
                                    long j4 = zzbcVarZzf.zzf;
                                    zzbcVarZza = zzbcVarZzf.zza(r4.zzd);
                                    j = j4;
                                }
                                zzpgVar2.zzj().zzh(zzbcVarZza);
                                try {
                                    zzbb zzbbVar3 = new zzbb(zzlpVarZzn.zzu, str8, str2, str, r4.zzd, j, bundle);
                                    zzhrVarZzk = com.google.android.gms.internal.measurement.zzhs.zzk();
                                    zzhrVarZzk.zzo(zzbbVar3.zzd);
                                    zzhrVarZzk.zzl(zzbbVar3.zzb);
                                    zzhrVarZzk.zzq(zzbbVar3.zze);
                                    zzbeVar = zzbbVar3.zzf;
                                    zzbdVar = new zzbd(zzbeVar);
                                    while (zzbdVar.hasNext()) {
                                        String next3 = zzbdVar.next();
                                        String str9 = next3;
                                        zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                        zzhvVarZzn.zzb(next3);
                                        objZza = zzbeVar.zza(next3);
                                        if (objZza != null) {
                                            zzpgVar2.zzp().zzd(zzhvVarZzn, objZza);
                                            zzhrVarZzk.zzg(zzhvVarZzn);
                                        }
                                    }
                                    zzicVarZzaE.zzg(zzhrVarZzk);
                                    com.google.android.gms.internal.measurement.zzie zzieVarZza3 = com.google.android.gms.internal.measurement.zzig.zza();
                                    com.google.android.gms.internal.measurement.zzht zzhtVarZza3 = com.google.android.gms.internal.measurement.zzhu.zza();
                                    zzhtVarZza3.zzb(zzbcVarZza.zzc);
                                    zzhtVarZza3.zza(str);
                                    zzieVarZza3.zza(zzhtVarZza3);
                                    zzicVarZzaE.zzap(zzieVarZza3);
                                    zzicVarZzaE.zzaf(zzpgVar2.zzm().zzb(zzhVarZzu.zzc(), Collections.emptyList(), zzicVarZzaE.zzk(), Long.valueOf(zzhrVarZzk.zzn()), Long.valueOf(zzhrVarZzk.zzn()), false));
                                    if (zzhrVarZzk.zzm()) {
                                        zzicVarZzaE.zzv(zzhrVarZzk.zzn());
                                        zzicVarZzaE.zzx(zzhrVarZzk.zzn());
                                    }
                                    jZzp = zzhVarZzu.zzp();
                                    if (jZzp != 0) {
                                        zzicVarZzaE.zzA(jZzp);
                                    }
                                    jZzn = zzhVarZzu.zzn();
                                    if (jZzn != 0) {
                                        zzicVarZzaE.zzy(jZzn);
                                    } else if (jZzp != 0) {
                                        zzicVarZzaE.zzy(jZzp);
                                    }
                                    strZzh = zzhVarZzu.zzh();
                                    zzrb.zza();
                                    if (zzicVar.zzc().zzp(str2, zzfy.zzaM) && strZzh != null) {
                                        zzicVarZzaE.zzau(strZzh);
                                    }
                                    zzhVarZzu.zzL();
                                    zzicVarZzaE.zzZ((int) zzhVarZzu.zzG());
                                    zzicVar.zzc().zzi();
                                    zzicVarZzaE.zzO(133005L);
                                    zzicVarZzaE.zzs(zzicVar.zzaZ().currentTimeMillis());
                                    zzicVarZzaE.zzae(z);
                                    zzpgVar6.zzS(zzicVarZzaE.zzK(), zzicVarZzaE);
                                    zzhzVarZzh.zze(zzicVarZzaE);
                                    zzhVarZzu.zzo(zzicVarZzaE.zzu());
                                    zzhVarZzu.zzq(zzicVarZzaE.zzw());
                                    zzpgVar2.zzj().zzv(zzhVarZzu, false, false);
                                    zzpgVar2.zzj().zzc();
                                    zzpgVar2.zzj().zzd();
                                    try {
                                        return zzpgVar2.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVarZzh.zzbc()).zzcc());
                                    } catch (IOException e2) {
                                        zzlpVarZzn.zzu.zzaV().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgu.zzl(str2), e2);
                                        return obj;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    r4 = zzlpVarZzn;
                                    r4.zzg.zzj().zzd();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                r4 = zzlpVarZzn;
                            }
                        } catch (SecurityException e3) {
                            zzlpVarZzn.zzu.zzaV().zzj().zzb("app instance id encryption failed", e3.getMessage());
                            bArr = new byte[0];
                            zzpgVar = zzlpVarZzn.zzg;
                            zzavVarZzj = zzpgVar.zzj();
                            zzavVarZzj.zzd();
                            return bArr;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    zzlpVarZzn.zzu.zzaV().zzj().zzb("Log and bundle disabled. package_name", str2);
                    bArr = new byte[0];
                }
                zzavVarZzj.zzd();
                return bArr;
            }
            zzlpVarZzn.zzu.zzaV().zzj().zzb("Log and bundle not available. package_name", str2);
            bArr = new byte[0];
            zzavVarZzj = zzpgVar3.zzj();
            zzavVarZzj.zzd();
            return bArr;
        } catch (Throwable th4) {
            th = th4;
            r4 = zzlpVarZzn;
            r4.zzg.zzj().zzd();
            throw th;
        }
    }
}
