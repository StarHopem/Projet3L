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

class StoresFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_stores, container, false)

        val myAdapter:AdapterClassStores

        val imageList:Array<Int> = arrayOf(
            R.drawable.store,
            R.drawable.store,
            R.drawable.store,
            R.drawable.store,
            R.drawable.store,
            R.drawable.store,
            R.drawable.store,
            R.drawable.store,
            R.drawable.store,
            R.drawable.store,)
        val titleList:Array<String> = arrayOf(
            getString(R.string.store1),
            getString(R.string.store2),
            getString(R.string.store3),
            getString(R.string.store4),
            getString(R.string.store5),
            getString(R.string.store6),
            getString(R.string.store7),
            getString(R.string.store8),
            getString(R.string.store9),
            getString(R.string.store10))
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
            getString(R.string.location10))
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
            "store1@gmail.com",
            "store2@gmail.com",
            "store3@gmail.com",
            "store4@gmail.com",
            "store5@gmail.com",
            "store6@gmail.com",
            "store7@gmail.com",
            "store8@gmail.com",
            "store9@gmail.com",
            "store10@gmail.com",)


        val recyclerView : RecyclerView =view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        val dataList = arrayListOf<DataClassStores>()

        // getData ____Begin____
        for (i in imageList.indices){
            val dataClass = DataClassStores(imageList[i], titleList[i],
                dataPhoneList[i],dataCallList[i], dataLocationList [i], dataMailList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClassStores(dataList)
        //____End____

        myAdapter= AdapterClassStores(dataList)
        recyclerView.adapter=myAdapter

        myAdapter.onItemClick = { item ->
            val fragment = Stores_DetailFragment()
            val bundle = Bundle()
            bundle.putParcelable("stores", item)
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