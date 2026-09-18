package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzctz extends zzcwh {
    private final zzcjk zzc;
    private final int zzd;
    private final Context zze;
    private final zzcto zzf;
    private final zzdkw zzg;
    private final zzdhy zzh;
    private final zzdbk zzi;
    private final boolean zzj;
    private final zzcdp zzk;
    private boolean zzl;

    zzctz(zzcwg zzcwgVar, Context context, zzcjk zzcjkVar, int i, zzcto zzctoVar, zzdkw zzdkwVar, zzdhy zzdhyVar, zzdbk zzdbkVar, zzcdp zzcdpVar) {
        super(zzcwgVar);
        this.zzl = false;
        this.zzc = zzcjkVar;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzctoVar;
        this.zzg = zzdkwVar;
        this.zzh = zzdhyVar;
        this.zzi = zzdbkVar;
        this.zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfk)).booleanValue();
        this.zzk = zzcdpVar;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcwh
    public final void zzb() {
        super.zzb();
        zzcjk zzcjkVar = this.zzc;
        if (zzcjkVar != null) {
            zzcjkVar.destroy();
        }
    }

    public final void zzc(zzbad zzbadVar) {
        zzcjk zzcjkVar = this.zzc;
        if (zzcjkVar != null) {
            zzcjkVar.zzai(zzbadVar);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzd(Activity activity, zzbaq zzbaqVar, boolean z) throws RemoteException {
        zzcjk zzcjkVar;
        zzfgm zzfgmVarZzD;
        Context context = activity;
        if (activity == null) {
            context = this.zze;
        }
        if (this.zzj) {
            this.zzh.zzb();
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaB)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzF(context)) {
                zzcec.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzi.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaC)).booleanValue()) {
                    new zzfrc(context.getApplicationContext(), com.google.android.gms.ads.internal.zzt.zzt().zzb()).zza(this.zza.zzb.zzb.zzb);
                    return;
                }
                return;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzll)).booleanValue() && (zzcjkVar = this.zzc) != null && (zzfgmVarZzD = zzcjkVar.zzD()) != null && zzfgmVarZzD.zzar && zzfgmVarZzD.zzas != this.zzk.zzb()) {
            zzcec.zzj("The app open consent form has been shown.");
            this.zzi.zza(zzfij.zzd(12, "The consent form has already been shown.", null));
            return;
        }
        if (this.zzl) {
            zzcec.zzj("App open interstitial ad is already visible.");
            this.zzi.zza(zzfij.zzd(10, null, null));
        }
        if (this.zzl) {
            return;
        }
        try {
            this.zzg.zza(z, context, this.zzi);
            if (this.zzj) {
                this.zzh.zza();
            }
            this.zzl = true;
        } catch (zzdkv e) {
            this.zzi.zzc(e);
        }
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
