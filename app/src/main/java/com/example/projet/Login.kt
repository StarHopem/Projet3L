@file:Suppress("DEPRECATION")

package com.example.projet

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class Login : AppCompatActivity() {

    lateinit var nav_view: BottomNavigationView
    lateinit var username: EditText
    lateinit var loginBtn: Button
    lateinit var phoneEt: TextInputEditText
    lateinit var phoneL: TextInputLayout
    lateinit var codeEt: TextInputEditText
    lateinit var codeL: TextInputLayout


    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initializeViews()

        loginBtn.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        phoneEt.doOnTextChanged { text, start, before, count ->
            run {
                if (phoneEt.length() > 9) {
                    phoneL.error = "No More"
                } else if (phoneEt.length() <= 9) {
                    phoneL.error = null
                }
            }
            /*  codeEt.doOnTextChanged { text, start, before, count -> run {
                  if (codeEt.length() > 5) {
                      codeL.error="No More !!!"
                  }else if(codeEt.length() <= 5){
                      codeL.error=null
                  }
              }
              }*/

            // for Radio Button
            val rdGroup = findViewById<RadioGroup>(R.id.radioGroup)
            val btn1 = findViewById<RadioButton>(R.id.radioButton1)
            val btn2 = findViewById<RadioButton>(R.id.radioButton2)
            btn1.setOnClickListener {
                val selectBtn: Int = rdGroup!!.checkedRadioButtonId
                val btn = findViewById<RadioButton>(selectBtn)
                Toast.makeText(this, btn.text, Toast.LENGTH_SHORT).show()
            }
            btn2.setOnClickListener {
                val selectBtn: Int = rdGroup!!.checkedRadioButtonId
                val btn = findViewById<RadioButton>(selectBtn)
                Toast.makeText(this, btn.text, Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun initializeViews() {
        nav_view = findViewById(R.id.bottomNavigationView)
        username = findViewById(R.id.usernameEditText)
        loginBtn = findViewById(R.id.loginButton)
        phoneEt = findViewById(R.id.emailAddressEditText)
        phoneL = findViewById(R.id.emailAddress)
        codeEt = findViewById(R.id.codeEditText)
        codeL = findViewById(R.id.password)
    }
}





