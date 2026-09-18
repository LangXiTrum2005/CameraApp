package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaka extends zzake {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    zzaka() {
    }

    public static boolean zzd(zzfp zzfpVar) {
        return zzk(zzfpVar, zza);
    }

    private static boolean zzk(zzfp zzfpVar, byte[] bArr) {
        if (zzfpVar.zzb() < 8) {
            return false;
        }
        int iZzd = zzfpVar.zzd();
        byte[] bArr2 = new byte[8];
        zzfpVar.zzG(bArr2, 0, 8);
        zzfpVar.zzK(iZzd);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzake
    protected final long zza(zzfp zzfpVar) {
        return zzg(zzadq.zzd(zzfpVar.zzM()));
    }

    @Override // com.google.android.gms.internal.ads.zzake
    protected final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzake
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzfp zzfpVar, long j, zzakb zzakbVar) throws zzcc {
        if (zzk(zzfpVar, zza)) {
            byte[] bArrCopyOf = Arrays.copyOf(zzfpVar.zzM(), zzfpVar.zze());
            int i = bArrCopyOf[9] & 255;
            List listZze = zzadq.zze(bArrCopyOf);
            if (zzakbVar.zza == null) {
                zzak zzakVar = new zzak();
                zzakVar.zzW("audio/opus");
                zzakVar.zzy(i);
                zzakVar.zzX(48000);
                zzakVar.zzL(listZze);
                zzakbVar.zza = zzakVar.zzac();
                return true;
            }
        } else {
            if (!zzk(zzfpVar, zzb)) {
                zzek.zzb(zzakbVar.zza);
                return false;
            }
            zzek.zzb(zzakbVar.zza);
            if (!this.zzc) {
                this.zzc = true;
                zzfpVar.zzL(8);
                zzby zzbyVarZzb = zzaeg.zzb(zzgaa.zzk(zzaeg.zzc(zzfpVar, false, false).zzb));
                if (zzbyVarZzb != null) {
                    zzak zzakVarZzb = zzakbVar.zza.zzb();
                    zzakVarZzb.zzP(zzbyVarZzb.zzd(zzakbVar.zza.zzk));
                    zzakbVar.zza = zzakVarZzb.zzac();
                }
            }
        }
        return true;
    }
}
