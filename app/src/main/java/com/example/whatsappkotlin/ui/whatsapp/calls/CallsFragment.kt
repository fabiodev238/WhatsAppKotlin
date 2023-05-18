package com.example.whatsappkotlin.ui.whatsapp.calls

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatsappkotlin.R
import com.example.whatsappkotlin.databinding.FragmentCallsBinding
import com.example.whatsappkotlin.databinding.FragmentChatsBinding
import com.example.whatsappkotlin.databinding.FragmentSocialBinding


class CallsFragment : Fragment() {

    private var _binding: FragmentCallsBinding? = null
    private val binding: FragmentCallsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding= FragmentCallsBinding.inflate(inflater, container, false)

        return binding.root
    }


}