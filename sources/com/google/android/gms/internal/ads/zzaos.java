package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Pair;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaos implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaoo
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzaos.zza;
            return new zzacu[]{new zzaos()};
        }
    };
    private zzacx zzb;
    private zzaea zzc;
    private zzaoq zzf;
    private int zzd = 0;
    private long zze = -1;
    private int zzg = -1;
    private long zzh = -1;

    /* JADX WARN: Code duplicated, block: B:47:0x00f0  */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        int i;
        zzek.zzb(this.zzc);
        int i2 = zzfy.zza;
        int i3 = this.zzd;
        int iZzk = 4;
        if (i3 == 0) {
            zzek.zzf(zzacvVar.zzf() == 0);
            int i4 = this.zzg;
            if (i4 != -1) {
                ((zzack) zzacvVar).zzo(i4, false);
                this.zzd = 4;
            } else {
                if (!zzaov.zzc(zzacvVar)) {
                    throw zzcc.zza("Unsupported or unrecognized wav file type.", null);
                }
                ((zzack) zzacvVar).zzo((int) (zzacvVar.zze() - zzacvVar.zzf()), false);
                this.zzd = 1;
            }
            return 0;
        }
        long jZzr = -1;
        if (i3 == 1) {
            zzfp zzfpVar = new zzfp(8);
            zzaou zzaouVarZza = zzaou.zza(zzacvVar, zzfpVar);
            if (zzaouVarZza.zza != 1685272116) {
                zzacvVar.zzj();
            } else {
                zzack zzackVar = (zzack) zzacvVar;
                zzackVar.zzl(8, false);
                zzfpVar.zzK(0);
                zzackVar.zzm(zzfpVar.zzM(), 0, 8, false);
                jZzr = zzfpVar.zzr();
                zzackVar.zzo(((int) zzaouVarZza.zzb) + 8, false);
            }
            this.zze = jZzr;
            this.zzd = 2;
            return 0;
        }
        if (i3 == 2) {
            zzaot zzaotVarZzb = zzaov.zzb(zzacvVar);
            int i5 = zzaotVarZzb.zza;
            if (i5 == 17) {
                this.zzf = new zzaop(this.zzb, this.zzc, zzaotVarZzb);
            } else if (i5 == 6) {
                this.zzf = new zzaor(this.zzb, this.zzc, zzaotVarZzb, "audio/g711-alaw", -1);
            } else if (i5 == 7) {
                this.zzf = new zzaor(this.zzb, this.zzc, zzaotVarZzb, "audio/g711-mlaw", -1);
            } else {
                int i6 = zzaotVarZzb.zze;
                if (i5 == 1) {
                    iZzk = zzfy.zzk(i6);
                    i = iZzk;
                } else {
                    if (i5 != 3) {
                        if (i5 == 65534) {
                            iZzk = zzfy.zzk(i6);
                            i = iZzk;
                        }
                    } else if (i6 == 32) {
                        i = iZzk;
                    }
                    i = 0;
                }
                if (i == 0) {
                    throw zzcc.zzc("Unsupported WAV format type: " + i5);
                }
                this.zzf = new zzaor(this.zzb, this.zzc, zzaotVarZzb, "audio/raw", i);
            }
            this.zzd = 3;
            return 0;
        }
        if (i3 != 3) {
            zzek.zzf(this.zzh != -1);
            long jZzf = this.zzh - zzacvVar.zzf();
            zzaoq zzaoqVar = this.zzf;
            zzaoqVar.getClass();
            return zzaoqVar.zzc(zzacvVar, jZzf) ? -1 : 0;
        }
        Pair pairZza = zzaov.zza(zzacvVar);
        this.zzg = ((Long) pairZza.first).intValue();
        long jLongValue = ((Long) pairZza.second).longValue();
        long j = this.zze;
        if (j != -1 && jLongValue == 4294967295L) {
            jLongValue = j;
        }
        long j2 = ((long) this.zzg) + jLongValue;
        this.zzh = j2;
        long jZzd = zzacvVar.zzd();
        if (jZzd != -1 && j2 > jZzd) {
            zzff.zzf("WavExtractor", "Data exceeds input length: " + j2 + ", " + jZzd);
            this.zzh = jZzd;
            j2 = jZzd;
        }
        zzaoq zzaoqVar2 = this.zzf;
        zzaoqVar2.getClass();
        zzaoqVar2.zza(this.zzg, j2);
        this.zzd = 4;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzb = zzacxVar;
        this.zzc = zzacxVar.zzw(0, 1);
        zzacxVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        this.zzd = j == 0 ? 0 : 4;
        zzaoq zzaoqVar = this.zzf;
        if (zzaoqVar != null) {
            zzaoqVar.zzb(j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return zzaov.zzc(zzacvVar);
    }
}
