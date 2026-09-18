package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbbj implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbbb zza;
    final /* synthetic */ zzceu zzb;
    final /* synthetic */ zzbbl zzc;

    zzbbj(zzbbl zzbblVar, zzbbb zzbbbVar, zzceu zzceuVar) {
        this.zza = zzbbbVar;
        this.zzb = zzceuVar;
        this.zzc = zzbblVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc.zzd) {
            zzbbl zzbblVar = this.zzc;
            if (zzbblVar.zzb) {
                return;
            }
            zzbblVar.zzb = true;
            final zzbba zzbbaVar = this.zzc.zza;
            if (zzbbaVar == null) {
                return;
            }
            zzgey zzgeyVar = zzcep.zza;
            final zzbbb zzbbbVar = this.zza;
            final zzceu zzceuVar = this.zzb;
            final ListenableFuture listenableFutureZza = zzgeyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbg
                @Override // java.lang.Runnable
                public final void run() {
                    zzbbj zzbbjVar = this.zza;
                    zzbba zzbbaVar2 = zzbbaVar;
                    zzceu zzceuVar2 = zzceuVar;
                    try {
                        zzbbd zzbbdVarZzq = zzbbaVar2.zzq();
                        boolean zZzp = zzbbaVar2.zzp();
                        zzbbb zzbbbVar2 = zzbbbVar;
                        zzbay zzbayVarZzg = zZzp ? zzbbdVarZzq.zzg(zzbbbVar2) : zzbbdVarZzq.zzf(zzbbbVar2);
                        if (!zzbayVarZzg.zze()) {
                            zzceuVar2.zzd(new RuntimeException("No entry contents."));
                            zzbbl.zze(zzbbjVar.zzc);
                            return;
                        }
                        zzbbi zzbbiVar = new zzbbi(zzbbjVar, zzbayVarZzg.zzc(), 1);
                        int i = zzbbiVar.read();
                        if (i == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        zzbbiVar.unread(i);
                        zzceuVar2.zzc(zzbbn.zzb(zzbbiVar, zzbayVarZzg.zzd(), zzbayVarZzg.zzg(), zzbayVarZzg.zza(), zzbayVarZzg.zzf()));
                    } catch (RemoteException | IOException e) {
                        zzcec.zzh("Unable to obtain a cache service instance.", e);
                        zzceuVar2.zzd(e);
                        zzbbl.zze(zzbbjVar.zzc);
                    }
                }
            });
            final zzceu zzceuVar2 = this.zzb;
            zzceuVar2.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbh
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzbbj.zzd;
                    if (zzceuVar2.isCancelled()) {
                        listenableFutureZza.cancel(true);
                    }
                }
            }, zzcep.zzf);
        }
    }
}
