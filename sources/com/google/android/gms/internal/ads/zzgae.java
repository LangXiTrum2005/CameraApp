package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgae extends zzfzt {

    @CheckForNull
    Object[] zzd;
    private int zze;

    public zzgae() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzfzt, com.google.android.gms.internal.ads.zzfzu
    public final /* bridge */ /* synthetic */ zzfzu zzb(Object obj) {
        zzf(obj);
        return this;
    }

    zzgae(int i) {
        super(i);
        this.zzd = new Object[zzgaf.zzh(i)];
    }

    public final zzgae zzg(Iterable iterable) {
        iterable.getClass();
        if (this.zzd != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                zzf(it.next());
            }
        } else {
            super.zzc(iterable);
        }
        return this;
    }

    public final zzgaf zzh() {
        zzgaf zzgafVarZzv;
        int i = this.zzb;
        if (i == 0) {
            return zzgbq.zza;
        }
        if (i == 1) {
            return new zzgcb(Objects.requireNonNull(this.zza[0]));
        }
        if (this.zzd == null || zzgaf.zzh(i) != this.zzd.length) {
            zzgafVarZzv = zzgaf.zzv(this.zzb, this.zza);
            this.zzb = zzgafVarZzv.size();
        } else {
            int i2 = this.zzb;
            Object[] objArrCopyOf = this.zza;
            if (zzgaf.zzw(i2, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i2);
            }
            int i3 = this.zze;
            Object[] objArr = this.zzd;
            zzgafVarZzv = new zzgbq(objArrCopyOf, i3, objArr, objArr.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzgafVarZzv;
    }

    public final zzgae zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int iZzh = zzgaf.zzh(this.zzb);
            Object[] objArr = this.zzd;
            if (iZzh <= objArr.length) {
                Objects.requireNonNull(objArr);
                int length = this.zzd.length - 1;
                int iHashCode = obj.hashCode();
                int iZza = zzfzs.zza(iHashCode);
                while (true) {
                    int i = iZza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        iZza = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zze += iHashCode;
                        super.zza(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzd = null;
        super.zza(obj);
        return this;
    }
}
