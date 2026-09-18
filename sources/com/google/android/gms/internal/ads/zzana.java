package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzana implements zzamy {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzaea zzc;
    private final zzaon zzd;
    private final zzfp zze;
    private final zzann zzf;
    private final boolean[] zzg;
    private final zzamz zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;

    public zzana() {
        this(null);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:39:0x0122  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long j;
        double d;
        int i5;
        int i6;
        zzek.zzb(this.zzc);
        int iZzd = zzfpVar.zzd();
        int iZze = zzfpVar.zze();
        byte[] bArrZzM = zzfpVar.zzM();
        this.zzi += (long) zzfpVar.zzb();
        this.zzc.zzr(zzfpVar, zzfpVar.zzb());
        while (true) {
            int iZza = zzgm.zza(bArrZzM, iZzd, iZze, this.zzg);
            if (iZza == iZze) {
                break;
            }
            int i7 = iZza + 3;
            int i8 = zzfpVar.zzM()[i7] & 255;
            int i9 = iZza - iZzd;
            if (!this.zzk) {
                if (i9 > 0) {
                    this.zzh.zza(bArrZzM, iZzd, iZza);
                }
                if (this.zzh.zzc(i8, i9 < 0 ? -i9 : 0)) {
                    zzamz zzamzVar = this.zzh;
                    String str = this.zzb;
                    str.getClass();
                    byte[] bArrCopyOf = Arrays.copyOf(zzamzVar.zzc, zzamzVar.zza);
                    int i10 = bArrCopyOf[4] & 255;
                    byte b = bArrCopyOf[5];
                    int i11 = bArrCopyOf[6] & 255;
                    int i12 = ((b & 255) >> 4) | (i10 << 4);
                    int i13 = (bArrCopyOf[7] & 240) >> 4;
                    int i14 = ((b & Ascii.SI) << 8) | i11;
                    if (i13 == 2) {
                        i2 = i14 * 4;
                        i3 = i12 * 3;
                    } else if (i13 != 3) {
                        if (i13 != 4) {
                            f = 1.0f;
                        } else {
                            i2 = i14 * 121;
                            i3 = i12 * 100;
                        }
                        zzak zzakVar = new zzak();
                        zzakVar.zzK(str);
                        zzakVar.zzW("video/mpeg2");
                        zzakVar.zzab(i12);
                        zzakVar.zzI(i14);
                        zzakVar.zzS(f);
                        zzakVar.zzL(Collections.singletonList(bArrCopyOf));
                        zzam zzamVarZzac = zzakVar.zzac();
                        i4 = (bArrCopyOf[7] & Ascii.SI) - 1;
                        j = 0;
                        if (i4 >= 0 && i4 < 8) {
                            d = zza[i4];
                            byte b2 = bArrCopyOf[zzamzVar.zzb + 9];
                            i5 = (b2 & 96) >> 5;
                            i6 = b2 & Ascii.US;
                            if (i5 != i6) {
                                d *= (((double) i5) + 1.0d) / ((double) (i6 + 1));
                            }
                            j = (long) (1000000.0d / d);
                        }
                        Pair pairCreate = Pair.create(zzamVarZzac, Long.valueOf(j));
                        this.zzc.zzl((zzam) pairCreate.first);
                        this.zzl = ((Long) pairCreate.second).longValue();
                        this.zzk = true;
                    } else {
                        i2 = i14 * 16;
                        i3 = i12 * 9;
                    }
                    f = i2 / i3;
                    zzak zzakVar2 = new zzak();
                    zzakVar2.zzK(str);
                    zzakVar2.zzW("video/mpeg2");
                    zzakVar2.zzab(i12);
                    zzakVar2.zzI(i14);
                    zzakVar2.zzS(f);
                    zzakVar2.zzL(Collections.singletonList(bArrCopyOf));
                    zzam zzamVarZzac2 = zzakVar2.zzac();
                    i4 = (bArrCopyOf[7] & Ascii.SI) - 1;
                    j = 0;
                    if (i4 >= 0) {
                        d = zza[i4];
                        byte b3 = bArrCopyOf[zzamzVar.zzb + 9];
                        i5 = (b3 & 96) >> 5;
                        i6 = b3 & Ascii.US;
                        if (i5 != i6) {
                            d *= (((double) i5) + 1.0d) / ((double) (i6 + 1));
                        }
                        j = (long) (1000000.0d / d);
                    }
                    Pair pairCreate2 = Pair.create(zzamVarZzac2, Long.valueOf(j));
                    this.zzc.zzl((zzam) pairCreate2.first);
                    this.zzl = ((Long) pairCreate2.second).longValue();
                    this.zzk = true;
                }
            }
            zzann zzannVar = this.zzf;
            if (zzannVar != null) {
                if (i9 > 0) {
                    zzannVar.zza(bArrZzM, iZzd, iZza);
                    i = 0;
                } else {
                    i = -i9;
                }
                if (this.zzf.zzd(i)) {
                    zzann zzannVar2 = this.zzf;
                    int iZzb = zzgm.zzb(zzannVar2.zza, zzannVar2.zzb);
                    zzfp zzfpVar2 = this.zze;
                    int i15 = zzfy.zza;
                    zzfpVar2.zzI(this.zzf.zza, iZzb);
                    this.zzd.zza(this.zzo, this.zze);
                }
                if (i8 == 178) {
                    if (zzfpVar.zzM()[iZza + 2] == 1) {
                        this.zzf.zzc(178);
                    }
                    i8 = 178;
                }
            }
            if (i8 == 0 || i8 == 179) {
                int i16 = iZze - iZza;
                if (this.zzq && this.zzk) {
                    long j2 = this.zzo;
                    if (j2 != -9223372036854775807L) {
                        this.zzc.zzt(j2, this.zzp ? 1 : 0, ((int) (this.zzi - this.zzn)) - i16, i16, null);
                    }
                }
                if (!this.zzj || this.zzq) {
                    this.zzn = this.zzi - ((long) i16);
                    long j3 = this.zzm;
                    if (j3 == -9223372036854775807L) {
                        long j4 = this.zzo;
                        j3 = j4 != -9223372036854775807L ? j4 + this.zzl : -9223372036854775807L;
                    }
                    this.zzo = j3;
                    z = false;
                    this.zzp = false;
                    this.zzm = -9223372036854775807L;
                    z2 = true;
                    this.zzj = true;
                } else {
                    z = false;
                    z2 = true;
                }
                this.zzq = i8 == 0 ? z2 : z;
            } else if (i8 == 184) {
                this.zzp = true;
            }
            iZzd = i7;
        }
        if (!this.zzk) {
            this.zzh.zza(bArrZzM, iZzd, iZze);
        }
        zzann zzannVar3 = this.zzf;
        if (zzannVar3 != null) {
            zzannVar3.zza(bArrZzM, iZzd, iZze);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzb = zzaokVar.zzb();
        this.zzc = zzacxVar.zzw(zzaokVar.zza(), 2);
        zzaon zzaonVar = this.zzd;
        if (zzaonVar != null) {
            zzaonVar.zzb(zzacxVar, zzaokVar);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
        zzek.zzb(this.zzc);
        if (z) {
            boolean z2 = this.zzp;
            long j = this.zzi - this.zzn;
            this.zzc.zzt(this.zzo, z2 ? 1 : 0, (int) j, 0, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        zzgm.zzf(this.zzg);
        this.zzh.zzb();
        zzann zzannVar = this.zzf;
        if (zzannVar != null) {
            zzannVar.zzb();
        }
        this.zzi = 0L;
        this.zzj = false;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }

    zzana(zzaon zzaonVar) {
        zzfp zzfpVar;
        this.zzd = zzaonVar;
        this.zzg = new boolean[4];
        this.zzh = new zzamz(128);
        if (zzaonVar != null) {
            this.zzf = new zzann(178, 128);
            zzfpVar = new zzfp();
        } else {
            zzfpVar = null;
            this.zzf = null;
        }
        this.zze = zzfpVar;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }
}
