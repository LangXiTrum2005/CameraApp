package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzguo extends zzgzu implements zzhbf {
    private static final zzguo zzb;
    private int zzd;
    private int zze;

    static {
        zzguo zzguoVar = new zzguo();
        zzb = zzguoVar;
        zzgzu.zzaU(zzguo.class, zzguoVar);
    }

    private zzguo() {
    }

    public static zzgun zzd() {
        return (zzgun) zzb.zzaA();
    }

    public static zzguo zzf() {
        return zzb;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzguo();
        }
        zzgum zzgumVar = null;
        if (i2 == 4) {
            return new zzgun(zzgumVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzguf zzc() {
        zzguf zzgufVar;
        int i = this.zzd;
        zzguf zzgufVar2 = zzguf.UNKNOWN_HASH;
        if (i == 0) {
            zzgufVar = zzguf.UNKNOWN_HASH;
        } else if (i == 1) {
            zzgufVar = zzguf.SHA1;
        } else if (i == 2) {
            zzgufVar = zzguf.SHA384;
        } else if (i == 3) {
            zzgufVar = zzguf.SHA256;
        } else if (i != 4) {
            zzgufVar = i != 5 ? null : zzguf.SHA224;
        } else {
            zzgufVar = zzguf.SHA512;
        }
        return zzgufVar == null ? zzguf.UNRECOGNIZED : zzgufVar;
    }
}
