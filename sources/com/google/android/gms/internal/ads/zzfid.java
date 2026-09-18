package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfid {
    private static zzfid zza;
    private final Context zzb;
    private final com.google.android.gms.ads.internal.client.zzcl zzc;
    private final AtomicReference zzd = new AtomicReference();

    zzfid(Context context, com.google.android.gms.ads.internal.client.zzcl zzclVar) {
        this.zzb = context;
        this.zzc = zzclVar;
    }

    static com.google.android.gms.ads.internal.client.zzcl zza(Context context) {
        try {
            return com.google.android.gms.ads.internal.client.zzck.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(Context.class).newInstance(context));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            zzcec.zzh("Failed to retrieve lite SDK info.", e);
            return null;
        }
    }

    public static zzfid zzd(Context context) {
        synchronized (zzfid.class) {
            zzfid zzfidVar = zza;
            if (zzfidVar != null) {
                return zzfidVar;
            }
            Context applicationContext = context.getApplicationContext();
            long jLongValue = ((Long) zzbic.zzb.zze()).longValue();
            com.google.android.gms.ads.internal.client.zzcl zzclVarZza = null;
            if (jLongValue > 0 && jLongValue <= 240304702) {
                zzclVarZza = zza(applicationContext);
            }
            zzfid zzfidVar2 = new zzfid(applicationContext, zzclVarZza);
            zza = zzfidVar2;
            return zzfidVar2;
        }
    }

    private final com.google.android.gms.ads.internal.client.zzen zzg() {
        com.google.android.gms.ads.internal.client.zzcl zzclVar = this.zzc;
        if (zzclVar != null) {
            try {
                return zzclVar.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final zzbsv zzb() {
        return (zzbsv) this.zzd.get();
    }

    public final zzcei zzc(int i, boolean z, int i2) {
        com.google.android.gms.ads.internal.client.zzen zzenVarZzg;
        com.google.android.gms.ads.internal.zzt.zzp();
        boolean zZzD = com.google.android.gms.ads.internal.util.zzt.zzD(this.zzb);
        zzcei zzceiVar = new zzcei(240304000, i2, true, zZzD);
        return (((Boolean) zzbic.zzc.zze()).booleanValue() && (zzenVarZzg = zzg()) != null) ? new zzcei(240304000, zzenVarZzg.zza(), true, zZzD) : zzceiVar;
    }

    public final String zze() {
        com.google.android.gms.ads.internal.client.zzen zzenVarZzg = zzg();
        if (zzenVarZzg != null) {
            return zzenVarZzg.zzb();
        }
        return null;
    }

    public final void zzf(zzbsv zzbsvVar) {
        zzbsv adapterCreator;
        if (!((Boolean) zzbic.zza.zze()).booleanValue()) {
            zzfic.zza(this.zzd, null, zzbsvVar);
            return;
        }
        com.google.android.gms.ads.internal.client.zzcl zzclVar = this.zzc;
        if (zzclVar == null) {
            adapterCreator = null;
        } else {
            try {
                adapterCreator = zzclVar.getAdapterCreator();
            } catch (RemoteException unused) {
                adapterCreator = null;
            }
        }
        AtomicReference atomicReference = this.zzd;
        if (adapterCreator != null) {
            zzbsvVar = adapterCreator;
        }
        zzfic.zza(atomicReference, null, zzbsvVar);
    }
}
