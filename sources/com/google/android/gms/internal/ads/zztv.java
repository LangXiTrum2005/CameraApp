package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zztv implements zzwh {
    public final zzwh zza;
    final /* synthetic */ zztw zzb;
    private boolean zzc;

    public zztv(zztw zztwVar, zzwh zzwhVar) {
        this.zzb = zztwVar;
        this.zza = zzwhVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zza(zzlb zzlbVar, zzih zzihVar, int i) {
        zztw zztwVar = this.zzb;
        if (zztwVar.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzihVar.zzc(4);
            return -4;
        }
        long jZzb = zztwVar.zzb();
        int iZza = this.zza.zza(zzlbVar, zzihVar, i);
        if (iZza != -5) {
            long j = this.zzb.zzb;
            if (j == Long.MIN_VALUE || ((iZza != -4 || zzihVar.zze < j) && !(iZza == -3 && jZzb == Long.MIN_VALUE && !zzihVar.zzd))) {
                return iZza;
            }
            zzihVar.zzb();
            zzihVar.zzc(4);
            this.zzc = true;
            return -4;
        }
        zzam zzamVar = zzlbVar.zza;
        zzamVar.getClass();
        int i2 = zzamVar.zzC;
        if (i2 != 0) {
            int i3 = this.zzb.zzb == Long.MIN_VALUE ? zzamVar.zzD : 0;
            zzak zzakVarZzb = zzamVar.zzb();
            zzakVarZzb.zzF(i2);
            zzakVarZzb.zzG(i3);
            zzlbVar.zza = zzakVarZzb.zzac();
        } else if (zzamVar.zzD != 0) {
            i2 = 0;
            if (this.zzb.zzb == Long.MIN_VALUE) {
            }
            zzak zzakVarZzb2 = zzamVar.zzb();
            zzakVarZzb2.zzF(i2);
            zzakVarZzb2.zzG(i3);
            zzlbVar.zza = zzakVarZzb2.zzac();
        }
        return -5;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
