package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamv implements zzaoj {
    private final List zza;

    public zzamv() {
        this(0);
    }

    public zzamv(int i, List list) {
        this.zza = list;
    }

    private final zzanz zzb(zzaoi zzaoiVar) {
        return new zzanz(zzd(zzaoiVar));
    }

    private final zzaon zzc(zzaoi zzaoiVar) {
        return new zzaon(zzd(zzaoiVar));
    }

    private final List zzd(zzaoi zzaoiVar) {
        String str;
        int i;
        List listSingletonList;
        zzfp zzfpVar = new zzfp(zzaoiVar.zzd);
        List arrayList = this.zza;
        while (zzfpVar.zzb() > 0) {
            int iZzm = zzfpVar.zzm();
            int iZzd = zzfpVar.zzd() + zzfpVar.zzm();
            if (iZzm == 134) {
                arrayList = new ArrayList();
                int iZzm2 = zzfpVar.zzm() & 31;
                for (int i2 = 0; i2 < iZzm2; i2++) {
                    String strZzA = zzfpVar.zzA(3, zzfwq.zzc);
                    int iZzm3 = zzfpVar.zzm();
                    boolean z = (iZzm3 & 128) != 0;
                    if (z) {
                        i = iZzm3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bZzm = (byte) zzfpVar.zzm();
                    zzfpVar.zzL(1);
                    if (z) {
                        int i3 = bZzm & SignedBytes.MAX_POWER_OF_TWO;
                        int i4 = zzem.zza;
                        listSingletonList = Collections.singletonList(i3 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzak zzakVar = new zzak();
                    zzakVar.zzW(str);
                    zzakVar.zzN(strZzA);
                    zzakVar.zzw(i);
                    zzakVar.zzL(listSingletonList);
                    arrayList.add(zzakVar.zzac());
                }
            }
            zzfpVar.zzK(iZzd);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzaoj
    public final zzaol zza(int i, zzaoi zzaoiVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzanp(new zzanm(zzaoiVar.zzb));
            }
            if (i == 21) {
                return new zzanp(new zzank());
            }
            if (i == 27) {
                return new zzanp(new zzanh(zzb(zzaoiVar), false, false));
            }
            if (i == 36) {
                return new zzanp(new zzanj(zzb(zzaoiVar)));
            }
            if (i == 89) {
                return new zzanp(new zzamx(zzaoiVar.zzc));
            }
            if (i == 138) {
                return new zzanp(new zzamw(zzaoiVar.zzb));
            }
            if (i == 172) {
                return new zzanp(new zzamr(zzaoiVar.zzb));
            }
            if (i == 257) {
                return new zzany(new zzano("application/vnd.dvb.ait"));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i == 134) {
                        return new zzany(new zzano("application/x-scte35"));
                    }
                    if (i != 135) {
                        switch (i) {
                            case 15:
                                return new zzanp(new zzamu(false, zzaoiVar.zzb));
                            case 16:
                                return new zzanp(new zzand(zzc(zzaoiVar)));
                            case 17:
                                return new zzanp(new zzanl(zzaoiVar.zzb));
                            default:
                                return null;
                        }
                    }
                }
                return new zzanp(new zzamo(zzaoiVar.zzb));
            }
        }
        return new zzanp(new zzana(zzc(zzaoiVar)));
    }

    public zzamv(int i) {
        this.zza = zzgaa.zzl();
    }
}
