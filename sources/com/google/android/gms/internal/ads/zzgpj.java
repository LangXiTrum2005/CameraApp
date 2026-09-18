package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpj {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    /* synthetic */ zzgpj(zzgpd zzgpdVar, zzgpi zzgpiVar) {
        this.zza = new HashMap(zzgpdVar.zza);
        this.zzb = new HashMap(zzgpdVar.zzb);
        this.zzc = new HashMap(zzgpdVar.zzc);
        this.zzd = new HashMap(zzgpdVar.zzd);
    }

    public final zzggc zza(zzgpc zzgpcVar, @Nullable zzghc zzghcVar) throws GeneralSecurityException {
        zzgpf zzgpfVar = new zzgpf(zzgpcVar.getClass(), zzgpcVar.zzd(), null);
        if (this.zzb.containsKey(zzgpfVar)) {
            return ((zzgnh) this.zzb.get(zzgpfVar)).zza(zzgpcVar, zzghcVar);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + zzgpfVar.toString() + " available");
    }

    public final zzggq zzb(zzgpc zzgpcVar) throws GeneralSecurityException {
        zzgpf zzgpfVar = new zzgpf(zzgpcVar.getClass(), zzgpcVar.zzd(), null);
        if (this.zzd.containsKey(zzgpfVar)) {
            return ((zzgoi) this.zzd.get(zzgpfVar)).zza(zzgpcVar);
        }
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + zzgpfVar.toString() + " available");
    }

    public final zzgpc zzc(zzggc zzggcVar, Class cls, @Nullable zzghc zzghcVar) throws GeneralSecurityException {
        zzgph zzgphVar = new zzgph(zzggcVar.getClass(), cls, null);
        if (this.zza.containsKey(zzgphVar)) {
            return ((zzgnl) this.zza.get(zzgphVar)).zza(zzggcVar, zzghcVar);
        }
        throw new GeneralSecurityException("No Key serializer for " + zzgphVar.toString() + " available");
    }

    public final zzgpc zzd(zzggq zzggqVar, Class cls) throws GeneralSecurityException {
        zzgph zzgphVar = new zzgph(zzggqVar.getClass(), cls, null);
        if (this.zzc.containsKey(zzgphVar)) {
            return ((zzgom) this.zzc.get(zzgphVar)).zza(zzggqVar);
        }
        throw new GeneralSecurityException("No Key Format serializer for " + zzgphVar.toString() + " available");
    }

    public final boolean zzi(zzgpc zzgpcVar) {
        return this.zzb.containsKey(new zzgpf(zzgpcVar.getClass(), zzgpcVar.zzd(), null));
    }

    public final boolean zzj(zzgpc zzgpcVar) {
        return this.zzd.containsKey(new zzgpf(zzgpcVar.getClass(), zzgpcVar.zzd(), null));
    }
}
