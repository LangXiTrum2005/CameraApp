package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zztu implements zzvi {
    private final zzadb zza;
    private zzacu zzb;
    private zzacv zzc;

    public zztu(zzadb zzadbVar) {
        this.zza = zzadbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final long zzb() {
        zzacv zzacvVar = this.zzc;
        if (zzacvVar != null) {
            return zzacvVar.zzf();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final void zzc() {
        zzacu zzacuVar = this.zzb;
        if (zzacuVar != null && (zzacuVar instanceof zzaig)) {
            ((zzaig) zzacuVar).zza();
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    @Override // com.google.android.gms.internal.ads.zzvi
    public final void zzd(zzu zzuVar, Uri uri, Map map, long j, long j2, zzacx zzacxVar) throws IOException {
        zzack zzackVar = new zzack(zzuVar, j, j2);
        this.zzc = zzackVar;
        if (this.zzb != null) {
            return;
        }
        zzacu[] zzacuVarArrZza = this.zza.zza(uri, map);
        int i = 0;
        boolean z = true;
        if (zzacuVarArrZza.length == 1) {
            this.zzb = zzacuVarArrZza[0];
        } else {
            for (zzacu zzacuVar : zzacuVarArrZza) {
                try {
                    if (zzacuVar.zze(zzackVar)) {
                        this.zzb = zzacuVar;
                        if (zzacuVar == null && zzackVar.zzf() != j) {
                            z = false;
                        }
                        zzek.zzf(z);
                        zzackVar.zzj();
                        break;
                    }
                    boolean z2 = this.zzb != null || zzackVar.zzf() == j;
                    zzek.zzf(z2);
                    zzackVar.zzj();
                } catch (EOFException unused) {
                    if (this.zzb != null || zzackVar.zzf() == j) {
                    }
                } catch (Throwable th) {
                    zzek.zzf(this.zzb != null || zzackVar.zzf() == j);
                    zzackVar.zzj();
                    throw th;
                }
                zzek.zzf(z2);
                zzackVar.zzj();
            }
            if (this.zzb == null) {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int length = zzacuVarArrZza.length;
                    if (i >= length) {
                        throw new zzwt("None of the available extractors (" + sb.toString() + ") could read the stream.", uri);
                    }
                    sb.append(zzacuVarArrZza[i].getClass().getSimpleName());
                    if (i < length - 1) {
                        sb.append(", ");
                    }
                    i++;
                }
            }
        }
        this.zzb.zzc(zzacxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final void zze() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final int zza(zzadr zzadrVar) throws IOException {
        zzacu zzacuVar = this.zzb;
        zzacuVar.getClass();
        zzacv zzacvVar = this.zzc;
        zzacvVar.getClass();
        return zzacuVar.zzb(zzacvVar, zzadrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvi
    public final void zzf(long j, long j2) {
        zzacu zzacuVar = this.zzb;
        zzacuVar.getClass();
        zzacuVar.zzd(j, j2);
    }
}
