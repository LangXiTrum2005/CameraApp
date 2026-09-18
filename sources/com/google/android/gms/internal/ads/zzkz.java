package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import androidx.core.view.PointerIconCompat;
import com.google.firebase.perf.util.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkz implements Handler.Callback, zzuo, zzyn, zzlw, zziw, zzlz {
    private boolean zzB;
    private boolean zzE;
    private int zzF;
    private zzky zzG;
    private long zzH;
    private int zzI;
    private boolean zzJ;
    private zziz zzK;
    private final zzjk zzM;
    private final zziu zzN;
    private final zzmf[] zza;
    private final Set zzb;
    private final zzmh[] zzc;
    private final zzyo zzd;
    private final zzyp zze;
    private final zzlc zzf;
    private final zzyw zzg;
    private final zzew zzh;
    private final HandlerThread zzi;
    private final Looper zzj;
    private final zzcw zzk;
    private final zzcu zzl;
    private final long zzm;
    private final zzix zzn;
    private final ArrayList zzo;
    private final zzel zzp;
    private final zzll zzq;
    private final zzlx zzr;
    private final long zzs;
    private zzmj zzt;
    private zzly zzu;
    private zzkx zzv;
    private boolean zzw;
    private boolean zzy;
    private boolean zzz;
    private int zzC = 0;
    private boolean zzD = false;
    private boolean zzx = false;
    private long zzL = -9223372036854775807L;
    private long zzA = -9223372036854775807L;

    public zzkz(zzmf[] zzmfVarArr, zzyo zzyoVar, zzyp zzypVar, zzlc zzlcVar, zzyw zzywVar, int i, boolean z, zzmp zzmpVar, zzmj zzmjVar, zziu zziuVar, long j, boolean z2, Looper looper, zzel zzelVar, zzjk zzjkVar, zzpb zzpbVar, Looper looper2) {
        this.zzM = zzjkVar;
        this.zza = zzmfVarArr;
        this.zzd = zzyoVar;
        this.zze = zzypVar;
        this.zzf = zzlcVar;
        this.zzg = zzywVar;
        int i2 = 0;
        this.zzt = zzmjVar;
        this.zzN = zziuVar;
        this.zzs = j;
        this.zzp = zzelVar;
        this.zzm = zzlcVar.zza();
        zzlcVar.zzf();
        zzly zzlyVarZzg = zzly.zzg(zzypVar);
        this.zzu = zzlyVarZzg;
        this.zzv = new zzkx(zzlyVarZzg);
        int length = zzmfVarArr.length;
        this.zzc = new zzmh[2];
        zzmg zzmgVarZzd = zzyoVar.zzd();
        while (true) {
            int length2 = zzmfVarArr.length;
            if (i2 >= 2) {
                this.zzn = new zzix(this, zzelVar);
                this.zzo = new ArrayList();
                this.zzb = Collections.newSetFromMap(new IdentityHashMap());
                this.zzk = new zzcw();
                this.zzl = new zzcu();
                zzyoVar.zzs(this, zzywVar);
                this.zzJ = true;
                zzew zzewVarZzb = zzelVar.zzb(looper, null);
                this.zzq = new zzll(zzmpVar, zzewVarZzb, new zzkr(this));
                this.zzr = new zzlx(this, zzmpVar, zzewVarZzb, zzpbVar);
                HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                this.zzi = handlerThread;
                handlerThread.start();
                Looper looper3 = handlerThread.getLooper();
                this.zzj = looper3;
                this.zzh = zzelVar.zzb(looper3, this);
                return;
            }
            zzmfVarArr[i2].zzu(i2, zzpbVar, zzelVar);
            this.zzc[i2] = zzmfVarArr[i2].zzl();
            this.zzc[i2].zzK(zzmgVarZzd);
            i2++;
        }
    }

    private final void zzA(zzmf zzmfVar) throws zziz {
        if (zzaf(zzmfVar)) {
            this.zzn.zzd(zzmfVar);
            zzam(zzmfVar);
            zzmfVar.zzq();
            this.zzF--;
        }
    }

    private final void zzB() throws zziz {
        int length = this.zza.length;
        zzC(new boolean[2], this.zzq.zzf().zzf());
    }

    private final void zzC(boolean[] zArr, long j) throws zziz {
        zzli zzliVarZzf = this.zzq.zzf();
        zzyp zzypVarZzi = zzliVarZzf.zzi();
        int i = 0;
        while (true) {
            int length = this.zza.length;
            if (i >= 2) {
                break;
            }
            if (!zzypVarZzi.zzb(i) && this.zzb.remove(this.zza[i])) {
                this.zza[i].zzH();
            }
            i++;
        }
        int i2 = 0;
        while (true) {
            int length2 = this.zza.length;
            if (i2 >= 2) {
                zzliVarZzf.zzg = true;
                return;
            }
            if (zzypVarZzi.zzb(i2)) {
                boolean z = zArr[i2];
                zzmf zzmfVar = this.zza[i2];
                if (!zzaf(zzmfVar)) {
                    zzll zzllVar = this.zzq;
                    zzli zzliVarZzf2 = zzllVar.zzf();
                    boolean z2 = zzliVarZzf2 == zzllVar.zze();
                    zzyp zzypVarZzi2 = zzliVarZzf2.zzi();
                    zzmi zzmiVar = zzypVarZzi2.zzb[i2];
                    zzam[] zzamVarArrZzak = zzak(zzypVarZzi2.zzc[i2]);
                    boolean z3 = zzai() && this.zzu.zze == 3;
                    boolean z4 = !z && z3;
                    this.zzF++;
                    this.zzb.add(zzmfVar);
                    zzmfVar.zzr(zzmiVar, zzamVarArrZzak, zzliVarZzf2.zzc[i2], this.zzH, z4, z2, j, zzliVarZzf2.zze(), zzliVarZzf2.zzf.zza);
                    zzmfVar.zzt(11, new zzks(this));
                    this.zzn.zze(zzmfVar);
                    if (z3) {
                        zzmfVar.zzN();
                    }
                }
            }
            i2++;
        }
    }

    private final void zzD(IOException iOException, int i) {
        zzll zzllVar = this.zzq;
        zziz zzizVarZzc = zziz.zzc(iOException, i);
        zzli zzliVarZze = zzllVar.zze();
        if (zzliVarZze != null) {
            zzizVarZzc = zzizVarZzc.zza(zzliVarZze.zzf.zza);
        }
        zzff.zzd("ExoPlayerImplInternal", "Playback error", zzizVarZzc);
        zzW(false, false);
        this.zzu = this.zzu.zzd(zzizVarZzc);
    }

    private final void zzE(boolean z) {
        zzli zzliVarZzd = this.zzq.zzd();
        zzur zzurVar = zzliVarZzd == null ? this.zzu.zzb : zzliVarZzd.zzf.zza;
        boolean z2 = !this.zzu.zzk.equals(zzurVar);
        if (z2) {
            this.zzu = this.zzu.zza(zzurVar);
        }
        zzly zzlyVar = this.zzu;
        zzlyVar.zzp = zzliVarZzd == null ? zzlyVar.zzr : zzliVarZzd.zzc();
        this.zzu.zzq = zzt();
        if ((z2 || z) && zzliVarZzd != null && zzliVarZzd.zzd) {
            zzZ(zzliVarZzd.zzf.zza, zzliVarZzd.zzh(), zzliVarZzd.zzi());
        }
    }

    /* JADX WARN: Code duplicated, block: B:201:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:202:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:205:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:209:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:211:0x03d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:217:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:220:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:224:0x041f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4, types: [long] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2, types: [long] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r1v80, types: [int] */
    /* JADX WARN: Type inference failed for: r1v96 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r21v0, types: [long] */
    /* JADX WARN: Type inference failed for: r21v10 */
    /* JADX WARN: Type inference failed for: r21v17 */
    /* JADX WARN: Type inference failed for: r21v18 */
    /* JADX WARN: Type inference failed for: r21v19 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r21v6 */
    /* JADX WARN: Type inference failed for: r21v7 */
    /* JADX WARN: Type inference failed for: r21v9 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.google.android.gms.internal.ads.zzll] */
    /* JADX WARN: Type inference failed for: r30v0, types: [com.google.android.gms.internal.ads.zzkz] */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.google.android.gms.internal.ads.zzcx] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [long] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v26, types: [long] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v38, types: [long] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [long] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v28, types: [long] */
    /* JADX WARN: Type inference failed for: r5v31, types: [long] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r6v22, types: [long] */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31, types: [long] */
    /* JADX WARN: Type inference failed for: r6v32 */
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
    private final void zzF(zzcx zzcxVar, boolean z) throws Throwable {
        ?? r21;
        zzur zzurVar;
        zzcu zzcuVar;
        zzcw zzcwVar;
        int i;
        long j;
        Object obj;
        int iZzg;
        ?? r3;
        boolean z2;
        boolean z3;
        boolean z4;
        ?? r4;
        int iZzg2;
        boolean z5;
        ?? r5;
        ?? r6;
        boolean z6;
        ?? r13;
        boolean z7;
        boolean z8;
        boolean z9;
        zzur zzurVarZzh;
        ?? r17;
        int i2;
        boolean z10;
        int iZzg3;
        ?? r7;
        boolean z11;
        boolean z12;
        boolean z13;
        ?? r8;
        boolean z14;
        char c;
        ?? r22;
        ?? r23;
        boolean z15;
        ?? r26;
        int i3;
        boolean z16;
        long j2;
        boolean z17;
        char c2;
        ?? Zzv;
        zzly zzlyVar = this.zzu;
        zzky zzkyVar = this.zzG;
        int i4 = this.zzC;
        boolean z18 = this.zzD;
        if (zzcxVar.zzo()) {
            zzurVarZzh = zzly.zzh();
            r17 = -9223372036854775807;
            z7 = false;
            z8 = true;
            z9 = false;
            z6 = true;
            r13 = 0;
            j = 0;
        } else {
            zzcu zzcuVar2 = this.zzl;
            zzur zzurVar2 = zzlyVar.zzb;
            Object obj2 = zzurVar2.zza;
            boolean zZzah = zzah(zzlyVar, zzcuVar2);
            r21 = (zzlyVar.zzb.zzb() || zZzah) ? zzlyVar.zzc : zzlyVar.zzr;
            zzcw zzcwVar2 = this.zzk;
            if (zzkyVar != null) {
                zzurVar = zzurVar2;
                zzcuVar = zzcuVar2;
                Pair pairZzy = zzy(zzcxVar, zzkyVar, true, i4, z18, zzcwVar2, zzcuVar);
                if (pairZzy == null) {
                    iZzg3 = zzcxVar.zzg(z18);
                    r8 = r21;
                    obj = obj2;
                    z12 = false;
                    z11 = false;
                    z13 = true;
                } else {
                    if (zzkyVar.zzc == -9223372036854775807L) {
                        iZzg3 = zzcxVar.zzn(pairZzy.first, zzcuVar).zzd;
                        r7 = r21;
                        obj = obj2;
                        z10 = false;
                    } else {
                        Object obj3 = pairZzy.first;
                        long jLongValue = ((Long) pairZzy.second).longValue();
                        obj = obj3;
                        z10 = true;
                        iZzg3 = -1;
                        r7 = jLongValue;
                    }
                    z11 = zzlyVar.zze == 4;
                    z12 = z10;
                    z13 = false;
                    r8 = r7;
                }
                z2 = z11;
                z3 = z13;
                iZzg = iZzg3;
                zzcwVar = zzcwVar2;
                i = -1;
                j = 0;
                z4 = z12;
                r3 = r8;
            } else {
                zzurVar = zzurVar2;
                zzcuVar = zzcuVar2;
                zzcwVar = zzcwVar2;
                if (zzlyVar.zza.zzo()) {
                    iZzg = zzcxVar.zzg(z18);
                    obj = obj2;
                    z2 = false;
                    z3 = false;
                    i = -1;
                } else if (zzcxVar.zza(obj2) == -1) {
                    i = -1;
                    Object objZzf = zzf(zzcwVar, zzcuVar, i4, z18, obj2, zzlyVar.zza, zzcxVar);
                    if (objZzf == null) {
                        iZzg2 = zzcxVar.zzg(z18);
                        z5 = true;
                    } else {
                        iZzg2 = zzcxVar.zzn(objZzf, zzcuVar).zzd;
                        z5 = false;
                    }
                    iZzg = iZzg2;
                    z3 = z5;
                    obj = obj2;
                    z2 = false;
                } else {
                    i = -1;
                    if (r21 == -9223372036854775807L) {
                        iZzg = zzcxVar.zzn(obj2, zzcuVar).zzd;
                        obj = obj2;
                        z2 = false;
                        z3 = false;
                    } else if (zZzah) {
                        zzlyVar.zza.zzn(zzurVar.zza, zzcuVar);
                        zzcwVar = zzcwVar;
                        j = 0;
                        if (zzlyVar.zza.zze(zzcuVar.zzd, zzcwVar, 0L).zzp == zzlyVar.zza.zza(zzurVar.zza)) {
                            Pair pairZzl = zzcxVar.zzl(zzcwVar, zzcuVar, zzcxVar.zzn(obj2, zzcuVar).zzd, r21);
                            Object obj4 = pairZzl.first;
                            long jLongValue2 = ((Long) pairZzl.second).longValue();
                            obj = obj4;
                            r4 = jLongValue2;
                        } else {
                            obj = obj2;
                            r4 = r21;
                        }
                        iZzg = -1;
                        z2 = false;
                        z3 = false;
                        z4 = true;
                        r3 = r4;
                    } else {
                        zzcwVar = zzcwVar;
                        j = 0;
                        iZzg = -1;
                        r3 = r21;
                        z2 = false;
                        z3 = false;
                        z4 = false;
                    }
                }
                z4 = false;
                j = 0;
                r3 = r21;
            }
            if (iZzg != i) {
                obj = obj2;
                Pair pairZzl2 = zzcxVar.zzl(zzcwVar, zzcuVar, iZzg, -9223372036854775807L);
                Object obj5 = pairZzl2.first;
                long jLongValue3 = ((Long) pairZzl2.second).longValue();
                obj = obj5;
                r5 = jLongValue3;
                r6 = -9223372036854775807;
            } else {
                obj = obj2;
                r5 = r3;
                r6 = r3;
            }
            zzur zzurVarZzi = this.zzq.zzi(zzcxVar, obj, r5);
            int i5 = zzurVarZzi.zze;
            boolean z19 = zzurVar.zza.equals(obj) && !zzurVar.zzb() && !zzurVarZzi.zzb() && (i5 == i || ((i2 = zzurVar.zze) != i && i5 >= i2));
            zzcu zzcuVarZzn = zzcxVar.zzn(obj, zzcuVar);
            if (!zZzah && r21 == r6 && zzurVar.zza.equals(zzurVarZzi.zza)) {
                if (zzurVar.zzb()) {
                    zzcuVarZzn.zzn(zzurVar.zzb);
                }
                if (zzurVarZzi.zzb()) {
                    zzcuVarZzn.zzn(zzurVarZzi.zzb);
                }
            }
            z6 = true;
            if (true == z19) {
                zzurVarZzi = zzurVar;
            }
            ?? r9 = r5;
            if (zzurVarZzi.zzb()) {
                if (zzurVarZzi.equals(zzurVar)) {
                    r9 = zzlyVar.zzr;
                } else {
                    zzcxVar.zzn(zzurVarZzi.zza, zzcuVar);
                    if (zzurVarZzi.zzc == zzcuVar.zze(zzurVarZzi.zzb)) {
                        zzcuVar.zzj();
                    }
                    r9 = j;
                }
            }
            r13 = r9;
            z7 = z2;
            z8 = z3;
            z9 = z4;
            zzurVarZzh = zzurVarZzi;
            r17 = r6;
        }
        boolean z20 = (this.zzu.zzb.equals(zzurVarZzh) && r13 == this.zzu.zzr) ? false : z6;
        if (z8) {
            try {
                if (this.zzu.zze != z6) {
                    c = 4;
                    try {
                        zzU(4);
                    } catch (Throwable th) {
                        th = th;
                        r22 = 4;
                        z15 = false;
                        r23 = r22;
                        zzly zzlyVar2 = this.zzu;
                        zzcx zzcxVar2 = zzlyVar2.zza;
                        zzur zzurVar3 = zzlyVar2.zzb;
                        if (true != z9) {
                            r26 = -9223372036854775807;
                        } else {
                            r26 = r13;
                        }
                        zzab(zzcxVar, zzurVarZzh, zzcxVar2, zzurVar3, r26, false);
                        if (z20) {
                            zzly zzlyVar3 = this.zzu;
                            Object obj6 = zzlyVar3.zzb.zza;
                            zzcx zzcxVar3 = zzlyVar3.zza;
                            if (z20) {
                            }
                            this.zzu = zzz(zzurVarZzh, r13, r17, this.zzu.zzd, (z20 || !z || zzcxVar3.zzo() || zzcxVar3.zzn(obj6, this.zzl).zzg) ? false : true, (zzcxVar.zza(obj6) == -1 ? r23 : 3) == true ? 1 : 0);
                        } else {
                            zzly zzlyVar4 = this.zzu;
                            Object obj7 = zzlyVar4.zzb.zza;
                            zzcx zzcxVar4 = zzlyVar4.zza;
                            if (z20) {
                            }
                            this.zzu = zzz(zzurVarZzh, r13, r17, this.zzu.zzd, (z20 || !z || zzcxVar4.zzo() || zzcxVar4.zzn(obj7, this.zzl).zzg) ? false : true, (zzcxVar.zza(obj7) == -1 ? r23 : 3) == true ? 1 : 0);
                        }
                        zzN();
                        zzP(zzcxVar, this.zzu.zza);
                        this.zzu = this.zzu.zzf(zzcxVar);
                        if (!zzcxVar.zzo()) {
                            this.zzG = z15;
                        }
                        zzE(false);
                        throw th;
                    }
                } else {
                    c = 4;
                }
                z14 = false;
                try {
                    zzM(false, false, false, z6);
                } catch (Throwable th2) {
                    th = th2;
                    r22 = c;
                    z15 = false;
                    r23 = r22;
                    zzly zzlyVar5 = this.zzu;
                    zzcx zzcxVar5 = zzlyVar5.zza;
                    zzur zzurVar4 = zzlyVar5.zzb;
                    if (true != z9) {
                        r26 = -9223372036854775807;
                    } else {
                        r26 = r13;
                    }
                    zzab(zzcxVar, zzurVarZzh, zzcxVar5, zzurVar4, r26, false);
                    if (z20 || r17 != this.zzu.zzc) {
                        zzly zzlyVar6 = this.zzu;
                        Object obj8 = zzlyVar6.zzb.zza;
                        zzcx zzcxVar6 = zzlyVar6.zza;
                        this.zzu = zzz(zzurVarZzh, r13, r17, this.zzu.zzd, (z20 || !z || zzcxVar6.zzo() || zzcxVar6.zzn(obj8, this.zzl).zzg) ? false : true, (zzcxVar.zza(obj8) == -1 ? r23 : 3) == true ? 1 : 0);
                    }
                    zzN();
                    zzP(zzcxVar, this.zzu.zza);
                    this.zzu = this.zzu.zzf(zzcxVar);
                    if (!zzcxVar.zzo()) {
                        this.zzG = z15;
                    }
                    zzE(false);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z14 = false;
                c = 4;
                r22 = c;
                z15 = false;
                r23 = r22;
                zzly zzlyVar7 = this.zzu;
                zzcx zzcxVar7 = zzlyVar7.zza;
                zzur zzurVar5 = zzlyVar7.zzb;
                if (true != z9) {
                    r26 = -9223372036854775807;
                } else {
                    r26 = r13;
                }
                zzab(zzcxVar, zzurVarZzh, zzcxVar7, zzurVar5, r26, false);
                if (z20) {
                    zzly zzlyVar8 = this.zzu;
                    Object obj9 = zzlyVar8.zzb.zza;
                    zzcx zzcxVar8 = zzlyVar8.zza;
                    if (z20) {
                    }
                    this.zzu = zzz(zzurVarZzh, r13, r17, this.zzu.zzd, (z20 || !z || zzcxVar8.zzo() || zzcxVar8.zzn(obj9, this.zzl).zzg) ? false : true, (zzcxVar.zza(obj9) == -1 ? r23 : 3) == true ? 1 : 0);
                } else {
                    zzly zzlyVar9 = this.zzu;
                    Object obj10 = zzlyVar9.zzb.zza;
                    zzcx zzcxVar9 = zzlyVar9.zza;
                    if (z20) {
                    }
                    this.zzu = zzz(zzurVarZzh, r13, r17, this.zzu.zzd, (z20 || !z || zzcxVar9.zzo() || zzcxVar9.zzn(obj10, this.zzl).zzg) ? false : true, (zzcxVar.zza(obj10) == -1 ? r23 : 3) == true ? 1 : 0);
                }
                zzN();
                zzP(zzcxVar, this.zzu.zza);
                this.zzu = this.zzu.zzf(zzcxVar);
                if (!zzcxVar.zzo()) {
                    this.zzG = z15;
                }
                zzE(false);
                throw th;
            }
        } else {
            z14 = false;
            c = 4;
        }
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        ?? r1 = z14;
        while (true) {
            i3 = 2;
            if (r1 < 2) {
                zzmfVarArr[r1].zzM(zzcxVar);
                r1++;
            } else {
                try {
                    break;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        if (z20) {
            z17 = z14;
            c2 = c;
            z16 = z9;
            if (!zzcxVar.zzo()) {
                for (zzli zzliVarZze = this.zzq.zze(); zzliVarZze != null; zzliVarZze = zzliVarZze.zzg()) {
                    if (zzliVarZze.zzf.zza.equals(zzurVarZzh)) {
                        Zzv = r13;
                        zzliVarZze.zzf = this.zzq.zzh(zzcxVar, zzliVarZze.zzf);
                        zzliVarZze.zzq();
                    } else {
                        Zzv = r13;
                    }
                }
                Zzv = r13;
                Zzv = zzv(zzurVarZzh, r13, z7);
            }
        } else {
            try {
                zzll zzllVar = this.zzq;
                long j3 = this.zzH;
                zzli zzliVarZzf = zzllVar.zzf();
                if (zzliVarZzf == null) {
                    z16 = z9;
                    j2 = j;
                } else {
                    long jZze = zzliVarZzf.zze();
                    try {
                        z16 = z9;
                        if (zzliVarZzf.zzd) {
                            long jMax = jZze;
                            int i6 = 0;
                            while (true) {
                                try {
                                    zzmf[] zzmfVarArr2 = this.zza;
                                    int length2 = zzmfVarArr2.length;
                                    if (i6 >= i3) {
                                        j2 = jMax;
                                        break;
                                    }
                                    if (zzaf(zzmfVarArr2[i6]) && this.zza[i6].zzo() == zzliVarZzf.zzc[i6]) {
                                        long jZzbh = this.zza[i6].zzbh();
                                        j2 = Long.MIN_VALUE;
                                        if (jZzbh == Long.MIN_VALUE) {
                                            break;
                                        } else {
                                            jMax = Math.max(jZzbh, jMax);
                                        }
                                    }
                                    i6++;
                                    i3 = 2;
                                } catch (Throwable th5) {
                                    th = th5;
                                    z9 = z16;
                                    z15 = false;
                                    r23 = 4;
                                    zzly zzlyVar10 = this.zzu;
                                    zzcx zzcxVar10 = zzlyVar10.zza;
                                    zzur zzurVar6 = zzlyVar10.zzb;
                                    if (true != z9) {
                                        r26 = -9223372036854775807;
                                    } else {
                                        r26 = r13;
                                    }
                                    zzab(zzcxVar, zzurVarZzh, zzcxVar10, zzurVar6, r26, false);
                                    if (z20) {
                                        zzly zzlyVar11 = this.zzu;
                                        Object obj11 = zzlyVar11.zzb.zza;
                                        zzcx zzcxVar11 = zzlyVar11.zza;
                                        if (z20) {
                                        }
                                        this.zzu = zzz(zzurVarZzh, r13, r17, this.zzu.zzd, (z20 || !z || zzcxVar11.zzo() || zzcxVar11.zzn(obj11, this.zzl).zzg) ? false : true, (zzcxVar.zza(obj11) == -1 ? r23 : 3) == true ? 1 : 0);
                                    } else {
                                        zzly zzlyVar12 = this.zzu;
                                        Object obj12 = zzlyVar12.zzb.zza;
                                        zzcx zzcxVar12 = zzlyVar12.zza;
                                        if (z20) {
                                        }
                                        this.zzu = zzz(zzurVarZzh, r13, r17, this.zzu.zzd, (z20 || !z || zzcxVar12.zzo() || zzcxVar12.zzn(obj12, this.zzl).zzg) ? false : true, (zzcxVar.zza(obj12) == -1 ? r23 : 3) == true ? 1 : 0);
                                    }
                                    zzN();
                                    zzP(zzcxVar, this.zzu.zza);
                                    this.zzu = this.zzu.zzf(zzcxVar);
                                    if (!zzcxVar.zzo()) {
                                        this.zzG = z15;
                                    }
                                    zzE(false);
                                    throw th;
                                }
                            }
                        } else {
                            j2 = jZze;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        r21 = c;
                        z6 = false;
                        r22 = r21;
                        z15 = false;
                        r23 = r22;
                        zzly zzlyVar13 = this.zzu;
                        zzcx zzcxVar13 = zzlyVar13.zza;
                        zzur zzurVar7 = zzlyVar13.zzb;
                        if (true != z9) {
                            r26 = -9223372036854775807;
                        } else {
                            r26 = r13;
                        }
                        zzab(zzcxVar, zzurVarZzh, zzcxVar13, zzurVar7, r26, false);
                        if (z20) {
                            zzly zzlyVar14 = this.zzu;
                            Object obj13 = zzlyVar14.zzb.zza;
                            zzcx zzcxVar14 = zzlyVar14.zza;
                            if (z20) {
                            }
                            this.zzu = zzz(zzurVarZzh, r13, r17, this.zzu.zzd, (z20 || !z || zzcxVar14.zzo() || zzcxVar14.zzn(obj13, this.zzl).zzg) ? false : true, (zzcxVar.zza(obj13) == -1 ? r23 : 3) == true ? 1 : 0);
                        } else {
                            zzly zzlyVar15 = this.zzu;
                            Object obj14 = zzlyVar15.zzb.zza;
                            zzcx zzcxVar15 = zzlyVar15.zza;
                            if (z20) {
                            }
                            this.zzu = zzz(zzurVarZzh, r13, r17, this.zzu.zzd, (z20 || !z || zzcxVar15.zzo() || zzcxVar15.zzn(obj14, this.zzl).zzg) ? false : true, (zzcxVar.zza(obj14) == -1 ? r23 : 3) == true ? 1 : 0);
                        }
                        zzN();
                        zzP(zzcxVar, this.zzu.zza);
                        this.zzu = this.zzu.zzf(zzcxVar);
                        if (!zzcxVar.zzo()) {
                            this.zzG = z15;
                        }
                        zzE(false);
                        throw th;
                    }
                }
                z17 = false;
                c2 = 4;
                Zzv = r13;
                if (!zzllVar.zzp(zzcxVar, j3, j2)) {
                    zzR(false);
                    Zzv = r13;
                }
            } catch (Throwable th7) {
                th = th7;
                z6 = z14;
                r21 = c;
            }
        }
        Zzv = r13;
        zzly zzlyVar16 = this.zzu;
        zzab(zzcxVar, zzurVarZzh, zzlyVar16.zza, zzlyVar16.zzb, true != z16 ? -9223372036854775807 : Zzv, false);
        if (z20 || r17 != this.zzu.zzc) {
            zzly zzlyVar17 = this.zzu;
            Object obj15 = zzlyVar17.zzb.zza;
            zzcx zzcxVar16 = zzlyVar17.zza;
            this.zzu = zzz(zzurVarZzh, Zzv, r17, this.zzu.zzd, (!z20 || !z || zzcxVar16.zzo() || zzcxVar16.zzn(obj15, this.zzl).zzg) ? z17 : true, zzcxVar.zza(obj15) == -1 ? c2 : (char) 3);
        }
        zzN();
        zzP(zzcxVar, this.zzu.zza);
        this.zzu = this.zzu.zzf(zzcxVar);
        if (!zzcxVar.zzo()) {
            this.zzG = null;
        }
        zzE(z17);
    }

    private final void zzG(zzcg zzcgVar, boolean z) throws zziz {
        zzH(zzcgVar, zzcgVar.zzc, true, z);
    }

    private final void zzH(zzcg zzcgVar, float f, boolean z, boolean z2) throws zziz {
        int i;
        zzkz zzkzVar = this;
        if (z) {
            if (z2) {
                zzkzVar.zzv.zza(1);
            }
            zzly zzlyVar = zzkzVar.zzu;
            zzcx zzcxVar = zzlyVar.zza;
            zzur zzurVar = zzlyVar.zzb;
            long j = zzlyVar.zzc;
            long j2 = zzlyVar.zzd;
            int i2 = zzlyVar.zze;
            zziz zzizVar = zzlyVar.zzf;
            boolean z3 = zzlyVar.zzg;
            zzws zzwsVar = zzlyVar.zzh;
            zzyp zzypVar = zzlyVar.zzi;
            List list = zzlyVar.zzj;
            zzur zzurVar2 = zzlyVar.zzk;
            boolean z4 = zzlyVar.zzl;
            int i3 = zzlyVar.zzm;
            long j3 = zzlyVar.zzp;
            long j4 = zzlyVar.zzq;
            long j5 = zzlyVar.zzr;
            long j6 = zzlyVar.zzs;
            boolean z5 = zzlyVar.zzo;
            zzkzVar = this;
            zzkzVar.zzu = new zzly(zzcxVar, zzurVar, j, j2, i2, zzizVar, z3, zzwsVar, zzypVar, list, zzurVar2, z4, i3, zzcgVar, j3, j4, j5, j6, false);
        }
        float f2 = zzcgVar.zzc;
        zzli zzliVarZze = zzkzVar.zzq.zze();
        while (true) {
            i = 0;
            if (zzliVarZze == null) {
                break;
            }
            zzyi[] zzyiVarArr = zzliVarZze.zzi().zzc;
            int length = zzyiVarArr.length;
            while (i < length) {
                zzyi zzyiVar = zzyiVarArr[i];
                i++;
            }
            zzliVarZze = zzliVarZze.zzg();
        }
        zzmf[] zzmfVarArr = zzkzVar.zza;
        int length2 = zzmfVarArr.length;
        while (i < 2) {
            zzmf zzmfVar = zzmfVarArr[i];
            if (zzmfVar != null) {
                zzmfVar.zzL(f, zzcgVar.zzc);
            }
            i++;
        }
    }

    private final void zzI() {
        long jZze;
        long jZze2;
        boolean zZzg = false;
        if (zzae()) {
            zzli zzliVarZzd = this.zzq.zzd();
            long jZzu = zzu(zzliVarZzd.zzd());
            if (zzliVarZzd == this.zzq.zze()) {
                jZze = this.zzH;
                jZze2 = zzliVarZzd.zze();
            } else {
                jZze = this.zzH - zzliVarZzd.zze();
                jZze2 = zzliVarZzd.zzf.zzb;
            }
            long j = jZze - jZze2;
            boolean zZzg2 = this.zzf.zzg(j, jZzu, this.zzn.zzc().zzc);
            if (zZzg2 || jZzu >= 500000 || this.zzm <= 0) {
                zZzg = zZzg2;
            } else {
                this.zzq.zze().zza.zzj(this.zzu.zzr, false);
                zZzg = this.zzf.zzg(j, jZzu, this.zzn.zzc().zzc);
            }
        }
        this.zzB = zZzg;
        if (zZzg) {
            this.zzq.zzd().zzk(this.zzH, this.zzn.zzc().zzc, this.zzA);
        }
        zzY();
    }

    private final void zzJ() {
        this.zzv.zzc(this.zzu);
        if (this.zzv.zzg) {
            zzjk zzjkVar = this.zzM;
            zzjkVar.zza.zzT(this.zzv);
            this.zzv = new zzkx(this.zzu);
        }
    }

    private final void zzK() throws zziz {
        int i;
        float f = this.zzn.zzc().zzc;
        zzll zzllVar = this.zzq;
        zzli zzliVarZzf = zzllVar.zzf();
        boolean z = true;
        for (zzli zzliVarZze = zzllVar.zze(); zzliVarZze != null && zzliVarZze.zzd; zzliVarZze = zzliVarZze.zzg()) {
            zzyp zzypVarZzj = zzliVarZze.zzj(f, this.zzu.zza);
            zzyp zzypVarZzi = zzliVarZze.zzi();
            boolean z2 = false;
            if (zzypVarZzi != null) {
                if (zzypVarZzi.zzc.length == zzypVarZzj.zzc.length) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= zzypVarZzj.zzc.length) {
                            if (zzliVarZze != zzliVarZzf) {
                                z2 = true;
                            }
                            z &= z2;
                        } else if (zzypVarZzj.zza(zzypVarZzi, i2)) {
                            i2++;
                        }
                    }
                }
            }
            if (z) {
                zzll zzllVar2 = this.zzq;
                zzli zzliVarZze2 = zzllVar2.zze();
                boolean zZzn = zzllVar2.zzn(zzliVarZze2);
                int length = this.zza.length;
                boolean[] zArr = new boolean[2];
                long jZzb = zzliVarZze2.zzb(zzypVarZzj, this.zzu.zzr, zZzn, zArr);
                zzly zzlyVar = this.zzu;
                boolean z3 = (zzlyVar.zze == 4 || jZzb == zzlyVar.zzr) ? false : true;
                zzly zzlyVar2 = this.zzu;
                i = 2;
                this.zzu = zzz(zzlyVar2.zzb, jZzb, zzlyVar2.zzc, zzlyVar2.zzd, z3, 5);
                if (z3) {
                    zzO(jZzb);
                }
                int length2 = this.zza.length;
                boolean[] zArr2 = new boolean[2];
                int i3 = 0;
                while (true) {
                    zzmf[] zzmfVarArr = this.zza;
                    int length3 = zzmfVarArr.length;
                    if (i3 >= 2) {
                        break;
                    }
                    zzmf zzmfVar = zzmfVarArr[i3];
                    boolean zZzaf = zzaf(zzmfVar);
                    zArr2[i3] = zZzaf;
                    zzwh zzwhVar = zzliVarZze2.zzc[i3];
                    if (zZzaf) {
                        if (zzwhVar != zzmfVar.zzo()) {
                            zzA(zzmfVar);
                        } else if (zArr[i3]) {
                            zzmfVar.zzI(this.zzH);
                        }
                    }
                    i3++;
                }
                zzC(zArr2, this.zzH);
            } else {
                i = 2;
                this.zzq.zzn(zzliVarZze);
                if (zzliVarZze.zzd) {
                    zzliVarZze.zza(zzypVarZzj, Math.max(zzliVarZze.zzf.zzb, this.zzH - zzliVarZze.zze()), false);
                }
            }
            zzE(true);
            if (this.zzu.zze != 4) {
                zzI();
                zzaa();
                this.zzh.zzi(i);
                return;
            }
            return;
        }
    }

    private final void zzL() throws zziz {
        zzK();
        zzR(true);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a3 A[PHI: r2 r6 r8
  0x00a3: PHI (r2v2 com.google.android.gms.internal.ads.zzur) = (r2v1 com.google.android.gms.internal.ads.zzur), (r2v19 com.google.android.gms.internal.ads.zzur) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]
  0x00a3: PHI (r6v3 long) = (r6v2 long), (r6v10 long) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]
  0x00a3: PHI (r8v3 long) = (r8v2 long), (r8v6 long) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ee A[PHI: r0
  0x00ee: PHI (r0v11 com.google.android.gms.internal.ads.zzcx) = 
  (r0v10 com.google.android.gms.internal.ads.zzcx)
  (r0v10 com.google.android.gms.internal.ads.zzcx)
  (r0v15 com.google.android.gms.internal.ads.zzcx)
  (r0v15 com.google.android.gms.internal.ads.zzcx)
 binds: [B:36:0x00b2, B:38:0x00b6, B:40:0x00c7, B:42:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    private final void zzM(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        zzcx zzcxVar;
        zzur zzurVar;
        this.zzh.zzf(2);
        this.zzK = null;
        zzac(false, true);
        this.zzn.zzi();
        this.zzH = 1000000000000L;
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        for (int i = 0; i < 2; i++) {
            try {
                zzA(zzmfVarArr[i]);
            } catch (zziz | RuntimeException e) {
                zzff.zzd("ExoPlayerImplInternal", "Disable failed.", e);
            }
        }
        if (z) {
            zzmf[] zzmfVarArr2 = this.zza;
            int length2 = zzmfVarArr2.length;
            for (int i2 = 0; i2 < 2; i2++) {
                zzmf zzmfVar = zzmfVarArr2[i2];
                if (this.zzb.remove(zzmfVar)) {
                    try {
                        zzmfVar.zzH();
                    } catch (RuntimeException e2) {
                        zzff.zzd("ExoPlayerImplInternal", "Reset failed.", e2);
                    }
                }
            }
        }
        this.zzF = 0;
        zzly zzlyVar = this.zzu;
        zzur zzurVar2 = zzlyVar.zzb;
        long jLongValue = zzlyVar.zzr;
        long j = (this.zzu.zzb.zzb() || zzah(this.zzu, this.zzl)) ? this.zzu.zzc : this.zzu.zzr;
        if (z2) {
            this.zzG = null;
            Pair pairZzx = zzx(this.zzu.zza);
            zzurVar2 = (zzur) pairZzx.first;
            jLongValue = ((Long) pairZzx.second).longValue();
            j = -9223372036854775807L;
            z5 = zzurVar2.equals(this.zzu.zzb) ? false : true;
        }
        long j2 = jLongValue;
        long j3 = j;
        this.zzq.zzj();
        this.zzB = false;
        zzcx zzcxVarZzx = this.zzu.zza;
        if (z3 && (zzcxVarZzx instanceof zzmd)) {
            zzcxVarZzx = ((zzmd) zzcxVarZzx).zzx(this.zzr.zzq());
            if (zzurVar2.zzb != -1) {
                zzcxVarZzx.zzn(zzurVar2.zza, this.zzl);
                zzcu zzcuVar = this.zzl;
                zzcw zzcwVar = this.zzk;
                zzcxVarZzx.zze(zzcuVar.zzd, zzcwVar, 0L);
                if (zzcwVar.zzb()) {
                    zzcxVar = zzcxVarZzx;
                    zzurVar = new zzur(zzurVar2.zza, zzurVar2.zzd);
                } else {
                    zzcxVar = zzcxVarZzx;
                    zzurVar = zzurVar2;
                }
            } else {
                zzcxVar = zzcxVarZzx;
                zzurVar = zzurVar2;
            }
        } else {
            zzcxVar = zzcxVarZzx;
            zzurVar = zzurVar2;
        }
        zzly zzlyVar2 = this.zzu;
        int i3 = zzlyVar2.zze;
        zziz zzizVar = z4 ? null : zzlyVar2.zzf;
        zzws zzwsVar = z5 ? zzws.zza : zzlyVar2.zzh;
        zzyp zzypVar = z5 ? this.zze : this.zzu.zzi;
        List listZzl = z5 ? zzgaa.zzl() : this.zzu.zzj;
        zzly zzlyVar3 = this.zzu;
        this.zzu = new zzly(zzcxVar, zzurVar, j3, j2, i3, zzizVar, false, zzwsVar, zzypVar, listZzl, zzurVar, zzlyVar3.zzl, zzlyVar3.zzm, zzlyVar3.zzn, j2, 0L, j2, 0L, false);
        if (z3) {
            this.zzr.zzh();
        }
    }

    private final void zzN() {
        zzli zzliVarZze = this.zzq.zze();
        boolean z = false;
        if (zzliVarZze != null && zzliVarZze.zzf.zzh && this.zzx) {
            z = true;
        }
        this.zzy = z;
    }

    private final void zzO(long j) throws zziz {
        zzli zzliVarZze = this.zzq.zze();
        long jZze = j + (zzliVarZze == null ? 1000000000000L : zzliVarZze.zze());
        this.zzH = jZze;
        this.zzn.zzf(jZze);
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        for (int i = 0; i < 2; i++) {
            zzmf zzmfVar = zzmfVarArr[i];
            if (zzaf(zzmfVar)) {
                zzmfVar.zzI(this.zzH);
            }
        }
        for (zzli zzliVarZze2 = this.zzq.zze(); zzliVarZze2 != null; zzliVarZze2 = zzliVarZze2.zzg()) {
            for (zzyi zzyiVar : zzliVarZze2.zzi().zzc) {
            }
        }
    }

    private final void zzP(zzcx zzcxVar, zzcx zzcxVar2) {
        if (zzcxVar.zzo() && zzcxVar2.zzo()) {
            return;
        }
        int size = this.zzo.size() - 1;
        if (size < 0) {
            Collections.sort(this.zzo);
            return;
        }
        zzkw zzkwVar = (zzkw) this.zzo.get(size);
        Object obj = zzkwVar.zzb;
        zzmb zzmbVar = zzkwVar.zza;
        int i = zzfy.zza;
        zzmb zzmbVar2 = zzkwVar.zza;
        throw null;
    }

    private final void zzQ(long j, long j2) {
        this.zzh.zzj(2, j + j2);
    }

    private final void zzR(boolean z) throws zziz {
        zzur zzurVar = this.zzq.zze().zzf.zza;
        long jZzw = zzw(zzurVar, this.zzu.zzr, true, false);
        if (jZzw != this.zzu.zzr) {
            zzly zzlyVar = this.zzu;
            this.zzu = zzz(zzurVar, jZzw, zzlyVar.zzc, zzlyVar.zzd, z, 5);
        }
    }

    private final void zzS(zzcg zzcgVar) {
        this.zzh.zzf(16);
        this.zzn.zzg(zzcgVar);
    }

    private final void zzT(boolean z, int i, boolean z2, int i2) throws zziz {
        this.zzv.zza(z2 ? 1 : 0);
        this.zzv.zzb(i2);
        this.zzu = this.zzu.zzc(z, i);
        zzac(false, false);
        for (zzli zzliVarZze = this.zzq.zze(); zzliVarZze != null; zzliVarZze = zzliVarZze.zzg()) {
            for (zzyi zzyiVar : zzliVarZze.zzi().zzc) {
            }
        }
        if (!zzai()) {
            zzX();
            zzaa();
            return;
        }
        int i3 = this.zzu.zze;
        if (i3 == 3) {
            zzV();
            this.zzh.zzi(2);
        } else if (i3 == 2) {
            this.zzh.zzi(2);
        }
    }

    private final void zzU(int i) {
        zzly zzlyVar = this.zzu;
        if (zzlyVar.zze != i) {
            if (i != 2) {
                this.zzL = -9223372036854775807L;
            }
            this.zzu = zzlyVar.zze(i);
        }
    }

    private final void zzV() throws zziz {
        zzac(false, false);
        this.zzn.zzh();
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        for (int i = 0; i < 2; i++) {
            zzmf zzmfVar = zzmfVarArr[i];
            if (zzaf(zzmfVar)) {
                zzmfVar.zzN();
            }
        }
    }

    private final void zzW(boolean z, boolean z2) {
        zzM(z || !this.zzE, false, true, false);
        this.zzv.zza(z2 ? 1 : 0);
        this.zzf.zzd();
        zzU(1);
    }

    private final void zzX() throws zziz {
        this.zzn.zzi();
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        for (int i = 0; i < 2; i++) {
            zzmf zzmfVar = zzmfVarArr[i];
            if (zzaf(zzmfVar)) {
                zzam(zzmfVar);
            }
        }
    }

    private final void zzY() {
        zzli zzliVarZzd = this.zzq.zzd();
        boolean z = this.zzB || (zzliVarZzd != null && zzliVarZzd.zza.zzp());
        zzly zzlyVar = this.zzu;
        if (z != zzlyVar.zzg) {
            zzcx zzcxVar = zzlyVar.zza;
            zzur zzurVar = zzlyVar.zzb;
            long j = zzlyVar.zzc;
            long j2 = zzlyVar.zzd;
            int i = zzlyVar.zze;
            zziz zzizVar = zzlyVar.zzf;
            zzws zzwsVar = zzlyVar.zzh;
            zzyp zzypVar = zzlyVar.zzi;
            List list = zzlyVar.zzj;
            zzur zzurVar2 = zzlyVar.zzk;
            boolean z2 = zzlyVar.zzl;
            int i2 = zzlyVar.zzm;
            zzcg zzcgVar = zzlyVar.zzn;
            long j3 = zzlyVar.zzp;
            long j4 = zzlyVar.zzq;
            long j5 = zzlyVar.zzr;
            long j6 = zzlyVar.zzs;
            boolean z3 = zzlyVar.zzo;
            this.zzu = new zzly(zzcxVar, zzurVar, j, j2, i, zzizVar, z, zzwsVar, zzypVar, list, zzurVar2, z2, i2, zzcgVar, j3, j4, j5, j6, false);
        }
    }

    private final void zzZ(zzur zzurVar, zzws zzwsVar, zzyp zzypVar) {
        zzcx zzcxVar = this.zzu.zza;
        zzyi[] zzyiVarArr = zzypVar.zzc;
        this.zzf.zze(zzcxVar, zzurVar, this.zza, zzwsVar, zzyiVarArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ad, code lost:
    
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzaa() throws com.google.android.gms.internal.ads.zziz {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkz.zzaa():void");
    }

    private final void zzab(zzcx zzcxVar, zzur zzurVar, zzcx zzcxVar2, zzur zzurVar2, long j, boolean z) throws zziz {
        if (!zzaj(zzcxVar, zzurVar)) {
            zzcg zzcgVar = zzurVar.zzb() ? zzcg.zza : this.zzu.zzn;
            if (this.zzn.zzc().equals(zzcgVar)) {
                return;
            }
            zzS(zzcgVar);
            zzH(this.zzu.zzn, zzcgVar.zzc, false, false);
            return;
        }
        zzcxVar.zze(zzcxVar.zzn(zzurVar.zza, this.zzl).zzd, this.zzk, 0L);
        zziu zziuVar = this.zzN;
        zzbf zzbfVar = this.zzk.zzl;
        int i = zzfy.zza;
        zziuVar.zzd(zzbfVar);
        if (j != -9223372036854775807L) {
            this.zzN.zze(zzs(zzcxVar, zzurVar.zza, j));
            return;
        }
        if (!zzfy.zzF(!zzcxVar2.zzo() ? zzcxVar2.zze(zzcxVar2.zzn(zzurVar2.zza, this.zzl).zzd, this.zzk, 0L).zzc : null, this.zzk.zzc) || z) {
            this.zzN.zze(-9223372036854775807L);
        }
    }

    private final void zzac(boolean z, boolean z2) {
        this.zzz = z;
        this.zzA = z2 ? -9223372036854775807L : SystemClock.elapsedRealtime();
    }

    private final synchronized void zzad(zzfxu zzfxuVar, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j;
        boolean z = false;
        while (true) {
            boolean z2 = ((zzkp) zzfxuVar).zza.zzw;
            Boolean.valueOf(z2).getClass();
            if (z2 || j <= 0) {
                break;
            }
            try {
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jElapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private final boolean zzae() {
        zzli zzliVarZzd = this.zzq.zzd();
        return (zzliVarZzd == null || zzliVarZzd.zzd() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean zzaf(zzmf zzmfVar) {
        return zzmfVar.zzbf() != 0;
    }

    private final boolean zzag() {
        zzli zzliVarZze = this.zzq.zze();
        long j = zzliVarZze.zzf.zze;
        if (!zzliVarZze.zzd) {
            return false;
        }
        if (j == -9223372036854775807L || this.zzu.zzr < j) {
            return true;
        }
        return !zzai();
    }

    private static boolean zzah(zzly zzlyVar, zzcu zzcuVar) {
        zzur zzurVar = zzlyVar.zzb;
        zzcx zzcxVar = zzlyVar.zza;
        return zzcxVar.zzo() || zzcxVar.zzn(zzurVar.zza, zzcuVar).zzg;
    }

    private final boolean zzai() {
        zzly zzlyVar = this.zzu;
        return zzlyVar.zzl && zzlyVar.zzm == 0;
    }

    private final boolean zzaj(zzcx zzcxVar, zzur zzurVar) {
        if (!zzurVar.zzb() && !zzcxVar.zzo()) {
            zzcxVar.zze(zzcxVar.zzn(zzurVar.zza, this.zzl).zzd, this.zzk, 0L);
            if (this.zzk.zzb()) {
                zzcw zzcwVar = this.zzk;
                if (zzcwVar.zzj && zzcwVar.zzg != -9223372036854775807L) {
                    return true;
                }
            }
        }
        return false;
    }

    private static zzam[] zzak(zzyi zzyiVar) {
        int iZzc = zzyiVar != null ? zzyiVar.zzc() : 0;
        zzam[] zzamVarArr = new zzam[iZzc];
        for (int i = 0; i < iZzc; i++) {
            zzamVarArr[i] = zzyiVar.zzd(i);
        }
        return zzamVarArr;
    }

    private static final void zzal(zzmb zzmbVar) throws zziz {
        zzmbVar.zzj();
        try {
            zzmbVar.zzc().zzt(zzmbVar.zza(), zzmbVar.zzg());
        } finally {
            zzmbVar.zzh(true);
        }
    }

    private static final void zzam(zzmf zzmfVar) {
        if (zzmfVar.zzbf() == 2) {
            zzmfVar.zzO();
        }
    }

    private static final void zzan(zzmf zzmfVar, long j) {
        zzmfVar.zzJ();
        if (zzmfVar instanceof zzww) {
            throw null;
        }
    }

    public static /* synthetic */ zzli zzd(zzkz zzkzVar, zzlj zzljVar, long j) {
        zzlc zzlcVar = zzkzVar.zzf;
        zzyo zzyoVar = zzkzVar.zzd;
        zzyx zzyxVarZzi = zzlcVar.zzi();
        zzyp zzypVar = zzkzVar.zze;
        return new zzli(zzkzVar.zzc, j, zzyoVar, zzyxVarZzi, zzkzVar.zzr, zzljVar, zzypVar);
    }

    static Object zzf(zzcw zzcwVar, zzcu zzcuVar, int i, boolean z, Object obj, zzcx zzcxVar, zzcx zzcxVar2) {
        int iZza = zzcxVar.zza(obj);
        int iZzb = zzcxVar.zzb();
        int iZzi = iZza;
        int iZza2 = -1;
        for (int i2 = 0; i2 < iZzb && iZza2 == -1; i2++) {
            iZzi = zzcxVar.zzi(iZzi, zzcuVar, zzcwVar, i, z);
            if (iZzi == -1) {
                iZza2 = -1;
                break;
            }
            iZza2 = zzcxVar2.zza(zzcxVar.zzf(iZzi));
        }
        if (iZza2 == -1) {
            return null;
        }
        return zzcxVar2.zzf(iZza2);
    }

    static final /* synthetic */ void zzr(zzmb zzmbVar) {
        try {
            zzal(zzmbVar);
        } catch (zziz e) {
            zzff.zzd("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private final long zzs(zzcx zzcxVar, Object obj, long j) {
        zzcxVar.zze(zzcxVar.zzn(obj, this.zzl).zzd, this.zzk, 0L);
        zzcw zzcwVar = this.zzk;
        if (zzcwVar.zzg != -9223372036854775807L && zzcwVar.zzb()) {
            zzcw zzcwVar2 = this.zzk;
            if (zzcwVar2.zzj) {
                long j2 = zzcwVar2.zzh;
                return zzfy.zzq((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - this.zzk.zzg) - j;
            }
        }
        return -9223372036854775807L;
    }

    private final long zzt() {
        return zzu(this.zzu.zzp);
    }

    private final long zzu(long j) {
        zzli zzliVarZzd = this.zzq.zzd();
        if (zzliVarZzd == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.zzH - zzliVarZzd.zze()));
    }

    private final long zzv(zzur zzurVar, long j, boolean z) throws zziz {
        zzll zzllVar = this.zzq;
        return zzw(zzurVar, j, zzllVar.zze() != zzllVar.zzf(), z);
    }

    private final long zzw(zzur zzurVar, long j, boolean z, boolean z2) throws zziz {
        zzX();
        zzac(false, true);
        if (z2 || this.zzu.zze == 3) {
            zzU(2);
        }
        zzli zzliVarZze = this.zzq.zze();
        zzli zzliVarZzg = zzliVarZze;
        while (zzliVarZzg != null && !zzurVar.equals(zzliVarZzg.zzf.zza)) {
            zzliVarZzg = zzliVarZzg.zzg();
        }
        if (z || zzliVarZze != zzliVarZzg || (zzliVarZzg != null && zzliVarZzg.zze() + j < 0)) {
            zzmf[] zzmfVarArr = this.zza;
            int length = zzmfVarArr.length;
            for (int i = 0; i < 2; i++) {
                zzA(zzmfVarArr[i]);
            }
            if (zzliVarZzg != null) {
                while (this.zzq.zze() != zzliVarZzg) {
                    this.zzq.zza();
                }
                this.zzq.zzn(zzliVarZzg);
                zzliVarZzg.zzp(1000000000000L);
                zzB();
            }
        }
        if (zzliVarZzg != null) {
            this.zzq.zzn(zzliVarZzg);
            if (!zzliVarZzg.zzd) {
                zzliVarZzg.zzf = zzliVarZzg.zzf.zzb(j);
            } else if (zzliVarZzg.zze) {
                j = zzliVarZzg.zza.zze(j);
                zzliVarZzg.zza.zzj(j - this.zzm, false);
            }
            zzO(j);
            zzI();
        } else {
            this.zzq.zzj();
            zzO(j);
        }
        zzE(false);
        this.zzh.zzi(2);
        return j;
    }

    private final Pair zzx(zzcx zzcxVar) {
        long j = 0;
        if (zzcxVar.zzo()) {
            return Pair.create(zzly.zzh(), 0L);
        }
        Pair pairZzl = zzcxVar.zzl(this.zzk, this.zzl, zzcxVar.zzg(this.zzD), -9223372036854775807L);
        zzur zzurVarZzi = this.zzq.zzi(zzcxVar, pairZzl.first, 0L);
        long jLongValue = ((Long) pairZzl.second).longValue();
        if (zzurVarZzi.zzb()) {
            zzcxVar.zzn(zzurVarZzi.zza, this.zzl);
            if (zzurVarZzi.zzc == this.zzl.zze(zzurVarZzi.zzb)) {
                this.zzl.zzj();
            }
        } else {
            j = jLongValue;
        }
        return Pair.create(zzurVarZzi, Long.valueOf(j));
    }

    private static Pair zzy(zzcx zzcxVar, zzky zzkyVar, boolean z, int i, boolean z2, zzcw zzcwVar, zzcu zzcuVar) {
        zzcx zzcxVar2 = zzkyVar.zza;
        if (zzcxVar.zzo()) {
            return null;
        }
        zzcx zzcxVar3 = true == zzcxVar2.zzo() ? zzcxVar : zzcxVar2;
        try {
            Pair pairZzl = zzcxVar3.zzl(zzcwVar, zzcuVar, zzkyVar.zzb, zzkyVar.zzc);
            if (zzcxVar.equals(zzcxVar3)) {
                return pairZzl;
            }
            if (zzcxVar.zza(pairZzl.first) != -1) {
                return (zzcxVar3.zzn(pairZzl.first, zzcuVar).zzg && zzcxVar3.zze(zzcuVar.zzd, zzcwVar, 0L).zzp == zzcxVar3.zza(pairZzl.first)) ? zzcxVar.zzl(zzcwVar, zzcuVar, zzcxVar.zzn(pairZzl.first, zzcuVar).zzd, zzkyVar.zzc) : pairZzl;
            }
            Object objZzf = zzf(zzcwVar, zzcuVar, i, z2, pairZzl.first, zzcxVar3, zzcxVar);
            if (objZzf != null) {
                return zzcxVar.zzl(zzcwVar, zzcuVar, zzcxVar.zzn(objZzf, zzcuVar).zzd, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00eb  */
    private final zzly zzz(zzur zzurVar, long j, long j2, long j3, boolean z, int i) {
        List listZzl;
        zzyp zzypVar;
        zzws zzwsVar;
        int i2 = 0;
        this.zzJ = (!this.zzJ && j == this.zzu.zzr && zzurVar.equals(this.zzu.zzb)) ? false : true;
        zzN();
        zzly zzlyVar = this.zzu;
        zzws zzwsVarZzh = zzlyVar.zzh;
        zzyp zzypVarZzi = zzlyVar.zzi;
        List list = zzlyVar.zzj;
        if (!this.zzr.zzj()) {
            if (zzurVar.equals(this.zzu.zzb)) {
                listZzl = list;
            } else {
                zzypVar = this.zze;
                zzwsVar = zzws.zza;
                listZzl = zzgaa.zzl();
            }
            if (z) {
                this.zzv.zzd(i);
            }
            return this.zzu.zzb(zzurVar, j, j2, j3, zzt(), zzwsVar, zzypVar, listZzl);
        }
        zzli zzliVarZze = this.zzq.zze();
        zzwsVarZzh = zzliVarZze == null ? zzws.zza : zzliVarZze.zzh();
        zzypVarZzi = zzliVarZze == null ? this.zze : zzliVarZze.zzi();
        zzyi[] zzyiVarArr = zzypVarZzi.zzc;
        zzfzx zzfzxVar = new zzfzx();
        boolean z2 = false;
        for (zzyi zzyiVar : zzyiVarArr) {
            if (zzyiVar != null) {
                zzby zzbyVar = zzyiVar.zzd(0).zzk;
                if (zzbyVar == null) {
                    zzfzxVar.zzf(new zzby(-9223372036854775807L, new zzbx[0]));
                } else {
                    zzfzxVar.zzf(zzbyVar);
                    z2 = true;
                }
            }
        }
        zzgaa zzgaaVarZzi = z2 ? zzfzxVar.zzi() : zzgaa.zzl();
        if (zzliVarZze != null) {
            zzlj zzljVar = zzliVarZze.zzf;
            if (zzljVar.zzc != j2) {
                zzliVarZze.zzf = zzljVar.zza(j2);
            }
        }
        zzli zzliVarZze2 = this.zzq.zze();
        if (zzliVarZze2 != null) {
            zzyp zzypVarZzi2 = zzliVarZze2.zzi();
            while (true) {
                int length = this.zza.length;
                if (i2 >= 2) {
                    break;
                }
                if (zzypVarZzi2.zzb(i2)) {
                    if (this.zza[i2].zzbj() != 1) {
                        break;
                    }
                    int i3 = zzypVarZzi2.zzb[i2].zzb;
                }
                i2++;
            }
        }
        listZzl = zzgaaVarZzi;
        zzwsVar = zzwsVarZzh;
        zzypVar = zzypVarZzi;
        if (z) {
            this.zzv.zzd(i);
        }
        return this.zzu.zzb(zzurVar, j, j2, j3, zzt(), zzwsVar, zzypVar, listZzl);
    }

    /* JADX WARN: Code duplicated, block: B:207:0x0482  */
    /* JADX WARN: Code duplicated, block: B:333:0x06e2 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:335:0x06e8 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:400:0x07d8 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:402:0x07df A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:404:0x07e3 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:406:0x07e9  */
    /* JADX WARN: Code duplicated, block: B:407:0x07ec  */
    /* JADX WARN: Code duplicated, block: B:408:0x07ee  */
    /* JADX WARN: Code duplicated, block: B:409:0x07f0 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:411:0x07f4 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:413:0x0808 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:414:0x0811  */
    /* JADX WARN: Code duplicated, block: B:420:0x082a  */
    /* JADX WARN: Code duplicated, block: B:426:0x083b  */
    /* JADX WARN: Code duplicated, block: B:434:0x0875 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:435:0x0879 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:437:0x0880 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:439:0x0884 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:441:0x088a  */
    /* JADX WARN: Code duplicated, block: B:442:0x088b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:443:0x088d A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:445:0x089d A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:447:0x08a5 A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:449:0x08af A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, LOOP:12: B:448:0x08ad->B:449:0x08af, LOOP_END, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:478:0x092c A[Catch: RuntimeException -> 0x09a8, IOException -> 0x09d2, zztt -> 0x09da, zzgx -> 0x09e2, zzcc -> 0x09ea, zzrq -> 0x0a01, zziz -> 0x0a0b, TryCatch #8 {zzcc -> 0x09ea, zzgx -> 0x09e2, zziz -> 0x0a0b, zzrq -> 0x0a01, zztt -> 0x09da, IOException -> 0x09d2, RuntimeException -> 0x09a8, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x002e, B:9:0x0033, B:10:0x0038, B:14:0x003f, B:16:0x0048, B:18:0x0056, B:19:0x005e, B:20:0x0069, B:21:0x007d, B:22:0x0095, B:23:0x00b1, B:25:0x00c0, B:26:0x00c4, B:27:0x00d5, B:29:0x00e4, B:30:0x0100, B:31:0x0113, B:32:0x011c, B:34:0x012e, B:35:0x013a, B:36:0x014a, B:38:0x0156, B:41:0x0161, B:42:0x0168, B:43:0x0175, B:47:0x017c, B:49:0x0184, B:51:0x0188, B:53:0x018e, B:55:0x0196, B:57:0x019e, B:58:0x01a1, B:60:0x01a6, B:67:0x01b3, B:68:0x01b4, B:72:0x01bb, B:74:0x01c9, B:75:0x01cc, B:76:0x01d1, B:78:0x01e1, B:79:0x01e4, B:80:0x01e9, B:81:0x01ee, B:83:0x01fa, B:84:0x0206, B:86:0x0212, B:88:0x023e, B:89:0x025e, B:90:0x0262, B:91:0x0266, B:93:0x026b, B:94:0x027c, B:96:0x0288, B:97:0x028b, B:104:0x0296, B:105:0x0297, B:107:0x029d, B:108:0x02a4, B:109:0x02b5, B:111:0x02dc, B:177:0x03f3, B:161:0x03c0, B:160:0x03bc, B:186:0x0404, B:187:0x0411, B:112:0x02fe, B:116:0x0311, B:118:0x0321, B:120:0x0338, B:122:0x0342, B:188:0x0412, B:190:0x0426, B:193:0x0430, B:195:0x043f, B:197:0x044b, B:199:0x0460, B:200:0x0465, B:201:0x0469, B:203:0x046d, B:205:0x047a, B:277:0x05d6, B:279:0x05de, B:281:0x05e6, B:284:0x05eb, B:285:0x05f7, B:287:0x05fd, B:289:0x0605, B:292:0x0615, B:294:0x061b, B:295:0x063b, B:297:0x0641, B:299:0x0646, B:301:0x064b, B:303:0x064f, B:305:0x0655, B:307:0x0659, B:309:0x0661, B:311:0x0667, B:313:0x0671, B:316:0x0677, B:317:0x067a, B:319:0x0683, B:321:0x0695, B:323:0x069e, B:325:0x06a6, B:330:0x06b0, B:331:0x06dc, B:333:0x06e2, B:335:0x06e8, B:336:0x06ef, B:208:0x0489, B:210:0x048f, B:213:0x0495, B:216:0x04a0, B:218:0x04a5, B:221:0x04b3, B:223:0x04b9, B:224:0x04c1, B:225:0x04c4, B:227:0x04cc, B:229:0x04da, B:231:0x0516, B:233:0x0520, B:236:0x052b, B:238:0x0533, B:239:0x0536, B:240:0x0539, B:242:0x053f, B:244:0x054e, B:246:0x0554, B:248:0x0560, B:250:0x056a, B:252:0x057b, B:254:0x0581, B:255:0x058c, B:256:0x0591, B:258:0x059c, B:261:0x05a1, B:263:0x05a7, B:265:0x05af, B:267:0x05b5, B:269:0x05bb, B:273:0x05c9, B:275:0x05d0, B:276:0x05d3, B:204:0x0477, B:339:0x06fb, B:343:0x0706, B:345:0x0710, B:346:0x0715, B:348:0x0723, B:349:0x073b, B:351:0x0741, B:353:0x0749, B:355:0x0750, B:359:0x0759, B:364:0x0768, B:370:0x0775, B:372:0x077b, B:382:0x078e, B:384:0x0793, B:386:0x079f, B:388:0x07a5, B:392:0x07b2, B:394:0x07ba, B:396:0x07be, B:397:0x07c9, B:399:0x07cf, B:453:0x08c1, B:456:0x08c9, B:458:0x08ce, B:460:0x08d6, B:462:0x08e4, B:463:0x08eb, B:464:0x08ef, B:466:0x08f5, B:468:0x08fe, B:470:0x0904, B:472:0x090f, B:479:0x0933, B:481:0x0939, B:485:0x0942, B:497:0x0964, B:493:0x0955, B:495:0x0959, B:496:0x095f, B:473:0x0916, B:476:0x0924, B:477:0x092b, B:478:0x092c, B:400:0x07d8, B:402:0x07df, B:404:0x07e3, B:432:0x0869, B:434:0x0875, B:409:0x07f0, B:411:0x07f4, B:413:0x0808, B:415:0x0816, B:417:0x0822, B:421:0x082b, B:423:0x0835, B:429:0x0840, B:435:0x0879, B:437:0x0880, B:439:0x0884, B:443:0x088d, B:445:0x089d, B:447:0x08a5, B:449:0x08af, B:450:0x08b4, B:451:0x08b9, B:452:0x08be, B:385:0x0798, B:498:0x0969, B:502:0x0970, B:503:0x0978, B:507:0x0996), top: B:579:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:599:0x06ef A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:447:0x08a5, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v35, types: [com.google.android.gms.internal.ads.zzhy, com.google.android.gms.internal.ads.zzyw] */
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
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        boolean z;
        boolean z2;
        zzli zzliVarZzf;
        boolean z3;
        boolean z4;
        zzly zzlyVar;
        int i;
        zzli zzliVarZze;
        int i2;
        zzli zzliVarZze2;
        long jZzb;
        zzli zzliVarZzd;
        boolean z5;
        boolean z6;
        zzli zzliVarZze3;
        zzli zzliVarZzg;
        byte b;
        boolean z7;
        zzyp zzypVarZzi;
        int i3;
        zzlj zzljVarZzg;
        long jLongValue;
        long j;
        boolean z8;
        zzur zzurVar;
        zzur zzurVar2;
        Throwable th;
        Throwable th2;
        long j2;
        long jZza;
        long j3;
        zzly zzlyVar2;
        int i4;
        zzly zzlyVarZzz;
        try {
            switch (message.what) {
                case 0:
                    this.zzv.zza(1);
                    zzM(false, false, false, true);
                    this.zzf.zzb();
                    zzU(true != this.zzu.zza.zzo() ? 2 : 4);
                    this.zzr.zzg(this.zzg);
                    this.zzh.zzi(2);
                    z = true;
                    zzJ();
                    return z;
                case 1:
                    zzT(message.arg1 != 0, message.arg2, true, 1);
                    z = true;
                    zzJ();
                    return z;
                case 2:
                    int i5 = 4;
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.zzh.zzf(2);
                    if (!this.zzu.zza.zzo() && this.zzr.zzj()) {
                        this.zzq.zzl(this.zzH);
                        if (this.zzq.zzo() && (zzljVarZzg = this.zzq.zzg(this.zzH, this.zzu)) != null) {
                            zzli zzliVarZzc = this.zzq.zzc(zzljVarZzg);
                            zzliVarZzc.zza.zzl(this, zzljVarZzg.zzb);
                            if (this.zzq.zze() == zzliVarZzc) {
                                zzO(zzljVarZzg.zzb);
                            }
                            zzE(false);
                        }
                        if (this.zzB) {
                            this.zzB = zzae();
                            zzY();
                        } else {
                            zzI();
                        }
                        zzli zzliVarZzf2 = this.zzq.zzf();
                        if (zzliVarZzf2 != null) {
                            if (zzliVarZzf2.zzg() != null && !this.zzy) {
                                zzli zzliVarZzf3 = this.zzq.zzf();
                                if (zzliVarZzf3.zzd) {
                                    int i6 = 0;
                                    while (true) {
                                        zzmf[] zzmfVarArr = this.zza;
                                        int length = zzmfVarArr.length;
                                        if (i6 < 2) {
                                            zzmf zzmfVar = zzmfVarArr[i6];
                                            zzwh zzwhVar = zzliVarZzf3.zzc[i6];
                                            if (zzmfVar.zzo() == zzwhVar) {
                                                if (zzwhVar == null || zzmfVar.zzP()) {
                                                    i6++;
                                                } else {
                                                    zzliVarZzf3.zzg();
                                                    boolean z9 = zzliVarZzf3.zzf.zzf;
                                                }
                                            }
                                        } else if (zzliVarZzf2.zzg().zzd || this.zzH >= zzliVarZzf2.zzg().zzf()) {
                                            zzyp zzypVarZzi2 = zzliVarZzf2.zzi();
                                            zzli zzliVarZzb = this.zzq.zzb();
                                            zzyp zzypVarZzi3 = zzliVarZzb.zzi();
                                            zzcx zzcxVar = this.zzu.zza;
                                            zzyp zzypVar = zzypVarZzi3;
                                            zzab(zzcxVar, zzliVarZzb.zzf.zza, zzcxVar, zzliVarZzf2.zzf.zza, -9223372036854775807L, false);
                                            if (!zzliVarZzb.zzd || zzliVarZzb.zza.zzd() == -9223372036854775807L) {
                                                int i7 = 0;
                                                while (true) {
                                                    int length2 = this.zza.length;
                                                    if (i7 < 2) {
                                                        boolean zZzb = zzypVarZzi2.zzb(i7);
                                                        zzyp zzypVar2 = zzypVar;
                                                        boolean zZzb2 = zzypVar2.zzb(i7);
                                                        if (zZzb && !this.zza[i7].zzQ()) {
                                                            this.zzc[i7].zzbj();
                                                            zzmi zzmiVar = zzypVarZzi2.zzb[i7];
                                                            zzmi zzmiVar2 = zzypVar2.zzb[i7];
                                                            if (!zZzb2 || !zzmiVar2.equals(zzmiVar)) {
                                                                zzan(this.zza[i7], zzliVarZzb.zzf());
                                                            }
                                                        }
                                                        i7++;
                                                        zzypVar = zzypVar2;
                                                    }
                                                }
                                            } else {
                                                long jZzf = zzliVarZzb.zzf();
                                                zzmf[] zzmfVarArr2 = this.zza;
                                                int length3 = zzmfVarArr2.length;
                                                for (int i8 = 0; i8 < 2; i8++) {
                                                    zzmf zzmfVar2 = zzmfVarArr2[i8];
                                                    if (zzmfVar2.zzo() != null) {
                                                        zzan(zzmfVar2, jZzf);
                                                    }
                                                }
                                                if (!zzliVarZzb.zzr()) {
                                                    this.zzq.zzn(zzliVarZzb);
                                                    zzE(false);
                                                    zzI();
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (zzliVarZzf2.zzf.zzi || this.zzy) {
                                int i9 = 0;
                                while (true) {
                                    zzmf[] zzmfVarArr3 = this.zza;
                                    int length4 = zzmfVarArr3.length;
                                    if (i9 < 2) {
                                        zzmf zzmfVar3 = zzmfVarArr3[i9];
                                        zzwh zzwhVar2 = zzliVarZzf2.zzc[i9];
                                        if (zzwhVar2 != null && zzmfVar3.zzo() == zzwhVar2 && zzmfVar3.zzP()) {
                                            long j4 = zzliVarZzf2.zzf.zze;
                                            zzan(zzmfVar3, (j4 == -9223372036854775807L || j4 == Long.MIN_VALUE) ? -9223372036854775807L : zzliVarZzf2.zze() + j4);
                                        }
                                        i9++;
                                    }
                                }
                            }
                        }
                        zzli zzliVarZzf4 = this.zzq.zzf();
                        if (zzliVarZzf4 != null && this.zzq.zze() != zzliVarZzf4 && !zzliVarZzf4.zzg) {
                            zzli zzliVarZzf5 = this.zzq.zzf();
                            zzyp zzypVarZzi4 = zzliVarZzf5.zzi();
                            int i10 = 0;
                            boolean z10 = false;
                            while (true) {
                                zzmf[] zzmfVarArr4 = this.zza;
                                int length5 = zzmfVarArr4.length;
                                if (i10 < 2) {
                                    zzmf zzmfVar4 = zzmfVarArr4[i10];
                                    if (zzaf(zzmfVar4)) {
                                        zzwh zzwhVarZzo = zzmfVar4.zzo();
                                        zzwh zzwhVar3 = zzliVarZzf5.zzc[i10];
                                        if (!zzypVarZzi4.zzb(i10) || zzwhVarZzo != zzwhVar3) {
                                            if (!zzmfVar4.zzQ()) {
                                                zzmfVar4.zzG(zzak(zzypVarZzi4.zzc[i10]), zzliVarZzf5.zzc[i10], zzliVarZzf5.zzf(), zzliVarZzf5.zze(), zzliVarZzf5.zzf.zza);
                                            } else if (zzmfVar4.zzV()) {
                                                zzA(zzmfVar4);
                                            } else {
                                                z10 = true;
                                            }
                                        }
                                    }
                                    i10++;
                                } else if (!z10) {
                                    zzB();
                                }
                            }
                        }
                        boolean z11 = false;
                        while (zzai() && !this.zzy && (zzliVarZze3 = this.zzq.zze()) != null && (zzliVarZzg = zzliVarZze3.zzg()) != null && this.zzH >= zzliVarZzg.zzf() && zzliVarZzg.zzg) {
                            if (z11) {
                                zzJ();
                            }
                            zzli zzliVarZza = this.zzq.zza();
                            zzliVarZza.getClass();
                            if (this.zzu.zzb.zza.equals(zzliVarZza.zzf.zza.zza)) {
                                zzur zzurVar3 = this.zzu.zzb;
                                b = -1;
                                if (zzurVar3.zzb == -1) {
                                    zzur zzurVar4 = zzliVarZza.zzf.zza;
                                    if (zzurVar4.zzb == -1 && zzurVar3.zze != zzurVar4.zze) {
                                        z7 = true;
                                    }
                                }
                                zzlj zzljVar = zzliVarZza.zzf;
                                zzur zzurVar5 = zzljVar.zza;
                                long j5 = zzljVar.zzb;
                                this.zzu = zzz(zzurVar5, j5, zzljVar.zzc, j5, !z7, 0);
                                zzN();
                                zzaa();
                                zzypVarZzi = this.zzq.zze().zzi();
                                i3 = 0;
                                while (true) {
                                    int length6 = this.zza.length;
                                    if (i3 < 2) {
                                        if (zzypVarZzi.zzb(i3)) {
                                            this.zza[i3].zzs();
                                        }
                                        i3++;
                                    }
                                }
                                z11 = true;
                            } else {
                                b = -1;
                            }
                            z7 = false;
                            zzlj zzljVar2 = zzliVarZza.zzf;
                            zzur zzurVar6 = zzljVar2.zza;
                            long j6 = zzljVar2.zzb;
                            this.zzu = zzz(zzurVar6, j6, zzljVar2.zzc, j6, !z7, 0);
                            zzN();
                            zzaa();
                            zzypVarZzi = this.zzq.zze().zzi();
                            i3 = 0;
                            while (true) {
                                int length7 = this.zza.length;
                                if (i3 < 2) {
                                    if (zzypVarZzi.zzb(i3)) {
                                        this.zza[i3].zzs();
                                    }
                                    i3++;
                                }
                            }
                            z11 = true;
                        }
                        i5 = 4;
                    }
                    int i11 = this.zzu.zze;
                    z = true;
                    if (i11 != 1) {
                        if (i11 != i5) {
                            zzli zzliVarZze4 = this.zzq.zze();
                            if (zzliVarZze4 == null) {
                                zzQ(jUptimeMillis, 10L);
                            } else {
                                int i12 = zzfy.zza;
                                Trace.beginSection("doSomeWork");
                                zzaa();
                                if (zzliVarZze4.zzd) {
                                    long jZzq = zzfy.zzq(SystemClock.elapsedRealtime());
                                    zzliVarZze4.zza.zzj(this.zzu.zzr - this.zzm, false);
                                    z3 = true;
                                    z4 = true;
                                    int i13 = 0;
                                    while (true) {
                                        zzmf[] zzmfVarArr5 = this.zza;
                                        int length8 = zzmfVarArr5.length;
                                        if (i13 < 2) {
                                            zzmf zzmfVar5 = zzmfVarArr5[i13];
                                            if (zzaf(zzmfVar5)) {
                                                zzmfVar5.zzU(this.zzH, jZzq);
                                                boolean z12 = z3 && zzmfVar5.zzV();
                                                boolean z13 = zzliVarZze4.zzc[i13] != zzmfVar5.zzo();
                                                boolean z14 = z13 || (!z13 && zzmfVar5.zzP()) || zzmfVar5.zzW() || zzmfVar5.zzV();
                                                boolean z15 = z4 && z14;
                                                if (!z14) {
                                                    zzmfVar5.zzv();
                                                }
                                                z4 = z15;
                                                z3 = z12;
                                            }
                                            i13++;
                                        }
                                    }
                                } else {
                                    zzliVarZze4.zza.zzk();
                                    z3 = true;
                                    z4 = true;
                                }
                                long j7 = zzliVarZze4.zzf.zze;
                                if (z3 && zzliVarZze4.zzd && (j7 == -9223372036854775807L || j7 <= this.zzu.zzr)) {
                                    if (this.zzy) {
                                        this.zzy = false;
                                        zzT(false, this.zzu.zzm, false, 5);
                                    }
                                    if (zzliVarZze4.zzf.zzi) {
                                        zzU(i5);
                                        zzX();
                                        i = 3;
                                    } else {
                                        zzlyVar = this.zzu;
                                        if (zzlyVar.zze != 2) {
                                            i = 3;
                                            if (this.zzu.zze == 3) {
                                                if (this.zzF == 0) {
                                                    if (!zzag()) {
                                                        zzac(zzai(), false);
                                                        zzU(2);
                                                        if (this.zzz) {
                                                            for (zzliVarZze = this.zzq.zze(); zzliVarZze != null; zzliVarZze = zzliVarZze.zzg()) {
                                                                for (zzyi zzyiVar : zzliVarZze.zzi().zzc) {
                                                                }
                                                            }
                                                            this.zzN.zzc();
                                                        }
                                                        zzX();
                                                    }
                                                } else if (!z4) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i2 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            }
                                        } else if (this.zzF == 0) {
                                            if (z4) {
                                                if (zzlyVar.zzg) {
                                                    zzliVarZze2 = this.zzq.zze();
                                                    if (zzaj(this.zzu.zza, zzliVarZze2.zzf.zza)) {
                                                        jZzb = this.zzN.zzb();
                                                    } else {
                                                        jZzb = -9223372036854775807L;
                                                    }
                                                    zzliVarZzd = this.zzq.zzd();
                                                    if (zzliVarZzd.zzr()) {
                                                        z5 = false;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    if (zzliVarZzd.zzf.zza.zzb()) {
                                                        z6 = false;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                    if (!z5) {
                                                    }
                                                }
                                                i = 3;
                                                zzU(3);
                                                this.zzK = null;
                                                if (zzai()) {
                                                    zzV();
                                                }
                                            }
                                            i = 3;
                                            if (this.zzu.zze == 3) {
                                                if (this.zzF == 0) {
                                                    if (!zzag()) {
                                                        zzac(zzai(), false);
                                                        zzU(2);
                                                        if (this.zzz) {
                                                            while (zzliVarZze != null) {
                                                                while (i2 < r5) {
                                                                }
                                                            }
                                                            this.zzN.zzc();
                                                        }
                                                        zzX();
                                                    }
                                                } else if (!z4) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i2 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            }
                                        } else if (zzag()) {
                                            i = 3;
                                            zzU(3);
                                            this.zzK = null;
                                            if (zzai()) {
                                                zzV();
                                            }
                                        } else {
                                            i = 3;
                                            if (this.zzu.zze == 3) {
                                                if (this.zzF == 0) {
                                                    if (!zzag()) {
                                                        zzac(zzai(), false);
                                                        zzU(2);
                                                        if (this.zzz) {
                                                            while (zzliVarZze != null) {
                                                                while (i2 < r5) {
                                                                }
                                                            }
                                                            this.zzN.zzc();
                                                        }
                                                        zzX();
                                                    }
                                                } else if (!z4) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i2 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    zzlyVar = this.zzu;
                                    if (zzlyVar.zze != 2) {
                                        i = 3;
                                        if (this.zzu.zze == 3) {
                                            if (this.zzF == 0) {
                                                if (!zzag()) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i2 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            } else if (!z4) {
                                                zzac(zzai(), false);
                                                zzU(2);
                                                if (this.zzz) {
                                                    while (zzliVarZze != null) {
                                                        while (i2 < r5) {
                                                        }
                                                    }
                                                    this.zzN.zzc();
                                                }
                                                zzX();
                                            }
                                        }
                                    } else if (this.zzF == 0) {
                                        if (z4) {
                                            if (zzlyVar.zzg) {
                                                zzliVarZze2 = this.zzq.zze();
                                                if (zzaj(this.zzu.zza, zzliVarZze2.zzf.zza)) {
                                                    jZzb = this.zzN.zzb();
                                                } else {
                                                    jZzb = -9223372036854775807L;
                                                }
                                                zzliVarZzd = this.zzq.zzd();
                                                if (zzliVarZzd.zzr() || !zzliVarZzd.zzf.zzi) {
                                                    z5 = false;
                                                } else {
                                                    z5 = true;
                                                }
                                                if (zzliVarZzd.zzf.zza.zzb() || zzliVarZzd.zzd) {
                                                    z6 = false;
                                                } else {
                                                    z6 = true;
                                                }
                                                if (!z5 || z6 || this.zzf.zzh(this.zzu.zza, zzliVarZze2.zzf.zza, zzt(), this.zzn.zzc().zzc, this.zzz, jZzb)) {
                                                }
                                            }
                                            i = 3;
                                            zzU(3);
                                            this.zzK = null;
                                            if (zzai()) {
                                                zzV();
                                            }
                                        }
                                        i = 3;
                                        if (this.zzu.zze == 3) {
                                            if (this.zzF == 0) {
                                                if (!zzag()) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i2 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            } else if (!z4) {
                                                zzac(zzai(), false);
                                                zzU(2);
                                                if (this.zzz) {
                                                    while (zzliVarZze != null) {
                                                        while (i2 < r5) {
                                                        }
                                                    }
                                                    this.zzN.zzc();
                                                }
                                                zzX();
                                            }
                                        }
                                    } else if (zzag()) {
                                        i = 3;
                                        zzU(3);
                                        this.zzK = null;
                                        if (zzai()) {
                                            zzV();
                                        }
                                    } else {
                                        i = 3;
                                        if (this.zzu.zze == 3) {
                                            if (this.zzF == 0) {
                                                if (!zzag()) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i2 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            } else if (!z4) {
                                                zzac(zzai(), false);
                                                zzU(2);
                                                if (this.zzz) {
                                                    while (zzliVarZze != null) {
                                                        while (i2 < r5) {
                                                        }
                                                    }
                                                    this.zzN.zzc();
                                                }
                                                zzX();
                                            }
                                        }
                                    }
                                }
                                int i14 = 2;
                                if (this.zzu.zze == 2) {
                                    int i15 = 0;
                                    while (true) {
                                        zzmf[] zzmfVarArr6 = this.zza;
                                        int length9 = zzmfVarArr6.length;
                                        if (i15 < i14) {
                                            if (zzaf(zzmfVarArr6[i15]) && this.zza[i15].zzo() == zzliVarZze4.zzc[i15]) {
                                                this.zza[i15].zzv();
                                            }
                                            i15++;
                                            i14 = 2;
                                        } else {
                                            zzly zzlyVar3 = this.zzu;
                                            if (zzlyVar3.zzg || zzlyVar3.zzq >= 500000 || !zzae()) {
                                                this.zzL = -9223372036854775807L;
                                            } else if (this.zzL == -9223372036854775807L) {
                                                this.zzL = SystemClock.elapsedRealtime();
                                            } else if (SystemClock.elapsedRealtime() - this.zzL >= 4000) {
                                                throw new IllegalStateException("Playback stuck buffering and not loading");
                                            }
                                        }
                                    }
                                } else {
                                    this.zzL = -9223372036854775807L;
                                }
                                boolean z16 = zzai() && this.zzu.zze == i;
                                boolean z17 = this.zzu.zzo;
                                int i16 = this.zzu.zze;
                                if (i16 != i5) {
                                    if (z16 || i16 == 2) {
                                        zzQ(jUptimeMillis, 10L);
                                    } else if (i16 == i && this.zzF != 0) {
                                        zzQ(jUptimeMillis, 1000L);
                                    }
                                }
                                Trace.endSection();
                            }
                        }
                        z = true;
                    }
                    zzJ();
                    return z;
                case 3:
                    zzky zzkyVar = (zzky) message.obj;
                    this.zzv.zza(1);
                    Pair pairZzy = zzy(this.zzu.zza, zzkyVar, true, this.zzC, this.zzD, this.zzk, this.zzl);
                    if (pairZzy == null) {
                        Pair pairZzx = zzx(this.zzu.zza);
                        zzurVar = (zzur) pairZzx.first;
                        long jLongValue2 = ((Long) pairZzx.second).longValue();
                        j = -9223372036854775807L;
                        z8 = !this.zzu.zza.zzo();
                        jLongValue = jLongValue2;
                    } else {
                        Object obj = pairZzy.first;
                        jLongValue = ((Long) pairZzy.second).longValue();
                        j = zzkyVar.zzc == -9223372036854775807L ? -9223372036854775807L : jLongValue;
                        zzur zzurVarZzi = this.zzq.zzi(this.zzu.zza, obj, jLongValue);
                        if (zzurVarZzi.zzb()) {
                            this.zzu.zza.zzn(zzurVarZzi.zza, this.zzl);
                            if (this.zzl.zze(zzurVarZzi.zzb) == zzurVarZzi.zzc) {
                                this.zzl.zzj();
                            }
                            zzurVar = zzurVarZzi;
                            z8 = true;
                            jLongValue = 0;
                        } else {
                            z8 = zzkyVar.zzc == -9223372036854775807L;
                            zzurVar = zzurVarZzi;
                        }
                    }
                    try {
                        try {
                            if (!this.zzu.zza.zzo()) {
                                if (pairZzy == null) {
                                    if (this.zzu.zze != 1) {
                                        zzU(4);
                                    }
                                    zzM(false, true, false, true);
                                } else {
                                    if (zzurVar.equals(this.zzu.zzb)) {
                                        zzli zzliVarZze5 = this.zzq.zze();
                                        jZza = (zzliVarZze5 == null || !zzliVarZze5.zzd || jLongValue == 0) ? jLongValue : zzliVarZze5.zza.zza(jLongValue, this.zzt);
                                        zzurVar2 = zzurVar;
                                        try {
                                            if (zzfy.zzt(jZza) == zzfy.zzt(this.zzu.zzr) && ((i4 = (zzlyVar2 = this.zzu).zze) == 2 || i4 == 3)) {
                                                long j8 = zzlyVar2.zzr;
                                                zzlyVarZzz = zzz(zzurVar2, j8, j, j8, z8, 2);
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            th = th;
                                            th2 = th;
                                            j2 = jLongValue;
                                            this.zzu = zzz(zzurVar2, j2, j, j2, z8, 2);
                                            throw th2;
                                        }
                                    } else {
                                        zzurVar2 = zzurVar;
                                        jZza = jLongValue;
                                    }
                                    long jZzv = zzv(zzurVar2, jZza, this.zzu.zze == 4);
                                    z8 |= jLongValue != jZzv;
                                    try {
                                        zzly zzlyVar4 = this.zzu;
                                        zzcx zzcxVar2 = zzlyVar4.zza;
                                        zzab(zzcxVar2, zzurVar2, zzcxVar2, zzlyVar4.zzb, j, true);
                                        j3 = jZzv;
                                        zzlyVarZzz = zzz(zzurVar2, j3, j, j3, z8, 2);
                                    } catch (Throwable th4) {
                                        j2 = jZzv;
                                        th2 = th4;
                                        this.zzu = zzz(zzurVar2, j2, j, j2, z8, 2);
                                        throw th2;
                                    }
                                }
                                this.zzu = zzlyVarZzz;
                                z = true;
                                zzJ();
                                return z;
                            }
                            this.zzG = zzkyVar;
                            j3 = jLongValue;
                            zzurVar2 = zzurVar;
                            zzlyVarZzz = zzz(zzurVar2, j3, j, j3, z8, 2);
                            this.zzu = zzlyVarZzz;
                            z = true;
                            zzJ();
                            return z;
                        } catch (Throwable th5) {
                            th = th5;
                            zzurVar2 = zzurVar;
                            th2 = th;
                            j2 = jLongValue;
                            this.zzu = zzz(zzurVar2, j2, j, j2, z8, 2);
                            throw th2;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        zzurVar2 = zzurVar;
                    }
                    break;
                case 4:
                    zzS((zzcg) message.obj);
                    zzG(this.zzn.zzc(), true);
                    z = true;
                    zzJ();
                    return z;
                case 5:
                    this.zzt = (zzmj) message.obj;
                    z = true;
                    zzJ();
                    return z;
                case 6:
                    zzW(false, true);
                    z = true;
                    zzJ();
                    return z;
                case 7:
                    zzM(true, false, true, false);
                    int i17 = 0;
                    while (true) {
                        int length10 = this.zza.length;
                        if (i17 >= 2) {
                            this.zzf.zzc();
                            zzU(1);
                            HandlerThread handlerThread = this.zzi;
                            if (handlerThread != null) {
                                handlerThread.quit();
                            }
                            synchronized (this) {
                                this.zzw = true;
                                notifyAll();
                                break;
                            }
                            return true;
                        }
                        this.zzc[i17].zzp();
                        this.zza[i17].zzF();
                        i17++;
                    }
                    break;
                case 8:
                    if (this.zzq.zzm((zzup) message.obj)) {
                        zzli zzliVarZzd2 = this.zzq.zzd();
                        zzliVarZzd2.zzl(this.zzn.zzc().zzc, this.zzu.zza);
                        zzZ(zzliVarZzd2.zzf.zza, zzliVarZzd2.zzh(), zzliVarZzd2.zzi());
                        if (zzliVarZzd2 == this.zzq.zze()) {
                            zzO(zzliVarZzd2.zzf.zzb);
                            zzB();
                            zzly zzlyVar5 = this.zzu;
                            zzur zzurVar7 = zzlyVar5.zzb;
                            long j9 = zzliVarZzd2.zzf.zzb;
                            this.zzu = zzz(zzurVar7, j9, zzlyVar5.zzc, j9, false, 5);
                        }
                        zzI();
                    }
                    z = true;
                    zzJ();
                    return z;
                case 9:
                    if (this.zzq.zzm((zzup) message.obj)) {
                        this.zzq.zzl(this.zzH);
                        zzI();
                    }
                    z = true;
                    zzJ();
                    return z;
                case 10:
                    zzK();
                    z = true;
                    zzJ();
                    return z;
                case 11:
                    int i18 = message.arg1;
                    this.zzC = i18;
                    if (!this.zzq.zzq(this.zzu.zza, i18)) {
                        zzR(true);
                    }
                    zzE(false);
                    z = true;
                    zzJ();
                    return z;
                case 12:
                    boolean z18 = message.arg1 != 0;
                    this.zzD = z18;
                    if (!this.zzq.zzr(this.zzu.zza, z18)) {
                        zzR(true);
                    }
                    zzE(false);
                    z = true;
                    zzJ();
                    return z;
                case 13:
                    boolean z19 = message.arg1 != 0;
                    AtomicBoolean atomicBoolean = (AtomicBoolean) message.obj;
                    if (this.zzE != z19) {
                        this.zzE = z19;
                        if (!z19) {
                            zzmf[] zzmfVarArr7 = this.zza;
                            int length11 = zzmfVarArr7.length;
                            for (int i19 = 0; i19 < 2; i19++) {
                                zzmf zzmfVar6 = zzmfVarArr7[i19];
                                if (!zzaf(zzmfVar6) && this.zzb.remove(zzmfVar6)) {
                                    zzmfVar6.zzH();
                                }
                            }
                        }
                    }
                    if (atomicBoolean != null) {
                        synchronized (this) {
                            atomicBoolean.set(true);
                            notifyAll();
                            break;
                        }
                    }
                    z = true;
                    zzJ();
                    return z;
                case 14:
                    zzmb zzmbVar = (zzmb) message.obj;
                    if (zzmbVar.zzb() == this.zzj) {
                        zzal(zzmbVar);
                        int i20 = this.zzu.zze;
                        if (i20 == 3 || i20 == 2) {
                            this.zzh.zzi(2);
                        }
                    } else {
                        this.zzh.zzc(15, zzmbVar).zza();
                    }
                    z = true;
                    zzJ();
                    return z;
                case 15:
                    final zzmb zzmbVar2 = (zzmb) message.obj;
                    Looper looperZzb = zzmbVar2.zzb();
                    if (looperZzb.getThread().isAlive()) {
                        this.zzp.zzb(looperZzb, null).zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkq
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzkz.zzr(zzmbVar2);
                            }
                        });
                    } else {
                        zzff.zzf("TAG", "Trying to send message on a dead thread.");
                        zzmbVar2.zzh(false);
                    }
                    z = true;
                    zzJ();
                    return z;
                case 16:
                    zzG((zzcg) message.obj, false);
                    z = true;
                    zzJ();
                    return z;
                case 17:
                    zzku zzkuVar = (zzku) message.obj;
                    this.zzv.zza(1);
                    if (zzkuVar.zzb != -1) {
                        this.zzG = new zzky(new zzmd(zzkuVar.zza, zzkuVar.zzd), zzkuVar.zzb, zzkuVar.zzc);
                    }
                    zzF(this.zzr.zzn(zzkuVar.zza, zzkuVar.zzd), false);
                    z = true;
                    zzJ();
                    return z;
                case 18:
                    zzku zzkuVar2 = (zzku) message.obj;
                    int iZza = message.arg1;
                    this.zzv.zza(1);
                    zzlx zzlxVar = this.zzr;
                    if (iZza == -1) {
                        iZza = zzlxVar.zza();
                    }
                    zzF(zzlxVar.zzk(iZza, zzkuVar2.zza, zzkuVar2.zzd), false);
                    z = true;
                    zzJ();
                    return z;
                case 19:
                    zzkv zzkvVar = (zzkv) message.obj;
                    this.zzv.zza(1);
                    zzlx zzlxVar2 = this.zzr;
                    int i21 = zzkvVar.zza;
                    int i22 = zzkvVar.zzb;
                    int i23 = zzkvVar.zzc;
                    zzwk zzwkVar = zzkvVar.zzd;
                    zzF(zzlxVar2.zzl(0, 0, 0, null), false);
                    z = true;
                    zzJ();
                    return z;
                case 20:
                    int i24 = message.arg1;
                    int i25 = message.arg2;
                    zzwk zzwkVar2 = (zzwk) message.obj;
                    this.zzv.zza(1);
                    zzF(this.zzr.zzm(i24, i25, zzwkVar2), false);
                    z = true;
                    zzJ();
                    return z;
                case 21:
                    zzwk zzwkVar3 = (zzwk) message.obj;
                    this.zzv.zza(1);
                    zzF(this.zzr.zzo(zzwkVar3), false);
                    z = true;
                    zzJ();
                    return z;
                case 22:
                    zzF(this.zzr.zzb(), true);
                    z = true;
                    zzJ();
                    return z;
                case 23:
                    this.zzx = message.arg1 != 0;
                    zzN();
                    if (this.zzy && this.zzq.zzf() != this.zzq.zze()) {
                        zzR(true);
                        zzE(false);
                    }
                    z = true;
                    zzJ();
                    return z;
                case 24:
                default:
                    return false;
                case 25:
                    zzL();
                    z = true;
                    zzJ();
                    return z;
                case 26:
                    zzL();
                    z = true;
                    zzJ();
                    return z;
                case 27:
                    int i26 = message.arg1;
                    int i27 = message.arg2;
                    List list = (List) message.obj;
                    this.zzv.zza(1);
                    zzF(this.zzr.zzc(i26, i27, list), false);
                    z = true;
                    zzJ();
                    return z;
            }
        } catch (zzcc e) {
            zzD(e, e.zzb == 1 ? true != e.zza ? 3003 : 3001 : 1000);
        } catch (zzgx e2) {
            zzD(e2, e2.zza);
        } catch (zziz e3) {
            zziz zzizVarZza = e3;
            if (zzizVarZza.zze == 1 && (zzliVarZzf = this.zzq.zzf()) != null) {
                zzizVarZza = zzizVarZza.zza(zzliVarZzf.zzf.zza);
            }
            if (zzizVarZza.zzk && (this.zzK == null || zzizVarZza.zzb == 5003)) {
                zzff.zzg("ExoPlayerImplInternal", "Recoverable renderer error", zzizVarZza);
                zziz zzizVar = this.zzK;
                if (zzizVar != null) {
                    zzizVar.addSuppressed(zzizVarZza);
                    zzizVarZza = this.zzK;
                } else {
                    this.zzK = zzizVarZza;
                }
                zzew zzewVar = this.zzh;
                zzewVar.zzk(zzewVar.zzc(25, zzizVarZza));
            } else {
                zziz zzizVar2 = this.zzK;
                if (zzizVar2 != null) {
                    zzizVar2.addSuppressed(zzizVarZza);
                    zzizVarZza = this.zzK;
                }
                zziz zzizVar3 = zzizVarZza;
                zzff.zzd("ExoPlayerImplInternal", "Playback error", zzizVar3);
                z = true;
                if (zzizVar3.zze == 1) {
                    zzll zzllVar = this.zzq;
                    if (zzllVar.zze() != zzllVar.zzf()) {
                        while (true) {
                            zzll zzllVar2 = this.zzq;
                            if (zzllVar2.zze() == zzllVar2.zzf()) {
                                break;
                            }
                            this.zzq.zza();
                        }
                        zzli zzliVarZze6 = this.zzq.zze();
                        zzliVarZze6.getClass();
                        zzlj zzljVar3 = zzliVarZze6.zzf;
                        zzur zzurVar8 = zzljVar3.zza;
                        long j10 = zzljVar3.zzb;
                        this.zzu = zzz(zzurVar8, j10, zzljVar3.zzc, j10, true, 0);
                    }
                    z2 = false;
                    z = true;
                } else {
                    z2 = false;
                }
                zzW(z, z2);
                this.zzu = this.zzu.zzd(zzizVar3);
            }
        } catch (zzrq e4) {
            zzD(e4, e4.zza);
        } catch (zztt e5) {
            zzD(e5, PointerIconCompat.TYPE_HAND);
        } catch (IOException e6) {
            zzD(e6, Constants.MAX_URL_LENGTH);
        } catch (RuntimeException e7) {
            zziz zzizVarZzd = zziz.zzd(e7, ((e7 instanceof IllegalStateException) || (e7 instanceof IllegalArgumentException)) ? 1004 : 1000);
            zzff.zzd("ExoPlayerImplInternal", "Playback error", zzizVarZzd);
            zzW(true, false);
            this.zzu = this.zzu.zzd(zzizVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zziw
    public final void zza(zzcg zzcgVar) {
        this.zzh.zzc(16, zzcgVar).zza();
    }

    public final Looper zzb() {
        return this.zzj;
    }

    final /* synthetic */ Boolean zze() {
        return Boolean.valueOf(this.zzw);
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final /* bridge */ /* synthetic */ void zzg(zzwj zzwjVar) {
        this.zzh.zzc(9, (zzup) zzwjVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlw
    public final void zzh() {
        this.zzh.zzi(22);
    }

    @Override // com.google.android.gms.internal.ads.zzuo
    public final void zzi(zzup zzupVar) {
        this.zzh.zzc(8, zzupVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final void zzj() {
        this.zzh.zzi(10);
    }

    public final void zzk() {
        this.zzh.zzb(0).zza();
    }

    public final void zzl(zzcx zzcxVar, int i, long j) {
        this.zzh.zzc(3, new zzky(zzcxVar, i, j)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final synchronized void zzm(zzmb zzmbVar) {
        if (!this.zzw && this.zzj.getThread().isAlive()) {
            this.zzh.zzc(14, zzmbVar).zza();
            return;
        }
        zzff.zzf("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        zzmbVar.zzh(false);
    }

    public final void zzn(boolean z, int i) {
        this.zzh.zzd(1, z ? 1 : 0, i).zza();
    }

    public final void zzo() {
        this.zzh.zzb(6).zza();
    }

    public final synchronized boolean zzp() {
        if (!this.zzw && this.zzj.getThread().isAlive()) {
            this.zzh.zzi(7);
            zzad(new zzkp(this), this.zzs);
            return this.zzw;
        }
        return true;
    }

    public final void zzq(List list, int i, long j, zzwk zzwkVar) {
        this.zzh.zzc(17, new zzku(list, zzwkVar, i, j, null)).zza();
    }
}
