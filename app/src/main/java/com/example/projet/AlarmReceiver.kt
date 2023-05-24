package com.example.projet

import android.Manifest
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.RingtoneManager
import android.os.Vibrator
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
         val vibrator=context!!.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(4000)
        Toast.makeText(context,"Alarm ! It's Time! It's Time! ",Toast.LENGTH_SHORT).show()

        var alarmUri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)

        if (alarmUri==null){
            alarmUri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }
        val ringtone=RingtoneManager.getRingtone(context,alarmUri)
        ringtone.play()


    }
}