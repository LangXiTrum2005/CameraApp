package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbuk extends zzayg implements zzbum {
    zzbuk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zze(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString("Adapter returned null.");
        zzbm(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzeVar);
        zzbm(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzg(zzbtk zzbtkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzbtkVar);
        zzbm(1, parcelZza);
    }
}
