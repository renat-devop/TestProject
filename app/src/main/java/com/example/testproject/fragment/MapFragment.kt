package com.example.testproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.testproject.R

class MapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize view
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        val textView = view.findViewById<TextView>(R.id.tv_map)
        textView.text = "MapFragment"
        // Return view
        return view
    }
}