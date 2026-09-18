package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzyf extends zzyc {
    private final boolean zze;
    private final zzxu zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final boolean zzo;
    private final boolean zzp;
    private final int zzq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:121:0x0162  */
    /* JADX WARN: Code duplicated, block: B:22:0x003b  */
    /* JADX WARN: Code duplicated, block: B:29:0x004a  */
    /* JADX WARN: Code duplicated, block: B:31:0x004e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0052  */
    /* JADX WARN: Code duplicated, block: B:35:0x0058  */
    /* JADX WARN: Code duplicated, block: B:37:0x005f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0063  */
    /* JADX WARN: Code duplicated, block: B:42:0x0069  */
    /* JADX WARN: Code duplicated, block: B:70:0x00da  */
    public zzyf(int i, zzcz zzczVar, int i2, zzxu zzxuVar, int i3, int i4, boolean z) {
        boolean z2;
        boolean z3;
        int i5;
        byte b;
        boolean z4;
        int i6;
        float f;
        int i7;
        super(i, zzczVar, 0);
        int i8 = 0;
        this.zzf = zzxuVar;
        int i9 = true != zzxuVar.zzK ? 16 : 24;
        boolean z5 = zzxuVar.zzJ;
        if (z) {
            zzam zzamVar = this.zzd;
            if (zzamVar.zzr != -1) {
                int i10 = zzxuVar.zzd;
            }
            if (zzamVar.zzs != -1) {
                int i11 = zzxuVar.zze;
            }
            float f2 = zzamVar.zzt;
            if (f2 != -1.0f) {
                int i12 = zzxuVar.zzf;
                if (f2 > 2.1474836E9f) {
                    z2 = false;
                }
            }
            if (zzamVar.zzi != -1) {
                int i13 = zzxuVar.zzg;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        this.zze = z2;
        if (z) {
            zzam zzamVar2 = this.zzd;
            int i14 = zzamVar2.zzr;
            if (i14 != -1) {
                int i15 = zzxuVar.zzh;
                if (i14 >= 0) {
                    i6 = zzamVar2.zzs;
                    if (i6 != -1) {
                        int i16 = zzxuVar.zzi;
                        if (i6 >= 0) {
                            f = zzamVar2.zzt;
                            if (f != -1.0f) {
                                int i17 = zzxuVar.zzj;
                                if (f >= 0.0f) {
                                    i7 = zzamVar2.zzi;
                                    if (i7 != -1) {
                                        int i18 = zzxuVar.zzk;
                                        if (i7 >= 0) {
                                            z3 = false;
                                        }
                                    }
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            } else {
                                i7 = zzamVar2.zzi;
                                if (i7 != -1) {
                                    int i19 = zzxuVar.zzk;
                                    if (i7 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            }
                        } else {
                            z3 = false;
                        }
                    } else {
                        f = zzamVar2.zzt;
                        if (f != -1.0f) {
                            int i110 = zzxuVar.zzj;
                            if (f >= 0.0f) {
                                i7 = zzamVar2.zzi;
                                if (i7 != -1) {
                                    int i111 = zzxuVar.zzk;
                                    if (i7 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            i7 = zzamVar2.zzi;
                            if (i7 != -1) {
                                int i112 = zzxuVar.zzk;
                                if (i7 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        }
                    }
                } else {
                    z3 = false;
                }
            } else {
                i6 = zzamVar2.zzs;
                if (i6 != -1) {
                    int i113 = zzxuVar.zzi;
                    if (i6 >= 0) {
                        f = zzamVar2.zzt;
                        if (f != -1.0f) {
                            int i114 = zzxuVar.zzj;
                            if (f >= 0.0f) {
                                i7 = zzamVar2.zzi;
                                if (i7 != -1) {
                                    int i115 = zzxuVar.zzk;
                                    if (i7 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            i7 = zzamVar2.zzi;
                            if (i7 != -1) {
                                int i116 = zzxuVar.zzk;
                                if (i7 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                    }
                } else {
                    f = zzamVar2.zzt;
                    if (f != -1.0f) {
                        int i117 = zzxuVar.zzj;
                        if (f >= 0.0f) {
                            i7 = zzamVar2.zzi;
                            if (i7 != -1) {
                                int i118 = zzxuVar.zzk;
                                if (i7 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } else {
                        i7 = zzamVar2.zzi;
                        if (i7 != -1) {
                            int i119 = zzxuVar.zzk;
                            if (i7 >= 0) {
                                z3 = false;
                            }
                        }
                        z3 = true;
                    }
                }
            }
        } else {
            z3 = false;
        }
        this.zzg = z3;
        this.zzh = zzyg.zzo(i3, false);
        zzam zzamVar3 = this.zzd;
        this.zzi = zzamVar3.zzi;
        this.zzj = zzamVar3.zza();
        int i20 = this.zzd.zzf;
        int i21 = zzxuVar.zzp;
        this.zzl = zzyg.zza(i20, 0);
        int i22 = this.zzd.zzf;
        this.zzm = i22 == 0 || (i22 & 1) != 0;
        int i23 = 0;
        while (true) {
            if (i23 >= zzxuVar.zzo.size()) {
                i23 = Integer.MAX_VALUE;
                break;
            }
            String str = this.zzd.zzm;
            if (str != null && str.equals(zzxuVar.zzo.get(i23))) {
                break;
            } else {
                i23++;
            }
        }
        this.zzk = i23;
        this.zzo = (i3 & 384) == 128;
        this.zzp = (i3 & 64) == 64;
        zzam zzamVar4 = this.zzd;
        String str2 = zzamVar4.zzm;
        if (str2 == null) {
            i5 = 0;
        } else {
            i5 = 4;
            switch (str2) {
                case "video/dolby-vision":
                    b = 0;
                    break;
                case "video/av01":
                    b = 1;
                    break;
                case "video/hevc":
                    b = 2;
                    break;
                case "video/avc":
                    b = 4;
                    break;
                case "video/x-vnd.on2.vp9":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                i5 = 5;
            } else if (b != 1) {
                if (b == 2) {
                    i5 = 3;
                } else if (b == 3) {
                    i5 = 2;
                } else if (b != 4) {
                    i5 = 0;
                } else {
                    i5 = 1;
                }
            }
        }
        this.zzq = i5;
        if ((zzamVar4.zzf & 16384) == 0) {
            zzxu zzxuVar2 = this.zzf;
            if (zzyg.zzo(i3, zzxuVar2.zzT) && ((z4 = this.zze) || zzxuVar2.zzI)) {
                if (zzyg.zzo(i3, false) && this.zzg && z4 && zzamVar4.zzi != -1) {
                    boolean z6 = zzxuVar2.zzC;
                    boolean z7 = zzxuVar2.zzB;
                    if ((i9 & i3) != 0) {
                        i8 = 2;
                    } else {
                        i8 = 1;
                    }
                } else {
                    i8 = 1;
                }
            }
        }
        this.zzn = i8;
    }

    public static /* synthetic */ int zza(zzyf zzyfVar, zzyf zzyfVar2) {
        zzgbj zzgbjVarZza = (zzyfVar.zze && zzyfVar.zzh) ? zzyg.zzc : zzyg.zzc.zza();
        zzfzp zzfzpVarZzk = zzfzp.zzk();
        Integer numValueOf = Integer.valueOf(zzyfVar.zzi);
        Integer numValueOf2 = Integer.valueOf(zzyfVar2.zzi);
        boolean z = zzyfVar.zzf.zzB;
        return zzfzpVarZzk.zzd(numValueOf, numValueOf2, zzyg.zzd).zzd(Integer.valueOf(zzyfVar.zzj), Integer.valueOf(zzyfVar2.zzj), zzgbjVarZza).zzd(Integer.valueOf(zzyfVar.zzi), Integer.valueOf(zzyfVar2.zzi), zzgbjVarZza).zza();
    }

    public static /* synthetic */ int zzd(zzyf zzyfVar, zzyf zzyfVar2) {
        zzfzp zzfzpVarZzd = zzfzp.zzk().zze(zzyfVar.zzh, zzyfVar2.zzh).zzb(zzyfVar.zzl, zzyfVar2.zzl).zze(zzyfVar.zzm, zzyfVar2.zzm).zze(zzyfVar.zze, zzyfVar2.zze).zze(zzyfVar.zzg, zzyfVar2.zzg).zzd(Integer.valueOf(zzyfVar.zzk), Integer.valueOf(zzyfVar2.zzk), zzgbj.zzc().zza());
        boolean z = zzyfVar.zzo;
        zzfzp zzfzpVarZze = zzfzpVarZzd.zze(z, zzyfVar2.zzo);
        boolean z2 = zzyfVar.zzp;
        zzfzp zzfzpVarZze2 = zzfzpVarZze.zze(z2, zzyfVar2.zzp);
        if (z && z2) {
            zzfzpVarZze2 = zzfzpVarZze2.zzb(zzyfVar.zzq, zzyfVar2.zzq);
        }
        return zzfzpVarZze2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final int zzb() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final /* bridge */ /* synthetic */ boolean zzc(zzyc zzycVar) {
        zzyf zzyfVar = (zzyf) zzycVar;
        if (!zzfy.zzF(this.zzd.zzm, zzyfVar.zzd.zzm)) {
            return false;
        }
        boolean z = this.zzf.zzL;
        return this.zzo == zzyfVar.zzo && this.zzp == zzyfVar.zzp;
    }
}
