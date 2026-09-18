package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaxt extends zzaxx {
    public zzaxt(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i, int i2) {
        super(zzawjVar, "CYcH4LBpiH+KaEScKuk48/IbmIORuaeHTHx2iwUA0vRWrbIkTWIgIbVYJ8eozDwX", "AtCF0F/Ugi3KOt6zYtgfLSsd+8KzXVTsnhwfj9NoYBY=", zzasgVar, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzag(3);
        boolean zBooleanValue = ((Boolean) this.zzf.invoke(null, this.zzb.zzb())).booleanValue();
        synchronized (this.zze) {
            try {
                if (zBooleanValue) {
                    this.zze.zzag(2);
                } else {
                    this.zze.zzag(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
