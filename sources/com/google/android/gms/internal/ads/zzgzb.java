package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgzb {
    private final zzgza zza;

    private zzgzb(zzgza zzgzaVar) {
        byte[] bArr = zzhae.zzd;
        this.zza = zzgzaVar;
        zzgzaVar.zze = this;
    }

    public static zzgzb zza(zzgza zzgzaVar) {
        zzgzb zzgzbVar = zzgzaVar.zze;
        return zzgzbVar != null ? zzgzbVar : new zzgzb(zzgzaVar);
    }

    public final void zzA(int i, int i2) throws IOException {
        this.zza.zzr(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzC(int i, long j) throws IOException {
        this.zza.zzt(i, (j >> 63) ^ (j + j));
    }

    @Deprecated
    public final void zzE(int i) throws IOException {
        this.zza.zzq(i, 3);
    }

    public final void zzF(int i, String str) throws IOException {
        this.zza.zzo(i, str);
    }

    public final void zzH(int i, int i2) throws IOException {
        this.zza.zzr(i, i2);
    }

    public final void zzJ(int i, long j) throws IOException {
        this.zza.zzt(i, j);
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzJ(i, z);
    }

    public final void zzd(int i, zzgyl zzgylVar) throws IOException {
        this.zza.zzK(i, zzgylVar);
    }

    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzK(i, (zzgyl) list.get(i2));
        }
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzq(i, 4);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzm(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    public final void zzo(int i, float f) throws IOException {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    public final void zzq(int i, Object obj, zzhby zzhbyVar) throws IOException {
        zzgza zzgzaVar = this.zza;
        zzgzaVar.zzq(i, 3);
        zzhbyVar.zzm((zzhbe) obj, zzgzaVar.zze);
        zzgzaVar.zzq(i, 4);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    public final void zzt(int i, long j) throws IOException {
        this.zza.zzt(i, j);
    }

    public final void zzv(int i, Object obj, zzhby zzhbyVar) throws IOException {
        this.zza.zzn(i, (zzhbe) obj, zzhbyVar);
    }

    public final void zzw(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzy(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    public final void zzG(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzham)) {
            while (i2 < list.size()) {
                this.zza.zzo(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzham zzhamVar = (zzham) list;
        while (i2 < list.size()) {
            Object objZzf = zzhamVar.zzf(i2);
            if (objZzf instanceof String) {
                this.zza.zzo(i, (String) objZzf);
            } else {
                this.zza.zzK(i, (zzgyl) objZzf);
            }
            i2++;
        }
    }

    public final void zzI(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzr(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzz = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzz += zzgza.zzz(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzs(iZzz);
        while (i2 < list.size()) {
            this.zza.zzs(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzK(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzt(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzA += zzgza.zzA(((Long) list.get(i3)).longValue());
        }
        this.zza.zzs(iZzA);
        while (i2 < list.size()) {
            this.zza.zzu(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzJ(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).booleanValue();
            i3++;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzI(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzi(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzk(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzA += zzgza.zzA(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzs(iZzA);
        while (i2 < list.size()) {
            this.zza.zzm(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzB(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzgza zzgzaVar = this.zza;
                int iIntValue = ((Integer) list.get(i2)).intValue();
                zzgzaVar.zzr(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzz = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            iZzz += zzgza.zzz((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.zza.zzs(iZzz);
        while (i2 < list.size()) {
            zzgza zzgzaVar2 = this.zza;
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            zzgzaVar2.zzs((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i2++;
        }
    }

    public final void zzD(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzgza zzgzaVar = this.zza;
                long jLongValue = ((Long) list.get(i2)).longValue();
                zzgzaVar.zzt(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iZzA += zzgza.zzA((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.zza.zzs(iZzA);
        while (i2 < list.size()) {
            zzgza zzgzaVar2 = this.zza;
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            zzgzaVar2.zzu((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).doubleValue();
            i3 += 8;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzA += zzgza.zzA(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzs(iZzA);
        while (i2 < list.size()) {
            this.zza.zzm(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).floatValue();
            i3 += 4;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzt(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int iZzA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzA += zzgza.zzA(((Long) list.get(i3)).longValue());
        }
        this.zza.zzs(iZzA);
        while (i2 < list.size()) {
            this.zza.zzu(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzx(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzi(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzz(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzq(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.zza.zzs(i3);
        while (i2 < list.size()) {
            this.zza.zzk(((Long) list.get(i2)).longValue());
            i2++;
        }
    }
}
