package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbvl implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbvn zza;

    zzbvl(zzbvn zzbvnVar) {
        this.zza = zzbvnVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbvn zzbvnVar = this.zza;
        Intent intentZzb = zzbvnVar.zzb();
        com.google.android.gms.ads.internal.zzt.zzp();
        com.google.android.gms.ads.internal.util.zzt.zzS(zzbvnVar.zzb, intentZzb);
    }
}
