package com.example.projet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class Doctors_AccountFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_doctors__account, container, false)

        val myAdapter:AdapterClassDocAccount

        val imageList:Array<Int> = arrayOf(
            R.drawable.doctor,
            R.drawable.doctor,
            R.drawable.doctor,
            R.drawable.doctor,
            R.drawable.doctor,
            R.drawable.doctor,
            R.drawable.doctor,
            R.drawable.doctor,
            R.drawable.doctor,
            R.drawable.doctor)

        val titleList:Array<String> = arrayOf(
            getString(R.string.ghardaia),
            getString(R.string.ouargla),
            getString(R.string.oran),
            getString(R.string.Bejaia),
            getString(R.string.Blida),
            getString(R.string.Tamanrasset),
            getString(R.string.Setif ),
            getString(R.string.Tlemcen),
            getString(R.string.Skikda),
            getString(R.string.Biskra)
        )
        val titleList2:Array<String> = arrayOf(
            "Dr.SALEM zineb",
            "Dr.MARIA beyoud",
            "Dr.ABDERHMAN saoud",
            "Dr.Ali",
            "Dr.Omar",
            "Dr.Ibrahim",
            "Dr.Ahlam",
            "Dr.Yahia",
            "Dr.Malek",
            "Dr.Hoda")
        val dataLocationList:Array<String> = arrayOf(
            getString(R.string.location1),
            getString(R.string.location2),
            getString(R.string.location3),
            getString(R.string.location4),
            getString(R.string.location5),
            getString(R.string.location6),
            getString(R.string.location7),
            getString(R.string.location8),
            getString(R.string.location9),
            getString(R.string.location10)
        )
        val dataPhoneList:Array<String> = arrayOf(
            "213+111111111",
            "213+222222222",
            "213+033333333",
            "213+444444444",
            "213+555555555",
            "213+666666666",
            "213+777777777",
            "213+888888888",
            "213+999999999",
            "213+010101010",)
        val dataCallList:Array<String> = arrayOf(
            "0111111111",
            "0222222222",
            "0333333333",
            "0444444444",
            "0555555555",
            "0666666666",
            "0777777777",
            "0888888888",
            "0999999999",
            "0101010101")
        val dataMailList:Array<String> = arrayOf(
            "salemzineb28@gmail.com",
            "mariabeyoud28@gmail.com",
            "saoudAbd28@gmail.com",
            "ali28@gmail.com",
            "omar28@gmail.com",
            "ibrahim28@gmail.com",
            "ahlam28@gmail.com",
            "yahia28@gmail.com",
            "malek28@gmail.com",
            "houda28@gmail.com",)

        val recyclerView :RecyclerView=view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        val dataList = arrayListOf<DataClassDocAccount>()

        // getData ____Begin____
        for (i in imageList.indices){
            val dataClassDocAccount = DataClassDocAccount(imageList[i], titleList[i], titleList2[i],
                dataPhoneList[i],dataCallList[i], dataLocationList [i], dataMailList[i] )
            dataList.add(dataClassDocAccount)
        }
        recyclerView.adapter = AdapterClassDocAccount(dataList)
        //____End____

        myAdapter= AdapterClassDocAccount(dataList)
        recyclerView.adapter=myAdapter

        myAdapter.onItemClick = { item ->
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putParcelable("account", item)
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()
                ?.replace(R.id.frame_layout, fragment)
                ?.commit()
        }

        val r_back : ImageView =view.findViewById(R.id.return_back)
        r_back.setOnClickListener{
            val fragment= Home()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        return view
}

}