package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.work.WorkRequest;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzqf {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private zzel zzI;
    private final zzqe zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private zzqd zze;
    private int zzf;
    private boolean zzg;
    private long zzh;
    private float zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private Method zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzqf(zzqe zzqeVar) {
        this.zza = zzqeVar;
        int i = zzfy.zza;
        try {
            this.zzm = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
        this.zzI = zzel.zza;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0099  */
    private final long zzl() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i = 2;
        if (this.zzx != -9223372036854775807L) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2) {
                return this.zzz;
            }
            return Math.min(this.zzA, this.zzz + zzfy.zzn(zzfy.zzo(zzfy.zzq(jElapsedRealtime) - this.zzx, this.zzi), this.zzf));
        }
        if (jElapsedRealtime - this.zzr >= 5) {
            AudioTrack audioTrack2 = this.zzc;
            audioTrack2.getClass();
            int playState = audioTrack2.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack2.getPlaybackHeadPosition()) & 4294967295L;
                long j = 0;
                if (this.zzg) {
                    if (playState != 2) {
                        i = playState;
                    } else if (playbackHeadPosition == 0) {
                        this.zzu = this.zzs;
                    }
                    playbackHeadPosition += this.zzu;
                    playState = i;
                }
                if (zzfy.zza > 29) {
                    if (this.zzs > playbackHeadPosition) {
                        this.zzt++;
                    }
                    this.zzs = playbackHeadPosition;
                } else {
                    if (playbackHeadPosition != 0) {
                        j = playbackHeadPosition;
                    } else if (this.zzs > 0 && playState == 3) {
                        if (this.zzy == -9223372036854775807L) {
                            this.zzy = jElapsedRealtime;
                        }
                    }
                    this.zzy = -9223372036854775807L;
                    playbackHeadPosition = j;
                    if (this.zzs > playbackHeadPosition) {
                        this.zzt++;
                    }
                    this.zzs = playbackHeadPosition;
                }
            }
            this.zzr = jElapsedRealtime;
        }
        return this.zzs + this.zzH + (this.zzt << 32);
    }

    private final long zzm() {
        return zzfy.zzr(zzl(), this.zzf);
    }

    private final void zzn() {
        this.zzk = 0L;
        this.zzw = 0;
        this.zzv = 0;
        this.zzl = 0L;
        this.zzC = 0L;
        this.zzF = 0L;
        this.zzj = false;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0063  */
    /* JADX WARN: Code duplicated, block: B:20:0x0073  */
    /* JADX WARN: Code duplicated, block: B:21:0x0076  */
    /* JADX WARN: Code duplicated, block: B:23:0x008e  */
    /* JADX WARN: Code duplicated, block: B:24:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:27:0x012f  */
    /* JADX WARN: Code duplicated, block: B:39:0x016f A[Catch: Exception -> 0x0188, TRY_LEAVE, TryCatch #0 {Exception -> 0x0188, blocks: (B:35:0x0146, B:37:0x014b, B:39:0x016f), top: B:67:0x0146 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x008e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x00ea, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x016f, please report this as an issue */
    public final long zza(boolean z) {
        long jZzm;
        zzqd zzqdVar;
        long jZzb;
        long jZza;
        long jZzm2;
        String str;
        Method method;
        long jMax;
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            long jNanoTime = System.nanoTime() / 1000;
            if (jNanoTime - this.zzl >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                long jZzm3 = zzm();
                if (jZzm3 != 0) {
                    this.zzb[this.zzv] = zzfy.zzp(jZzm3, this.zzi) - jNanoTime;
                    this.zzv = (this.zzv + 1) % 10;
                    int i = this.zzw;
                    if (i < 10) {
                        this.zzw = i + 1;
                    }
                    this.zzl = jNanoTime;
                    this.zzk = 0L;
                    int i2 = 0;
                    while (true) {
                        int i3 = this.zzw;
                        if (i2 >= i3) {
                            break;
                        }
                        this.zzk += this.zzb[i2] / ((long) i3);
                        i2++;
                    }
                    if (!this.zzg) {
                        zzqdVar = this.zze;
                        zzqdVar.getClass();
                        if (zzqdVar.zzg(jNanoTime)) {
                            jZzb = zzqdVar.zzb();
                            jZza = zzqdVar.zza();
                            jZzm2 = zzm();
                            if (Math.abs(jZzb - jNanoTime) > 5000000) {
                                zzrd zzrdVar = ((zzqy) this.zza).zza;
                                String str2 = "Spurious audio timestamp (system clock mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzm2 + ", " + zzrdVar.zzI() + ", " + zzrdVar.zzJ();
                                str = "DefaultAudioSink";
                                zzff.zzf(str, str2);
                                zzqdVar.zzd();
                            } else {
                                str = "DefaultAudioSink";
                                if (Math.abs(zzfy.zzr(jZza, this.zzf) - jZzm2) > 5000000) {
                                    zzrd zzrdVar2 = ((zzqy) this.zza).zza;
                                    zzff.zzf(str, "Spurious audio timestamp (frame position mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzm2 + ", " + zzrdVar2.zzI() + ", " + zzrdVar2.zzJ());
                                    zzqdVar.zzd();
                                } else {
                                    zzqdVar.zzc();
                                }
                            }
                        } else {
                            str = "DefaultAudioSink";
                        }
                        if (this.zzp && (method = this.zzm) != null && jNanoTime - this.zzq >= 500000) {
                            try {
                                AudioTrack audioTrack2 = this.zzc;
                                audioTrack2.getClass();
                                Integer num = (Integer) method.invoke(audioTrack2, null);
                                int i4 = zzfy.zza;
                                long jIntValue = (((long) num.intValue()) * 1000) - this.zzh;
                                this.zzn = jIntValue;
                                jMax = Math.max(jIntValue, 0L);
                                this.zzn = jMax;
                                if (jMax > 5000000) {
                                    zzff.zzf(str, "Ignoring impossibly large audio latency: " + jMax);
                                    this.zzn = 0L;
                                }
                            } catch (Exception unused) {
                                this.zzm = null;
                            }
                            this.zzq = jNanoTime;
                        }
                    }
                }
            } else if (!this.zzg) {
                zzqdVar = this.zze;
                zzqdVar.getClass();
                if (zzqdVar.zzg(jNanoTime)) {
                    str = "DefaultAudioSink";
                } else {
                    jZzb = zzqdVar.zzb();
                    jZza = zzqdVar.zza();
                    jZzm2 = zzm();
                    if (Math.abs(jZzb - jNanoTime) > 5000000) {
                        zzrd zzrdVar3 = ((zzqy) this.zza).zza;
                        String str3 = "Spurious audio timestamp (system clock mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzm2 + ", " + zzrdVar3.zzI() + ", " + zzrdVar3.zzJ();
                        str = "DefaultAudioSink";
                        zzff.zzf(str, str3);
                        zzqdVar.zzd();
                    } else {
                        str = "DefaultAudioSink";
                        if (Math.abs(zzfy.zzr(jZza, this.zzf) - jZzm2) > 5000000) {
                            zzrd zzrdVar4 = ((zzqy) this.zza).zza;
                            zzff.zzf(str, "Spurious audio timestamp (frame position mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzm2 + ", " + zzrdVar4.zzI() + ", " + zzrdVar4.zzJ());
                            zzqdVar.zzd();
                        } else {
                            zzqdVar.zzc();
                        }
                    }
                }
                if (this.zzp) {
                    AudioTrack audioTrack3 = this.zzc;
                    audioTrack3.getClass();
                    Integer num2 = (Integer) method.invoke(audioTrack3, null);
                    int i5 = zzfy.zza;
                    long jIntValue2 = (((long) num2.intValue()) * 1000) - this.zzh;
                    this.zzn = jIntValue2;
                    jMax = Math.max(jIntValue2, 0L);
                    this.zzn = jMax;
                    if (jMax > 5000000) {
                        zzff.zzf(str, "Ignoring impossibly large audio latency: " + jMax);
                        this.zzn = 0L;
                    }
                    this.zzq = jNanoTime;
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        zzqd zzqdVar2 = this.zze;
        zzqdVar2.getClass();
        boolean zZzf = zzqdVar2.zzf();
        if (zZzf) {
            jZzm = zzfy.zzr(zzqdVar2.zza(), this.zzf) + zzfy.zzo(jNanoTime2 - zzqdVar2.zzb(), this.zzi);
        } else {
            jZzm = this.zzw == 0 ? zzm() : zzfy.zzo(this.zzk + jNanoTime2, this.zzi);
            if (!z) {
                jZzm = Math.max(0L, jZzm - this.zzn);
            }
        }
        if (this.zzD != zZzf) {
            this.zzF = this.zzC;
            this.zzE = this.zzB;
        }
        long j = jNanoTime2 - this.zzF;
        if (j < 1000000) {
            long jZzo = this.zzE + zzfy.zzo(j, this.zzi);
            long j2 = (j * 1000) / 1000000;
            jZzm = ((jZzm * j2) + ((1000 - j2) * jZzo)) / 1000;
        }
        if (!this.zzj) {
            long j3 = this.zzB;
            if (jZzm > j3) {
                this.zzj = true;
                int i6 = zzfy.zza;
                long jCurrentTimeMillis = System.currentTimeMillis() - zzfy.zzt(zzfy.zzp(zzfy.zzt(jZzm - j3), this.zzi));
                zzrd zzrdVar5 = ((zzqy) this.zza).zza;
                if (zzrdVar5.zzp != null) {
                    ((zzri) zzrdVar5.zzp).zza.zzc.zzv(jCurrentTimeMillis);
                }
            }
        }
        this.zzC = jNanoTime2;
        this.zzB = jZzm;
        this.zzD = zZzf;
        return jZzm;
    }

    public final void zzb(long j) {
        this.zzz = zzl();
        this.zzx = zzfy.zzq(SystemClock.elapsedRealtime());
        this.zzA = j;
    }

    public final void zzc() {
        zzn();
        this.zzc = null;
        this.zze = null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0023  */
    public final void zzd(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        boolean z2;
        this.zzc = audioTrack;
        this.zzd = i3;
        this.zze = new zzqd(audioTrack);
        this.zzf = audioTrack.getSampleRate();
        if (!z || zzfy.zza >= 23) {
            z2 = false;
        } else {
            z2 = true;
            if (i != 5) {
                if (i == 6) {
                    i = 6;
                } else {
                    z2 = false;
                }
            }
        }
        this.zzg = z2;
        boolean zZzH = zzfy.zzH(i);
        this.zzp = zZzH;
        this.zzh = zZzH ? zzfy.zzr(i3 / i2, this.zzf) : -9223372036854775807L;
        this.zzs = 0L;
        this.zzt = 0L;
        this.zzG = false;
        this.zzH = 0L;
        this.zzu = 0L;
        this.zzo = false;
        this.zzx = -9223372036854775807L;
        this.zzy = -9223372036854775807L;
        this.zzq = 0L;
        this.zzn = 0L;
        this.zzi = 1.0f;
    }

    public final void zze(zzel zzelVar) {
        this.zzI = zzelVar;
    }

    public final void zzf() {
        if (this.zzx != -9223372036854775807L) {
            this.zzx = zzfy.zzq(SystemClock.elapsedRealtime());
        }
        zzqd zzqdVar = this.zze;
        zzqdVar.getClass();
        zzqdVar.zze();
    }

    public final boolean zzg(long j) {
        if (j > zzfy.zzn(zza(false), this.zzf)) {
            return true;
        }
        if (this.zzg) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2 && zzl() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zzi(long j) {
        return this.zzy != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.zzy >= 200;
    }

    public final boolean zzj(long j) {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.zzg) {
            if (playState == 2) {
                this.zzo = false;
                return false;
            }
            if (playState == 1) {
                if (zzl() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z = this.zzo;
        boolean zZzg = zzg(j);
        this.zzo = zZzg;
        if (z && !zZzg && playState != 1) {
            zzqe zzqeVar = this.zza;
            int i = this.zzd;
            long jZzt = zzfy.zzt(this.zzh);
            zzqy zzqyVar = (zzqy) zzqeVar;
            zzrd zzrdVar = zzqyVar.zza;
            if (zzrdVar.zzp != null) {
                ((zzri) zzqyVar.zza.zzp).zza.zzc.zzx(i, jZzt, SystemClock.elapsedRealtime() - zzrdVar.zzS);
            }
        }
        return true;
    }

    public final boolean zzk() {
        zzn();
        if (this.zzx != -9223372036854775807L) {
            this.zzz = zzl();
            return false;
        }
        zzqd zzqdVar = this.zze;
        zzqdVar.getClass();
        zzqdVar.zze();
        return true;
    }
}
