package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzage extends zzagr {
    public static final Parcelable.Creator<zzage> CREATOR = new zzagd();
    public final byte[] zza;

    /* JADX WARN: Illegal instructions before constructor call */
    zzage(Parcel parcel) {
        String string = parcel.readString();
        int i = zzfy.zza;
        super(string);
        this.zza = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzage zzageVar = (zzage) obj;
            if (this.zzf.equals(zzageVar.zzf) && Arrays.equals(this.zza, zzageVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzf.hashCode() + 527) * 31) + Arrays.hashCode(this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeByteArray(this.zza);
    }

    public zzage(String str, byte[] bArr) {
        super(str);
        this.zza = bArr;
    }
}
