package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzua extends zzts {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzhy zzc;

    protected zzua() {
    }

    protected abstract void zzA(Object obj, zzut zzutVar, zzcx zzcxVar);

    protected final void zzB(final Object obj, zzut zzutVar) {
        zzek.zzd(!this.zza.containsKey(obj));
        zzus zzusVar = new zzus() { // from class: com.google.android.gms.internal.ads.zztx
            @Override // com.google.android.gms.internal.ads.zzus
            public final void zza(zzut zzutVar2, zzcx zzcxVar) {
                this.zza.zzA(obj, zzutVar2, zzcxVar);
            }
        };
        zzty zztyVar = new zzty(this, obj);
        this.zza.put(obj, new zztz(zzutVar, zzusVar, zztyVar));
        Handler handler = this.zzb;
        handler.getClass();
        zzutVar.zzh(handler, zztyVar);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zzutVar.zzg(handler2, zztyVar);
        zzutVar.zzm(zzusVar, this.zzc, zzb());
        if (zzu()) {
            return;
        }
        zzutVar.zzi(zzusVar);
    }

    @Override // com.google.android.gms.internal.ads.zzts
    protected final void zzj() {
        for (zztz zztzVar : this.zza.values()) {
            zztzVar.zza.zzi(zztzVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzts
    protected final void zzl() {
        for (zztz zztzVar : this.zza.values()) {
            zztzVar.zza.zzk(zztzVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzts
    protected void zzn(zzhy zzhyVar) {
        this.zzc = zzhyVar;
        this.zzb = zzfy.zzw(null);
    }

    @Override // com.google.android.gms.internal.ads.zzts
    protected void zzq() {
        for (zztz zztzVar : this.zza.values()) {
            zztzVar.zza.zzp(zztzVar.zzb);
            zztzVar.zza.zzs(zztzVar.zzc);
            zztzVar.zza.zzr(zztzVar.zzc);
        }
        this.zza.clear();
    }

    protected int zzw(Object obj, int i) {
        return 0;
    }

    protected long zzx(Object obj, long j, zzur zzurVar) {
        return j;
    }

    protected zzur zzy(Object obj, zzur zzurVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public void zzz() throws IOException {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((zztz) it.next()).zza.zzz();
        }
    }
}
