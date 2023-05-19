package com.example.whatsappkotlin.ui.whatsapp.chats.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T, position: Int)
}