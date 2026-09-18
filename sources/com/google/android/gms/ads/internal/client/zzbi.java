package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayg;
import com.google.android.gms.internal.ads.zzayi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbi extends zzayg implements zzbk {
    zzbi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzb(zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzeVar);
        zzbm(2, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzc() throws RemoteException {
        zzbm(1, zza());
    }
}
