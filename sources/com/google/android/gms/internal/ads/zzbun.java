package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbun extends zzayg implements zzbup {
    zzbun(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbup
    public final void zze(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString("Adapter returned null.");
        zzbm(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbup
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzeVar);
        zzbm(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbup
    public final void zzg() throws RemoteException {
        zzbm(2, zza());
    }
}
