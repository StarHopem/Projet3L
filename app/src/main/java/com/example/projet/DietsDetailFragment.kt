package com.example.projet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DietsDetailFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_diets_detail, container, false)

        val getData = arguments?.getParcelable<DataClassDiets>("diets")
        if (getData != null) {
            val detailTitle: TextView = view.findViewById(R.id.detailTitle)
            val detailImage: ImageView = view.findViewById(R.id.detailImage)
            val detailDesc: TextView = view.findViewById(R.id.detailDes)

            detailTitle.text = getData.dataTitle
            detailImage.setImageResource(getData.dataImage)
            detailDesc.text = getData.dataDes
        }

        val r_back : ImageView =view.findViewById(R.id.return_back)
        r_back.setOnClickListener{
            val fragment= DietsFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        return  view
    }

}