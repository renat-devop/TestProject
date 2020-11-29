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
import com.example.testproject.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mAdapterViewPager = AdapterViewPager(supportFragmentManager)

    private lateinit var mMainViewModel: MainViewModel
    private lateinit var mBottomNavView: BottomNavigationView
    private lateinit var mViewPager: ViewPager

    private lateinit var colorList: ColorStateList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize
        mBottomNavView = findViewById(R.id.mBottomNavigationView)
        mViewPager = findViewById(R.id.ViewPager)
        mMainViewModel = MainViewModel(mBottomNavView, mViewPager)

        // Initialize methods
        prepareViewPager(mViewPager)
        prepareBottomNavView(mBottomNavView)
    }

    private fun prepareBottomNavView(mBottomNavView: BottomNavigationView) {
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
    }

    private fun prepareViewPager(mViewPager: ViewPager) {
        mViewPager.adapter = mAdapterViewPager
        mViewPager.offscreenPageLimit = 5
        mViewPager.currentItem = 0
    }
}