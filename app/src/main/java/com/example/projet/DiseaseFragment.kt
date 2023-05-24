package com.example.projet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet.DiseaseFragment as DiseaseFragment1

class DiseaseFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_disease, container, false)

        val kidney : CardView =view.findViewById(R.id.kidney_btn)
        val diabetics : CardView =view.findViewById(R.id.diabetics_btn)
        val unknown1_btn : CardView =view.findViewById(R.id.unknown1)
        val unknown2_btn : CardView =view.findViewById(R.id.unknown2)
        val r_back : ImageView =view.findViewById(R.id.return_back)

        r_back.setOnClickListener{
            val fragment= Home()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }
        kidney.setOnClickListener{
            val fragment= DietsFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        diabetics.setOnClickListener{
            Toast.makeText(context,getString(R.string.coming), Toast.LENGTH_SHORT).show()
        }

        unknown1_btn.setOnClickListener{
            Toast.makeText(context,getString(R.string.coming), Toast.LENGTH_SHORT).show()
        }

        unknown2_btn.setOnClickListener{
            Toast.makeText(context,getString(R.string.coming), Toast.LENGTH_SHORT).show()
        }

        return view
    }


}