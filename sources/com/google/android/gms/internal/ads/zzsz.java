package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzsz extends zziq {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private int zzA;
    private boolean zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private int zzI;
    private int zzJ;
    private ByteBuffer zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private long zzX;
    private long zzY;
    private boolean zzZ;
    protected zzir zza;
    private boolean zzaa;
    private boolean zzab;
    private zzsy zzac;
    private long zzad;
    private boolean zzae;
    private zzrz zzaf;
    private zzrz zzag;
    private final zzsq zzc;
    private final zztb zzd;
    private final float zze;
    private final zzih zzf;
    private final zzih zzg;
    private final zzih zzh;
    private final zzsn zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzrk zzl;
    private zzam zzm;
    private zzam zzn;
    private MediaCrypto zzo;
    private boolean zzp;
    private long zzq;
    private float zzr;
    private zzsr zzs;
    private zzam zzt;
    private MediaFormat zzu;
    private boolean zzv;
    private float zzw;
    private ArrayDeque zzx;
    private zzsx zzy;
    private zzsv zzz;

    public zzsz(int i, zzsq zzsqVar, zztb zztbVar, boolean z, float f) {
        super(i);
        this.zzc = zzsqVar;
        zztbVar.getClass();
        this.zzd = zztbVar;
        this.zze = f;
        this.zzf = new zzih(0, 0);
        this.zzg = new zzih(0, 0);
        this.zzh = new zzih(2, 0);
        zzsn zzsnVar = new zzsn();
        this.zzi = zzsnVar;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzr = 1.0f;
        this.zzq = -9223372036854775807L;
        this.zzk = new ArrayDeque();
        this.zzac = zzsy.zza;
        zzsnVar.zzi(0);
        zzsnVar.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzrk();
        this.zzw = -1.0f;
        this.zzA = 0;
        this.zzR = 0;
        this.zzI = -1;
        this.zzJ = -1;
        this.zzH = -9223372036854775807L;
        this.zzX = -9223372036854775807L;
        this.zzY = -9223372036854775807L;
        this.zzad = -9223372036854775807L;
        this.zzS = 0;
        this.zzT = 0;
        this.zza = new zzir();
    }

    protected static boolean zzaJ(zzam zzamVar) {
        return zzamVar.zzG == 0;
    }

    private final void zzaL() {
        this.zzI = -1;
        this.zzg.zzc = null;
    }

    private final void zzaM() {
        this.zzJ = -1;
        this.zzK = null;
    }

    private final void zzaN(zzsy zzsyVar) {
        this.zzac = zzsyVar;
        if (zzsyVar.zzd != -9223372036854775807L) {
            this.zzae = true;
        }
    }

    private final void zzaO() throws zziz {
        zzrz zzrzVar = this.zzag;
        zzrzVar.getClass();
        this.zzaf = zzrzVar;
        this.zzS = 0;
        this.zzT = 0;
    }

    private final boolean zzaP() throws zziz {
        if (this.zzU) {
            this.zzS = 1;
            if (this.zzC) {
                this.zzT = 3;
                return false;
            }
            this.zzT = 2;
        } else {
            zzaO();
        }
        return true;
    }

    private final boolean zzaQ() throws zziz {
        zzsr zzsrVar = this.zzs;
        if (zzsrVar == null || this.zzS == 2 || this.zzZ) {
            return false;
        }
        if (this.zzI < 0) {
            int iZza = zzsrVar.zza();
            this.zzI = iZza;
            if (iZza < 0) {
                return false;
            }
            this.zzg.zzc = zzsrVar.zzf(iZza);
            this.zzg.zzb();
        }
        if (this.zzS == 1) {
            if (!this.zzG) {
                this.zzV = true;
                zzsrVar.zzj(this.zzI, 0, 0, 0L, 4);
                zzaL();
            }
            this.zzS = 2;
            return false;
        }
        if (this.zzE) {
            this.zzE = false;
            ByteBuffer byteBuffer = this.zzg.zzc;
            byteBuffer.getClass();
            byteBuffer.put(zzb);
            zzsrVar.zzj(this.zzI, 0, 38, 0L, 0);
            zzaL();
            this.zzU = true;
            return true;
        }
        if (this.zzR == 1) {
            int i = 0;
            while (true) {
                zzam zzamVar = this.zzt;
                zzamVar.getClass();
                if (i >= zzamVar.zzo.size()) {
                    break;
                }
                byte[] bArr = (byte[]) this.zzt.zzo.get(i);
                ByteBuffer byteBuffer2 = this.zzg.zzc;
                byteBuffer2.getClass();
                byteBuffer2.put(bArr);
                i++;
            }
            this.zzR = 2;
        }
        ByteBuffer byteBuffer3 = this.zzg.zzc;
        byteBuffer3.getClass();
        int iPosition = byteBuffer3.position();
        zzlb zzlbVarZzbi = zzbi();
        try {
            int iZzbg = zzbg(zzlbVarZzbi, this.zzg, 0);
            if (iZzbg == -3) {
                if (zzP()) {
                    this.zzY = this.zzX;
                }
                return false;
            }
            if (iZzbg == -5) {
                if (this.zzR == 2) {
                    this.zzg.zzb();
                    this.zzR = 1;
                }
                zzab(zzlbVarZzbi);
                return true;
            }
            zzih zzihVar = this.zzg;
            if (zzihVar.zzf()) {
                this.zzY = this.zzX;
                if (this.zzR == 2) {
                    zzihVar.zzb();
                    this.zzR = 1;
                }
                this.zzZ = true;
                if (!this.zzU) {
                    zzaK();
                    return false;
                }
                try {
                    if (!this.zzG) {
                        this.zzV = true;
                        zzsrVar.zzj(this.zzI, 0, 0, 0L, 4);
                        zzaL();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw zzi(e, this.zzm, false, zzfy.zzi(e.getErrorCode()));
                }
            }
            if (!this.zzU && !zzihVar.zzg()) {
                zzihVar.zzb();
                if (this.zzR == 2) {
                    this.zzR = 1;
                }
                return true;
            }
            boolean zZzk = zzihVar.zzk();
            if (zZzk) {
                zzihVar.zzb.zzb(iPosition);
            }
            long j = this.zzg.zze;
            if (this.zzab) {
                if (this.zzk.isEmpty()) {
                    zzfv zzfvVar = this.zzac.zze;
                    zzam zzamVar2 = this.zzm;
                    zzamVar2.getClass();
                    zzfvVar.zzd(j, zzamVar2);
                } else {
                    zzfv zzfvVar2 = ((zzsy) this.zzk.peekLast()).zze;
                    zzam zzamVar3 = this.zzm;
                    zzamVar3.getClass();
                    zzfvVar2.zzd(j, zzamVar3);
                }
                this.zzab = false;
            }
            long jMax = Math.max(this.zzX, j);
            this.zzX = jMax;
            if (zzP() || this.zzg.zzh()) {
                this.zzY = jMax;
            }
            this.zzg.zzj();
            zzih zzihVar2 = this.zzg;
            if (zzihVar2.zze()) {
                zzah(zzihVar2);
            }
            zzaz(this.zzg);
            zzar(this.zzg);
            try {
                if (zZzk) {
                    zzsrVar.zzk(this.zzI, 0, this.zzg.zzb, j, 0);
                } else {
                    int i2 = this.zzI;
                    ByteBuffer byteBuffer4 = this.zzg.zzc;
                    byteBuffer4.getClass();
                    zzsrVar.zzj(i2, 0, byteBuffer4.limit(), j, 0);
                }
                zzaL();
                this.zzU = true;
                this.zzR = 0;
                this.zza.zzc++;
                return true;
            } catch (MediaCodec.CryptoException e2) {
                throw zzi(e2, this.zzm, false, zzfy.zzi(e2.getErrorCode()));
            }
        } catch (zzig e3) {
            zzai(e3);
            zzaT(0);
            zzag();
            return true;
        }
    }

    private final boolean zzaR() {
        return this.zzJ >= 0;
    }

    private final boolean zzaS(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzam zzamVar = this.zzn;
        if (zzamVar == null || !Objects.equals(zzamVar.zzm, "audio/opus")) {
            return true;
        }
        return !zzadq.zzf(j, j2);
    }

    private final boolean zzaT(int i) throws zziz {
        zzih zzihVar = this.zzf;
        zzlb zzlbVarZzbi = zzbi();
        zzihVar.zzb();
        int iZzbg = zzbg(zzlbVarZzbi, this.zzf, i | 4);
        if (iZzbg == -5) {
            zzab(zzlbVarZzbi);
            return true;
        }
        if (iZzbg != -4 || !this.zzf.zzf()) {
            return false;
        }
        this.zzZ = true;
        zzaK();
        return false;
    }

    private final boolean zzaU(long j) {
        if (this.zzq == -9223372036854775807L) {
            return true;
        }
        zzh();
        return SystemClock.elapsedRealtime() - j < this.zzq;
    }

    private final boolean zzaV(zzam zzamVar) throws zziz {
        if (zzfy.zza >= 23 && this.zzs != null && this.zzT != 3 && zzbf() != 0) {
            float f = this.zzr;
            zzamVar.getClass();
            float fZzY = zzY(f, zzamVar, zzS());
            float f2 = this.zzw;
            if (f2 != fZzY) {
                if (fZzY == -1.0f) {
                    zzad();
                    return false;
                }
                if (f2 != -1.0f || fZzY > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fZzY);
                    zzsr zzsrVar = this.zzs;
                    zzsrVar.getClass();
                    zzsrVar.zzp(bundle);
                    this.zzw = fZzY;
                }
            }
        }
        return true;
    }

    private final void zzac() {
        this.zzP = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzO = false;
        this.zzN = false;
        this.zzl.zzb();
    }

    private final void zzad() throws zziz {
        if (this.zzU) {
            this.zzS = 1;
            this.zzT = 3;
        } else {
            zzaB();
            zzax();
        }
    }

    private final void zzag() {
        try {
            zzsr zzsrVar = this.zzs;
            zzek.zzb(zzsrVar);
            zzsrVar.zzi();
        } finally {
            zzaC();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzam(zzsv zzsvVar, MediaCrypto mediaCrypto) throws Exception {
        zzsr zztpVar;
        zzsp zzspVar;
        int i;
        int i2;
        zzam zzamVar = this.zzm;
        zzamVar.getClass();
        String str = zzsvVar.zza;
        float fZzY = zzfy.zza < 23 ? -1.0f : zzY(this.zzr, zzamVar, zzS());
        if (fZzY <= this.zze) {
            fZzY = -1.0f;
        }
        zzaA(zzamVar);
        zzh();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        MediaCodec mediaCodec = null;
        zzsp zzspVarZzae = zzae(zzsvVar, zzamVar, null, fZzY);
        if (zzfy.zza >= 31) {
            zzsw.zza(zzspVarZzae, zzn());
        }
        try {
            Trace.beginSection("createCodec:" + str);
            if (zzfy.zza < 23 || zzfy.zza < 31) {
                try {
                    String str2 = zzspVarZzae.zza.zza;
                    Trace.beginSection("createCodec:".concat(str2));
                    MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str2);
                    Trace.endSection();
                    try {
                        Trace.beginSection("configureCodec");
                        mediaCodecCreateByCodecName.configure(zzspVarZzae.zzb, zzspVarZzae.zzd, (MediaCrypto) null, 0);
                        Trace.endSection();
                        Trace.beginSection("startCodec");
                        mediaCodecCreateByCodecName.start();
                        Trace.endSection();
                        zztpVar = new zztp(mediaCodecCreateByCodecName, null);
                    } catch (IOException | RuntimeException e) {
                        e = e;
                        mediaCodec = mediaCodecCreateByCodecName;
                        if (mediaCodec != null) {
                            mediaCodec.release();
                        }
                        throw e;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (RuntimeException e3) {
                    e = e3;
                }
            } else {
                int iZzb = zzcb.zzb(zzspVarZzae.zzc.zzm);
                zzff.zze("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzfy.zzB(iZzb)));
                zzse zzseVar = new zzse(iZzb);
                zzseVar.zzd(true);
                zztpVar = zzseVar.zzc(zzspVarZzae);
            }
            this.zzs = zztpVar;
            Trace.endSection();
            zzh();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (zzsvVar.zze(zzamVar)) {
                zzspVar = zzspVarZzae;
                i = 0;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("id=");
                sb.append(zzamVar.zzb);
                sb.append(", mimeType=");
                sb.append(zzamVar.zzm);
                if (zzamVar.zzl != null) {
                    sb.append(", container=");
                    sb.append(zzamVar.zzl);
                }
                if (zzamVar.zzi != -1) {
                    sb.append(", bitrate=");
                    sb.append(zzamVar.zzi);
                }
                if (zzamVar.zzj != null) {
                    sb.append(", codecs=");
                    sb.append(zzamVar.zzj);
                }
                if (zzamVar.zzp != null) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    int i3 = 0;
                    while (true) {
                        zzae zzaeVar = zzamVar.zzp;
                        if (i3 >= zzaeVar.zzb) {
                            break;
                        }
                        UUID uuid = zzaeVar.zza(i3).zza;
                        if (uuid.equals(zzo.zzb)) {
                            linkedHashSet.add("cenc");
                        } else if (uuid.equals(zzo.zzc)) {
                            linkedHashSet.add("clearkey");
                        } else if (uuid.equals(zzo.zze)) {
                            linkedHashSet.add("playready");
                        } else if (uuid.equals(zzo.zzd)) {
                            linkedHashSet.add("widevine");
                        } else {
                            if (uuid.equals(zzo.zza)) {
                                linkedHashSet.add("universal");
                            } else {
                                linkedHashSet.add("unknown (" + uuid.toString() + ")");
                            }
                            i3++;
                            zzspVarZzae = zzspVarZzae;
                        }
                        i3++;
                        zzspVarZzae = zzspVarZzae;
                    }
                    zzspVar = zzspVarZzae;
                    sb.append(", drm=[");
                    zzfwt.zzb(sb, linkedHashSet, ",");
                    sb.append(']');
                } else {
                    zzspVar = zzspVarZzae;
                }
                if (zzamVar.zzr != -1 && zzamVar.zzs != -1) {
                    sb.append(", res=");
                    sb.append(zzamVar.zzr);
                    sb.append("x");
                    sb.append(zzamVar.zzs);
                }
                zzt zztVar = zzamVar.zzy;
                if (zztVar != null && (zztVar.zze() || zztVar.zzf())) {
                    sb.append(", color=");
                    sb.append(zzamVar.zzy.zzd());
                }
                if (zzamVar.zzt != -1.0f) {
                    sb.append(", fps=");
                    sb.append(zzamVar.zzt);
                }
                if (zzamVar.zzz != -1) {
                    sb.append(", channels=");
                    sb.append(zzamVar.zzz);
                }
                if (zzamVar.zzA != -1) {
                    sb.append(", sample_rate=");
                    sb.append(zzamVar.zzA);
                }
                if (zzamVar.zzd != null) {
                    sb.append(", language=");
                    sb.append(zzamVar.zzd);
                }
                if (zzamVar.zzc != null) {
                    sb.append(", label=");
                    sb.append(zzamVar.zzc);
                }
                if (zzamVar.zze != 0) {
                    sb.append(", selectionFlags=[");
                    int i4 = zzamVar.zze;
                    ArrayList arrayList = new ArrayList();
                    if ((i4 & 1) != 0) {
                        arrayList.add("default");
                    }
                    if ((i4 & 2) != 0) {
                        arrayList.add("forced");
                    }
                    zzfwt.zzb(sb, arrayList, ",");
                    sb.append("]");
                }
                if (zzamVar.zzf != 0) {
                    sb.append(", roleFlags=[");
                    int i5 = zzamVar.zzf;
                    ArrayList arrayList2 = new ArrayList();
                    if ((i5 & 1) != 0) {
                        arrayList2.add("main");
                    }
                    if ((i5 & 2) != 0) {
                        arrayList2.add("alt");
                    }
                    if ((i5 & 4) != 0) {
                        arrayList2.add("supplementary");
                    }
                    if ((i5 & 8) != 0) {
                        arrayList2.add("commentary");
                    }
                    if ((i5 & 16) != 0) {
                        arrayList2.add("dub");
                    }
                    if ((i5 & 32) != 0) {
                        arrayList2.add("emergency");
                    }
                    if ((i5 & 64) != 0) {
                        arrayList2.add("caption");
                    }
                    if ((i5 & 128) != 0) {
                        arrayList2.add("subtitle");
                    }
                    if ((i5 & 256) != 0) {
                        arrayList2.add("sign");
                    }
                    if ((i5 & 512) != 0) {
                        arrayList2.add("describes-video");
                    }
                    if ((i5 & 1024) != 0) {
                        arrayList2.add("describes-music");
                    }
                    if ((i5 & 2048) != 0) {
                        arrayList2.add("enhanced-intelligibility");
                    }
                    if ((i5 & 4096) != 0) {
                        arrayList2.add("transcribes-dialog");
                    }
                    if ((i5 & 8192) != 0) {
                        arrayList2.add("easy-read");
                    }
                    if ((i5 & 16384) != 0) {
                        arrayList2.add("trick-play");
                    }
                    zzfwt.zzb(sb, arrayList2, ",");
                    sb.append("]");
                }
                i = 0;
                zzff.zzf("MediaCodecRenderer", String.format(Locale.US, "Format exceeds selected codec's capabilities [%s, %s]", sb.toString(), str));
            }
            this.zzz = zzsvVar;
            this.zzw = fZzY;
            this.zzt = zzamVar;
            if (zzfy.zza <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (zzfy.zzd.startsWith("SM-T585") || zzfy.zzd.startsWith("SM-A510") || zzfy.zzd.startsWith("SM-A520") || zzfy.zzd.startsWith("SM-J700"))) {
                i2 = 2;
            } else {
                i2 = (zzfy.zza >= 24 || !(("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(zzfy.zzb) || "flounder_lte".equals(zzfy.zzb) || "grouper".equals(zzfy.zzb) || "tilapia".equals(zzfy.zzb)))) ? i : 1;
            }
            this.zzA = i2;
            this.zzt.getClass();
            this.zzB = (zzfy.zza == 29 && "c2.android.aac.decoder".equals(str)) ? 1 : i;
            this.zzC = (zzfy.zza > 23 || !"OMX.google.vorbis.decoder".equals(str)) ? i : 1;
            this.zzD = (zzfy.zza == 21 && "OMX.google.aac.decoder".equals(str)) ? 1 : i;
            this.zzt.getClass();
            String str3 = zzsvVar.zza;
            this.zzG = ((zzfy.zza > 25 || !"OMX.rk.video_decoder.avc".equals(str3)) && (zzfy.zza > 29 || !("OMX.broadcom.video_decoder.tunnel".equals(str3) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str3) || "OMX.bcm.vdec.avc.tunnel".equals(str3) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str3) || "OMX.bcm.vdec.hevc.tunnel".equals(str3) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str3))) && !("Amazon".equals(zzfy.zzc) && "AFTS".equals(zzfy.zzd) && zzsvVar.zzf)) ? i : 1;
            this.zzs.getClass();
            if (zzbf() == 2) {
                zzh();
                this.zzH = SystemClock.elapsedRealtime() + 1000;
            }
            this.zza.zza++;
            zzaj(str, zzspVar, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected void zzB() {
        try {
            zzac();
            zzaB();
        } finally {
            this.zzag = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r5 >= r1) goto L14;
     */
    @Override // com.google.android.gms.internal.ads.zziq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzE(com.google.android.gms.internal.ads.zzam[] r13, long r14, long r16, com.google.android.gms.internal.ads.zzur r18) throws com.google.android.gms.internal.ads.zziz {
        /*
            r12 = this;
            r0 = r12
            com.google.android.gms.internal.ads.zzsy r1 = r0.zzac
            long r1 = r1.zzd
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L20
            com.google.android.gms.internal.ads.zzsy r1 = new com.google.android.gms.internal.ads.zzsy
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaN(r1)
            return
        L20:
            java.util.ArrayDeque r1 = r0.zzk
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L55
            long r1 = r0.zzX
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L38
            long r5 = r0.zzad
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L55
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 < 0) goto L55
        L38:
            com.google.android.gms.internal.ads.zzsy r1 = new com.google.android.gms.internal.ads.zzsy
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaN(r1)
            com.google.android.gms.internal.ads.zzsy r1 = r0.zzac
            long r1 = r1.zzd
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L54
            r12.zzan()
        L54:
            return
        L55:
            java.util.ArrayDeque r1 = r0.zzk
            com.google.android.gms.internal.ads.zzsy r9 = new com.google.android.gms.internal.ads.zzsy
            long r3 = r0.zzX
            r2 = r9
            r5 = r14
            r7 = r16
            r2.<init>(r3, r5, r7)
            r1.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsz.zzE(com.google.android.gms.internal.ads.zzam[], long, long, com.google.android.gms.internal.ads.zzur):void");
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmf
    public void zzL(float f, float f2) throws zziz {
        this.zzr = f2;
        zzaV(this.zzt);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 10731. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.google.android.gms.internal.ads.zzmf
    public void zzU(long r24, long r26) throws com.google.android.gms.internal.ads.zziz {
        /*
            Method dump skipped, instruction units count: 1073
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsz.zzU(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public boolean zzV() {
        return this.zzaa;
    }

    @Override // com.google.android.gms.internal.ads.zzmf
    public boolean zzW() {
        if (this.zzm == null) {
            return false;
        }
        if (zzR() || zzaR()) {
            return true;
        }
        if (this.zzH == -9223372036854775807L) {
            return false;
        }
        zzh();
        return SystemClock.elapsedRealtime() < this.zzH;
    }

    @Override // com.google.android.gms.internal.ads.zzmh
    public final int zzX(zzam zzamVar) throws zziz {
        try {
            return zzZ(this.zzd, zzamVar);
        } catch (zzth e) {
            throw zzi(e, zzamVar, false, 4002);
        }
    }

    protected float zzY(float f, zzam zzamVar, zzam[] zzamVarArr) {
        throw null;
    }

    protected abstract int zzZ(zztb zztbVar, zzam zzamVar) throws zzth;

    protected void zzaA(zzam zzamVar) throws zziz {
    }

    protected final void zzaB() {
        try {
            zzsr zzsrVar = this.zzs;
            if (zzsrVar != null) {
                zzsrVar.zzl();
                this.zza.zzb++;
                zzsv zzsvVar = this.zzz;
                zzsvVar.getClass();
                zzak(zzsvVar.zza);
            }
        } finally {
            this.zzs = null;
            this.zzo = null;
            this.zzaf = null;
            zzaD();
        }
    }

    protected void zzaC() {
        zzaL();
        zzaM();
        this.zzH = -9223372036854775807L;
        this.zzV = false;
        this.zzU = false;
        this.zzE = false;
        this.zzF = false;
        this.zzL = false;
        this.zzM = false;
        this.zzX = -9223372036854775807L;
        this.zzY = -9223372036854775807L;
        this.zzad = -9223372036854775807L;
        this.zzS = 0;
        this.zzT = 0;
        this.zzR = this.zzQ ? 1 : 0;
    }

    protected final void zzaD() {
        zzaC();
        this.zzx = null;
        this.zzz = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = false;
        this.zzW = false;
        this.zzw = -1.0f;
        this.zzA = 0;
        this.zzB = false;
        this.zzC = false;
        this.zzD = false;
        this.zzG = false;
        this.zzQ = false;
        this.zzR = 0;
        this.zzp = false;
    }

    protected final boolean zzaE() throws zziz {
        boolean zZzaF = zzaF();
        if (zZzaF) {
            zzax();
        }
        return zZzaF;
    }

    protected final boolean zzaF() {
        if (this.zzs == null) {
            return false;
        }
        int i = this.zzT;
        if (i == 3 || ((this.zzB && !this.zzW) || (this.zzC && this.zzV))) {
            zzaB();
            return true;
        }
        if (i == 2) {
            zzek.zzf(zzfy.zza >= 23);
            if (zzfy.zza >= 23) {
                try {
                    zzaO();
                } catch (zziz e) {
                    zzff.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    zzaB();
                    return true;
                }
            }
        }
        zzag();
        return false;
    }

    protected final boolean zzaG() {
        return this.zzN;
    }

    protected final boolean zzaH(zzam zzamVar) {
        return this.zzag == null && zzaq(zzamVar);
    }

    protected boolean zzaI(zzsv zzsvVar) {
        return true;
    }

    protected zzis zzaa(zzsv zzsvVar, zzam zzamVar, zzam zzamVar2) {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x009d  */
    protected zzis zzab(zzlb zzlbVar) throws zziz {
        int i;
        boolean z = true;
        this.zzab = true;
        zzam zzamVar = zzlbVar.zza;
        zzamVar.getClass();
        if (zzamVar.zzm == null) {
            throw zzi(new IllegalArgumentException("Sample MIME type is null."), zzamVar, false, 4005);
        }
        this.zzag = zzlbVar.zzb;
        this.zzm = zzamVar;
        if (this.zzN) {
            this.zzP = true;
            return null;
        }
        zzsr zzsrVar = this.zzs;
        if (zzsrVar == null) {
            this.zzx = null;
            zzax();
            return null;
        }
        zzsv zzsvVar = this.zzz;
        zzsvVar.getClass();
        zzam zzamVar2 = this.zzt;
        zzamVar2.getClass();
        zzrz zzrzVar = this.zzaf;
        zzrz zzrzVar2 = this.zzag;
        if (zzrzVar != zzrzVar2) {
            zzad();
            return new zzis(zzsvVar.zza, zzamVar2, zzamVar, 0, 128);
        }
        boolean z2 = zzrzVar2 != zzrzVar;
        zzek.zzf(!z2 || zzfy.zza >= 23);
        zzis zzisVarZzaa = zzaa(zzsvVar, zzamVar2, zzamVar);
        int i2 = zzisVarZzaa.zzd;
        if (i2 != 0) {
            i = 2;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (zzaV(zzamVar)) {
                        this.zzt = zzamVar;
                        if (!z2 || zzaP()) {
                        }
                    } else {
                        i = 16;
                    }
                } else if (zzaV(zzamVar)) {
                    this.zzQ = true;
                    this.zzR = 1;
                    int i3 = this.zzA;
                    if (i3 != 2 && (i3 != 1 || zzamVar.zzr != zzamVar2.zzr || zzamVar.zzs != zzamVar2.zzs)) {
                        z = false;
                    }
                    this.zzE = z;
                    this.zzt = zzamVar;
                    if (!z2 || zzaP()) {
                    }
                } else {
                    i = 16;
                }
            } else if (zzaV(zzamVar)) {
                this.zzt = zzamVar;
                if (z2) {
                    if (zzaP()) {
                    }
                } else if (this.zzU) {
                    this.zzS = 1;
                    if (this.zzC) {
                        this.zzT = 3;
                    } else {
                        this.zzT = 1;
                    }
                }
            } else {
                i = 16;
            }
            return (zzisVarZzaa.zzd != 0 || (this.zzs == zzsrVar && this.zzT != 3)) ? zzisVarZzaa : new zzis(zzsvVar.zza, zzamVar2, zzamVar, 0, i);
        }
        zzad();
        i = 0;
        if (zzisVarZzaa.zzd != 0) {
        }
    }

    protected abstract zzsp zzae(zzsv zzsvVar, zzam zzamVar, MediaCrypto mediaCrypto, float f);

    protected abstract List zzaf(zztb zztbVar, zzam zzamVar, boolean z) throws zzth;

    protected void zzah(zzih zzihVar) throws zziz {
        throw null;
    }

    protected void zzai(Exception exc) {
        throw null;
    }

    protected void zzaj(String str, zzsp zzspVar, long j, long j2) {
        throw null;
    }

    protected void zzak(String str) {
        throw null;
    }

    protected void zzal(zzam zzamVar, MediaFormat mediaFormat) throws zziz {
        throw null;
    }

    protected void zzan() {
    }

    protected void zzao() throws zziz {
    }

    protected abstract boolean zzap(long j, long j2, zzsr zzsrVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzam zzamVar) throws zziz;

    protected boolean zzaq(zzam zzamVar) {
        return false;
    }

    protected int zzar(zzih zzihVar) {
        return 0;
    }

    protected final long zzas() {
        return this.zzac.zzd;
    }

    protected final long zzat() {
        return this.zzac.zzc;
    }

    protected final zzsr zzau() {
        return this.zzs;
    }

    protected zzst zzav(Throwable th, zzsv zzsvVar) {
        return new zzst(th, zzsvVar);
    }

    protected final zzsv zzaw() {
        return this.zzz;
    }

    protected final void zzax() throws zziz {
        zzam zzamVar;
        if (this.zzs != null || this.zzN || (zzamVar = this.zzm) == null) {
            return;
        }
        if (zzaH(zzamVar)) {
            zzam zzamVar2 = this.zzm;
            zzac();
            String str = zzamVar2.zzm;
            if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
                this.zzi.zzn(32);
            } else {
                this.zzi.zzn(1);
            }
            this.zzN = true;
            return;
        }
        zzrz zzrzVar = this.zzag;
        this.zzaf = zzrzVar;
        if (zzrzVar != null) {
            zzek.zzf(true);
            zzrz zzrzVar2 = this.zzaf;
            this.zzm.getClass();
            boolean z = zzsa.zza;
            zzrzVar2.zza();
        }
        try {
            zzam zzamVar3 = this.zzm;
            zzamVar3.getClass();
            if (this.zzx == null) {
                try {
                    List listZzaf = zzaf(this.zzd, zzamVar3, false);
                    listZzaf.isEmpty();
                    this.zzx = new ArrayDeque();
                    if (!listZzaf.isEmpty()) {
                        this.zzx.add((zzsv) listZzaf.get(0));
                    }
                    this.zzy = null;
                } catch (zzth e) {
                    throw new zzsx(zzamVar3, (Throwable) e, false, -49998);
                }
            }
            if (this.zzx.isEmpty()) {
                throw new zzsx(zzamVar3, (Throwable) null, false, -49999);
            }
            ArrayDeque arrayDeque = this.zzx;
            arrayDeque.getClass();
            zzsv zzsvVar = (zzsv) arrayDeque.peekFirst();
            while (this.zzs == null) {
                zzsv zzsvVar2 = (zzsv) arrayDeque.peekFirst();
                zzsvVar2.getClass();
                if (!zzaI(zzsvVar2)) {
                    return;
                }
                try {
                    zzam(zzsvVar2, null);
                } catch (Exception e2) {
                    if (zzsvVar2 != zzsvVar) {
                        throw e2;
                    }
                    try {
                        zzff.zzf("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                        Thread.sleep(50L);
                        zzam(zzsvVar2, null);
                    } catch (Exception e3) {
                        zzff.zzg("MediaCodecRenderer", "Failed to initialize decoder: ".concat(zzsvVar2.zza), e3);
                        arrayDeque.removeFirst();
                        zzsx zzsxVar = new zzsx(zzamVar3, (Throwable) e3, false, zzsvVar2);
                        zzai(zzsxVar);
                        zzsx zzsxVar2 = this.zzy;
                        if (zzsxVar2 == null) {
                            this.zzy = zzsxVar;
                        } else {
                            this.zzy = zzsx.zza(zzsxVar2, zzsxVar);
                        }
                        if (arrayDeque.isEmpty()) {
                            throw this.zzy;
                        }
                    }
                }
            }
            this.zzx = null;
        } catch (zzsx e4) {
            throw zzi(e4, this.zzm, false, 4001);
        }
    }

    protected void zzay(long j) {
        this.zzad = j;
        while (!this.zzk.isEmpty() && j >= ((zzsy) this.zzk.peek()).zzb) {
            zzsy zzsyVar = (zzsy) this.zzk.poll();
            zzsyVar.getClass();
            zzaN(zzsyVar);
            zzan();
        }
    }

    protected void zzaz(zzih zzihVar) throws zziz {
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmh
    public final int zze() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected void zzw() {
        this.zzm = null;
        zzaN(zzsy.zza);
        this.zzk.clear();
        zzaF();
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected void zzx(boolean z, boolean z2) throws zziz {
        this.zza = new zzir();
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected void zzz(long j, boolean z) throws zziz {
        this.zzZ = false;
        this.zzaa = false;
        if (this.zzN) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzO = false;
            this.zzl.zzb();
        } else {
            zzaE();
        }
        zzfv zzfvVar = this.zzac.zze;
        if (zzfvVar.zza() > 0) {
            this.zzab = true;
        }
        zzfvVar.zze();
        this.zzk.clear();
    }

    private final void zzaK() throws zziz {
        int i = this.zzT;
        if (i == 1) {
            zzag();
            return;
        }
        if (i == 2) {
            zzag();
            zzaO();
        } else if (i != 3) {
            this.zzaa = true;
            zzao();
        } else {
            zzaB();
            zzax();
        }
    }
}
