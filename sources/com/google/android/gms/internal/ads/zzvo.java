package com.google.android.gms.internal.ads;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzvo implements zzzg, zzug {
    final /* synthetic */ zzvt zza;
    private final Uri zzc;
    private final zzhx zzd;
    private final zzvi zze;
    private final zzacx zzf;
    private final zzeo zzg;
    private volatile boolean zzi;
    private long zzk;
    private zzaea zzm;
    private boolean zzn;
    private final zzadr zzh = new zzadr();
    private boolean zzj = true;
    private final long zzb = zzui.zza();
    private zzhb zzl = zzi(0);

    public zzvo(zzvt zzvtVar, Uri uri, zzgw zzgwVar, zzvi zzviVar, zzacx zzacxVar, zzeo zzeoVar) {
        this.zza = zzvtVar;
        this.zzc = uri;
        this.zzd = new zzhx(zzgwVar);
        this.zze = zzviVar;
        this.zzf = zzacxVar;
        this.zzg = zzeoVar;
    }

    static /* bridge */ /* synthetic */ void zzf(zzvo zzvoVar, long j, long j2) {
        zzvoVar.zzh.zza = j;
        zzvoVar.zzk = j2;
        zzvoVar.zzj = true;
        zzvoVar.zzn = false;
    }

    private final zzhb zzi(long j) {
        zzgz zzgzVar = new zzgz();
        zzgzVar.zzd(this.zzc);
        zzgzVar.zzc(j);
        zzgzVar.zza(6);
        zzgzVar.zzb(zzvt.zzb);
        return zzgzVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzzg
    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x01e0 */
    @Override // com.google.android.gms.internal.ads.zzzg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvo.zzh():void");
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zza(zzfp zzfpVar) {
        long jMax = !this.zzn ? this.zzk : Math.max(zzvt.zzr(this.zza, true), this.zzk);
        int iZzb = zzfpVar.zzb();
        zzaea zzaeaVar = this.zzm;
        zzaeaVar.getClass();
        zzady.zzb(zzaeaVar, zzfpVar, iZzb);
        zzaeaVar.zzt(jMax, 1, iZzb, 0, null);
        this.zzn = true;
    }
}
