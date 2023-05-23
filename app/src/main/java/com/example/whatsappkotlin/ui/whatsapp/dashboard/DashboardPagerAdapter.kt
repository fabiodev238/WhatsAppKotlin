package com.example.whatsappkotlin.ui.whatsapp.dashboard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.whatsappkotlin.ui.whatsapp.calls.CallsFragment
import com.example.whatsappkotlin.ui.whatsapp.chats.ChatsFragment
import com.example.whatsappkotlin.ui.whatsapp.social.SocialFragment

class DashboardPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> { ChatsFragment() }
            1 -> { SocialFragment() }
            2 -> { CallsFragment() }

            else -> throw IllegalArgumentException("Invalid fragment position, max value 2")
        }
    }

}