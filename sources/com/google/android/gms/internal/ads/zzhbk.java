package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhbk {
    private static final zzhbj zza;
    private static final zzhbj zzb;

    static {
        zzhbj zzhbjVar = null;
        try {
            zzhbjVar = (zzhbj) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzhbjVar;
        zzb = new zzhbj();
    }

    static zzhbj zza() {
        return zza;
    }

    static zzhbj zzb() {
        return zzb;
    }
}
