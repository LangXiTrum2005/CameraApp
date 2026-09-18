package com.google.android.gms.internal.ads;

import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzafb extends zzafg {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzafb(zzaea zzaeaVar) {
        super(zzaeaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    protected final boolean zza(zzfp zzfpVar) throws zzaff {
        if (this.zzc) {
            zzfpVar.zzL(1);
        } else {
            int iZzm = zzfpVar.zzm();
            int i = iZzm >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(iZzm >> 2) & 3];
                zzak zzakVar = new zzak();
                zzakVar.zzW("audio/mpeg");
                zzakVar.zzy(1);
                zzakVar.zzX(i2);
                this.zza.zzl(zzakVar.zzac());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzak zzakVar2 = new zzak();
                zzakVar2.zzW(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw");
                zzakVar2.zzy(1);
                zzakVar2.zzX(8000);
                this.zza.zzl(zzakVar2.zzac());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzaff("Audio format not supported: " + i);
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    protected final boolean zzb(zzfp zzfpVar, long j) throws zzcc {
        if (this.zze == 2) {
            int iZzb = zzfpVar.zzb();
            this.zza.zzr(zzfpVar, iZzb);
            this.zza.zzt(j, 1, iZzb, 0, null);
            return true;
        }
        int iZzm = zzfpVar.zzm();
        if (iZzm != 0 || this.zzd) {
            if (this.zze == 10 && iZzm != 1) {
                return false;
            }
            int iZzb2 = zzfpVar.zzb();
            this.zza.zzr(zzfpVar, iZzb2);
            this.zza.zzt(j, 1, iZzb2, 0, null);
            return true;
        }
        int iZzb3 = zzfpVar.zzb();
        byte[] bArr = new byte[iZzb3];
        zzfpVar.zzG(bArr, 0, iZzb3);
        zzabr zzabrVarZza = zzabs.zza(bArr);
        zzak zzakVar = new zzak();
        zzakVar.zzW("audio/mp4a-latm");
        zzakVar.zzz(zzabrVarZza.zzc);
        zzakVar.zzy(zzabrVarZza.zzb);
        zzakVar.zzX(zzabrVarZza.zza);
        zzakVar.zzL(Collections.singletonList(bArr));
        this.zza.zzl(zzakVar.zzac());
        this.zzd = true;
        return false;
    }
}
