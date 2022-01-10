package com.example.pemf1.ui.view.notification

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.pemf1.R
import com.example.pemf1.ui.view.StreamActivity

class AlarmReciever:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val i = Intent(context,StreamActivity::class.java)
        intent!!.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(context,0,i,0)

        val builder = NotificationCompat.Builder(context!!,"isma")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("LA F1 COMIENZA YA")
                .setContentText("Estas listo para lo que puede ser la mejor carrera de la historia. No te lo pierdas")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(123,builder.build())
    }
}