package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzami implements zzakr {
    private final zzfp zza = new zzfp();
    private final zzaly zzb = new zzaly();

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i, int i2, zzakq zzakqVar, zzep zzepVar) {
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        ArrayList arrayList = new ArrayList();
        try {
            zzfp zzfpVar = this.zza;
            int iZzd = zzfpVar.zzd();
            String strZzy = zzfpVar.zzy(zzfwq.zzc);
            if (strZzy == null || !strZzy.startsWith("WEBVTT")) {
                zzfpVar.zzK(iZzd);
                throw zzcc.zza("Expected WEBVTT. Got ".concat(String.valueOf(zzfpVar.zzy(zzfwq.zzc))), null);
            }
            while (!TextUtils.isEmpty(this.zza.zzy(zzfwq.zzc))) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                zzfp zzfpVar2 = this.zza;
                byte b = -1;
                int iZzd2 = 0;
                while (b == -1) {
                    iZzd2 = zzfpVar2.zzd();
                    String strZzy2 = zzfpVar2.zzy(zzfwq.zzc);
                    if (strZzy2 == null) {
                        b = 0;
                    } else if ("STYLE".equals(strZzy2)) {
                        b = 2;
                    } else {
                        b = strZzy2.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                    }
                }
                zzfpVar2.zzK(iZzd2);
                if (b == 0) {
                    zzakl.zza(new zzaml(arrayList2), zzakqVar, zzepVar);
                    return;
                }
                if (b == 1) {
                    while (!TextUtils.isEmpty(this.zza.zzy(zzfwq.zzc))) {
                    }
                } else if (b != 2) {
                    zzama zzamaVarZzc = zzamh.zzc(this.zza, arrayList);
                    if (zzamaVarZzc != null) {
                        arrayList2.add(zzamaVarZzc);
                    }
                } else {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    this.zza.zzy(zzfwq.zzc);
                    arrayList.addAll(this.zzb.zzb(this.zza));
                }
            }
        } catch (zzcc e) {
            throw new IllegalArgumentException(e);
        }
    }
}
