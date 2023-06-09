package com.example.whatsappkotlin.ui.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.whatsappkotlin.data.local.UserHelper
import com.example.whatsappkotlin.databinding.FragmentChatsBinding
import com.example.whatsappkotlin.domain.ext.gone
import com.example.whatsappkotlin.domain.ext.show
import com.example.whatsappkotlin.ui.dashboard.DashBoardFragmentArgs
import com.example.whatsappkotlin.ui.dashboard.DashBoardFragmentDirections


class ChatsFragment() : Fragment() {

    private var _binding: FragmentChatsBinding? = null
    private val binding: FragmentChatsBinding
        get() = _binding!!



private val chatListAdapter by lazy {

    ChatListAdapter {
        val action =  com.example.whatsappkotlin.ui.dashboard.DashBoardFragmentDirections.actionDashboardFragmentToChatFragment(
            chatId = it.id,
            userId = arguments?.getString("userId") ?: throw Exception("Invalid user id"),
            userToTextId = it.userTwoId
        )
        findNavController().navigate(action)
    }
}






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatsBinding.inflate(inflater, container, false)

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
        val chatList = when(arguments?.getString("userId")?: throw Exception("Invalid user id")) {
            "1" -> UserHelper.cristianoChatList
            "2" -> UserHelper.messiChatList
            "3" -> UserHelper.lewandowskiChatList
            "4" -> UserHelper.neymarChatList
            else -> throw Exception("Invalid user id")
        }

        if (chatList.isEmpty()) {
            binding.chatList.gone()
            binding.emptyMessage.show()
        } else {
            binding.emptyMessage.gone()
            binding.chatList.show()

           chatListAdapter.submitList(chatList)
        }
    }
}