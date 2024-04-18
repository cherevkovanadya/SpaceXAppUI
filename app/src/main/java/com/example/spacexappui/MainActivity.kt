package com.example.spacexappui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacexappui.MockRockets.mockRocketLaunches
import com.example.spacexappui.MockRockets.mockRockets
import com.example.spacexappui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val rocketLaunchesAdapter = RocketLaunchesAdapter()
    private val rocketsAdapter = RocketsAdapter()

    private var rocketLaunches = mockRocketLaunches
    private var rockets = mockRockets

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRocketLaunchesRecyclerView()
        initRocketsRecyclerView()

        binding.upcomingTextView.setOnClickListener {
            binding.launchCardView.isVisible = true
            binding.upcomingDetails.isVisible = true
            binding.rocketLaunchesRecyclerView.isVisible = false
            binding.rocketsRecyclerView.isVisible = false
            binding.launchesTextView.setTextColor(getColor(R.color.black))
            binding.upcomingTextView.setTextColor(getColor(R.color.pink))
            binding.rocketsTextView.setTextColor(getColor(R.color.black))
        }

        binding.launchesTextView.setOnClickListener {
            binding.launchCardView.isVisible = false
            binding.upcomingDetails.isVisible = false
            binding.rocketLaunchesRecyclerView.isVisible = true
            binding.rocketsRecyclerView.isVisible = false
            binding.upcomingTextView.setTextColor(getColor(R.color.black))
            binding.launchesTextView.setTextColor(getColor(R.color.pink))
            binding.rocketsTextView.setTextColor(getColor(R.color.black))
        }

        binding.rocketsTextView.setOnClickListener {
            binding.launchCardView.isVisible = false
            binding.upcomingDetails.isVisible = false
            binding.rocketLaunchesRecyclerView.isVisible = false
            binding.rocketsRecyclerView.isVisible = true
            binding.upcomingTextView.setTextColor(getColor(R.color.black))
            binding.launchesTextView.setTextColor(getColor(R.color.black))
            binding.rocketsTextView.setTextColor(getColor(R.color.pink))
        }
    }

    private fun initRocketLaunchesRecyclerView(){
        binding.rocketLaunchesRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rocketLaunchesRecyclerView.adapter = rocketLaunchesAdapter
        rocketLaunchesAdapter.rockets = rocketLaunches
        rocketLaunchesAdapter.notifyDataSetChanged()
    }

    private fun initRocketsRecyclerView(){
        binding.rocketsRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rocketsRecyclerView.adapter = rocketsAdapter
        rocketsAdapter.rockets = rockets
        rocketsAdapter.notifyDataSetChanged()
    }
}