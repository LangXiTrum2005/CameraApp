package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgnp extends zzggq {
    private final zzgoy zza;

    public zzgnp(zzgoy zzgoyVar) {
        this.zza = zzgoyVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnp)) {
            return false;
        }
        zzgoy zzgoyVar = ((zzgnp) obj).zza;
        return this.zza.zzc().zzf().equals(zzgoyVar.zzc().zzf()) && this.zza.zzc().zzh().equals(zzgoyVar.zzc().zzh()) && this.zza.zzc().zzg().equals(zzgoyVar.zzc().zzg());
    }

    public final int hashCode() {
        zzgoy zzgoyVar = this.zza;
        return Objects.hash(zzgoyVar.zzc(), zzgoyVar.zzd());
    }

    public final String toString() {
        String str;
        String strZzh = this.zza.zzc().zzh();
        zzgvz zzgvzVarZzf = this.zza.zzc().zzf();
        zzgvz zzgvzVar = zzgvz.UNKNOWN_PREFIX;
        int iOrdinal = zzgvzVarZzf.ordinal();
        if (iOrdinal == 1) {
            str = "TINK";
        } else if (iOrdinal == 2) {
            str = "LEGACY";
        } else if (iOrdinal != 3) {
            str = iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY";
        } else {
            str = "RAW";
        }
        return String.format("(typeUrl=%s, outputPrefixType=%s)", strZzh, str);
    }

    @Override // com.google.android.gms.internal.ads.zzggq
    public final boolean zza() {
        throw null;
    }

    public final zzgoy zzb() {
        return this.zza;
    }
}
