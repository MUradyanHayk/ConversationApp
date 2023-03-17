package com.example.recyclerapp.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapp.item.CustomItem
import com.example.recyclerapp.item.CustomTextView
import com.example.recyclerapp.item.MainItem
import com.example.recyclerapp.model.MainModel
import com.example.recyclerapp.model.MainModelType
import com.example.recyclerapp.utils.MainViewHolder
import com.example.recyclerapp.utils.dp
import com.example.recyclerapp.utils.setPaddings

class MainAdapter(private val context: Context, private val list: MutableList<MainModel>) : RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val item = if (viewType == MainModelType.CUSTOM.ordinal) {
            CustomItem(context)
        } else if (viewType == MainModelType.CUSTOM_TEXT_VIEW.ordinal) {
            CustomTextView(context)
        } else {
            MainItem(context)
        }
        return MainViewHolder(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item: View
        if (list[position].type == MainModelType.CUSTOM) {
            item = holder.itemView as CustomItem
        } else if (list[position].type == MainModelType.CUSTOM_TEXT_VIEW) {

        } else {
            item = holder.itemView as MainItem
            item.configure(list[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
//        when (list[position].type) {
//            MainModelType.ITEM -> MainModelType.ITEM.ordinal
//            MainModelType.TITLE -> MainModelType.TITLE.ordinal
//            else -> MainModelType.ITEM
//        }
        super.getItemViewType(position)
        return list[position].type.ordinal
    }
}

