package com.example.pemf1.ui.view.notification

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import com.example.pemf1.R
import com.example.pemf1.databinding.ActivityNotificationBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*


class NotificationActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNotificationBinding
    private lateinit var picker :MaterialTimePicker
    private lateinit var calendar: Calendar
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent

    var hora:Int = 0
    var minuto:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        crearNotificacion()

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        //recuperamos preferencia
        val hora = prefs.getInt("keyHora",hora)
        val min = prefs.getInt("keyMinuto",minuto)

        calendar = Calendar.getInstance()
        calendar[Calendar.HOUR_OF_DAY] = hora
        calendar[Calendar.MINUTE] = min

        if(hora>12){
            binding.horaSeleccionada.text = calendar[Calendar.HOUR_OF_DAY].toString() + " : " + calendar[Calendar.MINUTE].toString() + " PM"

        }else{
            binding.horaSeleccionada.text = calendar[Calendar.HOUR_OF_DAY].toString() + " : " + calendar[Calendar.MINUTE].toString() + " AM"

        }


        binding.ponerHorabutton.setOnClickListener {

            mostrarTimePicker()
        }

        binding.activarAvisobutton.setOnClickListener {
            ponerAlarma()
        }

        binding.cancelarAvisobutton.setOnClickListener {
            cancelarAlarma()

        }

    }

    private fun cancelarAlarma() {
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this,AlarmReciever::class.java)
        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0)
        alarmManager.cancel(pendingIntent)

        Toast.makeText(this,"Cancelada",Toast.LENGTH_SHORT).show()


    }

    private fun ponerAlarma() {
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this,AlarmReciever::class.java)
        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0)

        alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,calendar.timeInMillis,
                AlarmManager.INTERVAL_DAY,pendingIntent

        )
        Toast.makeText(this,"Crema",Toast.LENGTH_SHORT).show()
    }

    private fun mostrarTimePicker() {
        picker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Selecciona cuando quieres que te avisemos")
                .build()

        picker.show(supportFragmentManager,"isma")

        picker.addOnPositiveButtonClickListener {
            if(picker.hour>12){
                binding.horaSeleccionada.text = String.format("%02d",picker.hour) + " : " + String.format(
                        "%02d",picker.minute
                ) + " PM"
            }else{
                binding.horaSeleccionada.text = String.format("%02d",picker.hour) + " : " + String.format(
                        "%02d",picker.minute
                ) + " AM"
            }

            //actualizamos variables
            hora = picker.hour
            minuto = picker.minute

            val prefs = PreferenceManager.getDefaultSharedPreferences(this)

            //guardamos la preferencia
            val editor = prefs.edit()
            editor.putInt("keyHora",hora)
            editor.putInt("keyMinuto",minuto)
            editor.apply()

            calendar[Calendar.HOUR_OF_DAY] = hora
            calendar[Calendar.MINUTE] = minuto
            calendar[Calendar.SECOND] = 0
            calendar[Calendar.MILLISECOND] = 0
        }

    }

    private fun crearNotificacion() {

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channelImportance = NotificationManager.IMPORTANCE_HIGH

                val channel = NotificationChannel("isma", "channelIsma", channelImportance).apply {
                    lightColor = Color.RED
                    enableLights(true)
                }

                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)
            }

    }
}