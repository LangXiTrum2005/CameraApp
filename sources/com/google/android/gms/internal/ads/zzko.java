package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.core.view.PointerIconCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzko extends zzm implements zzjj {
    public static final /* synthetic */ int zzd = 0;
    private final zzmo zzA;
    private final long zzB;
    private int zzC;
    private int zzD;
    private boolean zzE;
    private int zzF;
    private zzmj zzG;
    private zzck zzH;
    private zzbv zzI;
    private zzbv zzJ;
    private zzam zzK;
    private zzam zzL;
    private Object zzM;
    private Surface zzN;
    private int zzO;
    private zzfq zzP;
    private zzir zzQ;
    private zzir zzR;
    private int zzS;
    private zzk zzT;
    private float zzU;
    private boolean zzV;
    private zzee zzW;
    private boolean zzX;
    private boolean zzY;
    private zzaa zzZ;
    private zzdp zzaa;
    private zzbv zzab;
    private zzly zzac;
    private int zzad;
    private long zzae;
    private final zzjk zzaf;
    private zzwk zzag;
    final zzyp zzb;
    final zzck zzc;
    private final zzeo zze;
    private final Context zzf;
    private final zzco zzg;
    private final zzmf[] zzh;
    private final zzyo zzi;
    private final zzew zzj;
    private final zzkz zzk;
    private final zzfc zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzcu zzn;
    private final List zzo;
    private final boolean zzp;
    private final zzuq zzq;
    private final zzmp zzr;
    private final Looper zzs;
    private final zzyw zzt;
    private final zzel zzu;
    private final zzkk zzv;
    private final zzkm zzw;
    private final zzil zzx;
    private final zzip zzy;
    private final zzmn zzz;

    static {
        zzbq.zzb("media3.exoplayer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.google.android.gms.internal.ads.zzmp, com.google.android.gms.internal.ads.zzyv, java.lang.Object] */
    public zzko(zzji zzjiVar, zzco zzcoVar) {
        zzeo zzeoVar = new zzeo(zzel.zza);
        this.zze = zzeoVar;
        try {
            zzff.zze("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.2.1] [" + zzfy.zze + "]");
            Context applicationContext = zzjiVar.zza.getApplicationContext();
            this.zzf = applicationContext;
            ?? Apply = zzjiVar.zzh.apply(zzjiVar.zzb);
            this.zzr = Apply;
            this.zzT = zzjiVar.zzj;
            this.zzO = zzjiVar.zzk;
            this.zzV = false;
            this.zzB = zzjiVar.zzo;
            zzkk zzkkVar = new zzkk(this, null);
            this.zzv = zzkkVar;
            zzkm zzkmVar = new zzkm(null);
            this.zzw = zzkmVar;
            Handler handler = new Handler(zzjiVar.zzi);
            zzmf[] zzmfVarArrZza = ((zzjb) zzjiVar.zzc).zza.zza(handler, zzkkVar, zzkkVar, zzkkVar, zzkkVar);
            this.zzh = zzmfVarArrZza;
            int length = zzmfVarArrZza.length;
            zzyo zzyoVar = (zzyo) zzjiVar.zze.zza();
            this.zzi = zzyoVar;
            this.zzq = zzji.zza(((zzjc) zzjiVar.zzd).zza);
            zzza zzzaVarZzg = zzza.zzg(((zzjf) zzjiVar.zzg).zza);
            this.zzt = zzzaVarZzg;
            this.zzp = zzjiVar.zzl;
            this.zzG = zzjiVar.zzm;
            Looper looper = zzjiVar.zzi;
            this.zzs = looper;
            zzel zzelVar = zzjiVar.zzb;
            this.zzu = zzelVar;
            this.zzg = zzcoVar;
            zzfc zzfcVar = new zzfc(looper, zzelVar, new zzfa() { // from class: com.google.android.gms.internal.ads.zzke
                @Override // com.google.android.gms.internal.ads.zzfa
                public final void zza(Object obj, zzah zzahVar) {
                }
            });
            this.zzl = zzfcVar;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzm = copyOnWriteArraySet;
            this.zzo = new ArrayList();
            this.zzag = new zzwk(0);
            int length2 = zzmfVarArrZza.length;
            zzyp zzypVar = new zzyp(new zzmi[2], new zzyi[2], zzdk.zza, null);
            this.zzb = zzypVar;
            this.zzn = new zzcu();
            zzci zzciVar = new zzci();
            zzciVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzyoVar.zzn();
            zzciVar.zzd(29, true);
            zzciVar.zzd(23, false);
            zzciVar.zzd(25, false);
            zzciVar.zzd(33, false);
            zzciVar.zzd(26, false);
            zzciVar.zzd(34, false);
            zzck zzckVarZze = zzciVar.zze();
            this.zzc = zzckVarZze;
            zzci zzciVar2 = new zzci();
            zzciVar2.zzb(zzckVarZze);
            zzciVar2.zza(4);
            zzciVar2.zza(10);
            this.zzH = zzciVar2.zze();
            this.zzj = zzelVar.zzb(looper, null);
            zzjk zzjkVar = new zzjk(this);
            this.zzaf = zzjkVar;
            this.zzac = zzly.zzg(zzypVar);
            Apply.zzR(zzcoVar, looper);
            this.zzk = new zzkz(zzmfVarArrZza, zzyoVar, zzypVar, (zzlc) zzjiVar.zzf.zza(), zzzaVarZzg, 0, false, Apply, this.zzG, zzjiVar.zzr, zzjiVar.zzn, false, looper, zzelVar, zzjkVar, zzfy.zza < 31 ? new zzpb() : zzkf.zza(applicationContext, this, zzjiVar.zzp), null);
            this.zzU = 1.0f;
            this.zzI = zzbv.zza;
            zzbv zzbvVar = zzbv.zza;
            this.zzJ = zzbvVar;
            this.zzab = zzbvVar;
            int iGenerateAudioSessionId = -1;
            this.zzad = -1;
            AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
            if (audioManager != null) {
                iGenerateAudioSessionId = audioManager.generateAudioSessionId();
            }
            this.zzS = iGenerateAudioSessionId;
            this.zzW = zzee.zza;
            this.zzX = true;
            Apply.getClass();
            zzfcVar.zzb(Apply);
            zzzaVarZzg.zze(new Handler(looper), Apply);
            copyOnWriteArraySet.add(zzkkVar);
            this.zzx = new zzil(zzjiVar.zza, handler, zzkkVar);
            this.zzy = new zzip(zzjiVar.zza, handler, zzkkVar);
            zzfy.zzF(null, null);
            this.zzz = new zzmn(zzjiVar.zza);
            this.zzA = new zzmo(zzjiVar.zza);
            this.zzZ = new zzy(0).zza();
            this.zzaa = zzdp.zza;
            this.zzP = zzfq.zza;
            zzyoVar.zzk(this.zzT);
            zzag(1, 10, Integer.valueOf(this.zzS));
            zzag(2, 10, Integer.valueOf(this.zzS));
            zzag(1, 3, this.zzT);
            zzag(2, 4, Integer.valueOf(this.zzO));
            zzag(2, 5, 0);
            zzag(1, 9, Boolean.valueOf(this.zzV));
            zzag(2, 7, zzkmVar);
            zzag(6, 8, zzkmVar);
            zzeoVar.zze();
        } catch (Throwable th) {
            this.zze.zze();
            throw th;
        }
    }

    static /* bridge */ /* synthetic */ void zzP(zzko zzkoVar, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzkoVar.zzai(surface);
        zzkoVar.zzN = surface;
    }

    private final int zzW(zzly zzlyVar) {
        return zzlyVar.zza.zzo() ? this.zzad : zzlyVar.zza.zzn(zzlyVar.zzb.zza, this.zzn).zzd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzX(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    private final long zzY(zzly zzlyVar) {
        if (!zzlyVar.zzb.zzb()) {
            return zzfy.zzt(zzZ(zzlyVar));
        }
        zzlyVar.zza.zzn(zzlyVar.zzb.zza, this.zzn);
        if (zzlyVar.zzc == -9223372036854775807L) {
            long j = zzlyVar.zza.zze(zzW(zzlyVar), this.zza, 0L).zzn;
            return zzfy.zzt(0L);
        }
        int i = zzfy.zza;
        return zzfy.zzt(0L) + zzfy.zzt(zzlyVar.zzc);
    }

    private final long zzZ(zzly zzlyVar) {
        if (zzlyVar.zza.zzo()) {
            return zzfy.zzq(this.zzae);
        }
        boolean z = zzlyVar.zzo;
        long j = zzlyVar.zzr;
        if (zzlyVar.zzb.zzb()) {
            return j;
        }
        zzab(zzlyVar.zza, zzlyVar.zzb, j);
        return j;
    }

    private static long zzaa(zzly zzlyVar) {
        zzcw zzcwVar = new zzcw();
        zzcu zzcuVar = new zzcu();
        zzlyVar.zza.zzn(zzlyVar.zzb.zza, zzcuVar);
        long j = zzlyVar.zzc;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = zzlyVar.zza.zze(zzcuVar.zzd, zzcwVar, 0L).zzn;
        return 0L;
    }

    private final long zzab(zzcx zzcxVar, zzur zzurVar, long j) {
        zzcxVar.zzn(zzurVar.zza, this.zzn);
        return j;
    }

    private final Pair zzac(zzcx zzcxVar, int i, long j) {
        if (zzcxVar.zzo()) {
            this.zzad = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.zzae = j;
            return null;
        }
        if (i == -1 || i >= zzcxVar.zzc()) {
            i = zzcxVar.zzg(false);
            long j2 = zzcxVar.zze(i, this.zza, 0L).zzn;
            j = zzfy.zzt(0L);
        }
        return zzcxVar.zzl(this.zza, this.zzn, i, zzfy.zzq(j));
    }

    private final zzly zzad(zzly zzlyVar, zzcx zzcxVar, Pair pair) {
        zzek.zzd(zzcxVar.zzo() || pair != null);
        zzcx zzcxVar2 = zzlyVar.zza;
        long jZzY = zzY(zzlyVar);
        zzly zzlyVarZzf = zzlyVar.zzf(zzcxVar);
        if (zzcxVar.zzo()) {
            zzur zzurVarZzh = zzly.zzh();
            long jZzq = zzfy.zzq(this.zzae);
            zzly zzlyVarZza = zzlyVarZzf.zzb(zzurVarZzh, jZzq, jZzq, jZzq, 0L, zzws.zza, this.zzb, zzgaa.zzl()).zza(zzurVarZzh);
            zzlyVarZza.zzp = zzlyVarZza.zzr;
            return zzlyVarZza;
        }
        Object obj = zzlyVarZzf.zzb.zza;
        int i = zzfy.zza;
        boolean z = !obj.equals(pair.first);
        zzur zzurVar = z ? new zzur(pair.first, -1L) : zzlyVarZzf.zzb;
        long jLongValue = ((Long) pair.second).longValue();
        long jZzq2 = zzfy.zzq(jZzY);
        if (!zzcxVar2.zzo()) {
            zzcxVar2.zzn(obj, this.zzn);
        }
        if (z || jLongValue < jZzq2) {
            zzek.zzf(!zzurVar.zzb());
            zzly zzlyVarZza2 = zzlyVarZzf.zzb(zzurVar, jLongValue, jLongValue, jLongValue, 0L, z ? zzws.zza : zzlyVarZzf.zzh, z ? this.zzb : zzlyVarZzf.zzi, z ? zzgaa.zzl() : zzlyVarZzf.zzj).zza(zzurVar);
            zzlyVarZza2.zzp = jLongValue;
            return zzlyVarZza2;
        }
        if (jLongValue != jZzq2) {
            zzek.zzf(!zzurVar.zzb());
            long jMax = Math.max(0L, zzlyVarZzf.zzq - (jLongValue - jZzq2));
            long j = zzlyVarZzf.zzp;
            if (zzlyVarZzf.zzk.equals(zzlyVarZzf.zzb)) {
                j = jLongValue + jMax;
            }
            zzly zzlyVarZzb = zzlyVarZzf.zzb(zzurVar, jLongValue, jLongValue, jLongValue, jMax, zzlyVarZzf.zzh, zzlyVarZzf.zzi, zzlyVarZzf.zzj);
            zzlyVarZzb.zzp = j;
            return zzlyVarZzb;
        }
        int iZza = zzcxVar.zza(zzlyVarZzf.zzk.zza);
        if (iZza != -1 && zzcxVar.zzd(iZza, this.zzn, false).zzd == zzcxVar.zzn(zzurVar.zza, this.zzn).zzd) {
            return zzlyVarZzf;
        }
        zzcxVar.zzn(zzurVar.zza, this.zzn);
        long jZzh = zzurVar.zzb() ? this.zzn.zzh(zzurVar.zzb, zzurVar.zzc) : this.zzn.zze;
        zzly zzlyVarZza3 = zzlyVarZzf.zzb(zzurVar, zzlyVarZzf.zzr, zzlyVarZzf.zzr, zzlyVarZzf.zzd, jZzh - zzlyVarZzf.zzr, zzlyVarZzf.zzh, zzlyVarZzf.zzi, zzlyVarZzf.zzj).zza(zzurVar);
        zzlyVarZza3.zzp = jZzh;
        return zzlyVarZza3;
    }

    private final zzmb zzae(zzma zzmaVar) {
        int iZzW = zzW(this.zzac);
        zzcx zzcxVar = this.zzac.zza;
        if (iZzW == -1) {
            iZzW = 0;
        }
        zzel zzelVar = this.zzu;
        zzkz zzkzVar = this.zzk;
        return new zzmb(zzkzVar, zzmaVar, zzcxVar, iZzW, zzelVar, zzkzVar.zzb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaf(final int i, final int i2) {
        if (i == this.zzP.zzb() && i2 == this.zzP.zza()) {
            return;
        }
        this.zzP = new zzfq(i, i2);
        zzfc zzfcVar = this.zzl;
        zzfcVar.zzd(24, new zzez() { // from class: com.google.android.gms.internal.ads.zzkb
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                int i3 = zzko.zzd;
                ((zzcl) obj).zzo(i, i2);
            }
        });
        zzfcVar.zzc();
        zzag(2, 14, new zzfq(i, i2));
    }

    private final void zzag(int i, int i2, Object obj) {
        zzmf[] zzmfVarArr = this.zzh;
        int length = zzmfVarArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzmf zzmfVar = zzmfVarArr[i3];
            if (zzmfVar.zzbj() == i) {
                zzmb zzmbVarZzae = zzae(zzmfVar);
                zzmbVarZzae.zzf(i2);
                zzmbVarZzae.zze(obj);
                zzmbVarZzae.zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzah() {
        zzag(1, 2, Float.valueOf(this.zzU * this.zzy.zza()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzai(Object obj) {
        ArrayList arrayList = new ArrayList();
        zzmf[] zzmfVarArr = this.zzh;
        int length = zzmfVarArr.length;
        boolean z = false;
        for (int i = 0; i < 2; i++) {
            zzmf zzmfVar = zzmfVarArr[i];
            if (zzmfVar.zzbj() == 2) {
                zzmb zzmbVarZzae = zzae(zzmfVar);
                zzmbVarZzae.zzf(1);
                zzmbVarZzae.zze(obj);
                zzmbVarZzae.zzd();
                arrayList.add(zzmbVarZzae);
            }
        }
        Object obj2 = this.zzM;
        if (obj2 != null && obj2 != obj) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((zzmb) it.next()).zzi(this.zzB);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z = true;
            }
            Object obj3 = this.zzM;
            Surface surface = this.zzN;
            if (obj3 == surface) {
                surface.release();
                this.zzN = null;
            }
        }
        this.zzM = obj;
        if (z) {
            zzaj(zziz.zzd(new zzla(3), PointerIconCompat.TYPE_HELP));
        }
    }

    private final void zzaj(zziz zzizVar) {
        zzly zzlyVar = this.zzac;
        zzly zzlyVarZza = zzlyVar.zza(zzlyVar.zzb);
        zzlyVarZza.zzp = zzlyVarZza.zzr;
        zzlyVarZza.zzq = 0L;
        zzly zzlyVarZze = zzlyVarZza.zze(1);
        if (zzizVar != null) {
            zzlyVarZze = zzlyVarZze.zzd(zzizVar);
        }
        this.zzC++;
        this.zzk.zzo();
        zzal(zzlyVarZze, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzak(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        zzly zzlyVar = this.zzac;
        if (zzlyVar.zzl == z2 && zzlyVar.zzm == i3) {
            return;
        }
        this.zzC++;
        boolean z3 = zzlyVar.zzo;
        zzly zzlyVarZzc = zzlyVar.zzc(z2, i3);
        this.zzk.zzn(z2, i3);
        zzal(zzlyVarZzc, 0, i2, false, 5, -9223372036854775807L, -1, false);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:102:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:104:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:105:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:108:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:110:0x030c  */
    /* JADX WARN: Code duplicated, block: B:113:0x031c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0330  */
    /* JADX WARN: Code duplicated, block: B:117:0x0340  */
    /* JADX WARN: Code duplicated, block: B:120:0x034f  */
    /* JADX WARN: Code duplicated, block: B:123:0x035d  */
    /* JADX WARN: Code duplicated, block: B:126:0x036a  */
    /* JADX WARN: Code duplicated, block: B:129:0x037d  */
    /* JADX WARN: Code duplicated, block: B:132:0x0392  */
    /* JADX WARN: Code duplicated, block: B:135:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:141:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:144:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:145:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:147:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:148:0x0402  */
    /* JADX WARN: Code duplicated, block: B:151:0x040e  */
    /* JADX WARN: Code duplicated, block: B:152:0x0410  */
    /* JADX WARN: Code duplicated, block: B:154:0x0420  */
    /* JADX WARN: Code duplicated, block: B:157:0x042b  */
    /* JADX WARN: Code duplicated, block: B:159:0x043f  */
    /* JADX WARN: Code duplicated, block: B:160:0x0441  */
    /* JADX WARN: Code duplicated, block: B:164:0x0450  */
    /* JADX WARN: Code duplicated, block: B:167:0x0460  */
    /* JADX WARN: Code duplicated, block: B:170:0x0478 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:172:0x047c  */
    /* JADX WARN: Code duplicated, block: B:175:0x0482 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:177:0x0486  */
    /* JADX WARN: Code duplicated, block: B:180:0x048d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:185:0x0497  */
    /* JADX WARN: Code duplicated, block: B:188:0x049e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:190:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:193:0x04aa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:198:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:201:0x04c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:203:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:206:0x04cf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:208:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:211:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:40:0x010d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0113  */
    /* JADX WARN: Code duplicated, block: B:45:0x011e  */
    /* JADX WARN: Code duplicated, block: B:48:0x012d  */
    /* JADX WARN: Code duplicated, block: B:51:0x013a A[LOOP:1: B:49:0x0134->B:51:0x013a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x015a  */
    /* JADX WARN: Code duplicated, block: B:57:0x015d  */
    /* JADX WARN: Code duplicated, block: B:60:0x018a  */
    /* JADX WARN: Code duplicated, block: B:61:0x018c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0193  */
    /* JADX WARN: Code duplicated, block: B:65:0x0195  */
    /* JADX WARN: Code duplicated, block: B:68:0x019a  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:78:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:81:0x0206  */
    /* JADX WARN: Code duplicated, block: B:83:0x020e  */
    /* JADX WARN: Code duplicated, block: B:84:0x021d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0224  */
    /* JADX WARN: Code duplicated, block: B:87:0x022b  */
    /* JADX WARN: Code duplicated, block: B:88:0x022e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0236  */
    /* JADX WARN: Code duplicated, block: B:91:0x023d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0269  */
    /* JADX WARN: Code duplicated, block: B:96:0x029c  */
    /* JADX WARN: Code duplicated, block: B:99:0x02b4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r50v0 */
    /* JADX WARN: Type inference failed for: r50v1 */
    /* JADX WARN: Type inference failed for: r50v2 */
    /* JADX WARN: Type inference failed for: r50v3 */
    /* JADX WARN: Type inference failed for: r50v4 */
    /* JADX WARN: Type inference failed for: r50v5 */
    /* JADX WARN: Type inference failed for: r50v6 */
    /* JADX WARN: Type inference failed for: r8v23, types: [com.google.android.gms.internal.ads.zzcx] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v29 */
    private final void zzal(final zzly zzlyVar, final int i, final int i2, boolean z, int i3, long j, int i4, boolean z2) {
        int i5;
        boolean z3;
        boolean z4;
        Pair pair;
        boolean z5;
        int i6;
        boolean zBooleanValue;
        final int iIntValue;
        final zzbp zzbpVar;
        zzcx zzcxVarZzn;
        zzbv zzbvVarZzu;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        zzyp zzypVar;
        zzyp zzypVar2;
        zzck zzckVar;
        zzm zzmVar;
        zzcx zzcxVarZzn2;
        boolean z10;
        zzcx zzcxVarZzn3;
        ?? r10;
        int iZzk;
        int i7;
        boolean z11;
        ?? Zzn;
        int iZzd;
        ?? r8;
        zzcx zzcxVarZzn4;
        ?? r50;
        long j2;
        boolean z12;
        ?? r51;
        zzcx zzcxVarZzn5;
        boolean z13;
        boolean zZzo;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        int i8;
        boolean z19;
        boolean z20;
        zzck zzckVarZze;
        ?? r52;
        zzcu zzcuVar;
        int i9;
        Object obj;
        zzbp zzbpVar2;
        Object obj2;
        int i10;
        long jZzaa;
        long jZzaa2;
        int iZzd2;
        Object obj3;
        zzbp zzbpVar3;
        Object obj4;
        int iZza;
        long jZzt;
        long jZzt2;
        zzbt zzbtVarZza;
        List list;
        int i11;
        zzby zzbyVar;
        int i12;
        final int i13 = i3;
        zzly zzlyVar2 = this.zzac;
        this.zzac = zzlyVar;
        boolean z21 = !zzlyVar2.zza.equals(zzlyVar.zza);
        zzcx zzcxVar = zzlyVar2.zza;
        zzcx zzcxVar2 = zzlyVar.zza;
        if (!zzcxVar2.zzo() || !zzcxVar.zzo()) {
            if (zzcxVar2.zzo() != zzcxVar.zzo()) {
                pair = new Pair(true, 3);
            } else if (zzcxVar.zze(zzcxVar.zzn(zzlyVar2.zzb.zza, this.zzn).zzd, this.zza, 0L).zzc.equals(zzcxVar2.zze(zzcxVar2.zzn(zzlyVar.zzb.zza, this.zzn).zzd, this.zza, 0L).zzc)) {
                if (!z) {
                    i5 = i13;
                    z3 = false;
                } else if (i13 != 0) {
                    i5 = i13;
                    z3 = true;
                } else if (zzlyVar2.zzb.zzd < zzlyVar.zzb.zzd) {
                    pair = new Pair(true, 0);
                    z4 = true;
                    i13 = 0;
                } else {
                    z3 = true;
                    i5 = 0;
                }
                z4 = z3;
                i13 = i5;
                pair = new Pair(false, -1);
            } else {
                if (z) {
                    if (i13 == 0) {
                        z4 = true;
                        i6 = 1;
                        i13 = 0;
                    } else {
                        z4 = true;
                        z5 = true;
                    }
                    pair = new Pair(true, Integer.valueOf(i6));
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (z4 && i13 == 1) {
                    z4 = z5;
                    i6 = 2;
                } else {
                    if (!z21) {
                        throw new IllegalStateException();
                    }
                    i6 = 3;
                }
                pair = new Pair(true, Integer.valueOf(i6));
            }
            zBooleanValue = ((Boolean) pair.first).booleanValue();
            iIntValue = ((Integer) pair.second).intValue();
            if (zBooleanValue) {
                if (zzlyVar.zza.zzo()) {
                    zzbpVar = null;
                } else {
                    zzbpVar = zzlyVar.zza.zze(zzlyVar.zza.zzn(zzlyVar.zzb.zza, this.zzn).zzd, this.zza, 0L).zze;
                }
                this.zzab = zzbv.zza;
            } else {
                zzbpVar = null;
            }
            if (!zzlyVar2.zzj.equals(zzlyVar.zzj)) {
                zzbtVarZza = this.zzab.zza();
                list = zzlyVar.zzj;
                for (i11 = 0; i11 < list.size(); i11++) {
                    zzbyVar = (zzby) list.get(i11);
                    for (i12 = 0; i12 < zzbyVar.zza(); i12++) {
                        zzbyVar.zzb(i12).zza(zzbtVarZza);
                    }
                }
                this.zzab = zzbtVarZza.zzu();
            }
            zzcxVarZzn = zzn();
            if (zzcxVarZzn.zzo()) {
                zzbvVarZzu = this.zzab;
            } else {
                zzbp zzbpVar4 = zzcxVarZzn.zze(zzd(), this.zza, 0L).zze;
                zzbt zzbtVarZza2 = this.zzab.zza();
                zzbtVarZza2.zzb(zzbpVar4.zzg);
                zzbvVarZzu = zzbtVarZza2.zzu();
            }
            z6 = !zzbvVarZzu.equals(this.zzI);
            this.zzI = zzbvVarZzu;
            if (zzlyVar2.zzl != zzlyVar.zzl) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (zzlyVar2.zze != zzlyVar.zze) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8 || z7) {
                zzam();
            }
            if (zzlyVar2.zzg != zzlyVar.zzg) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z21) {
                this.zzl.zzd(0, new zzez() { // from class: com.google.android.gms.internal.ads.zzjm
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj5) {
                        int i14 = zzko.zzd;
                        ((zzcl) obj5).zzp(zzlyVar.zza, i);
                    }
                });
            }
            if (z4) {
                zzcuVar = new zzcu();
                if (zzlyVar2.zza.zzo()) {
                    i9 = i4;
                    obj = null;
                    zzbpVar2 = null;
                    obj2 = null;
                    i10 = -1;
                } else {
                    Object obj5 = zzlyVar2.zzb.zza;
                    zzlyVar2.zza.zzn(obj5, zzcuVar);
                    int i14 = zzcuVar.zzd;
                    int iZza2 = zzlyVar2.zza.zza(obj5);
                    obj2 = obj5;
                    obj = zzlyVar2.zza.zze(i14, this.zza, 0L).zzc;
                    zzbpVar2 = this.zza.zze;
                    i9 = i14;
                    i10 = iZza2;
                }
                if (i13 == 0) {
                    if (zzlyVar2.zzb.zzb()) {
                        zzur zzurVar = zzlyVar2.zzb;
                        jZzaa = zzcuVar.zzh(zzurVar.zzb, zzurVar.zzc);
                        jZzaa2 = zzaa(zzlyVar2);
                    } else {
                        if (zzlyVar2.zzb.zze != -1) {
                            jZzaa = zzaa(this.zzac);
                        } else {
                            jZzaa = zzcuVar.zze;
                        }
                        jZzaa2 = jZzaa;
                    }
                } else if (zzlyVar2.zzb.zzb()) {
                    jZzaa = zzlyVar2.zzr;
                    jZzaa2 = zzaa(zzlyVar2);
                } else {
                    jZzaa = zzlyVar2.zzr;
                    jZzaa2 = jZzaa;
                }
                int i15 = zzfy.zza;
                zzur zzurVar2 = zzlyVar2.zzb;
                final zzcn zzcnVar = new zzcn(obj, i9, zzbpVar2, obj2, i10, zzfy.zzt(jZzaa), zzfy.zzt(jZzaa2), zzurVar2.zzb, zzurVar2.zzc);
                iZzd2 = zzd();
                if (this.zzac.zza.zzo()) {
                    obj3 = null;
                    zzbpVar3 = null;
                    obj4 = null;
                    iZza = -1;
                } else {
                    zzly zzlyVar3 = this.zzac;
                    Object obj6 = zzlyVar3.zzb.zza;
                    zzlyVar3.zza.zzn(obj6, this.zzn);
                    iZza = this.zzac.zza.zza(obj6);
                    obj3 = this.zzac.zza.zze(iZzd2, this.zza, 0L).zzc;
                    zzbpVar3 = this.zza.zze;
                    obj4 = obj6;
                }
                jZzt = zzfy.zzt(j);
                if (this.zzac.zzb.zzb()) {
                    jZzt2 = zzfy.zzt(zzaa(this.zzac));
                } else {
                    jZzt2 = jZzt;
                }
                zzur zzurVar3 = this.zzac.zzb;
                final zzcn zzcnVar2 = new zzcn(obj3, iZzd2, zzbpVar3, obj4, iZza, jZzt, jZzt2, zzurVar3.zzb, zzurVar3.zzc);
                this.zzl.zzd(11, new zzez() { // from class: com.google.android.gms.internal.ads.zzjr
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        ((zzcl) obj7).zzm(zzcnVar, zzcnVar2, i13);
                    }
                });
            } else {
                z8 = z8;
                z9 = z9;
            }
            if (zBooleanValue) {
                this.zzl.zzd(1, new zzez() { // from class: com.google.android.gms.internal.ads.zzjt
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        ((zzcl) obj7).zzd(zzbpVar, iIntValue);
                    }
                });
            }
            if (zzlyVar2.zzf != zzlyVar.zzf) {
                this.zzl.zzd(10, new zzez() { // from class: com.google.android.gms.internal.ads.zzju
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        ((zzcl) obj7).zzk(zzlyVar.zzf);
                    }
                });
                if (zzlyVar.zzf != null) {
                    this.zzl.zzd(10, new zzez() { // from class: com.google.android.gms.internal.ads.zzjv
                        @Override // com.google.android.gms.internal.ads.zzez
                        public final void zza(Object obj7) {
                            int i16 = zzko.zzd;
                            ((zzcl) obj7).zzj(zzlyVar.zzf);
                        }
                    });
                }
            }
            zzypVar = zzlyVar2.zzi;
            zzypVar2 = zzlyVar.zzi;
            if (zzypVar != zzypVar2) {
                this.zzi.zzq(zzypVar2.zze);
                this.zzl.zzd(2, new zzez() { // from class: com.google.android.gms.internal.ads.zzjw
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        ((zzcl) obj7).zzq(zzlyVar.zzi.zzd);
                    }
                });
            }
            if (z6) {
                final zzbv zzbvVar = this.zzI;
                this.zzl.zzd(14, new zzez() { // from class: com.google.android.gms.internal.ads.zzjx
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        ((zzcl) obj7).zze(zzbvVar);
                    }
                });
            }
            if (z9) {
                this.zzl.zzd(3, new zzez() { // from class: com.google.android.gms.internal.ads.zzjy
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        ((zzcl) obj7).zzb(zzlyVar.zzg);
                    }
                });
            }
            if (z8 || z7) {
                this.zzl.zzd(-1, new zzez() { // from class: com.google.android.gms.internal.ads.zzjz
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        zzly zzlyVar4 = zzlyVar;
                        ((zzcl) obj7).zzl(zzlyVar4.zzl, zzlyVar4.zze);
                    }
                });
            }
            if (z8) {
                this.zzl.zzd(4, new zzez() { // from class: com.google.android.gms.internal.ads.zzka
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        ((zzcl) obj7).zzh(zzlyVar.zze);
                    }
                });
            }
            if (z7) {
                this.zzl.zzd(5, new zzez() { // from class: com.google.android.gms.internal.ads.zzjn
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        ((zzcl) obj7).zzf(zzlyVar.zzl, i2);
                    }
                });
            }
            if (zzlyVar2.zzm != zzlyVar.zzm) {
                this.zzl.zzd(6, new zzez() { // from class: com.google.android.gms.internal.ads.zzjo
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        ((zzcl) obj7).zzi(zzlyVar.zzm);
                    }
                });
            }
            if (zzlyVar2.zzi() != zzlyVar.zzi()) {
                this.zzl.zzd(7, new zzez() { // from class: com.google.android.gms.internal.ads.zzjp
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        ((zzcl) obj7).zzc(zzlyVar.zzi());
                    }
                });
            }
            if (!zzlyVar2.zzn.equals(zzlyVar.zzn)) {
                this.zzl.zzd(12, new zzez() { // from class: com.google.android.gms.internal.ads.zzjq
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i16 = zzko.zzd;
                        ((zzcl) obj7).zzg(zzlyVar.zzn);
                    }
                });
            }
            zzckVar = this.zzH;
            zzco zzcoVar = this.zzg;
            zzck zzckVar2 = this.zzc;
            int i16 = zzfy.zza;
            boolean zZzx = zzcoVar.zzx();
            zzmVar = (zzm) zzcoVar;
            zzcxVarZzn2 = zzmVar.zzn();
            if (zzcxVarZzn2.zzo() && zzcxVarZzn2.zze(zzmVar.zzd(), zzmVar.zza, 0L).zzi) {
                z10 = true;
            } else {
                z10 = false;
            }
            zzcxVarZzn3 = zzmVar.zzn();
            if (zzcxVarZzn3.zzo()) {
                i7 = -1;
                r10 = 0;
                z11 = false;
            } else {
                int iZzd3 = zzmVar.zzd();
                zzmVar.zzh();
                zzmVar.zzw();
                r10 = 0;
                r10 = 0;
                iZzk = zzcxVarZzn3.zzk(iZzd3, 0, false);
                i7 = -1;
                if (iZzk != -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
            Zzn = zzmVar.zzn();
            if (Zzn.zzo()) {
                r8 = r10;
            } else {
                iZzd = zzmVar.zzd();
                zzmVar.zzh();
                zzmVar.zzw();
                if (Zzn.zzj(iZzd, r10, r10) != i7) {
                    r8 = 1;
                } else {
                    r8 = r10;
                }
            }
            zzcxVarZzn4 = zzmVar.zzn();
            if (!zzcxVarZzn4.zzo()) {
                r52 = r8;
                j2 = 0;
                if (zzcxVarZzn4.zze(zzmVar.zzd(), zzmVar.zza, 0L).zzb()) {
                    r50 = r52;
                    z12 = true;
                    r51 = r52;
                }
                zzcxVarZzn5 = zzmVar.zzn();
                if (zzcxVarZzn5.zzo() && zzcxVarZzn5.zze(zzmVar.zzd(), zzmVar.zza, j2).zzj) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                zZzo = zzcoVar.zzn().zzo();
                zzci zzciVar = new zzci();
                zzciVar.zzb(zzckVar2);
                boolean z22 = !zZzx;
                zzciVar.zzd(4, z22);
                if (z10 || zZzx) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                zzciVar.zzd(5, z14);
                if (z11 || zZzx) {
                    z15 = false;
                } else {
                    z15 = true;
                }
                zzciVar.zzd(6, z15);
                if (!zZzo || (!(z11 || !z12 || z10) || zZzx)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                zzciVar.zzd(7, z16);
                if (r51 != 0 || zZzx) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                zzciVar.zzd(8, z17);
                if (!zZzo || ((r51 == 0 && !(z12 && z13)) || zZzx)) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                zzciVar.zzd(9, z18);
                zzciVar.zzd(10, z22);
                if (z10 || zZzx) {
                    i8 = 11;
                    z19 = false;
                } else {
                    i8 = 11;
                    z19 = true;
                }
                zzciVar.zzd(i8, z19);
                if (z10 || zZzx) {
                    z20 = false;
                } else {
                    z20 = true;
                }
                zzciVar.zzd(12, z20);
                zzckVarZze = zzciVar.zze();
                this.zzH = zzckVarZze;
                if (!zzckVarZze.equals(zzckVar)) {
                    this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                        @Override // com.google.android.gms.internal.ads.zzez
                        public final void zza(Object obj7) {
                            this.zza.zzU((zzcl) obj7);
                        }
                    });
                }
                this.zzl.zzc();
                boolean z23 = zzlyVar2.zzo;
                boolean z24 = zzlyVar.zzo;
            }
            r50 = r8;
            j2 = 0;
            r50 = r52;
            z12 = false;
            r51 = r50;
            zzcxVarZzn5 = zzmVar.zzn();
            if (zzcxVarZzn5.zzo()) {
                z13 = false;
            } else {
                z13 = false;
            }
            zZzo = zzcoVar.zzn().zzo();
            zzci zzciVar2 = new zzci();
            zzciVar2.zzb(zzckVar2);
            boolean z25 = !zZzx;
            zzciVar2.zzd(4, z25);
            if (z10) {
                z14 = false;
            } else {
                z14 = false;
            }
            zzciVar2.zzd(5, z14);
            if (z11) {
                z15 = false;
            } else {
                z15 = false;
            }
            zzciVar2.zzd(6, z15);
            if (zZzo) {
                z16 = false;
            } else {
                z16 = false;
            }
            zzciVar2.zzd(7, z16);
            if (r51 != 0) {
                z17 = false;
            } else {
                z17 = false;
            }
            zzciVar2.zzd(8, z17);
            if (zZzo) {
                z18 = false;
            } else {
                z18 = false;
            }
            zzciVar2.zzd(9, z18);
            zzciVar2.zzd(10, z25);
            if (z10) {
                i8 = 11;
                z19 = false;
            } else {
                i8 = 11;
                z19 = false;
            }
            zzciVar2.zzd(i8, z19);
            if (z10) {
                z20 = false;
            } else {
                z20 = false;
            }
            zzciVar2.zzd(12, z20);
            zzckVarZze = zzciVar2.zze();
            this.zzH = zzckVarZze;
            if (!zzckVarZze.equals(zzckVar)) {
                this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        this.zza.zzU((zzcl) obj7);
                    }
                });
            }
            this.zzl.zzc();
            boolean z26 = zzlyVar2.zzo;
            boolean z27 = zzlyVar.zzo;
        }
        pair = new Pair(false, -1);
        z4 = z;
        zBooleanValue = ((Boolean) pair.first).booleanValue();
        iIntValue = ((Integer) pair.second).intValue();
        if (zBooleanValue) {
            if (zzlyVar.zza.zzo()) {
                zzbpVar = zzlyVar.zza.zze(zzlyVar.zza.zzn(zzlyVar.zzb.zza, this.zzn).zzd, this.zza, 0L).zze;
            } else {
                zzbpVar = null;
            }
            this.zzab = zzbv.zza;
        } else {
            zzbpVar = null;
        }
        if (!zzlyVar2.zzj.equals(zzlyVar.zzj)) {
            zzbtVarZza = this.zzab.zza();
            list = zzlyVar.zzj;
            while (i11 < list.size()) {
                zzbyVar = (zzby) list.get(i11);
                while (i12 < zzbyVar.zza()) {
                    zzbyVar.zzb(i12).zza(zzbtVarZza);
                }
            }
            this.zzab = zzbtVarZza.zzu();
        }
        zzcxVarZzn = zzn();
        if (zzcxVarZzn.zzo()) {
            zzbvVarZzu = this.zzab;
        } else {
            zzbp zzbpVar5 = zzcxVarZzn.zze(zzd(), this.zza, 0L).zze;
            zzbt zzbtVarZza3 = this.zzab.zza();
            zzbtVarZza3.zzb(zzbpVar5.zzg);
            zzbvVarZzu = zzbtVarZza3.zzu();
        }
        z6 = !zzbvVarZzu.equals(this.zzI);
        this.zzI = zzbvVarZzu;
        if (zzlyVar2.zzl != zzlyVar.zzl) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (zzlyVar2.zze != zzlyVar.zze) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            zzam();
        } else {
            zzam();
        }
        if (zzlyVar2.zzg != zzlyVar.zzg) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z21) {
            this.zzl.zzd(0, new zzez() { // from class: com.google.android.gms.internal.ads.zzjm
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj7) {
                    int i17 = zzko.zzd;
                    ((zzcl) obj7).zzp(zzlyVar.zza, i);
                }
            });
        }
        if (z4) {
            zzcuVar = new zzcu();
            if (zzlyVar2.zza.zzo()) {
                Object obj7 = zzlyVar2.zzb.zza;
                zzlyVar2.zza.zzn(obj7, zzcuVar);
                int i17 = zzcuVar.zzd;
                int iZza3 = zzlyVar2.zza.zza(obj7);
                obj2 = obj7;
                obj = zzlyVar2.zza.zze(i17, this.zza, 0L).zzc;
                zzbpVar2 = this.zza.zze;
                i9 = i17;
                i10 = iZza3;
            } else {
                i9 = i4;
                obj = null;
                zzbpVar2 = null;
                obj2 = null;
                i10 = -1;
            }
            if (i13 == 0) {
                if (zzlyVar2.zzb.zzb()) {
                    zzur zzurVar4 = zzlyVar2.zzb;
                    jZzaa = zzcuVar.zzh(zzurVar4.zzb, zzurVar4.zzc);
                    jZzaa2 = zzaa(zzlyVar2);
                } else {
                    if (zzlyVar2.zzb.zze != -1) {
                        jZzaa = zzaa(this.zzac);
                    } else {
                        jZzaa = zzcuVar.zze;
                    }
                    jZzaa2 = jZzaa;
                }
            } else if (zzlyVar2.zzb.zzb()) {
                jZzaa = zzlyVar2.zzr;
                jZzaa2 = zzaa(zzlyVar2);
            } else {
                jZzaa = zzlyVar2.zzr;
                jZzaa2 = jZzaa;
            }
            int i18 = zzfy.zza;
            zzur zzurVar5 = zzlyVar2.zzb;
            final zzcn zzcnVar3 = new zzcn(obj, i9, zzbpVar2, obj2, i10, zzfy.zzt(jZzaa), zzfy.zzt(jZzaa2), zzurVar5.zzb, zzurVar5.zzc);
            iZzd2 = zzd();
            if (this.zzac.zza.zzo()) {
                zzly zzlyVar4 = this.zzac;
                Object obj8 = zzlyVar4.zzb.zza;
                zzlyVar4.zza.zzn(obj8, this.zzn);
                iZza = this.zzac.zza.zza(obj8);
                obj3 = this.zzac.zza.zze(iZzd2, this.zza, 0L).zzc;
                zzbpVar3 = this.zza.zze;
                obj4 = obj8;
            } else {
                obj3 = null;
                zzbpVar3 = null;
                obj4 = null;
                iZza = -1;
            }
            jZzt = zzfy.zzt(j);
            if (this.zzac.zzb.zzb()) {
                jZzt2 = zzfy.zzt(zzaa(this.zzac));
            } else {
                jZzt2 = jZzt;
            }
            zzur zzurVar6 = this.zzac.zzb;
            final zzcn zzcnVar4 = new zzcn(obj3, iZzd2, zzbpVar3, obj4, iZza, jZzt, jZzt2, zzurVar6.zzb, zzurVar6.zzc);
            this.zzl.zzd(11, new zzez() { // from class: com.google.android.gms.internal.ads.zzjr
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    ((zzcl) obj9).zzm(zzcnVar3, zzcnVar4, i13);
                }
            });
        } else {
            z8 = z8;
            z9 = z9;
        }
        if (zBooleanValue) {
            this.zzl.zzd(1, new zzez() { // from class: com.google.android.gms.internal.ads.zzjt
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    ((zzcl) obj9).zzd(zzbpVar, iIntValue);
                }
            });
        }
        if (zzlyVar2.zzf != zzlyVar.zzf) {
            this.zzl.zzd(10, new zzez() { // from class: com.google.android.gms.internal.ads.zzju
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    ((zzcl) obj9).zzk(zzlyVar.zzf);
                }
            });
            if (zzlyVar.zzf != null) {
                this.zzl.zzd(10, new zzez() { // from class: com.google.android.gms.internal.ads.zzjv
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj9) {
                        int i19 = zzko.zzd;
                        ((zzcl) obj9).zzj(zzlyVar.zzf);
                    }
                });
            }
        }
        zzypVar = zzlyVar2.zzi;
        zzypVar2 = zzlyVar.zzi;
        if (zzypVar != zzypVar2) {
            this.zzi.zzq(zzypVar2.zze);
            this.zzl.zzd(2, new zzez() { // from class: com.google.android.gms.internal.ads.zzjw
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    ((zzcl) obj9).zzq(zzlyVar.zzi.zzd);
                }
            });
        }
        if (z6) {
            final zzbv zzbvVar2 = this.zzI;
            this.zzl.zzd(14, new zzez() { // from class: com.google.android.gms.internal.ads.zzjx
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    ((zzcl) obj9).zze(zzbvVar2);
                }
            });
        }
        if (z9) {
            this.zzl.zzd(3, new zzez() { // from class: com.google.android.gms.internal.ads.zzjy
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    ((zzcl) obj9).zzb(zzlyVar.zzg);
                }
            });
        }
        if (z8) {
            this.zzl.zzd(-1, new zzez() { // from class: com.google.android.gms.internal.ads.zzjz
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    zzly zzlyVar5 = zzlyVar;
                    ((zzcl) obj9).zzl(zzlyVar5.zzl, zzlyVar5.zze);
                }
            });
        } else {
            this.zzl.zzd(-1, new zzez() { // from class: com.google.android.gms.internal.ads.zzjz
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    zzly zzlyVar5 = zzlyVar;
                    ((zzcl) obj9).zzl(zzlyVar5.zzl, zzlyVar5.zze);
                }
            });
        }
        if (z8) {
            this.zzl.zzd(4, new zzez() { // from class: com.google.android.gms.internal.ads.zzka
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    ((zzcl) obj9).zzh(zzlyVar.zze);
                }
            });
        }
        if (z7) {
            this.zzl.zzd(5, new zzez() { // from class: com.google.android.gms.internal.ads.zzjn
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    ((zzcl) obj9).zzf(zzlyVar.zzl, i2);
                }
            });
        }
        if (zzlyVar2.zzm != zzlyVar.zzm) {
            this.zzl.zzd(6, new zzez() { // from class: com.google.android.gms.internal.ads.zzjo
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    ((zzcl) obj9).zzi(zzlyVar.zzm);
                }
            });
        }
        if (zzlyVar2.zzi() != zzlyVar.zzi()) {
            this.zzl.zzd(7, new zzez() { // from class: com.google.android.gms.internal.ads.zzjp
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    ((zzcl) obj9).zzc(zzlyVar.zzi());
                }
            });
        }
        if (!zzlyVar2.zzn.equals(zzlyVar.zzn)) {
            this.zzl.zzd(12, new zzez() { // from class: com.google.android.gms.internal.ads.zzjq
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i19 = zzko.zzd;
                    ((zzcl) obj9).zzg(zzlyVar.zzn);
                }
            });
        }
        zzckVar = this.zzH;
        zzco zzcoVar2 = this.zzg;
        zzck zzckVar3 = this.zzc;
        int i19 = zzfy.zza;
        boolean zZzx2 = zzcoVar2.zzx();
        zzmVar = (zzm) zzcoVar2;
        zzcxVarZzn2 = zzmVar.zzn();
        if (zzcxVarZzn2.zzo()) {
            z10 = false;
        } else {
            z10 = false;
        }
        zzcxVarZzn3 = zzmVar.zzn();
        if (zzcxVarZzn3.zzo()) {
            i7 = -1;
            r10 = 0;
            z11 = false;
        } else {
            int iZzd4 = zzmVar.zzd();
            zzmVar.zzh();
            zzmVar.zzw();
            r10 = 0;
            r10 = 0;
            iZzk = zzcxVarZzn3.zzk(iZzd4, 0, false);
            i7 = -1;
            if (iZzk != -1) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        Zzn = zzmVar.zzn();
        if (Zzn.zzo()) {
            r8 = r10;
        } else {
            iZzd = zzmVar.zzd();
            zzmVar.zzh();
            zzmVar.zzw();
            if (Zzn.zzj(iZzd, r10, r10) != i7) {
                r8 = 1;
            } else {
                r8 = r10;
            }
        }
        zzcxVarZzn4 = zzmVar.zzn();
        if (!zzcxVarZzn4.zzo()) {
            r52 = r8;
            j2 = 0;
            if (zzcxVarZzn4.zze(zzmVar.zzd(), zzmVar.zza, 0L).zzb()) {
                r50 = r52;
                z12 = true;
                r51 = r52;
            }
            zzcxVarZzn5 = zzmVar.zzn();
            if (zzcxVarZzn5.zzo()) {
                z13 = false;
            } else {
                z13 = false;
            }
            zZzo = zzcoVar2.zzn().zzo();
            zzci zzciVar3 = new zzci();
            zzciVar3.zzb(zzckVar3);
            boolean z28 = !zZzx2;
            zzciVar3.zzd(4, z28);
            if (z10) {
                z14 = false;
            } else {
                z14 = false;
            }
            zzciVar3.zzd(5, z14);
            if (z11) {
                z15 = false;
            } else {
                z15 = false;
            }
            zzciVar3.zzd(6, z15);
            if (zZzo) {
                z16 = false;
            } else {
                z16 = false;
            }
            zzciVar3.zzd(7, z16);
            if (r51 != 0) {
                z17 = false;
            } else {
                z17 = false;
            }
            zzciVar3.zzd(8, z17);
            if (zZzo) {
                z18 = false;
            } else {
                z18 = false;
            }
            zzciVar3.zzd(9, z18);
            zzciVar3.zzd(10, z28);
            if (z10) {
                i8 = 11;
                z19 = false;
            } else {
                i8 = 11;
                z19 = false;
            }
            zzciVar3.zzd(i8, z19);
            if (z10) {
                z20 = false;
            } else {
                z20 = false;
            }
            zzciVar3.zzd(12, z20);
            zzckVarZze = zzciVar3.zze();
            this.zzH = zzckVarZze;
            if (!zzckVarZze.equals(zzckVar)) {
                this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj9) {
                        this.zza.zzU((zzcl) obj9);
                    }
                });
            }
            this.zzl.zzc();
            boolean z29 = zzlyVar2.zzo;
            boolean z210 = zzlyVar.zzo;
        }
        r50 = r8;
        j2 = 0;
        r50 = r52;
        z12 = false;
        r51 = r50;
        zzcxVarZzn5 = zzmVar.zzn();
        if (zzcxVarZzn5.zzo()) {
            z13 = false;
        } else {
            z13 = false;
        }
        zZzo = zzcoVar2.zzn().zzo();
        zzci zzciVar4 = new zzci();
        zzciVar4.zzb(zzckVar3);
        boolean z211 = !zZzx2;
        zzciVar4.zzd(4, z211);
        if (z10) {
            z14 = false;
        } else {
            z14 = false;
        }
        zzciVar4.zzd(5, z14);
        if (z11) {
            z15 = false;
        } else {
            z15 = false;
        }
        zzciVar4.zzd(6, z15);
        if (zZzo) {
            z16 = false;
        } else {
            z16 = false;
        }
        zzciVar4.zzd(7, z16);
        if (r51 != 0) {
            z17 = false;
        } else {
            z17 = false;
        }
        zzciVar4.zzd(8, z17);
        if (zZzo) {
            z18 = false;
        } else {
            z18 = false;
        }
        zzciVar4.zzd(9, z18);
        zzciVar4.zzd(10, z211);
        if (z10) {
            i8 = 11;
            z19 = false;
        } else {
            i8 = 11;
            z19 = false;
        }
        zzciVar4.zzd(i8, z19);
        if (z10) {
            z20 = false;
        } else {
            z20 = false;
        }
        zzciVar4.zzd(12, z20);
        zzckVarZze = zzciVar4.zze();
        this.zzH = zzckVarZze;
        if (!zzckVarZze.equals(zzckVar)) {
            this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    this.zza.zzU((zzcl) obj9);
                }
            });
        }
        this.zzl.zzc();
        boolean z212 = zzlyVar2.zzo;
        boolean z213 = zzlyVar.zzo;
    }

    private final void zzam() {
        int iZzf = zzf();
        if (iZzf == 2 || iZzf == 3) {
            zzan();
            boolean z = this.zzac.zzo;
            zzv();
            zzv();
        }
    }

    private final void zzan() {
        this.zze.zzb();
        if (Thread.currentThread() != this.zzs.getThread()) {
            String str = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.zzs.getThread().getName());
            if (this.zzX) {
                throw new IllegalStateException(str);
            }
            zzff.zzg("ExoPlayerImpl", str, this.zzY ? null : new IllegalStateException());
            this.zzY = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjj
    public final void zzA(zzms zzmsVar) {
        zzan();
        this.zzr.zzQ(zzmsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjj
    public final void zzB(zzut zzutVar) {
        zzan();
        List listSingletonList = Collections.singletonList(zzutVar);
        zzan();
        zzan();
        zzW(this.zzac);
        zzk();
        this.zzC++;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i = size - 1; i >= 0; i--) {
                this.zzo.remove(i);
            }
            this.zzag = this.zzag.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listSingletonList.size(); i2++) {
            zzlv zzlvVar = new zzlv((zzut) listSingletonList.get(i2), this.zzp);
            arrayList.add(zzlvVar);
            this.zzo.add(i2, new zzkn(zzlvVar.zzb, zzlvVar.zza));
        }
        this.zzag = this.zzag.zzg(0, arrayList.size());
        zzmd zzmdVar = new zzmd(this.zzo, this.zzag);
        if (!zzmdVar.zzo() && zzmdVar.zzc() < 0) {
            throw new zzan(zzmdVar, -1, -9223372036854775807L);
        }
        int iZzg = zzmdVar.zzg(false);
        zzly zzlyVarZzad = zzad(this.zzac, zzmdVar, zzac(zzmdVar, iZzg, -9223372036854775807L));
        int i3 = zzlyVarZzad.zze;
        if (iZzg != -1 && i3 != 1) {
            i3 = 4;
            if (!zzmdVar.zzo() && iZzg < zzmdVar.zzc()) {
                i3 = 2;
            }
        }
        zzly zzlyVarZze = zzlyVarZzad.zze(i3);
        this.zzk.zzq(arrayList, iZzg, zzfy.zzq(-9223372036854775807L), this.zzag);
        zzal(zzlyVarZze, 0, 1, (this.zzac.zzb.zza.equals(zzlyVarZze.zzb.zza) || this.zzac.zza.zzo()) ? false : true, 4, zzZ(zzlyVarZze), -1, false);
    }

    public final zziz zzE() {
        zzan();
        return this.zzac.zzf;
    }

    final /* synthetic */ void zzS(zzkx zzkxVar) {
        long j;
        boolean z;
        int i = this.zzC - zzkxVar.zzb;
        this.zzC = i;
        boolean z2 = true;
        if (zzkxVar.zzc) {
            this.zzD = zzkxVar.zzd;
            this.zzE = true;
        }
        if (zzkxVar.zze) {
            this.zzF = zzkxVar.zzf;
        }
        if (i == 0) {
            zzcx zzcxVar = zzkxVar.zza.zza;
            if (!this.zzac.zza.zzo() && zzcxVar.zzo()) {
                this.zzad = -1;
                this.zzae = 0L;
            }
            if (!zzcxVar.zzo()) {
                List listZzw = ((zzmd) zzcxVar).zzw();
                zzek.zzf(listZzw.size() == this.zzo.size());
                for (int i2 = 0; i2 < listZzw.size(); i2++) {
                    ((zzkn) this.zzo.get(i2)).zzc((zzcx) listZzw.get(i2));
                }
            }
            if (this.zzE) {
                if (zzkxVar.zza.zzb.equals(this.zzac.zzb) && zzkxVar.zza.zzd == this.zzac.zzr) {
                    z2 = false;
                }
                if (!z2) {
                    j = -9223372036854775807L;
                } else if (zzcxVar.zzo() || zzkxVar.zza.zzb.zzb()) {
                    j = zzkxVar.zza.zzd;
                } else {
                    zzly zzlyVar = zzkxVar.zza;
                    zzur zzurVar = zzlyVar.zzb;
                    j = zzlyVar.zzd;
                    zzab(zzcxVar, zzurVar, j);
                }
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.zzE = false;
            zzal(zzkxVar.zza, 1, this.zzF, z, this.zzD, j, -1, false);
        }
    }

    final /* synthetic */ void zzT(final zzkx zzkxVar) {
        this.zzj.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkd
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzS(zzkxVar);
            }
        });
    }

    final /* synthetic */ void zzU(zzcl zzclVar) {
        zzclVar.zza(this.zzH);
    }

    @Override // com.google.android.gms.internal.ads.zzm
    public final void zza(int i, long j, int i2, boolean z) {
        zzan();
        zzek.zzd(i >= 0);
        this.zzr.zzu();
        zzcx zzcxVar = this.zzac.zza;
        if (zzcxVar.zzo() || i < zzcxVar.zzc()) {
            this.zzC++;
            if (zzx()) {
                zzff.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzkx zzkxVar = new zzkx(this.zzac);
                zzkxVar.zza(1);
                this.zzaf.zza.zzT(zzkxVar);
                return;
            }
            zzly zzlyVarZze = this.zzac;
            int i3 = zzlyVarZze.zze;
            if (i3 == 3 || (i3 == 4 && !zzcxVar.zzo())) {
                zzlyVarZze = this.zzac.zze(2);
            }
            int iZzd = zzd();
            zzly zzlyVarZzad = zzad(zzlyVarZze, zzcxVar, zzac(zzcxVar, i, j));
            this.zzk.zzl(zzcxVar, i, zzfy.zzq(j));
            zzal(zzlyVarZzad, 0, 1, true, 1, zzZ(zzlyVarZzad), iZzd, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzb() {
        zzan();
        if (zzx()) {
            return this.zzac.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzc() {
        zzan();
        if (zzx()) {
            return this.zzac.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzd() {
        zzan();
        int iZzW = zzW(this.zzac);
        if (iZzW == -1) {
            return 0;
        }
        return iZzW;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zze() {
        zzan();
        if (this.zzac.zza.zzo()) {
            return 0;
        }
        zzly zzlyVar = this.zzac;
        return zzlyVar.zza.zza(zzlyVar.zzb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzf() {
        zzan();
        return this.zzac.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzg() {
        zzan();
        return this.zzac.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzh() {
        zzan();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzi() {
        zzan();
        if (zzx()) {
            zzly zzlyVar = this.zzac;
            return zzlyVar.zzk.equals(zzlyVar.zzb) ? zzfy.zzt(this.zzac.zzp) : zzl();
        }
        zzan();
        if (this.zzac.zza.zzo()) {
            return this.zzae;
        }
        zzly zzlyVar2 = this.zzac;
        long j = 0;
        if (zzlyVar2.zzk.zzd != zzlyVar2.zzb.zzd) {
            return zzfy.zzt(zzlyVar2.zza.zze(zzd(), this.zza, 0L).zzo);
        }
        long j2 = zzlyVar2.zzp;
        if (this.zzac.zzk.zzb()) {
            zzly zzlyVar3 = this.zzac;
            zzlyVar3.zza.zzn(zzlyVar3.zzk.zza, this.zzn).zzi(this.zzac.zzk.zzb);
        } else {
            j = j2;
        }
        zzly zzlyVar4 = this.zzac;
        zzab(zzlyVar4.zza, zzlyVar4.zzk, j);
        return zzfy.zzt(j);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzj() {
        zzan();
        return zzY(this.zzac);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzk() {
        zzan();
        return zzfy.zzt(zzZ(this.zzac));
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzl() {
        zzan();
        if (zzx()) {
            zzly zzlyVar = this.zzac;
            zzur zzurVar = zzlyVar.zzb;
            zzlyVar.zza.zzn(zzurVar.zza, this.zzn);
            return zzfy.zzt(this.zzn.zzh(zzurVar.zzb, zzurVar.zzc));
        }
        zzcx zzcxVarZzn = zzn();
        if (zzcxVarZzn.zzo()) {
            return -9223372036854775807L;
        }
        return zzfy.zzt(zzcxVarZzn.zze(zzd(), this.zza, 0L).zzo);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzm() {
        zzan();
        return zzfy.zzt(this.zzac.zzq);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcx zzn() {
        zzan();
        return this.zzac.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzdk zzo() {
        zzan();
        return this.zzac.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzp() {
        zzan();
        zzip zzipVar = this.zzy;
        boolean zZzv = zzv();
        int iZzb = zzipVar.zzb(zZzv, 2);
        zzak(zZzv, iZzb, zzX(zZzv, iZzb));
        zzly zzlyVar = this.zzac;
        if (zzlyVar.zze != 1) {
            return;
        }
        zzly zzlyVarZzd = zzlyVar.zzd(null);
        zzly zzlyVarZze = zzlyVarZzd.zze(true == zzlyVarZzd.zza.zzo() ? 4 : 2);
        this.zzC++;
        this.zzk.zzk();
        zzal(zzlyVarZze, 1, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzq() {
        zzff.zze("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.2.1] [" + zzfy.zze + "] [" + zzbq.zza() + "]");
        zzan();
        this.zzy.zzd();
        if (!this.zzk.zzp()) {
            zzfc zzfcVar = this.zzl;
            zzfcVar.zzd(10, new zzez() { // from class: com.google.android.gms.internal.ads.zzkc
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj) {
                    ((zzcl) obj).zzj(zziz.zzd(new zzla(1), PointerIconCompat.TYPE_HELP));
                }
            });
            zzfcVar.zzc();
        }
        this.zzl.zze();
        this.zzj.zze(null);
        this.zzt.zzf(this.zzr);
        boolean z = this.zzac.zzo;
        zzly zzlyVarZze = this.zzac.zze(1);
        this.zzac = zzlyVarZze;
        zzly zzlyVarZza = zzlyVarZze.zza(zzlyVarZze.zzb);
        this.zzac = zzlyVarZza;
        zzlyVarZza.zzp = zzlyVarZza.zzr;
        this.zzac.zzq = 0L;
        this.zzr.zzP();
        this.zzi.zzj();
        Surface surface = this.zzN;
        if (surface != null) {
            surface.release();
            this.zzN = null;
        }
        this.zzW = zzee.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzr(boolean z) {
        zzan();
        int iZzb = this.zzy.zzb(z, zzf());
        zzak(z, iZzb, zzX(z, iZzb));
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzs(Surface surface) {
        zzan();
        zzai(surface);
        int i = surface == null ? 0 : -1;
        zzaf(i, i);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzt(float f) {
        zzan();
        final float fMax = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzU == fMax) {
            return;
        }
        this.zzU = fMax;
        zzah();
        zzfc zzfcVar = this.zzl;
        zzfcVar.zzd(22, new zzez() { // from class: com.google.android.gms.internal.ads.zzjs
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                int i = zzko.zzd;
                ((zzcl) obj).zzs(fMax);
            }
        });
        zzfcVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzu() {
        zzan();
        this.zzy.zzb(zzv(), 1);
        zzaj(null);
        this.zzW = new zzee(zzgaa.zzl(), this.zzac.zzr);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzv() {
        zzan();
        return this.zzac.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzw() {
        zzan();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzx() {
        zzan();
        return this.zzac.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzjj
    public final int zzy() {
        zzan();
        int length = this.zzh.length;
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzjj
    public final void zzz(zzms zzmsVar) {
        this.zzr.zzt(zzmsVar);
    }
}
