package com.example.projet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView

class FavoritesFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_favorites, container, false)

        val favorites_diets : CardView =view.findViewById(R.id.favorites_diets)
        val favorites_docs : CardView =view.findViewById(R.id.favorites_docs)
        val favorites_stores: CardView =view.findViewById(R.id.favorites_stores)

        favorites_diets.setOnClickListener{
           Toast.makeText(context,getString(R.string.coming),Toast.LENGTH_SHORT).show()
        }

        favorites_docs.setOnClickListener{
            Toast.makeText(context,getString(R.string.coming),Toast.LENGTH_SHORT).show()
        }

        favorites_stores.setOnClickListener{
            Toast.makeText(context,getString(R.string.coming),Toast.LENGTH_SHORT).show()
        }



        return view
    }

}