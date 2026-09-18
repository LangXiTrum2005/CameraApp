package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaxu extends zzaxx {
    private final View zzi;

    public zzaxu(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i, int i2, View view) {
        super(zzawjVar, "a1Na7bntM+sktGxZBhUnqailj8ITQ7piLQZ5OyqVU2HU4R0rOCZ63N/fUHG081A+", "eISRjanjhAfdgJ9+lE3tGViJFRMvsuX1oVbmo+9k2XU=", zzasgVar, i, 57);
        this.zzi = view;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdk);
            Boolean bool2 = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzku);
            zzawn zzawnVar = new zzawn((String) this.zzf.invoke(null, this.zzi, this.zzb.zzb().getResources().getDisplayMetrics(), bool, bool2));
            zzatb zzatbVarZza = zzatc.zza();
            zzatbVarZza.zzb(zzawnVar.zza.longValue());
            zzatbVarZza.zzd(zzawnVar.zzb.longValue());
            zzatbVarZza.zze(zzawnVar.zzc.longValue());
            if (bool2.booleanValue()) {
                zzatbVarZza.zzc(zzawnVar.zze.longValue());
            }
            if (bool.booleanValue()) {
                zzatbVarZza.zza(zzawnVar.zzd.longValue());
            }
            this.zze.zzY((zzatc) zzatbVarZza.zzal());
        }
    }
}
