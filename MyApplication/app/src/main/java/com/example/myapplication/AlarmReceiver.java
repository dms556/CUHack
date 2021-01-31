package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    private static final String CHANNEL_ID = "SAMPLE_CHANNEL";

    @Override
    public void onReceive(Context context, Intent intent) {

        //Get id and message from intent
        int notificationID = intent.getIntExtra("notificationID",0);
        String message = intent.getStringExtra("todo");

        Intent mainIntent = new Intent(context,set.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, mainIntent, 0);

        //Notification Manager
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = "My Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, importance);
            notificationManager.createNotificationChannel(channel);

        }

        //Make notification
        Notification.Builder builder = new Notification.Builder(context);
                builder.setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Time to go on a walk!")
                .setContentText(message)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contentIntent);

        //Notify
        notificationManager.notify(notificationID,builder.build());
    }
}
