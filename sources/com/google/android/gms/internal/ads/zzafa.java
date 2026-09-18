package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzafa implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaez
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzafa.zza;
            return new zzacu[]{new zzafa(0)};
        }
    };
    private final byte[] zzb;
    private final zzfp zzc;
    private final zzadc zzd;
    private zzacx zze;
    private zzaea zzf;
    private int zzg;
    private zzby zzh;
    private zzadh zzi;
    private int zzj;
    private int zzk;
    private zzaey zzl;
    private int zzm;
    private long zzn;

    public zzafa() {
        this(0);
    }

    private final long zza(zzfp zzfpVar, boolean z) {
        boolean zZzc;
        this.zzi.getClass();
        int iZzd = zzfpVar.zzd();
        while (iZzd <= zzfpVar.zze() - 16) {
            zzfpVar.zzK(iZzd);
            if (zzadd.zzc(zzfpVar, this.zzi, this.zzk, this.zzd)) {
                zzfpVar.zzK(iZzd);
                return this.zzd.zza;
            }
            iZzd++;
        }
        if (!z) {
            zzfpVar.zzK(iZzd);
            return -1L;
        }
        while (iZzd <= zzfpVar.zze() - this.zzj) {
            zzfpVar.zzK(iZzd);
            try {
                zZzc = zzadd.zzc(zzfpVar, this.zzi, this.zzk, this.zzd);
            } catch (IndexOutOfBoundsException unused) {
                zZzc = false;
            }
            if (zzfpVar.zzd() <= zzfpVar.zze() && zZzc) {
                zzfpVar.zzK(iZzd);
                return this.zzd.zza;
            }
            iZzd++;
        }
        zzfpVar.zzK(zzfpVar.zze());
        return -1L;
    }

    private final void zzf() {
        long j = this.zzn * 1000000;
        zzadh zzadhVar = this.zzi;
        int i = zzfy.zza;
        this.zzf.zzt(j / ((long) zzadhVar.zze), 1, this.zzm, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zze = zzacxVar;
        this.zzf = zzacxVar.zzw(0, 1);
        zzacxVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        zzade.zza(zzacvVar, false);
        zzfp zzfpVar = new zzfp(4);
        ((zzack) zzacvVar).zzm(zzfpVar.zzM(), 0, 4, false);
        return zzfpVar.zzu() == 1716281667;
    }

    public zzafa(int i) {
        this.zzb = new byte[42];
        this.zzc = new zzfp(new byte[32768], 0);
        this.zzd = new zzadc();
        this.zzg = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        if (j == 0) {
            this.zzg = 0;
        } else {
            zzaey zzaeyVar = this.zzl;
            if (zzaeyVar != null) {
                zzaeyVar.zzd(j2);
            }
        }
        this.zzn = j2 != 0 ? -1L : 0L;
        this.zzm = 0;
        this.zzc.zzH(0);
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        boolean zZzo;
        zzadu zzadtVar;
        boolean z;
        int i = this.zzg;
        if (i == 0) {
            zzacvVar.zzj();
            long jZze = zzacvVar.zze();
            zzby zzbyVarZza = zzade.zza(zzacvVar, true);
            ((zzack) zzacvVar).zzo((int) (zzacvVar.zze() - jZze), false);
            this.zzh = zzbyVarZza;
            this.zzg = 1;
            return 0;
        }
        if (i == 1) {
            ((zzack) zzacvVar).zzm(this.zzb, 0, 42, false);
            zzacvVar.zzj();
            this.zzg = 2;
            return 0;
        }
        if (i == 2) {
            zzfp zzfpVar = new zzfp(4);
            ((zzack) zzacvVar).zzn(zzfpVar.zzM(), 0, 4, false);
            if (zzfpVar.zzu() != 1716281667) {
                throw zzcc.zza("Failed to read FLAC stream marker.", null);
            }
            this.zzg = 3;
            return 0;
        }
        if (i == 3) {
            zzadh zzadhVarZze = this.zzi;
            do {
                zzacvVar.zzj();
                zzfo zzfoVar = new zzfo(new byte[4], 4);
                zzack zzackVar = (zzack) zzacvVar;
                zzackVar.zzm(zzfoVar.zza, 0, 4, false);
                zZzo = zzfoVar.zzo();
                int iZzd = zzfoVar.zzd(7);
                int iZzd2 = zzfoVar.zzd(24) + 4;
                if (iZzd == 0) {
                    byte[] bArr = new byte[38];
                    zzackVar.zzn(bArr, 0, 38, false);
                    zzadhVarZze = new zzadh(bArr, 4);
                } else {
                    if (zzadhVarZze == null) {
                        throw new IllegalArgumentException();
                    }
                    if (iZzd == 3) {
                        zzfp zzfpVar2 = new zzfp(iZzd2);
                        zzackVar.zzn(zzfpVar2.zzM(), 0, iZzd2, false);
                        zzadhVarZze = zzadhVarZze.zzf(zzade.zzb(zzfpVar2));
                    } else if (iZzd == 4) {
                        zzfp zzfpVar3 = new zzfp(iZzd2);
                        zzackVar.zzn(zzfpVar3.zzM(), 0, iZzd2, false);
                        zzfpVar3.zzL(4);
                        zzadhVarZze = zzadhVarZze.zzg(Arrays.asList(zzaeg.zzc(zzfpVar3, false, false).zzb));
                    } else if (iZzd == 6) {
                        zzfp zzfpVar4 = new zzfp(iZzd2);
                        zzackVar.zzn(zzfpVar4.zzM(), 0, iZzd2, false);
                        zzfpVar4.zzL(4);
                        zzadhVarZze = zzadhVarZze.zze(zzgaa.zzm(zzafw.zzb(zzfpVar4)));
                    } else {
                        zzackVar.zzo(iZzd2, false);
                    }
                }
                int i2 = zzfy.zza;
                this.zzi = zzadhVarZze;
            } while (!zZzo);
            zzadhVarZze.getClass();
            this.zzj = Math.max(zzadhVarZze.zzc, 6);
            this.zzf.zzl(this.zzi.zzc(this.zzb, this.zzh));
            this.zzg = 4;
            return 0;
        }
        if (i == 4) {
            zzacvVar.zzj();
            zzfp zzfpVar5 = new zzfp(2);
            ((zzack) zzacvVar).zzm(zzfpVar5.zzM(), 0, 2, false);
            int iZzq = zzfpVar5.zzq();
            if ((iZzq >> 2) != 16382) {
                zzacvVar.zzj();
                throw zzcc.zza("First frame does not start with sync code.", null);
            }
            zzacvVar.zzj();
            this.zzk = iZzq;
            zzacx zzacxVar = this.zze;
            int i3 = zzfy.zza;
            long jZzf = zzacvVar.zzf();
            long jZzd = zzacvVar.zzd();
            zzadh zzadhVar = this.zzi;
            zzadhVar.getClass();
            if (zzadhVar.zzk != null) {
                zzadtVar = new zzadf(zzadhVar, jZzf);
            } else if (jZzd == -1 || zzadhVar.zzj <= 0) {
                zzadtVar = new zzadt(zzadhVar.zza(), 0L);
            } else {
                zzaey zzaeyVar = new zzaey(zzadhVar, this.zzk, jZzf, jZzd);
                this.zzl = zzaeyVar;
                zzadtVar = zzaeyVar.zzb();
            }
            zzacxVar.zzO(zzadtVar);
            this.zzg = 5;
            return 0;
        }
        this.zzf.getClass();
        zzadh zzadhVar2 = this.zzi;
        zzadhVar2.getClass();
        zzaey zzaeyVar2 = this.zzl;
        if (zzaeyVar2 != null && zzaeyVar2.zze()) {
            return zzaeyVar2.zza(zzacvVar, zzadrVar);
        }
        if (this.zzn == -1) {
            this.zzn = zzadd.zzb(zzacvVar, zzadhVar2);
            return 0;
        }
        zzfp zzfpVar6 = this.zzc;
        int iZze = zzfpVar6.zze();
        if (iZze < 32768) {
            int iZza = zzacvVar.zza(zzfpVar6.zzM(), iZze, 32768 - iZze);
            z = iZza == -1;
            if (!z) {
                this.zzc.zzJ(iZze + iZza);
            } else if (this.zzc.zzb() == 0) {
                zzf();
                return -1;
            }
        } else {
            z = false;
        }
        zzfp zzfpVar7 = this.zzc;
        int iZzd3 = zzfpVar7.zzd();
        int i4 = this.zzm;
        int i5 = this.zzj;
        if (i4 < i5) {
            zzfpVar7.zzL(Math.min(i5 - i4, zzfpVar7.zzb()));
        }
        long jZza = zza(this.zzc, z);
        zzfp zzfpVar8 = this.zzc;
        int iZzd4 = zzfpVar8.zzd() - iZzd3;
        zzfpVar8.zzK(iZzd3);
        zzady.zzb(this.zzf, this.zzc, iZzd4);
        this.zzm += iZzd4;
        if (jZza != -1) {
            zzf();
            this.zzm = 0;
            this.zzn = jZza;
        }
        zzfp zzfpVar9 = this.zzc;
        if (zzfpVar9.zzb() >= 16) {
            return 0;
        }
        int iZzb = zzfpVar9.zzb();
        System.arraycopy(zzfpVar9.zzM(), zzfpVar9.zzd(), zzfpVar9.zzM(), 0, iZzb);
        this.zzc.zzK(0);
        this.zzc.zzJ(iZzb);
        return 0;
    }
}
