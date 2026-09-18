package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaju extends zzake {
    private zzadh zza;
    private zzajt zzb;

    zzaju() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzake
    protected final long zza(zzfp zzfpVar) {
        if (!zzd(zzfpVar.zzM())) {
            return -1L;
        }
        int i = (zzfpVar.zzM()[2] & 255) >> 4;
        if (i == 6) {
            zzfpVar.zzL(4);
            zzfpVar.zzw();
        } else if (i == 7) {
            i = 7;
            zzfpVar.zzL(4);
            zzfpVar.zzw();
        }
        int iZza = zzadd.zza(zzfpVar, i);
        zzfpVar.zzK(0);
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzake
    protected final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzake
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzfp zzfpVar, long j, zzakb zzakbVar) {
        byte[] bArrZzM = zzfpVar.zzM();
        zzadh zzadhVar = this.zza;
        if (zzadhVar == null) {
            zzadh zzadhVar2 = new zzadh(bArrZzM, 17);
            this.zza = zzadhVar2;
            zzakbVar.zza = zzadhVar2.zzc(Arrays.copyOfRange(bArrZzM, 9, zzfpVar.zze()), null);
            return true;
        }
        if ((bArrZzM[0] & 127) == 3) {
            zzadg zzadgVarZzb = zzade.zzb(zzfpVar);
            zzadh zzadhVarZzf = zzadhVar.zzf(zzadgVarZzb);
            this.zza = zzadhVarZzf;
            this.zzb = new zzajt(zzadhVarZzf, zzadgVarZzb);
            return true;
        }
        if (!zzd(bArrZzM)) {
            return true;
        }
        zzajt zzajtVar = this.zzb;
        if (zzajtVar != null) {
            zzajtVar.zza(j);
            zzakbVar.zzb = this.zzb;
        }
        zzakbVar.zza.getClass();
        return false;
    }
}
