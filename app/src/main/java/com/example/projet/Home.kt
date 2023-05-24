package com.example.projet

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.cardview.widget.CardView
import com.example.projet.R

class Home : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)

        val stores_btn : CardView =view.findViewById(R.id.stores_btn)
        val disease_btn : CardView =view.findViewById(R.id.disease_btn)
        val doctors_account_btn : CardView =view.findViewById(R.id.doctors_account_btn)
        val sport_routine_btn : CardView =view.findViewById(R.id.sport_routine_btn)

        stores_btn.setOnClickListener{
            val fragment= StoresFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        disease_btn.setOnClickListener{
            val fragment= DiseaseFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }


        doctors_account_btn.setOnClickListener{
            val fragment=Doctors_AccountFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        sport_routine_btn.setOnClickListener{
            val fragment=Sport_RoutineFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }


       val toolBar :Toolbar =view.findViewById(R.id.toolbar)
        toolBar.inflateMenu(R.menu.menu)

        toolBar.setOnMenuItemClickListener { menuItem->
            when (menuItem.itemId) {
                R.id.call -> {
                    val callIntent= Intent(Intent.ACTION_DIAL)
                    callIntent.data= Uri.parse("tel:0123456789")
                    startActivity(callIntent)
                }
                R.id.mail -> {
                    val mailIntent= Intent(Intent.ACTION_SENDTO)
                    mailIntent.data= Uri.parse("mailto:")
                    mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("exemple@gmail.com"))
                    mailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.asklogin))
                    startActivity(mailIntent)
                }
                R.id.share -> {
                    val shareIntent= Intent(Intent.ACTION_SENDTO)
                    shareIntent.type="text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT,"my app link")
                    startActivity(shareIntent)
                }
                R.id.logout -> {
                    Toast.makeText(context,getString(R.string.logout), Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        return view
    }
}