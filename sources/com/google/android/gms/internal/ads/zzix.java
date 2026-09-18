package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzix implements zzlh {
    private final zzmm zza;
    private final zziw zzb;
    private zzmf zzc;
    private zzlh zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzix(zziw zziwVar, zzel zzelVar) {
        this.zzb = zziwVar;
        this.zza = new zzmm(zzelVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final long zza() {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    public final long zzb(boolean z) {
        zzcg zzcgVarZzc;
        zzmf zzmfVar = this.zzc;
        if (zzmfVar == null || zzmfVar.zzV() || (!this.zzc.zzW() && (z || this.zzc.zzP()))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        } else {
            zzlh zzlhVar = this.zzd;
            zzlhVar.getClass();
            long jZza = zzlhVar.zza();
            if (!this.zze) {
                this.zza.zzb(jZza);
                zzcgVarZzc = zzlhVar.zzc();
                if (!zzcgVarZzc.equals(this.zza.zzc())) {
                    this.zza.zzg(zzcgVarZzc);
                    this.zzb.zza(zzcgVarZzc);
                }
            } else if (jZza < this.zza.zza()) {
                this.zza.zze();
            } else {
                this.zze = false;
                if (this.zzf) {
                    this.zza.zzd();
                }
                this.zza.zzb(jZza);
                zzcgVarZzc = zzlhVar.zzc();
                if (!zzcgVarZzc.equals(this.zza.zzc())) {
                    this.zza.zzg(zzcgVarZzc);
                    this.zzb.zza(zzcgVarZzc);
                }
            }
        }
        if (this.zze) {
            return this.zza.zza();
        }
        zzlh zzlhVar2 = this.zzd;
        zzlhVar2.getClass();
        return zzlhVar2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final zzcg zzc() {
        zzlh zzlhVar = this.zzd;
        return zzlhVar != null ? zzlhVar.zzc() : this.zza.zzc();
    }

    public final void zzd(zzmf zzmfVar) {
        if (zzmfVar == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzmf zzmfVar) throws zziz {
        zzlh zzlhVar;
        zzlh zzlhVarZzk = zzmfVar.zzk();
        if (zzlhVarZzk == null || zzlhVarZzk == (zzlhVar = this.zzd)) {
            return;
        }
        if (zzlhVar != null) {
            throw zziz.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.zzd = zzlhVarZzk;
        this.zzc = zzmfVar;
        zzlhVarZzk.zzg(this.zza.zzc());
    }

    public final void zzf(long j) {
        this.zza.zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzg(zzcg zzcgVar) {
        zzlh zzlhVar = this.zzd;
        if (zzlhVar != null) {
            zzlhVar.zzg(zzcgVar);
            zzcgVar = this.zzd.zzc();
        }
        this.zza.zzg(zzcgVar);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final boolean zzj() {
        if (this.zze) {
            return false;
        }
        zzlh zzlhVar = this.zzd;
        zzlhVar.getClass();
        return zzlhVar.zzj();
    }
}
