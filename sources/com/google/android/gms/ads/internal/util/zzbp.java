package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzaqa;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.internal.ads.zzceb;
import com.google.android.gms.internal.ads.zzceu;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbp extends zzaqa {
    private final zzceu zza;
    private final zzceb zzb;

    public zzbp(String str, Map map, zzceu zzceuVar) {
        super(0, str, new zzbo(zzceuVar));
        this.zza = zzceuVar;
        zzceb zzcebVar = new zzceb(null);
        this.zzb = zzcebVar;
        zzcebVar.zzd(str, "GET", null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    protected final zzaqg zzh(zzapw zzapwVar) {
        return zzaqg.zzb(zzapwVar, zzaqx.zzb(zzapwVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    protected final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzapw zzapwVar = (zzapw) obj;
        this.zzb.zzf(zzapwVar.zzc, zzapwVar.zza);
        byte[] bArr = zzapwVar.zzb;
        if (zzceb.zzk() && bArr != null) {
            this.zzb.zzh(bArr);
        }
        this.zza.zzc(zzapwVar);
    }
}
