package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzfmn {
    public static zzfmo zza(Context context, int i) {
        boolean zBooleanValue;
        if (zzfnc.zza()) {
            int i2 = i - 2;
            if (i2 != 20 && i2 != 21) {
                switch (i2) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        zBooleanValue = ((Boolean) zzbht.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        zBooleanValue = ((Boolean) zzbht.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        zBooleanValue = ((Boolean) zzbht.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                zBooleanValue = ((Boolean) zzbht.zze.zze()).booleanValue();
            }
            if (zBooleanValue) {
                return new zzfmq(context, i);
            }
        }
        return new zzfnl();
    }

    public static zzfmo zzb(Context context, int i, int i2, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        zzfmo zzfmoVarZza = zza(context, i);
        if (zzfmoVarZza instanceof zzfmq) {
            zzfmoVarZza.zzh();
            zzfmoVarZza.zzm(i2);
            if (zzfmy.zze(zzlVar.zzp)) {
                zzfmoVarZza.zze(zzlVar.zzp);
            }
        }
        return zzfmoVarZza;
    }
}
