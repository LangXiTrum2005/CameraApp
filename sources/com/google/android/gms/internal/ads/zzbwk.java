package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbwk extends zzayg implements zzbwm {
    zzbwk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zze(Intent intent) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, intent);
        zzbm(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeStringArray(strArr);
        parcelZza.writeIntArray(iArr);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzh() throws RemoteException {
        zzbm(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzaVar);
        zzbm(6, parcelZza);
    }
}
