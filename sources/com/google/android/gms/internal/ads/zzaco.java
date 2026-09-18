package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaco {
    private final zzacn zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public zzaco(zzacn zzacnVar) {
        this.zza = zzacnVar;
    }

    public final zzacu zza(Object... objArr) {
        Constructor constructorZza;
        synchronized (this.zzb) {
            try {
                if (!this.zzb.get()) {
                    try {
                        constructorZza = this.zza.zza();
                    } catch (ClassNotFoundException unused) {
                        this.zzb.set(true);
                        constructorZza = null;
                    } catch (Exception e) {
                        throw new RuntimeException("Error instantiating extension", e);
                    }
                }
                constructorZza = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (constructorZza == null) {
            return null;
        }
        try {
            return (zzacu) constructorZza.newInstance(objArr);
        } catch (Exception e2) {
            throw new IllegalStateException("Unexpected error creating extractor", e2);
        }
    }
}
