package com.example.recyclerapp.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapp.item.MainItem
import com.example.recyclerapp.model.MainModel
import com.example.recyclerapp.model.MainModelType
import com.example.recyclerapp.utils.MainViewHolder

class MainAdapter(private val context: Context, private val list: MutableList<MainModel>) : RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val item = if (viewType == MainModelType.ITEM.ordinal) {
            MainItem(context)
        } else {
            MainItem(context)
        }
        return MainViewHolder(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = if (list[position].type == MainModelType.ITEM) {
            holder.itemView as MainItem
        } else {
            holder.itemView as MainItem
        }

        item.configure(list[position])

    }

    override fun getItemViewType(position: Int): Int {
        when (list[position].type) {
            MainModelType.ITEM -> MainModelType.ITEM.ordinal
            MainModelType.TITLE -> MainModelType.TITLE.ordinal
            else -> MainModelType.ITEM
        }
        return super.getItemViewType(position)
    }
}

