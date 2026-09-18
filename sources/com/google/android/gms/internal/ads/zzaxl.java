package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaxl extends zzaxx {
    public zzaxl(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i, int i2) {
        super(zzawjVar, "hvOzu3pRF2dcNdvDy8db1rttL97bOQyvLLd+NabZhD5sRaprNsAQL2vdtDd+eY16", "XE2927Ta6gTWmjrPmk4in7GLLwsXJnqTbhVN3N+/b3M=", zzasgVar, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcA);
        bool.booleanValue();
        zzavp zzavpVar = new zzavp((String) this.zzf.invoke(null, this.zzb.zzb(), bool));
        synchronized (this.zze) {
            this.zze.zzj(zzavpVar.zza);
            this.zze.zzC(zzavpVar.zzb);
        }
    }
}
