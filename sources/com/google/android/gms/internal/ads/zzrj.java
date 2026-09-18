package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzrj extends zzsz implements zzlh {
    private final Context zzb;
    private final zzpt zzc;
    private final zzqb zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private zzam zzh;
    private zzam zzi;
    private long zzj;
    private boolean zzk;
    private boolean zzl;
    private zzme zzm;
    private boolean zzn;

    public zzrj(Context context, zzsq zzsqVar, zztb zztbVar, boolean z, Handler handler, zzpu zzpuVar, zzqb zzqbVar) {
        super(1, zzsqVar, zztbVar, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzqbVar;
        this.zzc = new zzpt(handler, zzpuVar);
        zzqbVar.zzp(new zzri(this, null));
    }

    private final int zzaK(zzsv zzsvVar, zzam zzamVar) {
        if (!"OMX.google.raw.decoder".equals(zzsvVar.zza) || zzfy.zza >= 24 || (zzfy.zza == 23 && zzfy.zzJ(this.zzb))) {
            return zzamVar.zzn;
        }
        return -1;
    }

    private static List zzaL(zztb zztbVar, zzam zzamVar, boolean z, zzqb zzqbVar) throws zzth {
        zzsv zzsvVarZzb;
        if (zzamVar.zzm == null) {
            return zzgaa.zzl();
        }
        return (!zzqbVar.zzz(zzamVar) || (zzsvVarZzb = zztn.zzb()) == null) ? zztn.zzf(zztbVar, zzamVar, false, false) : zzgaa.zzm(zzsvVarZzb);
    }

    private final void zzaM() {
        long jZzb = this.zzd.zzb(zzV());
        if (jZzb != Long.MIN_VALUE) {
            if (!this.zzk) {
                jZzb = Math.max(this.zzj, jZzb);
            }
            this.zzj = jZzb;
            this.zzk = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected final void zzA() {
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    protected final void zzB() {
        this.zzn = false;
        try {
            super.zzB();
            if (this.zzl) {
            }
        } finally {
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzk();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected final void zzC() {
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected final void zzD() {
        zzaM();
        this.zzd.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzmf, com.google.android.gms.internal.ads.zzmh
    public final String zzT() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final boolean zzV() {
        return super.zzV() && this.zzd.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final boolean zzW() {
        return this.zzd.zzx() || super.zzW();
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final float zzY(float f, zzam zzamVar, zzam[] zzamVarArr) {
        int iMax = -1;
        for (zzam zzamVar2 : zzamVarArr) {
            int i = zzamVar2.zzA;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final int zzZ(zztb zztbVar, zzam zzamVar) throws zzth {
        int i;
        boolean z;
        if (!zzcb.zzg(zzamVar.zzm)) {
            return 128;
        }
        int i2 = zzfy.zza;
        int i3 = zzamVar.zzG;
        boolean zZzaJ = zzaJ(zzamVar);
        int i4 = 1;
        if (!zZzaJ || (i3 != 0 && zztn.zzb() == null)) {
            i = 0;
        } else {
            zzpg zzpgVarZzd = this.zzd.zzd(zzamVar);
            if (zzpgVarZzd.zzb) {
                i = true != zzpgVarZzd.zzc ? 512 : 1536;
                if (zzpgVarZzd.zzd) {
                    i |= 2048;
                }
            } else {
                i = 0;
            }
            if (this.zzd.zzz(zzamVar)) {
                return i | 172;
            }
        }
        if ((!"audio/raw".equals(zzamVar.zzm) || this.zzd.zzz(zzamVar)) && this.zzd.zzz(zzfy.zzy(2, zzamVar.zzz, zzamVar.zzA))) {
            List listZzaL = zzaL(zztbVar, zzamVar, false, this.zzd);
            if (!listZzaL.isEmpty()) {
                if (zZzaJ) {
                    zzsv zzsvVar = (zzsv) listZzaL.get(0);
                    boolean zZze = zzsvVar.zze(zzamVar);
                    if (!zZze) {
                        int i5 = 1;
                        while (true) {
                            if (i5 >= listZzaL.size()) {
                                z = true;
                                break;
                            }
                            zzsv zzsvVar2 = (zzsv) listZzaL.get(i5);
                            if (zzsvVar2.zze(zzamVar)) {
                                z = false;
                                zZze = true;
                                zzsvVar = zzsvVar2;
                                break;
                            }
                            i5++;
                        }
                    } else {
                        z = true;
                        break;
                    }
                    int i6 = true != zZze ? 3 : 4;
                    int i7 = 8;
                    if (zZze && zzsvVar.zzf(zzamVar)) {
                        i7 = 16;
                    }
                    return i6 | i7 | 32 | (true != zzsvVar.zzg ? 0 : 64) | (true != z ? 0 : 128) | i;
                }
                i4 = 2;
            }
        }
        return i4 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final long zza() {
        if (zzbf() == 2) {
            zzaM();
        }
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final zzis zzaa(zzsv zzsvVar, zzam zzamVar, zzam zzamVar2) {
        int i;
        int i2;
        zzis zzisVarZzb = zzsvVar.zzb(zzamVar, zzamVar2);
        int i3 = zzisVarZzb.zze;
        if (zzaH(zzamVar2)) {
            i3 |= 32768;
        }
        if (zzaK(zzsvVar, zzamVar2) > this.zze) {
            i3 |= 64;
        }
        String str = zzsvVar.zza;
        if (i3 != 0) {
            i2 = i3;
            i = 0;
        } else {
            i = zzisVarZzb.zzd;
            i2 = 0;
        }
        return new zzis(str, zzamVar, zzamVar2, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final zzsp zzae(zzsv zzsvVar, zzam zzamVar, MediaCrypto mediaCrypto, float f) {
        zzam[] zzamVarArrZzS = zzS();
        int length = zzamVarArrZzS.length;
        int iZzaK = zzaK(zzsvVar, zzamVar);
        if (length != 1) {
            for (zzam zzamVar2 : zzamVarArrZzS) {
                if (zzsvVar.zzb(zzamVar, zzamVar2).zzd != 0) {
                    iZzaK = Math.max(iZzaK, zzaK(zzsvVar, zzamVar2));
                }
            }
        }
        this.zze = iZzaK;
        this.zzf = zzfy.zza < 24 && "OMX.SEC.aac.dec".equals(zzsvVar.zza) && "samsung".equals(zzfy.zzc) && (zzfy.zzb.startsWith("zeroflte") || zzfy.zzb.startsWith("herolte") || zzfy.zzb.startsWith("heroqlte"));
        String str = zzsvVar.zza;
        this.zzg = str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
        String str2 = zzsvVar.zzc;
        int i = this.zze;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str2);
        mediaFormat.setInteger("channel-count", zzamVar.zzz);
        mediaFormat.setInteger("sample-rate", zzamVar.zzA);
        zzfi.zzb(mediaFormat, zzamVar.zzo);
        zzfi.zza(mediaFormat, "max-input-size", i);
        if (zzfy.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && (zzfy.zza != 23 || (!"ZTE B2017G".equals(zzfy.zzd) && !"AXON 7 mini".equals(zzfy.zzd)))) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (zzfy.zza <= 28 && "audio/ac4".equals(zzamVar.zzm)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (zzfy.zza >= 24 && this.zzd.zza(zzfy.zzy(4, zzamVar.zzz, zzamVar.zzA)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (zzfy.zza >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        this.zzi = (!"audio/raw".equals(zzsvVar.zzb) || "audio/raw".equals(zzamVar.zzm)) ? null : zzamVar;
        return zzsp.zza(zzsvVar, mediaFormat, zzamVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final List zzaf(zztb zztbVar, zzam zzamVar, boolean z) throws zzth {
        return zztn.zzg(zzaL(zztbVar, zzamVar, false, this.zzd), zzamVar);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzah(zzih zzihVar) {
        zzam zzamVar;
        if (zzfy.zza < 29 || (zzamVar = zzihVar.zza) == null || !Objects.equals(zzamVar.zzm, "audio/opus") || !zzaG()) {
            return;
        }
        ByteBuffer byteBuffer = zzihVar.zzf;
        byteBuffer.getClass();
        zzam zzamVar2 = zzihVar.zza;
        zzamVar2.getClass();
        if (byteBuffer.remaining() == 8) {
            this.zzd.zzq(zzamVar2.zzC, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzai(Exception exc) {
        zzff.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzaj(String str, zzsp zzspVar, long j, long j2) {
        this.zzc.zze(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzak(String str) {
        this.zzc.zzf(str);
    }

    protected final void zzam() {
        this.zzk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzan() {
        this.zzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzao() throws zziz {
        try {
            this.zzd.zzj();
        } catch (zzqa e) {
            throw zzi(e, e.zzc, e.zzb, true != zzaG() ? 5002 : 5003);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final boolean zzaq(zzam zzamVar) {
        zzm();
        return this.zzd.zzz(zzamVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final zzcg zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzg(zzcg zzcgVar) {
        this.zzd.zzr(zzcgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final boolean zzj() {
        boolean z = this.zzn;
        this.zzn = false;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmf
    public final zzlh zzk() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzma
    public final void zzt(int i, Object obj) throws zziz {
        if (i == 2) {
            zzqb zzqbVar = this.zzd;
            obj.getClass();
            zzqbVar.zzv(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            zzk zzkVar = (zzk) obj;
            zzqb zzqbVar2 = this.zzd;
            zzkVar.getClass();
            zzqbVar2.zzl(zzkVar);
            return;
        }
        if (i == 6) {
            zzl zzlVar = (zzl) obj;
            zzqb zzqbVar3 = this.zzd;
            zzlVar.getClass();
            zzqbVar3.zzn(zzlVar);
            return;
        }
        switch (i) {
            case 9:
                zzqb zzqbVar4 = this.zzd;
                obj.getClass();
                zzqbVar4.zzu(((Boolean) obj).booleanValue());
                break;
            case 10:
                zzqb zzqbVar5 = this.zzd;
                obj.getClass();
                zzqbVar5.zzm(((Integer) obj).intValue());
                break;
            case 11:
                this.zzm = (zzme) obj;
                break;
            case 12:
                if (zzfy.zza >= 23) {
                    zzrg.zza(this.zzd, obj);
                }
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    protected final void zzw() {
        this.zzl = true;
        this.zzh = null;
        try {
            this.zzd.zzf();
            super.zzw();
        } catch (Throwable th) {
            super.zzw();
            throw th;
        } finally {
            this.zzc.zzg(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    protected final void zzx(boolean z, boolean z2) throws zziz {
        super.zzx(z, z2);
        this.zzc.zzh(this.zza);
        zzm();
        this.zzd.zzs(zzn());
        this.zzd.zzo(zzh());
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    protected final void zzz(long j, boolean z) throws zziz {
        super.zzz(j, z);
        this.zzd.zzf();
        this.zzj = j;
        this.zzn = false;
        this.zzk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final zzis zzab(zzlb zzlbVar) throws zziz {
        zzam zzamVar = zzlbVar.zza;
        zzamVar.getClass();
        this.zzh = zzamVar;
        zzis zzisVarZzab = super.zzab(zzlbVar);
        this.zzc.zzi(zzamVar, zzisVarZzab);
        return zzisVarZzab;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final boolean zzap(long j, long j2, zzsr zzsrVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzam zzamVar) throws zziz {
        byteBuffer.getClass();
        if (this.zzi != null && (i2 & 2) != 0) {
            zzsrVar.getClass();
            zzsrVar.zzn(i, false);
            return true;
        }
        if (z) {
            if (zzsrVar != null) {
                zzsrVar.zzn(i, false);
            }
            this.zza.zzf += i3;
            this.zzd.zzg();
            return true;
        }
        try {
            if (!this.zzd.zzw(byteBuffer, j3, i3)) {
                return false;
            }
            if (zzsrVar != null) {
                zzsrVar.zzn(i, false);
            }
            this.zza.zze += i3;
            return true;
        } catch (zzpx e) {
            throw zzi(e, this.zzh, e.zzb, 5001);
        } catch (zzqa e2) {
            if (zzaG()) {
                zzm();
            }
            throw zzi(e2, zzamVar, e2.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzal(zzam zzamVar, MediaFormat mediaFormat) throws zziz {
        int iZzk;
        int[] iArr;
        int i;
        zzam zzamVar2 = this.zzi;
        int[] iArr2 = null;
        boolean z = true;
        if (zzamVar2 != null) {
            zzamVar = zzamVar2;
        } else if (zzau() != null) {
            mediaFormat.getClass();
            if ("audio/raw".equals(zzamVar.zzm)) {
                iZzk = zzamVar.zzB;
            } else if (zzfy.zza < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                iZzk = mediaFormat.containsKey("v-bits-per-sample") ? zzfy.zzk(mediaFormat.getInteger("v-bits-per-sample")) : 2;
            } else {
                iZzk = mediaFormat.getInteger("pcm-encoding");
            }
            zzak zzakVar = new zzak();
            zzakVar.zzW("audio/raw");
            zzakVar.zzQ(iZzk);
            zzakVar.zzF(zzamVar.zzC);
            zzakVar.zzG(zzamVar.zzD);
            zzakVar.zzP(zzamVar.zzk);
            zzakVar.zzK(zzamVar.zzb);
            zzakVar.zzM(zzamVar.zzc);
            zzakVar.zzN(zzamVar.zzd);
            zzakVar.zzY(zzamVar.zze);
            zzakVar.zzU(zzamVar.zzf);
            zzakVar.zzy(mediaFormat.getInteger("channel-count"));
            zzakVar.zzX(mediaFormat.getInteger("sample-rate"));
            zzam zzamVarZzac = zzakVar.zzac();
            if (this.zzf && zzamVarZzac.zzz == 6 && (i = zzamVar.zzz) < 6) {
                iArr2 = new int[i];
                for (int i2 = 0; i2 < zzamVar.zzz; i2++) {
                    iArr2[i2] = i2;
                }
            } else if (this.zzg) {
                int i3 = zzamVarZzac.zzz;
                if (i3 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i3 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i3 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i3 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i3 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
                iArr2 = iArr;
            }
            zzamVar = zzamVarZzac;
        }
        try {
            if (zzfy.zza >= 29) {
                if (zzaG()) {
                    zzm();
                }
                if (zzfy.zza < 29) {
                    z = false;
                }
                zzek.zzf(z);
            }
            this.zzd.zze(zzamVar, 0, iArr2);
        } catch (zzpw e) {
            throw zzi(e, e.zza, false, 5001);
        }
    }
}
