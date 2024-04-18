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
import com.example.spacexappui.adapters.RocketLaunchesAdapter

class LaunchesFragment : Fragment() {

    private val rocketLaunchesAdapter = RocketLaunchesAdapter()
    private lateinit var rocketLaunchesRecyclerView: RecyclerView
    private var rocketLaunches = MockRockets.mockRocketLaunches
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_launches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRocketLaunchesRecyclerView(view)
    }

    private fun initRocketLaunchesRecyclerView(view: View) {
        rocketLaunchesRecyclerView = view.findViewById(R.id.rocketLaunchesRecyclerView)
        rocketLaunchesRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rocketLaunchesRecyclerView.adapter = rocketLaunchesAdapter
        rocketLaunchesAdapter.rockets = rocketLaunches
        rocketLaunchesAdapter.notifyDataSetChanged()
    }
}