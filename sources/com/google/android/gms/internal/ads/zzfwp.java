package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfwp implements zzfxf {
    protected zzfwp() {
    }

    public static zzfwp zzc(char c) {
        return new zzfwm(c);
    }

    @Override // com.google.android.gms.internal.ads.zzfxf
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c);
}
