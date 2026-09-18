package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhaw implements zzhbz {
    private static final zzhbc zza = new zzhau();
    private final zzhbc zzb;

    public zzhaw() {
        zzhbc zzhbcVar;
        zzhbc[] zzhbcVarArr = new zzhbc[2];
        zzhbcVarArr[0] = zzgzo.zza();
        try {
            zzhbcVar = (zzhbc) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzhbcVar = zza;
        }
        zzhbcVarArr[1] = zzhbcVar;
        zzhav zzhavVar = new zzhav(zzhbcVarArr);
        byte[] bArr = zzhae.zzd;
        this.zzb = zzhavVar;
    }

    private static boolean zzb(zzhbb zzhbbVar) {
        return zzhbbVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhbz
    public final zzhby zza(Class cls) {
        zzhca.zzr(cls);
        zzhbb zzhbbVarZzb = this.zzb.zzb(cls);
        if (zzhbbVarZzb.zzb()) {
            return zzgzu.class.isAssignableFrom(cls) ? zzhbi.zzc(zzhca.zzn(), zzgzi.zzb(), zzhbbVarZzb.zza()) : zzhbi.zzc(zzhca.zzm(), zzgzi.zza(), zzhbbVarZzb.zza());
        }
        if (zzgzu.class.isAssignableFrom(cls)) {
            return zzb(zzhbbVarZzb) ? zzhbh.zzl(cls, zzhbbVarZzb, zzhbk.zzb(), zzhas.zze(), zzhca.zzn(), zzgzi.zzb(), zzhba.zzb()) : zzhbh.zzl(cls, zzhbbVarZzb, zzhbk.zzb(), zzhas.zze(), zzhca.zzn(), null, zzhba.zzb());
        }
        return zzb(zzhbbVarZzb) ? zzhbh.zzl(cls, zzhbbVarZzb, zzhbk.zza(), zzhas.zzd(), zzhca.zzm(), zzgzi.zza(), zzhba.zza()) : zzhbh.zzl(cls, zzhbbVarZzb, zzhbk.zza(), zzhas.zzd(), zzhca.zzm(), null, zzhba.zza());
    }
}
