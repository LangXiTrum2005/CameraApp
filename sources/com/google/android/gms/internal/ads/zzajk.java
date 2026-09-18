package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajk {
    private static final zzfxr zza = zzfxr.zzc(zzfwp.zzc(':'));
    private static final zzfxr zzb = zzfxr.zzc(zzfwp.zzc('*'));
    private final List zzc = new ArrayList();
    private int zzd = 0;
    private int zze;

    public final void zzb() {
        this.zzc.clear();
        this.zzd = 0;
    }

    public final int zza(zzacv zzacvVar, zzadr zzadrVar, List list) throws IOException {
        byte b;
        char c;
        int i = this.zzd;
        if (i == 0) {
            long jZzd = zzacvVar.zzd();
            zzadrVar.zza = (jZzd == -1 || jZzd < 8) ? 0L : jZzd - 8;
            this.zzd = 1;
            return 1;
        }
        int i2 = 2;
        if (i != 1) {
            char c2 = 2819;
            short s = 2817;
            short s2 = 2816;
            short s3 = 2192;
            if (i != 2) {
                long jZzf = zzacvVar.zzf();
                int iZzd = (int) ((zzacvVar.zzd() - zzacvVar.zzf()) - ((long) this.zze));
                zzfp zzfpVar = new zzfp(iZzd);
                zzacvVar.zzi(zzfpVar.zzM(), 0, iZzd);
                int i3 = 0;
                while (i3 < this.zzc.size()) {
                    zzajj zzajjVar = (zzajj) this.zzc.get(i3);
                    zzfpVar.zzK((int) (zzajjVar.zza - jZzf));
                    zzfpVar.zzL(4);
                    int iZzi = zzfpVar.zzi();
                    switch (zzfpVar.zzA(iZzi, zzfwq.zzc)) {
                        case "SlowMotion_Data":
                            b = 0;
                            break;
                        case "Super_SlowMotion_Edit_Data":
                            b = 3;
                            break;
                        case "Super_SlowMotion_Data":
                            b = 1;
                            break;
                        case "Super_SlowMotion_Deflickering_On":
                            b = 4;
                            break;
                        case "Super_SlowMotion_BGM":
                            b = 2;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 0) {
                        c = 2192;
                    } else if (b == 1) {
                        c = 2816;
                    } else if (b == 2) {
                        c = 2817;
                    } else if (b == 3) {
                        c = c2;
                    } else {
                        if (b != 4) {
                            throw zzcc.zza("Invalid SEF name", null);
                        }
                        c = 2820;
                    }
                    int i4 = zzajjVar.zzb - (iZzi + 8);
                    if (c == 2192) {
                        ArrayList arrayList = new ArrayList();
                        List listZzf = zzb.zzf(zzfpVar.zzA(i4, zzfwq.zzc));
                        for (int i5 = 0; i5 < listZzf.size(); i5++) {
                            List listZzf2 = zza.zzf((CharSequence) listZzf.get(i5));
                            if (listZzf2.size() != 3) {
                                throw zzcc.zza(null, null);
                            }
                            try {
                                arrayList.add(new zzahi(Long.parseLong((String) listZzf2.get(0)), Long.parseLong((String) listZzf2.get(1)), 1 << (Integer.parseInt((String) listZzf2.get(2)) - 1)));
                            } catch (NumberFormatException e) {
                                throw zzcc.zza(null, e);
                            }
                        }
                        list.add(new zzahj(arrayList));
                    } else if (c != 2816 && c != 2817 && c != c2 && c != 2820) {
                        throw new IllegalStateException();
                    }
                    i3++;
                    c2 = 2819;
                }
                zzadrVar.zza = 0L;
                return 1;
            }
            long jZzd2 = zzacvVar.zzd();
            int i6 = this.zze - 20;
            zzfp zzfpVar2 = new zzfp(i6);
            zzacvVar.zzi(zzfpVar2.zzM(), 0, i6);
            int i7 = 0;
            while (i7 < i6 / 12) {
                zzfpVar2.zzL(i2);
                short sZzC = zzfpVar2.zzC();
                if (sZzC == s3 || sZzC == s2 || sZzC == s || sZzC == 2819 || sZzC == 2820) {
                    this.zzc.add(new zzajj(sZzC, (jZzd2 - ((long) this.zze)) - ((long) zzfpVar2.zzi()), zzfpVar2.zzi()));
                } else {
                    zzfpVar2.zzL(8);
                }
                i7++;
                i6 = i6;
                i2 = 2;
                s = 2817;
                s2 = 2816;
                s3 = 2192;
            }
            if (this.zzc.isEmpty()) {
                zzadrVar.zza = 0L;
            } else {
                this.zzd = 3;
                zzadrVar.zza = ((zzajj) this.zzc.get(0)).zza;
            }
        } else {
            zzfp zzfpVar3 = new zzfp(8);
            zzacvVar.zzi(zzfpVar3.zzM(), 0, 8);
            this.zze = zzfpVar3.zzi() + 8;
            if (zzfpVar3.zzg() != 1397048916) {
                zzadrVar.zza = 0L;
            } else {
                zzadrVar.zza = zzacvVar.zzf() - ((long) (this.zze - 12));
                this.zzd = 2;
            }
        }
        return 1;
    }
}
