package com.example.projet

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TimePicker
import android.widget.Toast
import android.widget.ToggleButton
import java.util.Calendar

class Medication_stimulant : Fragment() {

    var alarmTimePicker:TimePicker?=null
    var alarmManager:AlarmManager?=null
    var pendingIntent:PendingIntent?=null
    var toggleButton: ToggleButton? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_medication_stimulant, container, false)

        val r_back : ImageView =view.findViewById(R.id.return_back)
        r_back.setOnClickListener{
            val fragment= Profile()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        alarmTimePicker=view.findViewById(R.id.timePicker)
        alarmManager= context?.getSystemService(ALARM_SERVICE) as AlarmManager
        val toggleButton: ToggleButton= view.findViewById(R.id.toggle)

        //
       /* toggleButton.setOnCheckedChangeListener { compoundButton, b ->
            val acti = if (b) "activated" else "disactivated"
            Toast.makeText(context, acti, Toast.LENGTH_SHORT).show()

        }
*/


        return view
    }



     fun onToggleClicked(view: View) {
         var time :Long
         if ((view as ToggleButton).isChecked){
             Toast.makeText(context,getString(R.string.alarmOn), Toast.LENGTH_SHORT).show()

             var calender=Calendar.getInstance()
             calender[Calendar.HOUR_OF_DAY]=alarmTimePicker!!.currentHour
             calender[Calendar.MINUTE]=alarmTimePicker!!.currentMinute

             val intent=Intent(context,AlarmReceiver::class.java)
             pendingIntent=PendingIntent.getBroadcast(context,0,intent,0)
             time=calender.timeInMillis - calender.timeInMillis % 60000

             if(System.currentTimeMillis()>time){
                 time=if (Calendar.AM_PM ==0){
                     time + 1000 *60 *60 *12
                 }
                 else{
                     time + 1000 *60 *60 *24
                 }
             }
             alarmManager!!.setRepeating(AlarmManager.RTC_WAKEUP,time,1000,pendingIntent)
         }
         else{
             alarmManager!!.cancel(pendingIntent)
             Toast.makeText(context,getString(R.string.alarmoff), Toast.LENGTH_SHORT).show()

         }
     }


}