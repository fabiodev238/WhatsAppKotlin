package com.example.whatsappkotlin.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.whatsappkotlin.R
import com.example.whatsappkotlin.databinding.FragmentDashBoardBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashBoardFragment : Fragment() {

    private var _binding: FragmentDashBoardBinding? = null
    private val binding: FragmentDashBoardBinding
        get() = _binding!!

   // private val dashboardPagerAdapter = DashboardPagerAdapter

    private val args: DashBoardFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashBoardBinding.inflate(inflater, container, false)

        setupViewPager()

        return binding.root
    }

    private fun setupViewPager() {
        binding.dashboardViewPager.apply {
            adapter = DashboardPagerAdapter(this@DashBoardFragment, userId = args.userId)
        }
        TabLayoutMediator(binding.dashboardTabLayout, binding.dashboardViewPager) { tab, position ->
            tab.text = when (position) {

                0 -> getString(R.string.chats)
                1 -> getString(R.string.social)
                2 -> getString(R.string.calls)
                else -> throw Exception("Invalid position")
            }
        }.attach()
    }

}