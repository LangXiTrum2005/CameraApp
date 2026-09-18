package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.PointerIconCompat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzavf implements zzave {
    protected static volatile zzawj zza;
    protected MotionEvent zzb;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected DisplayMetrics zzq;
    protected zzawb zzr;
    private double zzs;
    private double zzt;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    private boolean zzu = false;
    protected boolean zzp = false;

    protected zzavf(Context context) {
        try {
            zzatx.zzd();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcz)).booleanValue()) {
                this.zzr = new zzawb();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzj() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        if (this.zzc.isEmpty()) {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzc.clear();
        }
        this.zzb = null;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b4 A[Catch: Exception -> 0x00ee, TryCatch #0 {Exception -> 0x00ee, blocks: (B:45:0x00a7, B:48:0x00b4, B:57:0x00d8, B:58:0x00e8), top: B:73:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:52:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e8 A[Catch: Exception -> 0x00ee, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ee, blocks: (B:45:0x00a7, B:48:0x00b4, B:57:0x00d8, B:58:0x00e8), top: B:73:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final String zzm(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        zzavd zzavdVarZzd;
        String str2;
        int i2;
        Exception exc;
        int i3;
        int i4;
        long jCurrentTimeMillis;
        String strZza;
        int i5;
        int i6;
        zzasg zzasgVarZzc;
        int i7;
        int i8;
        int i9 = i;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcr)).booleanValue();
        zzasg zzasgVarZzb = null;
        if (zBooleanValue) {
            zzavdVarZzd = zza != null ? zza.zzd() : null;
            str2 = "be";
        } else {
            zzavdVarZzd = null;
            str2 = null;
        }
        int i10 = 1;
        try {
            if (i9 == 3) {
                zzasgVarZzb = zzb(context, view, activity);
                try {
                    this.zzu = true;
                    i8 = 1002;
                } catch (Exception e) {
                    exc = e;
                    i2 = 3;
                    i10 = 1;
                    if (!zBooleanValue) {
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (zzasgVarZzb != null) {
                        try {
                            if (((zzatd) zzasgVarZzb.zzal()).zzaz() == 0) {
                                strZza = Integer.toString(5);
                            } else {
                                zzatd zzatdVar = (zzatd) zzasgVarZzb.zzal();
                                int i11 = zzatx.zzc;
                                strZza = zzatx.zza(zzatdVar.zzax(), str);
                                if (zBooleanValue) {
                                    if (i9 == i2) {
                                        i5 = PointerIconCompat.TYPE_CELL;
                                    } else if (i9 == i3) {
                                        i5 = PointerIconCompat.TYPE_ALIAS;
                                    } else {
                                        i5 = PointerIconCompat.TYPE_WAIT;
                                    }
                                    zzavdVarZzd.zzc(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
                                }
                            }
                        } catch (Exception e2) {
                            strZza = Integer.toString(7);
                            if (zBooleanValue && zzavdVarZzd != null) {
                                if (i9 == i2) {
                                    i6 = PointerIconCompat.TYPE_CROSSHAIR;
                                } else {
                                    i6 = i9 == i3 ? PointerIconCompat.TYPE_COPY : 1005;
                                }
                                zzavdVarZzd.zzc(i6, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, e2);
                            }
                        }
                    } else {
                        strZza = Integer.toString(5);
                    }
                    return strZza;
                }
            } else {
                if (i9 == 2) {
                    zzasgVarZzc = zzd(context, view, activity);
                    i7 = PointerIconCompat.TYPE_TEXT;
                } else {
                    zzasgVarZzc = zzc(context, null);
                    i7 = 1000;
                }
                zzasgVarZzb = zzasgVarZzc;
                i8 = i7;
            }
            if (!zBooleanValue || zzavdVarZzd == null) {
                i2 = 3;
            } else {
                i2 = 3;
                try {
                    zzavdVarZzd.zzc(i8, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, null);
                } catch (Exception e3) {
                    e = e3;
                    exc = e;
                    if (!zBooleanValue && zzavdVarZzd != null) {
                        if (i9 == i2) {
                            i4 = 1003;
                            i3 = 2;
                        } else {
                            i3 = 2;
                            if (i9 == 2) {
                                i4 = 1009;
                            } else {
                                i4 = 1001;
                                i9 = i10;
                            }
                        }
                        zzavdVarZzd.zzc(i4, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, exc);
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (zzasgVarZzb != null) {
                        strZza = Integer.toString(5);
                    } else if (((zzatd) zzasgVarZzb.zzal()).zzaz() == 0) {
                        strZza = Integer.toString(5);
                    } else {
                        zzatd zzatdVar2 = (zzatd) zzasgVarZzb.zzal();
                        int i12 = zzatx.zzc;
                        strZza = zzatx.zza(zzatdVar2.zzax(), str);
                        if (zBooleanValue) {
                            if (i9 == i2) {
                                i5 = PointerIconCompat.TYPE_CELL;
                            } else if (i9 == i3) {
                                i5 = PointerIconCompat.TYPE_ALIAS;
                            } else {
                                i5 = PointerIconCompat.TYPE_WAIT;
                            }
                            zzavdVarZzd.zzc(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
                        }
                    }
                    return strZza;
                }
            }
        } catch (Exception e4) {
            e = e4;
            i2 = 3;
        }
        i3 = 2;
        jCurrentTimeMillis = System.currentTimeMillis();
        if (zzasgVarZzb != null) {
            strZza = Integer.toString(5);
        } else if (((zzatd) zzasgVarZzb.zzal()).zzaz() == 0) {
            strZza = Integer.toString(5);
        } else {
            zzatd zzatdVar3 = (zzatd) zzasgVarZzb.zzal();
            int i13 = zzatx.zzc;
            strZza = zzatx.zza(zzatdVar3.zzax(), str);
            if (zBooleanValue && zzavdVarZzd != null) {
                if (i9 == i2) {
                    i5 = PointerIconCompat.TYPE_CELL;
                } else if (i9 == i3) {
                    i5 = PointerIconCompat.TYPE_ALIAS;
                } else {
                    i5 = PointerIconCompat.TYPE_WAIT;
                }
                zzavdVarZzd.zzc(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
            }
        }
        return strZza;
    }

    protected abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzavz;

    protected abstract zzasg zzb(Context context, View view, Activity activity);

    protected abstract zzasg zzc(Context context, zzarz zzarzVar);

    protected abstract zzasg zzd(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zze(Context context, String str, View view) {
        return zzm(context, str, 3, view, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzf(Context context, String str, View view, Activity activity) {
        return zzm(context, str, 3, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzg(Context context) {
        if (zzawm.zzc()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zzm(context, null, 1, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzh(Context context, View view, Activity activity) {
        return zzm(context, null, 2, view, activity, null);
    }

    protected abstract zzawl zzi(MotionEvent motionEvent) throws zzavz;

    @Override // com.google.android.gms.internal.ads.zzave
    public final synchronized void zzk(MotionEvent motionEvent) {
        Long l;
        if (this.zzu) {
            zzj();
            this.zzu = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzk = 0.0d;
            this.zzs = motionEvent.getRawX();
            this.zzt = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d = rawX - this.zzs;
            double d2 = rawY - this.zzt;
            this.zzk += Math.sqrt((d * d) + (d2 * d2));
            this.zzs = rawX;
            this.zzt = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    this.zzb = motionEventObtain;
                    this.zzc.add(motionEventObtain);
                    if (this.zzc.size() > 6) {
                        ((MotionEvent) this.zzc.remove()).recycle();
                    }
                    this.zzf++;
                    this.zzh = zza(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.zze += (long) (motionEvent.getHistorySize() + 1);
                    zzawl zzawlVarZzi = zzi(motionEvent);
                    Long l2 = zzawlVarZzi.zzd;
                    if (l2 != null && zzawlVarZzi.zzg != null) {
                        this.zzi += l2.longValue() + zzawlVarZzi.zzg.longValue();
                    }
                    if (this.zzq != null && (l = zzawlVarZzi.zze) != null && zzawlVarZzi.zzh != null) {
                        this.zzj += l.longValue() + zzawlVarZzi.zzh.longValue();
                    }
                } else if (action2 == 3) {
                    this.zzg++;
                }
            } catch (zzavz unused) {
            }
        } else {
            this.zzl = motionEvent.getX();
            this.zzm = motionEvent.getY();
            this.zzn = motionEvent.getRawX();
            this.zzo = motionEvent.getRawY();
            this.zzd++;
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final synchronized void zzl(int i, int i2, int i3) {
        if (this.zzb != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcp)).booleanValue()) {
                zzj();
            } else {
                this.zzb.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzq;
        if (displayMetrics != null) {
            this.zzb = MotionEvent.obtain(0L, i3, 1, i * displayMetrics.density, i2 * this.zzq.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzb = null;
        }
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzawb zzawbVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcz)).booleanValue() || (zzawbVar = this.zzr) == null) {
            return;
        }
        zzawbVar.zzb(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public void zzo(View view) {
    }
}
