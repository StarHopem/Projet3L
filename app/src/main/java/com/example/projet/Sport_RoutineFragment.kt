package com.example.projet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Sport_RoutineFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_sport__routine, container, false)

        val myAdapter:AdapterClassSport

        val imageList:Array<Int> = arrayOf(
            R.drawable.sport,
            R.drawable.sport,
            R.drawable.sport,
            R.drawable.sport,
            R.drawable.sport,
            R.drawable.sport,
            R.drawable.sport,
            R.drawable.sport,
            R.drawable.sport,
            R.drawable.sport,)
        val titleList:Array<String> = arrayOf(
            getString(R.string.sport1),
            getString(R.string.sport2),
            getString(R.string.sport3),
            getString(R.string.sport4),
            getString(R.string.sport5),
            getString(R.string.sport6),
            getString(R.string.sport7),
            getString(R.string.sport8),
            getString(R.string.sport9),
            getString(R.string.sport10))

        val recyclerView : RecyclerView =view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        val dataList = arrayListOf<DataClassSport>()

        // getData ____Begin____
        for (i in imageList.indices){
            val dataClass = DataClassSport(imageList[i], titleList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClassSport(dataList)
        //____End____

        myAdapter= AdapterClassSport(dataList)
        recyclerView.adapter=myAdapter

        myAdapter.onItemClick = { item ->
            Toast.makeText(context,getString(R.string.coming), Toast.LENGTH_SHORT).show()
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