package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgut extends zzgzu implements zzhbf {
    private static final zzgut zzb;
    private String zzd = "";
    private zzgyl zze = zzgyl.zzb;
    private int zzf;

    static {
        zzgut zzgutVar = new zzgut();
        zzb = zzgutVar;
        zzgzu.zzaU(zzgut.class, zzgutVar);
    }

    private zzgut() {
    }

    public static zzguq zza() {
        return (zzguq) zzb.zzaA();
    }

    public static zzgut zze() {
        return zzb;
    }

    static /* synthetic */ void zzh(zzgut zzgutVar, String str) {
        str.getClass();
        zzgutVar.zzd = str;
    }

    static /* synthetic */ void zzi(zzgut zzgutVar, zzgyl zzgylVar) {
        zzgylVar.getClass();
        zzgutVar.zze = zzgylVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgut();
        }
        zzgup zzgupVar = null;
        if (i2 == 4) {
            return new zzguq(zzgupVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgus zzc() {
        zzgus zzgusVar;
        int i = this.zzf;
        zzgus zzgusVar2 = zzgus.UNKNOWN_KEYMATERIAL;
        if (i == 0) {
            zzgusVar = zzgus.UNKNOWN_KEYMATERIAL;
        } else if (i == 1) {
            zzgusVar = zzgus.SYMMETRIC;
        } else if (i == 2) {
            zzgusVar = zzgus.ASYMMETRIC_PRIVATE;
        } else if (i != 3) {
            zzgusVar = i != 4 ? null : zzgus.REMOTE;
        } else {
            zzgusVar = zzgus.ASYMMETRIC_PUBLIC;
        }
        return zzgusVar == null ? zzgus.UNRECOGNIZED : zzgusVar;
    }

    public final zzgyl zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzd;
    }
}
