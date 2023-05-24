package com.example.projet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.projet.R

class Profile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_profile, container, false)

        val question_answerTv :CardView=view.findViewById(R.id.question_answer)
        val Continuous_monitoringTv :CardView=view.findViewById(R.id.Continuous_monitoring)
        val Medication_stimulantTv:CardView=view.findViewById(R.id.Medication_stimulant)

        question_answerTv.setOnClickListener{
            val fragment= QA()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        Continuous_monitoringTv.setOnClickListener{
            val fragment= Continuous_monitoring()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        Medication_stimulantTv.setOnClickListener{
            val fragment=Medication_stimulant()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        return view
    }

}