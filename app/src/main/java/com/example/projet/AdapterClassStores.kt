package com.example.projet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClassStores (private val dataList:ArrayList<DataClassStores>): RecyclerView.Adapter<AdapterClassStores.ViewHolderClass>() {

    var onItemClick: ((DataClassStores) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_stores, parent, false)
        return AdapterClassStores.ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataStoreImage)
        holder.rvTitle.text = currentItem.dataStoreTitle

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }

    class ViewHolderClass (itemView: View):RecyclerView.ViewHolder(itemView){
        val rvImage: ImageView =itemView.findViewById(R.id.image)
        val rvTitle: TextView =itemView.findViewById(R.id.title)
    }
}