package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhba {
    private static final zzhaz zza;
    private static final zzhaz zzb;

    static {
        zzhaz zzhazVar = null;
        try {
            zzhazVar = (zzhaz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzhazVar;
        zzb = new zzhaz();
    }

    static zzhaz zza() {
        return zza;
    }

    static zzhaz zzb() {
        return zzb;
    }
}
