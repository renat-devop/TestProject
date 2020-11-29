package com.example.testproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.example.testproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainViewModel(private val mBottomNavView: BottomNavigationView, mViewPager: ViewPager): ViewModel() {


    init {
        listenerBottomNavView(mViewPager = mViewPager)
        pageChangeListener(mViewPager = mViewPager, mBottomNavView = mBottomNavView)
    }

    private fun listenerBottomNavView(mViewPager: ViewPager) {
        mBottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.search -> mViewPager.currentItem = 0
                R.id.menu -> mViewPager.currentItem = 1
                R.id.map -> mViewPager.currentItem = 2
                R.id.favorite -> mViewPager.currentItem = 3
                R.id.settings -> mViewPager.currentItem = 4
            }
            true
        }
    }

    private fun pageChangeListener(mViewPager: ViewPager, mBottomNavView: BottomNavigationView) {
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        mBottomNavView.selectedItemId = R.id.search
                    }
                    1 -> {
                        mBottomNavView.selectedItemId = R.id.menu
                    }
                    2 -> {
                        mBottomNavView.selectedItemId = R.id.map
                    }
                    3 -> {
                        mBottomNavView.selectedItemId = R.id.favorite
                    }
                    4 -> {
                        mBottomNavView.selectedItemId = R.id.settings
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }
}