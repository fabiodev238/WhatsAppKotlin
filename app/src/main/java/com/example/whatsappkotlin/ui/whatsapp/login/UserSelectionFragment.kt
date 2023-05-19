package com.example.whatsappkotlin.ui.whatsapp.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.whatsappkotlin.R
import com.example.whatsappkotlin.databinding.FragmentChatsBinding
import com.example.whatsappkotlin.databinding.FragmentUserSelectionBinding


class UserSelectionFragment : Fragment() {

    private var _binding: FragmentUserSelectionBinding? = null
    private val binding: FragmentUserSelectionBinding
        get() = _binding!!

    private val userListAdapter = UserListAdapter {
        Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=  FragmentUserSelectionBinding.inflate(inflater, container, false)

        return binding.root
    }


}