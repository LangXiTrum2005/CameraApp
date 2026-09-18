package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.NotificationHandlerActivity;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzehs extends zzbwl {
    final Map zza = new HashMap();
    private final Context zzb;
    private final zzdwf zzc;
    private final zzceh zzd;
    private final zzehh zze;
    private final zzflw zzf;
    private String zzg;
    private String zzh;

    public zzehs(Context context, zzehh zzehhVar, zzceh zzcehVar, zzdwf zzdwfVar, zzflw zzflwVar) {
        this.zzb = context;
        this.zzc = zzdwfVar;
        this.zzd = zzcehVar;
        this.zze = zzehhVar;
        this.zzf = zzflwVar;
    }

    public static void zzc(Context context, zzdwf zzdwfVar, zzflw zzflwVar, zzehh zzehhVar, String str, String str2, Map map) {
        String strZza;
        String str3 = true != com.google.android.gms.ads.internal.zzt.zzo().zzz(context) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue() || zzdwfVar == null) {
            zzflv zzflvVarZzb = zzflv.zzb(str2);
            zzflvVarZzb.zza("gqi", str);
            zzflvVarZzb.zza("device_connectivity", str3);
            zzflvVarZzb.zza("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zzflvVarZzb.zza((String) entry.getKey(), (String) entry.getValue());
            }
            strZza = zzflwVar.zza(zzflvVarZzb);
        } else {
            zzdwe zzdweVarZza = zzdwfVar.zza();
            zzdweVarZza.zzb("gqi", str);
            zzdweVarZza.zzb("action", str2);
            zzdweVarZza.zzb("device_connectivity", str3);
            zzdweVarZza.zzb("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            for (Map.Entry entry2 : map.entrySet()) {
                zzdweVarZza.zzb((String) entry2.getKey(), (String) entry2.getValue());
            }
            strZza = zzdweVarZza.zzf();
        }
        zzehhVar.zzd(new zzehj(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), str, strZza, 2));
    }

    public static final PendingIntent zzq(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str3);
        if (Build.VERSION.SDK_INT < 29 || !str.equals("offline_notification_clicked")) {
            intent.setClassName(context, AdService.CLASS_NAME);
            return zzfuj.zzb(context, 0, intent, zzfuj.zza | 1073741824, 0);
        }
        intent.setClassName(context, NotificationHandlerActivity.CLASS_NAME);
        return zzfuj.zza(context, 0, intent, 201326592);
    }

    private static String zzr(int i, String str) {
        Resources resourcesZze = com.google.android.gms.ads.internal.zzt.zzo().zze();
        return resourcesZze == null ? str : resourcesZze.getString(i);
    }

    private final void zzs(String str, String str2, Map map) {
        zzc(this.zzb, this.zzc, this.zzf, this.zze, str, str2, map);
    }

    private final void zzt() {
        boolean zZzg;
        try {
            com.google.android.gms.ads.internal.zzt.zzp();
            com.google.android.gms.ads.internal.util.zzbt zzbtVarZzy = com.google.android.gms.ads.internal.util.zzt.zzy(this.zzb);
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(this.zzb);
            String str = this.zzh;
            String str2 = this.zzg;
            zzegz zzegzVar = (zzegz) this.zza.get(str2);
            zZzg = zzbtVarZzy.zzg(iObjectWrapperWrap, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, zzegzVar == null ? "" : zzegzVar.zzc()));
            if (!zZzg) {
                try {
                    zZzg = zzbtVarZzy.zzf(ObjectWrapper.wrap(this.zzb), this.zzh, this.zzg);
                } catch (RemoteException e) {
                    e = e;
                    zzcec.zzh("Failed to schedule offline notification poster.", e);
                }
            }
        } catch (RemoteException e2) {
            e = e2;
            zZzg = false;
        }
        if (zZzg) {
            return;
        }
        this.zze.zzc(this.zzg);
        zzs(this.zzg, "offline_notification_worker_not_scheduled", zzgad.zzd());
    }

    private final void zzu(final Activity activity, final com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        com.google.android.gms.ads.internal.zzt.zzp();
        if (NotificationManagerCompat.from(activity).areNotificationsEnabled()) {
            zzt();
            zzv(activity, zzmVar);
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
                zzs(this.zzg, "asnpdi", zzgad.zzd());
                return;
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            AlertDialog.Builder builderZzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(activity);
            builderZzJ.setTitle(zzr(R.string.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(zzr(R.string.notifications_permission_confirm, HttpHeaders.ALLOW), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzehl
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.zza.zzd(activity, zzmVar, dialogInterface, i);
                }
            }).setNegativeButton(zzr(R.string.notifications_permission_decline, "Don't allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzehm
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.zza.zzk(zzmVar, dialogInterface, i);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzehn
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.zza.zzl(zzmVar, dialogInterface);
                }
            });
            builderZzJ.create().show();
            zzs(this.zzg, "rtsdi", zzgad.zzd());
        }
    }

    private final void zzv(Activity activity, final com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        AlertDialog alertDialogCreate;
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder onCancelListener = com.google.android.gms.ads.internal.util.zzt.zzJ(activity).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzehk
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                com.google.android.gms.ads.internal.overlay.zzm zzmVar2 = zzmVar;
                if (zzmVar2 != null) {
                    zzmVar2.zzb();
                }
            }
        });
        int i = R.layout.offline_ads_dialog;
        Resources resourcesZze = com.google.android.gms.ads.internal.zzt.zzo().zze();
        XmlResourceParser layout = resourcesZze == null ? null : resourcesZze.getLayout(i);
        if (layout == null) {
            onCancelListener.setMessage(zzr(R.string.offline_dialog_text, "You'll get a notification with the link when you're back online"));
            alertDialogCreate = onCancelListener.create();
        } else {
            View viewInflate = activity.getLayoutInflater().inflate(layout, (ViewGroup) null);
            onCancelListener.setView(viewInflate);
            zzegz zzegzVar = (zzegz) this.zza.get(this.zzg);
            String strZzb = zzegzVar == null ? "" : zzegzVar.zzb();
            if (!strZzb.isEmpty()) {
                TextView textView = (TextView) viewInflate.findViewById(R.id.offline_dialog_advertiser_name);
                textView.setVisibility(0);
                textView.setText(strZzb);
            }
            zzegz zzegzVar2 = (zzegz) this.zza.get(this.zzg);
            Drawable drawableZza = zzegzVar2 != null ? zzegzVar2.zza() : null;
            if (drawableZza != null) {
                ((ImageView) viewInflate.findViewById(R.id.offline_dialog_image)).setImageDrawable(drawableZza);
            }
            alertDialogCreate = onCancelListener.create();
            alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialogCreate.show();
        Timer timer = new Timer();
        timer.schedule(new zzehr(this, alertDialogCreate, timer, zzmVar), 3000L);
    }

    final /* synthetic */ void zzd(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzs(this.zzg, "rtsdc", map);
        activity.startActivity(com.google.android.gms.ads.internal.zzt.zzq().zzf(activity));
        zzt();
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            boolean zZzz = com.google.android.gms.ads.internal.zzt.zzo().zzz(this.zzb);
            HashMap map = new HashMap();
            char c = 2;
            if (stringExtra.equals("offline_notification_clicked")) {
                map.put("offline_notification_action", "offline_notification_clicked");
                c = true == zZzz ? (char) 1 : (char) 2;
                map.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                map.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                try {
                    Intent launchIntentForPackage = this.zzb.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    this.zzb.startActivity(launchIntentForPackage);
                    map.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    map.put("olaa", "olaf");
                }
            } else {
                map.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzs(stringExtra2, "offline_notification_action", map);
            try {
                SQLiteDatabase writableDatabase = this.zze.getWritableDatabase();
                if (c == 1) {
                    this.zze.zzg(writableDatabase, this.zzd, stringExtra2);
                } else {
                    zzehh.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                zzcec.zzg("Failed to get writable offline buffering database: ".concat(e.toString()));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("android.permission.POST_NOTIFICATIONS")) {
                zzehu zzehuVar = (zzehu) ObjectWrapper.unwrap(iObjectWrapper);
                Activity activityZza = zzehuVar.zza();
                com.google.android.gms.ads.internal.overlay.zzm zzmVarZzb = zzehuVar.zzb();
                HashMap map = new HashMap();
                if (iArr[i] == 0) {
                    map.put("dialog_action", "confirm");
                    zzt();
                    zzv(activityZza, zzmVarZzb);
                } else {
                    map.put("dialog_action", "dismiss");
                    if (zzmVarZzb != null) {
                        zzmVarZzb.zzb();
                    }
                }
                zzs(this.zzg, "asnpdc", map);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzg(IObjectWrapper iObjectWrapper) {
        zzehu zzehuVar = (zzehu) ObjectWrapper.unwrap(iObjectWrapper);
        final Activity activityZza = zzehuVar.zza();
        final com.google.android.gms.ads.internal.overlay.zzm zzmVarZzb = zzehuVar.zzb();
        this.zzg = zzehuVar.zzc();
        this.zzh = zzehuVar.zzd();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzip)).booleanValue()) {
            zzu(activityZza, zzmVarZzb);
            return;
        }
        zzs(this.zzg, "dialog_impression", zzgad.zzd());
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder builderZzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(activityZza);
        builderZzJ.setTitle(zzr(R.string.offline_opt_in_title, "Open ad when you're back online.")).setMessage(zzr(R.string.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzr(R.string.offline_opt_in_confirm, "OK"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzeho
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.zza.zzm(activityZza, zzmVarZzb, dialogInterface, i);
            }
        }).setNegativeButton(zzr(R.string.offline_opt_in_decline, "No thanks"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzehp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.zza.zzn(zzmVarZzb, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzehq
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.zza.zzo(zzmVarZzb, dialogInterface);
            }
        });
        builderZzJ.create().show();
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzh() {
        final zzceh zzcehVar = this.zzd;
        this.zze.zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzeha
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) throws Exception {
                zzehh.zzb(zzcehVar, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) {
        zzj(iObjectWrapper, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, ""));
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) {
        Bitmap bitmapDecodeStream;
        String str;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        String str2 = zzaVar.zza;
        String str3 = zzaVar.zzb;
        String str4 = zzaVar.zzc;
        com.google.android.gms.ads.internal.zzt.zzq().zzg(context, "offline_notification_channel", "AdMob Offline Notifications");
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(context, "offline_notification_channel").setContentTitle(zzr(R.string.offline_notification_title, "View the ad you saved when you were offline")).setAutoCancel(true).setDeleteIntent(zzq(context, "offline_notification_dismissed", str3, str2)).setContentIntent(zzq(context, "offline_notification_clicked", str3, str2)).setSmallIcon(context.getApplicationInfo().icon).setPriority(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziq)).intValue()).setSmallIcon(context.getApplicationInfo().icon);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzis)).booleanValue() || str4.isEmpty()) {
            bitmapDecodeStream = null;
        } else {
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(new URL(str4).openConnection().getInputStream());
            } catch (IOException unused) {
                bitmapDecodeStream = null;
            }
        }
        if (bitmapDecodeStream != null) {
            try {
                smallIcon.setLargeIcon(bitmapDecodeStream).setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmapDecodeStream).bigLargeIcon((Bitmap) null));
            } catch (Resources.NotFoundException unused2) {
            }
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        HashMap map = new HashMap();
        try {
            notificationManager.notify(str3, 54321, smallIcon.build());
            str = "offline_notification_impression";
        } catch (IllegalArgumentException e) {
            map.put("notification_not_shown_reason", e.getMessage());
            str = "offline_notification_failed";
        }
        zzs(str3, str, map);
    }

    final /* synthetic */ void zzk(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        this.zze.zzc(this.zzg);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzs(this.zzg, "rtsdc", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    final /* synthetic */ void zzl(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzg);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzs(this.zzg, "rtsdc", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    final /* synthetic */ void zzm(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzs(this.zzg, "dialog_click", map);
        zzu(activity, zzmVar);
    }

    final /* synthetic */ void zzn(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        this.zze.zzc(this.zzg);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzs(this.zzg, "dialog_click", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    final /* synthetic */ void zzo(com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzg);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzs(this.zzg, "dialog_click", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    public final void zzp(String str, zzdna zzdnaVar) {
        String strZzB;
        String string = "";
        if (TextUtils.isEmpty(zzdnaVar.zzx())) {
            strZzB = zzdnaVar.zzB() != null ? zzdnaVar.zzB() : "";
        } else {
            strZzB = zzdnaVar.zzx();
        }
        zzbjm zzbjmVarZzm = zzdnaVar.zzm();
        if (zzbjmVarZzm != null) {
            try {
                string = zzbjmVarZzm.zze().toString();
            } catch (RemoteException unused) {
            }
        }
        zzbjm zzbjmVarZzn = zzdnaVar.zzn();
        Drawable drawable = null;
        if (zzbjmVarZzn != null) {
            try {
                IObjectWrapper iObjectWrapperZzf = zzbjmVarZzn.zzf();
                if (iObjectWrapperZzf != null) {
                    drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzf);
                }
            } catch (RemoteException unused2) {
            }
        }
        this.zza.put(str, new zzegv(strZzB, string, drawable));
    }
}
