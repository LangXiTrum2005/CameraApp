package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfuk extends zzayg implements zzfum {
    zzfuk(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    @Override // com.google.android.gms.internal.ads.zzfum
    public final void zze(Bundle bundle, zzfuo zzfuoVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, bundle);
        zzayi.zzf(parcelZza, zzfuoVar);
        zzbn(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfum
    public final void zzf(String str, Bundle bundle, zzfuo zzfuoVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzayi.zzd(parcelZza, bundle);
        zzayi.zzf(parcelZza, zzfuoVar);
        zzbn(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfum
    public final void zzg(Bundle bundle, zzfuo zzfuoVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, bundle);
        zzayi.zzf(parcelZza, zzfuoVar);
        zzbn(3, parcelZza);
    }
}
