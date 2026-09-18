package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpx extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzam zzc;

    public zzpx(int i, int i2, int i3, int i4, zzam zzamVar, boolean z, Exception exc) {
        String strValueOf = String.valueOf(zzamVar);
        StringBuilder sb = new StringBuilder("AudioTrack init failed ");
        sb.append(i);
        sb.append(" Config(");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(") ");
        sb.append(strValueOf);
        sb.append(true != z ? "" : " (recoverable)");
        super(sb.toString(), exc);
        this.zza = i;
        this.zzb = z;
        this.zzc = zzamVar;
    }
}
