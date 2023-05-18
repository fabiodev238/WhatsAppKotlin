package com.example.whatsappkotlin.ui.whatsapp.social

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatsappkotlin.R
import com.example.whatsappkotlin.databinding.FragmentCallsBinding
import com.example.whatsappkotlin.databinding.FragmentSocialBinding


class SocialFragment : Fragment() {

    private var _binding: FragmentSocialBinding? = null
    private val binding: FragmentSocialBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
    _binding= FragmentSocialBinding.inflate(inflater, container, false)

        return binding.root
    }
}