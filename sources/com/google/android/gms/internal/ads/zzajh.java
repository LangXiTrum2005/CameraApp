package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajh implements zzacu, zzadu {

    @Deprecated
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzajf
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzajh.zza;
            return new zzacu[]{new zzajh()};
        }
    };
    private zzahe zzA;
    private final zzakp zzb;
    private final int zzc;
    private final zzfp zzd;
    private final zzfp zze;
    private final zzfp zzf;
    private final zzfp zzg;
    private final ArrayDeque zzh;
    private final zzajk zzi;
    private final List zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private int zzn;
    private zzfp zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private zzacx zzu;
    private zzajg[] zzv;
    private long[][] zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    @Deprecated
    public zzajh() {
        this(zzakp.zza, 16);
    }

    private static int zzf(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzi(zzajp zzajpVar, long j) {
        int iZza = zzajpVar.zza(j);
        return iZza == -1 ? zzajpVar.zzb(j) : iZza;
    }

    private static long zzj(zzajp zzajpVar, long j, long j2) {
        int iZzi = zzi(zzajpVar, j);
        return iZzi == -1 ? j2 : Math.min(zzajpVar.zzc[iZzi], j2);
    }

    private final void zzk() {
        this.zzk = 0;
        this.zzn = 0;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x012c  */
    private final void zzl(long j) throws zzcc {
        zzby zzbyVar;
        long j2;
        int i;
        zzby zzbyVar2;
        int i2;
        while (!this.zzh.isEmpty() && ((zzaim) this.zzh.peek()).zza == j) {
            zzaim zzaimVar = (zzaim) this.zzh.pop();
            if (zzaimVar.zzd == 1836019574) {
                ArrayList arrayList = new ArrayList();
                int i3 = this.zzz;
                zzadk zzadkVar = new zzadk();
                zzain zzainVarZzb = zzaimVar.zzb(1969517665);
                if (zzainVarZzb != null) {
                    zzby zzbyVarZzb = zzaiw.zzb(zzainVarZzb);
                    zzadkVar.zzb(zzbyVarZzb);
                    zzbyVar = zzbyVarZzb;
                } else {
                    zzbyVar = null;
                }
                zzaim zzaimVarZza = zzaimVar.zza(1835365473);
                zzby zzbyVarZza = zzaimVarZza != null ? zzaiw.zza(zzaimVarZza) : null;
                zzbx[] zzbxVarArr = new zzbx[1];
                zzain zzainVarZzb2 = zzaimVar.zzb(1836476516);
                zzainVarZzb2.getClass();
                boolean z = i3 == 1;
                zzbxVarArr[0] = zzaiw.zzc(zzainVarZzb2.zza);
                zzby zzbyVar3 = new zzby(-9223372036854775807L, zzbxVarArr);
                zzby zzbyVar4 = zzbyVar;
                long j3 = -9223372036854775807L;
                List listZzd = zzaiw.zzd(zzaimVar, zzadkVar, -9223372036854775807L, null, 1 == (this.zzc & 1), z, new zzfws() { // from class: com.google.android.gms.internal.ads.zzaje
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        zzajm zzajmVar = (zzajm) obj;
                        zzadb zzadbVar = zzajh.zza;
                        return zzajmVar;
                    }
                });
                int size = listZzd.size();
                long j4 = -9223372036854775807L;
                int size2 = -1;
                int i4 = 0;
                while (true) {
                    j2 = 0;
                    if (i4 >= size) {
                        break;
                    }
                    zzajp zzajpVar = (zzajp) listZzd.get(i4);
                    if (zzajpVar.zzb != 0) {
                        zzajm zzajmVar = zzajpVar.zza;
                        long j5 = zzajmVar.zze;
                        if (j5 == j3) {
                            j5 = zzajpVar.zzh;
                        }
                        long jMax = Math.max(j4, j5);
                        zzajg zzajgVar = new zzajg(zzajmVar, zzajpVar, this.zzu.zzw(i4, zzajmVar.zzb));
                        int i5 = "audio/true-hd".equals(zzajmVar.zzf.zzm) ? zzajpVar.zze * 16 : zzajpVar.zze + 30;
                        zzak zzakVarZzb = zzajmVar.zzf.zzb();
                        zzakVarZzb.zzO(i5);
                        if (zzajmVar.zzb != 2) {
                            i = 1;
                        } else {
                            if ((this.zzc & 8) != 0) {
                                zzakVarZzb.zzU(zzajmVar.zzf.zzf | (size2 == -1 ? 1 : 2));
                            }
                            if (j5 > 0) {
                                int i6 = zzajpVar.zzb;
                                i = 1;
                                if (i6 > 1) {
                                    zzakVarZzb.zzH(i6 / (j5 / 1000000.0f));
                                }
                            } else {
                                i = 1;
                            }
                        }
                        int i7 = zzajmVar.zzb;
                        int i8 = zzajd.zzb;
                        if (i7 == i && zzadkVar.zza()) {
                            zzakVarZzb.zzF(zzadkVar.zza);
                            zzakVarZzb.zzG(zzadkVar.zzb);
                        }
                        int i9 = zzajmVar.zzb;
                        zzby[] zzbyVarArr = new zzby[3];
                        if (this.zzj.isEmpty()) {
                            i2 = 0;
                            zzbyVar2 = null;
                        } else {
                            zzbyVar2 = new zzby(this.zzj);
                            i2 = 0;
                        }
                        zzbyVarArr[i2] = zzbyVar2;
                        zzbyVarArr[i] = zzbyVar4;
                        zzbyVarArr[2] = zzbyVar3;
                        zzby zzbyVar5 = new zzby(-9223372036854775807L, new zzbx[i2]);
                        if (zzbyVarZza != null) {
                            for (int i10 = i2; i10 < zzbyVarZza.zza(); i10++) {
                                zzbx zzbxVarZzb = zzbyVarZza.zzb(i10);
                                if (zzbxVarZzb instanceof zzgc) {
                                    zzgc zzgcVar = (zzgc) zzbxVarZzb;
                                    if (!zzgcVar.zza.equals("com.android.capture.fps")) {
                                        zzbyVar5 = zzbyVar5.zzc(zzgcVar);
                                    } else if (i9 == 2) {
                                        zzbyVar5 = zzbyVar5.zzc(zzgcVar);
                                    }
                                }
                            }
                        }
                        for (int i11 = 0; i11 < 3; i11++) {
                            zzbyVar5 = zzbyVar5.zzd(zzbyVarArr[i11]);
                        }
                        if (zzbyVar5.zza() > 0) {
                            zzakVarZzb.zzP(zzbyVar5);
                        }
                        zzajgVar.zzc.zzl(zzakVarZzb.zzac());
                        if (zzajmVar.zzb == 2 && size2 == -1) {
                            size2 = arrayList.size();
                        }
                        arrayList.add(zzajgVar);
                        j4 = jMax;
                    }
                    i4++;
                    zzadkVar = zzadkVar;
                    listZzd = listZzd;
                    size = size;
                    j3 = -9223372036854775807L;
                }
                this.zzx = size2;
                this.zzy = j4;
                zzajg[] zzajgVarArr = (zzajg[]) arrayList.toArray(new zzajg[0]);
                this.zzv = zzajgVarArr;
                int length = zzajgVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i12 = 0; i12 < zzajgVarArr.length; i12++) {
                    jArr[i12] = new long[zzajgVarArr[i12].zzb.zzb];
                    jArr2[i12] = zzajgVarArr[i12].zzb.zzf[0];
                }
                int i13 = 0;
                while (i13 < zzajgVarArr.length) {
                    int i14 = -1;
                    long j6 = Long.MAX_VALUE;
                    for (int i15 = 0; i15 < zzajgVarArr.length; i15++) {
                        if (!zArr[i15]) {
                            long j7 = jArr2[i15];
                            if (j7 <= j6) {
                                i14 = i15;
                                j6 = j7;
                            }
                        }
                    }
                    int i16 = iArr[i14];
                    long[] jArr3 = jArr[i14];
                    jArr3[i16] = j2;
                    zzajp zzajpVar2 = zzajgVarArr[i14].zzb;
                    j2 += (long) zzajpVar2.zzd[i16];
                    int i17 = i16 + 1;
                    iArr[i14] = i17;
                    if (i17 < jArr3.length) {
                        jArr2[i14] = zzajpVar2.zzf[i17];
                    } else {
                        zArr[i14] = true;
                        i13++;
                    }
                }
                this.zzw = jArr;
                this.zzu.zzD();
                this.zzu.zzO(this);
                this.zzh.clear();
                this.zzk = 2;
            } else if (!this.zzh.isEmpty()) {
                ((zzaim) this.zzh.peek()).zzc(zzaimVar);
            }
        }
        if (this.zzk != 2) {
            zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        if ((this.zzc & 16) == 0) {
            zzacxVar = new zzaks(zzacxVar, this.zzb);
        }
        this.zzu = zzacxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        this.zzh.clear();
        this.zzn = 0;
        this.zzp = -1;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        if (j == 0) {
            if (this.zzk != 3) {
                zzk();
                return;
            } else {
                this.zzi.zzb();
                this.zzj.clear();
                return;
            }
        }
        for (zzajg zzajgVar : this.zzv) {
            zzajp zzajpVar = zzajgVar.zzb;
            int iZza = zzajpVar.zza(j2);
            if (iZza == -1) {
                iZza = zzajpVar.zzb(j2);
            }
            zzajgVar.zze = iZza;
            zzaeb zzaebVar = zzajgVar.zzd;
            if (zzaebVar != null) {
                zzaebVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return zzajl.zzb(zzacvVar, (this.zzc & 2) != 0);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        long j2;
        long j3;
        int iZzb;
        zzajg[] zzajgVarArr = this.zzv;
        if (zzajgVarArr.length == 0) {
            zzadv zzadvVar = zzadv.zza;
            return new zzads(zzadvVar, zzadvVar);
        }
        int i = this.zzx;
        long jZzj = -1;
        if (i != -1) {
            zzajp zzajpVar = zzajgVarArr[i].zzb;
            int iZzi = zzi(zzajpVar, j);
            if (iZzi == -1) {
                zzadv zzadvVar2 = zzadv.zza;
                return new zzads(zzadvVar2, zzadvVar2);
            }
            long j4 = zzajpVar.zzf[iZzi];
            j2 = zzajpVar.zzc[iZzi];
            if (j4 >= j || iZzi >= zzajpVar.zzb - 1 || (iZzb = zzajpVar.zzb(j)) == -1 || iZzb == iZzi) {
                j3 = -9223372036854775807L;
            } else {
                j3 = zzajpVar.zzf[iZzb];
                jZzj = zzajpVar.zzc[iZzb];
            }
            j = j4;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            zzajg[] zzajgVarArr2 = this.zzv;
            if (i2 >= zzajgVarArr2.length) {
                break;
            }
            if (i2 != this.zzx) {
                zzajp zzajpVar2 = zzajgVarArr2[i2].zzb;
                long jZzj2 = zzj(zzajpVar2, j, j2);
                if (j3 != -9223372036854775807L) {
                    jZzj = zzj(zzajpVar2, j3, jZzj);
                }
                j2 = jZzj2;
            }
            i2++;
        }
        zzadv zzadvVar3 = new zzadv(j, j2);
        return j3 == -9223372036854775807L ? new zzads(zzadvVar3, zzadvVar3) : new zzads(zzadvVar3, new zzadv(j3, jZzj));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }

    public zzajh(zzakp zzakpVar, int i) {
        this.zzb = zzakpVar;
        this.zzc = i;
        this.zzk = (i & 4) != 0 ? 3 : 0;
        this.zzi = new zzajk();
        this.zzj = new ArrayList();
        this.zzg = new zzfp(16);
        this.zzh = new ArrayDeque();
        this.zzd = new zzfp(zzgm.zza);
        this.zze = new zzfp(4);
        this.zzf = new zzfp();
        this.zzp = -1;
        this.zzu = zzacx.zza;
        this.zzv = new zzajg[0];
    }

    /* JADX WARN: Code duplicated, block: B:278:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0080  */
    /* JADX WARN: Code duplicated, block: B:38:0x008f  */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        boolean z;
        boolean z2;
        while (true) {
            int i = this.zzk;
            if (i == 0) {
                if (this.zzn == 0) {
                    if (!zzacvVar.zzn(this.zzg.zzM(), 0, 8, true)) {
                        if (this.zzz != 2 || (this.zzc & 2) == 0) {
                            return -1;
                        }
                        zzaea zzaeaVarZzw = this.zzu.zzw(0, 4);
                        zzahe zzaheVar = this.zzA;
                        zzby zzbyVar = zzaheVar == null ? null : new zzby(-9223372036854775807L, zzaheVar);
                        zzak zzakVar = new zzak();
                        zzakVar.zzP(zzbyVar);
                        zzaeaVarZzw.zzl(zzakVar.zzac());
                        this.zzu.zzD();
                        this.zzu.zzO(new zzadt(-9223372036854775807L, 0L));
                        return -1;
                    }
                    this.zzn = 8;
                    this.zzg.zzK(0);
                    this.zzm = this.zzg.zzu();
                    this.zzl = this.zzg.zzg();
                }
                long j = this.zzm;
                if (j == 1) {
                    zzacvVar.zzi(this.zzg.zzM(), 8, 8);
                    this.zzn += 8;
                    this.zzm = this.zzg.zzv();
                } else if (j == 0) {
                    long jZzd = zzacvVar.zzd();
                    if (jZzd == -1) {
                        zzaim zzaimVar = (zzaim) this.zzh.peek();
                        jZzd = zzaimVar != null ? zzaimVar.zza : -1L;
                    }
                    if (jZzd != -1) {
                        this.zzm = (jZzd - zzacvVar.zzf()) + ((long) this.zzn);
                    }
                }
                long j2 = this.zzm;
                int i2 = this.zzn;
                if (j2 < i2) {
                    throw zzcc.zzc("Atom size less than header length (unsupported).");
                }
                int i3 = this.zzl;
                if (i3 == 1836019574 || i3 == 1953653099 || i3 == 1835297121 || i3 == 1835626086 || i3 == 1937007212 || i3 == 1701082227 || i3 == 1835365473) {
                    long jZzf = zzacvVar.zzf();
                    long j3 = this.zzm;
                    long j4 = jZzf + j3;
                    long j5 = this.zzn;
                    if (j3 != j5 && this.zzl == 1835365473) {
                        this.zzf.zzH(8);
                        zzacvVar.zzh(this.zzf.zzM(), 0, 8);
                        zzaiw.zze(this.zzf);
                        zzacvVar.zzk(this.zzf.zzd());
                        zzacvVar.zzj();
                    }
                    long j6 = j4 - j5;
                    this.zzh.push(new zzaim(this.zzl, j6));
                    if (this.zzm == this.zzn) {
                        zzl(j6);
                    } else {
                        zzk();
                    }
                } else if (i3 == 1835296868 || i3 == 1836476516 || i3 == 1751411826 || i3 == 1937011556 || i3 == 1937011827 || i3 == 1937011571 || i3 == 1668576371 || i3 == 1701606260 || i3 == 1937011555 || i3 == 1937011578 || i3 == 1937013298 || i3 == 1937007471 || i3 == 1668232756 || i3 == 1953196132 || i3 == 1718909296 || i3 == 1969517665 || i3 == 1801812339 || i3 == 1768715124) {
                    zzek.zzf(i2 == 8);
                    zzek.zzf(this.zzm <= 2147483647L);
                    zzfp zzfpVar = new zzfp((int) this.zzm);
                    System.arraycopy(this.zzg.zzM(), 0, zzfpVar.zzM(), 0, 8);
                    this.zzo = zzfpVar;
                    this.zzk = 1;
                } else {
                    long jZzf2 = zzacvVar.zzf();
                    long j7 = this.zzn;
                    long j8 = jZzf2 - j7;
                    if (this.zzl == 1836086884) {
                        this.zzA = new zzahe(0L, j8, -9223372036854775807L, j8 + j7, this.zzm - j7);
                    }
                    this.zzo = null;
                    this.zzk = 1;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        this.zzi.zza(zzacvVar, zzadrVar, this.zzj);
                        if (zzadrVar.zza == 0) {
                            zzk();
                        }
                        return 1;
                    }
                    long jZzf3 = zzacvVar.zzf();
                    int i4 = this.zzp;
                    if (i4 == -1) {
                        int i5 = -1;
                        int i6 = -1;
                        boolean z3 = true;
                        boolean z4 = true;
                        long j9 = Long.MAX_VALUE;
                        long j10 = Long.MAX_VALUE;
                        long j11 = Long.MAX_VALUE;
                        int i7 = 0;
                        while (true) {
                            zzajg[] zzajgVarArr = this.zzv;
                            if (i7 >= zzajgVarArr.length) {
                                break;
                            }
                            zzajg zzajgVar = zzajgVarArr[i7];
                            int i8 = zzajgVar.zze;
                            zzajp zzajpVar = zzajgVar.zzb;
                            if (i8 != zzajpVar.zzb) {
                                long j12 = zzajpVar.zzc[i8];
                                long[][] jArr = this.zzw;
                                int i9 = zzfy.zza;
                                long j13 = jArr[i7][i8];
                                long j14 = j12 - jZzf3;
                                boolean z5 = j14 < 0 || j14 >= 262144;
                                if (z5) {
                                    z = z4;
                                } else {
                                    if (z4) {
                                        z4 = z5;
                                        i6 = i7;
                                        j11 = j14;
                                        j10 = j13;
                                    } else {
                                        z = false;
                                    }
                                    if (j13 < j9) {
                                        z3 = z5;
                                        i5 = i7;
                                        j9 = j13;
                                    }
                                }
                                if (z5 != z || j14 >= j11) {
                                    z4 = z;
                                } else {
                                    z4 = z5;
                                    i6 = i7;
                                    j11 = j14;
                                    j10 = j13;
                                }
                                if (j13 < j9) {
                                    z3 = z5;
                                    i5 = i7;
                                    j9 = j13;
                                }
                            }
                            i7++;
                        }
                        i4 = (j9 == Long.MAX_VALUE || !z3 || j10 < j9 + 10485760) ? i6 : i5;
                        this.zzp = i4;
                        if (i4 == -1) {
                            return -1;
                        }
                    }
                    zzajg zzajgVar2 = this.zzv[i4];
                    zzaea zzaeaVar = zzajgVar2.zzc;
                    int i10 = zzajgVar2.zze;
                    zzajp zzajpVar2 = zzajgVar2.zzb;
                    long j15 = zzajpVar2.zzc[i10];
                    int i11 = zzajpVar2.zzd[i10];
                    zzaeb zzaebVar = zzajgVar2.zzd;
                    long j16 = (j15 - jZzf3) + ((long) this.zzq);
                    if (j16 < 0 || j16 >= 262144) {
                        zzadrVar.zza = j15;
                        return 1;
                    }
                    if (zzajgVar2.zza.zzg == 1) {
                        j16 += 8;
                        i11 -= 8;
                    }
                    zzacvVar.zzk((int) j16);
                    zzajm zzajmVar = zzajgVar2.zza;
                    int i12 = zzajmVar.zzj;
                    if (i12 == 0) {
                        if ("audio/ac4".equals(zzajmVar.zzf.zzm)) {
                            if (this.zzr == 0) {
                                zzaby.zzb(i11, this.zzf);
                                zzaeaVar.zzr(this.zzf, 7);
                                this.zzr += 7;
                            }
                            i11 += 7;
                        } else if (zzaebVar != null) {
                            zzaebVar.zzd(zzacvVar);
                        }
                        while (true) {
                            int i13 = this.zzr;
                            if (i13 >= i11) {
                                break;
                            }
                            int iZzf = zzaeaVar.zzf(zzacvVar, i11 - i13, false);
                            this.zzq += iZzf;
                            this.zzr += iZzf;
                            this.zzs -= iZzf;
                        }
                    } else {
                        byte[] bArrZzM = this.zze.zzM();
                        bArrZzM[0] = 0;
                        bArrZzM[1] = 0;
                        bArrZzM[2] = 0;
                        int i14 = 4 - i12;
                        while (this.zzr < i11) {
                            int i15 = this.zzs;
                            if (i15 == 0) {
                                zzacvVar.zzi(bArrZzM, i14, i12);
                                this.zzq += i12;
                                this.zze.zzK(0);
                                int iZzg = this.zze.zzg();
                                if (iZzg < 0) {
                                    throw zzcc.zza("Invalid NAL length", null);
                                }
                                this.zzs = iZzg;
                                this.zzd.zzK(0);
                                zzaeaVar.zzr(this.zzd, 4);
                                this.zzr += 4;
                                i11 += i14;
                            } else {
                                int iZzf2 = zzaeaVar.zzf(zzacvVar, i15, false);
                                this.zzq += iZzf2;
                                this.zzr += iZzf2;
                                this.zzs -= iZzf2;
                            }
                        }
                    }
                    zzajp zzajpVar3 = zzajgVar2.zzb;
                    long j17 = zzajpVar3.zzf[i10];
                    int i16 = zzajpVar3.zzg[i10];
                    if (zzaebVar != null) {
                        zzaebVar.zzc(zzaeaVar, j17, i16, i11, 0, null);
                        if (i10 + 1 == zzajgVar2.zzb.zzb) {
                            zzaebVar.zza(zzaeaVar, null);
                        }
                    } else {
                        zzaeaVar.zzt(j17, i16, i11, 0, null);
                    }
                    zzajgVar2.zze++;
                    this.zzp = -1;
                    this.zzq = 0;
                    this.zzr = 0;
                    this.zzs = 0;
                    return 0;
                }
                long j18 = this.zzm - ((long) this.zzn);
                long jZzf4 = zzacvVar.zzf() + j18;
                zzfp zzfpVar2 = this.zzo;
                if (zzfpVar2 != null) {
                    zzacvVar.zzi(zzfpVar2.zzM(), this.zzn, (int) j18);
                    if (this.zzl == 1718909296) {
                        this.zzt = true;
                        zzfpVar2.zzK(8);
                        int iZzf3 = zzf(zzfpVar2.zzg());
                        if (iZzf3 == 0) {
                            zzfpVar2.zzL(4);
                            do {
                                if (zzfpVar2.zzb() <= 0) {
                                    iZzf3 = 0;
                                    break;
                                }
                                iZzf3 = zzf(zzfpVar2.zzg());
                            } while (iZzf3 == 0);
                        }
                        this.zzz = iZzf3;
                    } else if (!this.zzh.isEmpty()) {
                        ((zzaim) this.zzh.peek()).zzd(new zzain(this.zzl, zzfpVar2));
                    }
                } else {
                    if (!this.zzt && this.zzl == 1835295092) {
                        this.zzz = 1;
                    }
                    if (j18 < 262144) {
                        zzacvVar.zzk((int) j18);
                    } else {
                        zzadrVar.zza = zzacvVar.zzf() + j18;
                        z2 = true;
                    }
                    zzl(jZzf4);
                    if (z2 && this.zzk != 2) {
                        return 1;
                    }
                }
                z2 = false;
                zzl(jZzf4);
                if (z2) {
                    continue;
                }
            }
        }
    }
}
