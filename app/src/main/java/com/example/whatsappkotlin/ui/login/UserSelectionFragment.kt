package com.example.whatsappkotlin.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.whatsappkotlin.data.local.UserHelper
import com.example.whatsappkotlin.databinding.FragmentUserSelectionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserSelectionFragment : Fragment() {

    private var _binding: FragmentUserSelectionBinding? = null
    private val binding: FragmentUserSelectionBinding
        get() = _binding!!

    private val viewModel: UserSelectionViewModel by viewModels()

    private val userListAdapter = UserListAdapter {
        viewModel.saveUserSelection(useId = it.id)
        val action =
            UserSelectionFragmentDirections.actionUserSelectionFragmentToDashboardFragment(userId = it.id)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserSelectionBinding.inflate(inflater, container, false)

        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.userList.apply {
            adapter = userListAdapter
            layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        }
        userListAdapter.submitList(UserHelper.userslist)
    }
//26
}