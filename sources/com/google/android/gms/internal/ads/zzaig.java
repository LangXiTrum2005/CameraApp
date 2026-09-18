package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaig implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaie
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzaig.zza;
            return new zzacu[]{new zzaig(0)};
        }
    };
    private static final zzago zzb = new zzago() { // from class: com.google.android.gms.internal.ads.zzaif
    };
    private final zzfp zzc;
    private final zzado zzd;
    private final zzadk zze;
    private final zzadm zzf;
    private final zzaea zzg;
    private zzacx zzh;
    private zzaea zzi;
    private zzaea zzj;
    private int zzk;
    private zzby zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private int zzp;
    private zzaii zzq;
    private boolean zzr;

    public zzaig() {
        this(0);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0212  */
    /* JADX WARN: Code duplicated, block: B:107:0x021b  */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0066  */
    /* JADX WARN: Code duplicated, block: B:26:0x006e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:29:0x0079  */
    /* JADX WARN: Code duplicated, block: B:35:0x009b  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d5  */
    /* JADX WARN: Multi-variable type inference failed */
    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    private final int zzf(zzacv zzacvVar) throws IOException {
        int iZzf;
        int i;
        int iZzg;
        zzadk zzadkVar;
        zzail zzailVarZzb;
        zzaii zzaiiVarZzh;
        int i2;
        int i3;
        zzaid zzaidVarZzb;
        long jZzq;
        if (this.zzk == 0) {
            try {
                zzk(zzacvVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.zzq == null) {
            zzfp zzfpVar = new zzfp(this.zzd.zzc);
            zzack zzackVar = (zzack) zzacvVar;
            zzackVar.zzm(zzfpVar.zzM(), 0, this.zzd.zzc, false);
            zzado zzadoVar = this.zzd;
            int i4 = 21;
            if ((zzadoVar.zza & 1) != 0) {
                if (zzadoVar.zze != 1) {
                    i4 = 36;
                }
            } else if (zzadoVar.zze == 1) {
                i4 = 13;
            }
            if (zzfpVar.zze() >= i4 + 4) {
                zzfpVar.zzK(i4);
                iZzg = zzfpVar.zzg();
                if (iZzg != 1483304551) {
                    if (iZzg == 1231971951) {
                        iZzg = 1231971951;
                    } else if (zzfpVar.zze() >= 40) {
                        zzfpVar.zzK(36);
                        if (zzfpVar.zzg() == 1447187017) {
                            iZzg = 1447187017;
                        } else {
                            iZzg = 0;
                        }
                    } else {
                        iZzg = 0;
                    }
                }
            } else if (zzfpVar.zze() >= 40) {
                zzfpVar.zzK(36);
                if (zzfpVar.zzg() == 1447187017) {
                    iZzg = 1447187017;
                } else {
                    iZzg = 0;
                }
            } else {
                iZzg = 0;
            }
            if (iZzg == 1231971951) {
                zzaik zzaikVarZza = zzaik.zza(this.zzd, zzfpVar);
                zzadkVar = this.zze;
                if (!zzadkVar.zza() && (i2 = zzaikVarZza.zzd) != -1 && (i3 = zzaikVarZza.zze) != -1) {
                    zzadkVar.zza = i2;
                    zzadkVar.zzb = i3;
                }
                zzailVarZzb = zzail.zzb(zzacvVar.zzd(), zzaikVarZza, zzacvVar.zzf());
                zzackVar.zzo(this.zzd.zzc, false);
                if (zzailVarZzb.zzh() && iZzg == 1231971951) {
                    zzaiiVarZzh = zzh(zzacvVar, false);
                } else {
                    zzaiiVarZzh = zzailVarZzb;
                }
            } else if (iZzg == 1447187017) {
                zzaiiVarZzh = zzaij.zzb(zzacvVar.zzd(), zzacvVar.zzf(), this.zzd, zzfpVar);
                zzackVar.zzo(this.zzd.zzc, false);
            } else if (iZzg != 1483304551) {
                zzacvVar.zzj();
                zzaiiVarZzh = null;
            } else {
                zzaik zzaikVarZza2 = zzaik.zza(this.zzd, zzfpVar);
                zzadkVar = this.zze;
                if (!zzadkVar.zza()) {
                    zzadkVar.zza = i2;
                    zzadkVar.zzb = i3;
                }
                zzailVarZzb = zzail.zzb(zzacvVar.zzd(), zzaikVarZza2, zzacvVar.zzf());
                zzackVar.zzo(this.zzd.zzc, false);
                if (zzailVarZzb.zzh()) {
                    zzaiiVarZzh = zzailVarZzb;
                } else {
                    zzaiiVarZzh = zzailVarZzb;
                }
            }
            zzby zzbyVar = this.zzl;
            long jZzf = zzacvVar.zzf();
            if (zzbyVar == null) {
                zzaidVarZzb = null;
                break;
            }
            int iZza = zzbyVar.zza();
            int i5 = 0;
            while (true) {
                if (i5 >= iZza) {
                    zzaidVarZzb = null;
                    break;
                }
                zzbx zzbxVarZzb = zzbyVar.zzb(i5);
                if (zzbxVarZzb instanceof zzagv) {
                    zzagv zzagvVar = (zzagv) zzbxVarZzb;
                    int iZza2 = zzbyVar.zza();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= iZza2) {
                            jZzq = -9223372036854775807L;
                            break;
                        }
                        zzbx zzbxVarZzb2 = zzbyVar.zzb(i6);
                        if (zzbxVarZzb2 instanceof zzagz) {
                            zzagz zzagzVar = (zzagz) zzbxVarZzb2;
                            if (zzagzVar.zzf.equals("TLEN")) {
                                jZzq = zzfy.zzq(Long.parseLong((String) zzagzVar.zzc.get(0)));
                                break;
                            }
                        }
                        i6++;
                    }
                    zzaidVarZzb = zzaid.zzb(jZzf, zzagvVar, jZzq);
                    break;
                }
                i5++;
            }
            if (this.zzr) {
                zzaiiVarZzh = new zzaih();
            } else {
                if (zzaidVarZzb != null) {
                    zzaiiVarZzh = zzaidVarZzb;
                } else if (zzaiiVarZzh == null) {
                    zzaiiVarZzh = null;
                }
                if (zzaiiVarZzh != null) {
                    zzaiiVarZzh.zzh();
                } else {
                    zzaiiVarZzh = zzh(zzacvVar, false);
                }
            }
            this.zzq = zzaiiVarZzh;
            this.zzh.zzO(zzaiiVarZzh);
            zzaea zzaeaVar = this.zzj;
            zzak zzakVar = new zzak();
            zzakVar.zzW(this.zzd.zzb);
            zzakVar.zzO(4096);
            zzakVar.zzy(this.zzd.zze);
            zzakVar.zzX(this.zzd.zzd);
            zzakVar.zzF(this.zze.zza);
            zzakVar.zzG(this.zze.zzb);
            zzakVar.zzP(this.zzl);
            zzaeaVar.zzl(zzakVar.zzac());
            this.zzo = zzacvVar.zzf();
        } else {
            long j = this.zzo;
            if (j != 0) {
                long jZzf2 = zzacvVar.zzf();
                if (jZzf2 < j) {
                    ((zzack) zzacvVar).zzo((int) (j - jZzf2), false);
                }
            }
        }
        int i7 = this.zzp;
        if (i7 == 0) {
            zzacvVar.zzj();
            if (zzj(zzacvVar)) {
                return -1;
            }
            this.zzc.zzK(0);
            int iZzg2 = this.zzc.zzg();
            if (!zzi(iZzg2, this.zzk) || zzadp.zzb(iZzg2) == -1) {
                ((zzack) zzacvVar).zzo(1, false);
                this.zzk = 0;
            } else {
                this.zzd.zza(iZzg2);
                if (this.zzm == -9223372036854775807L) {
                    this.zzm = this.zzq.zzd(zzacvVar.zzf());
                }
                zzado zzadoVar2 = this.zzd;
                int i8 = zzadoVar2.zzc;
                this.zzp = i8;
                zzaii zzaiiVar = this.zzq;
                if (zzaiiVar instanceof zzaic) {
                    zzg(this.zzn + ((long) zzadoVar2.zzg));
                    throw null;
                }
                i7 = i8;
                iZzf = this.zzj.zzf(zzacvVar, i7, true);
                if (iZzf == -1) {
                    return -1;
                }
                i = this.zzp - iZzf;
                this.zzp = i;
                if (i <= 0) {
                    this.zzj.zzt(zzg(this.zzn), 1, this.zzd.zzc, 0, null);
                    this.zzn += (long) this.zzd.zzg;
                    this.zzp = 0;
                    return 0;
                }
            }
        } else {
            iZzf = this.zzj.zzf(zzacvVar, i7, true);
            if (iZzf == -1) {
                return -1;
            }
            i = this.zzp - iZzf;
            this.zzp = i;
            if (i <= 0) {
                this.zzj.zzt(zzg(this.zzn), 1, this.zzd.zzc, 0, null);
                this.zzn += (long) this.zzd.zzg;
                this.zzp = 0;
                return 0;
            }
        }
        return 0;
    }

    private final long zzg(long j) {
        return this.zzm + ((j * 1000000) / ((long) this.zzd.zzd));
    }

    private final zzaii zzh(zzacv zzacvVar, boolean z) throws IOException {
        ((zzack) zzacvVar).zzm(this.zzc.zzM(), 0, 4, false);
        this.zzc.zzK(0);
        this.zzd.zza(this.zzc.zzg());
        return new zzaib(zzacvVar.zzd(), zzacvVar.zzf(), this.zzd, false);
    }

    private static boolean zzi(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    private final boolean zzj(zzacv zzacvVar) throws IOException {
        zzaii zzaiiVar = this.zzq;
        if (zzaiiVar != null) {
            long jZzc = zzaiiVar.zzc();
            if (jZzc != -1 && zzacvVar.zze() > jZzc - 4) {
                return true;
            }
        }
        try {
            return !zzacvVar.zzm(this.zzc.zzM(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzk(zzacv zzacvVar, boolean z) throws IOException {
        int iZze;
        int i;
        int iZzb;
        zzacvVar.zzj();
        if (zzacvVar.zzf() == 0) {
            zzby zzbyVarZza = this.zzf.zza(zzacvVar, null);
            this.zzl = zzbyVarZza;
            if (zzbyVarZza != null) {
                this.zze.zzb(zzbyVarZza);
            }
            iZze = (int) zzacvVar.zze();
            if (!z) {
                ((zzack) zzacvVar).zzo(iZze, false);
            }
            i = 0;
        } else {
            iZze = 0;
            i = 0;
        }
        int i2 = i;
        int i3 = i2;
        while (true) {
            if (zzj(zzacvVar)) {
                if (i2 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.zzc.zzK(0);
            int iZzg = this.zzc.zzg();
            if ((i == 0 || zzi(iZzg, i)) && (iZzb = zzadp.zzb(iZzg)) != -1) {
                i2++;
                if (i2 != 1) {
                    if (i2 == 4) {
                        break;
                    }
                } else {
                    this.zzd.zza(iZzg);
                    i = iZzg;
                }
                ((zzack) zzacvVar).zzl(iZzb - 4, false);
            } else {
                int i4 = i3 + 1;
                if (i3 == (true != z ? 131072 : 32768)) {
                    if (z) {
                        return false;
                    }
                    throw zzcc.zza("Searched too many bytes.", null);
                }
                if (z) {
                    zzacvVar.zzj();
                    ((zzack) zzacvVar).zzl(iZze + i4, false);
                } else {
                    ((zzack) zzacvVar).zzo(1, false);
                }
                i = 0;
                i3 = i4;
                i2 = 0;
            }
        }
        if (z) {
            ((zzack) zzacvVar).zzo(iZze + i3, false);
        } else {
            zzacvVar.zzj();
        }
        this.zzk = i;
        return true;
    }

    public final void zza() {
        this.zzr = true;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        zzek.zzb(this.zzi);
        int i = zzfy.zza;
        int iZzf = zzf(zzacvVar);
        if (iZzf == -1 && (this.zzq instanceof zzaic)) {
            if (this.zzq.zza() != zzg(this.zzn)) {
                throw null;
            }
        }
        return iZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzh = zzacxVar;
        zzaea zzaeaVarZzw = zzacxVar.zzw(0, 1);
        this.zzi = zzaeaVarZzw;
        this.zzj = zzaeaVarZzw;
        this.zzh.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        this.zzk = 0;
        this.zzm = -9223372036854775807L;
        this.zzn = 0L;
        this.zzp = 0;
        zzaii zzaiiVar = this.zzq;
        if (zzaiiVar instanceof zzaic) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return zzk(zzacvVar, true);
    }

    public zzaig(int i) {
        this.zzc = new zzfp(10);
        this.zzd = new zzado();
        this.zze = new zzadk();
        this.zzm = -9223372036854775807L;
        this.zzf = new zzadm();
        zzact zzactVar = new zzact();
        this.zzg = zzactVar;
        this.zzj = zzactVar;
    }
}
