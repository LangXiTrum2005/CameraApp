package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdxv implements zzdxf {
    private final long zza;
    private final zzdxk zzb;
    private final zzfgd zzc;

    zzdxv(long j, Context context, zzdxk zzdxkVar, zzclg zzclgVar, String str) {
        this.zza = j;
        this.zzb = zzdxkVar;
        zzfgf zzfgfVarZzv = zzclgVar.zzv();
        zzfgfVarZzv.zzb(context);
        zzfgfVarZzv.zza(str);
        this.zzc = zzfgfVarZzv.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zzb(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        try {
            this.zzc.zzf(zzlVar, new zzdxt(this));
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zzc() {
        try {
            this.zzc.zzk(new zzdxu(this));
            this.zzc.zzm(ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }
}
