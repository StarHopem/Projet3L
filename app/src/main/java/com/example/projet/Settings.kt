@file:Suppress("DEPRECATION")

package com.example.projet

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import com.example.projet.R
import java.util.*

@Suppress("UNREACHABLE_CODE")
class Settings : Fragment() {

    var nightMode: Boolean = false
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor :SharedPreferences.Editor


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_settings, container, false)

        val arbtn =view.findViewById<RadioButton>(R.id.arabicBtn)
        val frbtn =view.findViewById<RadioButton>(R.id.frenchBtn)
        val enbtn =view.findViewById<RadioButton>(R.id.englishBtn)

        val switchMode:SwitchCompat=view.findViewById(R.id.SwitchMode)
        val sharedPreferences = requireContext().getSharedPreferences("Mode", Context.MODE_PRIVATE)
        nightMode=sharedPreferences.getBoolean("nightMode",false)

        if (nightMode){
            switchMode.isChecked = true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        switchMode.setOnClickListener {
            if (nightMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                val editor = sharedPreferences.edit()
                editor.putBoolean("nightMode", false)
                editor.apply()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                val editor = sharedPreferences.edit()
                editor.putBoolean("nightMode", true)
                editor.apply()
            }
        }


        arbtn.setOnClickListener(){
            val res1: Resources = this.resources
            val dm1: DisplayMetrics = res1.displayMetrics
            val conf1: Configuration = res1.configuration
            conf1.setLocale(Locale("ar"))
            res1.updateConfiguration(conf1, dm1)
            val refresh = Intent(context, MainActivity::class.java)
            startActivity(refresh)
        }
        frbtn.setOnClickListener(){
            Toast.makeText(context,getString(R.string.coming), Toast.LENGTH_SHORT).show()
        }
        enbtn.setOnClickListener(){
            val res3: Resources = this.resources
            val dm3: DisplayMetrics = res3.displayMetrics
            val conf3: Configuration = res3.configuration
            conf3.setLocale(Locale("en"))
            res3.updateConfiguration(conf3, dm3)
            val refresh = Intent(context, MainActivity::class.java)
            startActivity(refresh)
        }

        return view
    }

}