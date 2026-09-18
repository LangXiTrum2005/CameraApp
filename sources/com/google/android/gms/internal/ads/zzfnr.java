package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfnr extends zzgzu implements zzhbf {
    private static final zzfnr zzb;
    private zzhad zzd = zzaN();

    static {
        zzfnr zzfnrVar = new zzfnr();
        zzb = zzfnrVar;
        zzgzu.zzaU(zzfnr.class, zzfnrVar);
    }

    private zzfnr() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzfno.class});
        }
        if (i2 == 3) {
            return new zzfnr();
        }
        zzfnp zzfnpVar = null;
        if (i2 == 4) {
            return new zzfnq(zzfnpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
