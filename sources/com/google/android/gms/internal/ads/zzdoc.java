package com.google.android.gms.internal.ads;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdoc implements GestureDetector.OnGestureListener {
    private final zzdmv zza;
    private final zzdnw zzb;

    zzdoc(zzdmv zzdmvVar, zzdnw zzdnwVar) {
        this.zza = zzdmvVar;
        this.zzb = zzdnwVar;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0061  */
    @Override // android.view.GestureDetector.OnGestureListener
    public final synchronized boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int y;
        if (this.zza != null) {
            int i = -1;
            if (Math.abs(f) > Math.abs(f2)) {
                if (f > 0.0f) {
                    y = (int) (((motionEvent2.getX() - motionEvent.getX()) / f) * 1000.0f);
                    i = 1;
                } else if (f < 0.0f) {
                    y = (int) (((motionEvent2.getX() - motionEvent.getX()) / f) * 1000.0f);
                    i = 2;
                } else {
                    y = 0;
                }
            } else if (f2 > 0.0f) {
                y = (int) (((motionEvent2.getY() - motionEvent.getY()) / f2) * 1000.0f);
                i = 8;
            } else if (f2 < 0.0f) {
                y = (int) (((motionEvent2.getY() - motionEvent.getY()) / f2) * 1000.0f);
                i = 4;
            } else {
                y = 0;
            }
            if (i == this.zza.zza()) {
                this.zza.zzD(this.zzb.zzr(), y);
                return false;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final synchronized boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
