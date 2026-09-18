package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbjg extends NativeAd.AdChoicesInfo {
    private final zzbjf zza;
    private final List zzb = new ArrayList();
    private String zzc;

    public zzbjg(zzbjf zzbjfVar) {
        IBinder iBinder;
        this.zza = zzbjfVar;
        try {
            this.zzc = zzbjfVar.zzg();
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            this.zzc = "";
        }
        try {
            for (Object obj : zzbjfVar.zzh()) {
                zzbjm zzbjkVar = null;
                if ((obj instanceof IBinder) && (iBinder = (IBinder) obj) != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzbjkVar = iInterfaceQueryLocalInterface instanceof zzbjm ? (zzbjm) iInterfaceQueryLocalInterface : new zzbjk(iBinder);
                }
                if (zzbjkVar != null) {
                    this.zzb.add(new zzbjn(zzbjkVar));
                }
            }
        } catch (RemoteException e2) {
            zzcec.zzh("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.zzc;
    }
}
