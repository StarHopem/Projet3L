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

class DietsFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_diets, container, false)

        val r_back : ImageView =view.findViewById(R.id.return_back)
        r_back.setOnClickListener{
            val fragment= DiseaseFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout,fragment)?.commit()
        }

        val myAdapter:AdapterClassDiets

        val imageList:Array<Int> = arrayOf(
            R.drawable.diet,
            R.drawable.diet,
            R.drawable.diet,
            R.drawable.diet,
            R.drawable.diet,
            R.drawable.diet,
            R.drawable.diet,
            R.drawable.diet,
            R.drawable.diet,
            R.drawable.diet,
        )
        val titleList:Array<String> = arrayOf(
            getString(R.string.diet_1),
            getString(R.string.diet_2),
            getString(R.string.diet_3),
            getString(R.string.diet_4),
            getString(R.string.diet_5),
            getString(R.string.diet_6),
            getString(R.string.diet_7),
            getString(R.string.diet_8),
            getString(R.string.diet_9),
            getString(R.string.diet_10))
        val descList:Array<String> = arrayOf(
            "aaaaaaaaaaaaaaa",
            "bbbbbbbbbbbbbbb",
            "ccccccccccccccc",
            "ddddddddddddddd",
            "eeeeeeeeeeeeeee",
            "fffffffffffffff",
            "jjjjjjjjjjjjjjj",
            "hhhhhhhhhhhhhhh",
            "kkkkkkkkkkkkkkk",
            "mmmmmmmmmmmmmmm")

        val recyclerView : RecyclerView =view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        val dataList = arrayListOf<DataClassDiets>()

        // getData ____Begin____
        for (i in imageList.indices){
            val dataClassDiets = DataClassDiets(imageList[i], titleList[i], descList[i])
            dataList.add(dataClassDiets)
        }
        recyclerView.adapter = AdapterClassDiets(dataList)
        //____End____

        myAdapter= AdapterClassDiets(dataList)
        recyclerView.adapter=myAdapter

        myAdapter.onItemClick = { item ->
            val fragment = DietsDetailFragment()
            val bundle = Bundle()
            bundle.putParcelable("diets", item)
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()
                ?.replace(R.id.frame_layout, fragment)
                ?.commit()
        }



        return view
    }

}