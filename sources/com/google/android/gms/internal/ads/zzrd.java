package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzrd implements zzqb {
    private static final Object zza = new Object();
    private static ExecutorService zzb;
    private static int zzc;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private int zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private float zzI;
    private ByteBuffer zzJ;
    private int zzK;
    private ByteBuffer zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private int zzP;
    private zzl zzQ;
    private zzqp zzR;
    private long zzS;
    private boolean zzT;
    private boolean zzU;
    private long zzV;
    private long zzW;
    private Handler zzX;
    private final zzqt zzY;
    private final zzqj zzZ;
    private final zzqg zzd;
    private final zzrn zze;
    private final zzgaa zzf;
    private final zzgaa zzg;
    private final zzeo zzh;
    private final zzqf zzi;
    private final ArrayDeque zzj;
    private zzrb zzk;
    private final zzqw zzl;
    private final zzqw zzm;
    private final zzqq zzn;
    private zzpb zzo;
    private zzpy zzp;
    private zzqs zzq;
    private zzqs zzr;
    private zzdq zzs;
    private AudioTrack zzt;
    private zzpd zzu;
    private zzk zzv = zzk.zza;
    private zzqv zzw;
    private zzqv zzx;
    private zzcg zzy;
    private boolean zzz;

    /* synthetic */ zzrd(zzqr zzqrVar, zzrc zzrcVar) {
        this.zzu = zzqrVar.zza;
        this.zzY = zzqrVar.zzd;
        int i = zzfy.zza;
        this.zzn = zzqrVar.zzc;
        zzqj zzqjVar = zzqrVar.zze;
        zzqjVar.getClass();
        this.zzZ = zzqjVar;
        zzeo zzeoVar = new zzeo(zzel.zza);
        this.zzh = zzeoVar;
        zzeoVar.zze();
        this.zzi = new zzqf(new zzqy(this, null));
        zzqg zzqgVar = new zzqg();
        this.zzd = zzqgVar;
        zzrn zzrnVar = new zzrn();
        this.zze = zzrnVar;
        this.zzf = zzgaa.zzo(new zzdx(), zzqgVar, zzrnVar);
        this.zzg = zzgaa.zzm(new zzrm());
        this.zzI = 1.0f;
        this.zzP = 0;
        this.zzQ = new zzl(0, 0.0f);
        this.zzx = new zzqv(zzcg.zza, 0L, 0L, null);
        this.zzy = zzcg.zza;
        this.zzz = false;
        this.zzj = new ArrayDeque();
        this.zzl = new zzqw(100L);
        this.zzm = new zzqw(100L);
    }

    public static /* synthetic */ void zzF(zzrd zzrdVar) {
        if (zzrdVar.zzW >= 1000000) {
            ((zzri) zzrdVar.zzp).zza.zzn = true;
        }
        zzrdVar.zzW = 0L;
    }

    static /* synthetic */ void zzG(AudioTrack audioTrack, final zzpy zzpyVar, Handler handler, final zzpv zzpvVar, zzeo zzeoVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzpyVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzql
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((zzri) zzpyVar).zza.zzc.zzd(zzpvVar);
                    }
                });
            }
            zzeoVar.zze();
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            if (zzpyVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzql
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((zzri) zzpyVar).zza.zzc.zzd(zzpvVar);
                    }
                });
            }
            zzeoVar.zze();
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzI() {
        zzqs zzqsVar = this.zzr;
        return zzqsVar.zzc == 0 ? this.zzA / ((long) zzqsVar.zzb) : this.zzB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzJ() {
        zzqs zzqsVar = this.zzr;
        if (zzqsVar.zzc != 0) {
            return this.zzD;
        }
        long j = this.zzC;
        long j2 = zzqsVar.zzd;
        int i = zzfy.zza;
        return ((j + j2) - 1) / j2;
    }

    private final AudioTrack zzK(zzqs zzqsVar) throws zzpx {
        try {
            return zzqsVar.zza(this.zzv, this.zzP);
        } catch (zzpx e) {
            zzpy zzpyVar = this.zzp;
            if (zzpyVar != null) {
                zzpyVar.zza(e);
            }
            throw e;
        }
    }

    private final void zzL(long j) {
        zzcg zzcgVar;
        boolean z;
        if (zzW()) {
            zzqt zzqtVar = this.zzY;
            zzcgVar = this.zzy;
            zzqtVar.zzc(zzcgVar);
        } else {
            zzcgVar = zzcg.zza;
        }
        zzcg zzcgVar2 = zzcgVar;
        this.zzy = zzcgVar2;
        if (zzW()) {
            zzqt zzqtVar2 = this.zzY;
            z = this.zzz;
            zzqtVar2.zzd(z);
        } else {
            z = false;
        }
        this.zzz = z;
        this.zzj.add(new zzqv(zzcgVar2, Math.max(0L, j), zzfy.zzr(zzJ(), this.zzr.zze), null));
        zzR();
        zzpy zzpyVar = this.zzp;
        if (zzpyVar != null) {
            ((zzri) zzpyVar).zza.zzc.zzw(this.zzz);
        }
    }

    private final void zzM() {
        if (this.zzr.zzc()) {
            this.zzT = true;
        }
    }

    private final void zzN() {
        if (this.zzN) {
            return;
        }
        this.zzN = true;
        this.zzi.zzb(zzJ());
        this.zzt.stop();
    }

    private final void zzO(long j) throws Exception {
        ByteBuffer byteBufferZzb;
        if (!this.zzs.zzh()) {
            ByteBuffer byteBuffer = this.zzJ;
            if (byteBuffer == null) {
                byteBuffer = zzdt.zza;
            }
            zzS(byteBuffer, j);
            return;
        }
        while (!this.zzs.zzg()) {
            do {
                byteBufferZzb = this.zzs.zzb();
                if (byteBufferZzb.hasRemaining()) {
                    zzS(byteBufferZzb, j);
                } else {
                    ByteBuffer byteBuffer2 = this.zzJ;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzs.zze(this.zzJ);
                    }
                }
            } while (!byteBufferZzb.hasRemaining());
            return;
        }
    }

    private final void zzP(zzcg zzcgVar) {
        zzqv zzqvVar = new zzqv(zzcgVar, -9223372036854775807L, -9223372036854775807L, null);
        if (zzU()) {
            this.zzw = zzqvVar;
        } else {
            this.zzx = zzqvVar;
        }
    }

    private final void zzQ() {
        if (zzU()) {
            int i = zzfy.zza;
            this.zzt.setVolume(this.zzI);
        }
    }

    private final void zzR() {
        zzdq zzdqVar = this.zzr.zzi;
        this.zzs = zzdqVar;
        zzdqVar.zzc();
    }

    private final void zzS(ByteBuffer byteBuffer, long j) throws Exception {
        zzpy zzpyVar;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.zzL;
            boolean z = false;
            if (byteBuffer2 != null) {
                zzek.zzd(byteBuffer2 == byteBuffer);
            } else {
                this.zzL = byteBuffer;
                int i = zzfy.zza;
            }
            int iRemaining = byteBuffer.remaining();
            int i2 = zzfy.zza;
            int iWrite = this.zzt.write(byteBuffer, iRemaining, 1);
            this.zzS = SystemClock.elapsedRealtime();
            if (iWrite < 0) {
                if ((zzfy.zza >= 24 && iWrite == -6) || iWrite == -32) {
                    if (zzJ() > 0) {
                        z = true;
                    } else if (zzV(this.zzt)) {
                        zzM();
                        z = true;
                    }
                }
                zzqa zzqaVar = new zzqa(iWrite, this.zzr.zza, z);
                zzpy zzpyVar2 = this.zzp;
                if (zzpyVar2 != null) {
                    zzpyVar2.zza(zzqaVar);
                }
                if (zzqaVar.zzb) {
                    this.zzu = zzpd.zza;
                    throw zzqaVar;
                }
                this.zzm.zzb(zzqaVar);
                return;
            }
            this.zzm.zza();
            if (zzV(this.zzt)) {
                if (this.zzD > 0) {
                    this.zzU = false;
                }
                if (this.zzO && (zzpyVar = this.zzp) != null && iWrite < iRemaining) {
                    zzrj zzrjVar = ((zzri) zzpyVar).zza;
                    if (zzrjVar.zzm != null) {
                        zzrjVar.zzm.zza();
                    }
                }
            }
            int i3 = this.zzr.zzc;
            if (i3 == 0) {
                this.zzC += (long) iWrite;
            }
            if (iWrite == iRemaining) {
                if (i3 != 0) {
                    zzek.zzf(byteBuffer == this.zzJ);
                    this.zzD += ((long) this.zzE) * ((long) this.zzK);
                }
                this.zzL = null;
            }
        }
    }

    private final boolean zzT() throws Exception {
        if (!this.zzs.zzh()) {
            ByteBuffer byteBuffer = this.zzL;
            if (byteBuffer == null) {
                return true;
            }
            zzS(byteBuffer, Long.MIN_VALUE);
            return this.zzL == null;
        }
        this.zzs.zzd();
        zzO(Long.MIN_VALUE);
        if (!this.zzs.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.zzL;
        return byteBuffer2 == null || !byteBuffer2.hasRemaining();
    }

    private final boolean zzU() {
        return this.zzt != null;
    }

    private static boolean zzV(AudioTrack audioTrack) {
        return zzfy.zza >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final boolean zzW() {
        zzqs zzqsVar = this.zzr;
        if (zzqsVar.zzc != 0) {
            return false;
        }
        int i = zzqsVar.zza.zzB;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final int zza(zzam zzamVar) {
        if (!"audio/raw".equals(zzamVar.zzm)) {
            return this.zzu.zza(zzamVar, this.zzv) != null ? 2 : 0;
        }
        if (zzfy.zzH(zzamVar.zzB)) {
            return zzamVar.zzB != 2 ? 1 : 2;
        }
        zzff.zzf("DefaultAudioSink", "Invalid PCM encoding: " + zzamVar.zzB);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final long zzb(boolean z) {
        long jZzo;
        if (!zzU() || this.zzG) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.zzi.zza(z), zzfy.zzr(zzJ(), this.zzr.zze));
        while (!this.zzj.isEmpty() && jMin >= ((zzqv) this.zzj.getFirst()).zzc) {
            this.zzx = (zzqv) this.zzj.remove();
        }
        zzqv zzqvVar = this.zzx;
        long j = jMin - zzqvVar.zzc;
        if (zzqvVar.zza.equals(zzcg.zza)) {
            jZzo = this.zzx.zzb + j;
        } else if (this.zzj.isEmpty()) {
            jZzo = this.zzY.zza(j) + this.zzx.zzb;
        } else {
            zzqv zzqvVar2 = (zzqv) this.zzj.getFirst();
            jZzo = zzqvVar2.zzb - zzfy.zzo(zzqvVar2.zzc - jMin, this.zzx.zza.zzc);
        }
        long jZzb = this.zzY.zzb();
        long jZzr = jZzo + zzfy.zzr(jZzb, this.zzr.zze);
        long j2 = this.zzV;
        if (jZzb > j2) {
            long jZzr2 = zzfy.zzr(jZzb - j2, this.zzr.zze);
            this.zzV = jZzb;
            this.zzW += jZzr2;
            if (this.zzX == null) {
                this.zzX = new Handler(Looper.myLooper());
            }
            this.zzX.removeCallbacksAndMessages(null);
            this.zzX.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqm
                @Override // java.lang.Runnable
                public final void run() {
                    zzrd.zzF(this.zza);
                }
            }, 100L);
        }
        return jZzr;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final zzcg zzc() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final zzpg zzd(zzam zzamVar) {
        return this.zzT ? zzpg.zza : this.zzZ.zza(zzamVar, this.zzv);
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zze(zzam zzamVar, int i, int[] iArr) throws zzpw {
        int iIntValue;
        zzdq zzdqVar;
        int iZzl;
        int iIntValue2;
        int iZzl2;
        int i2;
        int i3;
        int iMax;
        if ("audio/raw".equals(zzamVar.zzm)) {
            zzek.zzd(zzfy.zzH(zzamVar.zzB));
            iZzl = zzfy.zzl(zzamVar.zzB, zzamVar.zzz);
            zzfzx zzfzxVar = new zzfzx();
            int i4 = zzamVar.zzB;
            zzfzxVar.zzh(this.zzf);
            zzfzxVar.zzg(this.zzY.zze());
            zzdq zzdqVar2 = new zzdq(zzfzxVar.zzi());
            if (zzdqVar2.equals(this.zzs)) {
                zzdqVar2 = this.zzs;
            }
            this.zze.zzq(zzamVar.zzC, zzamVar.zzD);
            this.zzd.zzo(iArr);
            try {
                zzdr zzdrVarZza = zzdqVar2.zza(new zzdr(zzamVar.zzA, zzamVar.zzz, zzamVar.zzB));
                iIntValue = zzdrVarZza.zzd;
                i2 = zzdrVarZza.zzb;
                int i5 = zzdrVarZza.zzc;
                iIntValue2 = zzfy.zzg(i5);
                zzdqVar = zzdqVar2;
                iZzl2 = zzfy.zzl(iIntValue, i5);
                i3 = 0;
            } catch (zzds e) {
                throw new zzpw(e, zzamVar);
            }
        } else {
            zzdq zzdqVar3 = new zzdq(zzgaa.zzl());
            int i6 = zzamVar.zzA;
            zzpg zzpgVar = zzpg.zza;
            Pair pairZza = this.zzu.zza(zzamVar, this.zzv);
            if (pairZza == null) {
                throw new zzpw("Unable to configure passthrough for: ".concat(String.valueOf(String.valueOf(zzamVar))), zzamVar);
            }
            iIntValue = ((Integer) pairZza.first).intValue();
            zzdqVar = zzdqVar3;
            iZzl = -1;
            iIntValue2 = ((Integer) pairZza.second).intValue();
            iZzl2 = -1;
            i2 = i6;
            i3 = 2;
        }
        if (iIntValue == 0) {
            throw new zzpw("Invalid output encoding (mode=" + i3 + ") for: " + String.valueOf(zzamVar), zzamVar);
        }
        if (iIntValue2 == 0) {
            throw new zzpw("Invalid output channel config (mode=" + i3 + ") for: " + String.valueOf(zzamVar), zzamVar);
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i2, iIntValue2, iIntValue);
        zzek.zzf(minBufferSize != -2);
        int i7 = iZzl2 != -1 ? iZzl2 : 1;
        int i8 = zzamVar.zzi;
        int i9 = 250000;
        if (i3 == 0) {
            iMax = Math.max(zzrf.zza(250000, i2, i7), Math.min(minBufferSize * 4, zzrf.zza(750000, i2, i7)));
        } else if (i3 != 1) {
            if (iIntValue == 5) {
                i9 = 500000;
            } else if (iIntValue == 8) {
                i9 = DurationKt.NANOS_IN_MILLIS;
                iIntValue = 8;
            }
            iMax = zzgcu.zza((((long) i9) * ((long) (i8 != -1 ? zzgco.zza(i8, 8, RoundingMode.CEILING) : zzrf.zzb(iIntValue)))) / 1000000);
        } else {
            iMax = zzgcu.zza((((long) zzrf.zzb(iIntValue)) * 50000000) / 1000000);
        }
        int iMax2 = (((Math.max(minBufferSize, iMax) + i7) - 1) / i7) * i7;
        this.zzT = false;
        zzqs zzqsVar = new zzqs(zzamVar, iZzl, i3, iZzl2, i2, iIntValue2, iIntValue, iMax2, zzdqVar, false, false, false);
        if (zzU()) {
            this.zzq = zzqsVar;
        } else {
            this.zzr = zzqsVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzf() {
        if (zzU()) {
            this.zzA = 0L;
            this.zzB = 0L;
            this.zzC = 0L;
            this.zzD = 0L;
            this.zzU = false;
            this.zzE = 0;
            this.zzx = new zzqv(this.zzy, 0L, 0L, null);
            this.zzH = 0L;
            this.zzw = null;
            this.zzj.clear();
            this.zzJ = null;
            this.zzK = 0;
            this.zzL = null;
            this.zzN = false;
            this.zzM = false;
            this.zze.zzp();
            zzR();
            if (this.zzi.zzh()) {
                this.zzt.pause();
            }
            if (zzV(this.zzt)) {
                zzrb zzrbVar = this.zzk;
                zzrbVar.getClass();
                zzrbVar.zzb(this.zzt);
            }
            int i = zzfy.zza;
            final zzpv zzpvVarZzb = this.zzr.zzb();
            zzqs zzqsVar = this.zzq;
            if (zzqsVar != null) {
                this.zzr = zzqsVar;
                this.zzq = null;
            }
            this.zzi.zzc();
            final AudioTrack audioTrack = this.zzt;
            final zzeo zzeoVar = this.zzh;
            final zzpy zzpyVar = this.zzp;
            zzeoVar.zzc();
            final Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzfy.zzD("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqk
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzrd.zzG(audioTrack, zzpyVar, handler, zzpvVarZzb, zzeoVar);
                    }
                });
            }
            this.zzt = null;
        }
        this.zzm.zza();
        this.zzl.zza();
        this.zzV = 0L;
        this.zzW = 0L;
        Handler handler2 = this.zzX;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzg() {
        this.zzF = true;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzh() {
        this.zzO = false;
        if (zzU()) {
            if (this.zzi.zzk() || zzV(this.zzt)) {
                this.zzt.pause();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzi() {
        this.zzO = true;
        if (zzU()) {
            this.zzi.zzf();
            this.zzt.play();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzj() throws zzqa {
        if (!this.zzM && zzU() && zzT()) {
            zzN();
            this.zzM = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzk() {
        zzf();
        zzgaa zzgaaVar = this.zzf;
        int size = zzgaaVar.size();
        for (int i = 0; i < size; i++) {
            ((zzdt) zzgaaVar.get(i)).zzf();
        }
        zzgaa zzgaaVar2 = this.zzg;
        int size2 = zzgaaVar2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((zzdt) zzgaaVar2.get(i2)).zzf();
        }
        zzdq zzdqVar = this.zzs;
        if (zzdqVar != null) {
            zzdqVar.zzf();
        }
        this.zzO = false;
        this.zzT = false;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzl(zzk zzkVar) {
        if (this.zzv.equals(zzkVar)) {
            return;
        }
        this.zzv = zzkVar;
        zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzm(int i) {
        if (this.zzP != i) {
            this.zzP = i;
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzn(zzl zzlVar) {
        if (this.zzQ.equals(zzlVar)) {
            return;
        }
        if (this.zzt != null) {
            int i = this.zzQ.zza;
        }
        this.zzQ = zzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzo(zzel zzelVar) {
        this.zzi.zze(zzelVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzp(zzpy zzpyVar) {
        this.zzp = zzpyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzq(int i, int i2) {
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzV(audioTrack);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzr(zzcg zzcgVar) {
        this.zzy = new zzcg(Math.max(0.1f, Math.min(zzcgVar.zzc, 8.0f)), Math.max(0.1f, Math.min(zzcgVar.zzd, 8.0f)));
        zzP(zzcgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzs(zzpb zzpbVar) {
        this.zzo = zzpbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzu(boolean z) {
        this.zzz = z;
        zzP(this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzv(float f) {
        if (this.zzI != f) {
            this.zzI = f;
            zzQ();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:117:0x0233  */
    /* JADX WARN: Code duplicated, block: B:148:0x02e1 A[RETURN] */
    @Override // com.google.android.gms.internal.ads.zzqb
    public final boolean zzw(ByteBuffer byteBuffer, long j, int i) throws Exception {
        AudioTrack audioTrackZzK;
        zzpb zzpbVar;
        boolean z;
        int iZza;
        int i2;
        int i3;
        int i4;
        byte b;
        int i5;
        int i6;
        ByteBuffer byteBuffer2 = this.zzJ;
        zzek.zzd(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.zzq != null) {
            if (!zzT()) {
                return false;
            }
            zzqs zzqsVar = this.zzq;
            zzqs zzqsVar2 = this.zzr;
            if (zzqsVar2.zzc == zzqsVar.zzc && zzqsVar2.zzg == zzqsVar.zzg && zzqsVar2.zze == zzqsVar.zze && zzqsVar2.zzf == zzqsVar.zzf && zzqsVar2.zzd == zzqsVar.zzd) {
                boolean z2 = zzqsVar2.zzj;
                boolean z3 = zzqsVar.zzj;
                boolean z4 = zzqsVar2.zzk;
                boolean z5 = zzqsVar.zzk;
                this.zzr = zzqsVar;
                this.zzq = null;
                AudioTrack audioTrack = this.zzt;
                if (audioTrack != null && zzV(audioTrack)) {
                    boolean z6 = this.zzr.zzk;
                }
            } else {
                zzN();
                if (zzx()) {
                    return false;
                }
                zzf();
            }
            zzL(j);
        }
        if (!zzU()) {
            try {
                if (!this.zzh.zzd()) {
                    return false;
                }
                try {
                    zzqs zzqsVar3 = this.zzr;
                    zzqsVar3.getClass();
                    audioTrackZzK = zzK(zzqsVar3);
                } catch (zzpx e) {
                    zzqs zzqsVar4 = this.zzr;
                    if (zzqsVar4.zzh > 1000000) {
                        zzam zzamVar = zzqsVar4.zza;
                        int i7 = zzqsVar4.zzb;
                        int i8 = zzqsVar4.zzc;
                        int i9 = zzqsVar4.zzd;
                        int i10 = zzqsVar4.zze;
                        int i11 = zzqsVar4.zzf;
                        int i12 = zzqsVar4.zzg;
                        zzdq zzdqVar = zzqsVar4.zzi;
                        boolean z7 = zzqsVar4.zzj;
                        boolean z8 = zzqsVar4.zzk;
                        boolean z9 = zzqsVar4.zzl;
                        zzqs zzqsVar5 = new zzqs(zzamVar, i7, i8, i9, i10, i11, i12, DurationKt.NANOS_IN_MILLIS, zzdqVar, false, false, false);
                        try {
                            audioTrackZzK = zzK(zzqsVar5);
                            this.zzr = zzqsVar5;
                        } catch (zzpx e2) {
                            e.addSuppressed(e2);
                            zzM();
                            throw e;
                        }
                    }
                    zzM();
                    throw e;
                }
                this.zzt = audioTrackZzK;
                if (zzV(audioTrackZzK)) {
                    AudioTrack audioTrack2 = this.zzt;
                    if (this.zzk == null) {
                        this.zzk = new zzrb(this);
                    }
                    this.zzk.zza(audioTrack2);
                    boolean z10 = this.zzr.zzk;
                }
                if (zzfy.zza >= 31 && (zzpbVar = this.zzo) != null) {
                    zzqo.zza(this.zzt, zzpbVar);
                }
                this.zzP = this.zzt.getAudioSessionId();
                zzqf zzqfVar = this.zzi;
                AudioTrack audioTrack3 = this.zzt;
                zzqs zzqsVar6 = this.zzr;
                zzqfVar.zzd(audioTrack3, zzqsVar6.zzc == 2, zzqsVar6.zzg, zzqsVar6.zzd, zzqsVar6.zzh);
                zzQ();
                int i13 = this.zzQ.zza;
                zzqp zzqpVar = this.zzR;
                if (zzqpVar != null && zzfy.zza >= 23) {
                    zzqn.zza(this.zzt, zzqpVar);
                }
                this.zzG = true;
                zzpy zzpyVar = this.zzp;
                if (zzpyVar != null) {
                    ((zzri) zzpyVar).zza.zzc.zzc(this.zzr.zzb());
                }
            } catch (zzpx e3) {
                if (e3.zzb) {
                    throw e3;
                }
                this.zzl.zzb(e3);
                return false;
            }
        }
        this.zzl.zza();
        if (this.zzG) {
            this.zzH = Math.max(0L, j);
            this.zzF = false;
            this.zzG = false;
            zzL(j);
            if (this.zzO) {
                zzi();
            }
        }
        if (!this.zzi.zzj(zzJ())) {
            return false;
        }
        if (this.zzJ == null) {
            zzek.zzd(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            zzqs zzqsVar7 = this.zzr;
            if (zzqsVar7.zzc != 0 && this.zzE == 0) {
                int i14 = zzqsVar7.zzg;
                switch (i14) {
                    case 5:
                    case 6:
                    case 18:
                        z = true;
                        iZza = zzabv.zza(byteBuffer);
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 7:
                    case 8:
                        int i15 = zzacr.zza;
                        if (byteBuffer.getInt(0) != -233094848) {
                            if (byteBuffer.getInt(0) == -398277519) {
                                iZza = 1024;
                            } else if (byteBuffer.getInt(0) == 622876772) {
                                iZza = 4096;
                            } else {
                                int iPosition = byteBuffer.position();
                                byte b2 = byteBuffer.get(iPosition);
                                if (b2 != -2) {
                                    if (b2 != -1) {
                                        if (b2 != 31) {
                                            i4 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                            i5 = byteBuffer.get(iPosition + 5) & 252;
                                            i3 = 2;
                                        } else {
                                            i3 = 2;
                                            i4 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                            b = byteBuffer.get(iPosition + 6);
                                        }
                                        i2 = (i5 >> i3) | i4;
                                        z = true;
                                    } else {
                                        i3 = 2;
                                        i4 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                        b = byteBuffer.get(iPosition + 7);
                                    }
                                    i5 = b & 60;
                                    i2 = (i5 >> i3) | i4;
                                    z = true;
                                } else {
                                    z = true;
                                    i2 = ((byteBuffer.get(iPosition + 5) & 1) << 6) | ((byteBuffer.get(iPosition + 4) & 252) >> 2);
                                }
                                iZza = (i2 + (z ? 1 : 0)) * 32;
                            }
                            z = true;
                        } else {
                            z = true;
                            iZza = 1024;
                        }
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 9:
                        iZza = zzadp.zzc(zzfy.zzh(byteBuffer, byteBuffer.position()));
                        if (iZza == -1) {
                            throw new IllegalArgumentException();
                        }
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 10:
                    case 16:
                        iZza = 1024;
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 11:
                    case 12:
                        iZza = 2048;
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 13:
                    case 19:
                    default:
                        throw new IllegalStateException("Unexpected audio encoding: " + i14);
                    case 14:
                        int i16 = zzabv.zza;
                        int iPosition2 = byteBuffer.position();
                        int iLimit = byteBuffer.limit() - 10;
                        int i17 = iPosition2;
                        while (true) {
                            if (i17 > iLimit) {
                                i6 = -1;
                            } else if ((zzfy.zzh(byteBuffer, i17 + 4) & (-2)) == -126718022) {
                                i6 = i17 - iPosition2;
                            } else {
                                i17++;
                            }
                        }
                        if (i6 == -1) {
                            iZza = 0;
                        } else {
                            iZza = (40 << ((byteBuffer.get((byteBuffer.position() + i6) + ((byteBuffer.get((byteBuffer.position() + i6) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                        }
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 15:
                        iZza = 512;
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 17:
                        int i18 = zzaby.zza;
                        byte[] bArr = new byte[16];
                        int iPosition3 = byteBuffer.position();
                        byteBuffer.get(bArr);
                        byteBuffer.position(iPosition3);
                        iZza = zzaby.zza(new zzfo(bArr, 16)).zzc;
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                    case 20:
                        iZza = zzadq.zzb(byteBuffer);
                        z = true;
                        this.zzE = iZza;
                        if (iZza == 0) {
                            return z;
                        }
                        break;
                }
            }
            if (this.zzw != null) {
                if (!zzT()) {
                    return false;
                }
                zzL(j);
                this.zzw = null;
            }
            long jZzr = this.zzH + zzfy.zzr(zzI() - this.zze.zzo(), this.zzr.zza.zzA);
            if (!this.zzF && Math.abs(jZzr - j) > 200000) {
                zzpy zzpyVar2 = this.zzp;
                if (zzpyVar2 != null) {
                    zzpyVar2.zza(new zzpz(j, jZzr));
                }
                this.zzF = true;
            }
            if (this.zzF) {
                if (!zzT()) {
                    return false;
                }
                long j2 = j - jZzr;
                this.zzH += j2;
                this.zzF = false;
                zzL(j);
                zzpy zzpyVar3 = this.zzp;
                if (zzpyVar3 != null && j2 != 0) {
                    ((zzri) zzpyVar3).zza.zzam();
                }
            }
            if (this.zzr.zzc == 0) {
                this.zzA += (long) byteBuffer.remaining();
            } else {
                this.zzB += ((long) this.zzE) * ((long) i);
            }
            this.zzJ = byteBuffer;
            this.zzK = i;
        }
        zzO(j);
        if (!this.zzJ.hasRemaining()) {
            this.zzJ = null;
            this.zzK = 0;
            return true;
        }
        if (!this.zzi.zzi(zzJ())) {
            return false;
        }
        zzff.zzf("DefaultAudioSink", "Resetting stalled audio track");
        zzf();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final boolean zzx() {
        return zzU() && this.zzi.zzg(zzJ());
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final boolean zzy() {
        if (zzU()) {
            return this.zzM && !zzx();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final boolean zzz(zzam zzamVar) {
        return zza(zzamVar) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqb
    public final void zzt(AudioDeviceInfo audioDeviceInfo) {
        zzqp zzqpVar = audioDeviceInfo == null ? null : new zzqp(audioDeviceInfo);
        this.zzR = zzqpVar;
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzqn.zza(audioTrack, zzqpVar);
        }
    }
}
