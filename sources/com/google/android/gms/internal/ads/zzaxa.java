package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaxa extends zzaxx {
    private final long zzi;

    public zzaxa(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, long j, int i, int i2) {
        super(zzawjVar, "hIbo0WHjc5N2XBD7HI+Mwh9BXu/nIzOhdTaHZ1DPjeizuR48SZNCpBdtOxY4cHlb", "mLbfRIQxtPVbZphUgAhWqMeuqa25Ale/5rz8vv9YVkc=", zzasgVar, i, 25);
        this.zzi = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zzf.invoke(null, null)).longValue();
        synchronized (this.zze) {
            this.zze.zzt(jLongValue);
            long j = this.zzi;
            if (j != 0) {
                this.zze.zzT(jLongValue - j);
                this.zze.zzU(this.zzi);
            }
        }
    }
}
