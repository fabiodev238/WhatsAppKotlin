package com.example.whatsappkotlin.ui.whatsapp.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.whatsappkotlin.R
import com.example.whatsappkotlin.data.local.UserHelper
import com.example.whatsappkotlin.databinding.FragmentChatsBinding
import com.example.whatsappkotlin.databinding.FragmentSocialBinding
import com.example.whatsappkotlin.domain.ext.gone
import com.example.whatsappkotlin.domain.ext.show


class ChatsFragment : Fragment() {

    private var _binding: FragmentChatsBinding? = null
            private val binding: FragmentChatsBinding
            get() = _binding!!

    private val chatListAdapter = ChatListAdapter{

        Toast.makeText(requireContext(), it.userName, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentChatsBinding.inflate(inflater, container, false)

        setupRecyclerView()
        handleChatList()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.chatList.apply {

            adapter = chatListAdapter
        }
    }

    private fun handleChatList() {
        val chatList = UserHelper.chatList

        if(chatList.isEmpty()){
            binding.chatList.gone()
            binding.emptyMessage.show()
        }else{
            binding.emptyMessage.gone()
            binding.chatList.show()

            chatListAdapter.submitList(chatList)
        }
    }
}