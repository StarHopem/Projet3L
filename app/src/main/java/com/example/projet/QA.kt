package com.example.projet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.SearchView.SearchAutoComplete
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class QA : Fragment() {

        private val mList = ArrayList<LanguageData>()

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val view = inflater.inflate(R.layout.fragment_q_a, container, false)

            val r_back : ImageView =view.findViewById(R.id.return_back)
            r_back.setOnClickListener{
                val fragment= Profile()
                val transaction=fragmentManager?.beginTransaction()
                transaction?.replace(R.id.frame_layout,fragment)?.commit()
            }

            val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            addDataToList()
            val adapter :LanguageAdapter= LanguageAdapter(mList)
            recyclerView.adapter = adapter

            return view
        }

        private fun addDataToList() {
            mList.add(
                LanguageData(
                    getString(R.string.question1),
                    R.drawable.diet,
                    getString(R.string.answer1)))

            mList.add(
                LanguageData(
                    getString(R.string.question1),
                    R.drawable.kidney,
                    getString(R.string.answer1))
            )
            mList.add(
                LanguageData(
                    getString(R.string.question1),
                    R.drawable.doctor,
                    getString(R.string.answer1))
            )
            mList.add(
                LanguageData(
                    getString(R.string.question1),
                    R.drawable.diet,
                    getString(R.string.answer1))
            )
            mList.add(
                LanguageData(
                    getString(R.string.question1),
                    R.drawable.kidney,
                    getString(R.string.answer1))
            )
            mList.add(
                LanguageData(
                    getString(R.string.question1),
                    R.drawable.doctor,
                    getString(R.string.answer1))
            )
            mList.add(
                LanguageData(
                    getString(R.string.question1),
                    R.drawable.python,
                    getString(R.string.answer1))
            )
            mList.add(
                LanguageData(
                    getString(R.string.question1),
                    R.drawable.doctor,
                    getString(R.string.answer1))
            )
            mList.add(
                LanguageData(
                    getString(R.string.question1),
                    R.drawable.doctor,
                    getString(R.string.answer1))
            )
        }


}