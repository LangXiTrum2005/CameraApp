package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzws {
    public final int zzc;
    private final zzgaa zze;
    private int zzf;
    public static final zzws zza = new zzws(new zzcz[0]);
    private static final String zzd = Integer.toString(0, 36);

    @Deprecated
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzwr
    };

    /* JADX WARN: Multi-variable type inference failed */
    public zzws(zzcz... zzczVarArr) {
        this.zze = zzgaa.zzk(zzczVarArr);
        this.zzc = zzczVarArr.length;
        int i = 0;
        while (i < this.zze.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.zze.size(); i3++) {
                if (((zzcz) this.zze.get(i)).equals(this.zze.get(i3))) {
                    zzff.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzws zzwsVar = (zzws) obj;
            if (this.zzc == zzwsVar.zzc && this.zze.equals(zzwsVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.zze.hashCode();
        this.zzf = iHashCode;
        return iHashCode;
    }

    public final int zza(zzcz zzczVar) {
        int iIndexOf = this.zze.indexOf(zzczVar);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzcz zzb(int i) {
        return (zzcz) this.zze.get(i);
    }
}
