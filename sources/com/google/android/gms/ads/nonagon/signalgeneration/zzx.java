package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbxi;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzgej;
import java.util.ArrayList;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzx implements zzgej {
    final /* synthetic */ zzbxi zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaa zzc;

    zzx(zzaa zzaaVar, zzbxi zzbxiVar, boolean z) {
        this.zza = zzbxiVar;
        this.zzb = z;
        this.zzc = zzaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        try {
            this.zza.zze("Internal error: " + th.getMessage());
        } catch (RemoteException e) {
            zzcec.zzh("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        ArrayList<Uri> arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            if (this.zzc.zzu || this.zzb) {
                for (Uri uri : arrayList) {
                    if (this.zzc.zzS(uri)) {
                        this.zzc.zzt.zzc(zzaa.zzac(uri, this.zzc.zzD, "1").toString(), null);
                    } else {
                        if (((Boolean) zzba.zzc().zza(zzbgc.zzhx)).booleanValue()) {
                            this.zzc.zzt.zzc(uri.toString(), null);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            zzcec.zzh("", e);
        }
    }
}
