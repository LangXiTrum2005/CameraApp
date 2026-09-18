package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzggj {
    private final List zza = new ArrayList();
    private final zzgrw zzb = zzgrw.zza;
    private boolean zzc = false;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzggh) it.next()).zza = false;
        }
    }

    public final zzggj zza(zzggh zzgghVar) {
        if (zzgghVar.zzf != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzgghVar.zza) {
            zzd();
        }
        zzgghVar.zzf = this;
        this.zza.add(zzgghVar);
        return this;
    }

    public final zzggm zzb() throws GeneralSecurityException {
        int i;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        this.zzc = true;
        List list = this.zza;
        zzgvd zzgvdVarZzd = zzgvg.zzd();
        int i2 = 0;
        while (i2 < list.size() - 1) {
            int i3 = i2 + 1;
            if (((zzggh) list.get(i2)).zze == zzggi.zza && ((zzggh) list.get(i3)).zze != zzggi.zza) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
            i2 = i3;
        }
        HashSet hashSet = new HashSet();
        Integer num = null;
        for (zzggh zzgghVar : this.zza) {
            zzgge unused = zzgghVar.zzb;
            if (zzgghVar.zze == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            int i4 = 3;
            if (zzgghVar.zze == zzggi.zza) {
                i = 0;
                while (true) {
                    if (i != 0 && !hashSet.contains(Integer.valueOf(i))) {
                        break;
                    }
                    SecureRandom secureRandom = new SecureRandom();
                    byte[] bArr = new byte[4];
                    int i5 = 0;
                    while (i5 == 0) {
                        secureRandom.nextBytes(bArr);
                        i5 = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                    }
                    i = i5;
                }
            } else {
                zzggi unused2 = zzgghVar.zze;
                i = 0;
            }
            Integer numValueOf = Integer.valueOf(i);
            if (hashSet.contains(numValueOf)) {
                throw new GeneralSecurityException("Id " + i + " is used twice in the keyset");
            }
            hashSet.add(numValueOf);
            zzggh.zza(zzgghVar);
            zzggq zzggqVar = zzgghVar.zzd;
            zzgge zzggeVarZzc = zzgghVar.zzc();
            if (!zzgge.zza.equals(zzggeVarZzc)) {
                if (zzgge.zzb.equals(zzggeVarZzc)) {
                    i4 = 4;
                } else {
                    if (!zzgge.zzc.equals(zzggeVarZzc)) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    i4 = 5;
                }
            }
            zzgoy zzgoyVar = (zzgoy) (zzggqVar instanceof zzgnp ? ((zzgnp) zzggqVar).zzb() : zzgoe.zzd().zzf(zzggqVar, zzgoy.class));
            zzgut zzgutVarZza = zzghb.zza(zzgoyVar.zzc());
            zzgve zzgveVarZzd = zzgvf.zzd();
            zzgveVarZzd.zzb(i);
            zzgveVarZzd.zzd(i4);
            zzgveVarZzd.zza(zzgutVarZza);
            zzgveVarZzd.zzc(zzgoyVar.zzc().zzf());
            zzgvdVarZzd.zza((zzgvf) zzgveVarZzd.zzal());
            if (zzgghVar.zza) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                if (zzgghVar.zzb != zzgge.zza) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
                num = numValueOf;
            }
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzgvdVarZzd.zzb(num.intValue());
        return zzggm.zzb((zzgvg) zzgvdVarZzd.zzal(), this.zzb);
    }
}
