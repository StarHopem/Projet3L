package com.example.projet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClassDocAccount(private val dataList:ArrayList<DataClassDocAccount>):RecyclerView.Adapter<AdapterClassDocAccount.ViewHolderClass>() {
    var onItemClick: ((DataClassDocAccount) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_doc_account, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataTitle
        holder.rvTitle2.text = currentItem.dataTitle2

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }

    class ViewHolderClass(itemView:View):RecyclerView.ViewHolder(itemView) {
        val rvImage:ImageView=itemView.findViewById(R.id.image)
        val rvTitle:TextView=itemView.findViewById(R.id.title)
        val rvTitle2:TextView=itemView.findViewById(R.id.title2)
    }
}