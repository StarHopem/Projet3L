package com.example.projet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class DetailFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_detail, container, false)
        val getData = arguments?.getParcelable<DataClassDocAccount>("account")
        if (getData != null) {
            val detailTitle: TextView = view.findViewById(R.id.detailTitle)
            val detailImage: ImageView = view.findViewById(R.id.detailImage)
            val detailPhone:TextView = view.findViewById(R.id.textPhone)
            val detailCall:TextView = view.findViewById(R.id.textCall)
            val detailLocation:TextView = view.findViewById(R.id.textLocation)
            val detailMail:TextView = view.findViewById(R.id.textMail)
            detailTitle.text = getData.dataTitle2
            detailImage.setImageResource(getData.dataImage)
            detailPhone.text = getData.dataPhone
            detailCall.text = getData.dataCall
            detailLocation.text = getData.dataLocation
            detailMail.text = getData.dataMail

          /*  detailPhone.setOnClickListener(){
                val uri=Uri.parse("http://wa.me/${detailPhone.text}")
                val intent=Intent(Intent.ACTION_VIEW,uri)
                startActivity(intent)}*/

        }

        val r_back : ImageView =view.findViewById(R.id.return_back)
        r_back.setOnClickListener{
            val fragment= Doctors_AccountFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        return view
    }



}