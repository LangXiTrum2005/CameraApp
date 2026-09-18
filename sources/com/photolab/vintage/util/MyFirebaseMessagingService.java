package com.photolab.vintage.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.photolab.vintage.R;
import com.photolab.vintage.activity.EditPhotoActivity$3$$ExternalSyntheticApiModelOutline0;
import com.photolab.vintage.activity.IntroActivity;

/* JADX INFO: loaded from: classes2.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";

    private void sendRegistrationToServer(String str) {
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
            return;
        }
        if (remoteMessage.getData().size() > 0) {
            String str = remoteMessage.getData().get("title");
            String str2 = remoteMessage.getData().get("body");
            if (str == null || str2 == null) {
                return;
            }
            sendNotification(str, str2);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        Log.d(TAG, "Refreshed token: " + str);
        sendRegistrationToServer(str);
    }

    private void sendNotification(String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) IntroActivity.class);
        intent.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 1140850688);
        String string = getString(R.string.default_notification_channel_id);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannelM = EditPhotoActivity$3$$ExternalSyntheticApiModelOutline0.m(string, "General Notifications", 4);
            notificationChannelM.setDescription("General notifications from the app");
            notificationChannelM.enableLights(true);
            notificationChannelM.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannelM);
        }
        notificationManager.notify((int) System.currentTimeMillis(), new NotificationCompat.Builder(this, string).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(str).setContentText(str2).setAutoCancel(true).setSound(defaultUri).setPriority(1).setContentIntent(activity).build());
    }
}
