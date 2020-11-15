package com.example.testproject

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.testproject.adapter.AdapterViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapterViewPager: AdapterViewPager
    private lateinit var mBottomNavView: BottomNavigationView
    private lateinit var mViewPager: ViewPager

    private lateinit var colorList: ColorStateList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize
        mBottomNavView = findViewById(R.id.mBottomNavigationView)
        mViewPager = findViewById(R.id.ViewPager)
        colorList = ColorStateList(
            arrayOf(
                intArrayOf(-android.R.attr.state_selected),  // Disabled
                intArrayOf(android.R.attr.state_selected)    // Enabled
            ),
            intArrayOf(
                Color.GRAY,     // The color for the Disabled state
                Color.BLACK        // The color for the Enabled state
            )
        )
        mBottomNavView.itemIconTintList = colorList


        // Initialize methods
        listenerBottomNavView(mViewPager)
        prepareViewPager(mViewPager)
        pageChangeListener(mViewPager, mBottomNavView)
    }

    private fun prepareViewPager(mViewPager: ViewPager) {
        mAdapterViewPager = AdapterViewPager(supportFragmentManager)

        mViewPager.adapter = mAdapterViewPager
        mViewPager.offscreenPageLimit = 5
        mViewPager.currentItem = 0
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