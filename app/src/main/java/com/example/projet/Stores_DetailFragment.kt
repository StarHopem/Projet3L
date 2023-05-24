package com.example.projet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class Stores_DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view= inflater.inflate(R.layout.fragment_stores__detail, container, false)

        val getData = arguments?.getParcelable<DataClassStores>("stores")
        if (getData != null) {
            val detailTitle: TextView = view.findViewById(R.id.detailTitle)
            val detailImage: ImageView = view.findViewById(R.id.detailImage)
            val detailPhone: TextView = view.findViewById(R.id.textPhone)
            val detailCall: TextView = view.findViewById(R.id.textCall)
            val detailLocation: TextView = view.findViewById(R.id.textLocation)
            val detailMail: TextView = view.findViewById(R.id.textMail)
            detailTitle.text = getData.dataStoreTitle
            detailImage.setImageResource(getData.dataStoreImage)
            detailPhone.text = getData.dataPhone
            detailCall.text = getData.dataCall
            detailLocation.text = getData.dataLocation
            detailMail.text = getData.dataMail
        }

        val r_back : ImageView =view.findViewById(R.id.return_back)
        r_back.setOnClickListener{
            val fragment= StoresFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        return view
    }


}