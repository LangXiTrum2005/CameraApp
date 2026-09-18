package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcix extends zzcgc implements zzhy, zzms {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcii zzc;
    private final zzyg zzd;
    private final zzcgk zze;
    private final WeakReference zzf;
    private final zzvw zzg;
    private zzjj zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcgb zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzcik zzt;
    private final Object zzq = new Object();
    private final Set zzu = new HashSet();

    /* JADX WARN: Code duplicated, block: B:21:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:23:0x00e9  */
    public zzcix(Context context, zzcgk zzcgkVar, zzcgl zzcglVar, Integer num) {
        final boolean z;
        final zzgv zzgvVar;
        this.zzb = context;
        this.zze = zzcgkVar;
        this.zzr = num;
        this.zzf = new WeakReference(zzcglVar);
        zzcii zzciiVar = new zzcii();
        this.zzc = zzciiVar;
        zzyg zzygVar = new zzyg(context);
        this.zzd = zzygVar;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter initialize ".concat(toString()));
        }
        zzD().incrementAndGet();
        zzmk zzmkVar = new zzmk(context, new zzciu(this));
        zzmkVar.zzb(zzygVar);
        zzmkVar.zza(zzciiVar);
        zzml zzmlVarZzc = zzmkVar.zzc();
        this.zzh = zzmlVarZzc;
        zzmlVarZzc.zzz(this);
        this.zzl = 0;
        this.zzn = 0L;
        this.zzm = 0;
        this.zzs = new ArrayList();
        this.zzt = null;
        this.zzo = (String) zzfwz.zzd(zzcglVar != null ? zzcglVar.zzr() : null).zzb("");
        this.zzp = zzcglVar != null ? zzcglVar.zzf() : 0;
        final String strZzc = com.google.android.gms.ads.internal.zzt.zzp().zzc(context, zzcglVar.zzn().zza);
        if (!this.zzj || this.zzi.limit() <= 0) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbY)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue()) {
                    z = zzcgkVar.zzj ? false : true;
                }
            } else if (zzcgkVar.zzj) {
            }
            final zzgv zzgvVar2 = zzcgkVar.zzm ? new zzgv() { // from class: com.google.android.gms.internal.ads.zzcio
                @Override // com.google.android.gms.internal.ads.zzgv
                public final zzgw zza() {
                    return this.zza.zzW(strZzc, z);
                }
            } : zzcgkVar.zzi > 0 ? new zzgv() { // from class: com.google.android.gms.internal.ads.zzcip
                @Override // com.google.android.gms.internal.ads.zzgv
                public final zzgw zza() {
                    return this.zza.zzX(strZzc, z);
                }
            } : new zzgv() { // from class: com.google.android.gms.internal.ads.zzciq
                @Override // com.google.android.gms.internal.ads.zzgv
                public final zzgw zza() {
                    return this.zza.zzY(strZzc, z);
                }
            };
            zzgvVar = zzcgkVar.zzj ? new zzgv() { // from class: com.google.android.gms.internal.ads.zzcir
                @Override // com.google.android.gms.internal.ads.zzgv
                public final zzgw zza() {
                    return this.zza.zzZ(zzgvVar2);
                }
            } : zzgvVar2;
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && byteBuffer.limit() > 0) {
                final byte[] bArr = new byte[this.zzi.limit()];
                this.zzi.get(bArr);
                zzgvVar = new zzgv() { // from class: com.google.android.gms.internal.ads.zzcis
                    @Override // com.google.android.gms.internal.ads.zzgv
                    public final zzgw zza() {
                        int i = zzcix.zza;
                        zzgw zzgwVarZza = zzgvVar.zza();
                        byte[] bArr2 = bArr;
                        return new zzcil(new zzgr(bArr2), bArr2.length, zzgwVarZza);
                    }
                };
            }
        } else {
            final byte[] bArr2 = new byte[this.zzi.limit()];
            this.zzi.get(bArr2);
            zzgvVar = new zzgv() { // from class: com.google.android.gms.internal.ads.zzcim
                @Override // com.google.android.gms.internal.ads.zzgv
                public final zzgw zza() {
                    return new zzgr(bArr2);
                }
            };
        }
        this.zzg = new zzvw(zzgvVar, new zzvv(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzo)).booleanValue() ? new zzadb() { // from class: com.google.android.gms.internal.ads.zzciw
            @Override // com.google.android.gms.internal.ads.zzadb
            public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
                int i = zzada.zza;
                int i2 = zzcix.zza;
                return new zzacu[]{new zzajh(), new zzahy(0), new zzajc()};
            }
        } : new zzadb() { // from class: com.google.android.gms.internal.ads.zzcin
            @Override // com.google.android.gms.internal.ads.zzadb
            public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
                int i = zzada.zza;
                int i2 = zzcix.zza;
                return new zzacu[]{new zzajh(), new zzahy(0)};
            }
        }));
    }

    private final boolean zzad() {
        return this.zzt != null && this.zzt.zzq();
    }

    public final void finalize() {
        zzD().decrementAndGet();
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final long zzA() {
        if (zzad()) {
            return 0L;
        }
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final long zzB() {
        if (zzad()) {
            return this.zzt.zzl();
        }
        synchronized (this.zzq) {
            while (!this.zzs.isEmpty()) {
                long j = this.zzn;
                Map mapZze = ((zzht) this.zzs.remove(0)).zze();
                long j2 = 0;
                if (mapZze != null) {
                    for (Map.Entry entry : mapZze.entrySet()) {
                        if (entry != null) {
                            try {
                                if (entry.getKey() != null && zzfwk.zzc("content-length", (CharSequence) entry.getKey()) && entry.getValue() != null && ((List) entry.getValue()).get(0) != null) {
                                    j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException unused) {
                                continue;
                            }
                        }
                    }
                }
                this.zzn = j + j2;
            }
        }
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final Integer zzC() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzH() {
        zzjj zzjjVar = this.zzh;
        if (zzjjVar != null) {
            zzjjVar.zzA(this);
            this.zzh.zzq();
            this.zzh = null;
            zzE().decrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzI(long j) {
        zzm zzmVar = (zzm) this.zzh;
        zzmVar.zza(zzmVar.zzd(), j, 5, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzJ(int i) {
        this.zzc.zzk(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzK(int i) {
        this.zzc.zzl(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzL(zzcgb zzcgbVar) {
        this.zzk = zzcgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzM(int i) {
        this.zzc.zzm(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzN(int i) {
        this.zzc.zzn(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzO(boolean z) {
        this.zzh.zzr(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzP(Integer num) {
        this.zzr = num;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzQ(boolean z) {
        if (this.zzh == null) {
            return;
        }
        int i = 0;
        while (true) {
            this.zzh.zzy();
            if (i >= 2) {
                return;
            }
            zzyg zzygVar = this.zzd;
            zzxs zzxsVarZzc = zzygVar.zze().zzc();
            zzxsVarZzc.zzp(i, !z);
            zzygVar.zzl(zzxsVarZzc);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzR(int i) {
        Iterator it = this.zzu.iterator();
        while (it.hasNext()) {
            zzcih zzcihVar = (zzcih) ((WeakReference) it.next()).get();
            if (zzcihVar != null) {
                zzcihVar.zzm(i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzS(Surface surface, boolean z) {
        zzjj zzjjVar = this.zzh;
        if (zzjjVar != null) {
            zzjjVar.zzs(surface);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzT(float f, boolean z) {
        zzjj zzjjVar = this.zzh;
        if (zzjjVar != null) {
            zzjjVar.zzt(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzU() {
        this.zzh.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final boolean zzV() {
        return this.zzh != null;
    }

    final /* synthetic */ zzgw zzW(String str, boolean z) {
        zzcix zzcixVar = true != z ? null : this;
        zzcgk zzcgkVar = this.zze;
        return new zzcja(str, zzcixVar, zzcgkVar.zzd, zzcgkVar.zzf, zzcgkVar.zzn, zzcgkVar.zzo);
    }

    final /* synthetic */ zzgw zzX(String str, boolean z) {
        zzcix zzcixVar = true != z ? null : this;
        zzcgk zzcgkVar = this.zze;
        zzcih zzcihVar = new zzcih(str, zzcixVar, zzcgkVar.zzd, zzcgkVar.zzf, zzcgkVar.zzi);
        this.zzu.add(new WeakReference(zzcihVar));
        return zzcihVar;
    }

    final /* synthetic */ zzgw zzY(String str, boolean z) {
        zzhe zzheVar = new zzhe();
        zzheVar.zzf(str);
        zzheVar.zze(true != z ? null : this);
        zzheVar.zzc(this.zze.zzd);
        zzheVar.zzd(this.zze.zzf);
        zzheVar.zzb(true);
        return zzheVar.zza();
    }

    final /* synthetic */ zzgw zzZ(zzgv zzgvVar) {
        zzgw zzgwVarZza = zzgvVar.zza();
        zzciv zzcivVar = new zzciv(this);
        return new zzcik(this.zzb, zzgwVarZza, this.zzo, this.zzp, this, zzcivVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zza(zzgw zzgwVar, zzhb zzhbVar, boolean z, int i) {
        this.zzl += i;
    }

    final zzut zzaa(Uri uri) {
        zzar zzarVar = new zzar();
        zzarVar.zzb(uri);
        zzbp zzbpVarZzc = zzarVar.zzc();
        zzvw zzvwVar = this.zzg;
        zzvwVar.zza(this.zze.zzg);
        return zzvwVar.zzb(zzbpVarZzc);
    }

    final /* synthetic */ void zzab(boolean z, long j) {
        zzcgb zzcgbVar = this.zzk;
        if (zzcgbVar != null) {
            zzcgbVar.zzi(z, j);
        }
    }

    final /* synthetic */ zzmf[] zzac(Handler handler, zzabk zzabkVar, zzpu zzpuVar, zzwv zzwvVar, zztr zztrVar) {
        zztb zztbVar = zztb.zzb;
        zzpd zzpdVar = zzpd.zza;
        zzdt[] zzdtVarArr = new zzdt[0];
        zzqr zzqrVar = new zzqr();
        zzpd zzpdVar2 = zzpd.zza;
        if (zzpdVar == null) {
            if (zzpdVar2 == null) {
                throw new NullPointerException("Both parameters are null");
            }
            zzpdVar = zzpdVar2;
        }
        Context context = this.zzb;
        zzqrVar.zzc(zzpdVar);
        zzqrVar.zzd(zzdtVarArr);
        return new zzmf[]{new zzrj(context, zzsq.zza, zztbVar, false, handler, zzpuVar, zzqrVar.zze()), new zzaah(this.zzb, zzsq.zza, zztb.zzb, 0L, false, handler, zzabkVar, -1, 30.0f)};
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzb(zzgw zzgwVar, zzhb zzhbVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzc(zzgw zzgwVar, zzhb zzhbVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzd(zzgw zzgwVar, zzhb zzhbVar, boolean z) {
        if (zzgwVar instanceof zzht) {
            synchronized (this.zzq) {
                this.zzs.add((zzht) zzgwVar);
            }
        } else if (zzgwVar instanceof zzcik) {
            this.zzt = (zzcik) zzgwVar;
            final zzcgl zzcglVar = (zzcgl) this.zzf.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue() && zzcglVar != null && this.zzt.zzn()) {
                final HashMap map = new HashMap();
                map.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                map.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcit
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = zzcix.zza;
                        zzcglVar.zzd("onGcacheInfoEvent", map);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zze(zzmq zzmqVar, zzam zzamVar, zzis zzisVar) {
        zzcgl zzcglVar = (zzcgl) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue() || zzcglVar == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = zzamVar.zzl;
        if (str != null) {
            map.put("audioMime", str);
        }
        String str2 = zzamVar.zzm;
        if (str2 != null) {
            map.put("audioSampleMime", str2);
        }
        String str3 = zzamVar.zzj;
        if (str3 != null) {
            map.put("audioCodec", str3);
        }
        zzcglVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final /* synthetic */ void zzf(zzmq zzmqVar, int i, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final /* synthetic */ void zzg(zzmq zzmqVar, zzun zzunVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzh(zzmq zzmqVar, int i, long j) {
        this.zzm += i;
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final /* synthetic */ void zzi(zzco zzcoVar, zzmr zzmrVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzj(zzmq zzmqVar, zzui zzuiVar, zzun zzunVar, IOException iOException, boolean z) {
        zzcgb zzcgbVar = this.zzk;
        if (zzcgbVar != null) {
            if (this.zze.zzk) {
                zzcgbVar.zzl("onLoadException", iOException);
            } else {
                zzcgbVar.zzk("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzk(zzmq zzmqVar, int i) {
        zzcgb zzcgbVar = this.zzk;
        if (zzcgbVar != null) {
            zzcgbVar.zzm(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzl(zzmq zzmqVar, zzce zzceVar) {
        zzcgb zzcgbVar = this.zzk;
        if (zzcgbVar != null) {
            zzcgbVar.zzk("onPlayerError", zzceVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final /* synthetic */ void zzm(zzmq zzmqVar, zzcn zzcnVar, zzcn zzcnVar2, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzn(zzmq zzmqVar, Object obj, long j) {
        zzcgb zzcgbVar = this.zzk;
        if (zzcgbVar != null) {
            zzcgbVar.zzv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final /* synthetic */ void zzo(zzmq zzmqVar, zzir zzirVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzp(zzmq zzmqVar, zzam zzamVar, zzis zzisVar) {
        zzcgl zzcglVar = (zzcgl) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue() || zzcglVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("frameRate", String.valueOf(zzamVar.zzt));
        map.put("bitRate", String.valueOf(zzamVar.zzi));
        map.put("resolution", zzamVar.zzr + "x" + zzamVar.zzs);
        String str = zzamVar.zzl;
        if (str != null) {
            map.put("videoMime", str);
        }
        String str2 = zzamVar.zzm;
        if (str2 != null) {
            map.put("videoSampleMime", str2);
        }
        String str3 = zzamVar.zzj;
        if (str3 != null) {
            map.put("videoCodec", str3);
        }
        zzcglVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzq(zzmq zzmqVar, zzdp zzdpVar) {
        zzcgb zzcgbVar = this.zzk;
        if (zzcgbVar != null) {
            zzcgbVar.zzD(zzdpVar.zzc, zzdpVar.zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final int zzr() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final int zzt() {
        return this.zzh.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final long zzv() {
        return this.zzh.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final long zzw() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final long zzx() {
        if (zzad() && this.zzt.zzp()) {
            return Math.min(this.zzl, this.zzt.zzk());
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final long zzy() {
        return this.zzh.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final long zzz() {
        return this.zzh.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzut zzvhVar;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z;
            int length = uriArr.length;
            if (length == 1) {
                zzvhVar = zzaa(uriArr[0]);
            } else {
                zzut[] zzutVarArr = new zzut[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzutVarArr[i] = zzaa(uriArr[i]);
                }
                zzvhVar = new zzvh(false, false, zzutVarArr);
            }
            this.zzh.zzB(zzvhVar);
            this.zzh.zzp();
            zzE().incrementAndGet();
        }
    }
}
