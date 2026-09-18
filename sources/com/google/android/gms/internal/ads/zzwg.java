package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzwg implements zzaea {
    private boolean zzB;
    private zzrz zzC;
    private final zzwa zza;
    private final zzry zzd;
    private final zzrs zze;
    private zzwf zzf;
    private zzam zzg;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private boolean zzv;
    private zzam zzy;
    private zzam zzz;
    private final zzwc zzb = new zzwc();
    private int zzh = 1000;
    private long[] zzi = new long[1000];
    private long[] zzj = new long[1000];
    private long[] zzm = new long[1000];
    private int[] zzl = new int[1000];
    private int[] zzk = new int[1000];
    private zzadz[] zzn = new zzadz[1000];
    private final zzwn zzc = new zzwn(new zzep() { // from class: com.google.android.gms.internal.ads.zzwb
        @Override // com.google.android.gms.internal.ads.zzep
        public final void zza(Object obj) {
            throw null;
        }
    });
    private long zzs = Long.MIN_VALUE;
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private boolean zzx = true;
    private boolean zzw = true;
    private boolean zzA = true;

    protected zzwg(zzyx zzyxVar, zzry zzryVar, zzrs zzrsVar) {
        this.zzd = zzryVar;
        this.zze = zzrsVar;
        this.zza = new zzwa(zzyxVar);
    }

    private final int zzB(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.zzm[i];
            if (j2 > j) {
                break;
            }
            if (!z || (this.zzl[i] & 1) != 0) {
                i3 = i4;
                if (j2 == j) {
                    break;
                }
            }
            i++;
            if (i == this.zzh) {
                i = 0;
            }
        }
        return i3;
    }

    private final int zzC(int i) {
        int i2 = this.zzq + i;
        int i3 = this.zzh;
        return i2 < i3 ? i2 : i2 - i3;
    }

    private final synchronized int zzD(zzlb zzlbVar, zzih zzihVar, boolean z, boolean z2, zzwc zzwcVar) {
        zzihVar.zzd = false;
        if (!zzL()) {
            if (!z2 && !this.zzv) {
                zzam zzamVar = this.zzz;
                if (zzamVar == null || (!z && zzamVar == this.zzg)) {
                    return -3;
                }
                zzI(zzamVar, zzlbVar);
                return -5;
            }
            zzihVar.zzc(4);
            zzihVar.zze = Long.MIN_VALUE;
            return -4;
        }
        zzam zzamVar2 = ((zzwe) this.zzc.zza(this.zzp + this.zzr)).zza;
        if (!z && zzamVar2 == this.zzg) {
            int iZzC = zzC(this.zzr);
            if (!zzM(iZzC)) {
                zzihVar.zzd = true;
                return -3;
            }
            zzihVar.zzc(this.zzl[iZzC]);
            if (this.zzr == this.zzo - 1 && (z2 || this.zzv)) {
                zzihVar.zza(536870912);
            }
            long j = this.zzm[iZzC];
            zzihVar.zze = j;
            if (j < this.zzs) {
                zzihVar.zza(Integer.MIN_VALUE);
            }
            zzwcVar.zza = this.zzk[iZzC];
            zzwcVar.zzb = this.zzj[iZzC];
            zzwcVar.zzc = this.zzn[iZzC];
            return -4;
        }
        zzI(zzamVar2, zzlbVar);
        return -5;
    }

    private final synchronized long zzE(long j, boolean z, boolean z2) {
        int i;
        int i2 = this.zzo;
        if (i2 != 0) {
            long[] jArr = this.zzm;
            int i3 = this.zzq;
            if (j >= jArr[i3]) {
                if (z2 && (i = this.zzr) != i2) {
                    i2 = i + 1;
                }
                int iZzB = zzB(i3, i2, j, false);
                if (iZzB != -1) {
                    return zzG(iZzB);
                }
            }
        }
        return -1L;
    }

    private final synchronized long zzF() {
        int i = this.zzo;
        if (i == 0) {
            return -1L;
        }
        return zzG(i);
    }

    private final synchronized void zzH(long j, int i, long j2, int i2, zzadz zzadzVar) {
        int i3 = this.zzo;
        if (i3 > 0) {
            int iZzC = zzC(i3 - 1);
            zzek.zzd(this.zzj[iZzC] + ((long) this.zzk[iZzC]) <= j2);
        }
        this.zzv = (536870912 & i) != 0;
        this.zzu = Math.max(this.zzu, j);
        int iZzC2 = zzC(this.zzo);
        this.zzm[iZzC2] = j;
        this.zzj[iZzC2] = j2;
        this.zzk[iZzC2] = i2;
        this.zzl[iZzC2] = i;
        this.zzn[iZzC2] = zzadzVar;
        this.zzi[iZzC2] = 0;
        if (this.zzc.zzf() || !((zzwe) this.zzc.zzb()).zza.equals(this.zzz)) {
            zzam zzamVar = this.zzz;
            zzamVar.getClass();
            this.zzc.zzc(this.zzp + this.zzo, new zzwe(zzamVar, zzrx.zzb, null));
        }
        int i4 = this.zzo + 1;
        this.zzo = i4;
        int i5 = this.zzh;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            zzadz[] zzadzVarArr = new zzadz[i6];
            int i7 = this.zzq;
            int i8 = i5 - i7;
            System.arraycopy(this.zzj, i7, jArr2, 0, i8);
            System.arraycopy(this.zzm, this.zzq, jArr3, 0, i8);
            System.arraycopy(this.zzl, this.zzq, iArr, 0, i8);
            System.arraycopy(this.zzk, this.zzq, iArr2, 0, i8);
            System.arraycopy(this.zzn, this.zzq, zzadzVarArr, 0, i8);
            System.arraycopy(this.zzi, this.zzq, jArr, 0, i8);
            int i9 = this.zzq;
            System.arraycopy(this.zzj, 0, jArr2, i8, i9);
            System.arraycopy(this.zzm, 0, jArr3, i8, i9);
            System.arraycopy(this.zzl, 0, iArr, i8, i9);
            System.arraycopy(this.zzk, 0, iArr2, i8, i9);
            System.arraycopy(this.zzn, 0, zzadzVarArr, i8, i9);
            System.arraycopy(this.zzi, 0, jArr, i8, i9);
            this.zzj = jArr2;
            this.zzm = jArr3;
            this.zzl = iArr;
            this.zzk = iArr2;
            this.zzn = zzadzVarArr;
            this.zzi = jArr;
            this.zzq = 0;
            this.zzh = i6;
        }
    }

    private final void zzI(zzam zzamVar, zzlb zzlbVar) {
        zzam zzamVar2 = this.zzg;
        zzae zzaeVar = zzamVar2 == null ? null : zzamVar2.zzp;
        this.zzg = zzamVar;
        zzae zzaeVar2 = zzamVar.zzp;
        zzlbVar.zza = zzamVar.zzc(this.zzd.zza(zzamVar));
        zzlbVar.zzb = this.zzC;
        if (zzamVar2 == null || !zzfy.zzF(zzaeVar, zzaeVar2)) {
            zzrz zzrzVar = zzamVar.zzp != null ? new zzrz(new zzrq(new zzsb(1), 6001)) : null;
            this.zzC = zzrzVar;
            zzlbVar.zzb = zzrzVar;
        }
    }

    private final void zzJ() {
        if (this.zzC != null) {
            this.zzC = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzK() {
        this.zzr = 0;
        this.zza.zzg();
    }

    private final boolean zzL() {
        return this.zzr != this.zzo;
    }

    private final boolean zzM(int i) {
        if (this.zzC != null) {
            return (this.zzl[i] & 1073741824) != 0 ? false : false;
        }
        return true;
    }

    private final synchronized boolean zzN(zzam zzamVar) {
        this.zzx = false;
        if (zzfy.zzF(zzamVar, this.zzz)) {
            return false;
        }
        if (this.zzc.zzf() || !((zzwe) this.zzc.zzb()).zza.equals(zzamVar)) {
            this.zzz = zzamVar;
        } else {
            this.zzz = ((zzwe) this.zzc.zzb()).zza;
        }
        boolean z = this.zzA;
        zzam zzamVar2 = this.zzz;
        this.zzA = z & zzcb.zzf(zzamVar2.zzm, zzamVar2.zzj);
        this.zzB = false;
        return true;
    }

    static /* synthetic */ void zzm(zzwe zzweVar) {
        zzrx zzrxVar = zzweVar.zzb;
        int i = zzrw.zza;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:28:0x0055, B:25:0x0047), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x002e A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:28:0x0055, B:25:0x0047), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0036 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:28:0x0055, B:25:0x0047), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0044 A[EDGE_INSN: B:23:0x0044->B:26:0x0052 BREAK  A[LOOP:0: B:14:0x002c->B:20:0x003d]] */
    /* JADX WARN: Code duplicated, block: B:24:0x0045 A[EDGE_INSN: B:24:0x0045->B:26:0x0052 BREAK  A[LOOP:0: B:14:0x002c->B:20:0x003d]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0047 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:28:0x0055, B:25:0x0047), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055 A[Catch: all -> 0x0060, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:28:0x0055, B:25:0x0047), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x003d A[SYNTHETIC] */
    public final synchronized boolean zzA(long j, boolean z) {
        int iZzB;
        int i;
        zzK();
        int i2 = this.zzr;
        int iZzC = zzC(i2);
        if (zzL() && j >= this.zzm[iZzC]) {
            if (j <= this.zzu) {
                if (this.zzA) {
                    iZzB = this.zzo - i2;
                    i = 0;
                    while (true) {
                        if (i < iZzB) {
                            if (z) {
                                iZzB = -1;
                                break;
                            }
                            break;
                        }
                        if (this.zzm[iZzC] < j) {
                            iZzB = i;
                            break;
                        }
                        iZzC++;
                        if (iZzC == this.zzh) {
                            iZzC = 0;
                        }
                        i++;
                    }
                } else {
                    iZzB = zzB(iZzC, this.zzo - i2, j, true);
                }
                if (iZzB == -1) {
                    this.zzs = j;
                    this.zzr += iZzB;
                    return true;
                }
            } else if (z) {
                z = true;
                if (this.zzA) {
                    iZzB = this.zzo - i2;
                    i = 0;
                    while (true) {
                        if (i < iZzB) {
                            if (z) {
                                iZzB = -1;
                                break;
                            }
                            break;
                            break;
                        }
                        if (this.zzm[iZzC] < j) {
                            iZzB = i;
                            break;
                        }
                        iZzC++;
                        if (iZzC == this.zzh) {
                            iZzC = 0;
                        }
                        i++;
                    }
                } else {
                    iZzB = zzB(iZzC, this.zzo - i2, j, true);
                }
                if (iZzB == -1) {
                    this.zzs = j;
                    this.zzr += iZzB;
                    return true;
                }
            }
        }
        return false;
    }

    public final int zza() {
        return this.zzp;
    }

    public final int zzb() {
        return this.zzp + this.zzr;
    }

    public final synchronized int zzc(long j, boolean z) {
        int i = this.zzr;
        int iZzC = zzC(i);
        if (zzL() && j >= this.zzm[iZzC]) {
            if (j > this.zzu && z) {
                return this.zzo - i;
            }
            int iZzB = zzB(iZzC, this.zzo - i, j, true);
            if (iZzB == -1) {
                return 0;
            }
            return iZzB;
        }
        return 0;
    }

    public final int zzd() {
        return this.zzp + this.zzo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        if (r9 != 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zze(com.google.android.gms.internal.ads.zzlb r9, com.google.android.gms.internal.ads.zzih r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L7
            r5 = r1
            goto L9
        L7:
            r0 = 0
            r5 = r0
        L9:
            com.google.android.gms.internal.ads.zzwc r7 = r8.zzb
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            int r9 = r2.zzD(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L3e
            boolean r9 = r10.zzf()
            if (r9 != 0) goto L3d
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L34
            if (r9 == 0) goto L2c
            com.google.android.gms.internal.ads.zzwa r9 = r8.zza
            com.google.android.gms.internal.ads.zzwc r11 = r8.zzb
            r9.zzd(r10, r11)
            goto L3d
        L2c:
            com.google.android.gms.internal.ads.zzwa r9 = r8.zza
            com.google.android.gms.internal.ads.zzwc r11 = r8.zzb
            r9.zze(r10, r11)
            goto L37
        L34:
            if (r9 == 0) goto L37
            goto L3d
        L37:
            int r9 = r8.zzr
            int r9 = r9 + r1
            r8.zzr = r9
            return r12
        L3d:
            r9 = r12
        L3e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwg.zze(com.google.android.gms.internal.ads.zzlb, com.google.android.gms.internal.ads.zzih, int, boolean):int");
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final /* synthetic */ int zzf(zzu zzuVar, int i, boolean z) {
        return zzady.zza(this, zzuVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final int zzg(zzu zzuVar, int i, boolean z, int i2) throws IOException {
        return this.zza.zza(zzuVar, i, z);
    }

    public final synchronized long zzh() {
        return this.zzu;
    }

    public final synchronized zzam zzi() {
        if (this.zzx) {
            return null;
        }
        return this.zzz;
    }

    public final void zzj(long j, boolean z, boolean z2) {
        this.zza.zzc(zzE(j, false, z2));
    }

    public final void zzk() {
        this.zza.zzc(zzF());
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzl(zzam zzamVar) {
        this.zzy = zzamVar;
        boolean zZzN = zzN(zzamVar);
        zzwf zzwfVar = this.zzf;
        if (zzwfVar == null || !zZzN) {
            return;
        }
        zzwfVar.zzM(zzamVar);
    }

    public final void zzn() throws IOException {
        zzrz zzrzVar = this.zzC;
        if (zzrzVar != null) {
            throw zzrzVar.zza();
        }
    }

    public final void zzo() {
        zzk();
        zzJ();
    }

    public final void zzp() {
        zzq(true);
        zzJ();
    }

    public final void zzq(boolean z) {
        this.zza.zzf();
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzw = true;
        this.zzs = Long.MIN_VALUE;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = false;
        this.zzc.zzd();
        if (z) {
            this.zzy = null;
            this.zzz = null;
            this.zzx = true;
            this.zzA = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final /* synthetic */ void zzr(zzfp zzfpVar, int i) {
        zzady.zzb(this, zzfpVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzs(zzfp zzfpVar, int i, int i2) {
        this.zza.zzh(zzfpVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzt(long j, int i, int i2, int i3, zzadz zzadzVar) {
        if (this.zzw) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.zzw = false;
            }
        }
        if (this.zzA) {
            if (j < this.zzs) {
                return;
            }
            if ((i & 1) == 0) {
                if (!this.zzB) {
                    zzff.zzf("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(String.valueOf(this.zzz))));
                    this.zzB = true;
                }
                i |= 1;
            }
        }
        zzH(j, i, (this.zza.zzb() - ((long) i2)) - ((long) i3), i2, zzadzVar);
    }

    public final void zzu(long j) {
        this.zzs = j;
    }

    public final void zzv(zzwf zzwfVar) {
        this.zzf = zzwfVar;
    }

    public final synchronized void zzw(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.zzr + i <= this.zzo) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzek.zzd(z);
        this.zzr += i;
    }

    public final synchronized boolean zzx() {
        return this.zzv;
    }

    public final synchronized boolean zzy(boolean z) {
        boolean z2 = true;
        if (zzL()) {
            if (((zzwe) this.zzc.zza(this.zzp + this.zzr)).zza != this.zzg) {
                return true;
            }
            return zzM(zzC(this.zzr));
        }
        if (!z && !this.zzv) {
            zzam zzamVar = this.zzz;
            if (zzamVar == null) {
                z2 = false;
            } else if (zzamVar == this.zzg) {
                return false;
            }
        }
        return z2;
    }

    public final synchronized boolean zzz(int i) {
        zzK();
        int i2 = this.zzp;
        if (i >= i2 && i <= this.zzo + i2) {
            this.zzs = Long.MIN_VALUE;
            this.zzr = i - i2;
            return true;
        }
        return false;
    }

    private final long zzG(int i) {
        long j = this.zzt;
        long jMax = Long.MIN_VALUE;
        if (i != 0) {
            int iZzC = zzC(i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                jMax = Math.max(jMax, this.zzm[iZzC]);
                if ((this.zzl[iZzC] & 1) != 0) {
                    break;
                }
                iZzC--;
                if (iZzC == -1) {
                    iZzC = this.zzh - 1;
                }
            }
        }
        this.zzt = Math.max(j, jMax);
        this.zzo -= i;
        int i3 = this.zzp + i;
        this.zzp = i3;
        int i4 = this.zzq + i;
        this.zzq = i4;
        int i5 = this.zzh;
        if (i4 >= i5) {
            this.zzq = i4 - i5;
        }
        int i6 = this.zzr - i;
        this.zzr = i6;
        if (i6 < 0) {
            this.zzr = 0;
        }
        this.zzc.zze(i3);
        if (this.zzo != 0) {
            return this.zzj[this.zzq];
        }
        int i7 = this.zzq;
        if (i7 == 0) {
            i7 = this.zzh;
        }
        int i8 = i7 - 1;
        return this.zzj[i8] + ((long) this.zzk[i8]);
    }
}
