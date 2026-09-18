package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzenj implements zzdkw {
    private final Context zza;
    private final zzdtk zzb;
    private final zzfhh zzc;
    private final zzcei zzd;
    private final zzfgm zze;
    private final ListenableFuture zzf;
    private final zzcjk zzg;
    private final zzbni zzh;
    private final boolean zzi;
    private final zzehs zzj;

    zzenj(Context context, zzdtk zzdtkVar, zzfhh zzfhhVar, zzcei zzceiVar, zzfgm zzfgmVar, ListenableFuture listenableFuture, zzcjk zzcjkVar, zzbni zzbniVar, boolean z, zzehs zzehsVar) {
        this.zza = context;
        this.zzb = zzdtkVar;
        this.zzc = zzfhhVar;
        this.zzd = zzceiVar;
        this.zze = zzfgmVar;
        this.zzf = listenableFuture;
        this.zzg = zzcjkVar;
        this.zzh = zzbniVar;
        this.zzi = z;
        this.zzj = zzehsVar;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x008b  */
    /* JADX WARN: Code duplicated, block: B:19:0x0093  */
    /* JADX WARN: Code duplicated, block: B:22:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ec  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdkw
    public final void zza(boolean z, Context context, zzdbk zzdbkVar) {
        zzcjk zzcjkVar;
        zzcjk zzcjkVar2;
        boolean zZze;
        boolean z2;
        boolean zZzd;
        float fZza;
        zzdsp zzdspVar = (zzdsp) zzgen.zzq(this.zzf);
        try {
            zzfgm zzfgmVar = this.zze;
            if (this.zzg.zzaD()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaM)).booleanValue()) {
                    final zzcjk zzcjkVarZza = this.zzb.zza(this.zzc.zze, null, null);
                    zzbnx.zzb(zzcjkVarZza, zzdspVar.zzg());
                    final zzdto zzdtoVar = new zzdto();
                    zzdtoVar.zza(this.zza, (View) zzcjkVarZza);
                    zzdspVar.zzl().zzi(zzcjkVarZza, true, this.zzi ? this.zzh : null);
                    zzcjkVarZza.zzN().zzB(new zzckw() { // from class: com.google.android.gms.internal.ads.zzenh
                        @Override // com.google.android.gms.internal.ads.zzckw
                        public final void zza(boolean z3, int i, String str, String str2) {
                            zzdtoVar.zzb();
                            zzcjk zzcjkVar3 = zzcjkVarZza;
                            zzcjkVar3.zzZ();
                            zzcjkVar3.zzN().zzr();
                        }
                    });
                    zzcky zzckyVarZzN = zzcjkVarZza.zzN();
                    Objects.requireNonNull(zzcjkVarZza);
                    zzckyVarZzN.zzH(new zzckx() { // from class: com.google.android.gms.internal.ads.zzeni
                        @Override // com.google.android.gms.internal.ads.zzckx
                        public final void zza() {
                            zzcjkVarZza.zzY();
                        }
                    });
                    zzfgr zzfgrVar = zzfgmVar.zzt;
                    zzcjkVarZza.zzac(zzfgrVar.zzb, zzfgrVar.zza, null);
                    zzcjkVar = zzcjkVarZza;
                } else {
                    zzcjkVar2 = this.zzg;
                }
                zzcjkVar.zzao(true);
                if (this.zzi) {
                    zZze = this.zzh.zze(false);
                } else {
                    zZze = false;
                }
                com.google.android.gms.ads.internal.zzt.zzp();
                Context context2 = this.zza;
                z2 = this.zzi;
                boolean zZzH = com.google.android.gms.ads.internal.util.zzt.zzH(context2);
                if (z2) {
                    zZzd = this.zzh.zzd();
                } else {
                    zZzd = false;
                }
                if (this.zzi) {
                    fZza = this.zzh.zza();
                } else {
                    fZza = 0.0f;
                }
                float f = fZza;
                zzfgm zzfgmVar2 = this.zze;
                com.google.android.gms.ads.internal.zzj zzjVar = new com.google.android.gms.ads.internal.zzj(zZze, zZzH, zZzd, f, -1, z, zzfgmVar2.zzP, zzfgmVar2.zzQ);
                if (zzdbkVar != null) {
                    zzdbkVar.zzf();
                }
                com.google.android.gms.ads.internal.zzt.zzi();
                zzdkl zzdklVarZzh = zzdspVar.zzh();
                zzfgm zzfgmVar3 = this.zze;
                zzcei zzceiVar = this.zzd;
                int i = zzfgmVar3.zzR;
                String str = zzfgmVar3.zzC;
                zzfgr zzfgrVar2 = zzfgmVar3.zzt;
                com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzdklVarZzh, (com.google.android.gms.ads.internal.overlay.zzaa) null, zzcjkVar, i, zzceiVar, str, zzjVar, zzfgrVar2.zzb, zzfgrVar2.zza, this.zzc.zzf, zzdbkVar, zzfgmVar3.zzaj ? this.zzj : null), true);
            }
            zzcjkVar2 = this.zzg;
            zzcjkVar = zzcjkVar2;
            zzcjkVar.zzao(true);
            if (this.zzi) {
                zZze = this.zzh.zze(false);
            } else {
                zZze = false;
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            Context context3 = this.zza;
            z2 = this.zzi;
            boolean zZzH2 = com.google.android.gms.ads.internal.util.zzt.zzH(context3);
            if (z2) {
                zZzd = this.zzh.zzd();
            } else {
                zZzd = false;
            }
            if (this.zzi) {
                fZza = this.zzh.zza();
            } else {
                fZza = 0.0f;
            }
            float f2 = fZza;
            zzfgm zzfgmVar4 = this.zze;
            com.google.android.gms.ads.internal.zzj zzjVar2 = new com.google.android.gms.ads.internal.zzj(zZze, zZzH2, zZzd, f2, -1, z, zzfgmVar4.zzP, zzfgmVar4.zzQ);
            if (zzdbkVar != null) {
                zzdbkVar.zzf();
            }
            com.google.android.gms.ads.internal.zzt.zzi();
            zzdkl zzdklVarZzh2 = zzdspVar.zzh();
            zzfgm zzfgmVar5 = this.zze;
            zzcei zzceiVar2 = this.zzd;
            int i2 = zzfgmVar5.zzR;
            String str2 = zzfgmVar5.zzC;
            zzfgr zzfgrVar3 = zzfgmVar5.zzt;
            if (zzfgmVar5.zzaj) {
            }
            com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzdklVarZzh2, (com.google.android.gms.ads.internal.overlay.zzaa) null, zzcjkVar, i2, zzceiVar2, str2, zzjVar2, zzfgrVar3.zzb, zzfgrVar3.zza, this.zzc.zzf, zzdbkVar, zzfgmVar5.zzaj ? this.zzj : null), true);
        } catch (zzcjw e) {
            zzcec.zzh("", e);
        }
    }
}
