package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgzp;
import com.google.android.gms.internal.ads.zzgzu;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgzu<MessageType extends zzgzu<MessageType, BuilderType>, BuilderType extends zzgzp<MessageType, BuilderType>> extends zzgxt<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzhcq zzc = zzhcq.zzc();

    private final int zza(zzhby zzhbyVar) {
        return zzhbn.zza().zzb(getClass()).zza(this);
    }

    static zzgzu zzaC(Class cls) {
        Map map = zzb;
        zzgzu zzgzuVar = (zzgzu) map.get(cls);
        if (zzgzuVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgzuVar = (zzgzu) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgzuVar == null) {
            zzgzuVar = (zzgzu) ((zzgzu) zzhcz.zzg(cls)).zzb(6, null, null);
            if (zzgzuVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzgzuVar);
        }
        return zzgzuVar;
    }

    protected static zzgzu zzaE(zzgzu zzgzuVar, zzgyl zzgylVar) throws zzhag {
        zzgzf zzgzfVar = zzgzf.zza;
        zzgyt zzgytVarZzl = zzgylVar.zzl();
        zzgzu zzgzuVarZzaD = zzgzuVar.zzaD();
        try {
            zzhby zzhbyVarZzb = zzhbn.zza().zzb(zzgzuVarZzaD.getClass());
            zzhbyVarZzb.zzh(zzgzuVarZzaD, zzgyu.zzq(zzgytVarZzl), zzgzfVar);
            zzhbyVarZzb.zzf(zzgzuVarZzaD);
            try {
                zzgytVarZzl.zzz(0);
                zzc(zzgzuVarZzaD);
                zzc(zzgzuVarZzaD);
                return zzgzuVarZzaD;
            } catch (zzhag e) {
                e.zzh(zzgzuVarZzaD);
                throw e;
            }
        } catch (zzhag e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzhag(e);
            }
            e.zzh(zzgzuVarZzaD);
            throw e;
        } catch (zzhco e3) {
            zzhag zzhagVarZza = e3.zza();
            zzhagVarZza.zzh(zzgzuVarZzaD);
            throw zzhagVarZza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzhag) {
                throw ((zzhag) e4.getCause());
            }
            zzhag zzhagVar = new zzhag(e4);
            zzhagVar.zzh(zzgzuVarZzaD);
            throw zzhagVar;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzhag) {
                throw ((zzhag) e5.getCause());
            }
            throw e5;
        }
    }

    protected static zzgzu zzaF(zzgzu zzgzuVar, byte[] bArr) throws zzhag {
        zzgzu zzgzuVarZzd = zzd(zzgzuVar, bArr, 0, bArr.length, zzgzf.zza);
        zzc(zzgzuVarZzd);
        return zzgzuVarZzd;
    }

    protected static zzgzu zzaG(zzgzu zzgzuVar, zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        zzgyt zzgytVarZzl = zzgylVar.zzl();
        zzgzu zzgzuVarZzaD = zzgzuVar.zzaD();
        try {
            zzhby zzhbyVarZzb = zzhbn.zza().zzb(zzgzuVarZzaD.getClass());
            zzhbyVarZzb.zzh(zzgzuVarZzaD, zzgyu.zzq(zzgytVarZzl), zzgzfVar);
            zzhbyVarZzb.zzf(zzgzuVarZzaD);
            try {
                zzgytVarZzl.zzz(0);
                zzc(zzgzuVarZzaD);
                return zzgzuVarZzaD;
            } catch (zzhag e) {
                e.zzh(zzgzuVarZzaD);
                throw e;
            }
        } catch (zzhag e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzhag(e);
            }
            e.zzh(zzgzuVarZzaD);
            throw e;
        } catch (zzhco e3) {
            zzhag zzhagVarZza = e3.zza();
            zzhagVarZza.zzh(zzgzuVarZzaD);
            throw zzhagVarZza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzhag) {
                throw ((zzhag) e4.getCause());
            }
            zzhag zzhagVar = new zzhag(e4);
            zzhagVar.zzh(zzgzuVarZzaD);
            throw zzhagVar;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzhag) {
                throw ((zzhag) e5.getCause());
            }
            throw e5;
        }
    }

    protected static zzgzu zzaH(zzgzu zzgzuVar, InputStream inputStream, zzgzf zzgzfVar) throws zzhag {
        zzgyt zzgytVarZzH = zzgyt.zzH(inputStream, 4096);
        zzgzu zzgzuVarZzaD = zzgzuVar.zzaD();
        try {
            zzhby zzhbyVarZzb = zzhbn.zza().zzb(zzgzuVarZzaD.getClass());
            zzhbyVarZzb.zzh(zzgzuVarZzaD, zzgyu.zzq(zzgytVarZzH), zzgzfVar);
            zzhbyVarZzb.zzf(zzgzuVarZzaD);
            zzc(zzgzuVarZzaD);
            return zzgzuVarZzaD;
        } catch (zzhag e) {
            e = e;
            if (e.zzl()) {
                e = new zzhag(e);
            }
            e.zzh(zzgzuVarZzaD);
            throw e;
        } catch (zzhco e2) {
            zzhag zzhagVarZza = e2.zza();
            zzhagVarZza.zzh(zzgzuVarZzaD);
            throw zzhagVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzhag) {
                throw ((zzhag) e3.getCause());
            }
            zzhag zzhagVar = new zzhag(e3);
            zzhagVar.zzh(zzgzuVarZzaD);
            throw zzhagVar;
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzhag) {
                throw ((zzhag) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zzgzu zzaI(zzgzu zzgzuVar, byte[] bArr, zzgzf zzgzfVar) throws zzhag {
        zzgzu zzgzuVarZzd = zzd(zzgzuVar, bArr, 0, bArr.length, zzgzfVar);
        zzc(zzgzuVarZzd);
        return zzgzuVarZzd;
    }

    protected static zzgzz zzaJ() {
        return zzgzv.zzf();
    }

    protected static zzgzz zzaK(zzgzz zzgzzVar) {
        int size = zzgzzVar.size();
        return zzgzzVar.zzd(size == 0 ? 10 : size + size);
    }

    protected static zzhac zzaL() {
        return zzhat.zzf();
    }

    protected static zzhac zzaM(zzhac zzhacVar) {
        int size = zzhacVar.size();
        return zzhacVar.zzd(size == 0 ? 10 : size + size);
    }

    protected static zzhad zzaN() {
        return zzhbo.zze();
    }

    protected static zzhad zzaO(zzhad zzhadVar) {
        int size = zzhadVar.size();
        return zzhadVar.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzaQ(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzaR(zzhbe zzhbeVar, String str, Object[] objArr) {
        return new zzhbp(zzhbeVar, str, objArr);
    }

    protected static void zzaU(Class cls, zzgzu zzgzuVar) {
        zzgzuVar.zzaT();
        zzb.put(cls, zzgzuVar);
    }

    private static zzgzu zzc(zzgzu zzgzuVar) throws zzhag {
        if (zzgzuVar == null || zzgzuVar.zzaX()) {
            return zzgzuVar;
        }
        zzhag zzhagVarZza = new zzhco(zzgzuVar).zza();
        zzhagVarZza.zzh(zzgzuVar);
        throw zzhagVarZza;
    }

    private static zzgzu zzd(zzgzu zzgzuVar, byte[] bArr, int i, int i2, zzgzf zzgzfVar) throws zzhag {
        zzgzu zzgzuVarZzaD = zzgzuVar.zzaD();
        try {
            zzhby zzhbyVarZzb = zzhbn.zza().zzb(zzgzuVarZzaD.getClass());
            zzhbyVarZzb.zzi(zzgzuVarZzaD, bArr, 0, i2, new zzgxx(zzgzfVar));
            zzhbyVarZzb.zzf(zzgzuVarZzaD);
            return zzgzuVarZzaD;
        } catch (zzhag e) {
            e = e;
            if (e.zzl()) {
                e = new zzhag(e);
            }
            e.zzh(zzgzuVarZzaD);
            throw e;
        } catch (zzhco e2) {
            zzhag zzhagVarZza = e2.zza();
            zzhagVarZza.zzh(zzgzuVarZzaD);
            throw zzhagVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzhag) {
                throw ((zzhag) e3.getCause());
            }
            zzhag zzhagVar = new zzhag(e3);
            zzhagVar.zzh(zzgzuVarZzaD);
            throw zzhagVar;
        } catch (IndexOutOfBoundsException unused) {
            zzhag zzhagVarZzj = zzhag.zzj();
            zzhagVarZzj.zzh(zzgzuVarZzaD);
            throw zzhagVarZzj;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzhbn.zza().zzb(getClass()).zzj(this, (zzgzu) obj);
    }

    public final int hashCode() {
        if (zzaY()) {
            return zzay();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzay = zzay();
        this.zza = iZzay;
        return iZzay;
    }

    public final String toString() {
        return zzhbg.zza(this, super.toString());
    }

    protected final zzgzp zzaA() {
        return (zzgzp) zzb(5, null, null);
    }

    public final zzgzp zzaB() {
        zzgzp zzgzpVar = (zzgzp) zzb(5, null, null);
        zzgzpVar.zzaj(this);
        return zzgzpVar;
    }

    final zzgzu zzaD() {
        return (zzgzu) zzb(4, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ zzhbd zzaP() {
        return (zzgzp) zzb(5, null, null);
    }

    protected final void zzaS() {
        zzhbn.zza().zzb(getClass()).zzf(this);
        zzaT();
    }

    final void zzaT() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzaV(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final void zzaW(zzgza zzgzaVar) throws IOException {
        zzhbn.zza().zzb(getClass()).zzm(this, zzgzb.zza(zzgzaVar));
    }

    public final boolean zzaX() {
        boolean zBooleanValue = Boolean.TRUE.booleanValue();
        byte bByteValue = ((Byte) zzb(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzhbn.zza().zzb(getClass()).zzk(this);
        if (!zBooleanValue) {
            return zZzk;
        }
        zzb(2, true != zZzk ? null : this, null);
        return zZzk;
    }

    final boolean zzaY() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgxt
    final int zzat(zzhby zzhbyVar) {
        if (zzaY()) {
            int iZza = zzhbyVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzhbyVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    final int zzay() {
        return zzhbn.zza().zzb(getClass()).zzb(this);
    }

    protected abstract Object zzb(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final /* synthetic */ zzhbe zzbk() {
        return (zzgzu) zzb(6, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final int zzaz() {
        int iZza;
        if (zzaY()) {
            iZza = zza(null);
            if (iZza < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
            }
        } else {
            iZza = this.zzd & Integer.MAX_VALUE;
            if (iZza == Integer.MAX_VALUE) {
                iZza = zza(null);
                if (iZza < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza;
            }
        }
        return iZza;
    }
}
