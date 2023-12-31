package com.example.whatsappkotlin.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.whatsappkotlin.databinding.ItemIncomingMessageBinding
import com.example.whatsappkotlin.databinding.ItemOutgoingMessageBinding
import com.example.whatsappkotlin.domain.model.Message
import com.example.whatsappkotlin.ui.chats.common.BaseListViewHolder
import java.text.SimpleDateFormat
import java.util.*

const val INCOMING_MESSAGE = 0
const val OUTGOING_MESSAGE = 1

class MessageListAdapter(
private val currentUserId: String
): ListAdapter<Message, BaseListViewHolder<*>>(DiffUtilCallback)  {

    private object DiffUtilCallback : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<*> {
        return when(viewType) {
            INCOMING_MESSAGE -> {
                val itemBinding = ItemIncomingMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BindIncomingMessage(itemBinding)
            }
            OUTGOING_MESSAGE -> {
                val itemBinding = ItemOutgoingMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BindOutgoingMessage(itemBinding)
            }
            else -> {
                val itemBinding = ItemIncomingMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BindIncomingMessage(itemBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseListViewHolder<*>, position: Int) {
        when (holder) {
            is BindIncomingMessage -> holder.bind(getItem(position), position)
            is BindOutgoingMessage -> holder.bind(getItem(position), position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).senderId == currentUserId) OUTGOING_MESSAGE else INCOMING_MESSAGE
    }

    inner class BindIncomingMessage(private val binding: ItemIncomingMessageBinding) : BaseListViewHolder<Message>(binding.root) {

        override fun bind(item: Message, position: Int) = with(binding) {

            val sfd = SimpleDateFormat("HH:mm a", Locale.getDefault())
            val date = sfd.format(item.timestamp.toDate())

            tvMessage.text = item.message
            tvDate.text = date
        }
    }

    inner class BindOutgoingMessage(private val binding: ItemOutgoingMessageBinding) : BaseListViewHolder<Message>(binding.root) {

        override fun bind(item: Message, position: Int) = with(binding) {

            val sfd = SimpleDateFormat("HH:mm a", Locale.getDefault())
            val date = sfd.format(item.timestamp.toDate())

            tvMessage.text = item.message
            tvDate.text = date
        }
    }
}