package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzalf implements zzakr {
    private final zzfp zza = new zzfp();
    private final zzfp zzb = new zzfp();
    private final zzale zzc = new zzale();
    private Inflater zzd;

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i, int i2, zzakq zzakqVar, zzep zzepVar) {
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        zzfp zzfpVar = this.zza;
        if (zzfpVar.zzb() > 0 && zzfpVar.zzf() == 120) {
            if (this.zzd == null) {
                this.zzd = new Inflater();
            }
            if (zzfy.zzG(zzfpVar, this.zzb, this.zzd)) {
                zzfp zzfpVar2 = this.zzb;
                zzfpVar.zzI(zzfpVar2.zzM(), zzfpVar2.zze());
            }
        }
        this.zzc.zze();
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzfp zzfpVar3 = this.zza;
            if (zzfpVar3.zzb() < 3) {
                zzepVar.zza(new zzakj(arrayList, -9223372036854775807L, -9223372036854775807L));
                return;
            }
            zzale zzaleVar = this.zzc;
            int iZze = zzfpVar3.zze();
            int iZzm = zzfpVar3.zzm();
            int iZzq = zzfpVar3.zzq();
            int iZzd = zzfpVar3.zzd() + iZzq;
            zzec zzecVar = null;
            if (iZzd > iZze) {
                zzfpVar3.zzK(iZze);
            } else {
                if (iZzm != 128) {
                    switch (iZzm) {
                        case 20:
                            zzale.zzd(zzaleVar, zzfpVar3, iZzq);
                            break;
                        case 21:
                            zzale.zzb(zzaleVar, zzfpVar3, iZzq);
                            break;
                        case 22:
                            zzale.zzc(zzaleVar, zzfpVar3, iZzq);
                            break;
                    }
                } else {
                    zzec zzecVarZza = zzaleVar.zza();
                    zzaleVar.zze();
                    zzecVar = zzecVarZza;
                }
                zzfpVar3.zzK(iZzd);
            }
            if (zzecVar != null) {
                arrayList.add(zzecVar);
            }
        }
    }
}
