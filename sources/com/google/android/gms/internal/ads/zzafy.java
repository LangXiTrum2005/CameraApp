package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class zzafy implements zzbx {
    public static final Parcelable.Creator<zzafy> CREATOR = new zzafx();
    public final String zza;
    public final String zzb;

    protected zzafy(Parcel parcel) {
        String string = parcel.readString();
        int i = zzfy.zza;
        this.zza = string;
        this.zzb = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzafy zzafyVar = (zzafy) obj;
            if (this.zza.equals(zzafyVar.zza) && this.zzb.equals(zzafyVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() + 527) * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return "VC: " + this.zza + "=" + this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    @Override // com.google.android.gms.internal.ads.zzbx
    public final void zza(zzbt zzbtVar) {
        byte b;
        switch (this.zza) {
            case "ALBUM":
                b = 2;
                break;
            case "TITLE":
                b = 0;
                break;
            case "DESCRIPTION":
                b = 4;
                break;
            case "ALBUMARTIST":
                b = 3;
                break;
            case "ARTIST":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            zzbtVar.zzq(this.zzb);
            return;
        }
        if (b == 1) {
            zzbtVar.zze(this.zzb);
            return;
        }
        if (b == 2) {
            zzbtVar.zzd(this.zzb);
        } else if (b == 3) {
            zzbtVar.zzc(this.zzb);
        } else {
            if (b != 4) {
                return;
            }
            zzbtVar.zzh(this.zzb);
        }
    }

    public zzafy(String str, String str2) {
        this.zza = zzfwk.zzb(str);
        this.zzb = str2;
    }
}
