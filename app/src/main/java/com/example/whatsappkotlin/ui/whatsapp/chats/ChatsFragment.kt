package com.example.whatsappkotlin.ui.whatsapp.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatsappkotlin.R
import com.example.whatsappkotlin.databinding.FragmentChatsBinding
import com.example.whatsappkotlin.databinding.FragmentSocialBinding


class ChatsFragment : Fragment() {

    private var _binding: FragmentChatsBinding? = null
            private val binding: FragmentChatsBinding
            get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentChatsBinding.inflate(inflater, container, false)

        return binding.root
    }

}