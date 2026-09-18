package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzapy implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzaqa zzc;

    zzapy(zzaqa zzaqaVar, String str, long j) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzaqaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        zzaqa zzaqaVar = this.zzc;
        zzaqaVar.zza.zzb(zzaqaVar.toString());
    }
}
