package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbwa extends NativeAd.Image {
    private final zzbjm zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;

    public zzbwa(zzbjm zzbjmVar) {
        Drawable drawable;
        double dZzb;
        this.zza = zzbjmVar;
        Uri uriZze = null;
        try {
            IObjectWrapper iObjectWrapperZzf = zzbjmVar.zzf();
            drawable = iObjectWrapperZzf != null ? (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzf) : null;
        } catch (RemoteException e) {
            zzcec.zzh("", e);
        }
        this.zzb = drawable;
        try {
            uriZze = this.zza.zze();
        } catch (RemoteException e2) {
            zzcec.zzh("", e2);
        }
        this.zzc = uriZze;
        try {
            dZzb = this.zza.zzb();
        } catch (RemoteException e3) {
            zzcec.zzh("", e3);
            dZzb = 1.0d;
        }
        this.zzd = dZzb;
        try {
            this.zza.zzd();
        } catch (RemoteException e4) {
            zzcec.zzh("", e4);
        }
        try {
            this.zza.zzc();
        } catch (RemoteException e5) {
            zzcec.zzh("", e5);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final double getScale() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Uri getUri() {
        return this.zzc;
    }
}
