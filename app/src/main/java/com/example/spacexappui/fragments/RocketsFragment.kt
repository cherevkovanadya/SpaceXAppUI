package com.example.spacexappui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexappui.data.MockRockets
import com.example.spacexappui.R
import com.example.spacexappui.adapters.RocketsAdapter

class RocketsFragment : Fragment() {
    private val rocketsAdapter = RocketsAdapter()
    private lateinit var rocketsRecyclerView: RecyclerView
    private var rockets = MockRockets.mockRockets
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rockets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRocketsRecyclerView(view)
    }

    private fun initRocketsRecyclerView(view: View) {
        rocketsRecyclerView = view.findViewById(R.id.rocketsRecyclerView)
        rocketsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rocketsRecyclerView.adapter = rocketsAdapter
        rocketsAdapter.rockets = rockets
        rocketsAdapter.notifyDataSetChanged()
    }
}