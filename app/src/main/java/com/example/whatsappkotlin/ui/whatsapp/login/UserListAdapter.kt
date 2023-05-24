package com.example.whatsappkotlin.ui.whatsapp.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.whatsappkotlin.databinding.ItemUserBinding
import com.example.whatsappkotlin.domain.model.User
import com.example.whatsappkotlin.ui.whatsapp.chats.common.BaseListViewHolder

class UserListAdapter(private val onUserClick: (User) -> Unit, ) : ListAdapter<User, BaseListViewHolder<*>>(DiffUtilCallback) {

    private object DiffUtilCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<*> {
        val itemBinding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BindViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseListViewHolder<*>, position: Int) {
        when (holder) {
            is BindViewHolder -> holder.bind(getItem(position), position)
        }
    }

    inner class BindViewHolder(private val binding: ItemUserBinding) : BaseListViewHolder<User>(binding.root) {

        override fun bind(item: User, position: Int) = with(binding) {

            userName.text = item.name
            userImage.setImageResource(item.image)

            userCard.setOnClickListener { onUserClick.invoke(item) }
        }
    }
}
