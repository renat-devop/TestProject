package com.example.testproject.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.testproject.fragment.*

class AdapterViewPager(fm : FragmentManager?): FragmentPagerAdapter(fm!!) {
    override fun getCount(): Int = 5

    override fun getItem(position: Int): Fragment {

        return when(position){
            0 -> SearchFragment()
            1 -> ListFragment()
            2 -> MapFragment()
            3 -> FavFragment()
            4 -> SettingsFragment()

            else -> SearchFragment()
        }
    }
}