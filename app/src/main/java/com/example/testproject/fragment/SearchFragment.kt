package com.example.testproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.adapter.RecViewAdapter
import com.example.testproject.data.TestData

class SearchFragment : Fragment() {

    private lateinit var recView: RecyclerView
    private lateinit var list: List<TestData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Initialize view
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        list = arrayListOf(
            TestData("Шартаж"),
            TestData("Клубничка"),
            TestData("Суши бар YumTime"),
            TestData("Шартаж"),
            TestData("Клубничка"),
            TestData("Суши бар YumTime"),
            TestData("Шартаж"),
            TestData("Клубничка"),
            TestData("Суши бар YumTime"),
            TestData("Шартаж"),
            TestData("Клубничка"),
            TestData("Суши бар YumTime"),
            TestData("Шартаж"),
            TestData("Клубничка"),
            TestData("Суши бар YumTime")
        )

        recView = view.findViewById(R.id.rec_view)
        recView.adapter = RecViewAdapter(list = list)

        // Return view
        return view
    }
}