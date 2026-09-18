package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzauz implements zzfsm {
    final /* synthetic */ zzfqm zza;

    zzauz(zzavb zzavbVar, zzfqm zzfqmVar) {
        this.zza = zzfqmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsm
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
