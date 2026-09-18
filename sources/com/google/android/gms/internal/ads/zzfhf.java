package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfhf {
    private com.google.android.gms.ads.internal.client.zzl zza;
    private com.google.android.gms.ads.internal.client.zzq zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzfk zzd;
    private boolean zze;
    private ArrayList zzf;
    private ArrayList zzg;
    private zzbjb zzh;
    private com.google.android.gms.ads.internal.client.zzw zzi;
    private AdManagerAdViewOptions zzj;
    private PublisherAdViewOptions zzk;
    private com.google.android.gms.ads.internal.client.zzcb zzl;
    private zzbpp zzn;
    private zzeqe zzq;
    private com.google.android.gms.ads.internal.client.zzcf zzs;
    private int zzm = 1;
    private final zzfgs zzo = new zzfgs();
    private boolean zzp = false;
    private boolean zzr = false;

    public final zzfhf zzA(zzbjb zzbjbVar) {
        this.zzh = zzbjbVar;
        return this;
    }

    public final zzfhf zzB(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfhf zzC(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfhf zzD(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zzc();
            this.zzl = publisherAdViewOptions.zza();
        }
        return this;
    }

    public final zzfhf zzE(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        this.zza = zzlVar;
        return this;
    }

    public final zzfhf zzF(com.google.android.gms.ads.internal.client.zzfk zzfkVar) {
        this.zzd = zzfkVar;
        return this;
    }

    public final zzfhh zzG() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzfhh(this, null);
    }

    public final String zzI() {
        return this.zzc;
    }

    public final boolean zzO() {
        return this.zzp;
    }

    public final zzfhf zzQ(com.google.android.gms.ads.internal.client.zzcf zzcfVar) {
        this.zzs = zzcfVar;
        return this;
    }

    public final com.google.android.gms.ads.internal.client.zzl zze() {
        return this.zza;
    }

    public final com.google.android.gms.ads.internal.client.zzq zzg() {
        return this.zzb;
    }

    public final zzfgs zzo() {
        return this.zzo;
    }

    public final zzfhf zzp(zzfhh zzfhhVar) {
        this.zzo.zza(zzfhhVar.zzo.zza);
        this.zza = zzfhhVar.zzd;
        this.zzb = zzfhhVar.zze;
        this.zzs = zzfhhVar.zzr;
        this.zzc = zzfhhVar.zzf;
        this.zzd = zzfhhVar.zza;
        this.zzf = zzfhhVar.zzg;
        this.zzg = zzfhhVar.zzh;
        this.zzh = zzfhhVar.zzi;
        this.zzi = zzfhhVar.zzj;
        zzq(zzfhhVar.zzl);
        zzD(zzfhhVar.zzm);
        this.zzp = zzfhhVar.zzp;
        this.zzq = zzfhhVar.zzc;
        this.zzr = zzfhhVar.zzq;
        return this;
    }

    public final zzfhf zzq(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzfhf zzr(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        this.zzb = zzqVar;
        return this;
    }

    public final zzfhf zzs(String str) {
        this.zzc = str;
        return this;
    }

    public final zzfhf zzt(com.google.android.gms.ads.internal.client.zzw zzwVar) {
        this.zzi = zzwVar;
        return this;
    }

    public final zzfhf zzu(zzeqe zzeqeVar) {
        this.zzq = zzeqeVar;
        return this;
    }

    public final zzfhf zzv(zzbpp zzbppVar) {
        this.zzn = zzbppVar;
        this.zzd = new com.google.android.gms.ads.internal.client.zzfk(false, true, false);
        return this;
    }

    public final zzfhf zzw(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzfhf zzx(boolean z) {
        this.zzr = true;
        return this;
    }

    public final zzfhf zzy(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzfhf zzz(int i) {
        this.zzm = i;
        return this;
    }
}
