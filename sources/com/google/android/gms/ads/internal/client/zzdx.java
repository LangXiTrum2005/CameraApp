package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.ads.zzcdv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdx {
    private final String zza;
    private final List zzb;
    private final Set zzc;
    private final Bundle zzd;
    private final Map zze;
    private final String zzf;
    private final String zzg;

    @NotOnlyInitialized
    private final SearchAdRequest zzh;
    private final int zzi;
    private final Set zzj;
    private final Bundle zzk;
    private final Set zzl;
    private final boolean zzm;
    private final String zzn;
    private final int zzo;

    public zzdx(zzdw zzdwVar, SearchAdRequest searchAdRequest) {
        this.zza = zzdwVar.zzg;
        this.zzb = zzdwVar.zzh;
        this.zzc = Collections.unmodifiableSet(zzdwVar.zza);
        this.zzd = zzdwVar.zzb;
        this.zze = Collections.unmodifiableMap(zzdwVar.zzc);
        this.zzf = zzdwVar.zzi;
        this.zzg = zzdwVar.zzj;
        this.zzh = searchAdRequest;
        this.zzi = zzdwVar.zzk;
        this.zzj = Collections.unmodifiableSet(zzdwVar.zzd);
        this.zzk = zzdwVar.zze;
        this.zzl = Collections.unmodifiableSet(zzdwVar.zzf);
        this.zzm = zzdwVar.zzl;
        this.zzn = zzdwVar.zzm;
        this.zzo = zzdwVar.zzn;
    }

    public final int zza() {
        return this.zzo;
    }

    public final int zzb() {
        return this.zzi;
    }

    public final Bundle zzc(Class cls) {
        Bundle bundle = this.zzd.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle zzd() {
        return this.zzk;
    }

    public final Bundle zze(Class cls) {
        return this.zzd.getBundle(cls.getName());
    }

    public final Bundle zzf() {
        return this.zzd;
    }

    @Deprecated
    public final NetworkExtras zzg(Class cls) {
        return (NetworkExtras) this.zze.get(cls);
    }

    public final SearchAdRequest zzh() {
        return this.zzh;
    }

    public final String zzi() {
        return this.zzn;
    }

    public final String zzj() {
        return this.zza;
    }

    public final String zzk() {
        return this.zzf;
    }

    public final String zzl() {
        return this.zzg;
    }

    public final List zzm() {
        return new ArrayList(this.zzb);
    }

    public final Set zzn() {
        return this.zzl;
    }

    public final Set zzo() {
        return this.zzc;
    }

    @Deprecated
    public final boolean zzp() {
        return this.zzm;
    }

    public final boolean zzq(Context context) {
        RequestConfiguration requestConfigurationZzc = zzej.zzf().zzc();
        zzay.zzb();
        Set set = this.zzj;
        String strZzy = zzcdv.zzy(context);
        return set.contains(strZzy) || requestConfigurationZzc.getTestDeviceIds().contains(strZzy);
    }
}
