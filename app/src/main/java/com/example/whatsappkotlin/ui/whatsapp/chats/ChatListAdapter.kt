package com.example.whatsappkotlin.ui.whatsapp.chats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.whatsappkotlin.databinding.ItemChatBinding

import com.example.whatsappkotlin.domain.model.Chat

import com.example.whatsappkotlin.ui.whatsapp.chats.common.BaseListViewHolder

class ChatListAdapter(private val onChatClick: (Chat) -> Unit, ) : ListAdapter<Chat, BaseListViewHolder<*>>(DiffUtilCallback) {

        private object DiffUtilCallback : DiffUtil.ItemCallback<Chat>() {
            override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean = oldItem == newItem
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<*> {
            val itemBinding =
                ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return BindViewHolder(itemBinding)
        }

     override fun onBindViewHolder(holder: BaseListViewHolder<*>, position: Int) {
         when (holder){
             is BindViewHolder -> holder.bind(getItem(position),position)
         }

     }

    inner class BindViewHolder(private val binding: ItemChatBinding) :
        BaseListViewHolder<Chat>(binding.root) {

        override fun bind(item: Chat, position: Int) = with(binding) {
            chatName.text = item.userName
            chatImage.setImageResource(item.userImage)


            chatParent.setOnClickListener { onChatClick.invoke(item) }
        }
    }




}
